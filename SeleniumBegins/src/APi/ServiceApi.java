package APi;

import javax.xml.ws.Endpoint;


public class ServiceApi {

	public static void main(String[] args) {

		Endpoint.publish("http://localhost:8067/Calculator",new Calculator());
		System.out.println("Servie loaded");

	}

}
