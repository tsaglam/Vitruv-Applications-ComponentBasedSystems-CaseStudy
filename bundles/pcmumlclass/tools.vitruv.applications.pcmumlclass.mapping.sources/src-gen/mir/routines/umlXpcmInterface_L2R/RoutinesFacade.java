package mir.routines.umlXpcmInterface_L2R;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.Repository;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutinesFacade;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.RoutinesFacadeExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.RoutinesFacadesProvider;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;
import tools.vitruv.extensions.dslsruntime.reactions.structure.ReactionsImportPath;

@SuppressWarnings("all")
public class RoutinesFacade extends AbstractRepairRoutinesFacade {
  public RoutinesFacade(final RoutinesFacadesProvider routinesFacadesProvider, final ReactionsImportPath reactionsImportPath, final RoutinesFacadeExecutionState executionState) {
    super(routinesFacadesProvider, reactionsImportPath, executionState);
  }
  
  public boolean updateOperationInterfaceName(final Interface interface_, final org.eclipse.uml2.uml.Package contractsPackage) {
    mir.routines.umlXpcmInterface_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_L2R.UpdateOperationInterfaceNameRoutine routine = new mir.routines.umlXpcmInterface_L2R.UpdateOperationInterfaceNameRoutine(_routinesFacade, _reactionExecutionState, _caller, interface_, contractsPackage);
    return routine.applyRoutine();
  }
  
  public boolean operationInterface_BidirectionalUpdate(final Interface interface_, final org.eclipse.uml2.uml.Package contractsPackage_) {
    mir.routines.umlXpcmInterface_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_L2R.OperationInterface_BidirectionalUpdateRoutine routine = new mir.routines.umlXpcmInterface_L2R.OperationInterface_BidirectionalUpdateRoutine(_routinesFacade, _reactionExecutionState, _caller, interface_, contractsPackage_);
    return routine.applyRoutine();
  }
  
  public boolean operationInterface_CreateMapping(final Interface interface_, final org.eclipse.uml2.uml.Package contractsPackage_) {
    mir.routines.umlXpcmInterface_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_L2R.OperationInterface_CreateMappingRoutine routine = new mir.routines.umlXpcmInterface_L2R.OperationInterface_CreateMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, interface_, contractsPackage_);
    return routine.applyRoutine();
  }
  
  public boolean operationInterface_DeleteMapping(final OperationInterface operationInterface_, final Repository repository_) {
    mir.routines.umlXpcmInterface_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_L2R.OperationInterface_DeleteMappingRoutine routine = new mir.routines.umlXpcmInterface_L2R.OperationInterface_DeleteMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, operationInterface_, repository_);
    return routine.applyRoutine();
  }
  
  public boolean operationInterface_BidirectionalCheck(final EObject affectedEObject, final String routineName) {
    mir.routines.umlXpcmInterface_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_L2R.OperationInterface_BidirectionalCheckRoutine routine = new mir.routines.umlXpcmInterface_L2R.OperationInterface_BidirectionalCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject, routineName);
    return routine.applyRoutine();
  }
  
  public boolean operationInterface_ElementCreatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmInterface_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_L2R.OperationInterface_ElementCreatedCheckRoutine routine = new mir.routines.umlXpcmInterface_L2R.OperationInterface_ElementCreatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean operationInterface_ElementDeletedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmInterface_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_L2R.OperationInterface_ElementDeletedCheckRoutine routine = new mir.routines.umlXpcmInterface_L2R.OperationInterface_ElementDeletedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean operationInterface_ElementUpdatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmInterface_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_L2R.OperationInterface_ElementUpdatedCheckRoutine routine = new mir.routines.umlXpcmInterface_L2R.OperationInterface_ElementUpdatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean operationInterfaceParent_BidirectionalUpdate(final Interface interface_, final Generalization generalization_) {
    mir.routines.umlXpcmInterface_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_L2R.OperationInterfaceParent_BidirectionalUpdateRoutine routine = new mir.routines.umlXpcmInterface_L2R.OperationInterfaceParent_BidirectionalUpdateRoutine(_routinesFacade, _reactionExecutionState, _caller, interface_, generalization_);
    return routine.applyRoutine();
  }
  
  public boolean operationInterfaceParent_CreateMapping(final Interface interface_, final Generalization generalization_) {
    mir.routines.umlXpcmInterface_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_L2R.OperationInterfaceParent_CreateMappingRoutine routine = new mir.routines.umlXpcmInterface_L2R.OperationInterfaceParent_CreateMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, interface_, generalization_);
    return routine.applyRoutine();
  }
  
  public boolean operationInterfaceParent_DeleteMapping(final OperationInterface operationInterface_, final OperationInterface parentInterface_) {
    mir.routines.umlXpcmInterface_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_L2R.OperationInterfaceParent_DeleteMappingRoutine routine = new mir.routines.umlXpcmInterface_L2R.OperationInterfaceParent_DeleteMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, operationInterface_, parentInterface_);
    return routine.applyRoutine();
  }
  
  public boolean operationInterfaceParent_BidirectionalCheck(final EObject affectedEObject, final String routineName) {
    mir.routines.umlXpcmInterface_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_L2R.OperationInterfaceParent_BidirectionalCheckRoutine routine = new mir.routines.umlXpcmInterface_L2R.OperationInterfaceParent_BidirectionalCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject, routineName);
    return routine.applyRoutine();
  }
  
  public boolean operationInterfaceParent_ElementCreatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmInterface_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_L2R.OperationInterfaceParent_ElementCreatedCheckRoutine routine = new mir.routines.umlXpcmInterface_L2R.OperationInterfaceParent_ElementCreatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean operationInterfaceParent_ElementDeletedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmInterface_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_L2R.OperationInterfaceParent_ElementDeletedCheckRoutine routine = new mir.routines.umlXpcmInterface_L2R.OperationInterfaceParent_ElementDeletedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean operationInterfaceParent_ElementUpdatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmInterface_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_L2R.OperationInterfaceParent_ElementUpdatedCheckRoutine routine = new mir.routines.umlXpcmInterface_L2R.OperationInterfaceParent_ElementUpdatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean onOperationInterfaceNameReplacedAtInterface_nameBidirectionalRepair(final Interface affectedEObject) {
    mir.routines.umlXpcmInterface_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_L2R.OnOperationInterfaceNameReplacedAtInterface_nameBidirectionalRepairRoutine routine = new mir.routines.umlXpcmInterface_L2R.OnOperationInterfaceNameReplacedAtInterface_nameBidirectionalRepairRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
}
