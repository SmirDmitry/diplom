package xml2json_v01;

public class option {
	private String id = "";
	private String value = "";
	
	public option() {
		
	}
	public option(String _id, String _value) {
		id = _id;
		value = _value;
	}
	
	public String getId () {
		return id;
	}
	public void setId (String id) {
		this.id = id;
	}
	
	public String getValue () {
		return value;
	}
	public void setValue (String value) {
		this.value = value;
	}

}
