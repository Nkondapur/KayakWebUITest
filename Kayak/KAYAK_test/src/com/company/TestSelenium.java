package com.company;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestSelenium {
    public static void main(String[] args) throws InterruptedException {
        //Set the drivers
        System.setProperty("webdriver.gecko.driver","C:\\Users\\prash\\Automation\\Kayak\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\prash\\Automation\\Kayak\\chromedriver.exe");
        System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        WebDriver driver=new ChromeDriver();

        String baseUrl = "https://www.kayak.ch";
        //getting the url
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
       //Dismiss accept cookies popup
       driver.findElement(By.xpath("//*[text()='Nein, danke']")).click();
       driver.findElement(By.xpath("(//div[@class='XaZ4-icon '])[1]")).click();

       // driver.findElement(By.xpath("//div[contains(@class,\"vvTc-mod-ellipsis\")]")).clear();
        driver.findElement(By.xpath("(//div[contains(@class,\"vvTc-mod-variant-default\")]//div[@class=\"vvTc-item-close\"])[2]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Von?']")).sendKeys("Zurich");
        driver.findElement(By.xpath("//span[@class=\"JyN0-name\"]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//div[@class='XaZ4-icon '])[3]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Nach?']")).sendKeys("Basel");
        driver.findElement(By.xpath("//span[@class=\"JyN0-name\"]")).click();
        driver.findElement(By.xpath("//button[contains(@class,'Iqt3-mod-animation-search')]")).click();

        //Scroll to an element and select Max price as 1600 CHF
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//h3[text()=\"Dauer\"]")));

        driver.findElement(By.xpath("//h3[text()=\"Preis\"]/../div")).click();
        Thread.sleep(5000);

       // js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//div[contains(@id,\"price-price-slider-sliderWidget-handle-0\")]"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(element,-60,0).build().perform();
    }
}

