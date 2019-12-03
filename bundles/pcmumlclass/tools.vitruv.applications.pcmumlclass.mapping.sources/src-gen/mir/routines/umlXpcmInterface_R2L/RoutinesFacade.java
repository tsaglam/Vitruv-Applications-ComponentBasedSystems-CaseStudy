package mir.routines.umlXpcmInterface_R2L;

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
  
  public boolean updateInterfaceName(final OperationInterface operationInterface, final Repository repository) {
    mir.routines.umlXpcmInterface_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_R2L.UpdateInterfaceNameRoutine routine = new mir.routines.umlXpcmInterface_R2L.UpdateInterfaceNameRoutine(_routinesFacade, _reactionExecutionState, _caller, operationInterface, repository);
    return routine.applyRoutine();
  }
  
  public boolean operationInterface_BidirectionalUpdate(final OperationInterface operationInterface_, final Repository repository_) {
    mir.routines.umlXpcmInterface_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_R2L.OperationInterface_BidirectionalUpdateRoutine routine = new mir.routines.umlXpcmInterface_R2L.OperationInterface_BidirectionalUpdateRoutine(_routinesFacade, _reactionExecutionState, _caller, operationInterface_, repository_);
    return routine.applyRoutine();
  }
  
  public boolean operationInterface_CreateMapping(final OperationInterface operationInterface_, final Repository repository_) {
    mir.routines.umlXpcmInterface_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_R2L.OperationInterface_CreateMappingRoutine routine = new mir.routines.umlXpcmInterface_R2L.OperationInterface_CreateMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, operationInterface_, repository_);
    return routine.applyRoutine();
  }
  
  public boolean operationInterface_DeleteMapping(final Interface interface_, final org.eclipse.uml2.uml.Package contractsPackage_) {
    mir.routines.umlXpcmInterface_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_R2L.OperationInterface_DeleteMappingRoutine routine = new mir.routines.umlXpcmInterface_R2L.OperationInterface_DeleteMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, interface_, contractsPackage_);
    return routine.applyRoutine();
  }
  
  public boolean operationInterface_BidirectionalCheck(final EObject affectedEObject, final String routineName) {
    mir.routines.umlXpcmInterface_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_R2L.OperationInterface_BidirectionalCheckRoutine routine = new mir.routines.umlXpcmInterface_R2L.OperationInterface_BidirectionalCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject, routineName);
    return routine.applyRoutine();
  }
  
  public boolean operationInterface_ElementCreatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmInterface_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_R2L.OperationInterface_ElementCreatedCheckRoutine routine = new mir.routines.umlXpcmInterface_R2L.OperationInterface_ElementCreatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean operationInterface_ElementDeletedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmInterface_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_R2L.OperationInterface_ElementDeletedCheckRoutine routine = new mir.routines.umlXpcmInterface_R2L.OperationInterface_ElementDeletedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean operationInterface_ElementUpdatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmInterface_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_R2L.OperationInterface_ElementUpdatedCheckRoutine routine = new mir.routines.umlXpcmInterface_R2L.OperationInterface_ElementUpdatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean operationInterfaceParent_BidirectionalUpdate(final OperationInterface operationInterface_, final OperationInterface parentInterface_) {
    mir.routines.umlXpcmInterface_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_R2L.OperationInterfaceParent_BidirectionalUpdateRoutine routine = new mir.routines.umlXpcmInterface_R2L.OperationInterfaceParent_BidirectionalUpdateRoutine(_routinesFacade, _reactionExecutionState, _caller, operationInterface_, parentInterface_);
    return routine.applyRoutine();
  }
  
  public boolean operationInterfaceParent_CreateMapping(final OperationInterface operationInterface_, final OperationInterface parentInterface_) {
    mir.routines.umlXpcmInterface_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_R2L.OperationInterfaceParent_CreateMappingRoutine routine = new mir.routines.umlXpcmInterface_R2L.OperationInterfaceParent_CreateMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, operationInterface_, parentInterface_);
    return routine.applyRoutine();
  }
  
  public boolean operationInterfaceParent_DeleteMapping(final Interface interface_, final Generalization generalization_) {
    mir.routines.umlXpcmInterface_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_R2L.OperationInterfaceParent_DeleteMappingRoutine routine = new mir.routines.umlXpcmInterface_R2L.OperationInterfaceParent_DeleteMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, interface_, generalization_);
    return routine.applyRoutine();
  }
  
  public boolean operationInterfaceParent_BidirectionalCheck(final EObject affectedEObject, final String routineName) {
    mir.routines.umlXpcmInterface_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_R2L.OperationInterfaceParent_BidirectionalCheckRoutine routine = new mir.routines.umlXpcmInterface_R2L.OperationInterfaceParent_BidirectionalCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject, routineName);
    return routine.applyRoutine();
  }
  
  public boolean operationInterfaceParent_ElementCreatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmInterface_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_R2L.OperationInterfaceParent_ElementCreatedCheckRoutine routine = new mir.routines.umlXpcmInterface_R2L.OperationInterfaceParent_ElementCreatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean operationInterfaceParent_ElementDeletedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmInterface_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_R2L.OperationInterfaceParent_ElementDeletedCheckRoutine routine = new mir.routines.umlXpcmInterface_R2L.OperationInterfaceParent_ElementDeletedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean operationInterfaceParent_ElementUpdatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmInterface_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_R2L.OperationInterfaceParent_ElementUpdatedCheckRoutine routine = new mir.routines.umlXpcmInterface_R2L.OperationInterfaceParent_ElementUpdatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean onOperationInterfaceEntityNameReplacedAtOperationInterface_entityNameBidirectionalRepair(final OperationInterface affectedEObject) {
    mir.routines.umlXpcmInterface_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmInterface_R2L.OnOperationInterfaceEntityNameReplacedAtOperationInterface_entityNameBidirectionalRepairRoutine routine = new mir.routines.umlXpcmInterface_R2L.OnOperationInterfaceEntityNameReplacedAtOperationInterface_entityNameBidirectionalRepairRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
}
