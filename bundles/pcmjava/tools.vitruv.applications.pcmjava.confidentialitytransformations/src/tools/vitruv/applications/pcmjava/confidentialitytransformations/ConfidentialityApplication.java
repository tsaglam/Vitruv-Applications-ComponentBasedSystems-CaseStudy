package tools.vitruv.applications.pcmjava.confidentialitytransformations;

import java.util.HashSet;
import java.util.Set;

import tools.vitruv.applications.pcmjava.confidentialitytransformations.confidentiality2annotations.Confidentiality2AnnotationsChangePropagationSpecification;
import tools.vitruv.applications.pcmjava.confidentialitytransformations.confidentiality2annotations.ConfidentialityApplications2AnnotationsChangePropagationSpecification;
import tools.vitruv.framework.applications.AbstractVitruvApplication;
import tools.vitruv.framework.change.processing.ChangePropagationSpecification;

public class ConfidentialityApplication extends AbstractVitruvApplication {

    @Override
    public Set<ChangePropagationSpecification> getChangePropagationSpecifications() {
        Set<ChangePropagationSpecification> specs = new HashSet<ChangePropagationSpecification>();
        specs.add(new Confidentiality2AnnotationsChangePropagationSpecification());
        specs.add(new ConfidentialityApplications2AnnotationsChangePropagationSpecification());
        return specs;
    }

    @Override
    public String getName() {
        return "Confidentiality <> Annotation";
    }

}
