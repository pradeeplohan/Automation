package MavenDemo;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import MavenDemo.TestComponent.BaseTest;

public class LoginErrorValidation extends BaseTest {
	
	@Test
	public void loginWithIncorectEmail(){
		
		lpage.loginWebsite("pardeep-lohan@gmail.com", "Lohan@123");
		//System.out.println(driver.findElement(By.xpath("//div[contains(@class,'toast-message')]")).getText());
		//System.out.println(lpage.getErrorMessage());
	    AssertJUnit.assertEquals(lpage.getErrorMessage(), "Incorrect email or password.");
		
	}
	
	@Test
	public void loginWithIncorectPassword(){
		
		lpage.gotoWeb();
		lpage.loginWebsite("pardeeplohan@gmail.com", "Lohan@44");
		//System.out.println(driver.findElement(By.xpath("//div[contains(@class,'toast-message')]")).getText());
		//System.out.println(lpage.getErrorMessage());
	    AssertJUnit.assertEquals(lpage.getErrorMessage(), "Incorrect email or password.");
		
	}
	
	@Test
	public void loginWithIncorectEmailAndPassword(){
		
		lpage.gotoWeb();
		lpage.loginWebsite("pardeep.lohan@gmail.com", "Lohan@44");
		//System.out.println(driver.findElement(By.xpath("//div[contains(@class,'toast-message')]")).getText());
		//System.out.println(lpage.getErrorMessage());
	    AssertJUnit.assertEquals(lpage.getErrorMessage(), "Incorrect email or password.");
		
	}

}
