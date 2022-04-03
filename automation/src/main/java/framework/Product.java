package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Product {
    WebDriver driver;

    public void launch(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8000/");
    }

    public WebDriver driver(){
        return driver;
    }

    public WebElement findElement(By pBy){
        return driver.findElement(pBy);
    }

    public void close(){
        driver.close();
    }
}
