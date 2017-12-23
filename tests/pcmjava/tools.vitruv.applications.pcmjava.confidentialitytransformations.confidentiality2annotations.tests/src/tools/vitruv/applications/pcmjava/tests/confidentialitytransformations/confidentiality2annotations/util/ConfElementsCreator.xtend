package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util

import edu.kit.kastel.scbs.confidentiality.ConfidentialitySpecification
import edu.kit.kastel.scbs.confidentiality.ConfidentialityFactory
import edu.kit.kastel.scbs.confidentiality.data.DataFactory
import edu.kit.kastel.scbs.confidentiality.repository.RepositoryFactory
import java.util.LinkedList
import org.palladiosimulator.pcm.repository.Repository
import tools.vitruv.applications.pcmjava.tests.util.Pcm2JavaTestUtils
import org.palladiosimulator.pcm.repository.OperationInterface
import org.palladiosimulator.pcm.repository.OperationSignature

public final class ConfElementsCreator {
	
	public static val PARAMETER_SOURCE = "testParameterSource"
	
	public static val CALL = "\\call"
	
	public static val RESULT = "\\result"
	
	public static val ARRAY_SUFFIX = "[*]"
		
	public static val LENGTH_SUFFIX = "length"
	
    public static val RENAME = "rename";
	
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
        // overwrite standard id and name
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
        // overwrite standard id and name
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
    
    public static def String createParameterSource() {
		'''«PARAMETER_SOURCE»«GLOBAL_COUNTER++»'''
    }
    
    public static def createParameterSources(int amount) {
	    val params = new LinkedList<String>
        for (var i = 0; i < amount; i++) {
            params.add(createParameterSource);
        }
        return params
    }
    
    public static def createSimpleParameterSources() {
		#[CALL, '''«createParameterSource()»''', RESULT, '''«RESULT»«ARRAY_SUFFIX»''', '''«RESULT».«LENGTH_SUFFIX»''', '''«createParameterSource()»''']
    }
    
    public static def createComplexParameterSources() {
    	val params = createParameterSource()
		#['''«createParameterSource()».«createParameterSource()»''', CALL, '''«RESULT»«ARRAY_SUFFIX».«params»«ARRAY_SUFFIX»''', '''«RESULT».«params».«LENGTH_SUFFIX»''']
    }
    
    public static def Repository createRepository(String repositoryName) {
        return Pcm2JavaTestUtils.createRepository(repositoryName)
    }
    
    public static def OperationInterface createOperationInterface(Repository repo, String name) {
        val OperationInterface opInterface = org.palladiosimulator.pcm.repository.RepositoryFactory.eINSTANCE.createOperationInterface
        opInterface.setRepository__Interface(repo)
        opInterface.setEntityName(name)
        return opInterface
    }
    
    public static def OperationSignature createOperationSignature(OperationInterface opInterface, String name) {
        val OperationSignature opSig = org.palladiosimulator.pcm.repository.RepositoryFactory.eINSTANCE.createOperationSignature();
        opSig.setEntityName(name);
        opSig.setInterface__OperationSignature(opInterface);
        return opSig;
    }

    public static def String getId() {
        '''«GLOBAL_COUNTER++»'''
    }
}