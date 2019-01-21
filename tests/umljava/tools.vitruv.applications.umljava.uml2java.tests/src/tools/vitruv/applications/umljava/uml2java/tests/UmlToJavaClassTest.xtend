package tools.vitruv.applications.umljava.uml2java.tests

import org.apache.log4j.Logger
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.Model
import org.eclipse.uml2.uml.VisibilityKind
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestName
import tools.vitruv.applications.umljava.uml2java.Uml2JavaTransformationTest
import tools.vitruv.applications.util.temporary.java.JavaVisibility

import static org.junit.Assert.*
import static tools.vitruv.applications.umljava.testutil.JavaTestUtil.*
import static tools.vitruv.applications.umljava.testutil.TestUtil.*
import static tools.vitruv.applications.util.temporary.java.JavaTypeUtil.getClassifierFromTypeReference
import static tools.vitruv.applications.util.temporary.uml.UmlClassifierAndPackageUtil.*
import java.util.List
import org.eclipse.emf.compare.Diff
import org.eclipse.emf.compare.merge.IMerger
import org.eclipse.emf.compare.merge.IBatchMerger
import org.eclipse.emf.compare.merge.BatchMerger
import org.eclipse.emf.common.util.BasicMonitor
import tools.vitruv.framework.change.description.TransactionalChange
import tools.vitruv.framework.uuid.UuidGeneratorAndResolver
import tools.vitruv.framework.uuid.UuidGeneratorAndResolverImpl
import tools.vitruv.framework.util.ResourceSetUtil
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl

/**
 * This class provides tests for basic class tests in the uml to java direction
 * @author Fei
 */
class UmlToJavaClassTest extends Uml2JavaTransformationTest {
	private static val CLASS_NAME = "ClassName";
	private static val DATATYPE_NAME = "DataTypeName";
	private static val STANDARD_CLASS_NAME = "StandardClassName"
	private static val CLASS_RENAME = "ClassRenamed"
	private static val SUPER_CLASS_NAME = "SuperClassName"
	private static val INTERFACE_NAME = "InterfaceName";
	private static val INTERFACE_NAME2 = "InterfaceName2";

	private var Class uClass;

	private var Model rootCheckpoint;
	private static final Logger log = Logger.getLogger(typeof(UmlToJavaClassTest));

	@Rule public TestName name = new TestName();

	@Before
	def void before() {
		uClass = createUmlClassAndAddToPackage(rootElement, CLASS_NAME, VisibilityKind.PUBLIC_LITERAL, false, false)
		saveAndSynchronizeChanges(rootElement)
		rootCheckpoint = EcoreUtil.copy(rootElement); // create checkpoint
	}

	@After
	def void after() {
		testDeltaBasedDiff(getLocalUuidGeneratorAndResolver()) // evaluate delta from root and checkpoint	
		if (uClass !== null) {
			uClass.destroy;
		}
	}

	def testDeltaBasedDiff(UuidGeneratorAndResolver generatorAndResolver) {
		log.error(" --- " + name.methodName + ": --- ")
		// Create state based EMF compare diffs:
		val List<Diff> diffs = EMFCompareUtil.compare(rootElement, rootCheckpoint)
		// Create change recorder and record checkpoint:
		val resourceSet = new ResourceSetImpl();
		ResourceSetUtil.addExistingFactoriesToResourceSet(resourceSet);
		val uuidGeneratorAndResolver = new UuidGeneratorAndResolverImpl(virtualModel.getUuidGeneratorAndResolver(), resourceSet, true);
		//val AtomicEmfChangeRecorder changeRecorder = new AtomicEmfChangeRecorder(generatorAndResolver)
		val AtomicEmfChangeRecorder changeRecorder = new AtomicEmfChangeRecorder(uuidGeneratorAndResolver)
		changeRecorder.addToRecording(rootCheckpoint)
		changeRecorder.beginRecording()
		// replay the EMF compare diffs on checkpoint
		
		val IMerger.Registry mergerRegistry = IMerger.RegistryImpl.createStandaloneInstance()
		val IBatchMerger merger = new BatchMerger(mergerRegistry)
		merger.copyAllLeftToRight(diffs, new BasicMonitor())
		//merger.copyAllRightToLeft(diffs, new BasicMonitor());
		val int diffsAfterMerge = EMFCompareUtil.compare(rootElement, rootCheckpoint).size
		log.error('''After merge still «diffsAfterMerge» diffs!''')
		// end recording, access changes:
		changeRecorder.endRecording()
		val List<TransactionalChange> vitruvDiffs = changeRecorder.changes
		log.error(vitruvDiffs.size + " Vitruv changes:")
		for (diff : vitruvDiffs) {
			log.error(" - " + diff)
		}
	}

