package co.com.sofka.page.pages;

import co.com.sofka.model.CustomerCareFormModel;
import co.com.sofka.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomerCarePage extends CommonActionOnPages {

    private static final Logger LOGGER = Logger.getLogger(CustomerCarePage.class);

    CustomerCareFormModel customerCareFormModel;

    public CustomerCarePage(WebDriver driver, int seconds, boolean isExplicitWait, CustomerCareFormModel customerCareFormModel) {
        super(driver, seconds, isExplicitWait);
        PageFactoryInitElement(driver,this);
        this.customerCareFormModel=customerCareFormModel;
    }

    //For customer care scenarios
    @FindBy(id = "name")
    @CacheLookup
    private WebElement name;

    @FindBy(id = "email")
    @CacheLookup
    private WebElement email;

    @FindBy(id = "phone")
    @CacheLookup
    private WebElement phone;

    @FindBy(id = "message")
    @CacheLookup
    private WebElement message;

    @FindBy(css = "td > .button")
    @CacheLookup
    private WebElement sendToCustomerCareBtn;

    //For assertions


    //Funcionalidades del Page
    public void fillCustomerCareForm(){
        scrollOnWithExplicitWait(name);
        clearOnWithExplicitWait(name);
        clickOnWithExplicitWait(name);
        typeOnWithExplicitWait(name, customerCareFormModel.getName());

        scrollOnWithExplicitWait(email);
        clearOnWithExplicitWait(email);
        clickOnWithExplicitWait(email);
        typeOnWithExplicitWait(email, customerCareFormModel.getEmail());

        scrollOnWithExplicitWait(phone);
        clearOnWithExplicitWait(phone);
        clickOnWithExplicitWait(phone);
        typeOnWithExplicitWait(phone, customerCareFormModel.getPhone());

        scrollOnWithExplicitWait(message);
        clearOnWithExplicitWait(message);
        clickOnWithExplicitWait(message);
        typeOnWithExplicitWait(message, customerCareFormModel.getMessage());

        scrollOnWithExplicitWait(sendToCustomerCareBtn);
        clickOnWithExplicitWait(sendToCustomerCareBtn);
    }


}
