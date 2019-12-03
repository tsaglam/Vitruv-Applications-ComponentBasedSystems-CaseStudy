package mir.routines.umlXpcmComponent_R2L;

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
  
  public boolean updateComponentCorrespondingUmlNames(final RepositoryComponent component, final Repository repository) {
    mir.routines.umlXpcmComponent_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmComponent_R2L.UpdateComponentCorrespondingUmlNamesRoutine routine = new mir.routines.umlXpcmComponent_R2L.UpdateComponentCorrespondingUmlNamesRoutine(_routinesFacade, _reactionExecutionState, _caller, component, repository);
    return routine.applyRoutine();
  }
  
  public boolean repositoryComponent_BidirectionalUpdate(final RepositoryComponent component_, final Repository repository_) {
    mir.routines.umlXpcmComponent_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmComponent_R2L.RepositoryComponent_BidirectionalUpdateRoutine routine = new mir.routines.umlXpcmComponent_R2L.RepositoryComponent_BidirectionalUpdateRoutine(_routinesFacade, _reactionExecutionState, _caller, component_, repository_);
    return routine.applyRoutine();
  }
  
  public boolean repositoryComponent_CreateMapping(final RepositoryComponent component_, final Repository repository_) {
    mir.routines.umlXpcmComponent_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmComponent_R2L.RepositoryComponent_CreateMappingRoutine routine = new mir.routines.umlXpcmComponent_R2L.RepositoryComponent_CreateMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, component_, repository_);
    return routine.applyRoutine();
  }
  
  public boolean repositoryComponent_DeleteMapping(final org.eclipse.uml2.uml.Package componentPackage_, final org.eclipse.uml2.uml.Package repositoryPackage_, final org.eclipse.uml2.uml.Class implementation_, final Operation constructor_) {
    mir.routines.umlXpcmComponent_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmComponent_R2L.RepositoryComponent_DeleteMappingRoutine routine = new mir.routines.umlXpcmComponent_R2L.RepositoryComponent_DeleteMappingRoutine(_routinesFacade, _reactionExecutionState, _caller, componentPackage_, repositoryPackage_, implementation_, constructor_);
    return routine.applyRoutine();
  }
  
  public boolean repositoryComponent_BidirectionalCheck(final EObject affectedEObject, final String routineName) {
    mir.routines.umlXpcmComponent_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmComponent_R2L.RepositoryComponent_BidirectionalCheckRoutine routine = new mir.routines.umlXpcmComponent_R2L.RepositoryComponent_BidirectionalCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject, routineName);
    return routine.applyRoutine();
  }
  
  public boolean repositoryComponent_ElementCreatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmComponent_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmComponent_R2L.RepositoryComponent_ElementCreatedCheckRoutine routine = new mir.routines.umlXpcmComponent_R2L.RepositoryComponent_ElementCreatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean repositoryComponent_ElementDeletedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmComponent_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmComponent_R2L.RepositoryComponent_ElementDeletedCheckRoutine routine = new mir.routines.umlXpcmComponent_R2L.RepositoryComponent_ElementDeletedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean repositoryComponent_ElementUpdatedCheck(final EObject affectedEObject) {
    mir.routines.umlXpcmComponent_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmComponent_R2L.RepositoryComponent_ElementUpdatedCheckRoutine routine = new mir.routines.umlXpcmComponent_R2L.RepositoryComponent_ElementUpdatedCheckRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
  
  public boolean onRepositoryComponentEntityNameReplacedAtRepositoryComponent_entityNameBidirectionalRepair(final RepositoryComponent affectedEObject) {
    mir.routines.umlXpcmComponent_R2L.RoutinesFacade _routinesFacade = this;
    ReactionExecutionState _reactionExecutionState = this._getExecutionState().getReactionExecutionState();
    CallHierarchyHaving _caller = this._getExecutionState().getCaller();
    mir.routines.umlXpcmComponent_R2L.OnRepositoryComponentEntityNameReplacedAtRepositoryComponent_entityNameBidirectionalRepairRoutine routine = new mir.routines.umlXpcmComponent_R2L.OnRepositoryComponentEntityNameReplacedAtRepositoryComponent_entityNameBidirectionalRepairRoutine(_routinesFacade, _reactionExecutionState, _caller, affectedEObject);
    return routine.applyRoutine();
  }
}
