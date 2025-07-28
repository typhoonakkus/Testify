package stepDef;

import Utility.Find;
import Utility.Find.FTimeOut;
import Utility.Find.Locator;
import Utility.Util;
import Utility.Util.TimeOut;
import Utility.Assertion;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebElement;

public class CreateAccount {

    @Given("click Hesap Olustur button")
    public void click_hesap_olustur_button() {
        WebElement hesapOlusturBtn = Find.Element(Locator.xPath, "//button[text()='Hesap Oluştur']", FTimeOut.MIDDLE);
        Util.clickFunction(hesapOlusturBtn, TimeOut.MIDDLE);
    }

    @When("enter phone number {string}")
    public void enter_phone_number(String phone) {
        WebElement phoneField = Find.Element(Locator.name, "EmailOrPhone", FTimeOut.MIDDLE);
        Util.sendKeysFunction(phoneField, phone, TimeOut.MIDDLE);
    }

    @And("click Kayıt Ol button")
    public void click_kayit_ol_button() {
        WebElement kayitOlBtn = Find.Element(Locator.xPath, "//button[text()='Kayıt Ol']", FTimeOut.MIDDLE);
        Util.clickFunction(kayitOlBtn, TimeOut.MIDDLE);
    }

    @Then("validate SMSOTP window")
    public void validate_smsotp_window() {
        WebElement otpWindow = Find.Element(Locator.xPath, "//*[@id='Otp_Verify_Area']/div[2]/div[6]/span", FTimeOut.HIGH);
        Assertion.ElementExist(otpWindow);
    }
}
