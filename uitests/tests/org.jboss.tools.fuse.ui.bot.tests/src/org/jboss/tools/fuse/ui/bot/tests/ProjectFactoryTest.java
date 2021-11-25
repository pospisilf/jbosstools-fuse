package org.jboss.tools.fuse.ui.bot.tests;

import static org.jboss.tools.fuse.reddeer.wizard.NewFuseIntegrationProjectWizardDeploymentType.STANDALONE;
import static org.jboss.tools.fuse.reddeer.wizard.NewFuseIntegrationProjectWizardRuntimeType.SPRINGBOOT;
import static org.jboss.tools.fuse.reddeer.wizard.NewFuseIntegrationProjectWizardRuntimeType.KARAF;
import static org.jboss.tools.fuse.reddeer.wizard.NewFuseIntegrationProjectWizardRuntimeType.EAP;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.reddeer.common.wait.AbstractWait;
import org.eclipse.reddeer.common.wait.TimePeriod;
import org.eclipse.reddeer.eclipse.ui.navigator.resources.ProjectExplorer;
import org.eclipse.reddeer.junit.internal.runner.ParameterizedRequirementsRunnerFactory;
import org.eclipse.reddeer.junit.runner.RedDeerSuite;
import org.eclipse.reddeer.workbench.impl.shell.WorkbenchShell;
import org.jboss.tools.fuse.reddeer.ProjectTemplate;

import org.jboss.tools.fuse.reddeer.utils.ProjectFactory;
import org.jboss.tools.fuse.reddeer.wizard.NewFuseIntegrationProjectWizardDeploymentType;
import org.jboss.tools.fuse.reddeer.wizard.NewFuseIntegrationProjectWizardRuntimeType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.UseParametersRunnerFactory;

@UseParametersRunnerFactory(ParameterizedRequirementsRunnerFactory.class)
@RunWith(RedDeerSuite.class)
public class ProjectFactoryTest {
	
	public static final String PROJECT_NAME = "ProjectFactoryTest";
	
	@Parameter
	public NewFuseIntegrationProjectWizardDeploymentType deployment;

	@Parameter(1)
	public NewFuseIntegrationProjectWizardRuntimeType runtime;

	@Parameter(2)
	public String[] template;

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			// Springboot
			{STANDALONE, SPRINGBOOT, ProjectTemplate.SPRINGBOOT},
			
			//Karaf
			//Beginner -> CBR
			{STANDALONE, KARAF, ProjectTemplate.CBR_BLUEPRINT},
			{STANDALONE, KARAF, ProjectTemplate.CBR_SPRING},
			{STANDALONE, KARAF, ProjectTemplate.CBR_JAVA},
			
			//Advanced -> CXF
			{STANDALONE, KARAF, ProjectTemplate.CXF_SPRING},
			{STANDALONE, KARAF, ProjectTemplate.CXF_JAVA},
			
			//Empty ->  Empty
			{STANDALONE, KARAF, ProjectTemplate.EMPTY_BLUEPRINT},
			{STANDALONE, KARAF, ProjectTemplate.EMPTY_SPRING},
			{STANDALONE, KARAF, ProjectTemplate.EMPTY_JAVA},
			
			//EAP
			{STANDALONE, EAP, ProjectTemplate.EAP_SPRING}
		});
	}
	
	@Before
	public void createProject() { 		
		ProjectFactory.newProject(PROJECT_NAME).deploymentType(deployment).runtimeType(runtime).template(template).create();
	}
	
	@After 
	public void removeProject() {
		new WorkbenchShell();
		new ProjectExplorer().getProject(PROJECT_NAME).delete(true);
	}
		
	
	@Test
	public void testProjectFactory() {
		assertTrue(new ProjectExplorer().getProject(PROJECT_NAME) != null);	
		AbstractWait.sleep(TimePeriod.getCustom(5));
	}


}
