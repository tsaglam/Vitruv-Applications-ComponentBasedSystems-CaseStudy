package mir.reactions.reactionsPcmToJava.pcm2EjbJava;

import mir.routines.pcm2EjbJava.RoutinesFacade;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.xbase.lib.Extension;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.OperationSignature;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractReactionRealization;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;
import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.change.echange.compound.CreateAndInsertNonRoot;
import tools.vitruv.framework.change.echange.feature.reference.InsertEReference;

@SuppressWarnings("all")
class CreatedOperationSignatureReaction extends AbstractReactionRealization {
  public void executeReaction(final EChange change) {
    InsertEReference<org.palladiosimulator.pcm.repository.OperationInterface, org.palladiosimulator.pcm.repository.OperationSignature> typedChange = ((CreateAndInsertNonRoot<org.palladiosimulator.pcm.repository.OperationInterface, org.palladiosimulator.pcm.repository.OperationSignature>)change).getInsertChange();
    org.palladiosimulator.pcm.repository.OperationInterface affectedEObject = typedChange.getAffectedEObject();
    EReference affectedFeature = typedChange.getAffectedFeature();
    org.palladiosimulator.pcm.repository.OperationSignature newValue = typedChange.getNewValue();
    mir.routines.pcm2EjbJava.RoutinesFacade routinesFacade = new mir.routines.pcm2EjbJava.RoutinesFacade(this.executionState, this);
    mir.reactions.reactionsPcmToJava.pcm2EjbJava.CreatedOperationSignatureReaction.ActionUserExecution userExecution = new mir.reactions.reactionsPcmToJava.pcm2EjbJava.CreatedOperationSignatureReaction.ActionUserExecution(this.executionState, this);
    userExecution.callRoutine1(affectedEObject, affectedFeature, newValue, routinesFacade);
  }
  
  public static Class<? extends EChange> getExpectedChangeType() {
    return CreateAndInsertNonRoot.class;
  }
  
  private boolean checkChangeProperties(final EChange change) {
    InsertEReference<org.palladiosimulator.pcm.repository.OperationInterface, org.palladiosimulator.pcm.repository.OperationSignature> relevantChange = ((CreateAndInsertNonRoot<org.palladiosimulator.pcm.repository.OperationInterface, org.palladiosimulator.pcm.repository.OperationSignature>)change).getInsertChange();
    if (!(relevantChange.getAffectedEObject() instanceof org.palladiosimulator.pcm.repository.OperationInterface)) {
    	return false;
    }
    if (!relevantChange.getAffectedFeature().getName().equals("signatures__OperationInterface")) {
    	return false;
    }
    if (!(relevantChange.getNewValue() instanceof org.palladiosimulator.pcm.repository.OperationSignature)) {
    	return false;
    }
    return true;
  }
  
  public boolean checkPrecondition(final EChange change) {
    if (!(change instanceof CreateAndInsertNonRoot)) {
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
    
    public void callRoutine1(final OperationInterface affectedEObject, final EReference affectedFeature, final OperationSignature newValue, @Extension final RoutinesFacade _routinesFacade) {
      _routinesFacade.createMethodForOperationSignature(newValue);
    }
  }
}
