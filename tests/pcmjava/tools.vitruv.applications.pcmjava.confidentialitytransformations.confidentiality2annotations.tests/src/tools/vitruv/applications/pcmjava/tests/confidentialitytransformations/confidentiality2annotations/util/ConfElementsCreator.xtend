package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util

import edu.kit.kastel.scbs.confidentiality.ConfidentialitySpecification
import edu.kit.kastel.scbs.confidentiality.ConfidentialityFactory
import edu.kit.kastel.scbs.confidentiality.data.DataFactory
import edu.kit.kastel.scbs.confidentiality.repository.RepositoryFactory
import java.util.LinkedList

public final class ConfElementsCreator {
	
    private static var GLOBAL_COUNTER = 0;

    /**
     * No instantiation for utility classes.
     */
    private new() {
        // empty
    }

    public static def ConfidentialitySpecification createSpecification() {
        return ConfidentialityFactory.eINSTANCE.createConfidentialitySpecification()
    }

    public static def createParametersAndDataPair() {
        val created = RepositoryFactory.eINSTANCE.createParametersAndDataPair()
        // overwrite standard name
        val id = getId
        created.id = id
        created.name = '''pair_«id»'''
        return created
    }
    
    public static def createParametersAndDataPairs(int amount) {
	    val parametersAndDataPairs = new LinkedList
        for (var i = 0; i < amount; i++) {
            parametersAndDataPairs.add(createParametersAndDataPair);
        }
        return parametersAndDataPairs
    }

    public static def createDataSet() {
        val created = DataFactory.eINSTANCE.createDataSet()
        // overwrite standard name
        val id = getId
        created.id = id
        created.name = '''confidential_«id»'''
        return created
    }
    
    public static def createDataSets(int amount) {
	    val dataSets = new LinkedList
        for (var i = 0; i < amount; i++) {
            dataSets.add(createDataSet);
        }
        return dataSets
    }

    public static def String getId() {
        '''«GLOBAL_COUNTER++»'''
    }
}