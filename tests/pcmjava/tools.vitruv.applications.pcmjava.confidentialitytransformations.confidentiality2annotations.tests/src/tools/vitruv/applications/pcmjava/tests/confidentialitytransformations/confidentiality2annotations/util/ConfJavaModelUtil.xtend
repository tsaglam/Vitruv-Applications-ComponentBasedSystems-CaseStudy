package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util

import org.eclipse.jdt.core.IJavaProject
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.resources.IProject
import org.eclipse.jdt.core.JavaCore

public final class ConfJavaModelUtil {

    public static def IJavaProject createJavaProjectByPath(String path) {
    	val IProject project = ResourcesPlugin.workspace.root.getProject(path)
        project.create(null)
        project.open(null)
        val description = project.description
        description.natureIds = #[JavaCore.NATURE_ID]
        project.setDescription(description, null)
        val javaProject = JavaCore.create(project)
		// (3) src folder
		val sourceFolder = project.getFolder("src")
		sourceFolder.create(false, true, null)
		// (4) add src folder to class entries
		val root = javaProject.getPackageFragmentRoot(sourceFolder);
		javaProject.setRawClasspath(#[JavaCore.newSourceEntry(root.path)], null)
		javaProject
    }
}