	@Test
	def testCreateClass() {
	    val c = createUmlClassAndAddToPackage(rootElement, STANDARD_CLASS_NAME, VisibilityKind.PUBLIC_LITERAL, false, false)
	    saveAndSynchronizeChanges(rootElement) 
	    
	    val jClass = getCorrespondingClass(c)
	    assertEquals(STANDARD_CLASS_NAME, jClass.name)
		assertJavaFileExists(STANDARD_CLASS_NAME, #[]);
	}
	
	@Test
	def testDeletedClass() {
        uClass.destroy;
        saveAndSynchronizeChanges(rootElement);
        
        assertJavaFileNotExists(CLASS_NAME, #[]);
	}
	
	@Test
	def testChangeClassVisibility() {
		uClass.visibility = VisibilityKind.PRIVATE_LITERAL;
		saveAndSynchronizeChanges(uClass);

		val jClass = getCorrespondingClass(uClass)
		assertJavaModifiableHasVisibility(jClass, JavaVisibility.PRIVATE)
		assertClassEquals(uClass, jClass)

	}

	@Test
	def testChangeClassVisibility2() {
		uClass.visibility = VisibilityKind.PACKAGE_LITERAL;
		saveAndSynchronizeChanges(uClass);

		val jClass = getCorrespondingClass(uClass)
		assertJavaModifiableHasVisibility(jClass, JavaVisibility.PACKAGE)
		assertClassEquals(uClass, jClass)
	}

	@Test
	def testChangeAbstractClass() {
		uClass.isAbstract = true;
		saveAndSynchronizeChanges(uClass);

		val jClass = getCorrespondingClass(uClass)
		assertJavaModifiableAbstract(jClass, true)
		assertClassEquals(uClass, jClass)
	}

	@Test
	def testRenameClass() {
		uClass.name = CLASS_RENAME;
		saveAndSynchronizeChanges(uClass);

		val jClass = getCorrespondingClass(uClass)
		assertEquals(CLASS_RENAME, jClass.name)
		assertJavaFileExists(CLASS_RENAME, #[]);
		assertJavaFileNotExists(CLASS_NAME, #[]);
		assertClassEquals(uClass, jClass)
	}

	@Test
	def testChangeFinalClass() {
		uClass.isFinalSpecialization = true;
		saveAndSynchronizeChanges(uClass);

		val jClass = getCorrespondingClass(uClass)
		assertJavaModifiableFinal(jClass, true)
		assertClassEquals(uClass, jClass)
	}

	@Test
	def testSuperClassChanged() {
		val superClass = createSimpleUmlClass(rootElement, SUPER_CLASS_NAME);
		uClass.generals += superClass;
		saveAndSynchronizeChanges(uClass);
		val jClass = getCorrespondingClass(uClass)
		val jSuperClass = getCorrespondingClass(superClass)
		assertHasSuperClass(jClass, jSuperClass);
		assertClassEquals(uClass, jClass)
	}

	@Test
	def testDeleteClassImplement() {
		val uI = createSimpleUmlInterface(rootElement, INTERFACE_NAME);
		val uI2 = createSimpleUmlInterface(rootElement, INTERFACE_NAME2);
		uClass.createInterfaceRealization("InterfacRealization", uI);
		uClass.createInterfaceRealization("InterfacRealization2", uI2);
		saveAndSynchronizeChanges(uClass);

		uClass.interfaceRealizations.remove(0);
		saveAndSynchronizeChanges(uClass);

		val jClass = getCorrespondingClass(uClass)
		assertTrue(jClass.implements.size.toString, jClass.implements.size == 1);
		assertEquals(INTERFACE_NAME2, getClassifierFromTypeReference(jClass.implements.get(0)).name)
		assertJavaFileExists(INTERFACE_NAME, #[]);
		assertClassEquals(uClass, jClass)
	}

	@Test
	def testAddClassImplement() {
		val uI = createSimpleUmlInterface(rootElement, INTERFACE_NAME)
		uClass.createInterfaceRealization("InterfacRealization", uI)
		saveAndSynchronizeChanges(uClass)

		val jClass = getCorrespondingClass(uClass)
		assertEquals(INTERFACE_NAME, getClassifierFromTypeReference(jClass.implements.head).name);
		assertClassEquals(uClass, jClass)
	}

	@Test
	def testChangeInterfaceImplementer() {
		val uClass2 = createSimpleUmlClass(rootElement, STANDARD_CLASS_NAME)
		val uI = createSimpleUmlInterface(rootElement, INTERFACE_NAME);
		val realization = uClass.createInterfaceRealization("InterfacRealization", uI);
		saveAndSynchronizeChanges(rootElement);

		var jClass = getCorrespondingClass(uClass)
		var jClass2 = getCorrespondingClass(uClass2)
		assertEquals(INTERFACE_NAME, getClassifierFromTypeReference(jClass.implements.head).name);
		assertTrue(jClass2.implements.nullOrEmpty)

		realization.implementingClassifier = uClass2
		saveAndSynchronizeChanges(rootElement);

		jClass = getCorrespondingClass(uClass)
		jClass2 = getCorrespondingClass(uClass2)
		assertEquals(INTERFACE_NAME, getClassifierFromTypeReference(jClass2.implements.head).name);
		assertTrue(jClass.implements.nullOrEmpty)

		assertClassEquals(uClass, jClass)
		assertClassEquals(uClass2, jClass2)

	}

	@Test
	def testCreateDataType() {
		val dataType = createUmlDataType(rootElement, DATATYPE_NAME)
		saveAndSynchronizeChanges(dataType)

		val jClass = getCorrespondingClass(dataType)
		assertEquals(DATATYPE_NAME, jClass.name)
		assertJavaFileExists(DATATYPE_NAME, #[]);
	}

}
