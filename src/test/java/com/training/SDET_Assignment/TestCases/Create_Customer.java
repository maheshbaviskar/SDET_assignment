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

public class Create_Customer {
    public WebElement create_Customer(WebDriver oDriver, String username, String password, Excel_Readandwrite exc) throws IOException, InvalidFormatException {

        oDriver.get("http://demo.guru99.com/V4/index.php");
        oDriver.findElement(By.name("uid")).sendKeys(username);
        oDriver.findElement(By.name("password")).sendKeys(password);;
        oDriver.findElement(By.name("btnLogin")).click();
        WebElement wait2=new WebDriverWait(oDriver,30L).until(ExpectedConditions.presenceOfElementLocated(By.className("barone")));
        oDriver.findElement(By.partialLinkText("New Customer")).click();
        WebElement wait3=new WebDriverWait(oDriver, 60L).until(ExpectedConditions.presenceOfElementLocated(By.className("barone")));
        oDriver.findElement(By.name("name")).sendKeys(exc.hashRead("Name"));
        oDriver.findElement(By.name("dob")).sendKeys(exc.hashRead("DOB"));
        oDriver.findElement(By.name("addr")).sendKeys(exc.hashRead("Address"));
        oDriver.findElement(By.name("city")).sendKeys(exc.hashRead("City"));
        oDriver.findElement(By.name("state")).sendKeys(exc.hashRead("State"));
        oDriver.findElement(By.name("pinno")).sendKeys(exc.hashRead("Pin"));
        oDriver.findElement(By.name("telephoneno")).sendKeys(exc.hashRead("Telephone"));
        oDriver.findElement(By.name("emailid")).sendKeys(exc.hashRead("Email_id"));
        oDriver.findElement(By.name("password")).sendKeys(exc.hashRead("Password"));
        oDriver.findElement(By.name("sub")).click();

        try
        {
            WebElement wait4=new WebDriverWait(oDriver,30L).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"customer\"]/tbody")));
        } catch (TimeoutException t)
        {
            oDriver.get(oDriver.getCurrentUrl());
            System.out.println("Name");
        }
        WebElement wait4=new WebDriverWait(oDriver,30L).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"customer\"]/tbody")));


        return wait4;
    }
}
