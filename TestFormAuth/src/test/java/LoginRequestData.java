/**
 * Created by 1 on 17.04.2018.
 */
public class LoginRequestData {

    private String login;
    private String password;

    public LoginRequestData(String login, String password) {
        this.login = login;
        this.password = password;
    }


    @Override
    public String toString() {
        return "LoginRequestData{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
