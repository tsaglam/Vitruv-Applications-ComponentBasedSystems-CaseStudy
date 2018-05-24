package tools.vitruv.applications.cbs.composite.tests.pcm

import tools.vitruv.applications.cbs.composite.tests.CbsApplicationTest
import org.palladiosimulator.pcm.repository.RepositoryFactory
import org.junit.Test
import org.eclipse.xtend.lib.annotations.Accessors
import org.palladiosimulator.pcm.repository.Repository
import org.eclipse.uml2.uml.Model
import static org.junit.Assert.*;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsEqual.equalTo;
import org.eclipse.uml2.uml.Interface
import org.palladiosimulator.pcm.repository.OperationInterface
import org.palladiosimulator.pcm.repository.BasicComponent

class PcmCreationTests extends CbsApplicationTest {
	private static val REPOSITORY_NAME = "repository";
	private static val MODEL_FOLDER = "model";
	private static val COMPONENT_NAME = "Component";
	private static val INTERFACE_NAME = "Interface";
	private static val PACKAGE_CLASS_NAME = "package-info.java";
	private static val UML_MODEL_NAME = "umlModel";
	
	@Accessors(PRIVATE_GETTER)
	var Repository repository;
	
	private def getUmlModelFromResource() {
		val umlModelResource = getModelResource('''«MODEL_FOLDER»/«UML_MODEL_NAME».uml''');
		assertThat(umlModelResource.contents.size, equalTo(1));
		assertThat(umlModelResource.contents.get(0), instanceOf(Model));
		val umlModel = umlModelResource.contents.get(0) as Model;
		return umlModel;
	}
	
	override protected cleanup() {
		repository = null;
	}
	
	override protected setup() {
		repository = RepositoryFactory.eINSTANCE.createRepository;
		repository.entityName = "repository";
		userInteractor.addNextSelections(UML_MODEL_NAME, MODEL_FOLDER);
		createAndSynchronizeModel('''«MODEL_FOLDER»/«REPOSITORY_NAME».repository''', repository);
		
		assertModelExists('''src/«REPOSITORY_NAME»/«PACKAGE_CLASS_NAME»''');
		//assertModelExists('''«MODEL_FOLDER»/«UML_MODEL_NAME».uml''');
	}
	
	@Test
	public def void testRepositoryCreation() {
		val umlModel = umlModelFromResource;
		val repositoryPackage= umlModel.getNestedPackage(REPOSITORY_NAME);
		assertNotNull(repositoryPackage);
		val contractsPackage = repositoryPackage.getNestedPackage("contracts");
		assertNotNull(contractsPackage);
		val datatypesPackage = repositoryPackage.getNestedPackage("datatypes");
		assertNotNull(datatypesPackage);
	}
	
	@Test
	public def void testCreateComponent() {
		repository.createComponent;
		saveAndSynchronizeChanges(repository);
		
		assertModelExists('''src/«REPOSITORY_NAME»/«COMPONENT_NAME»/«COMPONENT_NAME»Impl.java''');
		val umlModel = umlModelFromResource;
		val repositoryPackage = umlModel.getNestedPackage(REPOSITORY_NAME);
		assertNotNull(repositoryPackage);
		val componentPackage = repositoryPackage.getNestedPackage(COMPONENT_NAME);
		assertNotNull(componentPackage);
		val componentClassElement = componentPackage.getMember(COMPONENT_NAME + "Impl");
		assertThat(componentClassElement, instanceOf(org.eclipse.uml2.uml.Class));
	}
	
	@Test
	public def void testCreateInterface() {
		repository.createInterface;
		saveAndSynchronizeChanges(repository);
		
		assertModelExists('''src/«REPOSITORY_NAME»/contracts/«INTERFACE_NAME».java''');
		val umlModel = umlModelFromResource;
		val repositoryPackage = umlModel.getNestedPackage(REPOSITORY_NAME);
		assertNotNull(repositoryPackage);
		val contractsPackage = repositoryPackage.getNestedPackage("contracts");
		assertNotNull(contractsPackage);
		val interfaceElement = contractsPackage.getMember(INTERFACE_NAME);
		assertThat(interfaceElement, instanceOf(org.eclipse.uml2.uml.Interface));
	}
	
