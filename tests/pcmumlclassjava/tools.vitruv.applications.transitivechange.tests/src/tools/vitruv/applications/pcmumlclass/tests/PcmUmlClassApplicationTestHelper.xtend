package tools.vitruv.applications.pcmumlclass.tests

import org.palladiosimulator.pcm.repository.RepositoryFactory
import org.palladiosimulator.pcm.repository.Repository
import tools.vitruv.applications.pcmumlclass.DefaultLiterals
import org.palladiosimulator.pcm.repository.CompositeComponent
import tools.vitruv.applications.pcmumlclass.TagLiterals
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.EObject
import tools.vitruv.framework.correspondence.CorrespondenceModel
import org.eclipse.emf.ecore.resource.ResourceSet
import java.util.Set
import tools.vitruv.extensions.dslsruntime.reactions.helper.ReactionsCorrespondenceHelper

import static extension tools.vitruv.framework.correspondence.CorrespondenceModelUtil.*
import org.palladiosimulator.pcm.repository.CompositeDataType
import org.palladiosimulator.pcm.repository.DataType
import org.palladiosimulator.pcm.repository.CollectionDataType
import org.eclipse.uml2.uml.PrimitiveType
import org.palladiosimulator.pcm.repository.PrimitiveDataType
import tools.vitruv.applications.pcmumlclass.PcmUmlClassHelper
import org.palladiosimulator.pcm.repository.PrimitiveTypeEnum
import org.palladiosimulator.pcm.repository.OperationInterface
import org.palladiosimulator.pcm.repository.OperationSignature
import java.util.function.Function
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource

final class PcmUmlClassApplicationTestHelper {
	public new (CorrespondenceModel testCorrespondenceModel, Function<URI, EObject> eObjectRetriever, Function<URI, Resource> resourceRetriever) {
		this.correspondenceModel = testCorrespondenceModel
		this.eObjectRetriever = eObjectRetriever
		
		val pcmPrimitiveTypes = PcmUmlClassHelper.getPcmPrimitiveTypes(resourceRetriever)	
		PCM_BOOL = pcmPrimitiveTypes.findFirst[it.type === PrimitiveTypeEnum.BOOL]
		PCM_INT = pcmPrimitiveTypes.findFirst[it.type === PrimitiveTypeEnum.INT]
		PCM_DOUBLE = pcmPrimitiveTypes.findFirst[it.type === PrimitiveTypeEnum.DOUBLE]
		PCM_STRING = pcmPrimitiveTypes.findFirst[it.type === PrimitiveTypeEnum.STRING]
		PCM_CHAR = pcmPrimitiveTypes.findFirst[it.type === PrimitiveTypeEnum.CHAR]
		PCM_BYTE = pcmPrimitiveTypes.findFirst[it.type === PrimitiveTypeEnum.BYTE]
		
		val umlPrimitiveTypes = PcmUmlClassHelper.getUmlPrimitiveTypes(resourceRetriever)
		UML_BOOL =  umlPrimitiveTypes.findFirst[it.name == "Boolean"]
		UML_INT =  umlPrimitiveTypes.findFirst[it.name == "Integer"]
		UML_REAL =  umlPrimitiveTypes.findFirst[it.name == "Real"]
		UML_STRING =  umlPrimitiveTypes.findFirst[it.name == "String"]
		UML_UNLIMITED_NATURAL =  umlPrimitiveTypes.findFirst[it.name == "UnlimitedNatural"]
	}
	
	private val CorrespondenceModel correspondenceModel
	private val Function<URI, EObject> eObjectRetriever
	
	/**
	 * Fetches the given {@link EObject} from the {@link ResourceSet} of the running test.
	 * <br>
	 * Elements retrieved via correspondence model are read-only (except in the Transactions performed by the framework),
	 * and live in a different resourceSet. If corresponding elements need to be changed or compared, they should be retrieved via this method, 
	 * or the getModifiableCorr(...) methods.
	 * 
	 * @param original
	 * 		the {@link EObject} instance living in some ResourceSet
	 * @return the object instance in the ResourceSet of this test
	 */
	def public <T extends EObject> getModifiableInstance(T original) {
		val originalURI = EcoreUtil.getURI(original)
		return eObjectRetriever.apply(originalURI) as T
	}
	
	def public <T extends EObject> Set<T> getCorrSet(EObject source, Class<T> typeFilter) {
		return correspondenceModel.getCorrespondingEObjectsByType(source, typeFilter) as Set<T>
	}
	
	def public <T extends EObject> T getCorr(EObject source, Class<T> typeFilter, String tag) {
		return ReactionsCorrespondenceHelper.getCorrespondingObjectsOfType(correspondenceModel, source, tag, typeFilter).head
	}
	
	def public <T extends EObject> Set<T> getModifiableCorrSet(EObject source, Class<T> typeFilter) {
		return getCorrSet(source, typeFilter).map[getModifiableInstance(it)].filter[it !== null].toSet
	}
	
