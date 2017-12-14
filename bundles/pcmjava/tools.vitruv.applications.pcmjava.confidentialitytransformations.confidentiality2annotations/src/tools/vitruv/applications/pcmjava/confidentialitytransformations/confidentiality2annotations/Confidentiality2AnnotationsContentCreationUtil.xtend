package tools.vitruv.applications.pcmjava.confidentialitytransformations.confidentiality2annotations

import tools.vitruv.applications.pcmjava.confidentialitytransformations.confidentiality2annotations.Confidentiality2AnnotationsUtil
import org.emftext.language.java.annotations.AnnotationsFactory
import org.emftext.language.java.modifiers.AnnotationInstanceOrModifier
import org.emftext.language.java.literals.LiteralsFactory
import org.emftext.language.java.classifiers.Enumeration
import org.emftext.language.java.members.Field
import org.emftext.language.java.members.Constructor
import org.emftext.language.java.classifiers.Annotation
import org.emftext.language.java.members.MembersFactory
import org.emftext.language.java.parameters.Parameter
import org.emftext.language.java.parameters.ParametersFactory
import org.emftext.language.java.statements.Statement
import org.emftext.language.java.statements.StatementsFactory
import org.emftext.language.java.expressions.ExpressionsFactory
import org.emftext.language.java.references.ReferencesFactory
import org.emftext.language.java.operators.OperatorsFactory
import org.eclipse.emf.ecore.util.EcoreUtil
import org.emftext.language.java.modifiers.ModifiersFactory
import org.emftext.language.java.types.TypeReference
import org.emftext.language.java.classifiers.ConcreteClassifier
import org.emftext.language.java.annotations.AnnotationInstance
import org.eclipse.emf.common.util.EList
import org.emftext.language.java.members.MemberContainer
import org.emftext.language.java.arrays.ArraysFactory
import org.emftext.language.java.expressions.Expression
import org.emftext.language.java.members.EnumConstant
import org.emftext.language.java.members.InterfaceMethod
import org.emftext.language.java.arrays.ArrayInitializationValue

class Confidentiality2AnnotationsContentCreationUtil {

// ###################################################
// ########### INFORMATION FLOW ANNOTATION ########### 

	public def static setInformationFlowAnnotation(Annotation informationFlowAnnotation) {
		// package already set in compilation unit
		informationFlowAnnotation.addImport("java.lang.annotation.ElementType");
		informationFlowAnnotation.addImport("java.lang.annotation.Retention");
		informationFlowAnnotation.addImport("java.lang.annotation.RetentionPolicy");
		informationFlowAnnotation.addImport("java.lang.annotation.Target");
		//informationFlowAnnotation.makePublic()

		// workaround because of unsupported annotation instance insertion
		// note: the order of modifier and annotation instances do not matter
		val EList<AnnotationInstanceOrModifier> modifier = informationFlowAnnotation.getAnnotationsAndModifiers;

		val retention = createInformationFlowAnnotationInstance(Confidentiality2AnnotationsUtil.RETENTION_ANNOTATION)
		setInformationFlowAnnotationInstanceParameter(retention, Confidentiality2AnnotationsUtil.RETENTION_POLICY_ENUMERATION -> "SOURCE")
		modifier.add(retention)

		val target = createInformationFlowAnnotationInstance(Confidentiality2AnnotationsUtil.TARGET_ANNOTATION)
		val elementTypeDotMethod = Confidentiality2AnnotationsUtil.ELEMENT_TYPE_ENUMERATION -> "METHOD"
		val elementTypeDotType = Confidentiality2AnnotationsUtil.ELEMENT_TYPE_ENUMERATION -> "TYPE"
		setInformationFlowAnnotationInstanceParameterArrayInstantiationByValuesUntyped(target, elementTypeDotMethod, elementTypeDotType)
		modifier.add(target)

		// add "ParametersAndDataPairs[] parametersAndDataPairs();"
		val method = getParametersAndDataPairsInterfaceMethod()
		informationFlowAnnotation.members.add(method)
	}
	
