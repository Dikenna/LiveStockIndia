package LiveStock;

public class LiveCompanyHelper {

	private String name; 
	private int t; 
	private int d;
	private String line;

	public LiveCompanyHelper(String line){
		//Get company name
		this.line = line;
		int target = line.indexOf("s/");
		int dest = line.indexOf("/1", target);
		int start = dest;
		while(start > 1 && line.substring(start, start+2)!="s/") start--;
		name = line.substring(target+2, dest);

		//get url of page to get price...
		t = line.indexOf("//");
		d = line.indexOf("\">");
	}

	public String getName(){
		return name;
	}

	public String getPrice_URL(){
		return ("https:"+line.substring(t, d));
	}
}
