package tools.vitruv.applications.pcmjava.confidentialitytransformations.confidentiality2annotations

import edu.kit.kastel.scbs.confidentiality.data.DataIdentifying
import edu.kit.kastel.scbs.confidentiality.data.DataSet
import edu.kit.kastel.scbs.confidentiality.repository.ParametersAndDataPair
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.util.EcoreUtil
import org.emftext.language.java.arrays.ArrayInitializationValue
import org.emftext.language.java.arrays.ArrayInstantiationByValuesTyped
import org.emftext.language.java.arrays.ArraysFactory
import org.emftext.language.java.classifiers.Annotation
import org.emftext.language.java.classifiers.Class
import org.emftext.language.java.classifiers.ClassifiersFactory
import org.emftext.language.java.classifiers.ConcreteClassifier
import org.emftext.language.java.classifiers.Enumeration
import org.emftext.language.java.containers.CompilationUnit
import org.emftext.language.java.containers.Package
import org.emftext.language.java.expressions.Expression
import org.emftext.language.java.literals.LiteralsFactory
import org.emftext.language.java.members.EnumConstant
import org.emftext.language.java.references.ReferencesFactory
import org.emftext.language.java.references.StringReference
import org.emftext.language.java.types.NamespaceClassifierReference
import org.emftext.language.java.types.TypesFactory
import org.emftext.language.java.annotations.AnnotationsFactory
import org.emftext.language.java.annotations.AnnotationAttributeSetting
import org.emftext.language.java.annotations.AnnotationParameterList
import org.emftext.language.java.arrays.ArrayInstantiationByValuesUntyped
import java.util.List
import org.emftext.language.java.arrays.ArrayInitializer

class Confidentiality2AnnotationsUtil {
	
	public static final val RETENTION_ANNOTATION = Confidentiality2AnnotationsUtil.getAnnotationByName("Retention")
	
	public static final val TARGET_ANNOTATION = Confidentiality2AnnotationsUtil.getAnnotationByName("Target")
	
	public static final val INFORMATION_FLOW_ANNOTATION = Confidentiality2AnnotationsUtil.getAnnotationByName("InformationFlow")
	
	public static final val STRING_CLASS = Confidentiality2AnnotationsUtil.getClassByName("String")
	
	public static final val ELEMENT_TYPE_ENUMERATION = Confidentiality2AnnotationsUtil.getEnumerationByName("ElementType")
	
	public static final val RETENTION_POLICY_ENUMERATION = Confidentiality2AnnotationsUtil.getEnumerationByName("RetentionPolicy")
	
	public static final val DATA_SETS_ENUMERATION = Confidentiality2AnnotationsUtil.getEnumerationByName("DataSets")
	
	public static final val DATA_SET_MAP_ENTRIES_ENUMERATION = Confidentiality2AnnotationsUtil.getEnumerationByName("DataSetMapEntries")
	
	public static final val PARAMETETERIZED_DATA_SET_MAP_ENTRIES_ENUMERATION = Confidentiality2AnnotationsUtil.getEnumerationByName("ParameterizedDataSetMapEntries")
	
	public static final val PARAMETERS_AND_DATA_PAIRS_ENUMERATION = Confidentiality2AnnotationsUtil.getEnumerationByName("ParametersAndDataPairs")

	public static val DATASET_ARGUMENT_ID = 0;
	
	public static val DATASET_ARGUMENT_NAME = 1;
	
	public static val PAIR_ARGUMENT_PARAMETER_SOURCES = 0;
	
	public static val PAIR_ARGUMENT_DATA_SETS = 1;

	public static def String createEnumConstantName(String name) {
		return name.toUpperCase;
	}
	
// ###################################################
// ################ DATA SET CONTENT #################
	
	public static def void setDataSetEnumConstantContent(EnumConstant enumConstant, DataSet dataSet) {
		enumConstant.arguments.clear
		enumConstant.arguments.add(toStringReference(dataSet.id));
		enumConstant.arguments.add(toStringReference(dataSet.name));
		enumConstant.name = createEnumConstantName(dataSet.name);
	}

	public static def void changeDataSetEnumConstantNameArgument(EnumConstant enumConstant, DataSet dataSet) {
		changeDataSetEnumConstantArgument(enumConstant, DATASET_ARGUMENT_NAME, dataSet.name)
	}
	
	public static def void changeDataSetEnumConstantIdArgument(EnumConstant enumConstant, DataSet dataSet) {
		changeDataSetEnumConstantArgument(enumConstant, DATASET_ARGUMENT_ID, dataSet.id)
	}
	
	private static def void changeDataSetEnumConstantArgument(EnumConstant enumConstant, int position, String name) {
		enumConstant.arguments.remove(position)
		enumConstant.arguments.add(position, toStringReference(name))
	}
	
// ###################################################
// ######## PARAMETERS AND DATA PAIRS CONTENT ########
	
