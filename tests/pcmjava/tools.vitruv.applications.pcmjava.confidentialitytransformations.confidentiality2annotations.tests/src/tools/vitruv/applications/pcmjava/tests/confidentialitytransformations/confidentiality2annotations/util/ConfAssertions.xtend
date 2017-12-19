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
import org.junit.Assert
import edu.kit.kastel.scbs.confidentiality.data.DataSet
import edu.kit.kastel.scbs.confidentiality.repository.ParametersAndDataPair
import java.util.Collection
import org.emftext.language.java.references.StringReference

//import org.eclipse.jdt.core.dom.Expression

public final class ConfAssertions {
	
    /**
     * No instantiation for utility classes.
     */
    private new() {
        // empty
    }

	//// ROOT PACKAGE ////
	
	static def void assertConfidentialityPackageExists(Set<Package> correspondingPackages) {
		var foundPackage = false 
		for (Package pack : correspondingPackages) {
			foundPackage = foundPackage || pack.getName().equals(ConfContent.CONFIDENTIALITY_REPOSITORY_PACKAGE) 
		}
		assertTrue("No corresponding java package for root found", foundPackage) 
	}
	
	//// ROOT ENUMERATIONS ////
	
	static def void assertRootEnumerationsExist(Set<Enumeration> correspondingEnumerations) {
		var Set<String> foundEnumerations = scanCorrespondingEnumerations(correspondingEnumerations) 
		checkCorrespondingEnumerations(foundEnumerations) 
	}
	
	private static def Set<String> scanCorrespondingEnumerations(Set<Enumeration> correspondingEnumerations) {
		var Set<String> foundEnumerations=new HashSet() 
		for (Enumeration enumeration : correspondingEnumerations) {
			var String name=enumeration.getName() 
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
	static def void assertRootAnnotationExists(Set<Annotation> correspondingAnnotations) {
		var foundAnnotation = false 
		for (Annotation annotation : correspondingAnnotations) {
			foundAnnotation = foundAnnotation || annotation.getName().equals(ConfContent.INFORMATION_FLOW_ANNOTATION) 
		}
		assertTrue("No corresponding java annotation for root found", foundAnnotation) 
	}
	
	static def boolean checkRootAnnotationContent(File enumeration) throws IOException {
		return checkContentIgnoreWhitespaceAndLb(enumeration, ConfContent.INFORMATION_FLOW_ANNOTATION_CONTENT) 
	}
	
	//// DATA SETS ////
	
	static def void assertEqualDataSets(DataSet dataSet, EnumConstant correspondingEnumConstant) {
        val List<Expression> arguments = correspondingEnumConstant.arguments
        val enumConstantName = correspondingEnumConstant.getName
        val id = (arguments.get(0) as StringReference).value
        val name = (arguments.get(1) as StringReference).value
		// compare name with enum constant name
		Assert.assertEquals('''DataSet.name != EnumConstant.name''', dataSet.getName, enumConstantName.toLowerCase) 
		// compare name with arguments name
		Assert.assertEquals('''DataSet.name != EnumConstant.arguments.name''', dataSet.getName, name)
		Assert.assertEquals('''DataSet.id != EnumConstant.arguments.id''', dataSet.getId, id)
	}
	
	static def boolean checkDataSetsContent(File enumeration) throws IOException {
		return checkContentIgnoreWhitespaceAndLb(enumeration, ConfContent.DATA_SETS_CONTENT) 
	}
	
	static def void assertZeroDataSetEnumConstants(int actual) {
		assertTrue("Not zero data set enum constants.", actual == 0);
	}
	
	static def void assertNumberOfDataSetEnumConstants(int expected, int actual) {
		assertTrue('''Expected «expected» data set enum constant, but got «actual».''', actual == expected);
	}
	
	//// PARAMETERS AND DATA PAIRS ////

	static def void assertParametersAndDataPairCorrespondence(ParametersAndDataPair parametersAndDataPair, EnumConstant correspondingEnumConstant) {
		// compare name with enum constant name
		var boolean equalNames = parametersAndDataPair.getName().equals(correspondingEnumConstant.getName().toLowerCase()) 
		var List<Expression> arguments = correspondingEnumConstant.getArguments() 
		// TODO check more values
		assertTrue('''Corresponding parameters and data pairs have different names: «parametersAndDataPair.getName()»<>«correspondingEnumConstant.getName()»''', equalNames) 
	}
	
	static def boolean checkPuDPairsContent(File enumeration) throws IOException {
		return checkContentIgnoreWhitespaceAndLb(enumeration, ConfContent.PARAMETERS_AND_DATA_PAIRS_CONTENT) 
	}
	
	//// GENERAL ////
	
	static def void assertNumberOfCorrespondences(int expected, int actual) {
		Assert.assertTrue('''Unexpected number of correspondences.''', expected == actual) 
	}
	
	static def void assertEmptyCorrespondences(EObject obj, boolean empty) {
		Assert.assertTrue('''Correspondences of '«obj.toString()»' are not empty.''', empty) 
	}
	
	static def <T> T getSingleObject(Collection<T> obj) {
		Assert.assertTrue('''Collection '«obj»' does not have exactly one element.''', obj.size == 1)
		return obj.head
	}

	static def void assertFileExists(File file) {
		assertTrue('''«file.getName()» is null.''', file !== null)
        assertTrue('''«file.getName()» does not exist.''', file.exists())
        assertTrue('''«file.getName()» is not a file.''', file.isFile())
	}
	
	static def boolean checkContentIgnoreWhitespaceAndLb(File file, String toCompare) throws IOException {
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