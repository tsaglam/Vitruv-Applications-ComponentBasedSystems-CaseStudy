package mir.reactions.combinedUmlClassToPcmReactions;

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
    return new mir.routines.combinedUmlClassToPcmReactions.RoutinesFacadesProvider();
  }
  
  protected void setup() {
    this.addReaction(new mir.reactions.umlRepositoryAndSystemPackageReactions.RepositoryOrSystemPackageInsertedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRepositoryAndSystemPackageReactions"))));
    this.addReaction(new mir.reactions.umlRepositoryAndSystemPackageReactions.RepositoryOrSystemPackageDeletedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRepositoryAndSystemPackageReactions"))));
    this.addReaction(new mir.reactions.umlRepositoryAndSystemPackageReactions.RepositoryOrSystemPackageRenamedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRepositoryAndSystemPackageReactions"))));
    this.addReaction(new mir.reactions.umlInterfaceReactions.InterfaceInsertedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlInterfaceReactions"))));
    this.addReaction(new mir.reactions.umlInterfaceReactions.InterfaceRemovedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlInterfaceReactions"))));
    this.addReaction(new mir.reactions.umlInterfaceReactions.InterfaceDeletedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlInterfaceReactions"))));
    this.addReaction(new mir.reactions.umlInterfaceReactions.InterfaceRenamedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlInterfaceReactions"))));
    this.addReaction(new mir.reactions.umlInterfaceGeneralizationReactions.InterfaceGeneralizationAddedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlInterfaceGeneralizationReactions"))));
    this.addReaction(new mir.reactions.umlInterfaceGeneralizationReactions.InterfaceGeneralizationRemovedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlInterfaceGeneralizationReactions"))));
    this.addReaction(new mir.reactions.umlInterfaceGeneralizationReactions.ParentInterfaceReplacedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlInterfaceGeneralizationReactions"))));
    this.addReaction(new mir.reactions.umlSignatureOperationReactions.SignatureOperationInsertedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlSignatureOperationReactions"))));
    this.addReaction(new mir.reactions.umlSignatureOperationReactions.SignatureOperationRemovedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlSignatureOperationReactions"))));
    this.addReaction(new mir.reactions.umlSignatureOperationReactions.SignatureOperationDeletedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlSignatureOperationReactions"))));
    this.addReaction(new mir.reactions.umlSignatureOperationReactions.SignatureOperationRenamedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlSignatureOperationReactions"))));
    this.addReaction(new mir.reactions.umlRegularParameterReactions.RegularParameterInsertedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRegularParameterReactions"))));
    this.addReaction(new mir.reactions.umlRegularParameterReactions.RegularParameterRemovedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRegularParameterReactions"))));
    this.addReaction(new mir.reactions.umlRegularParameterReactions.RegularParameterDeletedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRegularParameterReactions"))));
    this.addReaction(new mir.reactions.umlRegularParameterReactions.RegularParameterNameChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRegularParameterReactions"))));
    this.addReaction(new mir.reactions.umlRegularParameterReactions.RegularParameterDirectionChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRegularParameterReactions"))));
    this.addReaction(new mir.reactions.umlReturnAndRegularParameterTypeReactions.RegularOrReturnParameterTypeChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlReturnAndRegularParameterTypeReactions"))));
    this.addReaction(new mir.reactions.umlReturnAndRegularParameterTypeReactions.RegularOrReturnParameterLowerChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlReturnAndRegularParameterTypeReactions"))));
    this.addReaction(new mir.reactions.umlReturnAndRegularParameterTypeReactions.RegularOrReturnParameterLowerChanged2Reaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlReturnAndRegularParameterTypeReactions"))));
    this.addReaction(new mir.reactions.umlReturnAndRegularParameterTypeReactions.RegularOrReturnParameterUpperChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlReturnAndRegularParameterTypeReactions"))));
    this.addReaction(new mir.reactions.umlReturnAndRegularParameterTypeReactions.RegularOrReturnParameterUpperChanged2Reaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlReturnAndRegularParameterTypeReactions"))));
    this.addReaction(new mir.reactions.umlCompositeDataTypeClassReactions.CompositeDatyTypeClassInsertedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlCompositeDataTypeClassReactions"))));
    this.addReaction(new mir.reactions.umlCompositeDataTypeClassReactions.CompositeDataTypeClassRemovedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlCompositeDataTypeClassReactions"))));
    this.addReaction(new mir.reactions.umlCompositeDataTypeClassReactions.CompositeDataTypeClassDeletedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlCompositeDataTypeClassReactions"))));
    this.addReaction(new mir.reactions.umlCompositeDataTypeClassReactions.CompositeDataTypeClassNameChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlCompositeDataTypeClassReactions"))));
    this.addReaction(new mir.reactions.umlCompositeDataTypeGeneralizationReactions.CompositeDataTypeGeneralizationAddedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlCompositeDataTypeGeneralizationReactions"))));
    this.addReaction(new mir.reactions.umlCompositeDataTypeGeneralizationReactions.CompositeDataTypeGeneralizationRemovedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlCompositeDataTypeGeneralizationReactions"))));
    this.addReaction(new mir.reactions.umlCompositeDataTypeGeneralizationReactions.CompositeDataTypeGeneralizationTypeChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlCompositeDataTypeGeneralizationReactions"))));
    this.addReaction(new mir.reactions.umlInnerDeclarationPropertyReactions.InnerDeclarationPropertyInsertedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlInnerDeclarationPropertyReactions"))));
    this.addReaction(new mir.reactions.umlInnerDeclarationPropertyReactions.InnerDeclarationPropertyRemovedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlInnerDeclarationPropertyReactions"))));
    this.addReaction(new mir.reactions.umlInnerDeclarationPropertyReactions.InnerDeclarationPropertyDeletedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlInnerDeclarationPropertyReactions"))));
    this.addReaction(new mir.reactions.umlInnerDeclarationPropertyReactions.InnerDeclarationPropertyNameChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlInnerDeclarationPropertyReactions"))));
    this.addReaction(new mir.reactions.umlInnerDeclarationPropertyReactions.InnerDeclarationPropertyTypeChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlInnerDeclarationPropertyReactions"))));
    this.addReaction(new mir.reactions.umlInnerDeclarationPropertyReactions.InnerDeclarationPropertyLowerChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlInnerDeclarationPropertyReactions"))));
    this.addReaction(new mir.reactions.umlInnerDeclarationPropertyReactions.InnerDeclarationPropertyLowerChanged2Reaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlInnerDeclarationPropertyReactions"))));
    this.addReaction(new mir.reactions.umlInnerDeclarationPropertyReactions.InnerDeclarationPropertyUpperChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlInnerDeclarationPropertyReactions"))));
    this.addReaction(new mir.reactions.umlInnerDeclarationPropertyReactions.InnerDeclarationPropertyUpperChanged2Reaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlInnerDeclarationPropertyReactions"))));
    this.addReaction(new mir.reactions.umlRepositoryComponentPackageReactions.RepositoryComponentPackageInsertedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRepositoryComponentPackageReactions"))));
    this.addReaction(new mir.reactions.umlRepositoryComponentPackageReactions.RepositoryComponentPackageRemovedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRepositoryComponentPackageReactions"))));
    this.addReaction(new mir.reactions.umlRepositoryComponentPackageReactions.PackageDeletedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRepositoryComponentPackageReactions"))));
    this.addReaction(new mir.reactions.umlRepositoryComponentPackageReactions.RepositoryComponentPackageRenamedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRepositoryComponentPackageReactions"))));
    this.addReaction(new mir.reactions.umlIPREClassReactions.IPREClassRemovedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlIPREClassReactions"))));
    this.addReaction(new mir.reactions.umlIPREClassReactions.IPREClassNameChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlIPREClassReactions"))));
    this.addReaction(new mir.reactions.umlIPREConstructorOperationReactions.IPREConstructorOperationNameChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlIPREConstructorOperationReactions"))));
    this.addReaction(new mir.reactions.umlProvidedRoleRealizationReactions.ProvidedRoleRealizationAddedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlProvidedRoleRealizationReactions"))));
    this.addReaction(new mir.reactions.umlProvidedRoleRealizationReactions.ProvidedRoleRealizationRemovedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlProvidedRoleRealizationReactions"))));
    this.addReaction(new mir.reactions.umlProvidedRoleRealizationReactions.ProvidedRoleRealizationDeletedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlProvidedRoleRealizationReactions"))));
    this.addReaction(new mir.reactions.umlProvidedRoleRealizationReactions.ProvidedRoleRealizationNameChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlProvidedRoleRealizationReactions"))));
    this.addReaction(new mir.reactions.umlProvidedRoleRealizationReactions.ProvidedRoleRealizationTypeChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlProvidedRoleRealizationReactions"))));
    this.addReaction(new mir.reactions.umlRequiredRoleParameterReactions.RequiredRoleParameterInsertedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRequiredRoleParameterReactions"))));
    this.addReaction(new mir.reactions.umlRequiredRoleParameterReactions.RequiredRolePropertyRemovedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRequiredRoleParameterReactions"))));
    this.addReaction(new mir.reactions.umlRequiredRoleParameterReactions.RequiredRolePropertyDeletedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRequiredRoleParameterReactions"))));
    this.addReaction(new mir.reactions.umlRequiredRoleParameterReactions.RequiredRoleParameterNameChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRequiredRoleParameterReactions"))));
    this.addReaction(new mir.reactions.umlRequiredRoleParameterReactions.RequiredRoleParameterTypeChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRequiredRoleParameterReactions"))));
    this.addReaction(new mir.reactions.umlRequiredRolePropertyReactions.RequiredRolePropertyInsertedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRequiredRolePropertyReactions"))));
    this.addReaction(new mir.reactions.umlRequiredRolePropertyReactions.RequiredRolePropertyRemovedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRequiredRolePropertyReactions"))));
    this.addReaction(new mir.reactions.umlRequiredRolePropertyReactions.RequiredRolePropertyDeletedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRequiredRolePropertyReactions"))));
    this.addReaction(new mir.reactions.umlRequiredRolePropertyReactions.RequiredRolePropertyNameChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRequiredRolePropertyReactions"))));
    this.addReaction(new mir.reactions.umlRequiredRolePropertyReactions.RequiredRolePropertyTypeChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlRequiredRolePropertyReactions"))));
    this.addReaction(new mir.reactions.umlAssemblyContextPropertyReactions.AssemblyContextPropertyInsertedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlAssemblyContextPropertyReactions"))));
    this.addReaction(new mir.reactions.umlAssemblyContextPropertyReactions.AssemblyContextPropertyRemovedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlAssemblyContextPropertyReactions"))));
    this.addReaction(new mir.reactions.umlAssemblyContextPropertyReactions.AssemblyContextPropertyDeletedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlAssemblyContextPropertyReactions"))));
    this.addReaction(new mir.reactions.umlAssemblyContextPropertyReactions.AssemblyContextPropertyNameChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlAssemblyContextPropertyReactions"))));
    this.addReaction(new mir.reactions.umlAssemblyContextPropertyReactions.AssemblyContextPropertyTypeChangedReaction(this.getRoutinesFacadesProvider().getRoutinesFacade(ReactionsImportPath.fromPathString("combinedUmlClassToPcmReactions.umlAssemblyContextPropertyReactions"))));
  }
}
