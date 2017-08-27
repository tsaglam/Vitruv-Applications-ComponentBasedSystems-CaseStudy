package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util;

import edu.kit.kastel.scbs.confidentiality.ConfidentialityFactory;
import edu.kit.kastel.scbs.confidentiality.ConfidentialitySpecification;
import edu.kit.kastel.scbs.confidentiality.data.DataFactory;
import edu.kit.kastel.scbs.confidentiality.data.DataSet;
import edu.kit.kastel.scbs.confidentiality.repository.ParametersAndDataPair;
import edu.kit.kastel.scbs.confidentiality.repository.RepositoryFactory;

public final class ConfidentialitySpecificationElementsCreator {

    /**
     * No instantiation for utility classes.
     */
    public ConfidentialitySpecificationElementsCreator() {
        // empty
    }

    public static ConfidentialitySpecification createSpecification() {
        return ConfidentialityFactory.eINSTANCE.createConfidentialitySpecification();
    }

    public static ParametersAndDataPair createParametersAndDataPair() {
        return RepositoryFactory.eINSTANCE.createParametersAndDataPair();
    }

    public static DataSet createDataSet() {
        return DataFactory.eINSTANCE.createDataSet();
    }
}
