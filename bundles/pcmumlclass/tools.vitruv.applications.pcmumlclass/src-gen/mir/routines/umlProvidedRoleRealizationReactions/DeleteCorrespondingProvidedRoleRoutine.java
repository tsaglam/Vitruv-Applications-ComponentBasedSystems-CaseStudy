package mir.routines.umlProvidedRoleRealizationReactions;

import java.io.IOException;
import mir.routines.umlProvidedRoleRealizationReactions.RoutinesFacade;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import tools.vitruv.applications.pcmumlclass.TagLiterals;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;

@SuppressWarnings("all")
public class DeleteCorrespondingProvidedRoleRoutine extends AbstractRepairRoutineRealization {
  private DeleteCorrespondingProvidedRoleRoutine.ActionUserExecution userExecution;
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public EObject getElement1(final InterfaceRealization umlRealization, final OperationProvidedRole pcmProvided) {
      return pcmProvided;
    }
    
    public String getRetrieveTag1(final InterfaceRealization umlRealization) {
      return TagLiterals.PROVIDED_ROLE__INTERFACE_REALIZATION;
    }
    
    public EObject getElement2(final InterfaceRealization umlRealization, final OperationProvidedRole pcmProvided) {
      return umlRealization;
    }
    
    public EObject getElement3(final InterfaceRealization umlRealization, final OperationProvidedRole pcmProvided) {
      return pcmProvided;
    }
    
    public String getTag1(final InterfaceRealization umlRealization, final OperationProvidedRole pcmProvided) {
      return TagLiterals.PROVIDED_ROLE__INTERFACE_REALIZATION;
    }
    
    public EObject getCorrepondenceSourcePcmProvided(final InterfaceRealization umlRealization) {
      return umlRealization;
    }
  }
  
  public DeleteCorrespondingProvidedRoleRoutine(final RoutinesFacade routinesFacade, final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy, final InterfaceRealization umlRealization) {
    super(routinesFacade, reactionExecutionState, calledBy);
    this.userExecution = new mir.routines.umlProvidedRoleRealizationReactions.DeleteCorrespondingProvidedRoleRoutine.ActionUserExecution(getExecutionState(), this);
    this.umlRealization = umlRealization;
  }
  
  private InterfaceRealization umlRealization;
  
  protected boolean executeRoutine() throws IOException {
    getLogger().debug("Called routine DeleteCorrespondingProvidedRoleRoutine with input:");
    getLogger().debug("   umlRealization: " + this.umlRealization);
    
    org.palladiosimulator.pcm.repository.OperationProvidedRole pcmProvided = getCorrespondingElement(
    	userExecution.getCorrepondenceSourcePcmProvided(umlRealization), // correspondence source supplier
    	org.palladiosimulator.pcm.repository.OperationProvidedRole.class,
    	(org.palladiosimulator.pcm.repository.OperationProvidedRole _element) -> true, // correspondence precondition checker
    	userExecution.getRetrieveTag1(umlRealization), 
    	false // asserted
    	);
    if (pcmProvided == null) {
    	return false;
    }
    registerObjectUnderModification(pcmProvided);
    removeCorrespondenceBetween(userExecution.getElement1(umlRealization, pcmProvided), userExecution.getElement2(umlRealization, pcmProvided), userExecution.getTag1(umlRealization, pcmProvided));
    
    deleteObject(userExecution.getElement3(umlRealization, pcmProvided));
    
    postprocessElements();
    
    return true;
  }
}
