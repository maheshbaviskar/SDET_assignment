package test.java.com.training.SDET_Assignment.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Edit_Customer {

    public WebElement edit_Customer(WebDriver oDriver, String cust_id){
        oDriver.findElement(By.partialLinkText("Edit Customer")).click();
        WebElement wait6=new WebDriverWait(oDriver, 30L).until(ExpectedConditions.presenceOfElementLocated(By.className("barone")));
        oDriver.findElement(By.name("cusid")).sendKeys(cust_id);
        oDriver.findElement(By.name("AccSubmit")).click();

        WebElement wait8=new WebDriverWait(oDriver, 30L).until(ExpectedConditions.presenceOfElementLocated(By.className("barone")));
        oDriver.findElement(By.name("city")).clear();
        oDriver.findElement(By.name("city")).sendKeys("Pune city17");
        oDriver.findElement(By.name("sub")).click();
        wait8=new WebDriverWait(oDriver, 30L).until(ExpectedConditions.presenceOfElementLocated(By.className("barone")));
        try{
            WebElement iwait4=new WebDriverWait(oDriver,30L).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"customer\"]/tbody")));
        } catch (TimeoutException t)
        {
            System.out.println("Name");
            oDriver.get(oDriver.getCurrentUrl());
            System.out.println("Name");
        }

        WebElement iwait4=new WebDriverWait(oDriver,30L).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"customer\"]/tbody")));

        return iwait4;
    }
}
