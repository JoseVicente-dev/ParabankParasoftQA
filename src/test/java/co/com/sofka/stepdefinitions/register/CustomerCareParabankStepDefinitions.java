package co.com.sofka.stepdefinitions.register;

import co.com.sofka.stepdefinitions.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import java.util.Map;

public class CustomerCareParabankStepDefinitions extends WebUI {
    private static final Logger LOGGER = Logger.getLogger(CustomerCareParabankStepDefinitions.class);


    @Given("que estoy en la seccion Custom Care")
    public void queEstoyEnLaSeccionCustomCare() {

    }
    @When("diligencie mi PQRS y la envie")
    public void diligencieMiPQRSYLaEnvie(Map<String,String> dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

    }
    @Then("se confirmara el envio de la misma")
    public void seConfirmaraElEnvioDeLaMisma() {

    }



    @Given("que estoy en Custom Care")
    public void queEstoyEnCustomCare() {


    }
    @When("diligencie el mensaje de la PQRS y no suministre datos de contacto")
    public void diligencieElMensajeDeLaPQRSYNoSuministreDatosDeContacto(Map<String,String> dataTable) {



    }
    @Then("no se podra enviar la PQRS")
    public void noSePodraEnviarLaPQRS() {


    }

}
