package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.classifiers.Annotation;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.containers.Package;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.members.EnumConstant;
import org.junit.Assert;

import edu.kit.kastel.scbs.confidentiality.ConfidentialitySpecification;
import edu.kit.kastel.scbs.confidentiality.data.DataSet;
import edu.kit.kastel.scbs.confidentiality.repository.ParametersAndDataPair;
import tools.vitruv.framework.correspondence.CorrespondenceModel;
import tools.vitruv.framework.correspondence.CorrespondenceModelUtil;

public final class Confidentiality2AnnotationsAssertions {

    private final static String CONFIDENTIALITY_REPOSITORY_PACKAGE = "confidentialityRepository";

    private final static String CONFIDENTIALITY_REPOSITORY_ANNOTATION = "InformationFlow";

    private final static Set<String> CONFIDENTIALITY_REPOSITORY_ENUMERATIONS = new HashSet<>();

    static {
        CONFIDENTIALITY_REPOSITORY_ENUMERATIONS.add("DataSets");
        CONFIDENTIALITY_REPOSITORY_ENUMERATIONS.add("ParametersAndDataPairs");
        // TODO only creation not yet content
        CONFIDENTIALITY_REPOSITORY_ENUMERATIONS.add("SpecificationParameters");
        CONFIDENTIALITY_REPOSITORY_ENUMERATIONS.add("ParameterizedDataSetMapEntries");
        CONFIDENTIALITY_REPOSITORY_ENUMERATIONS.add("DataSetMaps");
        CONFIDENTIALITY_REPOSITORY_ENUMERATIONS.add("DataSetMapEntries");
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

    public static boolean checkRootAnnotationContent(final File enumeration) throws IOException {
        return checkContentIgnoreWhitespaceAndLb(enumeration,
                Confidentiality2AnnotationsContent.INFORMATION_FLOW_ANNOTATION_CONTENT);
    }

    //// DATA SETS ////

    public void assertDataSetCorrespondence(final DataSet dataSet) {
        final Set<EnumConstant> corresponding;
        corresponding = CorrespondenceModelUtil.getCorrespondingEObjectsByType(model, dataSet, EnumConstant.class);
        assertTrue("Not exactly one correspondance for data set " + dataSet.getName(), corresponding.size() == 1);
        checkDataSet(dataSet, new LinkedList<>(corresponding).get(0));
    }

    private void checkDataSet(final DataSet dataSet, final EnumConstant correspondingEnumConstant) {
        boolean equalNames = dataSet.getName().equals(correspondingEnumConstant.getName());
        // TODO check more values
        assertTrue("Corresponding data sets have different names: " + dataSet.getName() + "<>"
                + correspondingEnumConstant.getName(), equalNames);
    }

    public static boolean checkDataSetsContent(final File enumeration) throws IOException {
        return checkContentIgnoreWhitespaceAndLb(enumeration, Confidentiality2AnnotationsContent.DATA_SETS_CONTENT);
    }

    //// PARAMETERS AND DATA PAIRS ////

    public void assertParametersAndDataPairCorrespondence(final ParametersAndDataPair parametersAndDataPair) {
        final Set<EnumConstant> corresponding;
        corresponding = CorrespondenceModelUtil.getCorrespondingEObjectsByType(model, parametersAndDataPair,
                EnumConstant.class);
        assertTrue("Not exactly one correspondance for parameter and data pair " + parametersAndDataPair.getName(),
                corresponding.size() == 1);
        checkParametersAndDataPair(parametersAndDataPair, new LinkedList<>(corresponding).get(0));
    }

    private void checkParametersAndDataPair(final ParametersAndDataPair parametersAndDataPair,
            final EnumConstant correspondingEnumConstant) {
        boolean equalNames = parametersAndDataPair.getName().equals(correspondingEnumConstant.getName());
        List<Expression> arguments = correspondingEnumConstant.getArguments();
        // TODO check more values
        assertTrue("Corresponding parameters and data pairs have different names: " + parametersAndDataPair.getName()
                + "<>" + correspondingEnumConstant.getName(), equalNames);
    }

    public static boolean checkPuDPairsContent(final File enumeration) throws IOException {
        return checkContentIgnoreWhitespaceAndLb(enumeration,
                Confidentiality2AnnotationsContent.PARAMETERS_AND_DATA_PAIRS_CONTENT);
    }

    //// GENERAL ////

    public void assertEmptyCorrespondence(final EObject eObject) throws Throwable {
        boolean empty = CorrespondenceModelUtil.getCorrespondingEObjects(model, eObject).isEmpty();
        Assert.assertTrue("Correspondences of '" + eObject.toString() + "' are not empty.", empty);
    }

    public static boolean checkContentIgnoreWhitespaceAndLb(final File file, String toCompare)
            throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            // remove whitespace and line breaks
            String toAdd = line.replaceAll("((\\s)*(\\n)*)*", "");
            sb.append(toAdd);
        }
        return sb.toString()
                .equals(toCompare.replaceAll("((\\s)*(\\n)*)*", ""));
    }
}
