package com.brifgrlabz.facebook.page;

import com.brifgrlabz.facebook.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class LoginPage extends BaseClass {
    Logger logger;

    // declaration
    @FindBy(id = "email")
    WebElement username;

    @FindBy(xpath = "//input[@id='pass']")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginButton;

    // initialization
    public LoginPage() {
        PageFactory.initElements(driver,this);
        logger = Logger.getLogger(LoginPage.class.getName());
    }


    public String verifyPageTitle() {
        return driver.getTitle();
    }

    public Homepage login(String username, String password) {
        logger.info("login.....");
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        loginButton.click();
        return new Homepage();
    }

}
