package co.com.sofka.page;

import co.com.sofka.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonActionOnPages {


    private static final Logger LOGGER = Logger.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactoryInitElement(driver,this);
    }

    public HomePage(WebDriver driver, int seconds, boolean isExplicitWait) {
        super(driver, seconds, isExplicitWait);
        PageFactoryInitElement(driver,this);
    }

    //For register test scenarios
    @FindBy(linkText = "Register")
    @CacheLookup
    private WebElement register;

    //Funcionalidades del Page
    public void goToRegisterForm(){
        scrollOnWithExplicitWait(register);
        clickOnWithExplicitWait(register);
    }

}
