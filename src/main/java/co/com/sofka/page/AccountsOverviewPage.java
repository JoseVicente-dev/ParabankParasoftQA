package co.com.sofka.page;

import co.com.sofka.page.common.CommonActionOnPages;
import org.openqa.selenium.WebDriver;

public class AccountsOverviewPage extends CommonActionOnPages {
    public AccountsOverviewPage(WebDriver driver) {
        super(driver);
    }

    public AccountsOverviewPage(WebDriver driver, int seconds, boolean isExplicitWait) {
        super(driver, seconds, isExplicitWait);
    }
}
