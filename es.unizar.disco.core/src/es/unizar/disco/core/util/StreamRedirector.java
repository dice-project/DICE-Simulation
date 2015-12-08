package es.unizar.disco.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import es.unizar.disco.core.DiceCorePlugin;
import es.unizar.disco.core.logger.DiceLogger;

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
					throw new RuntimeException("Unable to redirect streams", ex);
				}
				DiceLogger.logInfo(DiceCorePlugin.getDefault(), "StreamRedirector finished");
			}
		};
	}
}