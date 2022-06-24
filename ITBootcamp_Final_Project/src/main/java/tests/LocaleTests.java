package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {

    @Test(priority = 10)

    public void SetLocaleToES() {

        navPage.getLanguagesButton().click();
        navPage.getEsButton().click();

        Assert.assertEquals(navPage.getLocale().getText(),
                "Página de aterrizaje",
                "Error! Text should contain 'Página de aterrizaje'");
    }

    @Test(priority = 20)
    public void SetLocaleToEN() {

        navPage.getLanguagesButton().click();
        navPage.getEnButton().click();

        Assert.assertEquals(navPage.getLocale().getText(),
                "Landing",
                "Error! Text should contain 'Landing'");
    }

    @Test(priority = 30)
    public void SetLocaleToCN() {

        navPage.getLanguagesButton().click();
        navPage.getCnButton().click();

        Assert.assertEquals(navPage.getLocale().getText(),
                "首页",
                "Error! Text should contain '首页'");
    }

    @Test(priority = 40)
    public void SetLocaleToFR() {

        navPage.getLanguagesButton().click();
        navPage.getFrButton().click();

        Assert.assertEquals(navPage.getLocale().getText(),
                "Page d'atterrissage",
                "Error! Text should contain 'Page d'atterrissage'");
    }
}
