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
package es.unizar.disco.simulation.ui.plot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;

/**
 * Immutable class holding the data to plot an XY graph
 * 
 * @author agomez
 *
 */
public class PlotData implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String COMMENT_CHAR = "#";
	private static final String HEADER_1 = "# This file has been automatically generated by the DICE Simulation Tool.";
	private static final String HEADER_2 = "# Comment lines starting with # SIM # contain important metadata needed to";
	private static final String HEADER_3 = "# plot this datafile within the Simulation Tool environment, and should";
	private static final String HEADER_4 = "# not be removed.";
	private static final String SIM_BEGIN_RESERVED_COMMENTS = "# SIM # BEGIN-RESERVED-COMMENTS";
	private static final String SIM_ID = "# SIM # ID: ";
	private static final String SIM_X_LABEL = "# SIM # X Label: ";
	private static final String SIM_X_UNIT = "# SIM # X Unit: ";
	private static final String SIM_Y_LABEL = "# SIM # Y Label: ";
	private static final String SIM_Y_UNIT = "# SIM # Y Unit: ";
	private static final String SIM_SLA_VALUE = "# SIM # SLA value: ";
	private static final String SIM_SLA_UNIT = "# SIM # SLA unit: ";
	
	private static final String SIM_END_RESERVED_COMMENTS = "# SIM # END-RESERVED-COMMENTS";

	public static class Pair<S, V> implements Serializable {

		private static final long serialVersionUID = 1L;

		private final String id;
		private final S series;
		private final V value;

		public Pair(String id, S series, V value) {
			this.id = id;
			this.series = series;
			this.value = value;
		}

		public String id() {
			return id;
		}

		public S series() {
			return series;
		}

		public V value() {
			return value;
		}
	}

	private String id;

	private String xLabel;
	private String yLabel;

	private String xUnit;
	private String yUnit;
	
	private String slaValue;
	private String slaUnit;

	private List<Pair<Number, Number>> data = new ArrayList<>();

	private PlotData() {
	}

	public static PlotData build(String id) {
		PlotData result = new PlotData();
		result.id = id;
		return result;
	}

	public String id() {
		return id;
	}

	public PlotData xLabel(String xLabel) {
		PlotData plotData = copy(this);
		plotData.xLabel = xLabel;
		return plotData;
	}

	public String xLabel() {
		return xLabel;
	}

	public PlotData yLabel(String yLabel) {
		this.yLabel = yLabel;
		return this;
	}

	public String yLabel() {
		return yLabel;
	}
	
	public PlotData slaValue(String value){
		this.slaValue=value;
		return this;
	}
	
	public String slaValue(){
		return slaValue;
	}
	
	public PlotData slaUnit(String value){
		this.slaUnit=value;
		return this;
	}
	
	public String slaUnit(){
		return slaUnit;
	}

	public PlotData xUnit(String xUnit) {
		PlotData plotData = copy(this);
		plotData.xUnit = xUnit;
		return plotData;
	}

	public String xUnit() {
		return xUnit;
	}

	public PlotData yUnit(String yUnit) {
		PlotData plotData = copy(this);
		plotData.yUnit = yUnit;
		return plotData;
	}

	public String yUnit() {
		return yUnit;
	}

	public PlotData data(List<Pair<Number, Number>> data) {
		PlotData plotData = copy(this);
		plotData.data = new ArrayList<>(data);
		return plotData;
	}

	public List<Pair<Number, Number>> data() {
		return new ArrayList<>(data);
	}

	/**
	 * Serializes the contents of this object in the passed
	 * {@link OutputStream}. Clients are responsible of closing the passed
	 * {@link Stream}. Objects serialized using this method can be reified using
	 * the {@link #deserialize(InputStream)} method.
	 * 
	 * @param out
	 * @throws IOException
	 * @see {@link #deserialize(InputStream)}
	 */
	public void serialize(OutputStream out) throws IOException {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		try {
			writer.write(HEADER_1);
			writer.newLine();
			writer.write(HEADER_2);
			writer.newLine();
			writer.write(HEADER_3);
			writer.newLine();
			writer.write(HEADER_4);
			writer.newLine();
			writer.newLine();
			writer.write(SIM_BEGIN_RESERVED_COMMENTS);
			writer.newLine();
			writer.write(SIM_ID);
			writer.write(String.valueOf(id));
			writer.newLine();
			writer.write(SIM_X_LABEL);
			writer.write(String.valueOf(xLabel));
			writer.newLine();
			writer.write(SIM_X_UNIT);
			writer.write(String.valueOf(xUnit));
			writer.newLine();
			writer.write(SIM_Y_LABEL);
			writer.write(String.valueOf(yLabel));
			writer.newLine();
			writer.write(SIM_Y_UNIT);
			writer.write(String.valueOf(yUnit));
			writer.newLine();
			writer.write(SIM_SLA_VALUE);
			writer.write(String.valueOf(slaValue));
			writer.newLine();
			writer.write(SIM_SLA_UNIT);
			writer.write(String.valueOf(slaUnit));
			writer.newLine();
			writer.write(SIM_END_RESERVED_COMMENTS);
			writer.newLine();
			writer.newLine();
			writer.write(MessageFormat.format("# {0}\t{1}\tid", xLabel, yLabel));
			writer.newLine();

			for (Pair<Number, Number> pair : data) {
				if (pair.series == null || pair.value == null) {
					// If there is information missing, comment the data
					writer.write(COMMENT_CHAR + " ");
				}
				MessageFormat format = new MessageFormat("{0}\t{1}\t\"{2}\"", Locale.ROOT);
				writer.write(format.format(new Object[] { pair.series, pair.value, pair.id }));
				writer.newLine();
			}
		} finally {
			writer.flush();
		}
	}

	/**
	 * Deserializes an instance of {@link PlotData} stored in the given
	 * {@link InputStream}. The deserialized {@link PlotData} is returned.
	 * 
	 * @param in
	 *            the {@link InputStream} containing a {@link PlotData} instance
	 *            serialized using the {@link #serialize(OutputStream)} method
	 * @return an instance of {@link PlotData}
	 * @throws IOException
	 * @throws ParseException 
	 * @see {@link #serialize(OutputStream)}
	 */
	public static PlotData deserialize(InputStream in) throws IOException, ParseException {
		PlotData plotData = new PlotData();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line = null;
		while ((line = reader.readLine()) != null) {
			if (line.trim().length() == 0) {
			} else if (line.startsWith(COMMENT_CHAR)) {
				if (line.startsWith(SIM_ID)) {
					plotData.id = sanitize(line.replaceFirst(SIM_ID, ""));
				} else if (line.startsWith(SIM_X_LABEL)) {
					plotData.xLabel = sanitize(line.replaceFirst(SIM_X_LABEL, ""));
				} else if (line.startsWith(SIM_X_UNIT)) {
					plotData.xUnit = sanitize(line.replaceFirst(SIM_X_UNIT, ""));
				} else if (line.startsWith(SIM_Y_LABEL)) {
					plotData.yLabel = sanitize(line.replaceFirst(SIM_Y_LABEL, ""));
				} else if (line.startsWith(SIM_Y_UNIT)) {
					plotData.yUnit = sanitize(line.replaceFirst(SIM_Y_UNIT, ""));
				} else if (line.startsWith(SIM_SLA_VALUE)){
					plotData.slaValue=sanitize(line.replaceFirst(SIM_SLA_VALUE, ""));
				} else if (line.startsWith(SIM_SLA_UNIT)){
					plotData.slaUnit=sanitize(line.replaceFirst(SIM_SLA_UNIT, ""));
				}
				
			} else {
				Pattern pattern = Pattern.compile("\\s*(?<series>\\S+)\\s+(?<value>\\S+)\\s+\"(?<id>\\S+)\"$");
				Matcher matcher = pattern.matcher(line);
				if (matcher.matches()) {
					String seriesString = matcher.group("series");
					String valueString = matcher.group("value");
					String idString = matcher.group("id");
					try {
						NumberFormat format = NumberFormat.getInstance(Locale.ROOT);
						Number series = format.parse(seriesString);
						Number value = format.parse(valueString);
						//Number series = Double.parseDouble(seriesString);
						//Number value = Double.parseDouble(valueString);
						Pair<Number, Number> pair = new Pair<>(idString, series, value);
						plotData.data.add(pair);
					} catch (NumberFormatException e) {
						DiceLogger.logError(DiceSimulationUiPlugin.getDefault(), MessageFormat.format("Unable to parse line in plot data file: ''{0}''", line),
								e);
					}
				} else {
					DiceLogger.logError(DiceSimulationUiPlugin.getDefault(), MessageFormat.format("Unable to parse line in plot data file: ''{0}''", line));
				}
			}
		}
		return plotData;
	}

	private static String sanitize(String string) {
		String str = string.trim();
		return "null".equals(str) ? null : str;
	}

	/**
	 * Performs a deep copy of the passed object by using in-memory
	 * serialization de-serialization
	 * 
	 * @param plotData
	 *            The object to be copied
	 * @return a deep-copy of <code>plotData</code>
	 */
	private static PlotData copy(PlotData plotData) {
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(outputStream);
			out.writeObject(plotData);
			out.flush();
			ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray()));
			return (PlotData) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			// (De-)serializing this same class using in-memory data structures
			// should not fail
			throw new RuntimeException(e);
		}
	}
}
