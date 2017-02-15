package es.unizar.disco.pnml.m2m.builder;

import org.eclipse.emf.common.util.URI;

import es.unizar.disco.pnml.m2m.PnmlM2mPlugin;
import es.unizar.disco.simulation.models.builders.IAnalyzableModelBuilder;

public class HadoopActivityDiagram2PnmlResourceBuilder extends AbstractPnmlResourceBuilder implements IAnalyzableModelBuilder {

	@Override
	protected URI getTransformationUri() {
		return URI.createURI(PnmlM2mPlugin.DTSM_HADOOP_AD2PNML_TRANSFORMATION_URI);
	}
}
