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
package es.unizar.disco.simulation.simulators;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;

import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.TraceSet;

public interface ISimulator {
	
	public static final int RET_CODE_OK = 0;
	
	public static final int RET_CODE_KILLED = -10;
	
	public static final int RET_CODE_UNKNOWN_ERROR = Integer.MIN_VALUE;
	
	
	public Process simulate(String id, List<EObject> analyzableModel, TraceSet traces, Map<String, String> options, IProgressMonitor monitor) throws SimulationException;
	
	public ToolResult getToolResult();

	public InputStream getRawResult();

}
