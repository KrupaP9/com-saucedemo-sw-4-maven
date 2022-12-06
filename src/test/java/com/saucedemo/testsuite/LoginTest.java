package com.saucedemo.testsuite;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsHomePage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    ProductsHomePage productsHomePage = new ProductsHomePage();

    //method to login with successful credentials
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //enter username
        loginPage.sendTextToUsernameField("standard_user");
        //enter password
        loginPage.sendTextToPasswordField("secret_sauce");
        //login
        loginPage.clickOnLoginButton();
        String expectedProductsText = "PRODUCTS";
        String actualProductsText = productsHomePage.getProductsText();
        //verify whether products text is displayed
        Assert.assertEquals(actualProductsText, expectedProductsText, "Products text not displayed");
    }

    //method to verify six products are displayed per page
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //enter username
        loginPage.sendTextToUsernameField("standard_user");
        loginPage.sendTextToPasswordField("secret_sauce");
        //click login
        loginPage.clickOnLoginButton();
        int expectedProductsPerPage = 6;
        int actualProductsPerPage = productsHomePage.getProductsNum();
        //verify whether 6 products displayed per page
        Assert.assertEquals(expectedProductsPerPage, actualProductsPerPage, "Products per page is not 6");
    }
}
