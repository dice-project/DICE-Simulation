package es.unizar.disco.ssh.ui.preferences;

/**
 * Constant definitions for plug-in preferences
 */
public enum PreferenceConstants {
	
	HOST				("host", 				PreferenceType.SECURE_PLAIN),
	PORT				("port", 				PreferenceType.SECURE_PLAIN),
	USERNAME			("username", 			PreferenceType.SECURE_PLAIN),
	PROVIDER			("provider", 			PreferenceType.SECURE_PLAIN),
	KEY_PROVIDER		("key_provider", 		PreferenceType.SECURE_PLAIN),
	PASSWORD_PROVIDER	("password_provider",	PreferenceType.SECURE_PLAIN),
	PASSWORD			("password", 			PreferenceType.SECURE_ENCRYPTED),
	KEY					("key", 				PreferenceType.SECURE_ENCRYPTED),
	PASSPHRASE			("passphrase", 			PreferenceType.SECURE_ENCRYPTED);

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
