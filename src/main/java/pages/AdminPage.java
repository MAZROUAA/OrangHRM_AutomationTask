package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.support.ui.Select;
import utilityHelper.Helper;

import static org.asynchttpclient.util.Assertions.assertNotNull;

public class AdminPage extends PageBase{
    String NumberOfRecords;



    public int getNumberOfRecords() {
        By NumberOfRecordsElementSelector=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span");

        WebElement NumberOfRecordsElement =Helper.waitUntil(NumberOfRecordsElementSelector, Helper.ExpectedConditionsEnum.presenceOfElement);
        setImplicitWait(2);
        NumberOfRecords=NumberOfRecordsElement.getText();

        String Records = NumberOfRecords.replaceAll("[^0-9]", "");

        System.out.println(Records);



        int number = Integer.parseInt(Records);
        return number;
    }

    public void addUser(String UserRole, String UserStatus, String EmployeeName,String UserName, String Password, String ConfirmPassword) throws InterruptedException {
        By AddButtonSelector=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
        By UserRoleDroplistSelector=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]");
        By UserRoleOptionSelector=By.xpath("//div[@role='option']//span[text()='" + UserRole + "']");
        By UserStatusDroplistSelector=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i");
        By UserStatusDroplistOptionSelector=By.xpath("//div[@role='option']//span[text()='" + UserStatus + "']");
        By EmployeeNameSelectror=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input");
        By EmployeeNameOptionSelector=By.xpath("//div[@role='option']//span[text()='" + EmployeeName + "']");

        By UserNameSelector=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
        By PasswordSelector=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
        By ConfirmPasswordSelector=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
        By SaveButtonSelector=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");


        //Click on Add button
        WebElement AddButton = Helper.waitUntil(AddButtonSelector, Helper.ExpectedConditionsEnum.presenceOfElement);
        clickOnElement(AddButton);


        //Choose User Role
        WebElement UserRoleDroplist = Helper.waitUntil(UserRoleDroplistSelector, Helper.ExpectedConditionsEnum.presenceOfElement);
        UserRoleDroplist.click();

        WebElement UserRoleOption = Helper.waitUntil(UserRoleOptionSelector, Helper.ExpectedConditionsEnum.presenceOfElement);
        UserRoleOption.click();

        Thread.sleep(2000);



        //Choose User Status
        WebElement UserStatusDroplist = Helper.waitUntil(UserStatusDroplistSelector, Helper.ExpectedConditionsEnum.presenceOfElement);
        UserStatusDroplist.click();

        WebElement UserStatusDroplistOption = Helper.waitUntil(UserStatusDroplistOptionSelector, Helper.ExpectedConditionsEnum.presenceOfElement);
        UserStatusDroplistOption.click();

        //Write Employee Name
        WebElement EmployeenameTextBox = driver.findElement(EmployeeNameSelectror);
        setTextElement(EmployeenameTextBox,EmployeeName.substring(0, 2));

        WebElement EmployeeNameOption = Helper.waitUntil(EmployeeNameOptionSelector, Helper.ExpectedConditionsEnum.presenceOfElement);
        EmployeeNameOption.click();

        //Write username
        WebElement UsernameTextBox = driver.findElement(UserNameSelector);
        setTextElement(UsernameTextBox,UserName);

        //Write password
        WebElement PasswordTextBox = driver.findElement(PasswordSelector);
        setTextElement(PasswordTextBox,Password);

        //Write confirm password
        WebElement ConfirmPasswordTextBox = driver.findElement(ConfirmPasswordSelector);
        setTextElement(ConfirmPasswordTextBox,ConfirmPassword);

        Thread.sleep(2000);

        //Click on save button
        WebElement SaveButton = driver.findElement(SaveButtonSelector);
        clickOnElement(SaveButton);
        Thread.sleep(6000);

    }


    public void SearchForUserByUserName(String UserName) throws InterruptedException {

        By UserNameSelector=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
        By SearchButtonSelector=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");


        //Write username
        WebElement UsernameTextBox = driver.findElement(UserNameSelector);
        setTextElement(UsernameTextBox,UserName);


        //Click on search button
        WebElement SearchButton = driver.findElement(SearchButtonSelector);
        clickOnElement(SearchButton);

        Thread.sleep(6000);

    }

    public void DeleteUser() {

        By DeleteIconSelector=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[6]/div/button[1]");
        By YesDeleteButtonSelector=By.xpath("/html/body/div/div[3]/div/div/div/div[3]/button[2]");


        //Click on delete icon
        WebElement DeleteICon = driver.findElement(DeleteIconSelector);
        clickOnElement(DeleteICon);

        //Click on yes delete button
        WebElement YesDeleteButton = Helper.waitUntil(YesDeleteButtonSelector, Helper.ExpectedConditionsEnum.presenceOfElement);
        clickOnElement(YesDeleteButton);

    }
}
