package es.unizar.disco.simulation.models.builders;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
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

		/**
		 * Returns the result model. This method returns the original model
		 * produced by the transformation and not a shallow copy since it is
		 * required to maintain the proper traceability links. Clients should
		 * not modify the model obtained by calling this method.
		 * 
		 * @return the produced model
		 */
		public List<EObject> getModel() {
			return model;
		}

		/**
		 * Returns the trace model. This method returns the original trace model
		 * produced by the transformation and not a shallow copy. This is needed
		 * to maintain the proper traceability links. Clients should not modify
		 * the model obtained by calling this method.
		 * 
		 * @return the trace model
		 */
		public TraceSet getTraceSet() {
			return traceSet;
		}

		/**
		 * Returns the status of the executed {@link IAnalyzableModelBuilder}
		 * 
		 * @return the {@link IStatus}
		 */
		public IStatus getStatus() {
			return status;
		}
	}

	public ModelResult createAnalyzableModel(Element element, List<PrimitiveVariableAssignment> assignments);

}
