package mir.reactions.java2PcmMethod;

import mir.routines.java2PcmMethod.RoutinesFacade;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.xbase.lib.Extension;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.members.Field;
import tools.vitruv.applications.pcmjava.pojotransformations.java2pcm.Java2PcmHelper;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractReactionRealization;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;
import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.change.echange.feature.reference.InsertEReference;

/**
 * *nCheck if Field has correspondence to CompositeDataType, ComposedProvidingRequiringEntity, nOperationInterface or RepositoryComponent and react accordingly.
 *  
 */
@SuppressWarnings("all")
public class FieldCreatedReaction extends AbstractReactionRealization {
  private InsertEReference<org.emftext.language.java.classifiers.Class, Field> insertChange;
  
  private int currentlyMatchedChange;
  
  public FieldCreatedReaction(final RoutinesFacade routinesFacade) {
    super(routinesFacade);
  }
  
  public void executeReaction(final EChange change) {
    if (!checkPrecondition(change)) {
    	return;
    }
    org.emftext.language.java.classifiers.Class affectedEObject = insertChange.getAffectedEObject();
    EReference affectedFeature = insertChange.getAffectedFeature();
    org.emftext.language.java.members.Field newValue = insertChange.getNewValue();
    int index = insertChange.getIndex();
    				
    getLogger().trace("Passed complete precondition check of Reaction " + this.getClass().getName());
    				
    mir.reactions.java2PcmMethod.FieldCreatedReaction.ActionUserExecution userExecution = new mir.reactions.java2PcmMethod.FieldCreatedReaction.ActionUserExecution(this.executionState, this);
    userExecution.callRoutine1(insertChange, affectedEObject, affectedFeature, newValue, index, this.getRoutinesFacade());
    
    resetChanges();
  }
  
  private void resetChanges() {
    insertChange = null;
    currentlyMatchedChange = 0;
  }
  
  public boolean checkPrecondition(final EChange change) {
    if (currentlyMatchedChange == 0) {
    	if (!matchInsertChange(change)) {
    		resetChanges();
    		return false;
    	} else {
    		currentlyMatchedChange++;
    	}
    }
    
    return true;
  }
  
  private boolean matchInsertChange(final EChange change) {
    if (change instanceof InsertEReference<?, ?>) {
    	InsertEReference<org.emftext.language.java.classifiers.Class, org.emftext.language.java.members.Field> _localTypedChange = (InsertEReference<org.emftext.language.java.classifiers.Class, org.emftext.language.java.members.Field>) change;
    	if (!(_localTypedChange.getAffectedEObject() instanceof org.emftext.language.java.classifiers.Class)) {
    		return false;
    	}
    	if (!_localTypedChange.getAffectedFeature().getName().equals("members")) {
    		return false;
    	}
    	if (!(_localTypedChange.getNewValue() instanceof org.emftext.language.java.members.Field)) {
    		return false;
    	}
    	this.insertChange = (InsertEReference<org.emftext.language.java.classifiers.Class, org.emftext.language.java.members.Field>) change;
    	return true;
    }
    
    return false;
  }
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public void callRoutine1(final InsertEReference insertChange, final org.emftext.language.java.classifiers.Class affectedEObject, final EReference affectedFeature, final Field newValue, final int index, @Extension final RoutinesFacade _routinesFacade) {
      _routinesFacade.createInnerDeclaration(newValue.getContainingConcreteClassifier(), newValue);
      final Classifier type = Java2PcmHelper.getTargetClassifierFromImplementsReferenceAndNormalizeURI(newValue.getTypeReference());
      _routinesFacade.fieldCreatedCorrespondingToOperationInterface(type, newValue);
      _routinesFacade.fieldCreatedCorrespondingToRepositoryComponent(type, newValue);
      _routinesFacade.createAssemblyContext(newValue.getContainingConcreteClassifier(), newValue);
    }
  }
}
