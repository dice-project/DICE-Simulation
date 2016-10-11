package es.unizar.disco.simulation.models.invocation.impl;

import java.util.Date;

import es.unizar.disco.simulation.models.datatypes.SimulationStatus;
import es.unizar.disco.simulation.models.invocation.InvocationSet;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

public class CustomInvocationSetImpl extends InvocationSetImpl implements InvocationSet {

	private static final Date MIN_DATE = new Date(Long.MIN_VALUE);
	private static final Date MAX_DATE = new Date(Long.MAX_VALUE);

	@Override
	public String getIdentifier() {
		return getDefinition().getIdentifier();
	}

	@Override
	public Date getStart() {
		// Check which is the first invocation that has been executed
		Date firstStart = MAX_DATE;
		for (SimulationInvocation invocation : getInvocations()) {
			Date start = invocation.getStart();
			if (start != null && start.before(firstStart)) {
				firstStart = start;
			}
		}
		return !firstStart.equals(MAX_DATE) ? firstStart : null;
	}

	@Override
	public Date getEnd() {
		// Return the last execution end if all the invocations have finished or
		// null if any of them has not an end date
		Date lastEnd = MIN_DATE;
		for (SimulationInvocation invocation : getInvocations()) {
			Date end = invocation.getEnd();
			if (end == null) {
				return null;
			} else if (end.after(lastEnd)) {
				lastEnd = end;
			}
		}
		return lastEnd;
	}
	
	@Override
	public SimulationStatus getStatus() {
		int running = 0;
		int finished = 0;
		int killed = 0;
		int waiting = 0;
		int failed = 0;
		for (SimulationInvocation invocation : getInvocations()) {
			switch (invocation.getStatus()) {
			case RUNNING:
				running++;
				break;
			case FINISHED:
				finished++;
				break;
			case KILLED:
				killed++;
				break;
			case WAITING:
				waiting++;
				break;
			case FAILED:
				failed++;
				break;
			default:
				break;
			}
		}
		if (running > 0) {
			// Any is running -> Set is running
			return SimulationStatus.RUNNING;
		} else if (killed > 0) {
			// No running jobs, any has been killed -> Set has been killed
			return SimulationStatus.KILLED;
		} else if (failed > 0) {
			// No running jobs, no killed jobs, any has failed -> Set has failed
			return SimulationStatus.FAILED;
		} else if (waiting > 0) {
			// No running jobs, no killed jobs, no failed jobs, jobs are waiting -> Set is waiting
			return SimulationStatus.WAITING;
		} else if (finished == getInvocations().size()) {
			// All invocations have finished
			return SimulationStatus.FINISHED;
		} else {
			return SimulationStatus.UNKNOWN; 
		}
	}
}
