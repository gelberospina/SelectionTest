package SelectionTest.controller;

import SelectionTest.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertTrue;


public class BusinessController {

    private WebDriver driver;

    public BusinessController(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void validateResultPage() {
        try{
            assertTrue(driver.getTitle().contains("Google"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void verifyNamePage(SearchPage searchPage, String namePage) {
        try {
            assertTrue(searchPage.productTitle().contains(namePage));
        }catch (Exception e){
            System.out.println("Verify the name page failed" + e);
        }
    }
}
