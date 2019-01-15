package mir.reactions.umlRequiredRoleParameterReactions;

import tools.vitruv.extensions.dslsruntime.reactions.AbstractReactionsExecutor;
import tools.vitruv.extensions.dslsruntime.reactions.RoutinesFacadesProvider;
import tools.vitruv.extensions.dslsruntime.reactions.structure.ReactionsImportPath;

@SuppressWarnings("all")
class ReactionsExecutor extends AbstractReactionsExecutor {
  public ReactionsExecutor() {
    super(new tools.vitruv.domains.uml.UmlDomainProvider().getDomain(), 
    	new tools.vitruv.domains.pcm.PcmDomainProvider().getDomain());
  }
  
  protected RoutinesFacadesProvider createRoutinesFacadesProvider() {
    return new mir.routines.umlRequiredRoleParameterReactions.RoutinesFacadesProvider();
  }
  
  protected void setup() {
    this.addReaction(new mir.reactions.umlRequiredRoleParameterReactions.RequiredRoleParameterInsertedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("umlRequiredRoleParameterReactions"))));
    this.addReaction(new mir.reactions.umlRequiredRoleParameterReactions.RequiredRolePropertyRemovedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("umlRequiredRoleParameterReactions"))));
    this.addReaction(new mir.reactions.umlRequiredRoleParameterReactions.RequiredRolePropertyDeletedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("umlRequiredRoleParameterReactions"))));
    this.addReaction(new mir.reactions.umlRequiredRoleParameterReactions.RequiredRoleParameterNameChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("umlRequiredRoleParameterReactions"))));
    this.addReaction(new mir.reactions.umlRequiredRoleParameterReactions.RequiredRoleParameterTypeChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("umlRequiredRoleParameterReactions"))));
  }
}
