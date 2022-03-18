package co.com.sofka.page;

import co.com.sofka.model.LoginPageModel;
import co.com.sofka.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonActionOnPages {

    private static final Logger LOGGER = Logger.getLogger(HomePage.class);

    private LoginPageModel loginPageModel;

    public HomePage(WebDriver driver, LoginPageModel loginPageModel) {
        super(driver);
        PageFactoryInitElement(driver,this);
        this.loginPageModel = loginPageModel;
    }

    public HomePage(WebDriver driver, int seconds, boolean isExplicitWait, LoginPageModel loginPageModel) {
        super(driver, seconds, isExplicitWait);
        PageFactoryInitElement(driver,this);
        this.loginPageModel=loginPageModel;
    }

    //For register test scenarios
    @FindBy(linkText = "Register")
    @CacheLookup
    private WebElement registerLink;

    //for login test scenarios
    @FindBy(name = "username")
    @CacheLookup
    private WebElement username;

     @FindBy(name = "password")
     @CacheLookup
     private WebElement password;

     @FindBy(css = ".button:nth-child(1)")
     @CacheLookup
     private WebElement loginBtn;

    //Funcionalidades del Page
    public void goToRegisterForm(){
        scrollOnWithExplicitWait(registerLink);
        clickOnWithExplicitWait(registerLink);
    }

    public void login(){

        scrollOnWithExplicitWait(username);
        clearOnWithExplicitWait(username);
        clickOnWithExplicitWait(username);
        typeOnWithExplicitWait(username,loginPageModel.getUsername());

        scrollOnWithExplicitWait(password);
        clearOnWithExplicitWait(password);
        clickOnWithExplicitWait(password);
        typeOnWithExplicitWait(password, loginPageModel.getPassword());

        scrollOnWithExplicitWait(loginBtn);
        doSubmitWithExplicitWait(loginBtn);
    }
}
