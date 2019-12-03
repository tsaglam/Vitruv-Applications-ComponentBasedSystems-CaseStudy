package mir.routines.javaToUmlMethod;

import java.io.IOException;
import mir.routines.javaToUmlMethod.RoutinesFacade;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.xtext.xbase.lib.Extension;
import org.emftext.language.java.parameters.OrdinaryParameter;
import org.emftext.language.java.types.TypeReference;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;

@SuppressWarnings("all")
public class ChangeUmlParameterTypeRoutine extends AbstractRepairRoutineRealization {
  private ChangeUmlParameterTypeRoutine.ActionUserExecution userExecution;
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public EObject getCorrepondenceSourceUParam(final OrdinaryParameter jParam, final TypeReference jType) {
      return jParam;
    }
    
    public void callRoutine1(final OrdinaryParameter jParam, final TypeReference jType, final Parameter uParam, @Extension final RoutinesFacade _routinesFacade) {
      _routinesFacade.javaToUmlTypePropagation.propagateParameterTypeChange(jParam, uParam);
    }
  }
  
  public ChangeUmlParameterTypeRoutine(final RoutinesFacade routinesFacade, final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy, final OrdinaryParameter jParam, final TypeReference jType) {
    super(routinesFacade, reactionExecutionState, calledBy);
    this.userExecution = new mir.routines.javaToUmlMethod.ChangeUmlParameterTypeRoutine.ActionUserExecution(getExecutionState(), this);
    this.jParam = jParam;this.jType = jType;
  }
  
  private OrdinaryParameter jParam;
  
  private TypeReference jType;
  
  protected boolean executeRoutine() throws IOException {
    getLogger().debug("Called routine ChangeUmlParameterTypeRoutine with input:");
    getLogger().debug("   jParam: " + this.jParam);
    getLogger().debug("   jType: " + this.jType);
    
    org.eclipse.uml2.uml.Parameter uParam = getCorrespondingElement(
    	userExecution.getCorrepondenceSourceUParam(jParam, jType), // correspondence source supplier
    	org.eclipse.uml2.uml.Parameter.class,
    	(org.eclipse.uml2.uml.Parameter _element) -> true, // correspondence precondition checker
    	null, 
    	false // asserted
    	);
    if (uParam == null) {
    	return false;
    }
    registerObjectUnderModification(uParam);
    userExecution.callRoutine1(jParam, jType, uParam, this.getRoutinesFacade());
    
    postprocessElements();
    
    return true;
  }
}
