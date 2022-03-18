package co.com.sofka.page;

import co.com.sofka.page.common.CommonActionOnPages;
import org.openqa.selenium.WebDriver;

public class LoginErrorPage extends CommonActionOnPages {


    public LoginErrorPage(WebDriver driver) {
        super(driver);
        PageFactoryInitElement(driver, this);
    }

    public LoginErrorPage(WebDriver driver, int seconds, boolean isExplicitWait) {
        super(driver, seconds, isExplicitWait);
    }

}
