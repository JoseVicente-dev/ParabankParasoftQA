package co.com.sofka.page.common;

import co.com.sofka.model.RegisterFormPageModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisteredUserPage extends CommonActionOnPages{

    private RegisterFormPageModel registerFormPageModel;

    public RegisteredUserPage(WebDriver driver, int seconds, boolean isExplicitWait, RegisterFormPageModel registerFormPageModel) {
        super(driver, seconds, isExplicitWait);
        this.registerFormPageModel=registerFormPageModel;
    }

    private final By assertionsUserRegistered = By.xpath("//h1[contains(.,'Welcome "+registerFormPageModel.getUsername()+"']");

    public String isRegistrationDone(WebDriver driver){

        return driver.findElement(assertionsUserRegistered).getText().trim();

    }

}
