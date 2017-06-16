package mir.routines.pcm2EjbJava;

import com.google.common.base.Objects;
import java.io.IOException;
import mir.routines.pcm2EjbJava.RoutinesFacade;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.palladiosimulator.pcm.repository.CompositeDataType;
import org.palladiosimulator.pcm.repository.Repository;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;

@SuppressWarnings("all")
public class CreateCompositeDataTypeImplementationRoutine extends AbstractRepairRoutineRealization {
  private RoutinesFacade actionsFacade;
  
  private CreateCompositeDataTypeImplementationRoutine.ActionUserExecution userExecution;
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public boolean getCorrespondingModelElementsPreconditionDatatypesPackage(final CompositeDataType compositeDataType, final org.emftext.language.java.containers.Package datatypesPackage) {
      String _name = datatypesPackage.getName();
      boolean _equals = Objects.equal(_name, "datatypes");
      return _equals;
    }
    
    public EObject getCorrepondenceSourceDatatypesPackage(final CompositeDataType compositeDataType) {
      Repository _repository__DataType = compositeDataType.getRepository__DataType();
      return _repository__DataType;
    }
    
    public void callRoutine1(final CompositeDataType compositeDataType, final org.emftext.language.java.containers.Package datatypesPackage, @Extension final RoutinesFacade _routinesFacade) {
      _routinesFacade.createJavaClass(compositeDataType, datatypesPackage, compositeDataType.getEntityName());
    }
  }
  
  public CreateCompositeDataTypeImplementationRoutine(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy, final CompositeDataType compositeDataType) {
    super(reactionExecutionState, calledBy);
    this.userExecution = new mir.routines.pcm2EjbJava.CreateCompositeDataTypeImplementationRoutine.ActionUserExecution(getExecutionState(), this);
    this.actionsFacade = new mir.routines.pcm2EjbJava.RoutinesFacade(getExecutionState(), this);
    this.compositeDataType = compositeDataType;
  }
  
  private CompositeDataType compositeDataType;
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine CreateCompositeDataTypeImplementationRoutine with input:");
    getLogger().debug("   CompositeDataType: " + this.compositeDataType);
    
    org.emftext.language.java.containers.Package datatypesPackage = getCorrespondingElement(
    	userExecution.getCorrepondenceSourceDatatypesPackage(compositeDataType), // correspondence source supplier
    	org.emftext.language.java.containers.Package.class,
    	(org.emftext.language.java.containers.Package _element) -> userExecution.getCorrespondingModelElementsPreconditionDatatypesPackage(compositeDataType, _element), // correspondence precondition checker
    	null);
    if (datatypesPackage == null) {
    	return;
    }
    registerObjectUnderModification(datatypesPackage);
    userExecution.callRoutine1(compositeDataType, datatypesPackage, actionsFacade);
    
    postprocessElements();
  }
}
