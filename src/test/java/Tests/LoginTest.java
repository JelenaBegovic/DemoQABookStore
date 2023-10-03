package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/");
    }

    @Test
    public void verifyThatUserCanLogin() {
        homePage.openCard("Book Store Application");
        bookStore.clickOnLoginButton();
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(bookStoreProfilePage.logOutButton.isDisplayed());
        Assert.assertEquals(bookStoreProfilePage.getUserName(), validUsername);
    }

    @Test
    public void verifyThatUserCannotLogin() {
        homePage.openCard("Book Store Application");
        bookStore.clickOnLoginButton();
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 2);
            String invalidPassword = excelReader.getStringData("Login", i, 3);
            loginPage.inputUsername(invalidUsername);
            loginPage.inputPassword(invalidPassword);
            loginPage.clickOnLoginButton();
            Assert.assertTrue(loginPage.message.isDisplayed());
        }
    }

}
