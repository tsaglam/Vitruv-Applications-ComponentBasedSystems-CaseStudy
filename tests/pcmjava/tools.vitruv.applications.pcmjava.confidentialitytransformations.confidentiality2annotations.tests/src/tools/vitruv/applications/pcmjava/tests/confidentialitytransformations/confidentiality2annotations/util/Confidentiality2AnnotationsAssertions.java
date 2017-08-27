package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.emftext.language.java.classifiers.Annotation;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.containers.Package;

import edu.kit.kastel.scbs.confidentiality.ConfidentialitySpecification;
import tools.vitruv.framework.correspondence.CorrespondenceModel;
import tools.vitruv.framework.correspondence.CorrespondenceModelUtil;

public final class Confidentiality2AnnotationsAssertions {

    private final static String CONFIDENTIALITY_REPOSITORY_PACKAGE = "confidentialityRepository";

    private final static String CONFIDENTIALITY_REPOSITORY_ANNOTATION = "InformationFlow";

    private final static Set<String> CONFIDENTIALITY_REPOSITORY_ENUMERATIONS = new HashSet<>();

    static {
        CONFIDENTIALITY_REPOSITORY_ENUMERATIONS.add("DataSets");
        CONFIDENTIALITY_REPOSITORY_ENUMERATIONS.add("ParametersAndDataPairs");
    }

    private final CorrespondenceModel model;

    public Confidentiality2AnnotationsAssertions(CorrespondenceModel model) {
        this.model = model;
    }

    public void assertRootCorrespondences(final ConfidentialitySpecification root) {
        assertRootPackage(root);
        assertRootEnumerations(root);
        assertRootAnnotation(root);
    }

    //// ROOT PACKAGE ////

    public void assertRootPackage(final ConfidentialitySpecification root) {
        final Set<Package> correspondingPackages;
        correspondingPackages = CorrespondenceModelUtil.getCorrespondingEObjectsByType(model, root, Package.class);
        scanCorrespondingPackages(root, correspondingPackages);
    }

    private void scanCorrespondingPackages(final ConfidentialitySpecification root,
            final Set<Package> correspondingPackages) {
        boolean foundPackage = false;
        for (final Package pack : correspondingPackages) {
            foundPackage |= pack.getName().equals(CONFIDENTIALITY_REPOSITORY_PACKAGE);
        }
        assertTrue("No corresponding java package for root found", foundPackage);
    }

    //// ROOT ENUMERATIONS ////

    public void assertRootEnumerations(final ConfidentialitySpecification root) {
        final Set<Enumeration> correspondingEnumerations;
        correspondingEnumerations = CorrespondenceModelUtil.getCorrespondingEObjectsByType(model, root,
                Enumeration.class);
        Set<String> foundEnumerations = scanCorrespondingEnumerations(root, correspondingEnumerations);
        checkCorrespondingEnumerations(foundEnumerations);
    }

    private Set<String> scanCorrespondingEnumerations(final ConfidentialitySpecification root,
            final Set<Enumeration> correspondingEnumerations) {
        Set<String> foundEnumerations = new HashSet<>();
        for (final Enumeration enumeration : correspondingEnumerations) {
            String name = enumeration.getName();
            if (CONFIDENTIALITY_REPOSITORY_ENUMERATIONS.contains(name)) {
                foundEnumerations.add(name);
            }
        }
        return foundEnumerations;
    }

    private void checkCorrespondingEnumerations(final Set<String> foundEnumerations) {
        for (final String name : CONFIDENTIALITY_REPOSITORY_ENUMERATIONS) {
            assertTrue("No corresponding java enumeration '" + name + "' found.", foundEnumerations.contains(name));
        }
    }

    //// ROOT ANNOTATION ////

    public void assertRootAnnotation(final ConfidentialitySpecification root) {
        final Set<Annotation> correspondingAnnotations;
        correspondingAnnotations = CorrespondenceModelUtil.getCorrespondingEObjectsByType(model, root,
                Annotation.class);
        scanCorrespondingAnnotations(root, correspondingAnnotations);
    }

    private void scanCorrespondingAnnotations(final ConfidentialitySpecification root,
            final Set<Annotation> correspondingAnnotations) {
        boolean foundAnnotation = false;
        for (final Annotation annotation : correspondingAnnotations) {
            foundAnnotation |= annotation.getName().equals(CONFIDENTIALITY_REPOSITORY_ANNOTATION);
        }
        assertTrue("No corresponding java annotation for root found", foundAnnotation);
    }
}
