package tests;

import assertion.AssertionPage;
import autorisation.AutorisationPage;
import org.junit.*;
import setup.BasePage;
import setup.Browser;

public class authorisationTest  extends BasePage {
    @Before
    public void beforeTest() {
        setBrowserOpenURL(Browser.CHROME, PLATFORM_URL);
    }

    @Test
    public void authorisationCorrectUser(){

        AutorisationPage autorisationPage = new AutorisationPage();
        AssertionPage assertionPage = new AssertionPage();

        autorisationPage.signIn();
        autorisationPage.completeAuthForm();

        assertionPage.assertHeaderIsVisible();
    }

    @After
    public void afterTest(){
        driver.quit();
    }
}
