package TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	WebDriver driver;
	XSSFWorkbook wbook;
    XSSFSheet sheet;
    
    @BeforeTest
    public void DataSetup() throws IOException
    {
    	FileInputStream fis = new FileInputStream("exceldata.xlsx");
    	wbook = new XSSFWorkbook(fis);
    	sheet = wbook.getSheet("Sheet1");
    }
    @AfterTest
    public void DataClean() throws IOException
    {
    	wbook.close();
    }
	@BeforeMethod
public void SetUp()
{
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	
	 driver = new ChromeDriver(); // if u give WebDriver driver here..it will cause nullpointer exception...declaration should be given one time which is already declared at line 11
	
	driver.get("https://www.simplilearn.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
}
	
	@AfterMethod
	public void TearDown()
	{
		//Step7: Close the browser
		driver.close();
	}
}
