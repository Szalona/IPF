package autorisation;

import org.openqa.selenium.By;
import setup.BasePage;
import setup.Wait;

public class AutorisationPage extends BasePage {
    private By signInBtn = By.xpath("//div[@class='header_user_info']");
    private By emailInput = By.id("email");
    private By passwordInput = By.id("passwd");
    private By signInTwoBtn = By.id("SubmitLogin");

    AutorisationModel autorisationModel = new AutorisationModel();

    public AutorisationPage() {
        setLogger(AutorisationPage.class.getName());
    }

    public void signIn(){
        waitClick(Wait.VISIBLE, signInBtn, autorisationModel.getSignIn());
    }

    public void completeAuthForm(){
        waitSendkeys(Wait.VISIBLE, emailInput, autorisationModel.getEmail(), "maks.brzeczyszczykiewicz@wp.pl");
        waitSendkeys(Wait.VISIBLE, passwordInput, autorisationModel.getPassword(), "Cokolwiek");
        waitClick(Wait.VISIBLE, signInTwoBtn, autorisationModel.getSignIn());
    }
}
