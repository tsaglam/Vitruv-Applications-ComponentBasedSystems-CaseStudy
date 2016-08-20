package edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.seffstatements.code2seff;

import org.palladiosimulator.pcm.repository.BasicComponent;
import org.somox.gast2seff.visitors.AbstractFunctionClassificationStrategy;
import org.somox.gast2seff.visitors.InterfaceOfExternalCallFinding;
import org.somox.gast2seff.visitors.ResourceDemandingBehaviourForClassMethodFinding;

import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.seffstatements.code2seff.BasicComponentFinding;
import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.seffstatements.code2seff.Code2SEFFFactory;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.CorrespondenceModel;

public class POJOJava2PCMCode2SEFFFactory implements Code2SEFFFactory {

    @Override
    public BasicComponentFinding createBasicComponentFinding() {
        return new BasicComponentForPackageMappingFinder();
    }

    @Override
    public InterfaceOfExternalCallFinding createInterfaceOfExternalCallFinding(
            final CorrespondenceModel correspondenceInstance, final BasicComponent basicComponent) {
        return new InterfaceOfExternalCallFinderForPackageMapping(correspondenceInstance, basicComponent);
    }

    @Override
    public ResourceDemandingBehaviourForClassMethodFinding createResourceDemandingBehaviourForClassMethodFinding(
            final CorrespondenceModel correspondenceInstance) {
        return new ResourceDemandingBehaviourForClassMethodFinderForPackageMapping(correspondenceInstance);
    }

    @Override
    public AbstractFunctionClassificationStrategy createAbstractFunctionClassificationStrategy(
            final BasicComponentFinding basicComponentFinding,
            final CorrespondenceModel correspondenceInstance, final BasicComponent basicComponent) {
        return new FunctionClassificationStrategyForPackageMapping(basicComponentFinding, correspondenceInstance,
                basicComponent);
    }

}