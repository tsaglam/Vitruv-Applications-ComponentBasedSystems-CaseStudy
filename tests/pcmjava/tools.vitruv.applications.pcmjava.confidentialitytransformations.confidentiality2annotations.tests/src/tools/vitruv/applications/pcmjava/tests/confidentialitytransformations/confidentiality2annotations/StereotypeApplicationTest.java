package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Assert;
import org.modelversioning.emfprofile.IProfileFacade;
import org.modelversioning.emfprofile.Profile;
import org.modelversioning.emfprofile.impl.ProfileFacadeImpl;
import org.modelversioning.emfprofileapplication.ProfileImport;
import org.palladiosimulator.pcm.repository.Repository;

import tools.vitruv.applications.pcmjava.pojotransformations.pcm2java.Pcm2JavaChangePropagationSpecification;
import tools.vitruv.applications.pcmjava.tests.util.Pcm2JavaTestUtils;
import tools.vitruv.domains.emfprofiles.EmfProfilesDomainProvider;
import tools.vitruv.domains.pcm.PcmDomainProvider;
import tools.vitruv.domains.pcm.PcmNamespace;
import tools.vitruv.framework.change.processing.ChangePropagationSpecification;
import tools.vitruv.framework.domains.VitruvDomain;

public class StereotypeApplicationTest extends ConfidentialityApplicationTest {

    private static final String CONFIDENTIALITY_MM = "http://edu.kit.kastel.scbs.confidentiality";

    private static final String CONFIDENTIALITY_PROFILE = "http://edu.kit.kastel.scbs/pcmconfidentialityprofile";

    @Override
    protected void setup() {
        super.setup();
        try {
            createAndSyncRepository(getRepositoryRelativePath());
        } catch (IOException e) {
            Assert.fail("Repository changes could not be saved for some reason.");
        }
        resourceSet = new ResourceSetImpl();
        loadProfile();
        loadModel();
        try {
            // repository is the profile application resource
            createProfileFacade(getRepository().eResource());
        } catch (IOException e) {
            Assert.fail("ProfileApplicationResource could not be set for some reason.");
        }
    }

    @Override
    protected Iterable<ChangePropagationSpecification> createChangePropagationSpecifications() {
        Iterable<ChangePropagationSpecification> superSpec = super.createChangePropagationSpecifications();
        List<ChangePropagationSpecification> result = new ArrayList<>();
        superSpec.forEach(e -> result.add(e));
        result.add(new Pcm2JavaChangePropagationSpecification());
        return result;
    }

    @Override
    protected Iterable<VitruvDomain> getVitruvDomains() {
        Iterable<VitruvDomain> domains = super.getVitruvDomains();
        List<VitruvDomain> result = new ArrayList<>();
        domains.forEach(e -> result.add(e));
        result.add(new EmfProfilesDomainProvider().getDomain());
        result.add(new PcmDomainProvider().getDomain());
        return result;
    }

    protected Repository getRepository() {
        return (Repository) getFirstRootElement(getRepositoryRelativePath());
    }

    protected String getRepositoryRelativePath() {
        return new File(MODEL_FOLDER_NAME, getRepositoryFileName()).getPath();
    }

    protected String getRepositoryAbsolutePath() {
        return getCurrentTestProjectRepository().getAbsolutePath();
    }

    protected File getCurrentTestProjectRepository() {
        return new File(getCurrentTestProjectModelFolder(), getRepositoryFileName());
    }

    protected String getRepositoryFileName() {
        return Pcm2JavaTestUtils.REPOSITORY_NAME + "." + PcmNamespace.REPOSITORY_FILE_EXTENSION;
    }

    protected Repository createAndSyncRepository(final String repositoryName) throws IOException {
        final Repository repo = Pcm2JavaTestUtils.createRepository(repositoryName);
        // add another root model
        createAndSynchronizeModel(getRepositoryRelativePath(), repo);
        return repo;
    }

    protected ResourceSet resourceSet;

    protected Profile profile;

    protected Resource model;

    protected IProfileFacade profileFacade;

    protected ProfileImport profileImport;

    protected void loadProfile() {
        Resource resource = loadResource(CONFIDENTIALITY_PROFILE);
        profile = extractProfile(resource);
        profile.setName("EMFProfile");
    }

    protected void loadModel() {
        model = loadResource(CONFIDENTIALITY_MM);
    }

    private Profile extractProfile(Resource resource) {
        return (Profile) resource.getContents().get(0);
    }

    private Resource loadResource(String path) {
        return resourceSet.getResource(URI.createURI(path), true);
    }

    private void createProfileFacade(Resource profileApplicationRes) throws IOException {
        profileFacade = new ProfileFacadeImpl();
        profileFacade.loadProfile(profile);
        profileFacade.setProfileApplicationResource(profileApplicationRes);
    }
}
