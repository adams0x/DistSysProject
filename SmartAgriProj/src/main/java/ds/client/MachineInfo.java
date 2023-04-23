package ds.client;

import java.beans.*;

public class MachineInfo {
	
	
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}

	
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		int oldId = this.id;
		this.id = id;
		pcs.firePropertyChange("id", oldId, id);
	}

	
	
	

}
