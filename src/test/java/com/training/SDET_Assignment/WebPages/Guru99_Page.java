package test.java.com.training.SDET_Assignment.WebPages;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.com.training.SDET_Assignment.TestCases.Create_Customer;
import test.java.com.training.SDET_Assignment.TestCases.*;
import test.java.com.training.SDET_Assignment.TestCases.Generate_Loginpassword_Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Guru99_Page {

    ExtentReports extent;
    ExtentTest logger;
    WebDriver oDriver = null;
    Workbook workook = new XSSFWorkbook();
    Excel_Readandwrite exc= new Excel_Readandwrite();
    String cust_id= null, account_id=null;
    Guru99_Page g9=null;

    @Parameters({ "browser" })
    @BeforeTest
    public void automationSetup(String browser) throws Exception{

        extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
        extent
                .addSystemInfo("Host Name", "SoftwareTestingMaterial")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Mahesh Baviskar");
        //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
        //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
        System.out.println("preset check completed1");
        oDriver=CommonLib.getDriver(browser);
        //oDriver.get(sUrl);
        Thread.sleep(15000);


    }

    @Test
    public void generate_Login_password() throws IOException, InvalidFormatException {
        String emailId = exc.readEmail();
        Generate_Loginpassword_Test glp= new Generate_Loginpassword_Test();
        WebElement wait1=glp.generate_Loginpassword(oDriver, emailId);
        g9=new Guru99_Page();
        g9.excel_handle_logic("LoginDetails",wait1,oDriver, workook);
        logger = extent.startTest("Generate_Login_password");
        logger.log(LogStatus.PASS, "Test Case generate_Login_password is passTest");
        extent.endTest(logger);
    }

    @Test(dependsOnMethods = "generate_Login_password")
    public void create_Customer() throws  IOException, InvalidFormatException{
        String username=exc.readUserName();
        String password =exc.readPassword();
        Create_Customer cc= new Create_Customer();
        WebElement  wait4 = cc.create_Customer(oDriver, username, password, exc);
        g9.excel_handle_logic("CustomerDeatils",wait4,oDriver, workook);
        logger = extent.startTest("create_Customer");
        logger.log(LogStatus.PASS, "Test Case create_Customer is passTest");
        extent.endTest(logger);



    }

    @Test(dependsOnMethods = "create_Customer")
    public void create_Account() throws IOException, InvalidFormatException{

        String cust_id =exc.readCustomer();
        Create_Account ca = new Create_Account();
        WebElement wait7=ca.create_Account(oDriver, exc, cust_id);
        g9.excel_handle_logic("AccountDetails",wait7,oDriver, workook);
        logger = extent.startTest("create_Account");
        logger.log(LogStatus.PASS, "Test Case create_Account is passTest");
        extent.endTest(logger);


    }

    @Test(dependsOnMethods = "create_Account")
    public void edit_Customer() throws IOException, InvalidFormatException{
        String cust_id=exc.readCustomer();
        Edit_Customer ec= new Edit_Customer();
        WebElement iwait4=ec.edit_Customer(oDriver, cust_id);

        g9.excel_handle_logic("Edited_customer",iwait4,oDriver, workook);
        logger = extent.startTest("Edit_Customer");
        logger.log(LogStatus.PASS, "Test Case Edit_Customer is passTest");
        extent.endTest(logger);

    }

    @Test(dependsOnMethods = "edit_Customer")
    public void customised_Statement() throws IOException, InvalidFormatException{
        Customised_Statement cs= new Customised_Statement();
        cs.customised_Statement(oDriver, exc);

        logger = extent.startTest("customised_Statement");
        logger.log(LogStatus.PASS, "Test Case customised_Statement is passTest");
        extent.endTest(logger);

    }

    @AfterTest
    public void closeTests(){
        extent.flush();
        extent.close();
        oDriver.close();

    }

    public void excel_handle_logic(String sheet_name, WebElement wait8, WebDriver oDriver, Workbook workook) throws IOException {

        Sheet sheet= workook.createSheet(sheet_name);
        Font headerFond= workook.createFont();
        Row row= null;
        List<WebElement> column =null;

        WebElement iwait4=wait8;
        int irow_size= iwait4.findElements(By.tagName("tr")).size();
        List<WebElement> itrow= iwait4.findElements(By.tagName("tr"));

        //ArrayList<String> tvalues=new ArrayList<String> ();

        for (int i=0 ; i< irow_size; i++ ) {
            row= sheet.createRow(i);
            if (itrow.get(i).findElements(By.tagName("th")).size() >0) {
                column = itrow.get(i).findElements(By.tagName("th"));

                for (int j=0 ; j< column.size(); j++ ) {
                    row.createCell(j).setCellValue(column.get(j).getText());
                }

            }
            else
            {
                column = itrow.get(i).findElements(By.tagName("td"));

                for (int j=0 ; j< column.size(); j++ ) {

                    row.createCell(j).setCellValue(column.get(j).getText());
                }
            }
        }

        FileOutputStream outfile= new FileOutputStream("C:\\Intellij_Test\\SDET_TestCases\\testwithjava.xlsx");
        workook.write(outfile);
    }


}
