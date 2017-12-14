package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.confidentialityrepository;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.eclipse.jdt.core.IJavaProject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.ConfidentialityApplicationTest;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util.Confidentiality2AnnotationsContent;

public class ConfidentialitySpecificationTest extends ConfidentialityApplicationTest {

    private File confidentialityRepository;

    @Before
    public void before() {
        confidentialityRepository = new File(getCurrentTestProjectSrcFolder(),
                Confidentiality2AnnotationsContent.CONFIDENTIALITY_REPOSITORY_PACKAGE);
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
        File enumeration = getJavaFile(confidentialityRepository, Confidentiality2AnnotationsContent.DATA_SETS);
        assertTrue(enumeration.getName() + " does not exist.", enumeration.exists());
        assertTrue(enumeration.getName() + " is not a (java) file.", enumeration.isFile());
    }

    @Test
    public void testInitialPuDPairsEnumerationCreation() throws Throwable {
        File enumeration = getJavaFile(confidentialityRepository,
                Confidentiality2AnnotationsContent.PARAMETERS_AND_DATA_PAIRS);
        assertTrue(enumeration.getName() + " does not exist.", enumeration.exists());
        assertTrue(enumeration.getName() + " is not a (java) file.", enumeration.isFile());
    }

    @Test
    public void testInitialDataSetMapEntriesEnumerationCreation() throws Throwable {
        File enumeration = getJavaFile(confidentialityRepository,
                Confidentiality2AnnotationsContent.DATA_SET_MAP_ENTRIES);
        assertTrue(enumeration.getName() + " does not exist.", enumeration.exists());
        assertTrue(enumeration.getName() + " is not a (java) file.", enumeration.isFile());
    }

    @Test
    public void testInitialDataSetMapsEnumerationCreation() throws Throwable {
        File enumeration = getJavaFile(confidentialityRepository, Confidentiality2AnnotationsContent.DATA_SET_MAPS);
        assertTrue(enumeration.getName() + " does not exist.", enumeration.exists());
        assertTrue(enumeration.getName() + " is not a (java) file.", enumeration.isFile());
    }

    @Test
    public void testInitialParameterizedDataSetMapEntriesEnumerationCreation() throws Throwable {
        File enumeration = getJavaFile(confidentialityRepository,
                Confidentiality2AnnotationsContent.PARAMETERIZED_DATA_SET_MAP_ENTRIES);
        assertTrue(enumeration.getName() + " does not exist.", enumeration.exists());
        assertTrue(enumeration.getName() + " is not a (java) file.", enumeration.isFile());
    }

    @Test
    public void testInitialSpecificationParametersEnumerationCreation() throws Throwable {
        File enumeration = getJavaFile(confidentialityRepository,
                Confidentiality2AnnotationsContent.SPECIFICATION_PARAMETERS);
        assertTrue(enumeration.getName() + " does not exist.", enumeration.exists());
        assertTrue(enumeration.getName() + " is not a (java) file.", enumeration.isFile());
    }

    @Test
    public void testInitialInformationFlowAnnotationCreation() throws Throwable {
        File annotation = getJavaFile(confidentialityRepository,
                Confidentiality2AnnotationsContent.INFORMATION_FLOW_ANNOTATION);
        assertTrue(annotation.getName() + " does not exist.", annotation.exists());
        assertTrue(annotation.getName() + " is not a (java) file.", annotation.isFile());
    }

    @Test
    public void testInitialCorrespondences() throws Throwable {
        getAssertionsHelper().assertRootCorrespondences(getRootElement());
    }

    @Test
    public void testInitialAnnotationCorrespondence() throws Throwable {
        getAssertionsHelper().assertRootAnnotation(getRootElement());
    }

    @Test
    public void testInitialEnumerationCorrespondences() throws Throwable {
        getAssertionsHelper().assertRootEnumerations(getRootElement());
    }

    @Test
    public void testInitialPackageCorrespondence() throws Throwable {
        getAssertionsHelper().assertRootPackage(getRootElement());
    }
}
