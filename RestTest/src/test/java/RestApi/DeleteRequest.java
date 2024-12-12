package RestApi;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class DeleteRequest {
	public static void main(String[] args) {
		given().contentType(ContentType.JSON).delete("123").statusCode();
	}

}
