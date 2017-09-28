package tools.vitruv.applications.pcmjava.confidentialitytransformations.confidentiality2annotations

import tools.vitruv.applications.pcmjava.confidentialitytransformations.confidentiality2annotations.Confidentiality2AnnotationsUtil
import org.emftext.language.java.annotations.AnnotationsFactory
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
import org.emftext.language.java.annotations.AnnotationParameterList
import org.emftext.language.java.members.InterfaceMethod

class Confidentiality2AnnotationsContentCreationUtil {

// ###################################################
// ########### INFORMATION FLOW ANNOTATION ########### 

	public def static setInformationFlowAnnotation(Annotation informationFlowAnnotation) {
		// package already set in compilation unit
		informationFlowAnnotation.addImport("java.lang.annotation.ElementType");
		informationFlowAnnotation.addImport("java.lang.annotation.Retention");
		informationFlowAnnotation.addImport("java.lang.annotation.RetentionPolicy");
		informationFlowAnnotation.addImport("java.lang.annotation.Target");
		informationFlowAnnotation.makePublic();

		val EList<AnnotationInstance> annotationInstances = informationFlowAnnotation.annotationInstances;

		val retention = createInformationFlowAnnotationInstance(Confidentiality2AnnotationsUtil.RETENTION_ANNOTATION)
		setInformationFlowAnnotationInstanceParameters(retention, Confidentiality2AnnotationsUtil.RETENTION_POLICY_ENUMERATION -> "SOURCE")
		annotationInstances.add(retention)

		val target = createInformationFlowAnnotationInstance(Confidentiality2AnnotationsUtil.TARGET_ANNOTATION)
		val elementTypeDotMethod = Confidentiality2AnnotationsUtil.ELEMENT_TYPE_ENUMERATION -> "METHOD"
		val elementTypeDotType = Confidentiality2AnnotationsUtil.ELEMENT_TYPE_ENUMERATION -> "TYPE"
		setInformationFlowAnnotationInstanceParameters(target, elementTypeDotMethod, elementTypeDotType)
		annotationInstances.add(target)

		// add "ParametersAndDataPairs parametersAndDataPairs();"
		val method = getParametersAndDataPairsInterfaceMethod()
		informationFlowAnnotation.methods.add(method)
	}
	
	public def static InterfaceMethod getParametersAndDataPairsInterfaceMethod() {
		// @interface InformationFlow:
		// ParametersAndDataPairs[] parametersAndDataPairs();
		val method = MembersFactory.eINSTANCE.createInterfaceMethod()
		method.name = "parametersAndDataPairs"
		val enumeration = Confidentiality2AnnotationsUtil.PARAMETERS_AND_DATA_PAIRS_ENUMERATION
		method.typeReference = Confidentiality2AnnotationsUtil.createNamespaceClassifierReference(enumeration)
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

	private def static void setInformationFlowAnnotationInstanceParameters(AnnotationInstance instance,
		Pair<Enumeration, String> reference2Name) {
		val parameter = AnnotationsFactory.eINSTANCE.createSingleAnnotationParameter
		parameter.value = createEnumerationReferenceDotEnumConstant(reference2Name.key, reference2Name.value)
		instance.parameter = parameter
	}

	private def static void setInformationFlowAnnotationInstanceParameters(AnnotationInstance instance,
		Pair<Enumeration, String> reference2Name1, Pair<Enumeration, String> reference2Name2) {
		val parameterList = AnnotationsFactory.eINSTANCE.createAnnotationParameterList
		addNewSettingWithNewAttributeToParameterSettingsList(parameterList, reference2Name1.key, reference2Name1.value)
		addNewSettingWithNewAttributeToParameterSettingsList(parameterList, reference2Name2.key, reference2Name2.value)
		instance.parameter = parameterList
	}
	
	private def static void addNewSettingWithNewAttributeToParameterSettingsList(AnnotationParameterList parameterList,
		Enumeration enumerationReference, String name) {		
		val setting = AnnotationsFactory.eINSTANCE.createAnnotationAttributeSetting
		val attribute = AnnotationsFactory.eINSTANCE.createAnnotationAttribute
		val enumeration = enumerationReference
		attribute.typeReference = Confidentiality2AnnotationsUtil.createNamespaceClassifierReference(enumeration)
		attribute.name = name
		setting.attribute = attribute
		parameterList.settings.add(setting)
	}
	
// ###################################################
// ################## ENUMERATIONS ################### 

	public def static setDataSetEnumeration(Enumeration dataSetEnumeration) {
		// package already set in compilation unit
		dataSetEnumeration.makePublic();
		addNewPublicConstantToMemberContainerByName(dataSetEnumeration, Confidentiality2AnnotationsUtil.STRING_CLASS, "id")
		addNewPublicConstantToMemberContainerByName(dataSetEnumeration, Confidentiality2AnnotationsUtil.STRING_CLASS, "name")
		addAllFieldsToNewConstructorToContainer(dataSetEnumeration)
	}

	public def static void setParametersAndDataPairEnumeration(Enumeration pairEnumeration) {
		// package already set in compilation unit
		pairEnumeration.makePublic();
		addNewPublicConstantArrayToMemberContainerByName(pairEnumeration, Confidentiality2AnnotationsUtil.STRING_CLASS, "parameterSources")
		addNewPublicConstantArrayToMemberContainerByName(pairEnumeration, Confidentiality2AnnotationsUtil.DATA_SETS_ENUMERATION, "dataSets")
		addNewPublicConstantArrayToMemberContainerByName(pairEnumeration, Confidentiality2AnnotationsUtil.DATA_SET_MAP_ENTRIES_ENUMERATION, "dataSetMapEntries")
		addAllFieldsToNewConstructorToContainer(pairEnumeration)
	}

	private def static void addAllFieldsToNewConstructorToContainer(MemberContainer container) {
		val Constructor constructor = MembersFactory.eINSTANCE.createConstructor
		for (field : container.fields) {
			addParameterAndAssignmentToConstructor(constructor, field)
		}
		container.constructors.add(constructor);
	}

	private def static void addNewPublicConstantArrayToMemberContainerByName(MemberContainer container, ConcreteClassifier classifier,
		String name) {
		val typeReference = Confidentiality2AnnotationsUtil.createNamespaceClassifierReference(classifier)
		val Field field = createPublicConstant(typeReference, name)
		field.arrayDimensionsBefore.add(ArraysFactory.eINSTANCE.createArrayDimension)
		container.fields.add(field)
	}

	private def static void addNewPublicConstantToMemberContainerByName(MemberContainer container, ConcreteClassifier classifier,
		String name) {
		val typeReference = Confidentiality2AnnotationsUtil.createNamespaceClassifierReference(classifier)
		val Field field = createPublicConstant(typeReference, name)
		container.fields.add(field)
	}

	private def static void addParameterAndAssignmentToConstructor(Constructor constructor, Field field) {
		val Parameter param = ParametersFactory.eINSTANCE.createOrdinaryParameter;
		param.name = field.name;
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
