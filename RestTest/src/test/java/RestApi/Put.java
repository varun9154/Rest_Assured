package RestApi;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
public class Put{
	public static void main (String[]args) {
	Response respones =given().contentType("application/json")
			
			.body("{\r\n"
	              + "    \"id\": \"9\",\r\n"
	                + "    \"customerName\": \"varun\",\r\n"
	               + "    \"email\": \"varun@gmail.com\",\r\n"
	              + "    \"phoneNo\": \"65432445\",\r\n"
	               + "    \"orderId\": \"ORD1234789\"\r\n"
	                + "}")
	            .post("http://localhost:3000/customers/5");
			respones.prettyPrint();
	//System.out.println(respones.asPrettyString());
	}
}

