package xml2json_v01;

import java.util.ArrayList;
import java.util.List;

public class config {

	private String id = "";
	private List<option> options = new ArrayList<option>();
	
	public config() {
	}
	public config(String _id, List<option> _options) {
		id = _id;
		options = _options;
	}
	
	public String getId () {
		return id;
	}
	public void setId (String id) {
		this.id = id;
	}
	
	public List<option> getOptions(){
		return options;
	}
	public void setOptions (List<option> options) {
		this.options = options;
	}

}
