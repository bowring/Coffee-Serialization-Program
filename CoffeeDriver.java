//driver to create objects of coffee class 
import java.io.FileNotFoundException;
import java.io.IOException;

public class CoffeeDriver {
	public static void main(String[] args) throws FileNotFoundException{
		Coffee myCoffee = new Coffee("iced", "latte", "whole milk", "whip cream");
		Coffee myOtherCoffee = new Coffee("hot", "cappucino", "low fat", "cinnamon");
		
		myCoffee.writeToCSV(myOtherCoffee, "coffeeDrinks");
		
		myCoffee.getFromCSV(myOtherCoffee, "coffeeDrinks");
		
	
		try {
			myCoffee.saveCoffeeXML(myOtherCoffee, "coffeeDrinks");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			myCoffee.loadCoffeeXML("coffeeDrinks");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			myCoffee.saveSerializedCoffee(myOtherCoffee, "javaSerializedCoffee");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			myCoffee.loadSerialized(myOtherCoffee, "javaSerializedCoffee");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
