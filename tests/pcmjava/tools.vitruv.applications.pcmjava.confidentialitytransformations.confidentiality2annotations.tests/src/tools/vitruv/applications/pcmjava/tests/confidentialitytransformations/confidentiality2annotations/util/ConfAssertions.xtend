package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util

import static org.junit.Assert.assertTrue
import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.util.HashSet
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.emftext.language.java.classifiers.Annotation
import org.emftext.language.java.classifiers.Enumeration
import org.emftext.language.java.containers.Package
import org.emftext.language.java.expressions.Expression
import org.emftext.language.java.members.EnumConstant
import org.emftext.language.java.references.IdentifierReference
import org.junit.Assert
import edu.kit.kastel.scbs.confidentiality.data.DataSet
import edu.kit.kastel.scbs.confidentiality.repository.ParametersAndDataPair
import java.util.Collection
import org.emftext.language.java.references.StringReference
import org.emftext.language.java.arrays.ArrayInstantiationByValuesTyped
import org.emftext.language.java.expressions.UnaryExpression

//import org.eclipse.jdt.core.dom.Expression

public final class ConfAssertions {
	
    /**
     * No instantiation for utility classes.
     */
    private new() {
        // empty
    }

	//// ROOT PACKAGE ////
	
	public static def void assertConfidentialityPackageExists(Set<Package> correspondingPackages) {
		var foundPackage = false 
		for (Package pack : correspondingPackages) {
			foundPackage = foundPackage || pack.name.equals(ConfContent.CONFIDENTIALITY_REPOSITORY_PACKAGE) 
		}
		assertTrue("No corresponding java package for root found", foundPackage) 
	}
	
	//// ROOT ENUMERATIONS ////
	
	public static def void assertRootEnumerationsExist(Set<Enumeration> correspondingEnumerations) {
		var Set<String> foundEnumerations = scanCorrespondingEnumerations(correspondingEnumerations) 
		checkCorrespondingEnumerations(foundEnumerations) 
	}
	
	private static def Set<String> scanCorrespondingEnumerations(Set<Enumeration> correspondingEnumerations) {
		var Set<String> foundEnumerations = new HashSet() 
		for (Enumeration enumeration : correspondingEnumerations) {
			var String name = enumeration.name
			if (ConfContent.CONFIDENTIALITY_REPOSITORY_ENUMERATIONS.contains(name)) {
				foundEnumerations.add(name) 
			}
		}
		return foundEnumerations 
	}
	
	private static def void checkCorrespondingEnumerations(Set<String> foundEnumerations) {
		for (String name : ConfContent.CONFIDENTIALITY_REPOSITORY_ENUMERATIONS) {
			assertTrue('''No corresponding java enumeration '«name»' found.''', foundEnumerations.contains(name)) 
		}
	}
	
	//// ROOT ANNOTATION ////
	
	// TODO unused because of annotation correspondence bug
	public static def void assertRootAnnotationExists(Set<Annotation> correspondingAnnotations) {
		var foundAnnotation = false 
		for (Annotation annotation : correspondingAnnotations) {
			foundAnnotation = foundAnnotation || annotation.name.equals(ConfContent.INFORMATION_FLOW_ANNOTATION) 
		}
		assertTrue("No corresponding java annotation for root found", foundAnnotation) 
	}
	
	public static def boolean checkRootAnnotationContent(File enumeration) throws IOException {
		return checkContentIgnoreWhitespaceAndLb(enumeration, ConfContent.INFORMATION_FLOW_ANNOTATION_CONTENT) 
	}
	
	//// DATA SETS ////
	
	public static def void assertEqualDataSets(DataSet dataSet, EnumConstant correspondingEnumConstant) {
        val List<Expression> arguments = correspondingEnumConstant.arguments
        val enumConstantName = correspondingEnumConstant.name
        val id = (arguments.get(0) as StringReference).value
        val name = (arguments.get(1) as StringReference).value
		// compare name with enum constant name
		Assert.assertEquals('''DataSet.name != EnumConstant.name''', dataSet.name.toUpperCase, enumConstantName) 
		// compare name with arguments name
		Assert.assertEquals('''DataSet.name != EnumConstant.arguments.name''', dataSet.name, name)
		Assert.assertEquals('''DataSet.id != EnumConstant.arguments.id''', dataSet.id, id)
	}
	
	public static def boolean checkDataSetsContent(File enumeration) throws IOException {
		return checkContentIgnoreWhitespaceAndLb(enumeration, ConfContent.DATA_SETS_CONTENT) 
	}
	
