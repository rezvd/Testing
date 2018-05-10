import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.junit.Assert.assertTrue;

/**
 * Created by 1 on 17.04.2018.
 */
public class PositiveTest {
    static private WebDriver driver;

    public final static UserData user = new UserData("admin", "admin");
    LoginPage loginPage;

    @BeforeClass
    public static void setUp() {
        System.setProperty( "webdriver.chrome.driver", "drivers/chromedriver" );
        driver = new ChromeDriver();
        driver.get("https://admin:admin123@diploma-courses.7bits.it/");
    }

    @Before
    public void preparing(){
        driver.get("https://diploma-courses.7bits.it/login");
    }

    @Test
    public void testFormAndButtonIsDisplayed() {

        driver.get("https://diploma-courses.7bits.it/login");
        assertTrue(loginPage.isElementPresent(driver.findElement(By.name("login"))));
        assertTrue(loginPage.isElementPresent(driver.findElement(By.name("password"))));
        assertTrue(loginPage.isElementPresent(driver.findElement(By.name("login__button"))));
    }

    @Test
    public void testPositive() {
        loginPage = new LoginPage(driver);
        loginPage.open();
        HomePage homePage;
        homePage = loginPage.loginAs(user);
        assertTrue(homePage.isLoggedIn());
        homePage.logout();
        assertTrue(homePage.isLoggedOut());

    }

    @AfterClass
    static public void tearDown() throws Exception {
        driver.quit();
    }
}
