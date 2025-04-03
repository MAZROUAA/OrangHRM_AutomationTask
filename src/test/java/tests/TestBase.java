package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.PageBase;

public class TestBase extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void startDriver( ) {
        PageBase.startDriver();



    }

    @AfterMethod
    public void stopdriver()  {
        PageBase.stopdriver();

    }

}
