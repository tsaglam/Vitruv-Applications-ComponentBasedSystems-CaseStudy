package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.emftext.language.java.members.EnumConstant;
import org.junit.Assert;

import edu.kit.kastel.scbs.confidentiality.ConfidentialitySpecification;
import edu.kit.kastel.scbs.confidentiality.data.DataSet;
import edu.kit.kastel.scbs.confidentiality.repository.ParametersAndDataPair;
import tools.vitruv.applications.pcmjava.confidentialitytransformations.confidentiality2annotations.Confidentiality2AnnotationsChangePropagationSpecification;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util.ConfAssertions;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util.ConfCorrespondences;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util.ConfElementsCreator;
import tools.vitruv.domains.confidentiality.ConfidentialityDomainProvider;
import tools.vitruv.domains.confidentiality.ConfidentialityNamespace;
import tools.vitruv.domains.java.JavaDomainProvider;
import tools.vitruv.domains.java.JavaNamespace;
import tools.vitruv.framework.change.processing.ChangePropagationSpecification;
import tools.vitruv.framework.domains.VitruvDomain;
import tools.vitruv.testutils.VitruviusApplicationTest;
import tools.vitruv.testutils.VitruviusTest;
import tools.vitruv.testutils.VitruviusUnmonitoredApplicationTest;
import tools.vitruv.testutils.util.TestUtil;

/**
 * Basic test class for all Confidentiality Vitruvius application tests.
 * 
 * <p>
 * Relevant {@code VitruviusApplicationTest} super methods:
 * </p>
 * <ul>
 * <li>{@link tools.vitruv.framework.tests.VitruviusApplicationTest#createAndSynchronizeModel
 * <em>createAndSynchronizeModel</em>} (Creates Model with (root, path) and propagates the model
 * creation change and starts recording further changes)</li>
 * <li>{@link tools.vitruv.framework.tests.VitruviusApplicationTest#saveAndSynchronizeChanges
 * <em>saveAndSynchronizeChanges</em>} (Saves the model of the given element and propagates all
 * changes performed within that model since last change propagation)</li>
 * </ul>
 * 
 * <p>
 * Relevant {@code VitruviusUnmonitoredApplicationTest} super methods:
 * </p>
 * <ul>
 * <li>{@link tools.vitruv.framework.tests.VitruviusUnmonitoredApplicationTest#getCorrespondenceModel
 * <em>getCorrespondenceModel</em>}</li>
 * <li>{@link tools.vitruv.framework.tests.VitruviusUnmonitoredApplicationTest#getFirstRootElement
 * <em>getFirstRootElement</em>}</li>
 * <li>{@link tools.vitruv.framework.tests.VitruviusUnmonitoredApplicationTest#assertModelExists
 * <em>assertModelExists</em>}</li>
 * </ul>
 * 
 * @see VitruviusApplicationTest
 * @see VitruviusUnmonitoredApplicationTest
 * @see VitruviusTest
 * @see tools.vitruv.framework.tests.util.TestUtil
 * 
 * @author Nils Wilka
 * @version 1.1, 16.12.2017
 */
public class ConfidentialityTest extends VitruviusApplicationTest {

    // Choose an arbitrary name for the confidentiality model
    public final static String MODEL_NAME = "model";

    // Choose an arbitrary name for the confidentiality model folder
    public final static String MODEL_FOLDER_NAME = MODEL_NAME;

    // choose to keep the files for manual checks
    public final static boolean CLEAN_UP = false;

    private ConfCorrespondences correspondences;

    // ###################################################
    // ###################### SETUP ######################

    @Override
    protected void setup() {
        correspondences = new ConfCorrespondences(getCorrespondenceModel());
        ConfidentialitySpecification specification = ConfElementsCreator.createSpecification();
        String path = getConfidentialityModelRelativePath();
        try {
            // creates corresponding (java model) root according to reactions
            createAndSynchronizeModel(path, specification);
        } catch (IOException e) {
            Assert.fail("Model changes could not be saved for some reason.");
        }
    }

    // ###################################################
    // #################### CLEAN UP #####################

    @Override
    protected void cleanup() {
        if (CLEAN_UP) {
            try {
                deleteAndSynchronizeModel(getConfidentialityModelRelativePath());
            } catch (IOException e) {
                // do nothing.
            }
        }
    }

    // ###################################################
    // ###################### OTHER ######################

    @Override
    protected Iterable<ChangePropagationSpecification> createChangePropagationSpecifications() {
        // Returns the ChangePropagationSpecifications developed for the application using
        // the Reactions language
        return Collections.singletonList(new Confidentiality2AnnotationsChangePropagationSpecification());
    }

    @Override
    protected Iterable<VitruvDomain> getVitruvDomains() {
        // Returns the domains that are relevant for the application test
        List<VitruvDomain> result = new ArrayList<VitruvDomain>();
        result.add(new JavaDomainProvider().getDomain());
        result.add(new ConfidentialityDomainProvider().getDomain());
        return result;
    }

    // ###################################################
    // ##################### ACCESS ######################

    protected ConfidentialitySpecification getRootElement() {
        return (ConfidentialitySpecification) getFirstRootElement(getConfidentialityModelRelativePath());
    }

