package es.unizar.disco.simulation.models.builders;

/**
 * 
 * {@link BuildException} capturing that an error ocurred while building an
 * analyzable resource
 * 
 * @author Abel Gómez <abel.gomez@unizar.es>
 *
 */
public class BuildException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a <tt>BuildException</tt> with no detail message. The cause is
	 * not initialized, and may subsequently be initialized by a call to
	 * {@link #initCause(Throwable) initCause}.
	 */
	public BuildException() {
	}

	/**
	 * Constructs a <tt>BuildException</tt> with the specified detail message.
	 * The cause is not initialized, and may subsequently be initialized by a
	 * call to {@link #initCause(Throwable) initCause}.
	 *
	 * @param message
	 *            the detail message
	 */
	public BuildException(String message) {
		super(message);
	}

	/**
	 * Constructs a <tt>BuildException</tt> with the specified detail message
	 * and cause.
	 *
	 * @param message
	 *            the detail message
	 * @param cause
	 *            the cause (which is saved for later retrieval by the
	 *            {@link #getCause()} method)
	 */
	public BuildException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a <tt>BuildException</tt> with the specified cause. The detail
	 * message is set to:
	 * 
	 * <pre>
	 * (cause == null ? null : cause.toString())
	 * </pre>
	 * 
	 * (which typically contains the class and detail message of <tt>cause</tt>
	 * ).
	 *
	 * @param cause
	 *            the cause (which is saved for later retrieval by the
	 *            {@link #getCause()} method)
	 */
	public BuildException(Throwable cause) {
		super(cause);
	}
}
