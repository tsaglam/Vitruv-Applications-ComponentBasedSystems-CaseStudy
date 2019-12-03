package mir.routines.umlXpcmComponent_L2R;

import java.io.IOException;
import org.eclipse.xtext.xbase.lib.Extension;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;

@SuppressWarnings("all")
public class OnRepositoryComponentNameReplacedAtClass_nameBidirectionalRepairRoutine extends AbstractRepairRoutineRealization {
  private OnRepositoryComponentNameReplacedAtClass_nameBidirectionalRepairRoutine.ActionUserExecution userExecution;
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public void callRoutine1(final org.eclipse.uml2.uml.Class affectedEObject, @Extension final mir.routines.umlXpcmComponent_L2R.RoutinesFacade _routinesFacade) {
      _routinesFacade.repositoryComponent_BidirectionalCheck(affectedEObject, "updateComponentName");
    }
  }
  
  public OnRepositoryComponentNameReplacedAtClass_nameBidirectionalRepairRoutine(final mir.routines.umlXpcmComponent_L2R.RoutinesFacade routinesFacade, final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy, final org.eclipse.uml2.uml.Class affectedEObject) {
    super(routinesFacade, reactionExecutionState, calledBy);
    this.userExecution = new mir.routines.umlXpcmComponent_L2R.OnRepositoryComponentNameReplacedAtClass_nameBidirectionalRepairRoutine.ActionUserExecution(getExecutionState(), this);
    this.affectedEObject = affectedEObject;
  }
  
  private org.eclipse.uml2.uml.Class affectedEObject;
  
  protected boolean executeRoutine() throws IOException {
    getLogger().debug("Called routine OnRepositoryComponentNameReplacedAtClass_nameBidirectionalRepairRoutine with input:");
    getLogger().debug("   affectedEObject: " + this.affectedEObject);
    
    userExecution.callRoutine1(affectedEObject, this.getRoutinesFacade());
    
    postprocessElements();
    
    return true;
  }
}
