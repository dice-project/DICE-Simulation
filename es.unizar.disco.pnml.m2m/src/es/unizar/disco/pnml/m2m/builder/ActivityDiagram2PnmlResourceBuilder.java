package es.unizar.disco.pnml.m2m.builder;

import org.eclipse.emf.common.util.URI;

import es.unizar.disco.pnml.m2m.PnmlM2mPlugin;
import es.unizar.disco.simulation.models.builders.IAnalyzableModelBuilder;

/**
 * This class will deal with the transformation of an AD to PNML for PERFORMANCE evaluation. The name is not yet updated to avoid touching extension and extesion points in the plugin.xmls
 * TODO: change the name of the class
 */
public class ActivityDiagram2PnmlResourceBuilder extends AbstractPnmlResourceBuilder implements IAnalyzableModelBuilder {

	@Override
	protected URI getTransformationUri() {
		return URI.createURI(PnmlM2mPlugin.DPIM_AD2PNML_PERFORMANCE_TRANSFORMATION_URI);
	}
}
