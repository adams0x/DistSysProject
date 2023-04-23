package ds.client;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class jmDNSInfo {

	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
	
	
	
	private String discoveryStatus;

	public String getDiscoveryStatus() {
		return discoveryStatus;
	}

	public void setDiscoveryStatus(String discoveryStatus) {
		//String oldDiscoveryStatus = discoveryStatus;
		String oldDiscoveryStatus = String.valueOf(this.discoveryStatus);
		this.discoveryStatus = discoveryStatus;
		pcs.firePropertyChange("discoveryStatus", oldDiscoveryStatus, discoveryStatus);
	}
	


}
