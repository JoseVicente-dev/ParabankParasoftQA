package co.com.sofka.page;

import co.com.sofka.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountsOverviewPage extends CommonActionOnPages {
    private static final Logger LOGGER = Logger.getLogger(AccountsOverviewPage.class);

    public AccountsOverviewPage(WebDriver driver) {
        super(driver);
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
