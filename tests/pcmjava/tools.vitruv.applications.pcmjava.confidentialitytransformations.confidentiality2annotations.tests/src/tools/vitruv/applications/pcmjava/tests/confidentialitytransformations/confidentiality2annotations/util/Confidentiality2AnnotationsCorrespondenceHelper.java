package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;

import edu.kit.kastel.scbs.confidentiality.ConfidentialitySpecification;
import tools.vitruv.framework.correspondence.CorrespondenceModel;
import tools.vitruv.framework.correspondence.CorrespondenceModelUtil;

public final class Confidentiality2AnnotationsCorrespondenceHelper {

    private final CorrespondenceModel model;

    public Confidentiality2AnnotationsCorrespondenceHelper(CorrespondenceModel model) {
        this.model = model;
    }

    public org.emftext.language.java.containers.Package getCorrespondingRoot(
            ConfidentialitySpecification specification) {
        Assert.assertNotNull(specification);
        Iterable<org.emftext.language.java.containers.Package> correspondingToRoot = getCorrespondingObjectsOfType(
                specification, org.emftext.language.java.containers.Package.class);
        org.emftext.language.java.containers.Package correspondingRoot = IterableExtensions.head(correspondingToRoot);
        Assert.assertNotNull(correspondingRoot); // assert corresponding root exists
        return correspondingRoot;
    }

    public <T> Iterable<T> getCorrespondingObjectsOfType(EObject obj, Class<T> type) {
        // get corresponding objects for obj
        Set<EObject> corresponding = CorrespondenceModelUtil.getCorrespondingEObjects(model, obj);
        // only get relevant objects (of correct type)
        return IterableExtensions.filter(corresponding, type);
    }

}
