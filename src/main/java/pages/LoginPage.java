package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase {

    public void userLogin(String UserName, String Password) throws InterruptedException {
        WebElement LoginUsernameTextBox = driver.findElement(By.name("username"));
        WebElement LoginPasswordTextBox = driver.findElement(By.name("password"));
        WebElement LoginButton = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));

        setTextElement(LoginUsernameTextBox, UserName);
        setTextElement(LoginPasswordTextBox, Password);
        Thread.sleep(2000);
        clickOnElement(LoginButton);
    }

}
