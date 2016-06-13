package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.JobTest;

import java.util.List;


public class JobsPage {

    By searchField = By.xpath("//div[@class='bloko-control-group__main']/input[@data-qa='vacancy-serp__query']");
    By findButton = By.xpath("//form[@data-hh-tab-id='searchVacancy']//button[@data-qa='navi-search__button']");
    By resultHeader = By.xpath("//div[@class='search-result']//div[@class='search-result-item__head']/a[contains(translate(., 'СПЕЦИАЛИСТ ПО ТЕСТИРОВАНИЮ', 'специалист по тестированию'), 'специалист по тестированию')]");

    public void typeToSearchField(String query){
        JobTest.driver.findElement(searchField).sendKeys(query);
    }

    public void clickFindButton(){
        JobTest.driver.findElement(findButton).click();
    }

    public List<WebElement> getResultHeadersList(){
        return JobTest.driver.findElements(resultHeader);
    }

}
