/*******************************************************************************
 * Copyright (c) 2018 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.fusesource.ide.camel.model.service.core.util.versionmapper;

import java.util.HashMap;
import java.util.Map;

import org.fusesource.ide.foundation.core.util.OnlineVersionMapper;

public class CamelForFuse71ToBomMapper extends OnlineVersionMapper {

	private static final String CAMEL_TO_BOM_MAPPING_FUSE_71_PROPERTY = "org.jboss.tools.fuse.camel2bom.fuse7.url";
	private static final String CAMEL_TO_BOM_MAPPING_FUSE_71_DEFAULT_URL = BASE_REPO_CONFIG_URI+"camel2bom.fuse71.properties";
	
	public CamelForFuse71ToBomMapper() {
		super(CAMEL_TO_BOM_MAPPING_FUSE_71_PROPERTY, CAMEL_TO_BOM_MAPPING_FUSE_71_DEFAULT_URL);
	}
	
	@Override
	protected Map<String, String> createFallbackMapping() {
		Map<String, String> mapping = new HashMap<>();
		mapping.put(CamelForFuseOnOpenShiftToBomMapper.FUSE_710_CAMEL_VERSION, "7.1.0.fuse-710019-redhat-00002");
		mapping.put(CamelForFuseOnOpenShiftToBomMapper.FUSE_720_CAMEL_VERSION, "7.2.0.fuse-720020-redhat-00001");
		mapping.put(CamelForFuseOnOpenShiftToBomMapper.FUSE_730_CAMEL_VERSION, "7.3.0.fuse-730058-redhat-00001");
		mapping.put(CamelForFuseOnOpenShiftToBomMapper.FUSE_731_CAMEL_VERSION, "7.3.1.fuse-731003-redhat-00003");
		return mapping;
	}

}
