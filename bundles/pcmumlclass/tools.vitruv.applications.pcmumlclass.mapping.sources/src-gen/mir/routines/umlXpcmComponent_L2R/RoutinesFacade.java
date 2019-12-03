package mir.routines.umlXpcmComponent_L2R;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Operation;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
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
  
  public boolean updateComponentName(final org.eclipse.uml2.uml.Package componentPackage, final org.eclipse.uml2.uml.Package repositoryPackage, final org.eclipse.uml2.uml.Class implementation, final Operation constructor) {
    mir.routines.umlXpcmComponent_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmComponent_L2R.UpdateComponentNameRoutine routine = new mir.routines.umlXpcmComponent_L2R.UpdateComponentNameRoutine(_routinesFacade, _reactionExecutionState, _caller, componentPackage, repositoryPackage, implementation, constructor);
    return routine.applyRoutine();
  }
  
  public boolean repositoryComponent_BidirectionalUpdate(final org.eclipse.uml2.uml.Package componentPackage_, final org.eclipse.uml2.uml.Package repositoryPackage_, final org.eclipse.uml2.uml.Class implementation_, final Operation constructor_) {
    mir.routines.umlXpcmComponent_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmComponent_L2R.RepositoryComponent_BidirectionalUpdateRoutine routine = new mir.routines.umlXpcmComponent_L2R.RepositoryComponent_BidirectionalUpdateRoutine(_routinesFacade, _reactionExecutionState, _caller, componentPackage_, repositoryPackage_, implementation_, constructor_);
    return routine.applyRoutine();
  }
  
  public boolean repositoryComponent_CreateMapping(final org.eclipse.uml2.uml.Package componentPackage_, final org.eclipse.uml2.uml.Package repositoryPackage_, final org.eclipse.uml2.uml.Class implementation_, final Operation constructor_) {
    mir.routines.umlXpcmComponent_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmComponent_L2R.RepositoryComponent_CreateMappingRoutine routine = new mir.routines.umlXpcmComponent_L2R.RepositoryComponent_CreateMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, componentPackage_, repositoryPackage_, implementation_, constructor_);
    return routine.applyRoutine();
  }
  
  public boolean repositoryComponent_DeleteMapping(final RepositoryComponent component_, final Repository repository_) {
    mir.routines.umlXpcmComponent_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmComponent_L2R.RepositoryComponent_DeleteMappingRoutine routine = new mir.routines.umlXpcmComponent_L2R.RepositoryComponent_DeleteMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, component_, repository_);
    return routine.applyRoutine();
  }
  
  public boolean repositoryComponent_BidirectionalCheck(final EObject affectedEObject, final String routineName) {
    mir.routines.umlXpcmComponent_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmComponent_L2R.RepositoryComponent_BidirectionalCheckRoutine routine = new mir.routines.umlXpcmComponent_L2R.RepositoryComponent_BidirectionalCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject, routineName);
    return routine.applyRoutine();
  }
  
  public boolean repositoryComponent_ElementCreatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmComponent_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmComponent_L2R.RepositoryComponent_ElementCreatedCheckRoutine routine = new mir.routines.umlXpcmComponent_L2R.RepositoryComponent_ElementCreatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean repositoryComponent_ElementDeletedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmComponent_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmComponent_L2R.RepositoryComponent_ElementDeletedCheckRoutine routine = new mir.routines.umlXpcmComponent_L2R.RepositoryComponent_ElementDeletedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean repositoryComponent_ElementUpdatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmComponent_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmComponent_L2R.RepositoryComponent_ElementUpdatedCheckRoutine routine = new mir.routines.umlXpcmComponent_L2R.RepositoryComponent_ElementUpdatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean onRepositoryComponentNameReplacedAtOperation_nameBidirectionalRepair(final Operation affectedEObject) {
    mir.routines.umlXpcmComponent_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmComponent_L2R.OnRepositoryComponentNameReplacedAtOperation_nameBidirectionalRepairRoutine routine = new mir.routines.umlXpcmComponent_L2R.OnRepositoryComponentNameReplacedAtOperation_nameBidirectionalRepairRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean onRepositoryComponentNameReplacedAtClass_nameBidirectionalRepair(final org.eclipse.uml2.uml.Class affectedEObject) {
    mir.routines.umlXpcmComponent_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmComponent_L2R.OnRepositoryComponentNameReplacedAtClass_nameBidirectionalRepairRoutine routine = new mir.routines.umlXpcmComponent_L2R.OnRepositoryComponentNameReplacedAtClass_nameBidirectionalRepairRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean onRepositoryComponentNameReplacedAtPackage_nameBidirectionalRepair(final org.eclipse.uml2.uml.Package affectedEObject) {
    mir.routines.umlXpcmComponent_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmComponent_L2R.OnRepositoryComponentNameReplacedAtPackage_nameBidirectionalRepairRoutine routine = new mir.routines.umlXpcmComponent_L2R.OnRepositoryComponentNameReplacedAtPackage_nameBidirectionalRepairRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
}
