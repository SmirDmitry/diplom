package xml2json_v01;

import java.util.ArrayList;
import java.util.List;

public class dashboard {

	private List<String> messages = new ArrayList<String>();
	private List<product> availableProducts = new ArrayList<product>();
	private List<product> unavailableProducts = new ArrayList<product>();
	private List<Double> loans = new ArrayList<Double>();
	
	public dashboard() {
	}
	public dashboard(List<String> _messages, List<product> _availableProducts, List<product> _unavailableProducts, List<Double> _loans) {
		messages = _messages;
		availableProducts = _availableProducts;
		unavailableProducts = _unavailableProducts;
		loans = _loans;
	}
	
	public List<String> getMessages(){
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	public List<product> getAvailableProducts(){
		return availableProducts;
	}
	public void setAvailableProducts (List<product> availableProducts) {
		this.availableProducts = availableProducts;
	}
	
	public List<product> getUnavailableProducts(){
		return unavailableProducts;
	}
	public void setUnavailableProducts (List<product> unavailableProducts) {
		this.unavailableProducts = unavailableProducts;
	}
	
	public List<Double> getLoans (){
		return loans;
	}
	public void setLoans(List<Double> loans) {
		this.loans = loans;
	}

}
