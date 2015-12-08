package es.unizar.disco.core.util;

import java.io.Closeable;

public class IOUtils {
	public static void closeQuietly(Closeable... closeables) {
		for (Closeable c : closeables) {
			if (c != null) {
				try {
					c.close();
				} catch (Throwable t) {
				}
			}
		}
	}
}
