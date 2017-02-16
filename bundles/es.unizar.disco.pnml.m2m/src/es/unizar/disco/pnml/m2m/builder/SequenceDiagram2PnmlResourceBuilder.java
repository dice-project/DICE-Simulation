package es.unizar.disco.pnml.m2m.builder;

import org.eclipse.emf.common.util.URI;

import es.unizar.disco.pnml.m2m.PnmlM2mPlugin;
import es.unizar.disco.simulation.models.builders.IAnalyzableModelBuilder;

public class SequenceDiagram2PnmlResourceBuilder extends AbstractPnmlResourceBuilder implements IAnalyzableModelBuilder {

	@Override
	protected URI getTransformationUri() {
		return URI.createURI(PnmlM2mPlugin.DPIM_SD2PNML_TRANSFORMATION_URI);
	}
}
