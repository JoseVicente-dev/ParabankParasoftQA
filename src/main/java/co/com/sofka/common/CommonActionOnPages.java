package co.com.sofka.common;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CommonActionOnPages extends BaseSikulix {

    private static final Logger LOGGER = Logger.getLogger(CommonActionOnPages.class);
    private static final String WEBDRIVER_NULL_MESSAGE = "\nWARNING!\n\rThe Webdriver is null, please check it. \n";
    private WebDriver driver;


    //Tiempo implicito
    private void webDriverImplicitWait(WebDriver driver, int seconds) {
        try {
            driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Tiempo explicito
    private WebDriverWait webDriverExplicitWait;

    //Configurar la espera del tiempo explicito
    private void setWebDriverExplicitWait(WebDriver webDriver, int seconds) {
        try {
            webDriverExplicitWait = new WebDriverWait(webDriver, seconds);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);

        }
    }

    //Constructor
    public CommonActionOnPages(WebDriver driver) {
        try {

            if (driver == null) {
                LOGGER.warn((WEBDRIVER_NULL_MESSAGE));
            } else {
                this.driver = driver;
            }

        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Constructor con parámetro que define el tipo de tiempo de espera
    public CommonActionOnPages(WebDriver driver, int seconds, boolean isExplicitTime) {
        try {

            if (driver == null) {
                LOGGER.warn((WEBDRIVER_NULL_MESSAGE));
            } else {
                this.driver = driver;

                if (isExplicitTime) {

                    setWebDriverExplicitWait(driver, seconds);
                } else {
                    webDriverImplicitWait(driver, seconds);
                }
            }

        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Init POM with Page Factory
    protected void PageFactoryInitElement(WebDriver driver, Object page) {
        PageFactory.initElements(driver, page);
    }


    //Funcionalidades
    protected void clickOn(By localizador) {
        driver.findElement(localizador).click();
    }

    protected void clickOn(WebElement webElement) {
        webElement.click();
    }

    protected void clickOnWithExplicitWait(By localizador) {
        driver.findElement(localizador).click();
    }

    protected void clickOnWithExplicitWait(WebElement webElement) {
        webElement.click();
    }

    protected void clearOn(By localizador) {
        driver.findElement(localizador).clear();
    }

    protected void clearOn(WebElement webElement) {
        webElement.clear();
    }

    protected void clearOnWithExplicitWait(WebElement webElement) {
        webDriverExplicitWait.until(ExpectedConditions.elementToBeClickable(webElement)).clear();
    }

    protected void clearOnWithExplicitWait(By localizador) {
        webDriverExplicitWait.until(ExpectedConditions.elementToBeClickable(localizador)).clear();
    }

    protected void typeOn(By localizador, CharSequence... keysToSend) {
        driver.findElement(localizador).sendKeys(keysToSend);
    }

    protected void typeOn(WebElement webElement, CharSequence... keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    protected void typeOnWithExplicitWait(By localizador, CharSequence... keysToSend) {
        driver.findElement(localizador).sendKeys(keysToSend);
    }

    protected void typeOnWithExplicitWait(WebElement webElement, CharSequence... keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    protected void scrollOn(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", webElement);
    }

    protected void scrollOn(By localizador) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", driver.findElement(localizador));
    }

    protected void scrollOnWithExplicitWait(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", webElement);
    }

    protected void scrollOnWithExplicitWait(By localizador) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", driver.findElement(localizador));
    }

    protected void doSubmit(By localizador) {
        driver.findElement(localizador).submit();
    }

    protected void doSubmit(WebElement webElement) {
        webElement.submit();
    }

    protected void doSubmitWithExplicitWait(By localizador) {
        driver.findElement(localizador).submit();
    }

    protected void doSubmitWithExplicitWait(WebElement webElement) {
        webElement.submit();
    }

    protected String getText(By localizador) {
        return driver.findElement(localizador).getText();
    }

    protected String getText(WebElement webElement) {
        return webElement.getText();
    }

    protected String getTextWithExplicitWait(By localizador) {
        return driver.findElement(localizador).getText();
    }

    protected String getTextWithExplicitWait(WebElement webElement) {
        return webElement.getText();
    }
}
