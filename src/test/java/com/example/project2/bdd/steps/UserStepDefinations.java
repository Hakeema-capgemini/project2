package com.example.project2.bdd.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.project2.controller.UserController;
import com.example.project2.vo.UserVO;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserStepDefinations {

	@Autowired
	private UserController userController;
	
	private ResponseEntity<UserVO> response;
	
	@Given("App1 is running")
    public void app1_is_running() {
      
    }
	@When("I call GET endpoint {string}")
    public void i_call_get_endpoint(String url) {
        // Call the appropriate endpoint in App2 using the given URL
        if (url.contains("/feign/")) {
            // Simulate calling the Feign endpoint
            String userId = url.split("/")[5];
            response = userController.getUserUsingFeign(Long.parseLong(userId));
        } else if (url.contains("/rest/")) {
            // Simulate calling the RestTemplate endpoint
            String userId = url.split("/")[5];
            response = userController.getUserUsingRestTemplate(Long.parseLong(userId));
        }
    }
	@Then("the response status should be {int}")
    public void the_response_status_should_be(Integer statusCode) {
        assertEquals( statusCode.intValue(), response.getStatusCodeValue());
    }

    @Then("the response body should contain the user details")
    public void the_response_body_should_contain_the_user_details() {
        assertNotNull( response.getBody());
        assertNotNull( response.getBody().getId());
        assertNotNull("User name is missing", response.getBody().getName());
    }
}