	@Test
	public def void testCreateProvidedRole() {
		val component = repository.createComponent;
		val interf = repository.createInterface;
		val providedRole = RepositoryFactory.eINSTANCE.createOperationProvidedRole;
		providedRole.entityName = INTERFACE_NAME;
		providedRole.providedInterface__OperationProvidedRole = interf;
		component.providedRoles_InterfaceProvidingEntity += providedRole;
		saveAndSynchronizeChanges(repository);
		
		assertModelExists('''src/«REPOSITORY_NAME»/contracts/«INTERFACE_NAME».java''');
		assertModelExists('''src/«REPOSITORY_NAME»/«COMPONENT_NAME»/«COMPONENT_NAME»Impl.java''');
		val umlModel = umlModelFromResource;
		val repositoryPackage = umlModel.getNestedPackage(REPOSITORY_NAME);
		assertNotNull(repositoryPackage);
		val contractsPackage = repositoryPackage.getNestedPackage("contracts");
		assertNotNull(contractsPackage);
		val interfaceElement = contractsPackage.getMember(INTERFACE_NAME);
		assertThat(interfaceElement, instanceOf(org.eclipse.uml2.uml.Interface));
		val umlInterface = interfaceElement as Interface;
		val componentPackage = repositoryPackage.getNestedPackage(COMPONENT_NAME);
		assertNotNull(componentPackage);
		val componentClassElement = componentPackage.getMember(COMPONENT_NAME + "Impl");
		assertThat(componentClassElement, instanceOf(org.eclipse.uml2.uml.Class));
		val componentClass = componentClassElement as org.eclipse.uml2.uml.Class;
		componentClass.getInterfaceRealization(INTERFACE_NAME, umlInterface);
	}
	
	@Test
	public def void testCreateRequiredRole() {
		val component = repository.createComponent;
		val interf = repository.createInterface;
		val requiredRole = RepositoryFactory.eINSTANCE.createOperationRequiredRole;
		requiredRole.entityName = INTERFACE_NAME.toLowerCase;
		requiredRole.requiredInterface__OperationRequiredRole = interf;
		requiredRole.requiringEntity_RequiredRole = component;
		saveAndSynchronizeChanges(repository);
		
		assertModelExists('''src/«REPOSITORY_NAME»/contracts/«INTERFACE_NAME».java''');
		assertModelExists('''src/«REPOSITORY_NAME»/«COMPONENT_NAME»/«COMPONENT_NAME»Impl.java''');
		val umlModel = umlModelFromResource;
		val repositoryPackage = umlModel.getNestedPackage(REPOSITORY_NAME);
		assertNotNull(repositoryPackage);
		val contractsPackage = repositoryPackage.getNestedPackage("contracts");
		assertNotNull(contractsPackage);
		val interfaceElement = contractsPackage.getMember(INTERFACE_NAME);
		assertThat(interfaceElement, instanceOf(org.eclipse.uml2.uml.Interface));
		val componentPackage = repositoryPackage.getNestedPackage(COMPONENT_NAME);
		assertNotNull(componentPackage);
		val componentClassElement = componentPackage.getMember(COMPONENT_NAME + "Impl");
		assertThat(componentClassElement, instanceOf(org.eclipse.uml2.uml.Class));
		val componentClass = componentClassElement as org.eclipse.uml2.uml.Class;
		val requiredRoleField = componentClass.getMember(INTERFACE_NAME.toLowerCase);
		assertNotNull(requiredRoleField);
	}
	
	private def BasicComponent createComponent(Repository repository) {
		val component = RepositoryFactory.eINSTANCE.createBasicComponent;
		component.entityName = COMPONENT_NAME;
		repository.components__Repository += component;
		return component;
	}
	
	private def OperationInterface createInterface(Repository repository) {
		val interf = RepositoryFactory.eINSTANCE.createOperationInterface;
		interf.entityName = INTERFACE_NAME;
		repository.interfaces__Repository += interf;
		return interf;
	}
}