package org.jboss.tools.fuse.ui.bot.tests;

import static org.jboss.tools.fuse.reddeer.ProjectTemplate.CBR_BLUEPRINT;
import static org.jboss.tools.fuse.reddeer.wizard.NewFuseIntegrationProjectWizardDeploymentType.STANDALONE;
import static org.jboss.tools.fuse.reddeer.wizard.NewFuseIntegrationProjectWizardRuntimeType.KARAF;
import static org.junit.Assert.assertTrue;

import org.eclipse.reddeer.common.wait.AbstractWait;
import org.eclipse.reddeer.common.wait.TimePeriod;

import java.util.Arrays;
import java.util.Collection;

import org.jboss.tools.fuse.reddeer.utils.ProjectFactory;
import org.jboss.tools.fuse.reddeer.wizard.NewFuseIntegrationProjectWizardDeploymentType;
import org.jboss.tools.fuse.reddeer.wizard.NewFuseIntegrationProjectWizardRuntimeType;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

public class ProjectFactoryTest {
	private static final String PROJECT_NAME = "ProjectFactoryTest";
	
	@Parameter
	public NewFuseIntegrationProjectWizardDeploymentType deployment;

	@Parameter(1)
	public NewFuseIntegrationProjectWizardRuntimeType runtime;

	@Parameter(2)
	public String[] template;


	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
		//	{STANDALONE, KARAF, CBR_BLUEPRINT },
			{STANDALONE, KARAF, CBR_BLUEPRINT}, });
	}

	@BeforeClass
	public static void createProject() {
		ProjectFactory.newProject(PROJECT_NAME).deploymentType(STANDALONE).runtimeType(KARAF).template(CBR_BLUEPRINT).create();
	}
	
	@Test
	public void testProjectFactory() {
		assertTrue(true);
	}
}
