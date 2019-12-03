package mir.routines.umlXpcmRepository_R2L;

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
  
  public boolean updateRepoPackageName(final Repository repository) {
    mir.routines.umlXpcmRepository_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRepository_R2L.UpdateRepoPackageNameRoutine routine = new mir.routines.umlXpcmRepository_R2L.UpdateRepoPackageNameRoutine(_routinesFacade, _reactionExecutionState, _caller, repository);
    return routine.applyRoutine();
  }
  
  public boolean repository_BidirectionalUpdate(final Repository repository_) {
    mir.routines.umlXpcmRepository_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRepository_R2L.Repository_BidirectionalUpdateRoutine routine = new mir.routines.umlXpcmRepository_R2L.Repository_BidirectionalUpdateRoutine(_routinesFacade, _reactionExecutionState, _caller, repository_);
    return routine.applyRoutine();
  }
  
  public boolean repository_CreateMapping(final Repository repository_) {
    mir.routines.umlXpcmRepository_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRepository_R2L.Repository_CreateMappingRoutine routine = new mir.routines.umlXpcmRepository_R2L.Repository_CreateMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, repository_);
    return routine.applyRoutine();
  }
  
  public boolean repository_DeleteMapping(final org.eclipse.uml2.uml.Package repositoryPkg_, final org.eclipse.uml2.uml.Package contractsPkg_, final org.eclipse.uml2.uml.Package datatypesPkg_) {
    mir.routines.umlXpcmRepository_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRepository_R2L.Repository_DeleteMappingRoutine routine = new mir.routines.umlXpcmRepository_R2L.Repository_DeleteMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, repositoryPkg_, contractsPkg_, datatypesPkg_);
    return routine.applyRoutine();
  }
  
  public boolean repository_BidirectionalCheck(final EObject affectedEObject, final String routineName) {
    mir.routines.umlXpcmRepository_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRepository_R2L.Repository_BidirectionalCheckRoutine routine = new mir.routines.umlXpcmRepository_R2L.Repository_BidirectionalCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject, routineName);
    return routine.applyRoutine();
  }
  
  public boolean repository_ElementCreatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmRepository_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRepository_R2L.Repository_ElementCreatedCheckRoutine routine = new mir.routines.umlXpcmRepository_R2L.Repository_ElementCreatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean repository_ElementDeletedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmRepository_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRepository_R2L.Repository_ElementDeletedCheckRoutine routine = new mir.routines.umlXpcmRepository_R2L.Repository_ElementDeletedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean repository_ElementUpdatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmRepository_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRepository_R2L.Repository_ElementUpdatedCheckRoutine routine = new mir.routines.umlXpcmRepository_R2L.Repository_ElementUpdatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean onRepositoryEntityNameReplacedAtRepository_entityNameBidirectionalRepair(final Repository affectedEObject) {
    mir.routines.umlXpcmRepository_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmRepository_R2L.OnRepositoryEntityNameReplacedAtRepository_entityNameBidirectionalRepairRoutine routine = new mir.routines.umlXpcmRepository_R2L.OnRepositoryEntityNameReplacedAtRepository_entityNameBidirectionalRepairRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
}
