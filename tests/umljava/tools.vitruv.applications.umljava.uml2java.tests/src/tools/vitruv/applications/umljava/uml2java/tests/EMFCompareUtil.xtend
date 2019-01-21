package tools.vitruv.applications.umljava.uml2java.tests

import java.util.List
import org.eclipse.emf.common.notify.Notifier
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.compare.Comparison
import org.eclipse.emf.compare.Diff
import org.eclipse.emf.compare.EMFCompare
import org.eclipse.emf.compare.scope.DefaultComparisonScope
import org.eclipse.emf.compare.scope.IComparisonScope
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.apache.log4j.Logger

class EMFCompareUtil {
	private static final Logger log = Logger.getLogger(typeof(EMFCompareUtil));

	def static List<Diff> compare(String firstPath, String secondPath) {
		var URI firstURI = URI.createFileURI("file1.xmi")
		var URI secondURI = URI.createFileURI("file2.xmi")
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl())
		var ResourceSet firstResource = new ResourceSetImpl()
		var ResourceSet secondResource = new ResourceSetImpl()
		firstResource.getResource(firstURI, true)
		secondResource.getResource(secondURI, true)
		compare(firstResource, secondResource)
	}

	def static List<Diff> compare(Notifier first, Notifier second) {
		compare(first, second, null)
	}

	def static List<Diff> compare(Notifier first, Notifier second, Notifier third) {
		// scope with models instead of resource sets
		var IComparisonScope scope = new DefaultComparisonScope(first, second, third)
		var Comparison comparison = EMFCompare.builder().build().compare(scope)
		var List<Diff> differences = comparison.getDifferences()
		log.error("Differences: " + differences.size)
		for (diff : differences) {
			log.error(" - " + DiffUtil.getStringRepresentation(diff))
		}
		return differences
	}
}
