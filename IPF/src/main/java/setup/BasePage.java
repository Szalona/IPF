package setup;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class BasePage extends Base {

    public WebElement waitBy;

    public WebElement visible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public boolean invisible(By by) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public WebElement presence(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement clickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    private WebElement chooseWait(Wait wait, By by) {
        switch (wait) {
            case VISIBLE:
                waitBy = visible(by);
                break;
            case PRESENCE:
                waitBy = presence(by);
            case CLICKABLE:
                waitBy = clickable(by);
                break;
        }
        return waitBy;
    }

    public void waitClick(Wait wait, By by, String elementName) {
        chooseWait(wait, by).click();
        log.debug(String.format("'%s' button has been clicked", elementName));
    }

    public void waitSendkeys(Wait wait, By by, String elementName, String text) {
        chooseWait(wait, by).sendKeys(text);
        log.debug(String.format("'%s' input has been filled by '%s' data", elementName, text));
    }


    public void assertText(Wait wait, By by, Elements elements, String elementName, String expected) {
        String actual = null;
        switch (elements) {
            case TEXT:
                actual = chooseWait(wait, by).getText();
                break;
            case ATTRIBUTE:
                actual = chooseWait(wait, by).getAttribute("value");
                break;
        }
        Assert.assertEquals(expected, actual);
        log.info(String.format("'%s' appeared properly as '%s'", actual, elementName));
    }

}
