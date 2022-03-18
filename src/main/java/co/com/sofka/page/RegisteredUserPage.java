package co.com.sofka.page;

import co.com.sofka.model.RegisterFormPageModel;
import co.com.sofka.page.common.CommonActionOnPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisteredUserPage extends CommonActionOnPages {

    public RegisteredUserPage(WebDriver driver, int seconds, boolean isExplicitWait) {
        super(driver, seconds, isExplicitWait);
    }

    //For registered user Assertions
    private final By assertionsUserRegistered  = By.xpath("//div[@id='rightPanel']/h1");

    public String isRegistrationDone(WebDriver driver){

        return driver.findElement(assertionsUserRegistered).getText().trim();
    }
}
