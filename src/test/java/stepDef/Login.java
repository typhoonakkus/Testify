package stepDef;

import org.openqa.selenium.WebElement;

import Utility.Assertion;
import Utility.Find;
import Utility.Find.FTimeOut;
import Utility.Find.Locator;
import Utility.Util;
import Utility.Util.TimeOut;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login {


    @Given("validate login page")
    public void validate_login_page_and_click_login() {
        WebElement phoneEmail = Find.Element(Locator.id, "PhoneOrEmail", FTimeOut.MIDDLE);
        Assertion.ElementExist(phoneEmail);
    }

	@When("write username {string}")
    public void write_username(String user) {
		WebElement userName = Find.Element(Locator.id, "PhoneOrEmail", FTimeOut.MIDDLE);
		Util.sendKeysFunction(userName, user, TimeOut.HIGH);
    }
    @And("write password {string}")
    public void write_password(String password)  {
    	WebElement passWrd = Find.Element(Locator.name, "Password", FTimeOut.MIDDLE);
		Util.sendKeysFunction(passWrd, password, TimeOut.LOW);
    }
    @And("clicks on login btn")
    public void clicks_on_login_btn() {
    	WebElement loginBtn = Find.Element( Locator.xPath, "//button[text()='Giriş Yap']", FTimeOut.MIDDLE);
		Util.clickFunction(loginBtn, TimeOut.LOW);
    }
    @Then("user is navigate to the home page")
    public void user_is_navigate_to_the_home_page() {
        WebElement errorMessage = Find.Element(Locator.xPath, "//div[text()='Giriş bilgileri hatalıdır. Lütfen tekrar deneyiniz! Eğer hesabınız yoksa kayıt olunuz. ']", FTimeOut.MIDDLE);
        Assertion.ElementExist(errorMessage);
    }

}
