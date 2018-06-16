package xml2json_v01;

import java.util.ArrayList;
import java.util.List;

public class product {
	
	private String id = "";
	private String header = "";
	private List<String> conditions  = new ArrayList<String>();
	private List<subProduct> subProductMatrix = new ArrayList<subProduct>();
	
	public product() {
	}
	public product(String _id, String _header, List<String> _conditions, List<subProduct> _subProductMatrix) {
		id = _id;
		header = _header;
		conditions = _conditions;
		subProductMatrix = _subProductMatrix;
	}
	
	public String getId() {
		return id;
	}
	public void setId (String id) {
		this.id = id;
	}
	
	public String getHeader() {
		return header;
	}
	public void setHeader (String header) {
		this.header = header;
	}
	
	public List<String> getConditions() {
		return conditions;
	}
	public void setConditioins (List<String> conditions) {
		this.conditions = conditions;
	}
	
	public List<subProduct> getSubProductMatrix() {
		return subProductMatrix;
	}
	public void setSubProductMatrix (List<subProduct> subProductMatrix) {
		this.subProductMatrix = subProductMatrix;
	}
	

}
