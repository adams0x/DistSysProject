package ds.client.ModelsUI;

import java.util.ArrayList;
import java.util.List;

public class MachineReportCollectionModel extends AbstractModelObject {
	private List<MachineReportModel> m_machines = new ArrayList<MachineReportModel>();

	public void addMachine(MachineReportModel machine) {
		List<MachineReportModel> oldValue = m_machines;
		m_machines = new ArrayList<MachineReportModel>(m_machines);
		m_machines.add(machine);
		firePropertyChange("machines", oldValue, m_machines);
	}

	public void removeMachine(MachineReportModel machine) {
		List<MachineReportModel> oldValue = m_machines;
		m_machines = new ArrayList<MachineReportModel>(m_machines);
		m_machines.remove(machine);
		firePropertyChange("machines", oldValue, m_machines);
	}

	public List<MachineReportModel> getMachines() {
		return m_machines;
	}
	
	
	public int getMachinesCount() {
		return m_machines.size();
	}


}
