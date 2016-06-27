package es.unizar.disco.simulation.models.builders;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Element;

import es.unizar.disco.simulation.models.datatypes.PrimitiveVariableAssignment;
import es.unizar.disco.simulation.models.traces.TraceSet;

public interface IAnalyzableModelBuilder {
	
	public final class ModelResult {
		
		private final List<EObject> model;
		
		private final TraceSet traceSet;

		private final IStatus status;
		
		public ModelResult(List<EObject> list, TraceSet traceSet, IStatus status) {
			this.model = list;
			this.traceSet = traceSet;
			this.status = status;
		}
		
		public List<EObject> getModel() {
			return new BasicEList<>(EcoreUtil.copyAll(model));
		}
		
		public TraceSet getTraceSet() {
			return EcoreUtil.copy(traceSet);
		}
		
		public IStatus getStatus() {
			return status;
		}
	}

	public ModelResult createAnalyzableModel(Element element, List<PrimitiveVariableAssignment> assignments);

}
