package co.com.sofka.stepdefinitions.setup;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class WebUI {

    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_DRIVER_PATH = "src/test/resources/drivers/windows/chrome/chromedriver.exe";

    private static final String PARABANK_PARASOFT_URL = "https://parabank.parasoft.com/parabank/index.htm";

    protected WebDriver driver;

    protected void setUpWebDriver() {
        System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH);//Se configura una variable del sistema
    }

    protected void generalSetUp() { //Inicializar el navegador

        driver = new ChromeDriver();
        driver.get(PARABANK_PARASOFT_URL);//Le indica la ruta donde inicializa
        driver.manage().window().maximize();//Que inicie maximizado. Se pueden poner otras opciones, incluso definir un tamaño determinado, que limpie cookies, etc
    }

    protected void setUpLog4j2() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

    protected void quitDriver() {
        driver.quit();
    }
}