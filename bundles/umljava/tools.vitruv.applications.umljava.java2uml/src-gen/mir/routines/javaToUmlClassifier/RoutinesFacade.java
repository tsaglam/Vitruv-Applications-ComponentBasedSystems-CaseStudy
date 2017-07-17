package mir.routines.javaToUmlClassifier;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.PackageableElement;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.members.EnumConstant;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutinesFacade;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;

@SuppressWarnings("all")
public class RoutinesFacade extends AbstractRepairRoutinesFacade {
  public RoutinesFacade(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
    super(reactionExecutionState, calledBy);
  }
  
  public void createUmlClass(final org.emftext.language.java.classifiers.Class jClass, final CompilationUnit jCompUnit) {
    mir.routines.javaToUmlClassifier.CreateUmlClassRoutine effect = new mir.routines.javaToUmlClassifier.CreateUmlClassRoutine(this.executionState, calledBy,
    	jClass, jCompUnit);
    effect.applyRoutine();
  }
  
  public void addUmlElementToPackage(final PackageableElement uPackageable, final org.eclipse.uml2.uml.Package uPackage, final EObject persistedObject) {
    mir.routines.javaToUmlClassifier.AddUmlElementToPackageRoutine effect = new mir.routines.javaToUmlClassifier.AddUmlElementToPackageRoutine(this.executionState, calledBy,
    	uPackageable, uPackage, persistedObject);
    effect.applyRoutine();
  }
  
  public void deleteUmlClassifier(final ConcreteClassifier jClassifier, final CompilationUnit jCompUnit) {
    mir.routines.javaToUmlClassifier.DeleteUmlClassifierRoutine effect = new mir.routines.javaToUmlClassifier.DeleteUmlClassifierRoutine(this.executionState, calledBy,
    	jClassifier, jCompUnit);
    effect.applyRoutine();
  }
  
  public void setUmlClassAbstract(final org.emftext.language.java.classifiers.Class jClass, final Boolean isAbstract) {
    mir.routines.javaToUmlClassifier.SetUmlClassAbstractRoutine effect = new mir.routines.javaToUmlClassifier.SetUmlClassAbstractRoutine(this.executionState, calledBy,
    	jClass, isAbstract);
    effect.applyRoutine();
  }
  
  public void setUmlClassFinal(final org.emftext.language.java.classifiers.Class jClass, final Boolean isFinal) {
    mir.routines.javaToUmlClassifier.SetUmlClassFinalRoutine effect = new mir.routines.javaToUmlClassifier.SetUmlClassFinalRoutine(this.executionState, calledBy,
    	jClass, isFinal);
    effect.applyRoutine();
  }
  
  public void addUmlSuperClass(final org.emftext.language.java.classifiers.Class jClass, final org.emftext.language.java.classifiers.Class jSuperClass) {
    mir.routines.javaToUmlClassifier.AddUmlSuperClassRoutine effect = new mir.routines.javaToUmlClassifier.AddUmlSuperClassRoutine(this.executionState, calledBy,
    	jClass, jSuperClass);
    effect.applyRoutine();
  }
  
  public void clearUmlSuperClassifiers(final org.emftext.language.java.classifiers.Class jClass) {
    mir.routines.javaToUmlClassifier.ClearUmlSuperClassifiersRoutine effect = new mir.routines.javaToUmlClassifier.ClearUmlSuperClassifiersRoutine(this.executionState, calledBy,
    	jClass);
    effect.applyRoutine();
  }
  
  public void addUmlClassImplement(final org.emftext.language.java.classifiers.Class jClass, final Classifier jInterface) {
    mir.routines.javaToUmlClassifier.AddUmlClassImplementRoutine effect = new mir.routines.javaToUmlClassifier.AddUmlClassImplementRoutine(this.executionState, calledBy,
    	jClass, jInterface);
    effect.applyRoutine();
  }
  
  public void removeUmlClassImplement(final org.emftext.language.java.classifiers.Class jClass, final Interface jInterface) {
    mir.routines.javaToUmlClassifier.RemoveUmlClassImplementRoutine effect = new mir.routines.javaToUmlClassifier.RemoveUmlClassImplementRoutine(this.executionState, calledBy,
    	jClass, jInterface);
    effect.applyRoutine();
  }
  
