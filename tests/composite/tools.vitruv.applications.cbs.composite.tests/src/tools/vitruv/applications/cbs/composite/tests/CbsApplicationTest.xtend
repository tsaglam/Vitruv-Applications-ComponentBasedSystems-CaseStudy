package tools.vitruv.applications.cbs.composite.tests

import tools.vitruv.testutils.VitruviusApplicationTest
import tools.vitruv.applications.pcmjava.pojotransformations.pcm2java.Pcm2JavaChangePropagationSpecification
import tools.vitruv.applications.umljava.java2uml.JavaToUmlChangePropagationSpecification
import tools.vitruv.domains.pcm.PcmDomainProvider
import tools.vitruv.domains.java.JavaDomainProvider
import tools.vitruv.domains.uml.UmlDomainProvider

abstract class CbsApplicationTest extends VitruviusApplicationTest {
	
	override protected createChangePropagationSpecifications() {
		#[new Pcm2JavaChangePropagationSpecification,
			new JavaToUmlChangePropagationSpecification]
	}

	override protected getVitruvDomains() {
		patchDomains();
		return #[new PcmDomainProvider().domain, new JavaDomainProvider().domain, new UmlDomainProvider().domain]
	}
	
	private def patchDomains() {
		new JavaDomainProvider().domain.enableTransitiveChangePropagation
	}

}
