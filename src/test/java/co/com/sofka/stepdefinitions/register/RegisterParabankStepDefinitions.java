package co.com.sofka.stepdefinitions.register;

import co.com.sofka.runners.RegisterParabankTest;
import co.com.sofka.stepdefinitions.setup.WebUI;
import co.com.sofka.util.Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

public class RegisterParabankStepDefinitions extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(RegisterParabankTest.class);

    @Given("que estoy en la pagina de registro de la plataforma")
    public void queEstoyEnLaPaginaDeRegistroDeLaPlataforma() {
        try {
            System.out.println("Test1");

        } catch (Exception exception) {
            quitDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }
    @When("diligencie mi informacion personal necesaria")
    public void diligencieMiInformacionPersonalNecesaria(Map<String,String> dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.

        try {

            System.out.println("dataTable print "+dataTable);
            System.out.println("toString "+dataTable.toString());
            System.out.println("value from key "+dataTable.get(Register.FIRST_NAME.getValue()));



        } catch (Exception exception) {
            quitDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @Then("se mostrara un mensaje que confirma mi registro en la plataforma")
    public void seMostraraUnMensajeQueConfirmaMiRegistroEnLaPlataforma() {
        System.out.println("Resultado1");
        quitDriver();
    }

    @Given("que estoy en la pagina de registro")
    public void queEstoyEnLaPaginaDeRegistro() {
        try {
            System.out.println("Test2");

        } catch (Exception exception) {
            quitDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }
    @When("diligencie la informacion personal necesaria")
    public void diligencieLaInformacionPersonalNecesaria(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }
    @When("incluya un Username de un usuario ya existente")
    public void incluyaUnUsernameDeUnUsuarioYaExistente() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("se mostrara un mensaje de error indicando que el Username diligenciado ya existe y no se podra crear el usuario")
    public void seMostraraUnMensajeDeErrorIndicandoQueElUsernameDiligenciadoYaExisteYNoSePodraCrearElUsuario() {
        System.out.println("Resultado2");
        quitDriver();
    }



}