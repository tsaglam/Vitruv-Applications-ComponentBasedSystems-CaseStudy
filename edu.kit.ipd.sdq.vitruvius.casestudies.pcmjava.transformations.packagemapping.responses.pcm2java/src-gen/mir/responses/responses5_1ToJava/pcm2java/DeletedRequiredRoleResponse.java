package mir.responses.responses5_1ToJava.pcm2java;

import edu.kit.ipd.sdq.vitruvius.extensions.dslsruntime.response.AbstractResponseRealization;
import edu.kit.ipd.sdq.vitruvius.framework.change.echange.EChange;
import edu.kit.ipd.sdq.vitruvius.framework.change.echange.feature.reference.RemoveEReference;
import edu.kit.ipd.sdq.vitruvius.framework.userinteraction.UserInteracting;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.core.entity.InterfaceRequiringEntity;
import org.palladiosimulator.pcm.repository.OperationRequiredRole;
import org.palladiosimulator.pcm.repository.RequiredRole;

@SuppressWarnings("all")
class DeletedRequiredRoleResponse extends AbstractResponseRealization {
  public DeletedRequiredRoleResponse(final UserInteracting userInteracting) {
    super(userInteracting);
  }
  
  private boolean checkTriggerPrecondition(final RemoveEReference<InterfaceRequiringEntity, RequiredRole> change) {
    RequiredRole _oldValue = change.getOldValue();
    return (_oldValue instanceof OperationRequiredRole);
  }
  
  public static Class<? extends EChange> getExpectedChangeType() {
    return RemoveEReference.class;
  }
  
  private boolean checkChangeProperties(final RemoveEReference<InterfaceRequiringEntity, RequiredRole> change) {
    EObject changedElement = change.getAffectedEObject();
    // Check model element type
    if (!(changedElement instanceof InterfaceRequiringEntity)) {
    	return false;
    }
    
    // Check feature
    if (!change.getAffectedFeature().getName().equals("requiredRoles_InterfaceRequiringEntity")) {
    	return false;
    }
    return true;
  }
  
  public boolean checkPrecondition(final EChange change) {
    if (!(change instanceof RemoveEReference<?, ?>)) {
    	return false;
    }
    RemoveEReference typedChange = (RemoveEReference)change;
    if (!checkChangeProperties(typedChange)) {
    	return false;
    }
    if (!checkTriggerPrecondition(typedChange)) {
    	return false;
    }
    getLogger().debug("Passed precondition check of response " + this.getClass().getName());
    return true;
  }
  
  public void executeResponse(final EChange change) {
    RemoveEReference<InterfaceRequiringEntity, RequiredRole> typedChange = (RemoveEReference<InterfaceRequiringEntity, RequiredRole>)change;
    mir.routines.pcm2java.DeletedRequiredRoleEffect effect = new mir.routines.pcm2java.DeletedRequiredRoleEffect(this.executionState, this, typedChange);
    effect.applyRoutine();
  }
}
