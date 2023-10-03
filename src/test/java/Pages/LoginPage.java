package Pages;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "userName")
    public WebElement usernameField;

    public void inputUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    @FindBy (id = "password")
    public WebElement passwordField;

    public void inputPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @FindBy (id = "login")
    public WebElement loginButton;

    public void clickOnLoginButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginButton);
        loginButton.click();
    }

    @FindBy (className = "mb-1")
    public WebElement message;

}
