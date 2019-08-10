package mir.reactions.umlToJavaClassifier;

import mir.routines.umlToJavaClassifier.RoutinesFacade;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.xtext.xbase.lib.Extension;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractReactionRealization;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;
import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.change.echange.eobject.CreateEObject;
import tools.vitruv.framework.change.echange.feature.reference.InsertEReference;

@SuppressWarnings("all")
public class UmlPrimitiveTypeCreatedReaction extends AbstractReactionRealization {
  private CreateEObject<PrimitiveType> createChange;
  
  private InsertEReference<Model, PrimitiveType> insertChange;
  
  private int currentlyMatchedChange;
  
  public UmlPrimitiveTypeCreatedReaction(final RoutinesFacade routinesFacade) {
    super(routinesFacade);
  }
  
  public void executeReaction(final EChange change) {
    if (!checkPrecondition(change)) {
    	return;
    }
    org.eclipse.uml2.uml.Model affectedEObject = insertChange.getAffectedEObject();
    EReference affectedFeature = insertChange.getAffectedFeature();
    org.eclipse.uml2.uml.PrimitiveType newValue = insertChange.getNewValue();
    int index = insertChange.getIndex();
    				
    getLogger().trace("Passed complete precondition check of Reaction " + this.getClass().getName());
    				
    mir.reactions.umlToJavaClassifier.UmlPrimitiveTypeCreatedReaction.ActionUserExecution userExecution = new mir.reactions.umlToJavaClassifier.UmlPrimitiveTypeCreatedReaction.ActionUserExecution(this.executionState, this);
    userExecution.callRoutine1(insertChange, affectedEObject, affectedFeature, newValue, index, this.getRoutinesFacade());
    
    resetChanges();
  }
  
  private void resetChanges() {
    createChange = null;
    insertChange = null;
    currentlyMatchedChange = 0;
  }
  
  private boolean matchCreateChange(final EChange change) {
    if (change instanceof CreateEObject<?>) {
    	CreateEObject<org.eclipse.uml2.uml.PrimitiveType> _localTypedChange = (CreateEObject<org.eclipse.uml2.uml.PrimitiveType>) change;
    	if (!(_localTypedChange.getAffectedEObject() instanceof org.eclipse.uml2.uml.PrimitiveType)) {
    		return false;
    	}
    	this.createChange = (CreateEObject<org.eclipse.uml2.uml.PrimitiveType>) change;
    	return true;
    }
    
    return false;
  }
  
  public boolean checkPrecondition(final EChange change) {
    if (currentlyMatchedChange == 0) {
    	if (!matchCreateChange(change)) {
    		resetChanges();
    		return false;
    	} else {
    		currentlyMatchedChange++;
    	}
    	return false; // Only proceed on the last of the expected changes
    }
    if (currentlyMatchedChange == 1) {
    	if (!matchInsertChange(change)) {
    		resetChanges();
    		checkPrecondition(change); // Reexecute to potentially register this as first change
    		return false;
    	} else {
    		currentlyMatchedChange++;
    	}
    }
    
    return true;
  }
  
  private boolean matchInsertChange(final EChange change) {
    if (change instanceof InsertEReference<?, ?>) {
    	InsertEReference<org.eclipse.uml2.uml.Model, org.eclipse.uml2.uml.PrimitiveType> _localTypedChange = (InsertEReference<org.eclipse.uml2.uml.Model, org.eclipse.uml2.uml.PrimitiveType>) change;
    	if (!(_localTypedChange.getAffectedEObject() instanceof org.eclipse.uml2.uml.Model)) {
    		return false;
    	}
    	if (!_localTypedChange.getAffectedFeature().getName().equals("packagedElement")) {
    		return false;
    	}
    	if (!(_localTypedChange.getNewValue() instanceof org.eclipse.uml2.uml.PrimitiveType)) {
    		return false;
    	}
    	this.insertChange = (InsertEReference<org.eclipse.uml2.uml.Model, org.eclipse.uml2.uml.PrimitiveType>) change;
    	return true;
    }
    
    return false;
  }
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public void callRoutine1(final InsertEReference insertChange, final Model affectedEObject, final EReference affectedFeature, final PrimitiveType newValue, final int index, @Extension final RoutinesFacade _routinesFacade) {
      _routinesFacade.warnUserToUsePredefinedPrimitiveTypes();
    }
  }
}
