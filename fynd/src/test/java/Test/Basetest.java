package Test;

import org.testng.annotations.BeforeClass;

import Utils.Testutils;
import io.restassured.response.Response;

public class Basetest {
	
	public Response response;
	
	@BeforeClass
	public void setup()
	{
		
		Testutils.seturl();
	}
	
}
