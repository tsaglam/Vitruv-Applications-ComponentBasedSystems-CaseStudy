package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.confidentialityrepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.ConfidentialityApplicationTest;

public class ConfidentialitySpecificationTest extends ConfidentialityApplicationTest {

    private static String DATASETS = "DataSets";
    private static String PARAMETERS_AND_DATA_PAIRS = "ParametersAndDataPairs";

    @Before
    public void before() {

    }

    @After
    public void after() {

    }

    @Test
    public void testInitialAnnotationCorrespondence() throws Throwable {
        getAssertions().assertRootAnnotation(getRootElement());
    }

    @Test
    public void testInitialEnumerationCorrespondences() throws Throwable {
        getAssertions().assertRootEnumerations(getRootElement());
    }

    @Test
    public void testInitialPackageCorrespondence() throws Throwable {
        getAssertions().assertRootPackage(getRootElement());
    }
}
