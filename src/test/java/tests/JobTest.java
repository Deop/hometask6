package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.JobsPage;
import pages.MainPage;

public class JobTest {

    public static WebDriver driver;
    MainPage mainPage = new MainPage();
    JobsPage jobsPage = new JobsPage();

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * Проверяет количество записей на странице результата поиска, соответсвующих заданому запросу.
     * Соответствие проверяется по критерию содержания текста запроса в заголовке результата.
     *
     * @param menuName Название элемента меню
     * @param query Текст запроса
     */
    @Test(dataProvider = "query")
    public void calculateResultsTest(String menuName, String query){
        driver.navigate().to("http://www.tut.by");
        mainPage.navigateToMenu(menuName);
        jobsPage.typeToSearchField(query);
        jobsPage.clickFindButton();

        Assert.assertTrue(jobsPage.getResultHeadersList().size() > 0, "There are not results matching query");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @DataProvider(name = "query")
    public static Object[][] query() {
        return new Object[][] {{ "Работа", "специалист по тестированию" }};
    }

}
