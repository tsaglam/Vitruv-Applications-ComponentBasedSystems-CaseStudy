package tools.vitruv.applications.pcmjava.confidentialitytransformations;

import java.util.HashSet;
import java.util.Set;

import mir.reactions.ConfidentialityToJavaChangePropagationSpecification; // TODO remove
// TODO insert import tools.vitruv.applications.pcmjava.confidentialitytransformations.confidentiality2annotations.ConfidentialityToJavaChangePropagationSpecification;
import tools.vitruv.framework.applications.AbstractVitruvApplication;
import tools.vitruv.framework.change.processing.ChangePropagationSpecification;

public class ConfidentialityApplication extends AbstractVitruvApplication {

    @Override
    public Set<ChangePropagationSpecification> getChangePropagationSpecifications() {
        Set<ChangePropagationSpecification> specs = new HashSet<ChangePropagationSpecification>();
        specs.add(new ConfidentialityToJavaChangePropagationSpecification());
        return specs;
    }

    @Override
    public String getName() {
        return "Confidentiality <> Annotation";
    }

}
