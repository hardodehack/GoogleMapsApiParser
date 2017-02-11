package xyz.hardik.GoogleMapsApiParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;		// It will be throws by createUnmarshaller method 
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by hpatel on 07-02-2017.
 * 
 * This is main JAXBUnmarshaller class in our project,
 * which will convert XML to Java Object.
 * 
 * Whatever you want you just have to call getters of that object
 * 
 */

public class Xml2JavaUnmarshaller {

	public static void main(String[] args) {
		
		URL url;
	    InputStream is = null;
	    String location;
	    Scanner scan = new Scanner(System.in);
	    System.out.println("Enter Location here :- ");
	    location = scan.next();
	        
		try {
			
			url = new URL("https://maps.googleapis.com/maps/api/geocode/xml?address="+location);
			is = url.openStream();       
			
			
			JAXBContext context = JAXBContext.newInstance(GeocodeResponse.class);	// It will retuen object of JAXBContext Abstract Class.
			
			Unmarshaller unmarshaller = context.createUnmarshaller(); 				
			GeocodeResponse gObj = (GeocodeResponse) unmarshaller.unmarshal(url);
			
			/*if(gObj.getStatus()=="OK"){*/
				
				System.out.println("Full Address is : "+gObj.getRes().getFormatted_address());
				System.out.println("Latitude for "+location+" is "+gObj.getRes().geo.getLocation().getLat());
				System.out.println("Longitude for "+location+" is "+gObj.getRes().geo.getLocation().getLng());
					
			/*}
			else{
				
				System.out.println("The Status is showing "+gObj.getStatus()+"\nPlease check the Location you Entered.");
				System.out.println("Processing Please wait...");
				
				
			}*/
			
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			System.out.println("The Location you Entered is Wrong"+location);
			System.err.println("Or May Be some Other Exception, Please check");
		}

	}

}
