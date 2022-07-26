package healthcheck;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.HealthCheckSteps;

public class IncludeMe {

    @Test(description = "Health check test example")
    //или можно использовать аннотаию Алюра Description, но что-то одно
    // @Description("Health check test example")
    public void includeMeTest(){
        HealthCheckSteps healthCheckSteps = new HealthCheckSteps();
        Assert.assertTrue(healthCheckSteps.checkLoginAndPassword("qwertyu", "123qwert"));
//        Assert.assertTrue(healthCheckSteps.checkLoginAndPassword("qwe", "123"));
    }
}
