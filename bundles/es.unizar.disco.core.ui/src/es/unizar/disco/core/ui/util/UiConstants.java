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
package es.unizar.disco.core.ui.util;

import org.eclipse.swt.layout.GridLayout;

public final class UiConstants {
	
	private static final GridLayout GRID_LAYOUT = new GridLayout();

	public static final int DEFAULT_MARGIN = GRID_LAYOUT.marginWidth;

	public static final int DEFAULT_MARGIN_WIDTH = GRID_LAYOUT.marginWidth;

	public static final int DEFAULT_MARGIN_HEIGHT = GRID_LAYOUT.marginWidth;

	public static final int DEFAULT_SPACING = GRID_LAYOUT.horizontalSpacing;

	public static final int DEFAULT_HORIZONTAL_SPACING = GRID_LAYOUT.horizontalSpacing;

	public static final int DEFAULT_VERTICAL_SPACING = GRID_LAYOUT.verticalSpacing;
	
	private UiConstants() {
	}
}
