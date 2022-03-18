package co.com.sofka.page.common;

import co.com.sofka.model.RegisterFormPageModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisteredUserPage extends CommonActionOnPages{



    public RegisteredUserPage(WebDriver driver, int seconds, boolean isExplicitWait) {
        super(driver, seconds, isExplicitWait);

    }


    private final By assertionsUserRegistered  = By.xpath("//div[@id='rightPanel']/h1");


    public String isRegistrationDone(WebDriver driver){

        return driver.findElement(assertionsUserRegistered).getText().trim();

    }


}
