package mir.routines.umlXpcmRoles_L2R;

import java.io.IOException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.xtext.xbase.lib.Extension;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;

@SuppressWarnings("all")
public class ProvidedRole_BidirectionalCheckRoutine extends AbstractRepairRoutineRealization {
  private ProvidedRole_BidirectionalCheckRoutine.ActionUserExecution userExecution;
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public void callRoutine1(final EObject affectedEObject, final String routineName, @Extension final mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade) {
      if ((affectedEObject instanceof InterfaceRealization)) {
        InterfaceRealization interfaceRealization_ = ((InterfaceRealization)affectedEObject);
        {
          EObject implementation__candidate = interfaceRealization_.eContainer();
          if (((implementation__candidate != null) && (implementation__candidate instanceof org.eclipse.uml2.uml.Class))) {
            org.eclipse.uml2.uml.Class implementation_ = ((org.eclipse.uml2.uml.Class) implementation__candidate);
            {
              Interface interface__candidate = interfaceRealization_.getContract();
              if (((interface__candidate != null) && (interface__candidate instanceof Interface))) {
                Interface interface_ = ((Interface) interface__candidate);
                {
                  if ((routineName == "updateProvidedRoleName")) {
                    _routinesFacade.updateProvidedRoleName(interfaceRealization_, implementation_, interface_);
                  }
                  return;
                }
              }
            }
          }
        }
      }
      if ((affectedEObject instanceof org.eclipse.uml2.uml.Class)) {
        org.eclipse.uml2.uml.Class implementation_ = ((org.eclipse.uml2.uml.Class)affectedEObject);
        EList<InterfaceRealization> _interfaceRealizations = implementation_.getInterfaceRealizations();
        for (final InterfaceRealization interfaceRealization__candidate : _interfaceRealizations) {
          if (((interfaceRealization__candidate != null) && (interfaceRealization__candidate instanceof InterfaceRealization))) {
            InterfaceRealization interfaceRealization__1 = ((InterfaceRealization) interfaceRealization__candidate);
            {
              Interface interface__candidate = interfaceRealization__1.getContract();
              if (((interface__candidate != null) && (interface__candidate instanceof Interface))) {
                Interface interface_ = ((Interface) interface__candidate);
                {
                  if ((routineName == "updateProvidedRoleName")) {
                    _routinesFacade.updateProvidedRoleName(interfaceRealization__1, implementation_, interface_);
                  }
                  return;
                }
              }
            }
          }
        }
      }
      if ((affectedEObject instanceof Interface)) {
        Interface interface_ = ((Interface)affectedEObject);
        EList<EObject> _eCrossReferences = interface_.eCrossReferences();
        for (final EObject interfaceRealization__candidate_1 : _eCrossReferences) {
          if (((interfaceRealization__candidate_1 != null) && (interfaceRealization__candidate_1 instanceof InterfaceRealization))) {
            InterfaceRealization interfaceRealization__2 = ((InterfaceRealization) interfaceRealization__candidate_1);
            Interface _contract = interfaceRealization__2.getContract();
            boolean _tripleEquals = (interface_ == _contract);
            if (_tripleEquals) {
              EObject implementation__candidate = interfaceRealization__2.eContainer();
              if (((implementation__candidate != null) && (implementation__candidate instanceof org.eclipse.uml2.uml.Class))) {
                org.eclipse.uml2.uml.Class implementation__1 = ((org.eclipse.uml2.uml.Class) implementation__candidate);
                {
                  if ((routineName == "updateProvidedRoleName")) {
                    _routinesFacade.updateProvidedRoleName(interfaceRealization__2, implementation__1, interface_);
                  }
                  return;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public ProvidedRole_BidirectionalCheckRoutine(final mir.routines.umlXpcmRoles_L2R.RoutinesFacade routinesFacade, final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy, final EObject affectedEObject, final String routineName) {
    super(routinesFacade, reactionExecutionState, calledBy);
    this.userExecution = new mir.routines.umlXpcmRoles_L2R.ProvidedRole_BidirectionalCheckRoutine.ActionUserExecution(getExecutionState(), this);
    this.affectedEObject = affectedEObject;this.routineName = routineName;
  }
  
  private EObject affectedEObject;
  
  private String routineName;
  
  protected boolean executeRoutine() throws IOException {
    getLogger().debug("Called routine ProvidedRole_BidirectionalCheckRoutine with input:");
    getLogger().debug("   affectedEObject: " + this.affectedEObject);
    getLogger().debug("   routineName: " + this.routineName);
    
    userExecution.callRoutine1(affectedEObject, routineName, this.getRoutinesFacade());
    
    postprocessElements();
    
    return true;
  }
}
