package co.com.sofka.page;

import co.com.sofka.page.common.CommonActionOnPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountsOverviewPage extends CommonActionOnPages {
    public AccountsOverviewPage(WebDriver driver) {
        super(driver);
        PageFactoryInitElement(driver,this);
    }

    public AccountsOverviewPage(WebDriver driver, int seconds, boolean isExplicitWait) {
        super(driver, seconds, isExplicitWait);
        PageFactoryInitElement(driver,this);

    }

    //For login assertions
    @FindBy
    @CacheLookup
    private WebElement titleAccountsOverview;

    public String isLoginDone(){
        return titleAccountsOverview.getText().trim();
    }

}
