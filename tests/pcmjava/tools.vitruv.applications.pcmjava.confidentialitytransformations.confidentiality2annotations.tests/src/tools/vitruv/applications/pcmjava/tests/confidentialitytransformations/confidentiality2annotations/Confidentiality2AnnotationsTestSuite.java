package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.confidentialityrepository.ConfidentialitySpecificationTest;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.confidentialityrepository.DataSetsTest;

@RunWith(Suite.class)

@SuiteClasses({ ConfidentialitySpecificationTest.class, DataSetsTest.class }) // TODO
public class Confidentiality2AnnotationsTestSuite {

}
