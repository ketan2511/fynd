package Utils;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Testutils {
	
	
	public static void seturl() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	}
	
	public static void checkStatus (Response response) {
		Assert.assertEquals(response.getStatusCode(),200, "Status Check Failed!");
        System.out.println("status code is "+response.getStatusCode());
    }

}
