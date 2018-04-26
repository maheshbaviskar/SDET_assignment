package test.java.com.training.SDET_Assignment.TestCases;

import org.openqa.selenium.TimeoutException;
import test.java.com.training.SDET_Assignment.WebPages.Excel_Readandwrite;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class Create_Account {
    public WebElement create_Account(WebDriver oDriver, Excel_Readandwrite exc, String cust_id) throws IOException, InvalidFormatException {

        oDriver.findElement(By.partialLinkText("New Account")).click();
        WebElement wait5=new WebDriverWait(oDriver, 30L).until(ExpectedConditions.presenceOfElementLocated(By.className("barone")));


        oDriver.findElement(By.name("cusid")).sendKeys(cust_id);
        //System.out.println("Amount is "+ exc.hashRead("Amount"));
        oDriver.findElement(By.name("inideposit")).sendKeys(exc.hashRead("Amount"));;
        oDriver.findElement(By.name("button2")).click();
        WebElement wait7=new WebDriverWait(oDriver, 30L).until(ExpectedConditions.presenceOfElementLocated(By.className("barone")));
        try{

            wait7=new WebDriverWait(oDriver,30L).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"account\"]/tbody")));
        } catch (TimeoutException t)
        {
            oDriver.get(oDriver.getCurrentUrl());
            System.out.println("Name");
        }
        wait7=new WebDriverWait(oDriver,30L).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"account\"]/tbody")));

        return wait7;
    }
}