    protected String getConfidentialityModelAbsolutePath() {
        return getCurrentTestProjectConfidentialityModel().getAbsolutePath();
    }

    protected String getConfidentialityModelRelativePath() {
        return new File(MODEL_FOLDER_NAME, getConfidentialityModelFileName()).getPath();
    }

    protected File getCurrentTestProjectConfidentialityModel() {
        return new File(getCurrentTestProjectModelFolder(), getConfidentialityModelFileName());
    }

    protected String getConfidentialityModelFileName() {
        return MODEL_NAME + "." + ConfidentialityNamespace.FILE_EXTENSION;
    }

    protected File getCurrentTestProjectModelFolder() {
        return new File(getCurrentTestProjectFolder(), MODEL_FOLDER_NAME);
    }

    protected File getCurrentTestProjectSrcFolder() {
        return new File(getCurrentTestProjectFolder(), TestUtil.SOURCE_FOLDER);
    }

    protected File getJavaFile(File parent, String child) {
        return new File(parent, child + "." + JavaNamespace.FILE_EXTENSION);
    }

    protected ConfCorrespondences correspondences() {
        return correspondences;
    }

    protected DataSet addDataSet() throws IOException {
        DataSet dataSet = ConfElementsCreator.createDataSet();
        addSaveAndSynchronize(dataSet);
        return dataSet;
    }

    protected DataSet addDataSetWithName(String name) throws IOException {
        DataSet dataSet = ConfElementsCreator.createDataSet();
        dataSet.setName(name);
        addSaveAndSynchronize(dataSet);
        return dataSet;
    }

    protected DataSet addDataSetWithId(String id) throws IOException {
        DataSet dataSet = ConfElementsCreator.createDataSet();
        dataSet.setId(id);
        addSaveAndSynchronize(dataSet);
        return dataSet;
    }

    protected void addSaveAndSynchronize(DataSet dataSet) throws IOException {
        getRootElement().getDataIdentifier().add(dataSet);
        saveAndSynchronizeChanges(getRootElement());
    }

    protected List<DataSet> addDataSets(int amount) throws IOException {
        return addDataSets(Optional.of(amount));
    }

    protected List<DataSet> addDataSets(Optional<Integer> amount) throws IOException {
        List<DataSet> dataSets;
        if (amount.isPresent()) {
            dataSets = ConfElementsCreator.createDataSets(amount.get());
        } else {
            dataSets = ConfElementsCreator.createDataSets(3);
        }
        for (DataSet dataSet : dataSets) {
            getRootElement().getDataIdentifier().add(dataSet);
            saveAndSynchronizeChanges(getRootElement());
        }
        return dataSets;
    }

    protected void checkDataSet(DataSet dataSet) {
        final Set<EnumConstant> corresponding = correspondences().getCorrespondingEnumConstants(dataSet);
        EnumConstant enumConstant = ConfAssertions.getSingleObject(corresponding);
        ConfAssertions.assertEqualDataSets(dataSet, enumConstant);
    }

    protected void checkDataSets(Iterable<DataSet> dataSets) {
        for (DataSet dataSet : dataSets) {
            checkDataSet(dataSet);
        }
    }

    protected ParametersAndDataPair addPuDPair() throws IOException {
        ParametersAndDataPair pudPair = ConfElementsCreator.createParametersAndDataPair();
        addSaveAndSynchronize(pudPair);
        return pudPair;
    }

    protected ParametersAndDataPair addPuDPairWithName(String name) throws IOException {
        ParametersAndDataPair pudPair = ConfElementsCreator.createParametersAndDataPair();
        pudPair.setName(name);
        addSaveAndSynchronize(pudPair);
        return pudPair;
    }

    protected void addSaveAndSynchronize(ParametersAndDataPair pudPair) throws IOException {
        getRootElement().getParametersAndDataPairs().add(pudPair);
        saveAndSynchronizeChanges(getRootElement());
    }

    protected List<ParametersAndDataPair> addPuDPairs(int amount) throws IOException {
        return addPuDPairs(Optional.of(amount));
    }

    protected List<ParametersAndDataPair> addPuDPairs(Optional<Integer> amount) throws IOException {
        List<ParametersAndDataPair> pudPairs;
        if (amount.isPresent()) {
            pudPairs = ConfElementsCreator.createParametersAndDataPairs(amount.get());
        } else {
            pudPairs = ConfElementsCreator.createParametersAndDataPairs(3);
        }
        for (ParametersAndDataPair pudPair : pudPairs) {
            getRootElement().getParametersAndDataPairs().add(pudPair);
            saveAndSynchronizeChanges(getRootElement());
        }
        return pudPairs;
    }

    protected void checkPuDPair(ParametersAndDataPair pudPair) {
        final Set<EnumConstant> corresponding = correspondences().getCorrespondingEnumConstants(pudPair);
        EnumConstant enumConstant = ConfAssertions.getSingleObject(corresponding);
        ConfAssertions.assertEqualParametersAndDataPairs(pudPair, enumConstant);
    }

    protected void checkPuDPairs(Iterable<ParametersAndDataPair> pudPairs) {
        for (ParametersAndDataPair pudPair : pudPairs) {
            checkPuDPair(pudPair);
        }
    }
}
