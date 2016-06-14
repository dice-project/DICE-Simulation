package es.unizar.disco.pnml.m2m.builder;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;

import es.unizar.disco.pnml.m2m.PnmlM2mPlugin;
import es.unizar.disco.simulation.models.builders.BuildException;
import es.unizar.disco.simulation.models.builders.IAnalyzableResourceBuilder;
import es.unizar.disco.simulation.models.datatypes.DatatypesFactory;
import es.unizar.disco.simulation.models.datatypes.Resource;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

public class PnmlResourceBuilder implements IAnalyzableResourceBuilder {

	@Override
	public Resource createAnalyzableResource(SimulationInvocation invocation, URI resourceURI) throws BuildException {

		TransformationExecutor executor = new TransformationExecutor(URI.createURI(PnmlM2mPlugin.AD2PNML_TRANSFORMATION_URI));
		ExecutionContextImpl context = new ExecutionContextImpl();

		ModelExtent inv = new BasicModelExtent(Arrays.asList(new EObject[] { invocation }));
		ModelExtent res = new BasicModelExtent();

		ExecutionDiagnostic result = executor.execute(context, inv, res);

		if (result.getSeverity() == Diagnostic.OK) {
			try {
				save(resourceURI, res.getContents());
			} catch (IOException e) {
				throw new BuildException(e.getLocalizedMessage(), e);
			}
			Resource resultResource = DatatypesFactory.eINSTANCE.createResource();
			resultResource.setUri(resourceURI);
			return resultResource;
		} else {
			throw new BuildException(result.getMessage());
		}
	}

	private void save(URI resourceURI, List<EObject> list) throws IOException {
		org.eclipse.emf.ecore.resource.Resource pnmlResource = new ResourceSetImpl().createResource(resourceURI);
		pnmlResource.getContents().addAll(list);
		pnmlResource.save(Collections.emptyMap());
	}
}
