package mir.routines.javaToUmlClassifier;

import java.io.IOException;
import mir.routines.javaToUmlClassifier.RoutinesFacade;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.emftext.language.java.members.EnumConstant;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;

@SuppressWarnings("all")
public class DeleteUmlEnumLiteralRoutine extends AbstractRepairRoutineRealization {
  private RoutinesFacade actionsFacade;
  
  private DeleteUmlEnumLiteralRoutine.ActionUserExecution userExecution;
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public EObject getElement1(final EnumConstant jConstant, final EnumerationLiteral uLiteral) {
      return uLiteral;
    }
    
    public EObject getCorrepondenceSourceULiteral(final EnumConstant jConstant) {
      return jConstant;
    }
  }
  
  public DeleteUmlEnumLiteralRoutine(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy, final EnumConstant jConstant) {
    super(reactionExecutionState, calledBy);
    this.userExecution = new mir.routines.javaToUmlClassifier.DeleteUmlEnumLiteralRoutine.ActionUserExecution(getExecutionState(), this);
    this.actionsFacade = new mir.routines.javaToUmlClassifier.RoutinesFacade(getExecutionState(), this);
    this.jConstant = jConstant;
  }
  
  private EnumConstant jConstant;
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine DeleteUmlEnumLiteralRoutine with input:");
    getLogger().debug("   EnumConstant: " + this.jConstant);
    
    EnumerationLiteral uLiteral = getCorrespondingElement(
    	userExecution.getCorrepondenceSourceULiteral(jConstant), // correspondence source supplier
    	EnumerationLiteral.class,
    	(EnumerationLiteral _element) -> true, // correspondence precondition checker
    	null);
    if (uLiteral == null) {
    	return;
    }
    registerObjectUnderModification(uLiteral);
    deleteObject(userExecution.getElement1(jConstant, uLiteral));
    
    postprocessElements();
  }
}
