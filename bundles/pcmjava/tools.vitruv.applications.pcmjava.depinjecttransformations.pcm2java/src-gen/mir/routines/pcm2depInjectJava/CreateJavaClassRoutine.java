package mir.routines.pcm2depInjectJava;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import mir.routines.pcm2depInjectJava.RoutinesFacade;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.emftext.language.java.classifiers.impl.ClassifiersFactoryImpl;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.modifiers.ModifiersFactory;
import org.emftext.language.java.modifiers.Public;
import org.palladiosimulator.pcm.core.entity.NamedElement;
import org.palladiosimulator.pcm.repository.BasicComponent;
import tools.vitruv.applications.pcmjava.depinjecttransformations.pcm2java.PCMJaMoPPUtilsGuice;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;
import tools.vitruv.framework.util.bridges.CollectionBridge;

@SuppressWarnings("all")
public class CreateJavaClassRoutine extends AbstractRepairRoutineRealization {
  private RoutinesFacade actionsFacade;
  
  private CreateJavaClassRoutine.ActionUserExecution userExecution;
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public EObject getElement1(final NamedElement sourceElementMappedToClass, final org.emftext.language.java.containers.Package containingPackage, final String className, final org.emftext.language.java.classifiers.Class javaClass) {
      return javaClass;
    }
    
    public void updateJavaClassElement(final NamedElement sourceElementMappedToClass, final org.emftext.language.java.containers.Package containingPackage, final String className, final org.emftext.language.java.classifiers.Class javaClass) {
      javaClass.setName(className);
      Public _createPublic = ModifiersFactory.eINSTANCE.createPublic();
      javaClass.addModifier(_createPublic);
    }
    
    public EObject getElement2(final NamedElement sourceElementMappedToClass, final org.emftext.language.java.containers.Package containingPackage, final String className, final org.emftext.language.java.classifiers.Class javaClass) {
      return sourceElementMappedToClass;
    }
    
    public void callRoutine1(final NamedElement sourceElementMappedToClass, final org.emftext.language.java.containers.Package containingPackage, final String className, final org.emftext.language.java.classifiers.Class javaClass, @Extension final RoutinesFacade _routinesFacade) {
      _routinesFacade.createCompilationUnit(sourceElementMappedToClass, javaClass, containingPackage);
      if ((sourceElementMappedToClass instanceof BasicComponent)) {
        PCMJaMoPPUtilsGuice.ensureConstructorWithInjectAnnotation(javaClass);
      } else {
        if ((sourceElementMappedToClass instanceof org.palladiosimulator.pcm.system.System)) {
          PCMJaMoPPUtilsGuice.addGuiceModuleInterfaceToClass(javaClass);
          final ClassMethod method = PCMJaMoPPUtilsGuice.addConfigureMethodToModule(javaClass);
          List<EObject> _list = CollectionBridge.<EObject>toList(method);
          this.correspondenceModel.createAndAddCorrespondence(Collections.<EObject>unmodifiableList(CollectionLiterals.<EObject>newArrayList(sourceElementMappedToClass)), _list);
        }
      }
    }
  }
  
  public CreateJavaClassRoutine(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy, final NamedElement sourceElementMappedToClass, final org.emftext.language.java.containers.Package containingPackage, final String className) {
    super(reactionExecutionState, calledBy);
    this.userExecution = new mir.routines.pcm2depInjectJava.CreateJavaClassRoutine.ActionUserExecution(getExecutionState(), this);
    this.actionsFacade = new mir.routines.pcm2depInjectJava.RoutinesFacade(getExecutionState(), this);
    this.sourceElementMappedToClass = sourceElementMappedToClass;this.containingPackage = containingPackage;this.className = className;
  }
  
  private NamedElement sourceElementMappedToClass;
  
  private org.emftext.language.java.containers.Package containingPackage;
  
  private String className;
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine CreateJavaClassRoutine with input:");
    getLogger().debug("   NamedElement: " + this.sourceElementMappedToClass);
    getLogger().debug("   Package: " + this.containingPackage);
    getLogger().debug("   String: " + this.className);
    
    org.emftext.language.java.classifiers.Class javaClass = ClassifiersFactoryImpl.eINSTANCE.createClass();
    userExecution.updateJavaClassElement(sourceElementMappedToClass, containingPackage, className, javaClass);
    
    addCorrespondenceBetween(userExecution.getElement1(sourceElementMappedToClass, containingPackage, className, javaClass), userExecution.getElement2(sourceElementMappedToClass, containingPackage, className, javaClass), "");
    
    userExecution.callRoutine1(sourceElementMappedToClass, containingPackage, className, javaClass, actionsFacade);
    
    postprocessElements();
  }
}