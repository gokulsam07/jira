package jira.tests;


import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jira.endpoints.BaseBuilder;



public class createIssueTest extends BaseBuilder {
	public static String id;

	@Test
	public void createIssue() {
		Response res =  RestAssured.given().contentType("application/json")
				.when()
				.body("{\r\n"
						+ "    \"fields\": {\r\n"
						+ "        \"project\": {\r\n"
						+ "            \"key\": \"TES\"\r\n"
						+ "        },\r\n"
						+ "        \"summary\": \"Create a new JIRA issue using Postman for Marathon\",\r\n"
						+ "        \"description\": \"Creating a Bug in JIRA using JIRA API with the help of Rest Assured\",\r\n"
						+ "        \"issuetype\": {\r\n"
						+ "            \"name\": \"Bug\"\r\n"
						+ "        }\r\n"
						+ "    }\r\n"
						+ "}")
				.post("/rest/api/2/issue");
		id = res.then().extract().jsonPath().get("id");
		res.then().assertThat().statusCode(201);
		res.then().assertThat().body("id", Matchers.equalTo(id));
	}

}
