package xml2json_v01;

public class message {
	
	private String title = "";
	private String text = "";
	private String type = "";
	
	public message() {
	}
	public message(String _title, String _text, String _type) {
		title = _title;
		text = _text;
		type = _type;		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
