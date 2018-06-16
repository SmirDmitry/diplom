package xml2json_v01;

import java.util.ArrayList;
import java.util.List;

public class GetClientRiskMetricsRs {

	private body body;
	private List<message> messages = new ArrayList<message>();
	
	public GetClientRiskMetricsRs() {
	}
	public GetClientRiskMetricsRs(body _body, List<message> _messages) {
		body = _body;
		messages = _messages;
	}
	public body getBody() {
		return body;
	}
	public void setBody(body body) {
		this.body = body;
	}
	
	public List<message> getMessages (){
		return messages;
	}
	public void setMessages(List<message> messages) {
		this.messages = messages;
	}

}
