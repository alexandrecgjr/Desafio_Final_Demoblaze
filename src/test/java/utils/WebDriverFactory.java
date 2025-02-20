package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().browserVersion("133.0.6943.126").setup();



        return new ChromeDriver();
    }
}
