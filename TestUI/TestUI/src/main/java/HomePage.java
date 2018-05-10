import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by 1 on 19.04.2018.
 */
public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isLoggedIn(){
        return (driver.findElement(By.className("left-menu__user-box-name")).getText().equals("admin"));
    }

    public void logout(){
        driver.findElement(By.className("left-menu__user-box-logout-icon")).click();
    }

    public boolean isLoggedOut(){
        return driver.findElement(By.className("login__button")).isDisplayed();
    }

}

