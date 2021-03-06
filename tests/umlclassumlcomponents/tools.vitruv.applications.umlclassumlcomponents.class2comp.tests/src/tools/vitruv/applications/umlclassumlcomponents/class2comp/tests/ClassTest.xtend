package tools.vitruv.applications.umlclassumlcomponents.class2comp.tests

import org.eclipse.uml2.uml.Component
import org.junit.Test

import static org.junit.Assert.*
import static tools.vitruv.applications.umlclassumlcomponents.sharedutil.SharedTestUtil.*

class ClassTest extends AbstractClass2CompTest{
	
	/*******
	*Class:*
	********/	
	
	@Test
	public def void testCreateComponentForClass() {
		val umlClass = createClass(CLASS_NAME, 0)
		saveAndSynchronizeWithInteractions(umlClass)
		
		assertComponentForClass(umlClass, CLASS_NAME)
	}
	
	@Test
	public def void testCreate2ComponentsFor2ClassesInSamePackage() {
		val classPackage = createPackage(CLASS_NAME)
		val umlClass1 = createClass(CLASS_NAME, classPackage, 0)
		val umlClass2 = createClassWithoutInteraction(CLASS_NAME2, classPackage)
		saveAndSynchronizeWithInteractions(rootElement)
		
		//First Class should have Component
		assertComponentForClass(umlClass1, CLASS_NAME)
		
		//Second Class should receive no Component
		val correspondingElements = correspondenceModel.getCorrespondingEObjects(#[umlClass2]).flatten
		assertEquals(0, correspondingElements.size)
	}
	
	@Test
	public def void testCreate2ComponentsFor2ClassesInDifferentPackages() {
		val classPackage1 = createPackage(CLASS_NAME)
		val umlClass1 = createClass(CLASS_NAME, classPackage1, 0)
		val classPackage2 = createPackage(CLASS_NAME2)
		val umlClass2 = createClass(CLASS_NAME2, classPackage2, 0)
		saveAndSynchronizeWithInteractions(rootElement)
		
		//Both Classes should have corresponding Components
		assertComponentForClass(umlClass1, CLASS_NAME)
		assertPackageLinkedToComponent(classPackage1, CLASS_NAME)
		assertComponentForClass(umlClass2, CLASS_NAME2)
		assertPackageLinkedToComponent(classPackage2, CLASS_NAME2)
	}
	
	@Test
	public def void testCreateNoComponentForClass() {
		val umlClass = createClass(CLASS_NAME, 1)
		saveAndSynchronizeWithInteractions(umlClass)
		
		val correspondingElements = correspondenceModel.getCorrespondingEObjects(#[umlClass]).flatten
		assertEquals(0, correspondingElements.size)
		assertFalse(rootElement.packagedElements.contains(Component))
	}

	@Test
    public def void testRenameClass() {
    	val umlClass = createClass("Old", 0)
		saveAndSynchronizeWithInteractions(umlClass)
		
		//Change name:
		umlClass.name = "New"
		saveAndSynchronizeWithInteractions(umlClass)
		
		//Check if rename happened in Component:
		assertComponentForClass(umlClass, "New")
    }
    
	@Test
    public def void testDeleteClass() {
    	val classPackage = createPackage(CLASS_NAME)
    	val umlClass = createClass(CLASS_NAME, classPackage, 0)	
		saveAndSynchronizeWithInteractions(umlClass)
		val umlComponent = assertComponentForClass(umlClass, CLASS_NAME)		
		
		//Remove Class		
		assertTrue(classPackage.packagedElements.contains(umlClass))
		umlClass.destroy()		
		assertFalse(classPackage.packagedElements.contains(umlClass))
		saveAndSynchronizeWithInteractions(rootElement)
		
		//Check if Component still exists:		
		assertFalse(classPackage.packagedElements.contains(umlComponent))
    }    
    
    @Test
	public def void testCreateComponentForClassInPackage() {
		val classPackage = createPackage(CLASS_NAME)
		val umlClass = createClass(CLASS_NAME, classPackage, 0)
		saveAndSynchronizeWithInteractions(umlClass)
		
		assertComponentForClass(umlClass, CLASS_NAME)
		assertPackageLinkedToComponent(classPackage, CLASS_NAME)
	}   
	
}