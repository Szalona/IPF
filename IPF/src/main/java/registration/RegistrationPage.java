package registration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import setup.BasePage;
import setup.Wait;

public class RegistrationPage extends BasePage {
    private By signInBtn = By.xpath("//div[@class='header_user_info']");
    private By emailInput = By.id("email_create");
    private By createAccountBtn = By.id("SubmitCreate");
    private By titleRadioBtn = By.id("id_gender1");
    private By firstNameInput = By.id("customer_firstname");
    private By lastNameInput = By.id("customer_lastname");
    private By passwordInput = By.id("passwd");
    private By dayDrp = By.id("days");
    private By monthsDrp = By.id("months");
    private By yearsDrp = By.id("years");
    private By addressInput = By.id("address1");
    private By cityInput = By.id("city");
    private By stateDrp = By.id("id_state");
    private By zipCodeInput = By.id("postcode");
    private By phoneInput = By.id("phone_mobile");
    private By registerBtn = By.id("submitAccount");

    private Select date, month, year, state;



    RegistrationModel registrationModel = new RegistrationModel();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public RegistrationPage() {
        setLogger(RegistrationPage.class.getName());
    }

    public void signIn(){
        waitClick(Wait.VISIBLE, signInBtn, registrationModel.getSignIn());
    }

    public void setEmail(){
        waitSendkeys(Wait.VISIBLE, emailInput, registrationModel.getEmail(), "maksim.brzeczyszczykiewicz@wp.pl");
        waitClick(Wait.VISIBLE, createAccountBtn, registrationModel.getCreate());
    }

    public void completePersonalInformation(){
        waitClick(Wait.VISIBLE, titleRadioBtn, registrationModel.getTitle());
        waitSendkeys(Wait.VISIBLE, firstNameInput, registrationModel.getFirstName(), "Maks");
        waitSendkeys(Wait.VISIBLE, lastNameInput, registrationModel.getLastName(), "Brzeczyszczykiewicz");
        waitSendkeys(Wait.VISIBLE, passwordInput, registrationModel.getPassword(), "Cokolwiek");
        js.executeScript("window.scrollBy(0,500)");
        date = new Select(driver.findElement(dayDrp));
        date.selectByValue("2");
        month = new Select(driver.findElement(monthsDrp));
        month.selectByValue("3");
        year = new Select(driver.findElement(yearsDrp));
        year.selectByValue("2000");
    }

    public void completeAddress(){
        waitSendkeys(Wait.VISIBLE, addressInput, registrationModel.getAddress(), "Centar");
        waitSendkeys(Wait.VISIBLE, cityInput, registrationModel.getCity(), "Novi Sad");
        js.executeScript("window.scrollBy(0,500)");
        state = new Select(driver.findElement(stateDrp));
        state.selectByValue("7");
        waitSendkeys(Wait.VISIBLE, zipCodeInput, registrationModel.getZip(), "21000");
        waitSendkeys(Wait.VISIBLE, phoneInput, registrationModel.getPhone(), "066");
    }

    public void register() {
        waitClick(Wait.VISIBLE, registerBtn, registrationModel.getRegister());
    }
}
