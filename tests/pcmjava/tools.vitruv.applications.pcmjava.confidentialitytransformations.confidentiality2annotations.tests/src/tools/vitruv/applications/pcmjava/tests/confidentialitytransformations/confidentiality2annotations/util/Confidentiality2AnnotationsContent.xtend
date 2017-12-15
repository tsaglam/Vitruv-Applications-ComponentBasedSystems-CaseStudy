package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util

final class Confidentiality2AnnotationsContent {

    public static final String CONFIDENTIALITY_REPOSITORY_PACKAGE = "confidentialityRepository";

    public static final String INFORMATION_FLOW_ANNOTATION = "InformationFlow";
    
    public static final String DATA_SETS = "DataSets";
    
    public static final String PARAMETERS_AND_DATA_PAIRS = "ParametersAndDataPairs";
    
 	public final static String SPECIFICATION_PARAMETERS = "SpecificationParameters";
     
 	public final static String PARAMETERIZED_DATA_SET_MAP_ENTRIES = "ParameterizedDataSetMapEntries";
      
    public static final String DATA_SET_MAPS = "DataSetMaps";
       
    public static final String DATA_SET_MAP_ENTRIES = "DataSetMapEntries";
    
    public static final String SEPARATOR = "((\\s)*(\\n)*(;)*)*";
    
    public static final String WHITESPACE_SEPARATOR = "((\\s)*(\\n)*)*";

    public static final String DATA_SETS_CONTENT = '''
    package «CONFIDENTIALITY_REPOSITORY_PACKAGE»;
    
    public enum «DATA_SETS» {;
    	
        public final String id;
        public final String name;
    	
        private «DATA_SETS»(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }
    '''

    public static final String PARAMETERS_AND_DATA_PAIRS_CONTENT = '''
    package «CONFIDENTIALITY_REPOSITORY_PACKAGE»;
    
    public enum «PARAMETERS_AND_DATA_PAIRS» {;
    	
        public final String[] parameterSources;
        public final DataSets[] dataSets;
    	public final DataSetMapEntries[] dataSetMapEntries;
    	public final ParameterizedDataSetMapEntries[] parameterizedDataSetMapEntries;
    	
        private «PARAMETERS_AND_DATA_PAIRS»(
            String[] parameterSources,
            DataSets[] dataSets, 
            DataSetMapEntries[] dataSetMapEntries, 
            ParameterizedDataSetMapEntries[] parameterizedDataSetMapEntries) {
            this.parameterSources = parameterSources;
        	this.dataSets = dataSets;
        	this.dataSetMapEntries = dataSetMapEntries;
        	this.parameterizedDataSetMapEntries = parameterizedDataSetMapEntries;
        }
    }
    '''
	
    public static final String INFORMATION_FLOW_ANNOTATION_CONTENT = '''
	package «CONFIDENTIALITY_REPOSITORY_PACKAGE»;
	
	import java.lang.annotation.ElementType;
	import java.lang.annotation.Retention;
	import java.lang.annotation.RetentionPolicy;
	import java.lang.annotation.Target;
	
	public
	@Retention(RetentionPolicy.SOURCE)
	@Target({ElementType.METHOD, ElementType.TYPE})
	@interface «INFORMATION_FLOW_ANNOTATION» {
	    «PARAMETERS_AND_DATA_PAIRS»[] «PARAMETERS_AND_DATA_PAIRS.toFirstLower»();
	}
    '''
}