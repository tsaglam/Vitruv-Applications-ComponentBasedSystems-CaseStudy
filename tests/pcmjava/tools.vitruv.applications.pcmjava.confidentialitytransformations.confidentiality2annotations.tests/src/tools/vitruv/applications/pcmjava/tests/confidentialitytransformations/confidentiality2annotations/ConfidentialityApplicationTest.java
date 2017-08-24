package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tools.vitruv.applications.pcmjava.confidentialitytransformations.confidentiality2annotations.Confidentiality2AnnotationsChangePropagationSpecification;
import tools.vitruv.domains.confidentiality.ConfidentialityDomainProvider;
import tools.vitruv.domains.java.JavaDomainProvider;
import tools.vitruv.framework.change.processing.ChangePropagationSpecification;
import tools.vitruv.framework.domains.VitruvDomain;
import tools.vitruv.framework.tests.VitruviusApplicationTest;

public class ConfidentialityApplicationTest extends VitruviusApplicationTest {

    @Override
    protected void setup() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void cleanup() {
        // TODO Auto-generated method stub

    }

    @Override
    protected Iterable<ChangePropagationSpecification> createChangePropagationSpecifications() {
        return Collections.singletonList(new Confidentiality2AnnotationsChangePropagationSpecification());
    }

    @Override
    protected Iterable<VitruvDomain> getVitruvDomains() {
        List<VitruvDomain> result = new ArrayList<VitruvDomain>();
        result.add(new ConfidentialityDomainProvider().getDomain());
        result.add(new JavaDomainProvider().getDomain());
        return result;
    }

}
