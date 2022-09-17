package TestCases;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.LoginPage;

	
public class SimpliLearnLogin extends BaseClass{
	
	
	@Test
	public void Test1() {
		
		test.log(LogStatus.INFO, "Test1 Started");
		LoginPage lp = new LoginPage(driver);
		lp.Login("abc@xyz.com", "Abcd12345"); //Test1 method for positive tc and Test2 for negative tc
		
		//Step6: Validate the error message on screen
		WebElement Error = driver.findElement(By.id("msg_box"));
		
		String ActError = Error.getText();
		String ExpError = "The email or password you have entered is invalid.";
//Assert.assertFalse(Error.isDisplayed());
Assert.assertTrue(Error.isDisplayed());
Assert.assertEquals(ActError, ExpError);
		/*if(ActError.equals(ExpError)) {
			System.out.println("TC PAssed");
		}else {
			System.out.println("Tc Failed");
		}	*/ //when if stmnt is used though we give ExpError value as something else we will get the output as TC Failed but the 
		//Testng is still passed, so to prevent this we need to make TC fail if the condition is failed using assertions
		// we need to use Assertions in testng instead of if else condition
	}
	
	@Test
	@Parameters({"uname","pwd"})
	public void Test2(String UN , String PW) {
		
		test.log(LogStatus.INFO, "Test2 Started");
		
		LoginPage lp = new LoginPage(driver);
		lp.Login(UN, PW);
	}	
		@Test
		public void Test3() {
			
			test.log(LogStatus.INFO, "Test3 Started");
			
			String UserName = sheet.getRow(1).getCell(0).getStringCellValue();
	        String Password = sheet.getRow(1).getCell(1).getStringCellValue();
			LoginPage lp = new LoginPage(driver);
			lp.Login(UserName, Password);
			
		
	
	}
}