	public static def void assertZeroDataSetEnumConstants(int actual) {
		assertTrue("Not zero data set enum constants.", actual == 0);
	}
	
	public static def void assertNumberOfDataSetEnumConstants(int expected, int actual) {
		assertTrue('''Expected «expected» data set enum constant, but got «actual».''', actual == expected);
	}
	
	//// PARAMETERS AND DATA PAIRS ////
	
	public static def void assertEqualParametersAndDataPairs(ParametersAndDataPair parametersAndDataPair, EnumConstant correspondingEnumConstant) {
        val enumConstantName = correspondingEnumConstant.name
		Assert.assertEquals('''ParametersAndDataPair.name != EnumConstant.name''', parametersAndDataPair.name, enumConstantName.toLowerCase)
		
		val paramsArrayArgument = correspondingEnumConstant.arguments.get(0) as ArrayInstantiationByValuesTyped
		val params = paramsArrayArgument.arrayInitializer.initialValues.map[it as StringReference].map[it.value]
		assertEqualParameterSourceArguments(parametersAndDataPair.parameterSources, params)
		
		val dataSetsArrayArgument = correspondingEnumConstant.arguments.get(1) as ArrayInstantiationByValuesTyped
		val expressions = dataSetsArrayArgument.arrayInitializer.initialValues.map[it as Expression]
		val dataSets = parametersAndDataPair.dataTargets.map[it as DataSet]
		assertEqualDataSetArguments(dataSets, expressions)
	}
	
	public static def void assertEqualParameterSourceArguments(List<String> params, List<String> correspondingParams) {
		Assert.assertEquals(params.length, correspondingParams.length)
		for (var i = 0; i < params.length; i++) {
			Assert.assertEquals('''ParametersAndDataPair.parameterSources != EnumConstant.arguments.parameterSources (at position «i»)''', params.get(i), correspondingParams.get(i))
		}
	}
	
	public static def void assertEqualDataSetArguments(List<DataSet> dataSets, List<Expression> correspondingDataSets) {
		Assert.assertEquals(dataSets.length, correspondingDataSets.length)
		for (var i = 0; i < dataSets.length; i++) {
			Assert.assertEquals('''ParametersAndDataPair.dataTargets != EnumConstant.arguments.dataSets (at position «i»)''', toString(dataSets.get(i)), toString(correspondingDataSets.get(i)))
		}
	}
	
	// lower case name expected to be changed to upper case
	private static def String toString(DataSet dataSet) {
		//'''«dataSet.name»_«dataSet.id»'''
		'''«ConfContent.DATA_SETS».«dataSet.name.toUpperCase»'''
	}
	
	private static def String toString(Expression dataSet) {
		val reference = (dataSet as UnaryExpression).child as IdentifierReference
		val classifier = reference.target
		val enumConstant = (reference.next as IdentifierReference).target
		'''«classifier.name».«enumConstant.name»'''
	}
	
	public static def boolean checkPuDPairsContent(File enumeration) throws IOException {
		return checkContentIgnoreWhitespaceAndLb(enumeration, ConfContent.PARAMETERS_AND_DATA_PAIRS_CONTENT) 
	}
	
	//// GENERAL ////
	
	public static def void assertNumberOfCorrespondences(int expected, int actual) {
		Assert.assertTrue('''Unexpected number of correspondences.''', expected == actual) 
	}
	
	public static def void assertEmptyCorrespondences(EObject obj, boolean empty) {
		Assert.assertTrue('''Correspondences of '«obj.toString()»' are not empty.''', empty) 
	}
	
	public static def <T> T getSingleObject(Collection<T> obj) {
		Assert.assertTrue('''Collection '«obj»' does not have exactly one element.''', obj.size == 1)
		return obj.head
	}

	public static def void assertFileExists(File file) {
		assertTrue('''«file.getName()» is null.''', file !== null)
        assertTrue('''«file.getName()» does not exist.''', file.exists())
        assertTrue('''«file.getName()» is not a file.''', file.isFile())
	}
	
	public static def boolean checkContentIgnoreWhitespaceAndLb(File file, String toCompare) throws IOException {
		var List<String> lines=Files.readAllLines(file.toPath()) 
		var StringBuilder sb=new StringBuilder() 
		for (String line : lines) {
			// remove whitespace and line breaks
			var String toAdd=line.replaceAll("((\\s)*(\\n)*)*", "") 
			sb.append(toAdd) 
		}
		return sb.toString().equals(toCompare.replaceAll("((\\s)*(\\n)*)*", "")) 
	}
}