package jira.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import jira.endpoints.BaseBuilder;

public class deleteIssueTest extends BaseBuilder {

	@Test(dependsOnMethods="jira.tests.createIssueTest.createIssue")
	public void deleteIssue() {
		Response res =  RestAssured.given().contentType("application/json").pathParam("id", createIssueTest.id)
				.when()
				.delete("/rest/api/2/issue/{id}");
		res.then().assertThat().statusCode(204);
	}

}
