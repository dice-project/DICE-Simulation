package es.unizar.disco.simulation.simulators;

import java.util.concurrent.ExecutionException;

/**
 * 
 * {@link ExecutionException} capturing that an error ocurred while running the
 * {@link ISimulator}
 * 
 * @author Abel Gómez <abel.gomez@unizar.es>
 *
 */
public class SimulationException extends ExecutionException {

	private static final long serialVersionUID = 1L;

    /**
     * Constructs a <tt>SimulationException</tt> with no detail message.
     * The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause(Throwable) initCause}.
     */
	public SimulationException() { }

    /**
     * Constructs a <tt>SimulationException</tt> with the specified detail
     * message. The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause(Throwable) initCause}.
     *
     * @param message the detail message
     */
    public SimulationException(String message) {
        super(message);
    }

    /**
     * Constructs a <tt>ExecutionException</tt> with the specified detail
     * message and cause.
     *
     * @param  message the detail message
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method)
     */
    public SimulationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a <tt>SimulationException</tt> with the specified cause.
     * The detail message is set to:
     * <pre>
     *  (cause == null ? null : cause.toString())</pre>
     * (which typically contains the class and detail message of
     * <tt>cause</tt>).
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method)
     */
    public SimulationException(Throwable cause) {
        super(cause);
    }
}
