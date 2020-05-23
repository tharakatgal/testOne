package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By user99GuruName = By.name("uid");
    By password99Guru = By.name("password");
    By titleText = By.className("barone");
    By login = By.name("btnLogin");

    public void setUserName(String strUserName) {
        driver.findElement(user99GuruName).sendKeys(strUserName);
    }

    public void setPassword(String strPassword) {
        driver.findElement(password99Guru).sendKeys(strPassword);
    }

    public void clickLogin() {
        driver.findElement(login).click();
    }

    public String getLoginTitle() { return driver.findElement(titleText).getText(); }

    public void login(String strUserName, String strPasword) {
        this.setUserName(strUserName);
        this.setPassword(strPasword);
        this.clickLogin();
    }

}