	public def static InterfaceMethod getParametersAndDataPairsInterfaceMethod() {
		// @interface InformationFlow:
		// ParametersAndDataPairs[] parametersAndDataPairs();
		val method = MembersFactory.eINSTANCE.createInterfaceMethod()
		method.name = "parametersAndDataPairs"
		val enumeration = Confidentiality2AnnotationsUtil.PARAMETERS_AND_DATA_PAIRS_ENUMERATION
		method.typeReference = Confidentiality2AnnotationsUtil.createNamespaceClassifierReference(enumeration)
		method.arrayDimensionsBefore.add(ArraysFactory.eINSTANCE.createArrayDimension)
		return method
	}
	
	public def static Expression createEnumerationReferenceDotEnumConstant(Enumeration enumerationReference, String name) {
		// notation: reference.name
		val expression = ExpressionsFactory.eINSTANCE.createUnaryExpression

		// reference.
		val reference = ReferencesFactory.eINSTANCE.createIdentifierReference
		reference.target = enumerationReference

		// .fieldname
		val enumConstantReference = ReferencesFactory.eINSTANCE.createIdentifierReference
		enumConstantReference.target = createEnumConstant(name)
		reference.next = enumConstantReference

		expression.child = reference
		return expression
	}

	private def static AnnotationInstance createInformationFlowAnnotationInstance(Annotation annotation) {
		val instance = AnnotationsFactory.eINSTANCE.createAnnotationInstance;
		instance.annotation = annotation
		return instance
	}
	
	private static def void setInformationFlowAnnotationInstanceParameterArrayInstantiationByValuesUntyped(AnnotationInstance instance,
			Pair<Enumeration, String> reference2Name1, Pair<Enumeration, String> reference2Name2) {
		val parameter = AnnotationsFactory.eINSTANCE.createSingleAnnotationParameter
		parameter.value = createArrayInstantiationByValuesUntyped(reference2Name1, reference2Name2)
		instance.parameter = parameter
	}
	
	private static def Expression createArrayInstantiationByValuesUntyped(Pair<Enumeration, String> reference2Name1,
			Pair<Enumeration, String> reference2Name2) {
		//// example: { ElementType.METHOD, ElementType.TYPE }
		val instantiation = ArraysFactory.eINSTANCE.createArrayInstantiationByValuesUntyped
		val initializer = ArraysFactory.eINSTANCE.createArrayInitializer
		val EList<ArrayInitializationValue> arrayArguments = initializer.initialValues
		arrayArguments.add(createEnumerationReferenceDotEnumConstant(reference2Name1.key, reference2Name1.value))
		arrayArguments.add(createEnumerationReferenceDotEnumConstant(reference2Name2.key, reference2Name2.value))
		instantiation.arrayInitializer = initializer
		return instantiation;
	}

	private def static void setInformationFlowAnnotationInstanceParameter(AnnotationInstance instance,
		Pair<Enumeration, String> reference2Name) {
		val parameter = AnnotationsFactory.eINSTANCE.createSingleAnnotationParameter
		parameter.value = createEnumerationReferenceDotEnumConstant(reference2Name.key, reference2Name.value)
		instance.parameter = parameter
	}
	
// ###################################################
// ################## ENUMERATIONS ################### 

	public def static setDataSetEnumeration(Enumeration dataSetEnumeration) {
		// package already set in compilation unit
		dataSetEnumeration.makePublic()
		addNewPublicConstantToMemberContainerByName(dataSetEnumeration, Confidentiality2AnnotationsUtil.STRING_CLASS, "id")
		addNewPublicConstantToMemberContainerByName(dataSetEnumeration, Confidentiality2AnnotationsUtil.STRING_CLASS, "name")
		addAllFieldsToNewConstructorToContainer(dataSetEnumeration, Confidentiality2AnnotationsUtil.DATA_SETS_ENUMERATION.name)
	}

	public def static void setParametersAndDataPairEnumeration(Enumeration pairEnumeration) {
		// package already set in compilation unit
		pairEnumeration.makePublic()
		addNewPublicConstantArrayToMemberContainerByName(pairEnumeration, Confidentiality2AnnotationsUtil.STRING_CLASS, "parameterSources")
		addNewPublicConstantArrayToMemberContainerByName(pairEnumeration, Confidentiality2AnnotationsUtil.DATA_SETS_ENUMERATION, "dataSets")
		addNewPublicConstantArrayToMemberContainerByName(pairEnumeration, Confidentiality2AnnotationsUtil.DATA_SET_MAP_ENTRIES_ENUMERATION, "dataSetMapEntries")
		addAllFieldsToNewConstructorToContainer(pairEnumeration, Confidentiality2AnnotationsUtil.PARAMETERS_AND_DATA_PAIRS_ENUMERATION.name)
	}

