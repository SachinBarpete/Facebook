package com.brifgrlabz.facebook.page;

import com.brifgrlabz.facebook.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BaseClass {

    @FindBy(xpath = "//span[contains(text(),'John Smith')]")
    WebElement userProfile;

    public Homepage() {

        PageFactory.initElements(driver, this);
    }

    public String verifyHomePagePageTitle() {
        return driver.getTitle();
    }

    public ProfilePage clickOnProfile() {
        userProfile.click();
        return new ProfilePage();
    }
}
