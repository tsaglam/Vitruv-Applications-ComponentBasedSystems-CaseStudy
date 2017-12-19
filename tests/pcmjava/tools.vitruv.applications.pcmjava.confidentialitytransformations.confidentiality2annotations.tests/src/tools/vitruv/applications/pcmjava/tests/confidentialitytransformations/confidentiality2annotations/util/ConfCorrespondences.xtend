package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util

import tools.vitruv.framework.correspondence.CorrespondenceModel
import java.util.Set
import org.eclipse.emf.ecore.EObject
import tools.vitruv.framework.correspondence.CorrespondenceModelUtil
import edu.kit.kastel.scbs.confidentiality.ConfidentialitySpecification
import org.emftext.language.java.members.EnumConstant
import org.emftext.language.java.containers.Package
import org.junit.Assert
import org.emftext.language.java.classifiers.Enumeration
import org.emftext.language.java.classifiers.Annotation

public final class ConfCorrespondences {
	
    private final val CorrespondenceModel model

    public new(CorrespondenceModel model) {
        this.model = model
    }

    public def Set<EnumConstant> getCorrespondingEnumConstants(EObject obj) {
        CorrespondenceModelUtil.getCorrespondingEObjectsByType(model, obj, typeof(EnumConstant))
    }
    
    public def Set<Package> getCorrespondingPackages(EObject obj) {
		CorrespondenceModelUtil.getCorrespondingEObjectsByType(model, obj, typeof(Package)) 
    }
    
    public def Set<Enumeration> getCorrespondingEnumerations(EObject obj) {
		CorrespondenceModelUtil.getCorrespondingEObjectsByType(model, obj, typeof(Enumeration)) 
    }
    
    public def Set<Annotation> getCorrespondingAnnotations(EObject obj) {
		CorrespondenceModelUtil.getCorrespondingEObjectsByType(model, obj, typeof(Annotation)) 
    }
    
    public def int getNumber(EObject obj) {
		CorrespondenceModelUtil.getCorrespondingEObjects(model, obj).size
    }
    
    public def boolean emptyCorrespondences(EObject obj) {
		CorrespondenceModelUtil.getCorrespondingEObjects(model, obj).empty
    }
}