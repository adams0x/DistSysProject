package ds.client.ModelsUI;

public class LiveHeartRateModel extends AbstractModelObject  {
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		int oldValue = this.id;
		this.id = id;
		firePropertyChange("id", oldValue, this.id);
	}
	
	
	private int liveHeartRate;

	public int getLiveHeartRate() {
		return liveHeartRate;
	}

	public void setLiveHeartRate(int liveHeartRate) {
		int oldValue = this.liveHeartRate;
		this.liveHeartRate = liveHeartRate;
		firePropertyChange("liveHeartRate", oldValue, this.liveHeartRate);
	}

	
	private int animalType;

	public int getAnimalType() {
		return animalType;
	}

	public void setAnimalType(int animalType) {
		int oldValue = this.animalType;
		this.animalType = animalType;
		firePropertyChange("animalType", oldValue, this.animalType);
	}

}
