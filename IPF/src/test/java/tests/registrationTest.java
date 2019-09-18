package tests;

import assertion.AssertionPage;
import org.junit.*;
import registration.RegistrationPage;
import setup.BasePage;
import setup.Browser;

public class registrationTest extends BasePage {

    @Before
    public void beforeTest() {
        setBrowserOpenURL(Browser.CHROME, PLATFORM_URL);
    }

    @Test
    public void registerToPlatform(){

        RegistrationPage registrationPage = new RegistrationPage();
        AssertionPage assertionPage = new AssertionPage();

        registrationPage.signIn();
        registrationPage.setEmail();
        registrationPage.completePersonalInformation();
        registrationPage.completeAddress();
        registrationPage.register();

        assertionPage.assertHeaderIsVisible();
    }
    @After
    public void afterTest(){
        driver.quit();
    }

}
