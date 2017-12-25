package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.confidentialityrepository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.modelversioning.emfprofile.Stereotype;
import org.modelversioning.emfprofileapplication.StereotypeApplication;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.OperationSignature;

import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.StereotypeApplicationTest;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util.ConfContent;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util.ConfElementsCreator;
import tools.vitruv.applications.pcmjava.tests.util.Pcm2JavaTestUtils;

public class InformationFlowStereotypeTest extends StereotypeApplicationTest {

    protected OperationInterface opInterface;

    protected OperationSignature opSignature;

    @Before
    public void setUp() throws Exception {
        opInterface = ConfElementsCreator.createOperationInterface(getRepository(), Pcm2JavaTestUtils.INTERFACE_NAME);
        saveAndSynchronizeChanges(getRepository());
        opSignature = ConfElementsCreator.createOperationSignature(opInterface,
                Pcm2JavaTestUtils.OPERATION_SIGNATURE_1_NAME);
        saveAndSynchronizeChanges(getRepository());
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAppliedToValueAfterApplyingStereotype() throws Throwable {
        Stereotype stereotype = profile.getStereotype(ConfContent.INFORMATION_FLOW_ANNOTATION);
        StereotypeApplication stereotypeApplication = profileFacade.apply(stereotype, opSignature);
        saveAndSynchronizeChanges(getRepository());
        Assert.assertNotNull(stereotype);
        Assert.assertNotNull(opSignature);
        Assert.assertNotNull(stereotypeApplication);
        Assert.assertEquals(opSignature, stereotypeApplication.getAppliedTo());
    }

}
