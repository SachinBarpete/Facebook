package com.bridgelabz.facebook.page;

import com.brifgrlabz.facebook.base.BaseClass;
import com.brifgrlabz.facebook.page.Homepage;
import com.brifgrlabz.facebook.page.LoginPage;
import com.brifgrlabz.facebook.utility.UtilityClass;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseClass {

    LoginPage loginPage;
    Homepage homepage;
    String sheetName = "Login";
    Logger logger;

    public LoginPageTest() {
        super();
        logger = Logger.getLogger(LoginPageTest.class.getName());
    }

    @BeforeMethod
    public void setUp() {
        initialization();

    }

    @Test(priority = 2)
    public Homepage loginTest() {

        logger.info("login start...");
        loginPage = new LoginPage();
        homepage = loginPage.login("81234", "123456");
        return homepage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }

    @DataProvider
    public Object[][] getLoginTestdata() {
        return UtilityClass.getTestData(sheetName);
    }

    @Test(priority = 1, dataProvider = "getLoginTestdata")
    public void loginTest(String username, String password) {

        logger.warn("warning");
        System.out.println("LoginTest Started against" + username + ",&" + password);

        loginPage = new LoginPage();
        homepage = loginPage.login(username, password);

        System.out.println("loginTest ended");
    }

    /*
    @Test(priority = 3)
    public void forgottPasswordTest() {
        forgottPasswordPage = loginPage.forgottPassword();
    }*/

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
