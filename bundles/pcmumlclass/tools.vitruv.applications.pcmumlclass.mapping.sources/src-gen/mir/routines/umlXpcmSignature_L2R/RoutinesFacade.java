package mir.routines.umlXpcmSignature_L2R;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.TypedElement;
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
  
  public boolean updateSignaturePcmName(final Operation operation, final Parameter returnParameter, final Interface interface_) {
    mir.routines.umlXpcmSignature_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_L2R.UpdateSignaturePcmNameRoutine routine = new mir.routines.umlXpcmSignature_L2R.UpdateSignaturePcmNameRoutine(_routinesFacade, _reactionExecutionState, _caller, operation, returnParameter, interface_);
    return routine.applyRoutine();
  }
  
  public boolean updateSignaturePcmReturnType(final Operation operation, final Parameter returnParameter, final Interface interface_) {
    mir.routines.umlXpcmSignature_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_L2R.UpdateSignaturePcmReturnTypeRoutine routine = new mir.routines.umlXpcmSignature_L2R.UpdateSignaturePcmReturnTypeRoutine(_routinesFacade, _reactionExecutionState, _caller, operation, returnParameter, interface_);
    return routine.applyRoutine();
  }
  
  public boolean signature_BidirectionalUpdate(final Operation operation_, final Parameter returnParameter_, final Interface interface_) {
    mir.routines.umlXpcmSignature_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_L2R.Signature_BidirectionalUpdateRoutine routine = new mir.routines.umlXpcmSignature_L2R.Signature_BidirectionalUpdateRoutine(_routinesFacade, _reactionExecutionState, _caller, operation_, returnParameter_, interface_);
    return routine.applyRoutine();
  }
  
  public boolean signature_CreateMapping(final Operation operation_, final Parameter returnParameter_, final Interface interface_) {
    mir.routines.umlXpcmSignature_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_L2R.Signature_CreateMappingRoutine routine = new mir.routines.umlXpcmSignature_L2R.Signature_CreateMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, operation_, returnParameter_, interface_);
    return routine.applyRoutine();
  }
  
  public boolean signature_DeleteMapping(final OperationSignature operationSignature_, final DataType returnType_, final OperationInterface operationInterface_) {
    mir.routines.umlXpcmSignature_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_L2R.Signature_DeleteMappingRoutine routine = new mir.routines.umlXpcmSignature_L2R.Signature_DeleteMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, operationSignature_, returnType_, operationInterface_);
    return routine.applyRoutine();
  }
  
  public boolean signature_BidirectionalCheck(final EObject affectedEObject, final String routineName) {
    mir.routines.umlXpcmSignature_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_L2R.Signature_BidirectionalCheckRoutine routine = new mir.routines.umlXpcmSignature_L2R.Signature_BidirectionalCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject, routineName);
    return routine.applyRoutine();
  }
  
  public boolean signature_ElementCreatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmSignature_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_L2R.Signature_ElementCreatedCheckRoutine routine = new mir.routines.umlXpcmSignature_L2R.Signature_ElementCreatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean signature_ElementDeletedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmSignature_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_L2R.Signature_ElementDeletedCheckRoutine routine = new mir.routines.umlXpcmSignature_L2R.Signature_ElementDeletedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean signature_ElementUpdatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmSignature_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_L2R.Signature_ElementUpdatedCheckRoutine routine = new mir.routines.umlXpcmSignature_L2R.Signature_ElementUpdatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean onSignatureNameReplacedAtOperation_nameBidirectionalRepair(final Operation affectedEObject) {
    mir.routines.umlXpcmSignature_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_L2R.OnSignatureNameReplacedAtOperation_nameBidirectionalRepairRoutine routine = new mir.routines.umlXpcmSignature_L2R.OnSignatureNameReplacedAtOperation_nameBidirectionalRepairRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean onSignatureElementReplacedAtParameter_typeBidirectionalRepair(final TypedElement affectedEObject) {
    mir.routines.umlXpcmSignature_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmSignature_L2R.OnSignatureElementReplacedAtParameter_typeBidirectionalRepairRoutine routine = new mir.routines.umlXpcmSignature_L2R.OnSignatureElementReplacedAtParameter_typeBidirectionalRepairRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
}