	def public <T extends EObject> T getModifiableCorr(EObject source, Class<T> typeFilter, String tag) {
		val correspondence = getCorr(source, typeFilter,tag)
		if(correspondence === null) return null
		return getModifiableInstance(getCorr(source, typeFilter,tag))
	}
	
	// here start the factory and retrieval methods
	
	public static val PCM_MODEL_FILE = "model/Repository.repository"
	public static val UML_MODEL_FILE = DefaultLiterals.MODEL_DIRECTORY + "/" + DefaultLiterals.UML_MODEL_FILE_NAME +
			DefaultLiterals.UML_EXTENSION
	
	public static val REPOSITORY_NAME = "TestRepository"
	
	public static val COMPONENT_NAME = "TestComponent"
	public static val COMPONENT_NAME_2 = "TestComponent_2"
	
	public static val COMPOSITE_DATATYPE_NAME = "TestCompositeType"
	public static val COMPOSITE_DATATYPE_NAME_2 = "TestCompositeType_2"
	public static val COLLECTION_DATATYPE_NAME = "TestCollectionType"
	
	public static val INTERFACE_NAME = "TestInterface"
	public static val SIGNATURE_NAME = "testSignature"
	
	public val PrimitiveDataType PCM_BOOL
	public val PrimitiveDataType PCM_INT
	public val PrimitiveDataType PCM_DOUBLE
	public val PrimitiveDataType PCM_STRING
	public val PrimitiveDataType PCM_CHAR
	public val PrimitiveDataType PCM_BYTE
	
	public val PrimitiveType UML_BOOL
	public val PrimitiveType UML_INT
	public val PrimitiveType UML_REAL
	public val PrimitiveType UML_STRING
	public val PrimitiveType UML_UNLIMITED_NATURAL
	
	// Repository
	public def createRepository() {
		val pcmRepository = RepositoryFactory.eINSTANCE.createRepository()
		pcmRepository.entityName = REPOSITORY_NAME
		return pcmRepository
	}
	
	public def getUmlRepositoryPackage(Repository pcmRepository) {
		return getModifiableCorr(pcmRepository, org.eclipse.uml2.uml.Package, TagLiterals.REPOSITORY_TO_REPOSITORY_PACKAGE)
	}
	public def getUmlContractsPackage(Repository pcmRepository) {
		return getModifiableCorr(pcmRepository, org.eclipse.uml2.uml.Package, TagLiterals.REPOSITORY_TO_CONTRACTS_PACKAGE)
	}
	public def getUmlDataTypesPackage(Repository pcmRepository) {
		return getModifiableCorr(pcmRepository, org.eclipse.uml2.uml.Package, TagLiterals.REPOSITORY_TO_DATATYPES_PACKAGE)
	}
	
	// CompositeComponent
	private def createComponent(Repository pcmRepository, String componentName) {
		val pcmComponent = RepositoryFactory.eINSTANCE.createCompositeComponent
		pcmComponent.entityName = componentName
		pcmRepository.components__Repository += pcmComponent
		return pcmComponent
	}
	public def createComponent(Repository pcmRepository) {
		return createComponent(pcmRepository, COMPONENT_NAME)
	}
	public def createComponent_2(Repository pcmRepository) {
		return createComponent(pcmRepository, COMPONENT_NAME_2)
	}
	
	private def getPcmComponent(Repository pcmRepository, String componentName) {
		return pcmRepository.components__Repository.filter(CompositeComponent).findFirst[it.entityName == componentName]
	}
	public def getPcmComponent(Repository pcmRepository) {
		return getPcmComponent(pcmRepository, COMPONENT_NAME)
	}
	public def getPcmComponent_2(Repository pcmRepository) {
		return getPcmComponent(pcmRepository, COMPONENT_NAME_2)
	}
	
	public def getUmlComponentImpl(Repository pcmRepository) {
		return getModifiableCorr(getPcmComponent(pcmRepository), org.eclipse.uml2.uml.Class, TagLiterals.IPRE__IMPLEMENTATION)
	}
	public def getUmlComponentImpl_2(Repository pcmRepository) {
		return getModifiableCorr(getPcmComponent_2(pcmRepository), org.eclipse.uml2.uml.Class, TagLiterals.IPRE__IMPLEMENTATION)
	}
	public def getUmlComponentConstructor(Repository pcmRepository) {
		return getModifiableCorr(getPcmComponent(pcmRepository), org.eclipse.uml2.uml.Operation, TagLiterals.IPRE__CONSTRUCTOR)
	}
	public def getUmlComponentConstructor_2(Repository pcmRepository) {
		return getModifiableCorr(getPcmComponent_2(pcmRepository), org.eclipse.uml2.uml.Operation, TagLiterals.IPRE__CONSTRUCTOR)
	}
	
