package RestDemo;
import static io.restassured.RestAssured.*;

import javax.swing.text.AbstractDocument.Content;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class passPOJOvalue {
	public static void main(String [] args) {
		DemoPOJO obj = new DemoPOJO(3,"Varun","varun34@gmail.com","Varu23");
		
		Response responspe = given().contentType(ContentType.JSON).body(obj).get("http://localhost:3000/users");
		
		responspe.prettyPrint();
	}
}
  