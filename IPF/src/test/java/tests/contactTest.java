package tests;

import assertion.AssertionPage;
import contact.ContactPage;
import org.junit.*;
import setup.BasePage;
import setup.Browser;

public class contactTest extends BasePage {
    @Before
    public void beforeTest() {
        setBrowserOpenURL(Browser.CHROME, PLATFORM_URL);
    }

    @Test
    public void contactUsForm() {

        ContactPage contactPage = new ContactPage();
        AssertionPage assertionPage = new AssertionPage();

        contactPage.contactUs();
        contactPage.completeMessage();
        contactPage.send();

        assertionPage.assertNotification();
    }
    @After
    public void afterTest(){
        driver.quit();
    }
}
