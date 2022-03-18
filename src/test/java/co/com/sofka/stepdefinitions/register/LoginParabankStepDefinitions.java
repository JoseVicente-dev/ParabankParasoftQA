package co.com.sofka.stepdefinitions.register;

import co.com.sofka.stepdefinitions.setup.WebUI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class LoginParabankStepDefinitions extends WebUI {



    @When("ingrese mis credenciales de login validas")
    public void ingreseMisCredencialesDeLoginValidas(Map<String, String> dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.



    }
    @Then("podre consultar el estado de mis poductos")
    public void podreConsultarElEstadoDeMisPoductos() {

    }


    @When("ingrese credenciales omitiendo el password")
    public void ingreseCredencialesOmitiendoElPassword(Map<String,String> dataTable) {

    }
    @Then("se mostrara un mensaje de error y no podre ingrear al aplicativo")
    public void seMostraraUnMensajeDeErrorYNoPodreIngrearAlAplicativo() {

    }


}
