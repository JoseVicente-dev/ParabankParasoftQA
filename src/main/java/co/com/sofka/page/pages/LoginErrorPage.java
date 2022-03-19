package co.com.sofka.page.pages;

import co.com.sofka.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginErrorPage extends CommonActionOnPages {

    private static final Logger LOGGER = Logger.getLogger(LoginErrorPage.class);

    public LoginErrorPage(WebDriver driver) {
        super(driver);
        PageFactoryInitElement(driver, this);
    }

    public LoginErrorPage(WebDriver driver, int seconds, boolean isExplicitWait) {
        super(driver, seconds, isExplicitWait);
        PageFactoryInitElement(driver, this);
    }

    //For login error assertions
    @FindBy(css = ".error")
    @CacheLookup
    private WebElement assertionsLoginErrorMessage;

    public String loginFailed() {
        return assertionsLoginErrorMessage.getText().trim();
    }
}