	public static def void setParameterAndDataPairEnumConstantContent(EnumConstant enumConstant, ParametersAndDataPair pair) {
		// (parameterSources : StringArray, dataSets : DataSetArray, null, null)
		enumConstant.name = createEnumConstantName(pair.name);
		enumConstant.arguments.clear
		enumConstant.arguments.add(createPairStringArrayArgument(pair.parameterSources));
		enumConstant.arguments.add(createPairDataSetsArrayArgument(dataIdentifyingToDataSet(pair.dataTargets)));
		enumConstant.arguments.add(LiteralsFactory.eINSTANCE.createNullLiteral);
		enumConstant.arguments.add(LiteralsFactory.eINSTANCE.createNullLiteral);
	}
	
	public static def void insertEnumConstantDataTarget(EnumConstant pair, EnumConstant dataSet) {
		var ArrayInstantiationByValuesTyped dataSetsArrayArgument
		dataSetsArrayArgument = pair.arguments.get(PAIR_ARGUMENT_DATA_SETS) as ArrayInstantiationByValuesTyped;
		val EList<ArrayInitializationValue> arrayArguments = dataSetsArrayArgument.arrayInitializer.initialValues;
		val enumeration = PARAMETERS_AND_DATA_PAIRS_ENUMERATION
		val value = dataSet.name
		val dataSetExpression = Confidentiality2AnnotationsContentCreationUtil.createEnumerationReferenceDotEnumConstant(enumeration, value)
		arrayArguments.add(dataSetExpression);
	}
	
	public static def void removeEnumConstantDataTarget(EnumConstant pair, EnumConstant dataSet) {
		var ArrayInstantiationByValuesTyped dataSetsArrayArgument
		dataSetsArrayArgument = pair.arguments.get(PAIR_ARGUMENT_DATA_SETS) as ArrayInstantiationByValuesTyped;
		val EList<ArrayInitializationValue> dataSetArray = dataSetsArrayArgument.arrayInitializer.initialValues;
		val enumeration = PARAMETERS_AND_DATA_PAIRS_ENUMERATION
		val value = dataSet.name
		val dataSetExpression = Confidentiality2AnnotationsContentCreationUtil.createEnumerationReferenceDotEnumConstant(enumeration, value)
		var ArrayInitializationValue toRemove
		for (dataSetArrayValue : dataSetArray) {
			if(dataSetArrayValue.toString.equals(dataSetExpression)) {
				toRemove = dataSetArrayValue
			}
		}
		dataSetArray.remove(toRemove);
	}
	
	private static def List<DataSet> dataIdentifyingToDataSet(EList<DataIdentifying> dataIds) {
		return dataIds.map[it as DataSet]
	}
	
	private static def Expression createPairStringArrayArgument(EList<String> parameterSources) {
		//// example: new String[] {"call"}
		// new String[]
		val instantiation = createArrayInstantiationByValuesTyped(STRING_CLASS)
		// {"call", ...}
		val initializer = createIntializerForArrayInstantiation(instantiation)
		val EList<ArrayInitializationValue> arrayArguments = initializer.initialValues;
		for (parameterSource : parameterSources) {
			arrayArguments.add(toStringReference(parameterSource));
		}
		return instantiation;
	}
	
	private static def Expression createPairDataSetsArrayArgument(List<DataSet> dataSets) {
		//// example: new DataSets[] {DataSet.NAME}
		// new DataSets[]
		val instantiation = createArrayInstantiationByValuesTyped(DATA_SETS_ENUMERATION)
		// {DataSet.NAME, ...}
		val initializer = createIntializerForArrayInstantiation(instantiation)
		if(!dataSets.empty) {
			addExistingDataSets(initializer, dataSets)
		}
		return instantiation;
	}
	
	private static def void addExistingDataSets(ArrayInitializer initializer, List<DataSet> dataSets) {
		val EList<ArrayInitializationValue> arrayArguments = initializer.initialValues;
		for (dataSet : dataSets) {
			val enumeration = PARAMETERS_AND_DATA_PAIRS_ENUMERATION
			val value = dataSet.name
			val dataSetExpression = Confidentiality2AnnotationsContentCreationUtil.createEnumerationReferenceDotEnumConstant(enumeration, value)
			arrayArguments.add(dataSetExpression);
		}
	}
	
	private static def ArrayInstantiationByValuesTyped createArrayInstantiationByValuesTyped(ConcreteClassifier classifier) {
		// new
		val instantiation = ArraysFactory.eINSTANCE.createArrayInstantiationByValuesTyped;
		// Classifier
		instantiation.typeReference = createNamespaceClassifierReference(classifier)
		// []
		instantiation.arrayDimensionsBefore.add(ArraysFactory.eINSTANCE.createArrayDimension)
		return instantiation
	}
	
