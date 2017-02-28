package mir.routines.pcm2java;

import java.io.IOException;
import mir.routines.pcm2java.RoutinesFacade;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;

@SuppressWarnings("all")
public class RenameComponentPackageAndClassRoutine extends AbstractRepairRoutineRealization {
  private RoutinesFacade actionsFacade;
  
  private RenameComponentPackageAndClassRoutine.ActionUserExecution userExecution;
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public boolean getCorrespondingModelElementsPreconditionRepositoryPackage(final RepositoryComponent component, final org.emftext.language.java.containers.Package repositoryPackage) {
      String _name = repositoryPackage.getName();
      Repository _repository__RepositoryComponent = component.getRepository__RepositoryComponent();
      String _entityName = _repository__RepositoryComponent.getEntityName();
      boolean _equals = _name.equals(_entityName);
      return _equals;
    }
    
    public EObject getCorrepondenceSourceRepositoryPackage(final RepositoryComponent component) {
      Repository _repository__RepositoryComponent = component.getRepository__RepositoryComponent();
      return _repository__RepositoryComponent;
    }
    
    public void callRoutine1(final RepositoryComponent component, final org.emftext.language.java.containers.Package repositoryPackage, @Extension final RoutinesFacade _routinesFacade) {
      String _entityName = component.getEntityName();
      _routinesFacade.renameJavaPackage(component, repositoryPackage, _entityName, null);
      _routinesFacade.renameComponentClass(component);
    }
  }
  
  public RenameComponentPackageAndClassRoutine(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy, final RepositoryComponent component) {
    super(reactionExecutionState, calledBy);
    this.userExecution = new mir.routines.pcm2java.RenameComponentPackageAndClassRoutine.ActionUserExecution(getExecutionState(), this);
    this.actionsFacade = new mir.routines.pcm2java.RoutinesFacade(getExecutionState(), this);
    this.component = component;
  }
  
  private RepositoryComponent component;
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine RenameComponentPackageAndClassRoutine with input:");
    getLogger().debug("   RepositoryComponent: " + this.component);
    
    org.emftext.language.java.containers.Package repositoryPackage = getCorrespondingElement(
    	userExecution.getCorrepondenceSourceRepositoryPackage(component), // correspondence source supplier
    	org.emftext.language.java.containers.Package.class,
    	(org.emftext.language.java.containers.Package _element) -> userExecution.getCorrespondingModelElementsPreconditionRepositoryPackage(component, _element), // correspondence precondition checker
    	null);
    if (repositoryPackage == null) {
    	return;
    }
    initializeRetrieveElementState(repositoryPackage);
    userExecution.callRoutine1(component, repositoryPackage, actionsFacade);
    
    postprocessElementStates();
  }
}