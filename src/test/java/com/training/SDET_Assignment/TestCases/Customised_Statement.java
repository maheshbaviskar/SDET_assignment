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

public class Customised_Statement {

    public WebElement customised_Statement(WebDriver oDriver, Excel_Readandwrite exc) throws IOException, InvalidFormatException {

        oDriver.findElement(By.partialLinkText("Customised Statement")).click();
        WebElement wait8=new WebDriverWait(oDriver, 30L).until(ExpectedConditions.presenceOfElementLocated(By.className("barone")));
        oDriver.findElement(By.name("accountno")).sendKeys(exc.readAccount());
        oDriver.findElement(By.name("fdate")).sendKeys("01/01/1991");
        oDriver.findElement(By.name("tdate")).sendKeys("15/04/2018");
        oDriver.findElement(By.name("AccSubmit")).click();
        wait8=new WebDriverWait(oDriver, 30L).until(ExpectedConditions.presenceOfElementLocated(By.className("barone")));

        try{
            WebElement iwait4=new WebDriverWait(oDriver,30L).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"customstmt\"]/tbody")));
        } catch (TimeoutException t)
        {
            System.out.println("Name");
            oDriver.get(oDriver.getCurrentUrl());
        }
        WebElement iwait4=new WebDriverWait(oDriver,30L).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"customstmt\"]/tbody")));
        return iwait4;
    }
}
