package theinternet;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class TheInternetUITest {

    @BeforeClass
    public void before() {
        Configuration.holdBrowserOpen = true;
        Selenide.open("https://the-internet.herokuapp.com/login");
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
