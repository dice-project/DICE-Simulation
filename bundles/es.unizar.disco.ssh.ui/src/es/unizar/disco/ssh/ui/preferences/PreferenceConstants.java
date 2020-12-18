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
package es.unizar.disco.ssh.ui.preferences;

/**
 * Constant definitions for plug-in preferences
 */
public enum PreferenceConstants {
	
	HOST				("host", 				PreferenceType.SECURE_PLAIN), //$NON-NLS-1$
	PORT				("port", 				PreferenceType.SECURE_PLAIN), //$NON-NLS-1$
	USERNAME			("username", 			PreferenceType.SECURE_PLAIN), //$NON-NLS-1$
	PROVIDER			("provider", 			PreferenceType.SECURE_PLAIN), //$NON-NLS-1$
	KEY_PROVIDER		("key_provider", 		PreferenceType.SECURE_PLAIN), //$NON-NLS-1$
	PASSWORD_PROVIDER	("password_provider",	PreferenceType.SECURE_PLAIN), //$NON-NLS-1$
	PASSWORD			("password", 			PreferenceType.SECURE_ENCRYPTED), //$NON-NLS-1$
	KEY					("key", 				PreferenceType.SECURE_ENCRYPTED), //$NON-NLS-1$
	PASSPHRASE			("passphrase", 			PreferenceType.SECURE_ENCRYPTED); //$NON-NLS-1$

	public enum PreferenceType {
		PLAIN,
		SECURE_PLAIN,
		SECURE_ENCRYPTED;
	};
	
	private String literal;
	
	private PreferenceType type;
	
	private  PreferenceConstants(String literal, PreferenceType type) {
		this.literal = literal;
		this.type = type;
	}
	
	public PreferenceType getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return literal;
	}
	
	public static PreferenceConstants getEnum(String literal) {
		for (PreferenceConstants constant : values()) {
			if (constant.toString().equals(literal)) {
				return constant;
			}
		}
		return null;
	}
}
