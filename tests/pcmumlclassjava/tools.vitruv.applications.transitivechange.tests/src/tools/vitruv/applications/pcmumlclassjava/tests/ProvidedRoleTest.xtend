package tools.vitruv.applications.pcmumlclassjava.tests

import org.eclipse.uml2.uml.InterfaceRealization
import org.junit.Test
import org.palladiosimulator.pcm.repository.OperationProvidedRole
import org.palladiosimulator.pcm.repository.Repository
import org.palladiosimulator.pcm.repository.RepositoryFactory
import tools.vitruv.applications.pcmumlclass.TagLiterals
import tools.vitruv.applications.pcmumlclass.tests.PcmUmlClassApplicationTestHelper
import tools.vitruv.applications.pcmumlclassjava.TransitiveChangeTest
import tools.vitruv.framework.correspondence.CorrespondenceModel

import static org.junit.Assert.*

/**
 * This class is based on the correlating PCM/UML test class. It is extended to include Java in the network.
 * This test class tests the reactions and routines that are supposed to synchronize a pcm::OperationProvidedRole 
 * in an pcm::InterfaceProvidingRequiringEntity (IPRE) with an uml::InterfaceRealization in the uml::Class (implementation) corresponding to the IPRE.
 * <br><br>
 * Related files: PcmProvidedRole.reactions, UmlProvidedRoleGeneralization.reactions
 */
class ProvidedRoleTest extends TransitiveChangeTest {

    private static val PROVIDED_ROLE_NAME = "testProvidedRole"

    def public static void checkProvidedRoleConcept(
        CorrespondenceModel cm,
        OperationProvidedRole pcmProvided,
        InterfaceRealization umlRealization
    ) {
        assertNotNull(pcmProvided)
        assertNotNull(umlRealization)
        assertTrue(corresponds(cm, pcmProvided, umlRealization, TagLiterals.PROVIDED_ROLE__INTERFACE_REALIZATION))
        assertTrue(pcmProvided.entityName == umlRealization.name)
        // the respective type references have to correspond
        assertTrue(corresponds(cm, pcmProvided.providedInterface__OperationProvidedRole, umlRealization.contract, TagLiterals.INTERFACE_TO_INTERFACE))
        // the owning component and component implementation have to correspond
        assertTrue(corresponds(cm, pcmProvided.providingEntity_ProvidedRole, umlRealization.implementingClassifier, TagLiterals.IPRE__IMPLEMENTATION))
    }

    def protected checkProvidedRoleConcept(OperationProvidedRole pcmProvided) {
        val umlRealization = helper.getModifiableCorr(pcmProvided, InterfaceRealization, TagLiterals.PROVIDED_ROLE__INTERFACE_REALIZATION)
        checkProvidedRoleConcept(correspondenceModel, pcmProvided, umlRealization)
        checkJavaProvidedRoleConcept(umlRealization, pcmProvided)
    }

    def protected checkProvidedRoleConcept(InterfaceRealization umlRealization) {
        val pcmProvided = helper.getModifiableCorr(umlRealization, OperationProvidedRole, TagLiterals.PROVIDED_ROLE__INTERFACE_REALIZATION)
        checkProvidedRoleConcept(correspondenceModel, pcmProvided, umlRealization)
        checkJavaProvidedRoleConcept(umlRealization, pcmProvided)
    }

    def protected checkJavaProvidedRoleConcept(InterfaceRealization umlRealization, OperationProvidedRole pcmProvided) {
        checkJavaType(umlRealization.contract)
        checkJavaType(umlRealization.implementingClassifier)
        checkJavaRealization(umlRealization)
        umlRealization.implementingClassifier.operations.forEach[checkJavaConstructor]
        // Created before test cases, should be still there:
        val umlPackage = helper.getUmlRepositoryPackage(pcmProvided.providedInterface__OperationProvidedRole.repository__Interface)
        umlPackage.checkJavaPackage
        umlPackage.nestedPackages.forEach[checkJavaPackage]
    }

    def private Repository createRepository_Component_Interface() {
        val pcmRepository = helper.createRepository()
        helper.createComponent(pcmRepository)
        helper.createOperationInterface(pcmRepository)

        userInteractor.addNextTextInput(PcmUmlClassApplicationTestHelper.UML_MODEL_FILE)
        createAndSynchronizeModel(PcmUmlClassApplicationTestHelper.PCM_MODEL_FILE, pcmRepository)
        assertModelExists(PcmUmlClassApplicationTestHelper.PCM_MODEL_FILE)
        assertModelExists(PcmUmlClassApplicationTestHelper.UML_MODEL_FILE)

        return reloadResourceAndReturnRoot(pcmRepository) as Repository
    }

    @Test
    def void testProvidedRoleConcept_PCM() {
        var pcmRepository = createRepository_Component_Interface

        var pcmProvided = RepositoryFactory.eINSTANCE.createOperationProvidedRole
        pcmProvided.entityName = PROVIDED_ROLE_NAME
        pcmProvided.providedInterface__OperationProvidedRole = helper.getPcmOperationInterface(pcmRepository)
        helper.getPcmComponent(pcmRepository).providedRoles_InterfaceProvidingEntity += pcmProvided

        saveAndSynchronizeChanges(pcmProvided)
        pcmRepository = reloadResourceAndReturnRoot(pcmRepository) as Repository

        pcmProvided = helper.getPcmComponent(pcmRepository).providedRoles_InterfaceProvidingEntity.head as OperationProvidedRole
        checkProvidedRoleConcept(pcmProvided)
    }

    @Test
    def void testProvidedRoleConcept_UML() {
        var pcmRepository = createRepository_Component_Interface
        startRecordingChanges(helper.getUmlComponentImpl(pcmRepository))

        var umlRealization = helper.getUmlComponentImpl(pcmRepository).createInterfaceRealization(PROVIDED_ROLE_NAME, helper.getUmlInterface(pcmRepository))

        saveAndSynchronizeChanges(umlRealization)
        reloadResourceAndReturnRoot(umlRealization)
        pcmRepository = reloadResourceAndReturnRoot(pcmRepository) as Repository

        val umlInterface = helper.getUmlInterface(pcmRepository) // necessary that it is final for Lambda
        umlRealization = helper.getUmlComponentImpl(pcmRepository).interfaceRealizations.findFirst[it.contract == umlInterface]
        checkProvidedRoleConcept(umlRealization)
    }

}
