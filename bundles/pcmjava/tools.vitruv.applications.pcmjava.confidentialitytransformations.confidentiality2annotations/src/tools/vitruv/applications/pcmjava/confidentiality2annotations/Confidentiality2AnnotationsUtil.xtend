package tools.vitruv.applications.pcmjava.confidentiality2annotations

import org.emftext.language.java.containers.CompilationUnit

class Confidentiality2AnnotationsUtil {
	
	//source: tools.vitruv.domains.java.util.JavaPersistenceHelper.xtend
	public static def String getPackageInfoClassName() {
		"package-info"
	} 
	
	//source: tools.vitruv.domains.java.util.JavaPersistenceHelper.xtend
	public static def String buildJavaFilePath(CompilationUnit compilationUnit) {
		return '''src/«FOR namespace : compilationUnit.namespaces SEPARATOR "/" AFTER "/"»«namespace»«ENDFOR»«compilationUnit.name»''';
	}
	
 	//source: tools.vitruv.domains.java.util.JavaPersistenceHelper.xtend
	public static def String buildJavaFilePath(org.emftext.language.java.containers.Package javaPackage) {
		return '''src/«FOR namespace : javaPackage.namespaces SEPARATOR "/" AFTER "/"»«namespace»«ENDFOR»«javaPackage.name»/«packageInfoClassName».java''';
	}
}