	private def static void addAllFieldsToNewConstructorToContainer(MemberContainer container, String name) {
		val Constructor constructor = MembersFactory.eINSTANCE.createConstructor
		constructor.makePrivate
		constructor.name = name
		for (field : container.fields) {
			addParameterAndAssignmentToConstructor(constructor, field)
		}
		container.members.add(constructor);
	}

	private def static void addNewPublicConstantArrayToMemberContainerByName(MemberContainer container, ConcreteClassifier classifier,
		String name) {
		val typeReference = Confidentiality2AnnotationsUtil.createNamespaceClassifierReference(classifier)
		val Field field = createPublicConstant(typeReference, name)
		field.arrayDimensionsBefore.add(ArraysFactory.eINSTANCE.createArrayDimension)
		container.members.add(field)
	}

	private def static void addNewPublicConstantToMemberContainerByName(MemberContainer container, ConcreteClassifier classifier,
		String name) {
		val typeReference = Confidentiality2AnnotationsUtil.createNamespaceClassifierReference(classifier)
		val Field field = createPublicConstant(typeReference, name)
		container.members.add(field)
	}

	private def static void addParameterAndAssignmentToConstructor(Constructor constructor, Field field) {
		val Parameter param = ParametersFactory.eINSTANCE.createOrdinaryParameter;
		param.typeReference = EcoreUtil.copy(field.typeReference)
		param.name = field.name;
		// assert field.arrayDimensionsBefore.size <= 1;
		if(!field.arrayDimensionsBefore.empty) {
			param.arrayDimensionsBefore.add(ArraysFactory.eINSTANCE.createArrayDimension)
		}
		constructor.parameters.add(param)
		val assignment = createAssignmentFromParameterToField(field, param);
		constructor.statements.add(assignment)
	}

// ###################################################
// ################# GENERAL PRIVATE ################# 

	// source: Pcm2JavaHelper
	private def static Statement createAssignmentFromParameterToField(Field field, Parameter parameter) {
		val expressionStatement = StatementsFactory.eINSTANCE.createExpressionStatement
		val assigmentExpression = ExpressionsFactory.eINSTANCE.createAssignmentExpression

		// this.
		val selfReference = ReferencesFactory.eINSTANCE.createSelfReference
		selfReference.self = LiteralsFactory.eINSTANCE.createThis
		assigmentExpression.child = selfReference

		// .fieldname
		val fieldReference = ReferencesFactory.eINSTANCE.createIdentifierReference
		fieldReference.target = EcoreUtil.copy(field)
		selfReference.next = fieldReference

		// =
		assigmentExpression.assignmentOperator = OperatorsFactory.eINSTANCE.createAssignment

		// name		
		val identifierReference = ReferencesFactory.eINSTANCE.createIdentifierReference
		identifierReference.target = parameter

		assigmentExpression.value = identifierReference
		expressionStatement.expression = assigmentExpression
		return expressionStatement
	}

	private def static createPublicConstant(TypeReference reference, String name) {
		// general: public final reference name;
		// example: public final String id;
		val Field field = createField(reference, name)
		field.annotationsAndModifiers.add(ModifiersFactory.eINSTANCE.createPublic)
		field.annotationsAndModifiers.add(ModifiersFactory.eINSTANCE.createFinal)
		return field
	}

	private def static Field createField(TypeReference reference, String name) {
		// general: reference name;
		// example: String id;
		val Field field = MembersFactory.eINSTANCE.createField
		field.typeReference = EcoreUtil.copy(reference)
		field.name = name
		return field
	}

	private def static EnumConstant createEnumConstant(String name) {
		val EnumConstant enumConstant = MembersFactory.eINSTANCE.createEnumConstant
		enumConstant.name = name
		return enumConstant
	}
}
