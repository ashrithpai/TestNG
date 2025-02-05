package com.testNg.ApiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GETMethodTests {
	
	@Test
	public void getAllPosts()
	{
		Response response = 
		RestAssured
			.given()
				.contentType(ContentType.JSON)
				.baseUri("https://jsonplaceholder.typicode.com/posts/1")
			.when()
				.get()
			.then()
				.assertThat()
					.statusCode(200)
			.extract()
				.response();
		
		Assert.assertTrue(response.getBody().asString().contains("userId"));
					
	}

}
