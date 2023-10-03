package Base;

import Pages.BookStore;
import Pages.BookStoreProfilePage;
import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public BookStore bookStore;
    public LoginPage loginPage;
    public ExcelReader excelReader;
    public BookStoreProfilePage bookStoreProfilePage;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        homePage = new HomePage();
        bookStore = new BookStore();
        loginPage = new LoginPage();
        excelReader = new ExcelReader("src/test/java/TestData.xlsx");
        bookStoreProfilePage = new BookStoreProfilePage();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
