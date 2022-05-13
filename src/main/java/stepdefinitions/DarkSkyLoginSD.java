package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DarkSkyAPI;
import pages.DarkskyHomePage;
import pages.Login;

import static stepdefinitions.SharedSD.getDriver;

public class DarkSkyLoginSD {

    Login login = new Login();
    @Given("I am on the darksky Login page")
    public void i_am_on_the_darksky_login_page() {

        login.clickDarkSkyAPI();
        login.clickLnkLogin();

    }
    @When("I click on Login button")
    public void i_click_on_login_button() {
            login.clickBtnLogin();
    }
    @Then("I verify I am on the Login page itself by asserting Login page title")
    public void i_verify_i_am_on_the_login_page_itself_by_asserting_login_page_title() {

        Assert.assertEquals("this is not a login page",
                "Dark Sky API: Log In",
                getDriver().getTitle());

    }

}
