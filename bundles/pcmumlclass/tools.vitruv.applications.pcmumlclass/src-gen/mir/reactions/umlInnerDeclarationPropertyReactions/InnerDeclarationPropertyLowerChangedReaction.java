package mir.reactions.umlInnerDeclarationPropertyReactions;

import mir.routines.umlInnerDeclarationPropertyReactions.RoutinesFacade;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.xtext.xbase.lib.Extension;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractReactionRealization;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;
import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.change.echange.feature.reference.ReplaceSingleValuedEReference;

@SuppressWarnings("all")
public class InnerDeclarationPropertyLowerChangedReaction extends AbstractReactionRealization {
  private ReplaceSingleValuedEReference<Property, ValueSpecification> replaceChange;
  
  private int currentlyMatchedChange;
  
  public InnerDeclarationPropertyLowerChangedReaction(final RoutinesFacade routinesFacade) {
    super(routinesFacade);
  }
  
  public void executeReaction(final EChange change) {
    if (!checkPrecondition(change)) {
    	return;
    }
    org.eclipse.uml2.uml.Property affectedEObject = replaceChange.getAffectedEObject();
    EReference affectedFeature = replaceChange.getAffectedFeature();
    org.eclipse.uml2.uml.ValueSpecification oldValue = replaceChange.getOldValue();
    org.eclipse.uml2.uml.ValueSpecification newValue = replaceChange.getNewValue();
    				
    getLogger().trace("Passed complete precondition check of Reaction " + this.getClass().getName());
    				
    mir.reactions.umlInnerDeclarationPropertyReactions.InnerDeclarationPropertyLowerChangedReaction.ActionUserExecution userExecution = new mir.reactions.umlInnerDeclarationPropertyReactions.InnerDeclarationPropertyLowerChangedReaction.ActionUserExecution(this.executionState, this);
    userExecution.callRoutine1(replaceChange, affectedEObject, affectedFeature, oldValue, newValue, this.getRoutinesFacade());
    
    resetChanges();
  }
  
  private void resetChanges() {
    replaceChange = null;
    currentlyMatchedChange = 0;
  }
  
  public boolean checkPrecondition(final EChange change) {
    if (currentlyMatchedChange == 0) {
    	if (!matchReplaceChange(change)) {
    		resetChanges();
    		return false;
    	} else {
    		currentlyMatchedChange++;
    	}
    }
    
    return true;
  }
  
  private boolean matchReplaceChange(final EChange change) {
    if (change instanceof ReplaceSingleValuedEReference<?, ?>) {
    	ReplaceSingleValuedEReference<org.eclipse.uml2.uml.Property, org.eclipse.uml2.uml.ValueSpecification> _localTypedChange = (ReplaceSingleValuedEReference<org.eclipse.uml2.uml.Property, org.eclipse.uml2.uml.ValueSpecification>) change;
    	if (!(_localTypedChange.getAffectedEObject() instanceof org.eclipse.uml2.uml.Property)) {
    		return false;
    	}
    	if (!_localTypedChange.getAffectedFeature().getName().equals("lowerValue")) {
    		return false;
    	}
    	if (_localTypedChange.isFromNonDefaultValue() && !(_localTypedChange.getOldValue() instanceof org.eclipse.uml2.uml.ValueSpecification)) {
    		return false;
    	}
    	if (_localTypedChange.isToNonDefaultValue() && !(_localTypedChange.getNewValue() instanceof org.eclipse.uml2.uml.ValueSpecification)) {
    		return false;
    	}
    	this.replaceChange = (ReplaceSingleValuedEReference<org.eclipse.uml2.uml.Property, org.eclipse.uml2.uml.ValueSpecification>) change;
    	return true;
    }
    
    return false;
  }
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public void callRoutine1(final ReplaceSingleValuedEReference replaceChange, final Property affectedEObject, final EReference affectedFeature, final ValueSpecification oldValue, final ValueSpecification newValue, @Extension final RoutinesFacade _routinesFacade) {
      _routinesFacade.propagateTypeChange(affectedEObject);
    }
  }
}
