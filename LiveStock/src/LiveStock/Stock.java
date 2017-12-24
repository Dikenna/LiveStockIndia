package LiveStock;

public class Stock {

	private String name;
	private float price;
	
	public Stock(String name_, float price_){
		name = name_;
		price = price_;
	}
	
	public String getName(){
		return name;
	}
	
	public Float getPrice(){
		return price;
	}
	
	public Stock getStock(){
		return this;
	}
	
}
