package ds.client.ModelsUI;

import java.util.ArrayList;
import java.util.List;

public class AnimalHealthReportCollectionModel extends AbstractModelObject {
	
	private List<AnimalHealthReportModel> healthReports = new ArrayList<AnimalHealthReportModel>();

	public void addHealthReport(AnimalHealthReportModel healthReport) {
		List<AnimalHealthReportModel> oldValue = healthReports;
		healthReports = new ArrayList<AnimalHealthReportModel>(healthReports);
		healthReports.add(healthReport);
		firePropertyChange("healthReports", oldValue, healthReports);
	}

	public void removeHealthReport(AnimalHealthReportModel healthReport) {
		List<AnimalHealthReportModel> oldValue = healthReports;
		healthReports = new ArrayList<AnimalHealthReportModel>(healthReports);
		healthReports.remove(healthReport);
		firePropertyChange("healthReports", oldValue, healthReports);
	}

	public List<AnimalHealthReportModel> getHealthReports() {
		return healthReports;
	}
	
	
	public int getReportsCount() {
		return healthReports.size();
	}

}
