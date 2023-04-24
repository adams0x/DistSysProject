package ds.client;

import java.beans.*;
import java.util.ArrayList;
import java.util.List;

import ds.client.ModelsUI.AbstractModelObject;



public class MachineInfo extends AbstractModelObject {
	
	private List<Integer> m_IdList = new ArrayList<Integer>();
	

	
	public void addId(Integer person) {
		List<Integer> oldValue = m_IdList;
		m_IdList = new ArrayList<Integer>(m_IdList);
		m_IdList.add(person);
		firePropertyChange("idList", oldValue, m_IdList);
		firePropertyChange("idListCount", oldValue.size(), m_IdList.size());
	}

	public void removeId(Integer person) {
		List<Integer> oldValue = m_IdList;
		m_IdList = new ArrayList<Integer>(m_IdList);
		m_IdList.remove(person);
		firePropertyChange("IdList", oldValue, m_IdList);
		firePropertyChange("IdListCount", oldValue.size(), m_IdList.size());
	}
	
	
	
	public List<Integer> getIdList() {
		return m_IdList;
	}
	
	public int getIdListCount() {
		return m_IdList.size();
	}
	
	

}
