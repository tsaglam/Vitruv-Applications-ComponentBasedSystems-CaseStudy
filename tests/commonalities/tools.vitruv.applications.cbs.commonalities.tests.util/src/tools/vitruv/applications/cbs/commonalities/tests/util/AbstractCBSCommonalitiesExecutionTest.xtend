package tools.vitruv.applications.cbs.commonalities.tests.util

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.xtend.lib.annotations.Accessors
import tools.vitruv.dsls.commonalities.testutils.CommonalitiesExecutionTest

import static org.junit.Assert.*

abstract class AbstractCBSCommonalitiesExecutionTest extends CommonalitiesExecutionTest {

	@Accessors(PROTECTED_GETTER)
	val VitruvApplicationTestAdapter vitruvApplicationTestAdapter = createVitruvApplicationTestAdapter()

	private def VitruvApplicationTestAdapter createVitruvApplicationTestAdapter() {
		val testResourceFunc = [ String resourcePath |
			getTestResource(resourcePath)
		]
		val createAndSynchronizeModelFunc = [ String modelPathInProject, EObject rootElement |
			createAndSynchronizeModel(modelPathInProject, rootElement)
		]
		val saveAndSynchronizeChangesFunc = [ Resource resource |
			saveAndSynchronizeChanges(resource)
		]
		val deleteAndSynchronizeModelFunc = [ String modelPathInProject |
			deleteAndSynchronizeModel(modelPathInProject)
		]
		return new VitruvApplicationTestAdapter() {

			override getResourceAt(String modelPathInProject) {
				// The resources get loaded into the result resource set:
				resultResourceSet.resourceAt(modelPathInProject)
			}

			override getTestResource(String resourcePath) {
				testResourceFunc.apply(resourcePath)
			}

			override createAndSynchronizeModel(String modelPathInProject, EObject rootElement) {
				createAndSynchronizeModelFunc.apply(modelPathInProject, rootElement)
			}

			override saveAndSynchronizeChanges(Resource resource) {
				saveAndSynchronizeChangesFunc.apply(resource)
			}

			override deleteAndSynchronizeModel(String modelPathInProject) {
				deleteAndSynchronizeModelFunc.apply(modelPathInProject)
			}
		}
	}

	@Accessors(PROTECTED_GETTER)
	var ResourceSet testResourcesResourceSet

	// Stores the loaded target models.
	@Accessors(PROTECTED_GETTER)
	var ResourceSet resultResourceSet

	override protected setup() {
		testResourcesResourceSet = new ResourceSetImpl()
		resultResourceSet = new ResourceSetImpl()
	}

	override protected cleanup() {
		testResourcesResourceSet = null
		resultResourceSet = null
	}

	protected final def getTestResource(String resourcePath) {
		val resourceUri = URI.createURI(resourcePath)
		val resource = testResourcesResourceSet.getResource(resourceUri, true)
		assertNotNull("Resource not found: " + resourcePath, resource)
		return resource
	}
}
