package jira.tests;


import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jira.endpoints.BaseBuilder;

public class getIssueAfterDeleteTest extends BaseBuilder{

	@Test(dependsOnMethods="jira.tests.deleteIssueTest.deleteIssue")
	public void getIssueAfterDelete() {
		Response res =  RestAssured.given().contentType("application/json").pathParam("id", createIssueTest.id)
				.when()
				.body("{\r\n"
						+ "    \"fields\": {\r\n"
						+ "        \"description\": \"Updated the details of field description using PUT call via Rest Assured\"\r\n"
						+ "    }\r\n"
						+ "}")
				.get("/rest/api/2/issue/{id}");
		res.then().assertThat().statusCode(404);
	}
}
