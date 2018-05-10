import io.restassured.RestAssured;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.restassured.RestAssured.preemptive;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by 1 on 19.04.2018.
 */
public class NegativeTest {

    static private WebDriver driver;

    public final static UserData user = new UserData("admin", "adminadmin");
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
        assertFalse(homePage.isLoggedIn());
    }

    @AfterClass
    static public void tearDown() throws Exception {
        driver.quit();
    }
}

