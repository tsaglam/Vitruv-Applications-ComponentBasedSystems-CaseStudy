package mir.routines.pcm2depInjectJava;

import java.io.IOException;
import mir.routines.pcm2depInjectJava.RoutinesFacade;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.members.ClassMethod;
import org.palladiosimulator.pcm.seff.ServiceEffectSpecification;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;

@SuppressWarnings("all")
public class DeleteMethodForSeffRoutine extends AbstractRepairRoutineRealization {
  private RoutinesFacade actionsFacade;
  
  private DeleteMethodForSeffRoutine.ActionUserExecution userExecution;
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public EObject getElement1(final ServiceEffectSpecification seff, final ClassMethod classMethod) {
      return classMethod;
    }
    
    public EObject getCorrepondenceSourceClassMethod(final ServiceEffectSpecification seff) {
      return seff;
    }
  }
  
  public DeleteMethodForSeffRoutine(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy, final ServiceEffectSpecification seff) {
    super(reactionExecutionState, calledBy);
    this.userExecution = new mir.routines.pcm2depInjectJava.DeleteMethodForSeffRoutine.ActionUserExecution(getExecutionState(), this);
    this.actionsFacade = new mir.routines.pcm2depInjectJava.RoutinesFacade(getExecutionState(), this);
    this.seff = seff;
  }
  
  private ServiceEffectSpecification seff;
  
  protected boolean executeRoutine() throws IOException {
    getLogger().debug("Called routine DeleteMethodForSeffRoutine with input:");
    getLogger().debug("   seff: " + this.seff);
    
    org.emftext.language.java.members.ClassMethod classMethod = getCorrespondingElement(
    	userExecution.getCorrepondenceSourceClassMethod(seff), // correspondence source supplier
    	org.emftext.language.java.members.ClassMethod.class,
    	(org.emftext.language.java.members.ClassMethod _element) -> true, // correspondence precondition checker
    	null);
    if (classMethod == null) {
    	return false;
    }
    registerObjectUnderModification(classMethod);
    deleteObject(userExecution.getElement1(seff, classMethod));
    
    postprocessElements();
    
    return true;
  }
}
