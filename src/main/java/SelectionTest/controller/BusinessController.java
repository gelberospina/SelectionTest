package SelectionTest.controller;

import SelectionTest.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class BusinessController {

    private WebDriver driver;

    public BusinessController(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean validateResultPage() {
        try{
            return driver.getTitle().contains("Google");
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean verifySuggestionsList(SearchPage searchPage) {
        try{
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return searchPage.listSuggestions.isEnabled();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
