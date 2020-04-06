package SelectionTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SearchPage {

    private WebDriver driver;

    @FindBy (xpath = "//input[@class='gLFyf gsfi']")
    private WebElement inputSearch;

    @FindBy (xpath = "(//ul[@class='erkvQe']//div[@class='sbtc']//span)[1]")
    private WebElement textSuggestions;

    @FindBy (xpath = "//input[@class='gNO89b']")
    private WebElement buttonSearch;


    @FindBy (xpath = "//button[@class=' a-button-close a-declarative']")
    private WebElement buttonPopUp;

    @FindBy (xpath = "//div[@class='g'][2]/div[@class='rc']/div[@class='r']/a/h3")
    private WebElement firstResult;

    @FindBy (id = "firstHeading")
    private WebElement labelTittle;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeInputSearch(String textInput)
    {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        inputSearch.sendKeys(textInput);
    }

    public void clickTextSuggestions(){
        textSuggestions.click();
    }

    public void clickButtonSearch(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        buttonSearch.click();
    }

    public String textFirstResult(){
        return firstResult.getText();
    }

    public void clickFirstResult(){
        firstResult.click();
    }

    public void closePopUp(){
        buttonPopUp.click();
    }

    public String productTitle(){
        return labelTittle.getText();
    }

}
