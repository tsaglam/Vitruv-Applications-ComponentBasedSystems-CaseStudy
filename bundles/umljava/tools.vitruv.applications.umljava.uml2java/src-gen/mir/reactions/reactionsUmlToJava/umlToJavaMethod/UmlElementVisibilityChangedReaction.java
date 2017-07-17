package mir.reactions.reactionsUmlToJava.umlToJavaMethod;

import mir.routines.umlToJavaMethod.RoutinesFacade;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.xtext.xbase.lib.Extension;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractReactionRealization;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;
import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.change.echange.feature.attribute.ReplaceSingleValuedEAttribute;

@SuppressWarnings("all")
class UmlElementVisibilityChangedReaction extends AbstractReactionRealization {
  public void executeReaction(final EChange change) {
    ReplaceSingleValuedEAttribute<NamedElement, VisibilityKind> typedChange = (ReplaceSingleValuedEAttribute<NamedElement, VisibilityKind>)change;
    NamedElement affectedEObject = typedChange.getAffectedEObject();
    EAttribute affectedFeature = typedChange.getAffectedFeature();
    VisibilityKind oldValue = typedChange.getOldValue();
    VisibilityKind newValue = typedChange.getNewValue();
    mir.routines.umlToJavaMethod.RoutinesFacade routinesFacade = new mir.routines.umlToJavaMethod.RoutinesFacade(this.executionState, this);
    mir.reactions.reactionsUmlToJava.umlToJavaMethod.UmlElementVisibilityChangedReaction.ActionUserExecution userExecution = new mir.reactions.reactionsUmlToJava.umlToJavaMethod.UmlElementVisibilityChangedReaction.ActionUserExecution(this.executionState, this);
    userExecution.callRoutine1(affectedEObject, affectedFeature, oldValue, newValue, routinesFacade);
  }
  
  public static Class<? extends EChange> getExpectedChangeType() {
    return ReplaceSingleValuedEAttribute.class;
  }
  
  private boolean checkChangeProperties(final EChange change) {
    ReplaceSingleValuedEAttribute<NamedElement, VisibilityKind> relevantChange = (ReplaceSingleValuedEAttribute<NamedElement, VisibilityKind>)change;
    if (!(relevantChange.getAffectedEObject() instanceof NamedElement)) {
    	return false;
    }
    if (!relevantChange.getAffectedFeature().getName().equals("visibility")) {
    	return false;
    }
    if (relevantChange.isFromNonDefaultValue() && !(relevantChange.getOldValue() instanceof VisibilityKind)) {
    	return false;
    }
    if (relevantChange.isToNonDefaultValue() && !(relevantChange.getNewValue() instanceof VisibilityKind)) {
    	return false;
    }
    return true;
  }
  
  public boolean checkPrecondition(final EChange change) {
    if (!(change instanceof ReplaceSingleValuedEAttribute)) {
    	return false;
    }
    getLogger().debug("Passed change type check of reaction " + this.getClass().getName());
    if (!checkChangeProperties(change)) {
    	return false;
    }
    getLogger().debug("Passed change properties check of reaction " + this.getClass().getName());
    ReplaceSingleValuedEAttribute<NamedElement, VisibilityKind> typedChange = (ReplaceSingleValuedEAttribute<NamedElement, VisibilityKind>)change;
    NamedElement affectedEObject = typedChange.getAffectedEObject();
    EAttribute affectedFeature = typedChange.getAffectedFeature();
    VisibilityKind oldValue = typedChange.getOldValue();
    VisibilityKind newValue = typedChange.getNewValue();
    if (!checkUserDefinedPrecondition(affectedEObject, affectedFeature, oldValue, newValue)) {
    	return false;
    }
    getLogger().debug("Passed complete precondition check of reaction " + this.getClass().getName());
    return true;
  }
  
  private boolean checkUserDefinedPrecondition(final NamedElement affectedEObject, final EAttribute affectedFeature, final VisibilityKind oldValue, final VisibilityKind newValue) {
    EObject _eContainer = affectedEObject.eContainer();
    boolean _not = (!(_eContainer instanceof Interface));
    return _not;
  }
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public void callRoutine1(final NamedElement affectedEObject, final EAttribute affectedFeature, final VisibilityKind oldValue, final VisibilityKind newValue, @Extension final RoutinesFacade _routinesFacade) {
      _routinesFacade.changeJavaElementVisibility(affectedEObject);
    }
  }
}