	// CompositeDataType
	private def createCompositeDataType(Repository pcmRepository, String name) {
		val pcmCompositeDataType = RepositoryFactory.eINSTANCE.createCompositeDataType
		pcmCompositeDataType.entityName = name
		pcmRepository.dataTypes__Repository += pcmCompositeDataType
		return pcmCompositeDataType
	}
	public def createCompositeDataType(Repository pcmRepository) {
		return createCompositeDataType(pcmRepository, tools.vitruv.applications.pcmumlclass.tests.PcmUmlClassApplicationTestHelper.COMPOSITE_DATATYPE_NAME)
	}
	public def createCompositeDataType_2(Repository pcmRepository) {
		return createCompositeDataType(pcmRepository, tools.vitruv.applications.pcmumlclass.tests.PcmUmlClassApplicationTestHelper.COMPOSITE_DATATYPE_NAME_2)
	}
	
	private def getPcmCompositeDataType(Repository pcmRepository, String componentName) {
		return pcmRepository.dataTypes__Repository.filter(CompositeDataType).findFirst[it.entityName == componentName]
	}
	public def getPcmCompositeDataType(Repository pcmRepository) {
		return getPcmCompositeDataType(pcmRepository, tools.vitruv.applications.pcmumlclass.tests.PcmUmlClassApplicationTestHelper.COMPOSITE_DATATYPE_NAME)
	}
	public def getPcmCompositeDataType_2(Repository pcmRepository) {
		return getPcmCompositeDataType(pcmRepository, tools.vitruv.applications.pcmumlclass.tests.PcmUmlClassApplicationTestHelper.COMPOSITE_DATATYPE_NAME_2)
	}
	
	public def getUmlCompositeDataTypeClass(Repository pcmRepository) {
		return getModifiableCorr(getPcmCompositeDataType(pcmRepository), org.eclipse.uml2.uml.Class, TagLiterals.COMPOSITE_DATATYPE__CLASS)
	}
	public def getUmlCompositeDataTypeClass_2(Repository pcmRepository) {
		return getModifiableCorr(getPcmCompositeDataType_2(pcmRepository), org.eclipse.uml2.uml.Class, TagLiterals.COMPOSITE_DATATYPE__CLASS)
	}
	
	// CollectionDataType
	public def createCollectionDataType(Repository pcmRepository, DataType innerType) {
		val pcmCollectionType = RepositoryFactory.eINSTANCE.createCollectionDataType
		pcmCollectionType.entityName = tools.vitruv.applications.pcmumlclass.tests.PcmUmlClassApplicationTestHelper.COLLECTION_DATATYPE_NAME
		pcmCollectionType.innerType_CollectionDataType = innerType
		pcmRepository.dataTypes__Repository += pcmCollectionType
		return pcmCollectionType
	}
	
	public def getPcmCollectionDataType(Repository pcmRepository) {
		return pcmRepository.dataTypes__Repository.filter(CollectionDataType)
			.findFirst[it.entityName == tools.vitruv.applications.pcmumlclass.tests.PcmUmlClassApplicationTestHelper.COLLECTION_DATATYPE_NAME] 
	}
	
	// OperationInterface
	public def createOperationInterface(Repository pcmRepository) {
		val pcmInterface = RepositoryFactory.eINSTANCE.createOperationInterface
		pcmInterface.entityName = INTERFACE_NAME
		pcmRepository.interfaces__Repository += pcmInterface
		return pcmInterface
	}
	
	public def getPcmOperationInterface(Repository pcmRepository) {
		return pcmRepository.interfaces__Repository.filter(OperationInterface).findFirst[it.entityName == INTERFACE_NAME]
	}
	public def getUmlInterface(Repository pcmRepository) {
		return getModifiableCorr(getPcmOperationInterface(pcmRepository), org.eclipse.uml2.uml.Interface, TagLiterals.INTERFACE_TO_INTERFACE)
	}

	// OperationSignature
	public def createOperationSignature(OperationInterface pcmInterface) {
		val pcmSignature = RepositoryFactory.eINSTANCE.createOperationSignature
		pcmSignature.entityName = SIGNATURE_NAME
		pcmInterface.signatures__OperationInterface += pcmSignature
		return pcmSignature
	}
	
	public def getPcmOperationSignature(OperationInterface pcmInterface) {
		return pcmInterface.signatures__OperationInterface.filter(OperationSignature).findFirst[it.entityName == SIGNATURE_NAME]
	}
	public def getUmlOperation(OperationInterface pcmInterface) {
		return getModifiableCorr(getPcmOperationSignature(pcmInterface), org.eclipse.uml2.uml.Operation, TagLiterals.SIGNATURE__OPERATION)
	}
	public def getUmlReturnParameter(OperationInterface pcmInterface) {
		return getModifiableCorr(getPcmOperationSignature(pcmInterface), org.eclipse.uml2.uml.Parameter, TagLiterals.SIGNATURE__RETURN_PARAMETER)
	}

}