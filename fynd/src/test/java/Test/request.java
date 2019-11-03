package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.testng.annotations.Test;

import Utils.Testutils;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class request extends Basetest{

	@Test
	public void test() throws FileNotFoundException {

		RequestSpecification request = RestAssured.given();
		
		Scanner sc = new Scanner(System.in);
		String br = "";
		System.out.println("enter method name");
		br = sc.next();
		sc.close();
		
		if (br.equalsIgnoreCase("get")) {

			response = request.get("/employees");
			System.out.println("data is " + response.asString());
			Testutils.checkStatus(response);
			System.out.println("Response time " + response.getTime());
		}

		else if (br.equalsIgnoreCase("post")) {
			/*
			RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
			RequestSpecification request = RestAssured.given();
			JSONObject json = new JSONObject();
			json.put("name", "abcxyzq");
			json.put("salary", "64321");
			json.put("age", "30");
			request.body(json.toJSONString());
            */
			
			request.header("Content-Type", "application/json");
			
			FileInputStream fis = new FileInputStream(new File(".\\employee.json"));
			request.body(fis);
  
			response = request.post("/create");
			Testutils.checkStatus(response);

		} 
		
		else if (br.equalsIgnoreCase("put")) {
			int id = 99485;

			request.header("Content-Type", "application/json");

			FileInputStream fis = new FileInputStream(new File(".\\employee.json"));
			request.body(fis);

			response = request.put("/update/" + id);
			Testutils.checkStatus(response);
		} 
		
		else if (br.equalsIgnoreCase("del")) {
			int id = 99422;

			response = request.delete("/delete/" + id);
			Testutils.checkStatus(response);
		} 	
		
	}
}
