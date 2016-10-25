package es.unizar.disco.simulation.ui.wizards;

import java.text.MessageFormat;
import java.util.Locale;

import es.unizar.disco.simulation.models.definition.InputVariable;
import es.unizar.disco.simulation.models.definition.VariableConfiguration;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;
import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.ui.wizards.PlotWizard.WizardData;

class PlotBuilder {

	private WizardData data;

	private String plotContents = "";

	private boolean error = false;

	private PlotBuilder(WizardData data) {
		this.data = data;
	}

	public static PlotBuilder build(WizardData data) {

		PlotBuilder plotBuilder = new PlotBuilder(data);
		plotBuilder.doBuild();
		return plotBuilder;
	}

	private void doBuild() {

		InputVariable selectedVariable = data.getSelectedVariable();
		DomainMeasureDefinition selectedMeasure = data.getSelectedMeasure();

		StringBuilder builder = new StringBuilder();

		builder.append(MessageFormat.format("# {0}\t{1}\tunit\n", selectedVariable.getName(), selectedMeasure.getMeasure()));

		for (SimulationInvocation invocation : data.getInvocations()) {
			try {
				for (DomainMeasure measure : invocation.getResult().getMeasures()) {
					if (selectedMeasure.equals(measure.getDefinition())) {
						VariableConfiguration configuration = invocation.getVariableConfiguration();
						// @formatter:off
						MessageFormat format = new MessageFormat("{0}\t{1}\t{2}\n", Locale.ROOT);
						builder.append(
								format.format(
									new Object[] {
										configuration.findAssignment(selectedVariable).getValue().getValue(), 
										measure.getValue(),
										measure.getUnit() 
									}
								));
						// @formatter:on
					}
				}
			} catch (NullPointerException e) {
				builder.append(MessageFormat.format("# Error: information missing for invocation ''{0}''\n", invocation.getIdentifier()));
				error = true;
			}
		}
		plotContents = builder.toString();
	}

	public String contents() {
		return plotContents;
	}

	public boolean error() {
		return error;
	}

	public byte[] getBytes() {
		return plotContents.getBytes();
	}
}