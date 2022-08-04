package SauceDemoTests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartAndCheckout {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Camila\\OneDrive\\Escritorio\\InstallationProject\\Project\\SeleniumSauceDemoProject\\src\\main\\resources\\drivers\\chromedriver.exe");

        //Init the webdriver
        WebDriver driver = new ChromeDriver();

        // Open the website
        driver.get("https://saucedemo.com/");

        //Maximize the webbrowser
        driver.manage().window().maximize();

        //Credentials
        String username = "standard_user";
        String password = "secret_sauce";

        //Elements by ID
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        //Login
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();

// Perform the click operation that opens new window

// Switch to new window opened
        for(String winHandle1 : driver.getWindowHandles()){
            driver.switchTo().window(winHandle1);
        }
        WebElement backpackAddToCartButton = driver.findElement(By.cssSelector("button[name='add-to-cart-sauce-labs-backpack']"));
        WebElement bikeLightCartButton = driver.findElement(By.cssSelector("button[name='add-to-cart-sauce-labs-bike-light']"));
        //Add to Cart
        backpackAddToCartButton.click();
        bikeLightCartButton.click();
        WebElement shoppingCartLink = driver.findElement(By.cssSelector("a.shopping_cart_link"));
        shoppingCartLink.click();
        for(String winHandle2 : driver.getWindowHandles()){
            driver.switchTo().window(winHandle2);
        }
        WebElement checkoutLink = driver.findElement(By.id("checkout"));
        checkoutLink.click();
        for(String winHandle3 : driver.getWindowHandles()){
            driver.switchTo().window(winHandle3);
        }
        //Checkout Information
        String firstName = "Laura";
        String lastName = "Saucedo";
        String postalCode = "25100";

        //Elements by ID
        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        WebElement postalCodeInput = driver.findElement(By.id("postal-code"));
        WebElement continueButton = driver.findElement(By.id("continue"));

        //Fill checkout information
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);
        continueButton.click();

        for(String winHandle4 : driver.getWindowHandles()){
            driver.switchTo().window(winHandle4);
        }
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
        for(String winHandle5 : driver.getWindowHandles()){
            driver.switchTo().window(winHandle5);
        }
        Assert.assertEquals("https://www.saucedemo.com/checkout-complete.html", driver.getCurrentUrl());
        driver.quit();

    }
}



