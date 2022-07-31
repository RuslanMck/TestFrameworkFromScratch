package theinternet;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class TheInternetLoginTest {

    @BeforeClass
    public void start(){
        Selenide.open("https://the-internet.herokuapp.com/login");
    }

    private void enterCredentials(String name, String password){
        $("#username").setValue(name);
        $("#password").setValue(password);
    }

    @Test
    @Description("Verify that the user can be logged in with valid credentials")
    public void setCredentials(){
        enterCredentials("tomsmith","SuperSecretPassword!");
        $(By.xpath("//button[@type='submit']")).click();
        Assert.assertTrue($(By.xpath("//*[@class='flash success']")).isDisplayed());
        Assert.assertEquals($("h4").getText(), "Welcome to the Secure Area. When you are done click logout below.");
    }
}
