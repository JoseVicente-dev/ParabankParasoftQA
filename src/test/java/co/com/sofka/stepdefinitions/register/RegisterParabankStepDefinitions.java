package co.com.sofka.stepdefinitions.register;

import co.com.sofka.model.RegisterFormPageModel;
import co.com.sofka.page.HomePage;
import co.com.sofka.page.RegisterFormPage;
import co.com.sofka.page.common.RegisteredUserPage;
import co.com.sofka.runners.RegisterParabankTest;
import co.com.sofka.stepdefinitions.setup.WebUI;
import co.com.sofka.util.RegisterForm;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RegisterParabankStepDefinitions extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(RegisterParabankTest.class);
    HomePage homePage;
    RegisterFormPageModel registerFormPageModel;
    RegisterFormPage registerFormPage;
    RegisteredUserPage registeredUserPage;

    @Given("que estoy en la pagina de registro de la plataforma")
    public void queEstoyEnLaPaginaDeRegistroDeLaPlataforma() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            homePage = new HomePage(driver, 5, true);
            homePage.goToRegisterForm();

        } catch (Exception exception) {
            quitDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @When("diligencie mi informacion personal necesaria")
    public void diligencieMiInformacionPersonalNecesaria(Map<String, String> dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.

        try {

            registerFormPageModel = new RegisterFormPageModel();
            registerFormPageModel.setFirstName(dataTable.get(RegisterForm.FIRST_NAME.getValue()));
            registerFormPageModel.setLastName(dataTable.get(RegisterForm.LAST_NAME.getValue()));
            registerFormPageModel.setAddress(dataTable.get(RegisterForm.ADDRESS.getValue()));
            registerFormPageModel.setCity(dataTable.get(RegisterForm.CITY.getValue()));
            registerFormPageModel.setState(dataTable.get(RegisterForm.STATE.getValue()));
            registerFormPageModel.setZipCode(dataTable.get(RegisterForm.ZIP_CODE.getValue()));
            registerFormPageModel.setPhoneNumber(dataTable.get(RegisterForm.PHONE_NUMBER.getValue()));
            registerFormPageModel.setSsn(dataTable.get(RegisterForm.SSN.getValue()));
            registerFormPageModel.setUsername(dataTable.get(RegisterForm.USERNAME.getValue()));
            registerFormPageModel.setPassword(dataTable.get(RegisterForm.PASSWORD.getValue()));
            registerFormPageModel.setConfirmPassword(dataTable.get(RegisterForm.CONFIRM_PASSWORD.getValue()));

            registerFormPage = new RegisterFormPage(driver, 10, true, registerFormPageModel);
            registerFormPage.fillRegisterForm();

        } catch (Exception exception) {
            quitDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @Then("se mostrara un mensaje que confirma mi registro en la plataforma")
    public void seMostraraUnMensajeQueConfirmaMiRegistroEnLaPlataforma() {

        registeredUserPage = new RegisteredUserPage(driver, 10, true);
        Assertions.assertEquals(forRegisterAssertions(registerFormPageModel.getUsername()).get(0), registeredUserPage.isRegistrationDone(driver));
        quitDriver();
    }

    @Given("que estoy en la pagina de registro")
    public void queEstoyEnLaPaginaDeRegistro() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            homePage = new HomePage(driver, 5, true);
            homePage.goToRegisterForm();

        } catch (Exception exception) {
            quitDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @When("diligencie la informacion personal necesaria")
    public void diligencieLaInformacionPersonalNecesaria(Map<String, String> dataTable) {
        try {

            registerFormPageModel = new RegisterFormPageModel();
            registerFormPageModel.setFirstName(dataTable.get(RegisterForm.FIRST_NAME.getValue()));
            registerFormPageModel.setLastName(dataTable.get(RegisterForm.LAST_NAME.getValue()));
            registerFormPageModel.setAddress(dataTable.get(RegisterForm.ADDRESS.getValue()));
            registerFormPageModel.setCity(dataTable.get(RegisterForm.CITY.getValue()));
            registerFormPageModel.setState(dataTable.get(RegisterForm.STATE.getValue()));
            registerFormPageModel.setZipCode(dataTable.get(RegisterForm.ZIP_CODE.getValue()));
            registerFormPageModel.setPhoneNumber(dataTable.get(RegisterForm.PHONE_NUMBER.getValue()));
            registerFormPageModel.setSsn(dataTable.get(RegisterForm.SSN.getValue()));
            registerFormPageModel.setUsername(dataTable.get(RegisterForm.USERNAME.getValue()));
            registerFormPageModel.setPassword(dataTable.get(RegisterForm.PASSWORD.getValue()));
            registerFormPageModel.setConfirmPassword(dataTable.get(RegisterForm.CONFIRM_PASSWORD.getValue()));

        } catch (Exception exception) {
            quitDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @When("incluya un Username de un usuario ya existente")
    public void incluyaUnUsernameDeUnUsuarioYaExistente() {
        try {

            registerFormPage = new RegisterFormPage(driver, 10, true, registerFormPageModel);
            registerFormPage.fillRegisterForm();

        } catch (Exception exception) {
            quitDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @Then("se mostrara un mensaje de error indicando que el Username diligenciado ya existe y no se podra crear el usuario")
    public void seMostraraUnMensajeDeErrorIndicandoQueElUsernameDiligenciadoYaExisteYNoSePodraCrearElUsuario() {

        Assertions.assertEquals(forRegisterAssertions(registerFormPageModel.getUsername()).get(1), registerFormPage.errorUserNameAlreadyExists(driver));
        quitDriver();
    }

    private List<String> forRegisterAssertions(String username) {

        List<String> registerExpectedResults = new ArrayList<>();
        registerExpectedResults.add("Welcome " + username);
        registerExpectedResults.add("This username already exists.");

        return registerExpectedResults;
    }
}