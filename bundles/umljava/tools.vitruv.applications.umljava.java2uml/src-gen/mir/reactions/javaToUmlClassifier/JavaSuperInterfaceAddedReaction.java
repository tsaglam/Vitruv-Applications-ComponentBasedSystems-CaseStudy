package mir.reactions.javaToUmlClassifier;

import mir.routines.javaToUmlClassifier.RoutinesFacade;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.xbase.lib.Extension;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.types.TypeReference;
import tools.vitruv.applications.umljava.util.UmlJavaTypePropagationHelper;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractReactionRealization;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;
import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.change.echange.feature.reference.InsertEReference;

@SuppressWarnings("all")
public class JavaSuperInterfaceAddedReaction extends AbstractReactionRealization {
  private InsertEReference<Interface, TypeReference> insertChange;
  
  private int currentlyMatchedChange;
  
  public JavaSuperInterfaceAddedReaction(final RoutinesFacade routinesFacade) {
    super(routinesFacade);
  }
  
  public void executeReaction(final EChange change) {
    if (!checkPrecondition(change)) {
    	return;
    }
    org.emftext.language.java.classifiers.Interface affectedEObject = insertChange.getAffectedEObject();
    EReference affectedFeature = insertChange.getAffectedFeature();
    org.emftext.language.java.types.TypeReference newValue = insertChange.getNewValue();
    int index = insertChange.getIndex();
    				
    getLogger().trace("Passed complete precondition check of Reaction " + this.getClass().getName());
    				
    mir.reactions.javaToUmlClassifier.JavaSuperInterfaceAddedReaction.ActionUserExecution userExecution = new mir.reactions.javaToUmlClassifier.JavaSuperInterfaceAddedReaction.ActionUserExecution(this.executionState, this);
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
    	InsertEReference<org.emftext.language.java.classifiers.Interface, org.emftext.language.java.types.TypeReference> _localTypedChange = (InsertEReference<org.emftext.language.java.classifiers.Interface, org.emftext.language.java.types.TypeReference>) change;
    	if (!(_localTypedChange.getAffectedEObject() instanceof org.emftext.language.java.classifiers.Interface)) {
    		return false;
    	}
    	if (!_localTypedChange.getAffectedFeature().getName().equals("extends")) {
    		return false;
    	}
    	if (!(_localTypedChange.getNewValue() instanceof org.emftext.language.java.types.TypeReference)) {
    		return false;
    	}
    	this.insertChange = (InsertEReference<org.emftext.language.java.classifiers.Interface, org.emftext.language.java.types.TypeReference>) change;
    	return true;
    }
    
    return false;
  }
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public void callRoutine1(final InsertEReference insertChange, final Interface affectedEObject, final EReference affectedFeature, final TypeReference newValue, final int index, @Extension final RoutinesFacade _routinesFacade) {
      Classifier _classifier = UmlJavaTypePropagationHelper.getClassifier(newValue);
      final Interface jSuperInterface = ((Interface) _classifier);
      _routinesFacade.addUmlSuperinterfaces(affectedEObject, newValue, jSuperInterface);
    }
  }
}
