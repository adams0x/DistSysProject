package ds.client.ModelsUI;

public class AnimalHealthReportModel extends AbstractModelObject  {

	private int id;
	private int minBPM;
	private int maxBPM;
	private int avgBPM;
	private String reportDate;
	private String dateOfBirth;
	private String dateNextVaccine;
	private String animalType;
	private String health;

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		int oldValue = this.id;
		this.id = id;
		firePropertyChange("id", oldValue, this.id);
	}
	public int getMinBPM() {
		return minBPM;
	}
	public void setMinBPM(int minBPM) {
		int oldValue = this.minBPM;
		this.minBPM = minBPM;
		firePropertyChange("minBPM", oldValue, this.minBPM);
	}
	public int getMaxBPM() {
		return maxBPM;
	}
	public void setMaxBPM(int maxBPM) {
		int oldValue = this.maxBPM;
		this.maxBPM = maxBPM;
		firePropertyChange("maxBPM", oldValue, this.maxBPM);
	}
	public int getAvgBPM() {
		return avgBPM;
	}
	public void setAvgBPM(int avgBPM) {
		int oldValue = this.avgBPM;
		this.avgBPM = avgBPM;
		firePropertyChange("avgBPM", oldValue, this.avgBPM);
	}

	
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		String oldValue = String.valueOf(this.reportDate);
		this.reportDate = reportDate;
		firePropertyChange("reportDate", oldValue, this.reportDate);
	}
	public String getDateNextVaccine() {
		return dateNextVaccine;
	}
	public void setDateNextVaccine(String dateNextVaccine) {
		String oldValue = String.valueOf(this.dateNextVaccine);
		this.dateNextVaccine = dateNextVaccine;
		firePropertyChange("dateNextVaccine", oldValue, this.dateNextVaccine);
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		String oldValue = String.valueOf(this.dateOfBirth);
		this.dateOfBirth = dateOfBirth;
		firePropertyChange("dateOfBirth", oldValue, this.dateOfBirth);
	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		String oldValue = String.valueOf(this.animalType);
		this.animalType = animalType;
		firePropertyChange("animalType", oldValue, this.animalType);
	}
	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		String oldValue = String.valueOf(this.health);
		this.health = health;
		firePropertyChange("health", oldValue, this.health);
	}

	
}
