package SauceDemoLogin;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Login {
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
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        driver.quit();


    }
}
Footer
© 2022 GitHub, Inc.
Footer navigation
Terms
Privacy
Security
Status
Docs
Contact GitHub
Pricing
API
Training
Blog
About
