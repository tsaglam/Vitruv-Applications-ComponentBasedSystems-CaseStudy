package mir.reactions.umlXpcmDatatypes_R2L;

import org.eclipse.xtext.xbase.lib.Extension;
import org.palladiosimulator.pcm.repository.Repository;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractReactionRealization;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;
import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.change.echange.eobject.CreateEObject;

@SuppressWarnings("all")
public class OnCompositeDataypeRepositoryInsertedAsRootReaction extends AbstractReactionRealization {
  private CreateEObject<Repository> createChange;
  
  private int currentlyMatchedChange;
  
  public OnCompositeDataypeRepositoryInsertedAsRootReaction(final mir.routines.umlXpcmDatatypes_R2L.RoutinesFacade routinesFacade) {
    super(routinesFacade);
  }
  
  public void executeReaction(final EChange change) {
    if (!checkPrecondition(change)) {
    	return;
    }
    org.palladiosimulator.pcm.repository.Repository affectedEObject = createChange.getAffectedEObject();
    				
    getLogger().trace("Passed complete precondition check of Reaction " + this.getClass().getName());
    				
    mir.reactions.umlXpcmDatatypes_R2L.OnCompositeDataypeRepositoryInsertedAsRootReaction.ActionUserExecution userExecution = new mir.reactions.umlXpcmDatatypes_R2L.OnCompositeDataypeRepositoryInsertedAsRootReaction.ActionUserExecution(this.executionState, this);
    userExecution.callRoutine1(createChange, affectedEObject, this.getRoutinesFacade());
    
    resetChanges();
  }
  
  private void resetChanges() {
    createChange = null;
    currentlyMatchedChange = 0;
  }
  
  private boolean matchCreateChange(final EChange change) {
    if (change instanceof CreateEObject<?>) {
    	CreateEObject<org.palladiosimulator.pcm.repository.Repository> _localTypedChange = (CreateEObject<org.palladiosimulator.pcm.repository.Repository>) change;
    	if (!(_localTypedChange.getAffectedEObject() instanceof org.palladiosimulator.pcm.repository.Repository)) {
    		return false;
    	}
    	this.createChange = (CreateEObject<org.palladiosimulator.pcm.repository.Repository>) change;
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
    }
    
    return true;
  }
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public void callRoutine1(final CreateEObject createChange, final Repository affectedEObject, @Extension final mir.routines.umlXpcmDatatypes_R2L.RoutinesFacade _routinesFacade) {
      _routinesFacade.compositeDataype_ElementCreatedCheck(affectedEObject);
    }
  }
}
