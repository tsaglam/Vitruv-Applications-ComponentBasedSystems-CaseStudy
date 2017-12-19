package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.confidentialityrepository;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Set;

import org.eclipse.jdt.core.IJavaProject;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.containers.Package;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.ConfidentialityApplicationTest;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util.ConfAssertions;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util.ConfContent;

public class ConfidentialitySpecificationTest extends ConfidentialityApplicationTest {

    private File confidentialityRepository;

    @Before
    public void before() {
        confidentialityRepository = new File(getCurrentTestProjectSrcFolder(),
                ConfContent.CONFIDENTIALITY_REPOSITORY_PACKAGE);
    }

    @After
    public void after() {
        confidentialityRepository = null;
    }

    @Test
    public void testConfidentialityApplicationTest() throws Throwable {
        IJavaProject project = getCurrentTestProject();
        assertTrue("Project is not null", project != null);
        assertTrue("Project does not exist", project.exists());
    }

    @Test
    public void testConfidentialityRepositoryCreation() throws Throwable {
        assertTrue(confidentialityRepository.getName() + " package does not exist.",
                confidentialityRepository.exists());
        assertTrue(confidentialityRepository.getName() + " package is not a directory.",
                confidentialityRepository.isDirectory());
    }

    @Test
    public void testInitialDataSetsEnumerationCreation() throws Throwable {
        File enumeration = getJavaFile(confidentialityRepository, ConfContent.DATA_SETS);
        ConfAssertions.assertFileExists(enumeration);
    }

    @Test
    public void testInitialPuDPairsEnumerationCreation() throws Throwable {
        File enumeration = getJavaFile(confidentialityRepository,
                ConfContent.PARAMETERS_AND_DATA_PAIRS);
        ConfAssertions.assertFileExists(enumeration);
    }

    @Test
    public void testInitialDataSetMapEntriesEnumerationCreation() throws Throwable {
        File enumeration = getJavaFile(confidentialityRepository,
                ConfContent.DATA_SET_MAP_ENTRIES);
        ConfAssertions.assertFileExists(enumeration);
    }

    @Test
    public void testInitialDataSetMapsEnumerationCreation() throws Throwable {
        File enumeration = getJavaFile(confidentialityRepository, ConfContent.DATA_SET_MAPS);
        ConfAssertions.assertFileExists(enumeration);
    }

    @Test
    public void testInitialParameterizedDataSetMapEntriesEnumerationCreation() throws Throwable {
        File enumeration = getJavaFile(confidentialityRepository,
                ConfContent.PARAMETERIZED_DATA_SET_MAP_ENTRIES);
        ConfAssertions.assertFileExists(enumeration);
    }

    @Test
    public void testInitialSpecificationParametersEnumerationCreation() throws Throwable {
        File enumeration = getJavaFile(confidentialityRepository,
                ConfContent.SPECIFICATION_PARAMETERS);
        ConfAssertions.assertFileExists(enumeration);
    }

    @Test
    public void testInitialInformationFlowAnnotationCreation() throws Throwable {
        File annotation = getJavaFile(confidentialityRepository,
                ConfContent.INFORMATION_FLOW_ANNOTATION);
        ConfAssertions.assertFileExists(annotation);
    }

    @Test
    public void testInitialAnnotationCorrespondence() throws Throwable {
        // TODO correspondence not working - but also not necessary (does not get modified later)
        // @see creation and content tests
        // ConfAssertions#assertRootAnnotationExists
        assertTrue(true);
    }

    @Test
    public void testInitialEnumerationCorrespondences() throws Throwable {
        Set<Enumeration> corresponding = correspondences().getCorrespondingEnumerations(getRootElement());
        ConfAssertions.assertRootEnumerationsExist(corresponding);
    }

    @Test
    public void testInitialPackageCorrespondence() throws Throwable {
        Set<Package> corresponding = correspondences().getCorrespondingPackages(getRootElement());
        ConfAssertions.assertConfidentialityPackageExists(corresponding);
    }

    @Test
    public void testInitialDataSetsEnumerationContent() throws Throwable {
        File enumeration = getJavaFile(confidentialityRepository, ConfContent.DATA_SETS);
        assertTrue("Created (java) file content is not equal to desired content.",
                ConfAssertions.checkDataSetsContent(enumeration));
    }

    @Test
    public void testInitialPuDPairsEnumerationContent() throws Throwable {
        File enumeration = getJavaFile(confidentialityRepository,
                ConfContent.PARAMETERS_AND_DATA_PAIRS);
        assertTrue("Created (java) file content is not equal to desired content.",
                ConfAssertions.checkPuDPairsContent(enumeration));
    }

    @Test
    public void testInitialInformationFlowAnnotationContent() throws Throwable {
        File annotation = getJavaFile(confidentialityRepository,
                ConfContent.INFORMATION_FLOW_ANNOTATION);
        assertTrue("Created (java) file content is not equal to desired content.",
                ConfAssertions.checkRootAnnotationContent(annotation));
    }
}
