package mir.responses.mocks.org.palladiosimulator.pcm.repository;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.cdo.CDOLock;
import org.eclipse.emf.cdo.CDOObjectHistory;
import org.eclipse.emf.cdo.CDOState;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.lock.CDOLockState;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.common.security.CDOPermission;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.palladiosimulator.pcm.repository.DataType;
import org.palladiosimulator.pcm.repository.Repository;

@SuppressWarnings("all")
public class DataTypeContainerMock implements DataType {
  public DataTypeContainerMock(final DataType containedObject, final EObject containerObject) {
    super();
    this.containedObject = containedObject;
    this.containerObject = containerObject;
  }
  
  private DataType containedObject;
  
  private EObject containerObject;
  
  public void setRepository__DataType(final Repository arg0) {
    containedObject.setRepository__DataType(arg0);
  }
  
  public Repository getRepository__DataType() {
    return containedObject.getRepository__DataType();
  }
  
  public CDORevision cdoRevision(final boolean arg0) {
    return containedObject.cdoRevision(arg0);
  }
  
  public CDORevision cdoRevision() {
    return containedObject.cdoRevision();
  }
  
  public CDOID cdoID() {
    return containedObject.cdoID();
  }
  
  public CDOLockState cdoLockState() {
    return containedObject.cdoLockState();
  }
  
  public CDOView cdoView() {
    return containedObject.cdoView();
  }
  
  public CDOState cdoState() {
    return containedObject.cdoState();
  }
  
  public CDOLock cdoWriteOption() {
    return containedObject.cdoWriteOption();
  }
  
  public CDOResource cdoDirectResource() {
    return containedObject.cdoDirectResource();
  }
  
  public CDOObjectHistory cdoHistory() {
    return containedObject.cdoHistory();
  }
  
  public boolean cdoConflict() {
    return containedObject.cdoConflict();
  }
  
  public boolean cdoInvalid() {
    return containedObject.cdoInvalid();
  }
  
  public CDOPermission cdoPermission() {
    return containedObject.cdoPermission();
  }
  
  public void cdoPrefetch(final int arg0) {
    containedObject.cdoPrefetch(arg0);
  }
  
  public CDOLock cdoReadLock() {
    return containedObject.cdoReadLock();
  }
  
  public void cdoReload() {
    containedObject.cdoReload();
  }
  
  public CDOResource cdoResource() {
    return containedObject.cdoResource();
  }
  
  public CDOLock cdoWriteLock() {
    return containedObject.cdoWriteLock();
  }
  
  public EObject eContainer() {
    return containerObject;
  }
  
  public EReference eContainmentFeature() {
    return containedObject.eContainmentFeature();
  }
  
  public EStructuralFeature eContainingFeature() {
    return containedObject.eContainingFeature();
  }
  
  public EClass eClass() {
    return containedObject.eClass();
  }
  
  public Object eInvoke(final EOperation arg0, final EList arg1) throws InvocationTargetException {
    return containedObject.eInvoke(arg0, arg1);
  }
  
  public boolean eIsSet(final EStructuralFeature arg0) {
    return containedObject.eIsSet(arg0);
  }
  
  public Object eGet(final EStructuralFeature arg0) {
    return containedObject.eGet(arg0);
  }
  
  public Object eGet(final EStructuralFeature arg0, final boolean arg1) {
    return containedObject.eGet(arg0, arg1);
  }
  
  public boolean eIsProxy() {
    return containedObject.eIsProxy();
  }
  
  public Resource eResource() {
    return containerObject.eResource();
  }
  
  public void eSet(final EStructuralFeature arg0, final Object arg1) {
    containedObject.eSet(arg0, arg1);
  }
  
  public void eUnset(final EStructuralFeature arg0) {
    containedObject.eUnset(arg0);
  }
  
  public TreeIterator eAllContents() {
    return containedObject.eAllContents();
  }
  
  public EList eContents() {
    return containedObject.eContents();
  }
  
  public EList eCrossReferences() {
    return containedObject.eCrossReferences();
  }
  
  public void eNotify(final Notification arg0) {
    containedObject.eNotify(arg0);
  }
  
  public void eSetDeliver(final boolean arg0) {
    containedObject.eSetDeliver(arg0);
  }
  
  public boolean eDeliver() {
    return containedObject.eDeliver();
  }
  
  public EList eAdapters() {
    return containedObject.eAdapters();
  }
}