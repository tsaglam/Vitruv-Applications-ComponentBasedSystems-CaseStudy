package tools.vitruv.applications.pcmumlcomponents.pcm2uml.versioning

import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl

import org.eclipse.uml2.uml.Component
import org.eclipse.uml2.uml.Model

import org.junit.Test
import tools.vitruv.framework.versioning.Conflict
import java.util.List
import tools.vitruv.framework.change.echange.EChange
import org.eclipse.xtext.xbase.lib.Functions.Function1
import org.palladiosimulator.pcm.repository.BasicComponent
import org.palladiosimulator.pcm.repository.Repository

import tools.vitruv.framework.util.datatypes.VURI
import tools.vitruv.framework.versioning.mococo.PushState

import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.CoreMatchers.is
import static org.hamcrest.CoreMatchers.not

import static org.hamcrest.collection.IsCollectionWithSize.hasSize
import static org.hamcrest.collection.IsIterableWithSize.iterableWithSize

import static org.junit.Assert.assertThat

class UmlToPCMBothDirectionsVersioningTest extends UmlToPCMBothDirectionsTest {
	override setup() {
		super.setup
		myUMLVURI = VURI::getInstance(myUMLModel.eResource)
		myPCMVURI = myUMLModel.correspondentVURI
		initializeTheirVURIs
	}

	private def void testCreateAndRenameConflictAndAccept(
		Function1<Conflict, List<EChange>> callback,
		String expectedName
	) {
		// PS Same base in both virtual models.
		val myUMLComponent = createUmlComponent(COMPONENT_NAME, false)

		saveAndSynchronizeChanges(rootElement)
		assertThat(mylocalRepository.commit(BASE_COMMIT_MESSAGE, myUMLVURI).changes, hasSize(2))
		assertThat(mylocalRepository.push, is(PushState::SUCCESS))

		theirLocalRepository.pull
		theirLocalRepository.checkout(theirUMLVURI)

		// PS Check if changes are in new virtual model.
		val model = theirLocalRepository.virtualModel.getModelInstance(theirUMLVURI).firstRootEObject as Model
		val myRepo = mylocalRepository.virtualModel.getModelInstance(myPCMVURI).firstRootEObject as Repository
		val theirRep = theirLocalRepository.virtualModel.getModelInstance(theirPCMVURI).firstRootEObject as Repository

		// PS TODO When reapplying the already recorded changes to other virtual model, only the original changes 
		// are applied. So the correspondent PCM elements get new IDs. To handle the objects in PCM still as the same object 
		// although the IDs are different, this mapping is used. 
		theirLocalRepository.addIDPair(theirRep.id -> myRepo.id)
		val myPCMComponent = myRepo.components__Repository.get(0) as BasicComponent
		val theirPCMComponent1 = theirRep.components__Repository.get(0) as BasicComponent
		theirLocalRepository.addIDPair(myPCMComponent.id -> theirPCMComponent1.id)

		val umlComponent = model.packagedElements.get(0) as Component
		assertThat(umlComponent.name, equalTo(COMPONENT_NAME))
		val correspondences1 = theirLocalRepository.virtualModel.correspondenceModel.
			getCorrespondingEObjects(#[umlComponent]).flatten
		assertThat(correspondences1, iterableWithSize(1))
		val basicComponent1 = correspondences1.get(0) as BasicComponent
		assertThat(basicComponent1.entityName, equalTo(COMPONENT_NAME))

		// PS Change 
		myUMLComponent.name = UmlToPCMBothDirectionsVersioningTest.MY_NAME
		saveAndSynchronizeChanges(rootElement)

		assertThat(mylocalRepository.commit(MY_COMMIT_MESSAGE, myUMLVURI).changes, hasSize(1))
		assertThat(mylocalRepository.push, is(PushState::SUCCESS))

		// PS Change name in pcm, commit and push should abort 
		val correspondences = theirLocalRepository.virtualModel.correspondenceModel.
			getCorrespondingEObjects(#[umlComponent]).flatten.toList
		assertThat(correspondences, hasSize(1))
		val theirPCMComponent = correspondences.get(0) as BasicComponent
		assertThat(theirPCMComponent.entityName, equalTo(COMPONENT_NAME))
		val ResourceSet testResourceSet = new ResourceSetImpl
		testResourceSet.resourceFactoryRegistry.extensionToFactoryMap.put("*", new XMIResourceFactoryImpl)
		val sourceModel = testResourceSet.getResource(theirPCMComponent.eResource.URI, true)
		val repo = sourceModel.contents.get(0) as Repository
		val theirModifiableComponent = repo.components__Repository.get(0) as BasicComponent
		startRecordingChanges(repo)
		theirModifiableComponent.entityName = UmlToPCMBothDirectionsVersioningTest.THEIR_NAME
		saveAndSynchronizeChanges(theirLocalRepository.virtualModel, repo)
		theirPCMVURI = VURI::getInstance(theirPCMComponent.eResource)
		assertThat(theirLocalRepository.commit(THEIR_COMMIT_MESSAGE, theirPCMVURI).changes, hasSize(1))
		assertThat(theirLocalRepository.push, is(PushState::COMMIT_NOT_ACCEPTED))

		// PS Pull new commit and merge 
		val remoteBranch = theirLocalRepository.currentBranch.remoteBranch
		assertThat(theirLocalRepository.getCommits(remoteBranch), hasSize(2))
		theirLocalRepository.pull
		assertThat(theirLocalRepository.getCommits(remoteBranch), hasSize(3))
		val lastRemoteCommit = theirLocalRepository.getCommits(remoteBranch).last
		val lastLocalCommit = theirLocalRepository.getCommits(theirLocalRepository.currentBranch).last
		assertThat(lastRemoteCommit.identifier, not(equalTo(lastLocalCommit.identifier)))

		// PS Merge and accept their changes 
		val mergeCommit = theirLocalRepository.merge(
			remoteBranch -> mylocalRepository.virtualModel,
			theirLocalRepository.currentBranch -> theirLocalRepository.virtualModel,
			callback,
			triggeredCallback,
			theirLocalRepository.virtualModel
		)
		assertThat(mergeCommit.changes, hasSize(1))
		assertThat(theirLocalRepository.push, is(PushState::SUCCESS))
		val modelAgain = theirLocalRepository.virtualModel.getModelInstance(theirUMLVURI).firstRootEObject as Model
		val umlComponentAgain = modelAgain.packagedElements.get(0) as Component
		assertThat(umlComponentAgain.name, is(expectedName))
		val correspondences2 = theirLocalRepository.virtualModel.correspondenceModel.
			getCorrespondingEObjects(#[umlComponentAgain]).flatten.toList
		assertThat(correspondences2, hasSize(1))
		val pcmComponentAgain = correspondences2.get(0) as BasicComponent
		assertThat(pcmComponentAgain.entityName, is(expectedName))
	}

	@Test
	def void testCreateAndRenameConflictAndAcceptTheirName() {
		testCreateAndRenameConflictAndAccept(acceptTheirChangesCallback, THEIR_NAME)
	}

	@Test
	def void testCreateAndRenameConflictAndAcceptMyName() {
		testCreateAndRenameConflictAndAccept(acceptMyChangesCallback, MY_NAME)
	}
}
