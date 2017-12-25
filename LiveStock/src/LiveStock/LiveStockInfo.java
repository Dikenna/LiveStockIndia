package LiveStock;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;
import java.util.Scanner;

//Display live stock in India
public class LiveStockInfo {

	public static void main(String[] args) throws IOException {
		//Method can be looped to get as many companies as 
		Scanner sc = new Scanner(System.in);
		System.out.println("Select Indice: (Connect spaces with dashes: eg \"nifty-50\")");
		String indice = sc.next();

		URL url = new URL("http://money.rediff.com/indices/nse/"+indice); //Check if there is a "next" page
		URLConnection urlConn = url.openConnection();
		InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
		BufferedReader buff = new BufferedReader(inStream);
		String line = buff.readLine(); 
		System.out.println("StockStore id: numbers only:");
		StockStore store = new StockStore(sc.nextInt());

		System.out.println("Finding " + indice + " companies in INDIA with real quotes...");
		while(line!=null){
			if(line.contains("                    <a href=\"//money.rediff.com/companies/")){
				LiveCompanyHelper g = new LiveCompanyHelper(line);
				String name = g.getName();
				String s_price_url = g.getPrice_URL();
				
				LivePriceHelper h = new LivePriceHelper(s_price_url);
				String price = h.getPrice();
				
				store.addStock(name, price);
				System.out.println("Name: " + name + "    Price: " + price);
			}
			line = buff.readLine();
		}
		System.out.println("Done");
	}
}
