//coffee class 
import java.io.*;
import java.util.*;
import java.util.logging.Logger;
import java.beans.*;

public class Coffee implements Serializable {
		private String temperature; 
		private String type; 
		private String milk; 
		private String garnish; 
	
	public Coffee() {
		//empty constructor
	}
	public Coffee(String temp, String type, String milk, String garnish) {
		this.temperature = temp;
		this.type = type;
		this.milk = milk; 
		this.garnish = garnish; 
	}
	
	public void setTemp(String temperature) {
		this.temperature = temperature; 
	}
	
	public String getTemp() {
		return temperature;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setMilk(String milk) {
		this.milk = milk; 
	}
	
	public String getMilk() {
		return milk;
	}
	
	public void setGarnish(String garnish) {
		this.garnish = garnish;
	}
	
	public String getGarnish() {
		return garnish;
	}
	
	//end class definition 
	
	//prove serialization using csv 
	
	public void writeToCSV(Coffee coffee, String filename) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(filename + ".csv"));
        StringBuilder sb = new StringBuilder();
		sb.append(coffee.getTemp());
		sb.append(",");
		sb.append(coffee.getType());
		sb.append(",");
		sb.append(coffee.getMilk());
		sb.append(",");
		sb.append(coffee.getGarnish());
		
        pw.write(sb.toString());
        pw.close();
        System.out.println("done writing to csv!");
	}
	
	public void getFromCSV(Coffee coffee, String filename) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(filename + ".csv"));
        scanner.useDelimiter(",");
        Coffee myCoffeeTest = new Coffee();
        myCoffeeTest.setTemp(scanner.next());
        myCoffeeTest.setType(scanner.next());
        myCoffeeTest.setMilk(scanner.next());
        myCoffeeTest.setGarnish(scanner.next());
        scanner.close();
        
        System.out.println("State of original coffee: " + coffee.getTemp() + " " + coffee.getType()
        		+ " " + coffee.getMilk() + " " + coffee.getGarnish());
        System.out.println("State of returned coffee test: " + myCoffeeTest.getTemp() + " " + myCoffeeTest.getType()
        		+ " " + myCoffeeTest.getMilk() + " " + myCoffeeTest.getGarnish());
        
	}
	
	//use java serialization here 
	
	public void saveSerializedCoffee(Coffee coffee, String filename) throws IOException {
  
		FileOutputStream fileOutput = new FileOutputStream(filename + ".bin");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        
        outputStream.writeObject(coffee);
   
        outputStream.flush();
        outputStream.close();
        
        System.out.println("Pre-Serialized Coffee: " + coffee.getTemp() + " " + 
				coffee.getType() + " " + coffee.getMilk() + " " + coffee.getGarnish());
      
    } 


    public void loadSerialized(Coffee coffee, String filename) throws Exception {
    		
    		FileInputStream fileInput = new FileInputStream(filename + ".bin");
    		ObjectInputStream objectInput = new ObjectInputStream(fileInput);
    		
    		Coffee coffeeSerialized = (Coffee)objectInput.readObject();
    		
    		System.out.println("Serialized Coffee: " + coffee.getTemp() + " " + 
    				coffee.getType() + " " + coffee.getMilk() + " " + coffee.getGarnish());
  
	}
	
	
	//use XML here 
	
	public void saveCoffeeXML(Coffee coffee, String filename) throws IOException {
		FileOutputStream os = new FileOutputStream(filename + ".xml");
		XMLEncoder encoder = new XMLEncoder(os);
		encoder.writeObject(coffee);
		encoder.flush();
		encoder.close(); 
		
		System.out.println("read to XML");
	}
	
	public Object loadCoffeeXML(String filename) throws ClassNotFoundException, IOException {
		FileInputStream os = new FileInputStream(filename + ".xml");
		XMLDecoder decoder = new XMLDecoder(os);
		Object object = decoder.readObject();
		decoder.close();
		
		System.out.println("read from XML");
		
		return object;
		
		
	}

	
}
