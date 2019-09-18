package contact;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import setup.BasePage;
import setup.Wait;

public class ContactPage extends BasePage {
    private By cotactUsBtn = By.id("contact-link");
    private By subjectDrp = By.id("id_contact");
    private By emailInput = By.id("email");
    private By orderInput = By.id("id_order");
    private By messageInput = By.id("message");
    private By sendBtn = By.id("submitMessage");

    private Select subject;

    ContactModel contactModel = new ContactModel();

    public ContactPage() {
        setLogger(ContactPage.class.getName());
    }

    public void contactUs(){
        waitClick(Wait.VISIBLE, cotactUsBtn, contactModel.getContact());
    }

    public void completeMessage(){
        subject = new Select(driver.findElement(subjectDrp));
        subject.selectByValue("2");
        waitSendkeys(Wait.VISIBLE, emailInput, contactModel.getEmail(), "maks.brzeczyszczykiewicz@wp.pl");
        waitSendkeys(Wait.VISIBLE, orderInput, contactModel.getOrder(), "23.M");
        waitSendkeys(Wait.VISIBLE, messageInput, contactModel.getMessage(), "Cokolwiek");
    }

    public void send(){
        waitClick(Wait.VISIBLE, sendBtn, contactModel.getSend());
    }
}
