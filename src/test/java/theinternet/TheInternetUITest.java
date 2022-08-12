package theinternet;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TheInternetUITest {

    @BeforeClass
    public void before() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "104.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://192.168.0.77:4444/wd/hub").toURL(),
                capabilities
        );
        WebDriverRunner.setWebDriver(driver);

        Configuration.holdBrowserOpen = true;
        open("https://the-internet.herokuapp.com/login");
    }

    @Test (priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the login page is opened and main blocks are displayed")
    @Step("Verify that the login page title is displayed")
    public void loginPageOpening() {
//        $(By.xpath("//a[contains(text(),'Form Authentication')]")).click();
        Assert.assertEquals($("h2").getText(), "Login Page");
        System.out.println("1");
    }

    @Test
    @Description("Verify that the login block is displayed")
    public void loginBlockIsVisible() {
        Assert.assertTrue($("#login").isDisplayed());
        System.out.println("2");

    }

    @Test
    @Description("Verify that the login input field is displayed")
    public void loginInputIsVisible() {
        Assert.assertTrue($("#username").isDisplayed());
        System.out.println("3");

    }

    @Test
    @Description("Verify that the password input field is displayed")
    public void passwordInputIsVisible() {
        Assert.assertTrue($("#password").isDisplayed());
        System.out.println("4");

    }

    @Test
    @Description("Verify that the login button is displayed")
    public void loginButtonIsVisible() {
        Assert.assertTrue($(By.xpath("//button[@type='submit']")).isDisplayed());
        System.out.println("5");

    }
    @Test
    public void selenideTest1() {
        open("https://google.com");
        $("[name='q']")
                .shouldBe(visible)
                .setValue("Selenide")
                .pressEnter();
        $$x("//h3[contains(text(), 'Selenide')]")
                .filter(visible)
                .shouldHave(sizeGreaterThanOrEqual(7))
                .get(1)
                .click();
        $(".donate_header")
                .shouldHave(text("Selenide Supports Ukraine \uD83C\uDDFA\uD83C\uDDE6"));
    }


//    private void enterCredentials(String name, String password){
//        $("#username").setValue(name);
//        $("#password").setValue(password);
//    }
//
//    @Test
//    @Description("setCredentials")
//    public void setCredentials(){
//        enterCredentials("tomsmith","SuperSecretPassword!");
//        $(By.xpath("//button[@type='submit']")).click();
//    }

}
