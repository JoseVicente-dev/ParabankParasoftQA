package co.com.sofka.page.pages;

import co.com.sofka.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisteredUserPage extends CommonActionOnPages {

    private static final Logger LOGGER = Logger.getLogger(RegisteredUserPage.class);


    public RegisteredUserPage(WebDriver driver, int seconds, boolean isExplicitWait) {
        super(driver, seconds, isExplicitWait);
        PageFactoryInitElement(driver,this);
    }

    //For registered user Assertions
    private final By assertionsUserRegistered  = By.xpath("//div[@id='rightPanel']/h1");

    public String isRegistrationDone(WebDriver driver){

        return driver.findElement(assertionsUserRegistered).getText().trim();
    }
}
