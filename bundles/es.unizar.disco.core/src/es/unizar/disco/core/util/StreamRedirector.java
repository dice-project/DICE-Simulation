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
package es.unizar.disco.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamRedirector extends Thread {

	public StreamRedirector(final InputStream in, final OutputStream out){
		super(StreamRedirector.handler(in, out));
		start();
	}

	public StreamRedirector(final InputStream in, final OutputStream out, final boolean daemon){
		super(StreamRedirector.handler(in, out));
		setDaemon(daemon);
		start();
	}

	private static Runnable handler(final InputStream in, final OutputStream out){
		return new Runnable() {
			@Override
			public void run() {
				try {
					int d;
					while ((d = in.read()) != -1) {
						out.write(d);
					}
				} catch (IOException ex) {
					throw new RuntimeException(Messages.StreamRedirector_unableToRedirectStreamError, ex);
				}
			}
		};
	}
}