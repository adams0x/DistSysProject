package ds.client.ModelsUI;

import java.util.ArrayList;
import java.util.List;

public class AnimalIdCollectionModel extends AbstractModelObject {
	private List<AnimalIdModel> m_animals = new ArrayList<AnimalIdModel>();

	public void addAnimal(AnimalIdModel animal) {
		List<AnimalIdModel> oldValue = m_animals;
		m_animals = new ArrayList<AnimalIdModel>(m_animals);
		m_animals.add(animal);
		firePropertyChange("animals", oldValue, m_animals);
	}

	public void removeAnimal(AnimalIdModel animal) {
		List<AnimalIdModel> oldValue = m_animals;
		m_animals = new ArrayList<AnimalIdModel>(m_animals);
		m_animals.remove(animal);
		firePropertyChange("animals", oldValue, m_animals);
	}

	public List<AnimalIdModel> getAnimals() {
		return m_animals;
	}
	
	
	public int getAnimalsCount() {
		return m_animals.size();
	}


}
