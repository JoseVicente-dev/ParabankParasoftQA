package co.com.sofka.stepdefinitions.register;

import co.com.sofka.model.CustomerCareFormModel;
import co.com.sofka.page.pages.CustomerCareFormPage;
import co.com.sofka.page.pages.HomePage;
import co.com.sofka.stepdefinitions.setup.WebUI;
import co.com.sofka.util.enums.CustomerCareForm;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerCareParabankStepDefinitions extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(CustomerCareParabankStepDefinitions.class);

    HomePage homePage;
    CustomerCareFormModel customerCareFormModel;
    CustomerCareFormPage customerCareFormPage;


    @Given("que estoy en la seccion Custom Care")
    public void queEstoyEnLaSeccionCustomCare() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            homePage = new HomePage(driver, 10, true, null);
            homePage.goToCustomerCareForm();

        } catch (Exception exception) {
            quitDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }

    }

    @When("diligencie mi PQRS y la envie")
    public void diligencieMiPQRSYLaEnvie(Map<String, String> dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        try {

            customerCareFormModel = new CustomerCareFormModel();
            customerCareFormModel.setName(dataTable.get(CustomerCareForm.NAME.getValue()));
            customerCareFormModel.setEmail(dataTable.get(CustomerCareForm.EMAIL.getValue()));
            customerCareFormModel.setPhone(dataTable.get(CustomerCareForm.PHONE.getValue()));
            customerCareFormModel.setMessage(dataTable.get(CustomerCareForm.MESSAGE.getValue()));

            customerCareFormPage = new CustomerCareFormPage(driver,10,true,customerCareFormModel);
            customerCareFormPage.fillCustomerCareForm();


        } catch (Exception exception) {
            quitDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }

    }

    @Then("se confirmara el envio de la misma")
    public void seConfirmaraElEnvioDeLaMisma() {

        Assertions.assertEquals(forCustomerCareAssertions(customerCareFormModel.getName()).get(0),customerCareFormPage.isCustomerCareMessageSend());
        quitDriver();

    }


    @Given("que estoy en Custom Care")
    public void queEstoyEnCustomCare() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            homePage = new HomePage(driver, 10, true, null);
            homePage.goToCustomerCareForm();

        } catch (Exception exception) {
            quitDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @When("diligencie el mensaje de la PQRS y no suministre datos de contacto")
    public void diligencieElMensajeDeLaPQRSYNoSuministreDatosDeContacto(Map<String, String> dataTable) {
        try {

            customerCareFormModel = new CustomerCareFormModel();
            customerCareFormModel.setName(dataTable.get(CustomerCareForm.NAME.getValue()));
            customerCareFormModel.setMessage(dataTable.get(CustomerCareForm.MESSAGE.getValue()));

            customerCareFormPage = new CustomerCareFormPage(driver,10,true,customerCareFormModel);
            customerCareFormPage.fillCustomerCareForm();

        } catch (Exception exception) {
            quitDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @Then("no se podra enviar la PQRS")
    public void noSePodraEnviarLaPQRS() {

        Assertions.assertEquals(forCustomerCareAssertions(customerCareFormModel.getName()).get(1),customerCareFormPage.errorContactInformationIsRequired());

        quitDriver();
    }

    private List<String> forCustomerCareAssertions(String name){
        List<String> customerCareExpectedResults = new ArrayList<>();
        customerCareExpectedResults.add("Thank you "+name);
        customerCareExpectedResults.add("Email is required. Phone is required.");
        return customerCareExpectedResults;
    }

}
