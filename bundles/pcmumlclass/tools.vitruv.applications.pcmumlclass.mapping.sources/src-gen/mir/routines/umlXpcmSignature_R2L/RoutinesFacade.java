package mir.routines.umlXpcmSignature_R2L;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.palladiosimulator.pcm.repository.DataType;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.OperationSignature;
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
  
  public boolean updateSignatureUmlName(final OperationSignature operationSignature, final DataType returnType, final OperationInterface operationInterface) {
    mir.routines.umlXpcmSignature_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_R2L.UpdateSignatureUmlNameRoutine routine = new mir.routines.umlXpcmSignature_R2L.UpdateSignatureUmlNameRoutine(_routinesFacade, _reactionExecutionState, _caller, operationSignature, returnType, operationInterface);
    return routine.applyRoutine();
  }
  
  public boolean updateSignatureUmlReturnType(final OperationSignature operationSignature, final DataType returnType, final OperationInterface operationInterface) {
    mir.routines.umlXpcmSignature_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_R2L.UpdateSignatureUmlReturnTypeRoutine routine = new mir.routines.umlXpcmSignature_R2L.UpdateSignatureUmlReturnTypeRoutine(_routinesFacade, _reactionExecutionState, _caller, operationSignature, returnType, operationInterface);
    return routine.applyRoutine();
  }
  
  public boolean signature_BidirectionalUpdate(final OperationSignature operationSignature_, final DataType returnType_, final OperationInterface operationInterface_) {
    mir.routines.umlXpcmSignature_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_R2L.Signature_BidirectionalUpdateRoutine routine = new mir.routines.umlXpcmSignature_R2L.Signature_BidirectionalUpdateRoutine(_routinesFacade, _reactionExecutionState, _caller, operationSignature_, returnType_, operationInterface_);
    return routine.applyRoutine();
  }
  
  public boolean signature_CreateMapping(final OperationSignature operationSignature_, final DataType returnType_, final OperationInterface operationInterface_) {
    mir.routines.umlXpcmSignature_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_R2L.Signature_CreateMappingRoutine routine = new mir.routines.umlXpcmSignature_R2L.Signature_CreateMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, operationSignature_, returnType_, operationInterface_);
    return routine.applyRoutine();
  }
  
  public boolean signature_DeleteMapping(final Operation operation_, final Parameter returnParameter_, final Interface interface_) {
    mir.routines.umlXpcmSignature_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_R2L.Signature_DeleteMappingRoutine routine = new mir.routines.umlXpcmSignature_R2L.Signature_DeleteMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, operation_, returnParameter_, interface_);
    return routine.applyRoutine();
  }
  
  public boolean signature_BidirectionalCheck(final EObject affectedEObject, final String routineName) {
    mir.routines.umlXpcmSignature_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_R2L.Signature_BidirectionalCheckRoutine routine = new mir.routines.umlXpcmSignature_R2L.Signature_BidirectionalCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject, routineName);
    return routine.applyRoutine();
  }
  
  public boolean signature_ElementCreatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmSignature_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_R2L.Signature_ElementCreatedCheckRoutine routine = new mir.routines.umlXpcmSignature_R2L.Signature_ElementCreatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean signature_ElementDeletedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmSignature_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_R2L.Signature_ElementDeletedCheckRoutine routine = new mir.routines.umlXpcmSignature_R2L.Signature_ElementDeletedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean signature_ElementUpdatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmSignature_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_R2L.Signature_ElementUpdatedCheckRoutine routine = new mir.routines.umlXpcmSignature_R2L.Signature_ElementUpdatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean onSignatureEntityNameReplacedAtOperationSignature_entityNameBidirectionalRepair(final OperationSignature affectedEObject) {
    mir.routines.umlXpcmSignature_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_R2L.OnSignatureEntityNameReplacedAtOperationSignature_entityNameBidirectionalRepairRoutine routine = new mir.routines.umlXpcmSignature_R2L.OnSignatureEntityNameReplacedAtOperationSignature_entityNameBidirectionalRepairRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean onSignatureElementReplacedAtOperationSignature_returnType__OperationSignatureBidirectionalRepair(final OperationSignature affectedEObject) {
    mir.routines.umlXpcmSignature_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_R2L.OnSignatureElementReplacedAtOperationSignature_returnType__OperationSignatureBidirectionalRepairRoutine routine = new mir.routines.umlXpcmSignature_R2L.OnSignatureElementReplacedAtOperationSignature_returnType__OperationSignatureBidirectionalRepairRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
}
