package mir.routines.umlXpcmRoles_R2L;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
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
  
  public boolean updateRequiredRoleCorrespondingUmlNames(final OperationRequiredRole role, final OperationInterface operationInterface, final InterfaceProvidingRequiringEntity requiringEntity) {
    mir.routines.umlXpcmRoles_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_R2L.UpdateRequiredRoleCorrespondingUmlNamesRoutine routine = new mir.routines.umlXpcmRoles_R2L.UpdateRequiredRoleCorrespondingUmlNamesRoutine(_routinesFacade, _reactionExecutionState, _caller, role, operationInterface, requiringEntity);
    return routine.applyRoutine();
  }
  
  public boolean requiredRole_BidirectionalUpdate(final OperationRequiredRole role_, final OperationInterface operationInterface_, final InterfaceProvidingRequiringEntity requiringEntity_) {
    mir.routines.umlXpcmRoles_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_R2L.RequiredRole_BidirectionalUpdateRoutine routine = new mir.routines.umlXpcmRoles_R2L.RequiredRole_BidirectionalUpdateRoutine(_routinesFacade, _reactionExecutionState, _caller, role_, operationInterface_, requiringEntity_);
    return routine.applyRoutine();
  }
  
  public boolean requiredRole_CreateMapping(final OperationRequiredRole role_, final OperationInterface operationInterface_, final InterfaceProvidingRequiringEntity requiringEntity_) {
    mir.routines.umlXpcmRoles_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_R2L.RequiredRole_CreateMappingRoutine routine = new mir.routines.umlXpcmRoles_R2L.RequiredRole_CreateMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, role_, operationInterface_, requiringEntity_);
    return routine.applyRoutine();
  }
  
  public boolean requiredRole_DeleteMapping(final Property property_, final Parameter parameter_, final org.eclipse.uml2.uml.Class implementation_, final Interface interface_, final Operation operation_) {
    mir.routines.umlXpcmRoles_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_R2L.RequiredRole_DeleteMappingRoutine routine = new mir.routines.umlXpcmRoles_R2L.RequiredRole_DeleteMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, property_, parameter_, implementation_, interface_, operation_);
    return routine.applyRoutine();
  }
  
  public boolean requiredRole_BidirectionalCheck(final EObject affectedEObject, final String routineName) {
    mir.routines.umlXpcmRoles_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_R2L.RequiredRole_BidirectionalCheckRoutine routine = new mir.routines.umlXpcmRoles_R2L.RequiredRole_BidirectionalCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject, routineName);
    return routine.applyRoutine();
  }
  
  public boolean requiredRole_ElementCreatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmRoles_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_R2L.RequiredRole_ElementCreatedCheckRoutine routine = new mir.routines.umlXpcmRoles_R2L.RequiredRole_ElementCreatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean requiredRole_ElementDeletedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmRoles_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_R2L.RequiredRole_ElementDeletedCheckRoutine routine = new mir.routines.umlXpcmRoles_R2L.RequiredRole_ElementDeletedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean requiredRole_ElementUpdatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmRoles_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_R2L.RequiredRole_ElementUpdatedCheckRoutine routine = new mir.routines.umlXpcmRoles_R2L.RequiredRole_ElementUpdatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean updateInterfaceRealizationName(final OperationProvidedRole role, final OperationInterface operationInterface, final InterfaceProvidingRequiringEntity providingEntity) {
    mir.routines.umlXpcmRoles_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_R2L.UpdateInterfaceRealizationNameRoutine routine = new mir.routines.umlXpcmRoles_R2L.UpdateInterfaceRealizationNameRoutine(_routinesFacade, _reactionExecutionState, _caller, role, operationInterface, providingEntity);
    return routine.applyRoutine();
  }
  
  public boolean providedRole_BidirectionalUpdate(final OperationProvidedRole role_, final OperationInterface operationInterface_, final InterfaceProvidingRequiringEntity providingEntity_) {
    mir.routines.umlXpcmRoles_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_R2L.ProvidedRole_BidirectionalUpdateRoutine routine = new mir.routines.umlXpcmRoles_R2L.ProvidedRole_BidirectionalUpdateRoutine(_routinesFacade, _reactionExecutionState, _caller, role_, operationInterface_, providingEntity_);
    return routine.applyRoutine();
  }
  
  public boolean providedRole_CreateMapping(final OperationProvidedRole role_, final OperationInterface operationInterface_, final InterfaceProvidingRequiringEntity providingEntity_) {
    mir.routines.umlXpcmRoles_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_R2L.ProvidedRole_CreateMappingRoutine routine = new mir.routines.umlXpcmRoles_R2L.ProvidedRole_CreateMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, role_, operationInterface_, providingEntity_);
    return routine.applyRoutine();
  }
  
  public boolean providedRole_DeleteMapping(final InterfaceRealization interfaceRealization_, final org.eclipse.uml2.uml.Class implementation_, final Interface interface_) {
    mir.routines.umlXpcmRoles_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_R2L.ProvidedRole_DeleteMappingRoutine routine = new mir.routines.umlXpcmRoles_R2L.ProvidedRole_DeleteMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, interfaceRealization_, implementation_, interface_);
    return routine.applyRoutine();
  }
  
  public boolean providedRole_BidirectionalCheck(final EObject affectedEObject, final String routineName) {
    mir.routines.umlXpcmRoles_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_R2L.ProvidedRole_BidirectionalCheckRoutine routine = new mir.routines.umlXpcmRoles_R2L.ProvidedRole_BidirectionalCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject, routineName);
    return routine.applyRoutine();
  }
  
  public boolean providedRole_ElementCreatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmRoles_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_R2L.ProvidedRole_ElementCreatedCheckRoutine routine = new mir.routines.umlXpcmRoles_R2L.ProvidedRole_ElementCreatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean providedRole_ElementDeletedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmRoles_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_R2L.ProvidedRole_ElementDeletedCheckRoutine routine = new mir.routines.umlXpcmRoles_R2L.ProvidedRole_ElementDeletedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean providedRole_ElementUpdatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmRoles_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_R2L.ProvidedRole_ElementUpdatedCheckRoutine routine = new mir.routines.umlXpcmRoles_R2L.ProvidedRole_ElementUpdatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean onRequiredRoleEntityNameReplacedAtOperationRequiredRole_entityNameBidirectionalRepair(final OperationRequiredRole affectedEObject) {
    mir.routines.umlXpcmRoles_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_R2L.OnRequiredRoleEntityNameReplacedAtOperationRequiredRole_entityNameBidirectionalRepairRoutine routine = new mir.routines.umlXpcmRoles_R2L.OnRequiredRoleEntityNameReplacedAtOperationRequiredRole_entityNameBidirectionalRepairRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean onProvidedRoleEntityNameReplacedAtOperationProvidedRole_entityNameBidirectionalRepair(final OperationProvidedRole affectedEObject) {
    mir.routines.umlXpcmRoles_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRoles_R2L.OnProvidedRoleEntityNameReplacedAtOperationProvidedRole_entityNameBidirectionalRepairRoutine routine = new mir.routines.umlXpcmRoles_R2L.OnProvidedRoleEntityNameReplacedAtOperationProvidedRole_entityNameBidirectionalRepairRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
}
