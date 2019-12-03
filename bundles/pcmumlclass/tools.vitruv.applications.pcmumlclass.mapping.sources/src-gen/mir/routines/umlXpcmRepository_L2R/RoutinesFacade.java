package mir.routines.umlXpcmRepository_L2R;

import org.eclipse.emf.ecore.EObject;
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
  
  public boolean updateRepoName(final org.eclipse.uml2.uml.Package repositoryPkg, final org.eclipse.uml2.uml.Package contractsPkg, final org.eclipse.uml2.uml.Package datatypesPkg) {
    mir.routines.umlXpcmRepository_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRepository_L2R.UpdateRepoNameRoutine routine = new mir.routines.umlXpcmRepository_L2R.UpdateRepoNameRoutine(_routinesFacade, _reactionExecutionState, _caller, repositoryPkg, contractsPkg, datatypesPkg);
    return routine.applyRoutine();
  }
  
  public boolean repository_BidirectionalUpdate(final org.eclipse.uml2.uml.Package repositoryPkg_, final org.eclipse.uml2.uml.Package contractsPkg_, final org.eclipse.uml2.uml.Package datatypesPkg_) {
    mir.routines.umlXpcmRepository_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRepository_L2R.Repository_BidirectionalUpdateRoutine routine = new mir.routines.umlXpcmRepository_L2R.Repository_BidirectionalUpdateRoutine(_routinesFacade, _reactionExecutionState, _caller, repositoryPkg_, contractsPkg_, datatypesPkg_);
    return routine.applyRoutine();
  }
  
  public boolean repository_CreateMapping(final org.eclipse.uml2.uml.Package repositoryPkg_, final org.eclipse.uml2.uml.Package contractsPkg_, final org.eclipse.uml2.uml.Package datatypesPkg_) {
    mir.routines.umlXpcmRepository_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRepository_L2R.Repository_CreateMappingRoutine routine = new mir.routines.umlXpcmRepository_L2R.Repository_CreateMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, repositoryPkg_, contractsPkg_, datatypesPkg_);
    return routine.applyRoutine();
  }
  
  public boolean repository_DeleteMapping(final Repository repository_) {
    mir.routines.umlXpcmRepository_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRepository_L2R.Repository_DeleteMappingRoutine routine = new mir.routines.umlXpcmRepository_L2R.Repository_DeleteMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, repository_);
    return routine.applyRoutine();
  }
  
  public boolean repository_BidirectionalCheck(final EObject affectedEObject, final String routineName) {
    mir.routines.umlXpcmRepository_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRepository_L2R.Repository_BidirectionalCheckRoutine routine = new mir.routines.umlXpcmRepository_L2R.Repository_BidirectionalCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject, routineName);
    return routine.applyRoutine();
  }
  
  public boolean repository_ElementCreatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmRepository_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRepository_L2R.Repository_ElementCreatedCheckRoutine routine = new mir.routines.umlXpcmRepository_L2R.Repository_ElementCreatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean repository_ElementDeletedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmRepository_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRepository_L2R.Repository_ElementDeletedCheckRoutine routine = new mir.routines.umlXpcmRepository_L2R.Repository_ElementDeletedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean repository_ElementUpdatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmRepository_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRepository_L2R.Repository_ElementUpdatedCheckRoutine routine = new mir.routines.umlXpcmRepository_L2R.Repository_ElementUpdatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean onRepositoryNameReplacedAtPackage_nameBidirectionalRepair(final org.eclipse.uml2.uml.Package affectedEObject) {
    mir.routines.umlXpcmRepository_L2R.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRepository_L2R.OnRepositoryNameReplacedAtPackage_nameBidirectionalRepairRoutine routine = new mir.routines.umlXpcmRepository_L2R.OnRepositoryNameReplacedAtPackage_nameBidirectionalRepairRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
}
