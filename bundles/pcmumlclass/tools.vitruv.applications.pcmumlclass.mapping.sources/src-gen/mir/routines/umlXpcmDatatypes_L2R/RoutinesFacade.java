package mir.routines.umlXpcmDatatypes_L2R;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Generalization;
import org.palladiosimulator.pcm.repository.CompositeDataType;
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
  
  public boolean updateCompositeDataTypeName(final org.eclipse.uml2.uml.Class class_, final org.eclipse.uml2.uml.Package datatypesPackage) {
    mir.routines.umlXpcmDatatypes_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmDatatypes_L2R.UpdateCompositeDataTypeNameRoutine routine = new mir.routines.umlXpcmDatatypes_L2R.UpdateCompositeDataTypeNameRoutine(_routinesFacade, _reactionExecutionState, _caller, class_, datatypesPackage);
    return routine.applyRoutine();
  }
  
  public boolean compositeDataype_BidirectionalUpdate(final org.eclipse.uml2.uml.Class class_, final org.eclipse.uml2.uml.Package datatypesPackage_) {
    mir.routines.umlXpcmDatatypes_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmDatatypes_L2R.CompositeDataype_BidirectionalUpdateRoutine routine = new mir.routines.umlXpcmDatatypes_L2R.CompositeDataype_BidirectionalUpdateRoutine(_routinesFacade, _reactionExecutionState, _caller, class_, datatypesPackage_);
    return routine.applyRoutine();
  }
  
  public boolean compositeDataype_CreateMapping(final org.eclipse.uml2.uml.Class class_, final org.eclipse.uml2.uml.Package datatypesPackage_) {
    mir.routines.umlXpcmDatatypes_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmDatatypes_L2R.CompositeDataype_CreateMappingRoutine routine = new mir.routines.umlXpcmDatatypes_L2R.CompositeDataype_CreateMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, class_, datatypesPackage_);
    return routine.applyRoutine();
  }
  
  public boolean compositeDataype_DeleteMapping(final CompositeDataType type_, final Repository repository_) {
    mir.routines.umlXpcmDatatypes_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmDatatypes_L2R.CompositeDataype_DeleteMappingRoutine routine = new mir.routines.umlXpcmDatatypes_L2R.CompositeDataype_DeleteMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, type_, repository_);
    return routine.applyRoutine();
  }
  
  public boolean compositeDataype_BidirectionalCheck(final EObject affectedEObject, final String routineName) {
    mir.routines.umlXpcmDatatypes_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmDatatypes_L2R.CompositeDataype_BidirectionalCheckRoutine routine = new mir.routines.umlXpcmDatatypes_L2R.CompositeDataype_BidirectionalCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject, routineName);
    return routine.applyRoutine();
  }
  
  public boolean compositeDataype_ElementCreatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmDatatypes_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmDatatypes_L2R.CompositeDataype_ElementCreatedCheckRoutine routine = new mir.routines.umlXpcmDatatypes_L2R.CompositeDataype_ElementCreatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean compositeDataype_ElementDeletedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmDatatypes_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmDatatypes_L2R.CompositeDataype_ElementDeletedCheckRoutine routine = new mir.routines.umlXpcmDatatypes_L2R.CompositeDataype_ElementDeletedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean compositeDataype_ElementUpdatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmDatatypes_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmDatatypes_L2R.CompositeDataype_ElementUpdatedCheckRoutine routine = new mir.routines.umlXpcmDatatypes_L2R.CompositeDataype_ElementUpdatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean compositeDatatypeParent_BidirectionalUpdate(final org.eclipse.uml2.uml.Class class_, final Generalization generalization_) {
    mir.routines.umlXpcmDatatypes_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmDatatypes_L2R.CompositeDatatypeParent_BidirectionalUpdateRoutine routine = new mir.routines.umlXpcmDatatypes_L2R.CompositeDatatypeParent_BidirectionalUpdateRoutine(_routinesFacade, _reactionExecutionState, _caller, class_, generalization_);
    return routine.applyRoutine();
  }
  
  public boolean compositeDatatypeParent_CreateMapping(final org.eclipse.uml2.uml.Class class_, final Generalization generalization_) {
    mir.routines.umlXpcmDatatypes_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmDatatypes_L2R.CompositeDatatypeParent_CreateMappingRoutine routine = new mir.routines.umlXpcmDatatypes_L2R.CompositeDatatypeParent_CreateMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, class_, generalization_);
    return routine.applyRoutine();
  }
  
  public boolean compositeDatatypeParent_DeleteMapping(final CompositeDataType type_, final CompositeDataType parentType_) {
    mir.routines.umlXpcmDatatypes_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmDatatypes_L2R.CompositeDatatypeParent_DeleteMappingRoutine routine = new mir.routines.umlXpcmDatatypes_L2R.CompositeDatatypeParent_DeleteMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, type_, parentType_);
    return routine.applyRoutine();
  }
  
  public boolean compositeDatatypeParent_BidirectionalCheck(final EObject affectedEObject, final String routineName) {
    mir.routines.umlXpcmDatatypes_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmDatatypes_L2R.CompositeDatatypeParent_BidirectionalCheckRoutine routine = new mir.routines.umlXpcmDatatypes_L2R.CompositeDatatypeParent_BidirectionalCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject, routineName);
    return routine.applyRoutine();
  }
  
  public boolean compositeDatatypeParent_ElementCreatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmDatatypes_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmDatatypes_L2R.CompositeDatatypeParent_ElementCreatedCheckRoutine routine = new mir.routines.umlXpcmDatatypes_L2R.CompositeDatatypeParent_ElementCreatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean compositeDatatypeParent_ElementDeletedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmDatatypes_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmDatatypes_L2R.CompositeDatatypeParent_ElementDeletedCheckRoutine routine = new mir.routines.umlXpcmDatatypes_L2R.CompositeDatatypeParent_ElementDeletedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean compositeDatatypeParent_ElementUpdatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmDatatypes_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmDatatypes_L2R.CompositeDatatypeParent_ElementUpdatedCheckRoutine routine = new mir.routines.umlXpcmDatatypes_L2R.CompositeDatatypeParent_ElementUpdatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean onCompositeDataypeNameReplacedAtClass_nameBidirectionalRepair(final org.eclipse.uml2.uml.Class affectedEObject) {
    mir.routines.umlXpcmDatatypes_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmDatatypes_L2R.OnCompositeDataypeNameReplacedAtClass_nameBidirectionalRepairRoutine routine = new mir.routines.umlXpcmDatatypes_L2R.OnCompositeDataypeNameReplacedAtClass_nameBidirectionalRepairRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
}
