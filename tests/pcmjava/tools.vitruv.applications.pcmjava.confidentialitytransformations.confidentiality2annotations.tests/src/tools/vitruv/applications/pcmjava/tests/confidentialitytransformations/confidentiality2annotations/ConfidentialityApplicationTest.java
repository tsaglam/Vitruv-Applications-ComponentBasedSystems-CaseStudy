package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.junit.Assert;

import edu.kit.kastel.scbs.confidentiality.ConfidentialitySpecification;
import tools.vitruv.applications.pcmjava.confidentialitytransformations.confidentiality2annotations.Confidentiality2AnnotationsChangePropagationSpecification;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util.Confidentiality2AnnotationsAssertions;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util.Confidentiality2AnnotationsCorrespondenceHelper;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util.ConfidentialitySpecificationElementsCreator;
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
 * @version 1.0, 26.08.2017
 */
public class ConfidentialityApplicationTest extends VitruviusApplicationTest {

    // Choose an arbitrary name for the confidentiality model
    public final static String MODEL_NAME = "model";

    // Choose an arbitrary name for the confidentiality model folder
    public final static String MODEL_FOLDER_NAME = MODEL_NAME;

    private Confidentiality2AnnotationsCorrespondenceHelper correspondenceHelper;

    private Confidentiality2AnnotationsAssertions assertions;

    // ###################################################
    // ###################### SETUP ######################

    @Override
    protected void setup() {
        correspondenceHelper = new Confidentiality2AnnotationsCorrespondenceHelper(getCorrespondenceModel());
        assertions = new Confidentiality2AnnotationsAssertions(getCorrespondenceModel());

        ConfidentialitySpecification specification = ConfidentialitySpecificationElementsCreator.createSpecification();
        String path = getConfidentialityModelRelativePath();
        try {
            // creates corresponding (java model) root according to reactions
            createAndSynchronizeModel(path, specification);
        } catch (IOException e) {
            Assert.fail("Model changes could not be saved for some reason");
        }
    }

    // ###################################################
    // #################### CLEAN UP #####################

    @Override
    protected void cleanup() {
        // TODO Auto-generated method stub

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

    protected Confidentiality2AnnotationsCorrespondenceHelper getCorrespondenceHelper() {
        return correspondenceHelper;
    }

    protected Confidentiality2AnnotationsAssertions getAssertionsHelper() {
        return assertions;
    }

    protected IJavaProject getCurrentTestProject() {
        File file = getCurrentTestProjectFolder();
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = root.getProject(file.getName());
        IJavaProject javaProject;
        try {
            project.create(null);
            project.open(null);
            IProjectDescription description = project.getDescription();
            description.setNatureIds(new String[] { JavaCore.NATURE_ID });
            project.setDescription(description, null);
            javaProject = JavaCore.create(project);
        } catch (CoreException e) {
            javaProject = null;
        }
        return javaProject;
    }
}
