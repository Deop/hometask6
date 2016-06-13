package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.JobTest;

import java.util.List;


public class JobsPage {

    long tenSeconds = 10000;

    By searchField = By.xpath("//div[@class='bloko-control-group__main']/input[@data-qa='vacancy-serp__query']");
    By findButton = By.xpath("//form[@data-hh-tab-id='searchVacancy']//button[@data-qa='navi-search__button']");
    By searchResults = By.xpath("//div[@class='search-result']");
    //By resultHeader = By.xpath("//div[@class='search-result']//div[@class='search-result-item__head']/a[contains(translate(., 'СПЕЦИАЛИСТ ПО ТЕСТИРОВАНИЮ', 'специалист по тестированию'), 'специалист по Тестированию')]");

    String resultHeaderPattern = "//div[@class='search-result']//div[@class='search-result-item__head']/a[contains(translate(., '%s', '%s'), '%s')]";

    public void typeToSearchField(String query){
        JobTest.driver.findElement(searchField).sendKeys(query);
    }

    public void clickFindButton(){
        JobTest.driver.findElement(findButton).click();
    }

    public void waitForSearchResults(){
        WebDriverWait wait = new WebDriverWait(JobTest.driver, tenSeconds);
        wait.until(ExpectedConditions.visibilityOf(JobTest.driver.findElement(searchResults)));
    }

    public List<WebElement> getResultHeadersList(String query){
        String resultHeaderXpath = String.format(resultHeaderPattern, query.toUpperCase(), query.toLowerCase(), query.toLowerCase());
        return JobTest.driver.findElements(By.xpath(resultHeaderXpath));
    }

}
