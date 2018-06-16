package xml2json_v01;

public class subProduct {
	private String subProductId;
	private String currencyCode;
	private Integer period;
	private Double rate;
	private Integer min;
	private Integer max;

	public subProduct() {
		// TODO Auto-generated constructor stub
	}
	
	public subProduct(String _subProductId, String _currencyCode, Integer _period, Double _rate, Integer _min, Integer _max) {
		subProductId = _subProductId;
		currencyCode = _currencyCode;
		period = _period;
		rate = _rate;
		min = _min;
		max = _max;
	}
	
	public String getSubProductId() {
		return subProductId;
	}	
	public void setSubProductId(String subProductId) {
		this.subProductId = subProductId;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}	
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	public Integer getPeriod() {
		return period;
	}	
	public void setPeriod(Integer period) {
		this.period = period;
	}
	
	public Double getRate() {
		return rate;
	}	
	public void setRate(Double rate) {
		this.rate = rate;
	}
	
	public Integer getMin() {
		return min;
	}	
	public void setMin(Integer min) {
		this.min = min;
	}
	
	public Integer getMax() {
		return max;
	}	
	public void setMax(Integer max) {
		this.max = max;
	}
}
