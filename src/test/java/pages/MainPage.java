package pages;

import org.openqa.selenium.By;
import tests.JobTest;

public class MainPage {

    String navMenuElementPattern = "//ul[@class='b-topbar-i']/li/a[@title='%s']";

    public void navigateToMenu(String name){
        String menuElementXpath = String.format(navMenuElementPattern, name);
        JobTest.driver.findElement(By.xpath(menuElementXpath)).click();
    }

}
