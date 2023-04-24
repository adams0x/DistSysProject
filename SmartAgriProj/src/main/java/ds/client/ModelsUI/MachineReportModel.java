package ds.client.ModelsUI;

public class MachineReportModel extends AbstractModelObject  {

	private int id;
	private String reportDate;
	private String dateNextService;
	private float volumeLitres;
	private float heatedTemperature;
	private float heatedDuration;
	private float chilledTemperature;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		int oldValue = this.id;
		this.id = id;
		firePropertyChange("id", oldValue, this.id);
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		String oldValue = String.valueOf(this.reportDate);
		this.reportDate = reportDate;
		firePropertyChange("reportDate", oldValue, this.reportDate);
	}
	public String getDateNextService() {
		return dateNextService;
	}
	public void setDateNextService(String dateNextService) {
		String oldValue = String.valueOf(this.dateNextService);
		this.dateNextService = dateNextService;
		firePropertyChange("dateNextService", oldValue, this.dateNextService);
	}
	public float getVolumeLitres() {
		return volumeLitres;
	}
	public void setVolumeLitres(float volumeLitres) {
		float oldValue = this.volumeLitres;
		this.volumeLitres = volumeLitres;
		firePropertyChange("volumeLitres", oldValue, this.volumeLitres);
	}
	public float getHeatedTemperature() {
		return heatedTemperature;
	}
	public void setHeatedTemperature(float heatedTemperature) {
		float oldValue = this.heatedTemperature;
		this.heatedTemperature = heatedTemperature;
		firePropertyChange("heatedTemperature", oldValue, this.heatedTemperature);
	}
	public float getHeatedDuration() {
		return heatedDuration;
	}
	public void setHeatedDuration(float heatedDuration) {
		float oldValue = this.heatedDuration;
		this.heatedDuration = heatedDuration;
		firePropertyChange("heatedDuration", oldValue, this.heatedDuration);
	}
	public float getChilledTemperature() {
		return chilledTemperature;
	}
	public void setChilledTemperature(float chilledTemperature) {
		float oldValue = this.chilledTemperature;
		this.chilledTemperature = chilledTemperature;
		firePropertyChange("chilledTemperature", oldValue, this.chilledTemperature);
	}

	
	


}
