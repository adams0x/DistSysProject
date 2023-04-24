package ds.client.ModelsUI;

public class AnimalIdModel extends AbstractModelObject {
	
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		int oldValue = this.id;
		this.id = id;
		firePropertyChange("id", oldValue, this.id);
	}
	
}
