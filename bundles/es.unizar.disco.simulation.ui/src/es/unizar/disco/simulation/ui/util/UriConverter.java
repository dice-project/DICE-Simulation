/*******************************************************************************
 * Copyright (c) 2020 DisCo Group - Universidad de Zaragoza.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-1.0/
 *
 * SPDX-License-Identifier: EPL-1.0
 *
 * Contributors:
 *     Abel Gómez
 *     Ignacio Requeno
 *     Diego Pérez
 *******************************************************************************/
package es.unizar.disco.simulation.ui.util;

import java.io.File;
import java.net.URI;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;

public class UriConverter {

	public static URI toPlatformResourceUri(URI fileUri) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		if (new File(fileUri).isFile()) {
			IFile[] files = root.findFilesForLocationURI(fileUri);
			if (files.length > 0) {
				return URI.create(org.eclipse.emf.common.util.URI.createPlatformResourceURI(
						files[0].getFullPath().toString(), true).toString());
			}
		} else {
			IContainer[] containers = root.findContainersForLocationURI(fileUri);
			if (containers.length > 0) {
				return URI.create(org.eclipse.emf.common.util.URI.createPlatformResourceURI(
						containers[0].getFullPath().toString(), true).toString());
			}
		}
		return null;
	}
	
	public static URI toPlatformResourceUri(org.eclipse.emf.common.util.URI fileUri) {
		return toPlatformResourceUri(toJavaUri(fileUri));
	}
	
	public static URI toFileResourceUri(URI platformResourceUri) {
		return ResourcesPlugin.getWorkspace().getRoot().findMember(
				new Path(toEmfUri(platformResourceUri).toPlatformString(true))).getLocationURI();
	}
	
	public static org.eclipse.emf.common.util.URI toEmfUri(URI uri) {
		return org.eclipse.emf.common.util.URI.createURI(uri.toString());
	}
	
	public static URI toJavaUri(org.eclipse.emf.common.util.URI uri) {
		return URI.create(uri.toString());
	}

}
