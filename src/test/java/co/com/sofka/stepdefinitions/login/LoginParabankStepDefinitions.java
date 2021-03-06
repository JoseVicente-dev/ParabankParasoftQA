package co.com.sofka.stepdefinitions.login;

import co.com.sofka.model.HomePageModel;
import co.com.sofka.page.pages.AccountsOverviewPage;
import co.com.sofka.page.pages.HomePage;
import co.com.sofka.page.pages.LoginErrorPage;
import co.com.sofka.stepdefinitions.setup.WebUI;
import co.com.sofka.util.enums.LoginForm;
import co.com.sofka.util.enums.Seconds;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginParabankStepDefinitions extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(LoginParabankStepDefinitions.class);

    HomePageModel homePageModel;
    HomePage homePage;
    AccountsOverviewPage accountsOverviewPage;
    LoginErrorPage loginErrorPage;

    @When("ingrese mis credenciales de login validas")
    public void ingreseMisCredencialesDeLoginValidas(Map<String, String> dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

        try {
            generalSetUp();

            homePageModel = new HomePageModel();
            homePageModel.setUsername(dataTable.get(LoginForm.USERNAME.getValue()));
            homePageModel.setPassword(dataTable.get(LoginForm.PASSWORD.getValue()));

            homePage = new HomePage(driver, Seconds.TEN_SECONDS.getValue(), true, homePageModel);
            homePage.login();

        } catch (Exception exception) {
            quitDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @Then("podre consultar el estado de mis poductos")
    public void podreConsultarElEstadoDeMisPoductos() {

        accountsOverviewPage = new AccountsOverviewPage(driver,Seconds.TEN_SECONDS.getValue(),true);
        Assertions.assertEquals(forLoginAssertions().get(0), accountsOverviewPage.isLoginDone());
        quitDriver();
    }


    @When("ingrese credenciales omitiendo el password")
    public void ingreseCredencialesOmitiendoElPassword(Map<String, String> dataTable) {
        try {
            generalSetUp();

            homePageModel = new HomePageModel();
            homePageModel.setUsername(dataTable.get(LoginForm.USERNAME.getValue()));

            homePage = new HomePage(driver, Seconds.TEN_SECONDS.getValue(), true, homePageModel);
            homePage.login();

        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quitDriver();
        }
    }

    @Then("se mostrara un mensaje de error y no podre ingrear al aplicativo")
    public void seMostraraUnMensajeDeErrorYNoPodreIngrearAlAplicativo() {

        loginErrorPage = new LoginErrorPage(driver,Seconds.TEN_SECONDS.getValue(),true);
        Assertions.assertEquals(forLoginAssertions().get(1),loginErrorPage.loginFailed());
        quitDriver();
    }

    private List<String> forLoginAssertions() {
        List<String> loginExpectedResults = new ArrayList<>();
        loginExpectedResults.add("Account Services");
        loginExpectedResults.add("Please enter a username and password.");
        return loginExpectedResults;
    }
}
