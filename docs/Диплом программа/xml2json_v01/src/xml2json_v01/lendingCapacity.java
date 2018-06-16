package xml2json_v01;

import java.util.ArrayList;
import java.util.List;

public class lendingCapacity {

	private Boolean calculated = true;
	private String calculationDate = "";
	private Boolean expired = true;
	private String expirationDate = "";
	private List<capacity_unit> capacity = new ArrayList<capacity_unit>();
	public lendingCapacity() {
	}
	public lendingCapacity(Boolean _calculated, String _calculationDate, Boolean _expired, String _expirationDate, List<capacity_unit> _capacity) {
		calculated = _calculated;
		calculationDate = _calculationDate;
		expired = _expired;
		expirationDate = _expirationDate;
		capacity = _capacity;		
	}
	
	public Boolean getCalculated () {
		return calculated;
	}
	public void setCalculated (Boolean calculated) {
		this.calculated = calculated;
	}
	
	public String getCalculationDate () {
		return calculationDate;
	}
	public void setCalculationDate(String calculationDate) {
		this.calculationDate = calculationDate;
	}
	
	public Boolean getExpired () {
		return expired;
	}
	public void setExpired(Boolean expired) {
		this.expired = expired;
	}
	
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate (String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public List<capacity_unit> getCapacity (){
		return capacity;
	}
	public void setCapacity(List<capacity_unit> capacity) {
		this.capacity = capacity;
	}

}
