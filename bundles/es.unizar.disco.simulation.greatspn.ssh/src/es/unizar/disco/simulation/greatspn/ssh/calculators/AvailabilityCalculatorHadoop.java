package es.unizar.disco.simulation.greatspn.ssh.calculators;

import java.math.BigDecimal;
import java.text.MessageFormat;

import javax.measure.Unit;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Activity;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.pnml.m2m.utils.ConstantUtils;
import es.unizar.disco.simulation.greatspn.ssh.GspnSshSimulationPlugin;
import es.unizar.disco.simulation.models.datatypes.NonStandardUnits;
import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.models.measures.MeasureCalculator;
import es.unizar.disco.simulation.models.measures.MeasuresFactory;
import es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.Trace;
import es.unizar.disco.simulation.models.traces.TraceSet;
import tec.units.ri.format.SimpleUnitFormat;
import tec.units.ri.format.SimpleUnitFormat.Flavor;
import tec.units.ri.unit.Units;

public class AvailabilityCalculatorHadoop extends AbstractCalculator implements MeasureCalculator {

	/**
	 * The result is the proportion of the throughput of the transition without
	 * fail of the final node (successful executions), divided by the sum of the
	 * throughputs of the transitions of the final node (all executions)
	 */
	@Override
	public DomainMeasure calculate(EObject domainElement, DomainMeasureDefinition definition, ToolResult toolResult,
			TraceSet traceSet) {

		// From other calculators:
		if (!isAdequateFor(domainElement)) {
			throw new IllegalArgumentException(MessageFormat
					.format("Domain element ''{0}'' is not of type 'org.eclipse.uml2.uml.Activity' but type ''{1}''", domainElement, domainElement.getClass()));
		}

		//get from trace the trasition information of the closing transition
		for (Trace trace : traceSet.getTraces()) {
			//the trace of interest
			if(ConstantUtils.getPlaceNotExpelled().equalsIgnoreCase(trace.getRule())){
				//look for the result in toolResult
				for (AnalyzableElementInfo info : toolResult.getInfos()) {
					if(trace.getToAnalyzableElement().equals(info.getAnalyzedElement())){
						BigDecimal measuredecimal = new BigDecimal(info.getValue().doubleValue()*100.0);
						//String targetUnit = definition.getVslExpressionEntries().get("unit") != null ? definition.getVslExpressionEntries().get("unit") : "s";
						String targetUnit = "%";
						DomainMeasure measure = buildMeasure(measuredecimal, info.getUnit(), targetUnit);
						measure.setDefinition(definition);
						return measure;
					}
					
				}
				
			}
		}
		DiceLogger.logError(GspnSshSimulationPlugin.getDefault(), "It has not been possible to calculate the MTTF");
		return null;
	}
	
	private DomainMeasure buildMeasure(BigDecimal rawValue, String sourceInversedUnit, String targetUnit) {
		DomainMeasure measure = MeasuresFactory.eINSTANCE.createDomainMeasure();

		try {
			// Try to convert

			Unit<?> toUnit = SimpleUnitFormat.getInstance(Flavor.ASCII).parse(targetUnit);
			measure.setUnit(toUnit.toString());
			measure.setValue(rawValue);
		} catch (Throwable t) {
			try {
				DiceLogger.logWarning(GspnSshSimulationPlugin.getDefault(), "There was an exception with the common unit management (%). Acting as default");
				// If this fails, use the base unit
				Unit<?> fromUnit = SimpleUnitFormat.getInstance(Flavor.ASCII).parse(sourceInversedUnit).inverse();
				measure.setUnit("%");
				measure.setValue(fromUnit.getConverterToAny(Units.SECOND).convert(rawValue));
			} catch (Throwable t2) {
				// If everything fails, don't use any unit
				DiceLogger.logWarning(GspnSshSimulationPlugin.getDefault(), "There has been trown a Second Exception with the unit PERCENTAGE management");
				measure.setUnit(NonStandardUnits.UNSPECIFIED.getLiteral());
				measure.setValue(rawValue);
			}
		}
		return measure;
	}

	@Override
	public Boolean isAdequateFor(EObject domainElement) {
		return (domainElement instanceof Activity);
	}
}
