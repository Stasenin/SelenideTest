package selenide.test;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GoogleTest extends ExternalResource{

    @Before
    public void BrowserStrategy() {
        // можно задать драйвер и закоментированым кодом,  смесь селениума с селенидом=/
        System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
        System.setProperty("selenide.browser","firefox"); // firefox, chrome,htmlunit,opera,ie,phantomjs.
//        WebDriver driver = new FirefoxDriver();
//        WebDriverRunner.setWebDriver(driver); // это строка возвращает селениду настройки нашего драйвера.
    }

    @Rule
    public ScreenShooter photographer = ScreenShooter.failedTests().succeededTests(); // делает скриншот успешного теста

    @Test
    public void search_selenide_in_google() {

        open("https://www.google.com.ua/");
        $(By.name("q")).setValue("Somethig").pressEnter();
        $$("[class=\"rc\"]").shouldHave(CollectionCondition.size(8));//проверяет что выдает 10 елементов q. (10 результатов поиска)
        $("[class=\"rc\"]").shouldHave(text("Something"));



    }
}
