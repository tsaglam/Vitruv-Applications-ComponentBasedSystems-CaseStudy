package mir.routines.umlXpcmRoles_L2R;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TypedElement;
import org.palladiosimulator.pcm.core.entity.InterfaceProvidingRequiringEntity;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationRequiredRole;
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
  
  public boolean updateRequiredRoleName(final Property property, final Parameter parameter, final org.eclipse.uml2.uml.Class implementation, final Interface interface_, final Operation operation) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.UpdateRequiredRoleNameRoutine routine = new mir.routines.umlXpcmRoles_L2R.UpdateRequiredRoleNameRoutine(_routinesFacade, _reactionExecutionState, _caller, property, parameter, implementation, interface_, operation);
    return routine.applyRoutine();
  }
  
  public boolean changeTypeOfCorrespondingRequiredRole(final Property property, final Parameter parameter, final org.eclipse.uml2.uml.Class implementation, final Interface interface_, final Operation operation) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.ChangeTypeOfCorrespondingRequiredRoleRoutine routine = new mir.routines.umlXpcmRoles_L2R.ChangeTypeOfCorrespondingRequiredRoleRoutine(_routinesFacade, _reactionExecutionState, _caller, property, parameter, implementation, interface_, operation);
    return routine.applyRoutine();
  }
  
  public boolean requiredRole_BidirectionalUpdate(final Property property_, final Parameter parameter_, final org.eclipse.uml2.uml.Class implementation_, final Interface interface_, final Operation operation_) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.RequiredRole_BidirectionalUpdateRoutine routine = new mir.routines.umlXpcmRoles_L2R.RequiredRole_BidirectionalUpdateRoutine(_routinesFacade, _reactionExecutionState, _caller, property_, parameter_, implementation_, interface_, operation_);
    return routine.applyRoutine();
  }
  
  public boolean requiredRole_CreateMapping(final Property property_, final Parameter parameter_, final org.eclipse.uml2.uml.Class implementation_, final Interface interface_, final Operation operation_) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.RequiredRole_CreateMappingRoutine routine = new mir.routines.umlXpcmRoles_L2R.RequiredRole_CreateMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, property_, parameter_, implementation_, interface_, operation_);
    return routine.applyRoutine();
  }
  
  public boolean requiredRole_DeleteMapping(final OperationRequiredRole role_, final OperationInterface operationInterface_, final InterfaceProvidingRequiringEntity requiringEntity_) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.RequiredRole_DeleteMappingRoutine routine = new mir.routines.umlXpcmRoles_L2R.RequiredRole_DeleteMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, role_, operationInterface_, requiringEntity_);
    return routine.applyRoutine();
  }
  
  public boolean requiredRole_BidirectionalCheck(final EObject affectedEObject, final String routineName) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.RequiredRole_BidirectionalCheckRoutine routine = new mir.routines.umlXpcmRoles_L2R.RequiredRole_BidirectionalCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject, routineName);
    return routine.applyRoutine();
  }
  
  public boolean requiredRole_ElementCreatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.RequiredRole_ElementCreatedCheckRoutine routine = new mir.routines.umlXpcmRoles_L2R.RequiredRole_ElementCreatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean requiredRole_ElementDeletedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.RequiredRole_ElementDeletedCheckRoutine routine = new mir.routines.umlXpcmRoles_L2R.RequiredRole_ElementDeletedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean requiredRole_ElementUpdatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.RequiredRole_ElementUpdatedCheckRoutine routine = new mir.routines.umlXpcmRoles_L2R.RequiredRole_ElementUpdatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean updateProvidedRoleName(final InterfaceRealization interfaceRealization, final org.eclipse.uml2.uml.Class implementation, final Interface interface_) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.UpdateProvidedRoleNameRoutine routine = new mir.routines.umlXpcmRoles_L2R.UpdateProvidedRoleNameRoutine(_routinesFacade, _reactionExecutionState, _caller, interfaceRealization, implementation, interface_);
    return routine.applyRoutine();
  }
  
  public boolean providedRole_BidirectionalUpdate(final InterfaceRealization interfaceRealization_, final org.eclipse.uml2.uml.Class implementation_, final Interface interface_) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.ProvidedRole_BidirectionalUpdateRoutine routine = new mir.routines.umlXpcmRoles_L2R.ProvidedRole_BidirectionalUpdateRoutine(_routinesFacade, _reactionExecutionState, _caller, interfaceRealization_, implementation_, interface_);
    return routine.applyRoutine();
  }
  
  public boolean providedRole_CreateMapping(final InterfaceRealization interfaceRealization_, final org.eclipse.uml2.uml.Class implementation_, final Interface interface_) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.ProvidedRole_CreateMappingRoutine routine = new mir.routines.umlXpcmRoles_L2R.ProvidedRole_CreateMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, interfaceRealization_, implementation_, interface_);
    return routine.applyRoutine();
  }
  
  public boolean providedRole_DeleteMapping(final OperationProvidedRole role_, final OperationInterface operationInterface_, final InterfaceProvidingRequiringEntity providingEntity_) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.ProvidedRole_DeleteMappingRoutine routine = new mir.routines.umlXpcmRoles_L2R.ProvidedRole_DeleteMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, role_, operationInterface_, providingEntity_);
    return routine.applyRoutine();
  }
  
  public boolean providedRole_BidirectionalCheck(final EObject affectedEObject, final String routineName) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.ProvidedRole_BidirectionalCheckRoutine routine = new mir.routines.umlXpcmRoles_L2R.ProvidedRole_BidirectionalCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject, routineName);
    return routine.applyRoutine();
  }
  
  public boolean providedRole_ElementCreatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.ProvidedRole_ElementCreatedCheckRoutine routine = new mir.routines.umlXpcmRoles_L2R.ProvidedRole_ElementCreatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean providedRole_ElementDeletedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.ProvidedRole_ElementDeletedCheckRoutine routine = new mir.routines.umlXpcmRoles_L2R.ProvidedRole_ElementDeletedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean providedRole_ElementUpdatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.ProvidedRole_ElementUpdatedCheckRoutine routine = new mir.routines.umlXpcmRoles_L2R.ProvidedRole_ElementUpdatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean onRequiredRoleNameReplacedAtProperty_nameBidirectionalRepair(final Property affectedEObject) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.OnRequiredRoleNameReplacedAtProperty_nameBidirectionalRepairRoutine routine = new mir.routines.umlXpcmRoles_L2R.OnRequiredRoleNameReplacedAtProperty_nameBidirectionalRepairRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean onRequiredRoleNameReplacedAtParameter_nameBidirectionalRepair(final Parameter affectedEObject) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.OnRequiredRoleNameReplacedAtParameter_nameBidirectionalRepairRoutine routine = new mir.routines.umlXpcmRoles_L2R.OnRequiredRoleNameReplacedAtParameter_nameBidirectionalRepairRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean onRequiredRoleElementReplacedAtParameter_typeBidirectionalRepair(final TypedElement affectedEObject) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.OnRequiredRoleElementReplacedAtParameter_typeBidirectionalRepairRoutine routine = new mir.routines.umlXpcmRoles_L2R.OnRequiredRoleElementReplacedAtParameter_typeBidirectionalRepairRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean onProvidedRoleNameReplacedAtInterfaceRealization_nameBidirectionalRepair(final InterfaceRealization affectedEObject) {
    mir.routines.umlXpcmRoles_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_L2R.OnProvidedRoleNameReplacedAtInterfaceRealization_nameBidirectionalRepairRoutine routine = new mir.routines.umlXpcmRoles_L2R.OnProvidedRoleNameReplacedAtInterfaceRealization_nameBidirectionalRepairRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
}
