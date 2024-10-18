package StrategyPattern;

import java.util.ArrayList;
import java.util.List;

public class Strategy {

	public static void main(String[] args) {
		//Client
		
		ShoppingCart cart = new ShoppingCart();
		
		Item item1 = new Item("1234", 10);
		Item item2 = new Item("5678", 40);
		
		cart.addItem(item1);
		cart.addItem(item2);
		
		//pay by paypal
		cart.pay(new PaypalStrategy("jason@email.com", "mypassword"));
		//pay by credit card
		cart.pay(new CreditCardStrategy("jason fedin", "222222", "444", "12/15"));
		
	}

}

interface PaymentStrategy{
	public void pay(int amount);
}

class CreditCardStrategy implements PaymentStrategy{
	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;
	
	public CreditCardStrategy(String nm,String ccNum,String cvv,String expiryDate) {
		this.name = nm;
		this.cardNumber = ccNum;
		this.cvv = cvv;
		this.dateOfExpiry = expiryDate;
	}
	
	@Override
	public void pay(int amount) {
		System.out.println(amount+" paid with credit/debit card.");
	}
}

class PaypalStrategy implements PaymentStrategy{
	private String email_id;
	private String password;
	
	public PaypalStrategy(String email,String pwd){
		this.email_id = email;
		this.password = pwd;
	}
	
	@Override
	public void pay(int amount) {
		System.out.println(amount+" paid using Paypal.");
	}
}

class Item{
	private String upcCode;
	private int price;
	
	public Item(String upc,int cost) {
		this.upcCode = upc;
		this.price = cost;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getUpcCode() {
		return upcCode;
	}
}

class ShoppingCart{
	List<Item> items;
	
	public ShoppingCart() {
		this.items = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}
	
	public void removeItem(Item item) {
		this.items.remove(item);
	}
	
	public int calculateTotal() {
		int sum = 0;
		for(Item item:items) {
			sum+=item.getPrice();
		}
		return sum;
	}
	
	public void pay(PaymentStrategy paymentMethod) {
		int amount = calculateTotal();
		paymentMethod.pay(amount);
	}
}


