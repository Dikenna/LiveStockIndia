package LiveStock;

import java.util.Map;
import java.util.HashMap;

public class StockStore {
	private Map<String, Stock> stocks = new HashMap<String, Stock>();
	private int id;

	public StockStore(){

	}

	public StockStore(int id_){
		id = id_;
	}

	public void addStock(String name_, String price_){
		float price = 0;
		if(price_.equals("Not Found")) price = 0;
		else price = Float.valueOf(price_);
		Stock stock = new Stock(name_, price);
		stocks.put(stock.getName(), stock);
	}

	public int getId(){
		return id;
	}

}
