package test.java.com.training.SDET_Assignment.TestCases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class Generate_Loginpassword_Test {

    public WebElement generate_Loginpassword(WebDriver oDriver, String emailId) throws IOException, InvalidFormatException {

        oDriver.get("http://demo.guru99.com/");
        System.out.println(oDriver.getTitle());

        WebElement email=oDriver.findElement(By.name("emailid"));

        email.sendKeys(emailId);
        oDriver.findElement(By.name("btnLogin")).click();
        WebDriverWait wb= new WebDriverWait(oDriver,60L);
        try {

            WebElement wait1 = wb.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/table/tbody")));
        } catch (TimeoutException t)
        {
            System.out.println("Name");
            oDriver.get(oDriver.getCurrentUrl());

        }
        WebElement wait1 = wb.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/table/tbody")));

        return wait1;
    }
}
