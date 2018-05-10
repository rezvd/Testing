import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by 1 on 19.04.2018.
 */
public class LoginPage extends Page {
    @FindBy(className="login")
    public WebElement linkSignIn;

    @FindBy(id="username")
    WebElement fieldUsername;

    @FindBy(id="password")
    WebElement fieldPassword;

    @FindBy(name="login")
    WebElement buttonLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage loginAs(UserData user) {
        linkSignIn.click();
        type(fieldUsername, user.name);
        type(fieldPassword, user.password);
        buttonLogin.click();
        return PageFactory.initElements(driver, HomePage.class);
    }

    @Override
    public void open() {
        driver.get("login.url");
    }
}

