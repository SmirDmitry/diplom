package xml2json_v01;

public class capacity_unit {

	private String id;
	private String header;
	private Double amount;
	
	public capacity_unit() {
		// TODO Auto-generated constructor stub
	}
	
	public capacity_unit(String _id, String _header, Double _amount) {
		id = _id;
		header = _header;
		amount = _amount;
	}
	
	public String getId (){
		return id;
	}
	public void setId (String id) {
		this.id  = id ;
	}
	
	public String getHeader(){
		return header;
	}
	public void setHeader (String header) {
		this.header  = header;
	}
	
	public Double getAmount(){
		return amount;
	}
	public void setAmount (Double amount) {
		this.amount  = amount;
	}

}
