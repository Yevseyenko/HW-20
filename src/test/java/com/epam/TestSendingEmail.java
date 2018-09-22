package com.epam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Test
public class TestSendingEmail {

    public void sendingLetter() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.ua");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement enterElement = driver.findElement(By.cssSelector("a.gb_we.gb_Aa.gb_Fb[target='_top']"));
        enterElement.click();
        WebElement userEmailInput = driver.findElement(By.xpath("//div/div/div/input"));
        userEmailInput.sendKeys("surfakeemail@gmail.com");
        WebElement nextEmailButton = driver.findElement(By.xpath("//div[@id='identifierNext']"));
        nextEmailButton.click();
        WebElement passwordInput = driver.findElement(By.cssSelector("input[name=\"password\"]"));
        passwordInput.sendKeys("Fake123456");
        WebElement nextPasswordButton = driver.findElement(By.xpath("//div[@id='passwordNext']"));
        nextPasswordButton.click();
        WebElement enterMailElement = driver.findElement(By.cssSelector("a[href=\"https://mail.google.com/mail/?tab=wm\"]"));
        enterMailElement.click();
        WebElement buttonWrite = driver.findElement(By.xpath("//*[@role='button'][@class='T-I J-J5-Ji T-I-KE L3']"));
        buttonWrite.click();
        WebElement receiver = driver.findElement(By.xpath("//textarea[@name='to']"));
        receiver.sendKeys("jevsejen@gmail.com");
        WebElement subject = driver.findElement(By.xpath("//input[@name='subjectbox']"));
        subject.sendKeys("Test email");
        WebElement emailText = driver.findElement(By.cssSelector("div.Am.Al.editable.LW-avf[role='textbox']"));
        emailText.sendKeys("Hello world!");
        WebElement sendButton = driver.findElement(By.cssSelector("div.T-I.J-J5-Ji.aoO.T-I-atl.L3[role='button']"));
        sendButton.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.findElement(By.cssSelector("span.bAq")).isDisplayed());
        driver.quit();
    }


}
