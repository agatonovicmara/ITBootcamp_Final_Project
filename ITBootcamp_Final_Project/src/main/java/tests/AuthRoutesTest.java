package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTest extends BasicTest {

    @Test(priority = 10)

    public void ForbidVisitsToHomeUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/home");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "Error, there should be '/login' route"
        );

    }

    @Test(priority = 20)

    public void ForbidVisitsToProfileUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/profile");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "Error, there should be '/login' route"
        );
    }

    @Test(priority = 30)

    public void ForbidVisitsToAdminCitiesUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/admin/cities");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "Error, there should be '/login' route"
        );
    }

    @Test(priority = 40)

    public void ForbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/admin/users");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "Error, there should be '/login' route"
        );
    }


}
