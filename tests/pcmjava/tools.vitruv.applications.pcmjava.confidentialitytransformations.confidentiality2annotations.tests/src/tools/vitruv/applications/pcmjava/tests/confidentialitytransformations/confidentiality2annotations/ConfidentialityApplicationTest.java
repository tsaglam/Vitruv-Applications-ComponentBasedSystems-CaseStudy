package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.core.IJavaProject;
import org.junit.Assert;

import edu.kit.kastel.scbs.confidentiality.ConfidentialitySpecification;
import tools.vitruv.applications.pcmjava.confidentialitytransformations.confidentiality2annotations.Confidentiality2AnnotationsChangePropagationSpecification;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util.ConfCorrespondences;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util.ConfElementsCreator;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util.ConfJavaModelUtil;
import tools.vitruv.domains.confidentiality.ConfidentialityDomainProvider;
import tools.vitruv.domains.confidentiality.ConfidentialityNamespace;
import tools.vitruv.domains.java.JavaDomainProvider;
import tools.vitruv.framework.change.processing.ChangePropagationSpecification;
import tools.vitruv.framework.domains.VitruvDomain;
import tools.vitruv.framework.tests.VitruviusApplicationTest;
import tools.vitruv.framework.tests.VitruviusTest;
import tools.vitruv.framework.tests.VitruviusUnmonitoredApplicationTest;
import tools.vitruv.framework.tests.util.TestUtil;

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
public class ConfidentialityApplicationTest extends VitruviusApplicationTest {

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
        javaProject = null;

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

    protected String getConfidentialityModelRelativePath() {
        return new File(MODEL_FOLDER_NAME, MODEL_NAME + "." + ConfidentialityNamespace.FILE_EXTENSION).getPath();
    }

    protected File getCurrentTestProjectConfidentialityModel() {
        return new File(getCurrentTestProjectModelFolder(), MODEL_NAME + "." + ConfidentialityNamespace.FILE_EXTENSION);
    }

    protected File getCurrentTestProjectModelFolder() {
        return new File(getCurrentTestProjectFolder(), MODEL_FOLDER_NAME);
    }

    protected File getCurrentTestProjectSrcFolder() {
        return new File(getCurrentTestProjectFolder(), TestUtil.SOURCE_FOLDER);
    }

    protected File getJavaFile(File parent, String child) {
        return new File(parent, child + ".java");
    }

    protected ConfCorrespondences correspondences() {
        return correspondences;
    }

    private IJavaProject javaProject;

    protected IJavaProject getCurrentTestProject() {
        if (javaProject == null) {
            javaProject = ConfJavaModelUtil.createJavaProjectByPath(getCurrentTestProjectFolder().getName());
        }
        return javaProject;
    }
}
