package utilityHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static pages.PageBase.driver;

public class Helper {




    public static WebElement waitUntil(By b, ExpectedConditionsEnum condition) {
        Duration TimeOut=Duration.ofSeconds(10);
        try {
            WebElement element = null;
            switch (condition) {
                case presenceOfElement:

                    element = (new WebDriverWait(driver,TimeOut)).until(ExpectedConditions.presenceOfElementLocated(b));
                    return element;

                case ElementToBeClickable:
                    element = (new WebDriverWait(driver, TimeOut)).until(ExpectedConditions.elementToBeClickable(b));
                    return element;


                default:
                    element = null;

            }
            return element ;
        } catch (Exception e) {
            //Assert.fail("Couldn't find the element because of " + e.getMessage());
            return null;
        }
    }


    public enum ExpectedConditionsEnum{
        presenceOfElement,
        ElementToBeClickable
    }
}
