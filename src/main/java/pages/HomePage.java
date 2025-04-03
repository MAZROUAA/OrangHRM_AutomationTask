package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends PageBase{

    public void openAdminPage() {
        WebElement AdminLink = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span"));
        clickOnElement(AdminLink);
    }

}
