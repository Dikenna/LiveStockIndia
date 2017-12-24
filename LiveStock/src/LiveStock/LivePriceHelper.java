package LiveStock;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class LivePriceHelper {
	private String s_price_url;
	
	public LivePriceHelper(String s_price_url_){
		s_price_url = s_price_url_;
	}

	public String getPrice() throws IOException{
		String price = "Not Found";
		URL price_url = new URL(s_price_url);
		URLConnection price_urlConn = price_url.openConnection();
		InputStreamReader price_inStream = new InputStreamReader(price_urlConn.getInputStream());
		BufferedReader price_buff = new BufferedReader(price_inStream);
		String price_line = price_buff.readLine(); 

		while(price_line!=null){
			if(price_line.contains("span id=\"ltpid_nse\" class=\"bold\">")){
				int target = price_line.indexOf("\">");
				int dest = price_line.indexOf('<', target);
				int start = dest;
				while(start > 1 && price_line.substring(start, start+2)!="\">") start--;
				price = price_line.substring(target+2, dest);
				break;
			}
			price_line = price_buff.readLine();
		}
		return price;
	}
}
