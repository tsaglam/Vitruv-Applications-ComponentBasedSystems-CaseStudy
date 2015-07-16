package edu.kit.ipd.sdq.vitruvius.casestudies.jmljava.synchronizers.java

import edu.kit.ipd.sdq.vitruvius.casestudies.jmljava.correspondences.Java2JMLCorrespondenceAdder
import edu.kit.ipd.sdq.vitruvius.casestudies.jmljava.helper.Utilities
import edu.kit.ipd.sdq.vitruvius.casestudies.jmljava.synchronizers.helpers.CorrespondenceHelper
import edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.Modifiable
import edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.RegularModifier
import edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.Typed
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.CorrespondenceInstance
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.TransformationChangeResult
import edu.kit.ipd.sdq.vitruvius.framework.meta.correspondence.datatypes.TUID
import java.util.ArrayList
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EObject
import org.emftext.language.java.commons.Commentable
import org.emftext.language.java.members.Method
import org.emftext.language.java.modifiers.Modifier
import org.emftext.language.java.types.TypeReference
import org.emftext.language.java.variables.Variable

class CommonSynchronizerTransformations {
	
	private static val LOGGER = Logger.getLogger(CommonSynchronizerTransformations)
	
	static def replaceNonRootEObjectInList(EObject affectedJavaObject, Modifier javaOldValue, Modifier javaNewValue, CorrespondenceInstance ci) {
		val changedObjects = new TransformationChangeResult()
		
		val jmlModifiable = CorrespondenceHelper.getSingleCorrespondingEObjectOfType(ci, affectedJavaObject, Modifiable)
		if (jmlModifiable != null) {
			LOGGER.trace("Replacing " + javaOldValue + " with " + javaNewValue)
			
			val jmlModifiableTUIDOld = TUID.getInstance(Utilities.getTUID(jmlModifiable))
			val jmlMemberDeclWithModifierCorr = CorrespondenceHelper.getSingleCorrespondence(ci, affectedJavaObject, jmlModifiable)
			
			val oldJmlModifier = CorrespondenceHelper.getSingleCorrespondingEObjectOfType(ci, javaOldValue, RegularModifier)
			val oldIndex = jmlModifiable.modifiers.indexOf(oldJmlModifier)
			
			ci.removeAllCorrespondences(oldJmlModifier)
			ci.removeAllCorrespondences(javaOldValue)
			
			jmlModifiable.modifiers.remove(oldJmlModifier)
			
			val newJmlModifier = CommonSynchronizerTasks.createJMLModifier(javaNewValue)
			jmlModifiable.modifiers.add(oldIndex, newJmlModifier)
			
			Java2JMLCorrespondenceAdder.addCorrespondences(javaNewValue, newJmlModifier, ci, jmlMemberDeclWithModifierCorr)
			ci.update(jmlModifiableTUIDOld, TUID.getInstance(Utilities.getTUID(jmlModifiable)))
			
			changedObjects.existingObjectsToSave += jmlModifiable
		}
		
		return changedObjects
	}
	
	static def createNonRootEObjectInList(EObject affectedJavaObject, Modifier javaModifier, CorrespondenceInstance ci) {
		val changedObjects = new TransformationChangeResult()
		
		val jmlModifiable = CorrespondenceHelper.getSingleCorrespondingEObjectOfType(ci, affectedJavaObject, Modifiable)
		if (jmlModifiable != null) {
			LOGGER.trace("Creating " + javaModifier)
			
			val jmlModifiableCorr = CorrespondenceHelper.getSingleCorrespondence(ci, affectedJavaObject, jmlModifiable)
			val jmlModifier = CommonSynchronizerTasks.createJMLModifier(javaModifier)
			jmlModifiable.modifiers.add(0, jmlModifier)
			
			Java2JMLCorrespondenceAdder.addCorrespondences(javaModifier, jmlModifier, ci, jmlModifiableCorr)
			
			changedObjects.existingObjectsToSave += jmlModifiable			
		}
		
		return changedObjects
	}
	
	static def replaceNonRootEObjectSingleType(EObject affectedJavaObject, TypeReference javaOldValue, TypeReference javaNewValue, CorrespondenceInstance ci) {
		val changedObjects = new ArrayList<EObject>()
		
		// this does not treat varargs for parameters...
		
		val jmlTyped = CorrespondenceHelper.getSingleCorrespondingEObjectOfType(ci, affectedJavaObject, Typed)
		if (jmlTyped != null) {
			LOGGER.trace("Updating " + jmlTyped)
			val jmlTypedTUIDOld = TUID.getInstance(Utilities.getTUID(jmlTyped))
			val typeArrayDimensions = getArrayDimensions(affectedJavaObject as Commentable)
			jmlTyped.type = CommonSynchronizerTasks.createJMLType(javaNewValue, typeArrayDimensions)
			ci.update(jmlTypedTUIDOld, TUID.getInstance(Utilities.getTUID(jmlTyped)))
			changedObjects.add(jmlTyped)
		}
		
		return changedObjects
	}
	
	private static def dispatch getArrayDimensions(Method javaMethod) {
		return javaMethod.arrayDimension
	}
	
	private static def dispatch getArrayDimensions(Variable javaVariable) {
		return javaVariable.arrayDimension
	}
	
}