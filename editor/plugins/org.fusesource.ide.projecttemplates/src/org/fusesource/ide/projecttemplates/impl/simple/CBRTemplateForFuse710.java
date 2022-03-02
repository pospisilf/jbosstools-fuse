/*******************************************************************************
 * Copyright (c) 2020 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at https://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.fusesource.ide.projecttemplates.impl.simple;

import java.util.Arrays;
import java.util.List;

import org.fusesource.ide.camel.model.service.core.util.FuseBomFilter;
import org.fusesource.ide.foundation.core.util.VersionUtil;
import org.fusesource.ide.projecttemplates.adopters.configurators.MavenTemplateConfigurator;
import org.fusesource.ide.projecttemplates.adopters.configurators.TemplateConfiguratorSupport;
import org.fusesource.ide.projecttemplates.adopters.creators.TemplateCreatorSupport;
import org.fusesource.ide.projecttemplates.util.CommonNewProjectMetaData;
import org.fusesource.ide.projecttemplates.wizards.pages.model.EnvironmentData;

public class CBRTemplateForFuse710 extends AbstractCBRTemplate {
	
	private static final String FIRST_INCOMPATIBLE_CAMEL_VERSION = "2.24";
	private static final String MINIMAL_COMPATIBLE_CAMEL_VERSION_PREFIX = "2.23.2.fuse-7_10_0";
	private static final String MINIMAL_COMPATIBLE_CAMEL_VERSION = "2.24.0";

	@Override
	public TemplateConfiguratorSupport getConfigurator() {
		return new MavenTemplateConfigurator(FuseBomFilter.BOM_FUSE_71_KARAF);
	}

	@Override
	public TemplateCreatorSupport getCreator(CommonNewProjectMetaData projectMetaData) {
		return new CBRUnzipTemplateCreator("7.10");
	}
	
	@Override
	public boolean isCompatible(EnvironmentData environment) {
		return super.isCompatible(environment)
				&& (environment.getCamelVersion().startsWith(MINIMAL_COMPATIBLE_CAMEL_VERSION_PREFIX)
						|| new VersionUtil().isGreaterThan(environment.getCamelVersion(), MINIMAL_COMPATIBLE_CAMEL_VERSION))
				&& new VersionUtil().isStrictlyGreaterThan(FIRST_INCOMPATIBLE_CAMEL_VERSION, environment.getCamelVersion());
	}
	
	@Override
	public List<String> getJavaExecutionEnvironments() {
		return Arrays.asList("JavaSE-1.8", "JavaSE-11");
	}

}
