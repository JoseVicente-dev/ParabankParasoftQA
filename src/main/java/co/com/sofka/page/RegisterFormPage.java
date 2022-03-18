package co.com.sofka.page;

import co.com.sofka.model.RegisterFormPageModel;
import co.com.sofka.page.common.CommonActionOnPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterFormPage extends CommonActionOnPages {

    private RegisterFormPageModel registerFormPageModel;

    public RegisterFormPage(WebDriver driver, int seconds, boolean isExplicitWait) {
        super(driver, seconds, isExplicitWait);
        PageFactoryInitElement(driver,this);
    }

    @FindBy (id="customer.firstName")
    @CacheLookup
    private WebElement firstName;

    @FindBy (id = "customer.lastName")
    @CacheLookup
    private WebElement lastName;

    @FindBy (id="customer.address.street")
    @CacheLookup
    private WebElement address;

    @FindBy (id="customer.address.city")
    @CacheLookup
    private WebElement city;

    @FindBy (id="customer.address.state")
    @CacheLookup
    private WebElement state;

    @FindBy (id="customer.address.zipCode")
    @CacheLookup
    private WebElement zipCode;

    @FindBy (id="customer.phoneNumber")
    @CacheLookup
    private WebElement phoneNumber;

    @FindBy (id="customer.ssn")
    @CacheLookup
    private WebElement ssn;

    @FindBy (id="customer.username")
    @CacheLookup
    private WebElement username;

    @FindBy (id="customer.password")
    @CacheLookup
    private WebElement password;

    @FindBy (id="repeatedPassword")
    @CacheLookup
    private WebElement confirmPassword;

    @FindBy(css = "td > .button")
    @CacheLookup
    private WebElement registerBtn;

    //For assertions
    @FindBy(id="customer.username.errors")
    private WebElement usernameError;

    //Funcionalidades del Page
    public void fillRegisterForm(){

        scrollOnWithExplicitWait(firstName);
        clearOnWithExplicitWait(firstName);
        clickOnWithExplicitWait(firstName);
        typeOnWithExplicitWait(firstName, registerFormPageModel.getFirstName());

        scrollOnWithExplicitWait(lastName);
        clearOnWithExplicitWait(lastName);
        clickOnWithExplicitWait(lastName);
        typeOnWithExplicitWait(lastName, registerFormPageModel.getLastName());

        scrollOnWithExplicitWait(address);
        clearOnWithExplicitWait(address);
        clickOnWithExplicitWait(address);
        typeOnWithExplicitWait(address, registerFormPageModel.getAddress());

        scrollOnWithExplicitWait(city);
        clearOnWithExplicitWait(city);
        clickOnWithExplicitWait(city);
        typeOnWithExplicitWait(city,registerFormPageModel.getCity());

        scrollOnWithExplicitWait(state);
        clearOnWithExplicitWait(state);
        clickOnWithExplicitWait(state);
        typeOnWithExplicitWait(state, registerFormPageModel.getState());

        scrollOnWithExplicitWait(zipCode);
        clearOnWithExplicitWait(zipCode);
        clickOnWithExplicitWait(zipCode);
        typeOnWithExplicitWait(zipCode, registerFormPageModel.getZipCode());

        scrollOnWithExplicitWait(phoneNumber);
        clearOnWithExplicitWait(phoneNumber);
        clickOnWithExplicitWait(phoneNumber);
        typeOnWithExplicitWait(phoneNumber, registerFormPageModel.getPhoneNumber());

        scrollOnWithExplicitWait(ssn);
        clearOnWithExplicitWait(ssn);
        clickOnWithExplicitWait(ssn);
        typeOnWithExplicitWait(ssn, registerFormPageModel.getSsn());

        scrollOnWithExplicitWait(username);
        clearOnWithExplicitWait(username);
        clickOnWithExplicitWait(username);
        typeOnWithExplicitWait(username,registerFormPageModel.getUsername());

        scrollOnWithExplicitWait(password);
        clearOnWithExplicitWait(password);
        clickOnWithExplicitWait(password);
        typeOnWithExplicitWait(password,registerFormPageModel.getPassword());

        scrollOnWithExplicitWait(confirmPassword);
        clearOnWithExplicitWait(confirmPassword);
        clickOnWithExplicitWait(confirmPassword);
        typeOnWithExplicitWait(confirmPassword, registerFormPageModel.getConfirmPassword());

        doSubmit(registerBtn);

    }


}
