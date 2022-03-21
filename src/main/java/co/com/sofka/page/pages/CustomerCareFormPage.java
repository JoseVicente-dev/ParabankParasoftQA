package co.com.sofka.page.pages;

import co.com.sofka.model.CustomerCareFormModel;
import co.com.sofka.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomerCareFormPage extends CommonActionOnPages {

    private static final Logger LOGGER = Logger.getLogger(CustomerCareFormPage.class);

    CustomerCareFormModel customerCareFormModel;

    public CustomerCareFormPage(WebDriver driver) {
        super(driver);
        pageFactoryInitElement(driver, this);
    }

    public CustomerCareFormPage(WebDriver driver, int seconds, boolean isExplicitWait, CustomerCareFormModel customerCareFormModel) {
        super(driver, seconds, isExplicitWait);
        pageFactoryInitElement(driver, this);
        this.customerCareFormModel = customerCareFormModel;
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
    @FindBy(css = "#rightPanel > p:nth-child(2)")
    private WebElement assertionsThankYouMessage;

    @FindBy(id = "email.errors")
    private WebElement assertionsEmailError;

    @FindBy(id = "phone.errors")
    private WebElement assertionsPhoneError;

    //Funcionalidades del Page
    public void fillCustomerCareForm() {
        scrollOnWithExplicitWait(name);
        clearOnWithExplicitWait(name);
        clickOnWithExplicitWait(name);
        typeOnWithExplicitWait(name, customerCareFormModel.getName());

        scrollOnWithExplicitWait(email);
        clearOnWithExplicitWait(email);
        clickOnWithExplicitWait(email);

        String emailText = customerCareFormModel.getEmail() != null ? customerCareFormModel.getEmail() : "";
        typeOnWithExplicitWait(email, emailText);

        scrollOnWithExplicitWait(phone);
        clearOnWithExplicitWait(phone);
        clickOnWithExplicitWait(phone);

        String phoneText = customerCareFormModel.getPhone() != null? customerCareFormModel.getPhone() : "";
        typeOnWithExplicitWait(phone, phoneText);

        scrollOnWithExplicitWait(message);
        clearOnWithExplicitWait(message);
        clickOnWithExplicitWait(message);
        typeOnWithExplicitWait(message, customerCareFormModel.getMessage());

        scrollOnWithExplicitWait(sendToCustomerCareBtn);
        clickOnWithExplicitWait(sendToCustomerCareBtn);
    }

    public String isCustomerCareMessageSend() {
        return getTextWithExplicitWait(assertionsThankYouMessage);
    }

    public String errorContactInformationIsRequired() {

        return getTextWithExplicitWait(assertionsEmailError) + " " + getTextWithExplicitWait(assertionsPhoneError);

    }

}
