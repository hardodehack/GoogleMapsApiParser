package xyz.hardik.GoogleMapsApiParser;

import java.io.FileOutputStream;

import javax.xml.bind.*;

public class Java2XmlMarshaller {
	public static void main(String[] args) {
		
	
	try {
		JAXBContext context = JAXBContext.newInstance(GeocodeResponse.class);
		Marshaller marshaller = context.createMarshaller();
	
		Address a = new Address();
		a.setShort_name("Short Means Short");
		a.setLong_name("Long is Long");
		Result r = new Result();
		r.setFormatted_address("Hsiaisa,ajb j  bnk  389001");
		r.setPlace_id("hiii hoooo haaa");
		r.setType("Bau Motu");
		r.setAddress(a);
		GeocodeResponse go = new GeocodeResponse();
		go.setStatus("Ala Perfect");
		go.setRes(r);
		
		marshaller.marshal(go,new FileOutputStream("generated.xml"));
		System.out.println("****************Successufully Generated*********************");
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	}
}
