package co.com.sofka.page.common;

import co.com.sofka.model.RegisterFormPageModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisteredUserPage extends CommonActionOnPages{

    private RegisterFormPageModel registerFormPageModel;
    private String registeredUserXpath;

    public RegisteredUserPage(WebDriver driver, int seconds, boolean isExplicitWait, RegisterFormPageModel registerFormPageModel) {
        super(driver, seconds, isExplicitWait);
        this.registerFormPageModel=registerFormPageModel;
        defineRegisteredUserXpath(registerFormPageModel.getUsername());
    }


    private final By assertionsUserRegistered  = By.xpath("//div[@id='rightPanel']/h1");


    public String isRegistrationDone(WebDriver driver){

        return driver.findElement(assertionsUserRegistered).getText().trim();

    }

    private void defineRegisteredUserXpath(String username){
        this.registeredUserXpath =  "//h1[contains(.,'Welcome "+username+"']";
    }

}
