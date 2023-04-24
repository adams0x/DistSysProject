package ds.client.ModelsUI;

import java.util.ArrayList;
import java.util.List;



public class MachineIdCollectionModel extends AbstractModelObject {
	private List<MachineIdModel> m_machines = new ArrayList<MachineIdModel>();

	public void addMachine(MachineIdModel machine) {
		List<MachineIdModel> oldValue = m_machines;
		m_machines = new ArrayList<MachineIdModel>(m_machines);
		m_machines.add(machine);
		firePropertyChange("machines", oldValue, m_machines);
	}

	public void removeMachine(MachineIdModel machine) {
		List<MachineIdModel> oldValue = m_machines;
		m_machines = new ArrayList<MachineIdModel>(m_machines);
		m_machines.remove(machine);
		firePropertyChange("machines", oldValue, m_machines);
	}

	public List<MachineIdModel> getMachines() {
		return m_machines;
	}
	
	
	public int getMachinesCount() {
		return m_machines.size();
	}


}
