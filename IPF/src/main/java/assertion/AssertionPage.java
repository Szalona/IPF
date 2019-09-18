package assertion;

import org.junit.Assert;
import org.openqa.selenium.By;
import setup.BasePage;
import setup.Elements;
import setup.Wait;


public class AssertionPage  extends BasePage {

    private By notification = By.xpath("//p[@class='alert alert-success']");

    AssertionModel assertionModel = new AssertionModel();

    public AssertionPage() {
        setLogger(AssertionPage.class.getName());
    }

    public void assertHeaderIsVisible() {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://automationpractice.com/index.php?controller=my-account");
    }

    public void assertNotification(){
        assertText(Wait.VISIBLE, notification, Elements.TEXT, assertionModel.getNotification(),"Your message has been successfully sent to our team.");
    }
}
