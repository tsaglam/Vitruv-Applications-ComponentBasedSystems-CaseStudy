package mir.reactions.reactionsUmlToPcm.umlToPcm;

import tools.vitruv.domains.pcm.PcmDomainProvider;
import tools.vitruv.domains.uml.UmlDomainProvider;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractReactionsExecutor;

@SuppressWarnings("all")
public class ExecutorUmlToPcm extends AbstractReactionsExecutor {
  public ExecutorUmlToPcm() {
    super(new UmlDomainProvider().getDomain(), 
    	new PcmDomainProvider().getDomain());
  }
  
  protected void setup() {
    tools.vitruv.framework.userinteraction.UserInteracting userInteracting = getUserInteracting();
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.RenamedElementReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.RenamedElementReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.DeletedElementReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.DeletedElementReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.ChangedMultiplicityLowerValueReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.ChangedMultiplicityLowerValueReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.ChangedMultiplicityUpperValueReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.ChangedMultiplicityUpperValueReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.ChangedMultiplicityLowerReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.ChangedMultiplicityLowerReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.ChangedMultiplicityUpperReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.ChangedMultiplicityUpperReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.CreatedUmlModelReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.CreatedUmlModelReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.CreatedPrimitiveDataTypeReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.CreatedPrimitiveDataTypeReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.CreatedDataTypeReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.CreatedDataTypeReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.CreatedPropertyForDataTypeReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.CreatedPropertyForDataTypeReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.DeletedPropertyFromDataTypeReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.DeletedPropertyFromDataTypeReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.ChangedPropertyTypeReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.ChangedPropertyTypeReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.DeletedDataTypeReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.DeletedDataTypeReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.CreatedInterfaceReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.CreatedInterfaceReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.CreatedInterfaceOperationReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.CreatedInterfaceOperationReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.AddedInterfaceOperationParameterReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.AddedInterfaceOperationParameterReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.ChangedParameterTypeReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.ChangedParameterTypeReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.ChangedParameterNameReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.ChangedParameterNameReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.ChangedParameterDirectionReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.ChangedParameterDirectionReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.DeletedParameterReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.DeletedParameterReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.CreatedComponentReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.CreatedComponentReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.AddedUsesRelationshipReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.AddedUsesRelationshipReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.ChangedUsesRelationshipInterfaceReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.ChangedUsesRelationshipInterfaceReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.RemovedUsesRelationshipInterfaceReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.RemovedUsesRelationshipInterfaceReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.RemovedUsesRelationshipReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.RemovedUsesRelationshipReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.CreatedInterfaceRealizationRelationshipReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.CreatedInterfaceRealizationRelationshipReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.ChangedInterfaceRealizationInterfaceReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.ChangedInterfaceRealizationInterfaceReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.RemovedInterfaceRealizationInterfaceReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.RemovedInterfaceRealizationInterfaceReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToPcm.umlToPcm.RemovedInterfaceRealizationRelationshipReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToPcm.umlToPcm.RemovedInterfaceRealizationRelationshipReaction(userInteracting));
  }
}