import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by 1 on 17.04.2018.
 */
public class TestUI {
    private WebDriver driver;

    @Test
    public void testFormAndButtonIsDisplayed() {

        driver.get("https://diploma-courses.7bits.it/login");

        assertTrue(driver.findElement(By.name("login")).isDisplayed());
        assertTrue(driver.findElement(By.name("password")).isDisplayed());
        assertTrue(driver.findElement(By.className("login__button")).isDisplayed());
    }

    @Test
    public void testPositive() {
        driver.get("https://diploma-courses.7bits.it/login");

        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys("admin");

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin");

        assertTrue(driver.findElement(By.className("form-password-field__hide-show")).isDisplayed());
        driver.findElement(By.className("form-password-field__hide-show")).click();
        assertTrue(driver.findElement(By.className("form-password-field__hide-show form-password-field__hide-show_opened")).isDisplayed());

        driver.findElement(By.className("login__button")).click();

        boolean linkPersonal = isElementPresent(By.className("left-menu__user-box-name"));

        assertEquals(driver.findElement(By.className("left-menu__user-box-name")).getText(), "admin");
        driver.findElement(By.className("left-menu__user-box-logout-icon")).click();
        assertTrue(driver.findElement(By.className("login__button")).isDisplayed());
    }

    @Test
    public void testNegative() {
        driver.get("https://diploma-courses.7bits.it/login");

        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys("admin");

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("");

        driver.findElement(By.className("login__button")).click();

        assertTrue(driver.findElement(By.className("login__button")).isDisplayed());
    }


    }
