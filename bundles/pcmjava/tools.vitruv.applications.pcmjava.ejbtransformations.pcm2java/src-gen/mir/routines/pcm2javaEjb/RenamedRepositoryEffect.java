package mir.routines.pcm2javaEjb;

import com.google.common.collect.Iterables;
import java.io.IOException;
import mir.routines.pcm2javaEjb.RoutinesFacade;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.CollectionDataType;
import org.palladiosimulator.pcm.repository.CompositeDataType;
import org.palladiosimulator.pcm.repository.DataType;
import org.palladiosimulator.pcm.repository.Interface;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import tools.vitruv.applications.pcmjava.util.transformations.pcm2java.helper.Pcm2JavaHelper;
import tools.vitruv.extensions.dslsruntime.response.AbstractEffectRealization;
import tools.vitruv.extensions.dslsruntime.response.ResponseExecutionState;
import tools.vitruv.extensions.dslsruntime.response.structure.CallHierarchyHaving;
import tools.vitruv.framework.change.echange.feature.attribute.ReplaceSingleValuedEAttribute;

@SuppressWarnings("all")
public class RenamedRepositoryEffect extends AbstractEffectRealization {
  public RenamedRepositoryEffect(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy, final ReplaceSingleValuedEAttribute<Repository, String> change) {
    super(responseExecutionState, calledBy);
    				this.change = change;
  }
  
  private ReplaceSingleValuedEAttribute<Repository, String> change;
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine RenamedRepositoryEffect with input:");
    getLogger().debug("   ReplaceSingleValuedEAttribute: " + this.change);
    
    org.emftext.language.java.containers.Package rootPackage = getCorrespondingElement(
    	getCorrepondenceSourceRootPackage(change), // correspondence source supplier
    	org.emftext.language.java.containers.Package.class,
    	(org.emftext.language.java.containers.Package _element) -> true, // correspondence precondition checker
    	getRetrieveTag0(change));
    if (rootPackage == null) {
    	return;
    }
    initializeRetrieveElementState(rootPackage);
    
    preprocessElementStates();
    new mir.routines.pcm2javaEjb.RenamedRepositoryEffect.EffectUserExecution(getExecutionState(), this).executeUserOperations(
    	change, rootPackage);
    postprocessElementStates();
  }
  
  private String getRetrieveTag0(final ReplaceSingleValuedEAttribute<Repository, String> change) {
    return "repository_root";
  }
  
  private EObject getCorrepondenceSourceRootPackage(final ReplaceSingleValuedEAttribute<Repository, String> change) {
    Repository _affectedEObject = change.getAffectedEObject();
    return _affectedEObject;
  }
  
  private static class EffectUserExecution extends AbstractEffectRealization.UserExecution {
    @Extension
    private RoutinesFacade effectFacade;
    
    public EffectUserExecution(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy) {
      super(responseExecutionState);
      this.effectFacade = new mir.routines.pcm2javaEjb.RoutinesFacade(responseExecutionState, calledBy);
    }
    
    private void executeUserOperations(final ReplaceSingleValuedEAttribute<Repository, String> change, final org.emftext.language.java.containers.Package rootPackage) {
      final Repository repository = change.getAffectedEObject();
      String _newValue = change.getNewValue();
      rootPackage.setName(_newValue);
      this.effectFacade.callRenameJavaPackage(repository, rootPackage, "contracts", "contracts");
      this.effectFacade.callRenameJavaPackage(repository, rootPackage, "datatypes", "datatypes");
      EList<RepositoryComponent> _components__Repository = repository.getComponents__Repository();
      Iterable<BasicComponent> _filter = Iterables.<BasicComponent>filter(_components__Repository, BasicComponent.class);
      for (final BasicComponent component : _filter) {
        this.effectFacade.callRenameComponentPackageAndClass(component);
      }
      EList<Interface> _interfaces__Repository = repository.getInterfaces__Repository();
      Iterable<OperationInterface> _filter_1 = Iterables.<OperationInterface>filter(_interfaces__Repository, OperationInterface.class);
      for (final OperationInterface interface_ : _filter_1) {
        this.effectFacade.callRenameInterface(interface_);
      }
      EList<DataType> _dataTypes__Repository = repository.getDataTypes__Repository();
      Iterable<CompositeDataType> _filter_2 = Iterables.<CompositeDataType>filter(_dataTypes__Repository, CompositeDataType.class);
      for (final CompositeDataType dataType : _filter_2) {
        this.effectFacade.callRenameCompositeDataType(dataType);
      }
      EList<DataType> _dataTypes__Repository_1 = repository.getDataTypes__Repository();
      Iterable<CollectionDataType> _filter_3 = Iterables.<CollectionDataType>filter(_dataTypes__Repository_1, CollectionDataType.class);
      for (final CollectionDataType dataType_1 : _filter_3) {
        this.effectFacade.callRenameCollectionDataType(dataType_1);
      }
      Repository _affectedEObject = change.getAffectedEObject();
      String _buildJavaFilePath = Pcm2JavaHelper.buildJavaFilePath(rootPackage);
      this.persistProjectRelative(_affectedEObject, rootPackage, _buildJavaFilePath);
    }
  }
}
