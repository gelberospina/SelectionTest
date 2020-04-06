package SelectionTest.steps;

import SelectionTest.controller.BusinessController;
import SelectionTest.pages.SearchPage;
import SelectionTest.utils.Constants;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.MalformedURLException;
import static junit.framework.Assert.assertTrue;

public class StepDefinitions {

    public static WebDriver driver;
    private final String STEPSUCCESSFUL ="Successful step: ";
    private final String STEPFAILED="Failed step: ";

    @Before
    public void setUp() throws MalformedURLException
    {
        WebDriverManager.chromedriver().version("80.0.3987.16").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown()
    {
        driver.close();
    }


    @Given("^I am on the homepage$")
    public void i_am_on_the_homepage(){
        driver.get(Constants.URLSEARCH);
    }

    @When("^I type \"([^\"]*)\" into the search field$")
    public void i_type_into_the_search_field(String infoSearched){
        try{
            SearchPage searchPage = new SearchPage(driver);
            searchPage.typeInputSearch(infoSearched);
            System.out.println(STEPSUCCESSFUL + " I type into the search field");
        }catch(Exception e){
            System.out.println(STEPFAILED + " I type into the search field");
            e.printStackTrace();
        }
        
    }

    @And("^I click google search buttom$")
    public void i_click_google_search_buttom(){
        try{
            SearchPage searchPage = new SearchPage(driver);
            searchPage.clickButtonSearch();
            System.out.println(STEPSUCCESSFUL + " I click google search buttom");
        }catch(Exception e){
            System.out.println(STEPFAILED + " I click google search buttom");
            e.printStackTrace();
        }
        
    }

    @And("^I click on the first suggestion in the list$")
    public void i_click_on_the_first_suggestion_in_the_list(){
        try{
            SearchPage searchPage = new SearchPage(driver);
            searchPage.clickTextSuggestions();
            System.out.println(STEPSUCCESSFUL + " I click on the first suggestion in the list");
        }catch(Exception e){
            System.out.println(STEPFAILED + " I click on the first suggestion in the list");
            e.printStackTrace();
        }
    }



    @Then("^I go to search results page$")
    public void i_go_to_search_results_page(){
        try{
            BusinessController businessController = new BusinessController(driver);
            businessController.validateResultPage();
            System.out.println(STEPSUCCESSFUL + " I verify go to result page");
        }catch(Exception e){
            System.out.println(STEPFAILED + " I verify go to result page");
            e.printStackTrace();
        }
        
    }

    @And("^I verify the first result$")
    public void i_verify_the_first_result(){
        try{
            SearchPage searchPage = new SearchPage(driver);
            System.out.println(searchPage.textFirstResult());
            System.out.println(STEPSUCCESSFUL + " I verify the first result");
        }catch(Exception e){
            System.out.println(STEPFAILED + " I verify the first result");
            e.printStackTrace();
        }
    }

    @When ("^I click the first result link$")
    public void i_click_the_first_result_link(){
        try{
            SearchPage searchPage = new SearchPage(driver);
            searchPage.clickFirstResult();
            System.out.println(STEPSUCCESSFUL + " I click the first result link");
        }catch(Exception e){
            System.out.println(STEPFAILED + " I click the first result link");
            e.printStackTrace();
        }
    }

    @Then ("^I go to the \"([^\"]*)\" page$")
    public void i_go_to_the_page(String namePage){
        try {
            assertTrue(driver.getTitle().contains(namePage));
            System.out.println(STEPSUCCESSFUL + " I go to the "+"namePage"+" page");
        }catch (Exception e){
            System.out.println(STEPFAILED + " I go to the "+"namePage"+" page");
            e.printStackTrace();
        }

    }

}
