package xml2json_v01;

import java.util.ArrayList;
import java.util.List;

public class body {
	
	private lendingCapacity lendingCapacity;
	private dashboard dashboard;
	private List<config> configs = new ArrayList<config>();
	
	public body() {
	}
	public body(lendingCapacity _lendingCapacity, dashboard _dashboard, List<config> _configs) {
		lendingCapacity = _lendingCapacity;
		dashboard = _dashboard;
		configs = _configs;
	}
	public lendingCapacity getLendingCapacity() {
		return lendingCapacity;
	}
	public void setLendingCapacity(lendingCapacity lendingCapacity) {
		this.lendingCapacity = lendingCapacity;
	}
	
	public dashboard getDashboard () {
		return dashboard;
	}
	public void setDashboard (dashboard dashboard) {
		this.dashboard = dashboard;
	}
	
	public List<config> getConfigs(){
		return configs;
	}
	public void setConfigs (List<config> configs) {
		this.configs = configs;
	}

}
