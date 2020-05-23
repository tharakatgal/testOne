package tests;

import data.LoginData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.JasonReaderHelper;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class LoginTest {


    WebDriver driver;
    //Create Login Page object
    LoginPage objLoginPage;
    HomePage objHomePage;
    LoginData loginData;

    @BeforeTest
    public void setup() throws FileNotFoundException {
        loginData = JasonReaderHelper.getLoginData()[0];
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");
    }

    @Test(priority = 0)
    public void loginTest() {
        objLoginPage = new LoginPage(driver);
        objHomePage = new HomePage(driver);

        String loginPageTitle = objLoginPage.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains(loginData.getTitle()));
        objLoginPage.login(loginData.getUserName(), loginData.getPassword());
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains(loginData.getUserName()));
    }

    @AfterTest
    public void postCondition(){
        driver.quit();
    }
}