  public void createUmlInterface(final Interface jInterface, final CompilationUnit jCompUnit) {
    mir.routines.javaToUmlClassifier.CreateUmlInterfaceRoutine effect = new mir.routines.javaToUmlClassifier.CreateUmlInterfaceRoutine(this.executionState, calledBy,
    	jInterface, jCompUnit);
    effect.applyRoutine();
  }
  
  public void addUmlSuperinterfaces(final Interface jInterface, final Classifier jSuperInterface) {
    mir.routines.javaToUmlClassifier.AddUmlSuperinterfacesRoutine effect = new mir.routines.javaToUmlClassifier.AddUmlSuperinterfacesRoutine(this.executionState, calledBy,
    	jInterface, jSuperInterface);
    effect.applyRoutine();
  }
  
  public void removeUmlSuperInterface(final Interface jInterface, final Classifier jSuperClassifier) {
    mir.routines.javaToUmlClassifier.RemoveUmlSuperInterfaceRoutine effect = new mir.routines.javaToUmlClassifier.RemoveUmlSuperInterfaceRoutine(this.executionState, calledBy,
    	jInterface, jSuperClassifier);
    effect.applyRoutine();
  }
  
  public void createUmlPackage(final org.emftext.language.java.containers.Package jPackage) {
    mir.routines.javaToUmlClassifier.CreateUmlPackageRoutine effect = new mir.routines.javaToUmlClassifier.CreateUmlPackageRoutine(this.executionState, calledBy,
    	jPackage);
    effect.applyRoutine();
  }
  
  public void deleteUmlPackage(final org.emftext.language.java.containers.Package jPackage) {
    mir.routines.javaToUmlClassifier.DeleteUmlPackageRoutine effect = new mir.routines.javaToUmlClassifier.DeleteUmlPackageRoutine(this.executionState, calledBy,
    	jPackage);
    effect.applyRoutine();
  }
  
  public void addUmlPackageOfClass(final org.emftext.language.java.containers.Package jPackage, final ConcreteClassifier jClassifier) {
    mir.routines.javaToUmlClassifier.AddUmlPackageOfClassRoutine effect = new mir.routines.javaToUmlClassifier.AddUmlPackageOfClassRoutine(this.executionState, calledBy,
    	jPackage, jClassifier);
    effect.applyRoutine();
  }
  
  public void removeUmlPackageOfClass(final org.emftext.language.java.containers.Package jPackage, final ConcreteClassifier jClassifier) {
    mir.routines.javaToUmlClassifier.RemoveUmlPackageOfClassRoutine effect = new mir.routines.javaToUmlClassifier.RemoveUmlPackageOfClassRoutine(this.executionState, calledBy,
    	jPackage, jClassifier);
    effect.applyRoutine();
  }
  
  public void addUmlElementToModelOrPackage(final CompilationUnit jCompUnit, final org.eclipse.uml2.uml.Classifier uClassifier) {
    mir.routines.javaToUmlClassifier.AddUmlElementToModelOrPackageRoutine effect = new mir.routines.javaToUmlClassifier.AddUmlElementToModelOrPackageRoutine(this.executionState, calledBy,
    	jCompUnit, uClassifier);
    effect.applyRoutine();
  }
  
  public void createUmlEnum(final Enumeration jEnum, final CompilationUnit jCompUnit) {
    mir.routines.javaToUmlClassifier.CreateUmlEnumRoutine effect = new mir.routines.javaToUmlClassifier.CreateUmlEnumRoutine(this.executionState, calledBy,
    	jEnum, jCompUnit);
    effect.applyRoutine();
  }
  
  public void createUmlEnumLiteral(final Enumeration jEnum, final EnumConstant jConstant) {
    mir.routines.javaToUmlClassifier.CreateUmlEnumLiteralRoutine effect = new mir.routines.javaToUmlClassifier.CreateUmlEnumLiteralRoutine(this.executionState, calledBy,
    	jEnum, jConstant);
    effect.applyRoutine();
  }
  
  public void deleteUmlEnumLiteral(final EnumConstant jConstant) {
    mir.routines.javaToUmlClassifier.DeleteUmlEnumLiteralRoutine effect = new mir.routines.javaToUmlClassifier.DeleteUmlEnumLiteralRoutine(this.executionState, calledBy,
    	jConstant);
    effect.applyRoutine();
  }
}
