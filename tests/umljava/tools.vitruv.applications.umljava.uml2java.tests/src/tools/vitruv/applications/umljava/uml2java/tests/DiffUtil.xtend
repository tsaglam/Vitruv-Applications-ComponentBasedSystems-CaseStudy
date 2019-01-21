package tools.vitruv.applications.umljava.uml2java.tests

import org.eclipse.emf.compare.AttributeChange
import org.eclipse.emf.compare.Diff
import org.eclipse.emf.compare.DifferenceKind
import org.eclipse.emf.compare.FeatureMapChange
import org.eclipse.emf.compare.ReferenceChange
import org.eclipse.emf.compare.ResourceAttachmentChange
import org.eclipse.emf.compare.ResourceLocationChange
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EReference
import org.eclipse.uml2.uml.NamedElement

class DiffUtil {

	def dispatch static String getStringRepresentation(Diff diff) {
		return '''Diff («diff.kind»)'''
	}

	def dispatch static String getStringRepresentation(ReferenceChange diff) {
		return '''Reference Change: «diff.kind.fullName» of «diff.reference.resolve» which references «diff.value.resolve»'''
	}

	def dispatch static String getStringRepresentation(AttributeChange diff) {
		return '''Attribute Change: «diff.kind.fullName» of «diff.attribute.resolve» with value «diff.value.resolve»'''
	}

	def dispatch static String getStringRepresentation(FeatureMapChange diff) {
		return '''Feature Map Change: «diff.kind.fullName» of «diff.attribute.resolve» with value «diff.value.resolve»'''
	}

	def dispatch static String getStringRepresentation(ResourceAttachmentChange diff) {
		return '''Resource Attachment Change: «diff.kind.fullName» of URI «diff.resourceURI»'''
	}

	def dispatch static String getStringRepresentation(ResourceLocationChange diff) {
		return '''Resource Location Change: «diff.kind.fullName» from «diff.baseLocation» to «diff.changedLocation»'''
	}

	def private dispatch static String resolve(EAttribute attribute) '''Attribute named «attribute.name»'''

	def private dispatch static String resolve(EReference reference) '''Reference named «reference.name»'''

	def private dispatch static String resolve(NamedElement element) '''a «element.class.simpleName» named «element.name»'''

	def private dispatch static String resolve(Object object) '''a «object.class.simpleName»'''

	def private static String getFullName(DifferenceKind kind) {
		switch (kind) {
			case ADD:
				return "Addition"
			case DELETE:
				return "Deletion"
			case CHANGE:
				return "Change"
			case MOVE:
				return "Movement"
		}
	}
}
