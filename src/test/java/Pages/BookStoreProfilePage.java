package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookStoreProfilePage extends BaseTest {
    public BookStoreProfilePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "submit")
    public WebElement logOutButton;

    public void clickOnLogoutButton() {
        logOutButton.click();
    }

    @FindBy (id = "userName-value")
    public WebElement userNameValue;

    public String getUserName() {
        return userNameValue.getText();
    }
}
