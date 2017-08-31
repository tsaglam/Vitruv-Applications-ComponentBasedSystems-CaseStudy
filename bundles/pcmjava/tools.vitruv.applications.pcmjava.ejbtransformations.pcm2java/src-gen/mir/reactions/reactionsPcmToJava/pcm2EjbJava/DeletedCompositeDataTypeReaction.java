package mir.reactions.reactionsPcmToJava.pcm2EjbJava;

import mir.routines.pcm2EjbJava.RoutinesFacade;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.xbase.lib.Extension;
import org.palladiosimulator.pcm.repository.CompositeDataType;
import org.palladiosimulator.pcm.repository.Repository;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractReactionRealization;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;
import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.change.echange.compound.RemoveAndDeleteNonRoot;
import tools.vitruv.framework.change.echange.feature.reference.RemoveEReference;

@SuppressWarnings("all")
class DeletedCompositeDataTypeReaction extends AbstractReactionRealization {
  public void executeReaction(final EChange change) {
    RemoveEReference<org.palladiosimulator.pcm.repository.Repository, org.palladiosimulator.pcm.repository.CompositeDataType> typedChange = ((RemoveAndDeleteNonRoot<org.palladiosimulator.pcm.repository.Repository, org.palladiosimulator.pcm.repository.CompositeDataType>)change).getRemoveChange();
    org.palladiosimulator.pcm.repository.Repository affectedEObject = typedChange.getAffectedEObject();
    EReference affectedFeature = typedChange.getAffectedFeature();
    org.palladiosimulator.pcm.repository.CompositeDataType oldValue = typedChange.getOldValue();
    mir.routines.pcm2EjbJava.RoutinesFacade routinesFacade = new mir.routines.pcm2EjbJava.RoutinesFacade(this.executionState, this);
    mir.reactions.reactionsPcmToJava.pcm2EjbJava.DeletedCompositeDataTypeReaction.ActionUserExecution userExecution = new mir.reactions.reactionsPcmToJava.pcm2EjbJava.DeletedCompositeDataTypeReaction.ActionUserExecution(this.executionState, this);
    userExecution.callRoutine1(affectedEObject, affectedFeature, oldValue, routinesFacade);
  }
  
  public static Class<? extends EChange> getExpectedChangeType() {
    return RemoveAndDeleteNonRoot.class;
  }
  
  private boolean checkChangeProperties(final EChange change) {
    RemoveEReference<org.palladiosimulator.pcm.repository.Repository, org.palladiosimulator.pcm.repository.CompositeDataType> relevantChange = ((RemoveAndDeleteNonRoot<org.palladiosimulator.pcm.repository.Repository, org.palladiosimulator.pcm.repository.CompositeDataType>)change).getRemoveChange();
    if (!(relevantChange.getAffectedEObject() instanceof org.palladiosimulator.pcm.repository.Repository)) {
    	return false;
    }
    if (!relevantChange.getAffectedFeature().getName().equals("dataTypes__Repository")) {
    	return false;
    }
    if (!(relevantChange.getOldValue() instanceof org.palladiosimulator.pcm.repository.CompositeDataType)) {
    	return false;
    }
    return true;
  }
  
  public boolean checkPrecondition(final EChange change) {
    if (!(change instanceof RemoveAndDeleteNonRoot)) {
    	return false;
    }
    getLogger().debug("Passed change type check of reaction " + this.getClass().getName());
    if (!checkChangeProperties(change)) {
    	return false;
    }
    getLogger().debug("Passed change properties check of reaction " + this.getClass().getName());
    getLogger().debug("Passed complete precondition check of reaction " + this.getClass().getName());
    return true;
  }
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public void callRoutine1(final Repository affectedEObject, final EReference affectedFeature, final CompositeDataType oldValue, @Extension final RoutinesFacade _routinesFacade) {
      _routinesFacade.deleteJavaClassifier(oldValue);
    }
  }
}