	private static def ArrayInitializer createIntializerForArrayInstantiation(ArrayInstantiationByValuesTyped instantiation) {
		val initializer = ArraysFactory.eINSTANCE.createArrayInitializer
		instantiation.arrayInitializer = initializer
		return initializer
	}
	
// ###################################################
// ############### ANNOTATION ADDITIONS ##############

	public def static void addValueToAnnotationAttributeSetting(
			AnnotationAttributeSetting setting,
			ParametersAndDataPair parametersAndDataPair) {
		val ArrayInstantiationByValuesUntyped arrayInstantiation = setting.value as ArrayInstantiationByValuesUntyped
		val EList<ArrayInitializationValue> arrayArguments = arrayInstantiation.arrayInitializer.initialValues
		arrayArguments.add(createParametersAndDataPairExpression(parametersAndDataPair))
	}

	public def static AnnotationAttributeSetting createAndInitializeAnnotationAttributeSetting(
			AnnotationParameterList parameterList,
			Iterable<ParametersAndDataPair> parametersAndDataPairs) {		
		val setting = AnnotationsFactory.eINSTANCE.createAnnotationAttributeSetting
		
		// parametersAndDataPairs = 
		val attribute = Confidentiality2AnnotationsContentCreationUtil.getParametersAndDataPairsInterfaceMethod()
		setting.attribute = attribute
		
		// { ParametersAndDataPairs.NAME, ... }
		setting.value = createAnnotationInstancePairArrayArgument(parametersAndDataPairs)
		return setting
	}
	
	private static def Expression createAnnotationInstancePairArrayArgument(Iterable<ParametersAndDataPair> parametersAndDataPairs) {
		//// example: {ParametersAndDataPairs.NAME, ...}
		val instantiation = ArraysFactory.eINSTANCE.createArrayInstantiationByValuesUntyped
		val initializer = ArraysFactory.eINSTANCE.createArrayInitializer
		val EList<ArrayInitializationValue> arrayArguments = initializer.initialValues
		for (pair : parametersAndDataPairs) {
			arrayArguments.add(createParametersAndDataPairExpression(pair))
		}
		instantiation.arrayInitializer = initializer
		return instantiation
	}
	
	private static def Expression createParametersAndDataPairExpression(ParametersAndDataPair pair) {
		val enumeration = PARAMETERS_AND_DATA_PAIRS_ENUMERATION
		val pairExpression = Confidentiality2AnnotationsContentCreationUtil.createEnumerationReferenceDotEnumConstant(enumeration, pair.name)
		return pairExpression
	}

// ###################################################
// ##################### GENERAL #####################

	//source: tools.vitruv.domains.java.util.JavaPersistenceHelper.xtend
	public static def String getPackageInfoClassName() {
		"package-info"
	} 
	
	//source: tools.vitruv.domains.java.util.JavaPersistenceHelper.xtend
	public static def String buildJavaFilePath(CompilationUnit compilationUnit) {
		return '''src/«FOR namespace : compilationUnit.namespaces SEPARATOR "/" AFTER "/"»«namespace»«ENDFOR»«compilationUnit.name»''';
	}
	
 	//source: tools.vitruv.domains.java.util.JavaPersistenceHelper.xtend
	public static def String buildJavaFilePath(Package javaPackage) {
		return '''src/«FOR namespace : javaPackage.namespaces SEPARATOR "/" AFTER "/"»«namespace»«ENDFOR»«javaPackage.name»/«packageInfoClassName».java''';
	}
	
	public static def Expression toStringReference(String name) {
		val stringLiteral = getStringReference()
		stringLiteral.value = name
		return stringLiteral
	}
	
	public def static StringReference getStringReference() {
		return ReferencesFactory.eINSTANCE.createStringReference()
	}
	
	// source: Pcm2JavaHelper
	public def static NamespaceClassifierReference createNamespaceClassifierReference(
		ConcreteClassifier concreteClassifier) {
		val namespaceClassifierReference = TypesFactory.eINSTANCE.createNamespaceClassifierReference
		val classifierRef = TypesFactory.eINSTANCE.createClassifierReference
		classifierRef.target = EcoreUtil.copy(concreteClassifier)
		namespaceClassifierReference.classifierReferences.add(classifierRef)
		return namespaceClassifierReference
	}
	
	public def static Class getClassByName(String name) {
		val Class clazz = ClassifiersFactory.eINSTANCE.createClass
		clazz.setName(name)
		return clazz
	}
	
	public def static Enumeration getEnumerationByName(String name) {
		val Enumeration enumeration = ClassifiersFactory.eINSTANCE.createEnumeration
		enumeration.setName(name)
		return enumeration
	}
	
	public def static Annotation getAnnotationByName(String name) {
		val Annotation annotation = ClassifiersFactory.eINSTANCE.createAnnotation
		annotation.setName(name)
		return annotation
	}
}