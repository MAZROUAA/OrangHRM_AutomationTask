package steps;

import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import tests.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;import data.LoadPropertiesFile;


public class AddingAndDeletingUsers extends TestBase {


    HomePage homeObj;
    LoginPage loginObj;

    AdminPage adminObj;
    static int numberOfRecords;

    String userRole= LoadPropertiesFile.userData.getProperty("userRole");
    String userStatus= LoadPropertiesFile.userData.getProperty("userStatus");
    String employeeName= LoadPropertiesFile.userData.getProperty("employeeName");
    String userName= LoadPropertiesFile.userData.getProperty("userName");
    String passWord= LoadPropertiesFile.userData.getProperty("passWord");

    String confirmPassword= LoadPropertiesFile.userData.getProperty("confirmPassword");


    @Given("the user in the login page")
    public void the_user_in_the_login_page() {
        loginObj=new LoginPage();

    }
    @When("the user Enter {string} and {string} in Log in Form and Click on the login button")
    public void the_user_enter_in_log_in_form_and_click_on_the_login_button(String username, String password) throws InterruptedException {
        loginObj.userLogin(username,password);
    }
    @When("the user Click on Admin tab on the left side menu")
    public void the_user_click_on_admin_tab_on_the_left_side_menu() {
        homeObj= new HomePage();
        homeObj.openAdminPage();

    }
    @Then("the user can Get the number of records")
    public void the_user_can_get_the_number_of_records() {
        adminObj =new AdminPage();
        numberOfRecords=adminObj.getNumberOfRecords();
        Assert.assertNotNull(numberOfRecords);

    }
    @When("the user add new user")
    public void the_user_add_new_user() throws InterruptedException {
        adminObj.addUser(userRole,userStatus,employeeName,userName,passWord,confirmPassword);
    }
    @Then("the number of records will increase by one and user will be found by search")
    public void the_number_of_records_will_increase_by_one_and_user_will_be_found_by_search() throws InterruptedException {
        int numberOfRecordsAfterUserAddition =adminObj.getNumberOfRecords();
        Assert.assertNotEquals(numberOfRecordsAfterUserAddition,numberOfRecords);

        adminObj.SearchForUserByUserName(userName);

        int numberOfRecordsAfterSearch =adminObj.getNumberOfRecords();
        Assert.assertEquals(numberOfRecordsAfterSearch,1);

        numberOfRecords=numberOfRecordsAfterUserAddition;

    }
    @When("the user Delete the new user")
    public void the_user_delete_the_new_user() {
        adminObj.DeleteUser();
    }
    @Then("the number of records will decrease by one")
    public void the_number_of_records_will_decrease_by_one() {
        homeObj.openAdminPage();

        int numberOfRecordsAfterUserDeletion =adminObj.getNumberOfRecords();

        Assert.assertEquals(numberOfRecordsAfterUserDeletion,numberOfRecords-1);

    }


}
