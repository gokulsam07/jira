package jira.endpoints;


import org.testng.annotations.BeforeMethod;
import io.restassured.RestAssured;
public class BaseBuilder {

	
	@BeforeMethod
	public void setUp() {
		String username = "Feb2023restAPI@gmail.com";
		String password ="ATATT3xFfGF0d39TsozfFQWR0Hvr0UfPqKKtyFJxQvnaGGtSvez8FvOvhfzSTapOBEUGx0ZAdIbWfM5tjeU8rFw7Rh72pbanmBdYhtysnC3yH89HMn-lXz9PTGKVKtWFV2vp6GyZ_75P27LqLCAbHxqOjYds1SNn5oFZQFDi3ufeUI3cJwdCy20=5543D93F";
		RestAssured.baseURI="https://testjirafeb2023.atlassian.net";
		RestAssured.authentication = RestAssured.preemptive().basic(username, password);
	}
}
