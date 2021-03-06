/*******************************************************************************
 * Copyright (c) 2015 QNX Software Systems and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.cdt.core.build;

import org.eclipse.core.runtime.CoreException;

/**
 * A provider of toolchains. Registered with the toolChainProvider extension
 * point.
 * 
 * @since 6.0
 */
public interface IToolChainProvider {

	/**
	 * Returns the id for this provider.
	 * 
	 * @return id
	 */
	String getId();

	/**
	 * Initialize the list of toolchains.
	 * 
	 * @param manager handle on manager to add or remove them
	 */
	default void init(IToolChainManager manager) throws CoreException {
		// By default, toolchains are created on demand
	}

	/**
	 * Called by the manager to dynamically create the toolchain.
	 * 
	 * @deprecated We have dropped the concept of version. All ids must be unique.
	 * @param id
	 *            the id of the toolchain
	 * @param version
	 *            the version of the toolchain
	 * @return the toolchain initialized with the settings.
	 */
	@Deprecated
	default IToolChain getToolChain(String id, String version) throws CoreException {
		return getToolChain(id);
	}

	/**
	 * Called by the manager to dynamically create the toolchain.
	 * 
	 * @param id
	 *            the id of the toolchain
	 * @return the toolchain initialized with the settings.
	 * @since 6.4
	 */
	default IToolChain getToolChain(String id) throws CoreException {
		// By default, assumes all toolchains were added at init time.
		return null;
	}

}
