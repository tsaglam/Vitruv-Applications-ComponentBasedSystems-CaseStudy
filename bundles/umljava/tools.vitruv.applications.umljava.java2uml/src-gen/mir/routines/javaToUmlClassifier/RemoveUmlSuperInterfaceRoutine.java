package mir.routines.javaToUmlClassifier;

import java.io.IOException;
import mir.routines.javaToUmlClassifier.RoutinesFacade;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Generalization;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.types.TypeReference;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;

@SuppressWarnings("all")
public class RemoveUmlSuperInterfaceRoutine extends AbstractRepairRoutineRealization {
  private RemoveUmlSuperInterfaceRoutine.ActionUserExecution userExecution;
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public EObject getElement1(final Interface jInterface, final TypeReference jReference, final org.eclipse.uml2.uml.Interface uInterface, final Generalization uGeneralization) {
      return uGeneralization;
    }
    
    public EObject getCorrepondenceSourceUInterface(final Interface jInterface, final TypeReference jReference) {
      return jInterface;
    }
    
    public EObject getCorrepondenceSourceUGeneralization(final Interface jInterface, final TypeReference jReference, final org.eclipse.uml2.uml.Interface uInterface) {
      return jReference;
    }
  }
  
  public RemoveUmlSuperInterfaceRoutine(final RoutinesFacade routinesFacade, final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy, final Interface jInterface, final TypeReference jReference) {
    super(routinesFacade, reactionExecutionState, calledBy);
    this.userExecution = new mir.routines.javaToUmlClassifier.RemoveUmlSuperInterfaceRoutine.ActionUserExecution(getExecutionState(), this);
    this.jInterface = jInterface;this.jReference = jReference;
  }
  
  private Interface jInterface;
  
  private TypeReference jReference;
  
  protected boolean executeRoutine() throws IOException {
    getLogger().debug("Called routine RemoveUmlSuperInterfaceRoutine with input:");
    getLogger().debug("   jInterface: " + this.jInterface);
    getLogger().debug("   jReference: " + this.jReference);
    
    org.eclipse.uml2.uml.Interface uInterface = getCorrespondingElement(
    	userExecution.getCorrepondenceSourceUInterface(jInterface, jReference), // correspondence source supplier
    	org.eclipse.uml2.uml.Interface.class,
    	(org.eclipse.uml2.uml.Interface _element) -> true, // correspondence precondition checker
    	null, 
    	false // asserted
    	);
    if (uInterface == null) {
    	return false;
    }
    registerObjectUnderModification(uInterface);
    org.eclipse.uml2.uml.Generalization uGeneralization = getCorrespondingElement(
    	userExecution.getCorrepondenceSourceUGeneralization(jInterface, jReference, uInterface), // correspondence source supplier
    	org.eclipse.uml2.uml.Generalization.class,
    	(org.eclipse.uml2.uml.Generalization _element) -> true, // correspondence precondition checker
    	null, 
    	false // asserted
    	);
    if (uGeneralization == null) {
    	return false;
    }
    registerObjectUnderModification(uGeneralization);
    deleteObject(userExecution.getElement1(jInterface, jReference, uInterface, uGeneralization));
    
    postprocessElements();
    
    return true;
  }
}
