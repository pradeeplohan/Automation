package MavenDemo;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import MavenDemo.TestComponent.BaseTest;
import MavenDemo.pageobjects.CartPage;
import MavenDemo.pageobjects.LandingPage;
import MavenDemo.pageobjects.Payment;
import MavenDemo.pageobjects.ProductCatalogue;


public class endToEnd extends BaseTest{

	
	@Test
	public void entToEndTest() throws IOException {
		String myProd = "ADIDAS ORIGINAL";
		
		LandingPage lpage = launchApplication();
		
		//LandingPage lpage = new LandingPage(driver); //Creating object of a page object model class and passing driver as argument
		//lpage.gotoWeb();
		ProductCatalogue pCat = lpage.loginWebsite("pardeeplohan@gmail.com", "Lohan@123");

		//ProductCatalogue pCat = new ProductCatalogue(driver);
		//List<WebElement> products = pCat.getProductList();
		pCat.addProductToCart(myProd); 
		
		CartPage cartPage = pCat.goToCartPage();
		
		//CartPage cartPage = new CartPage(driver);
		
		boolean match = cartPage.verifyProductDisplay(myProd);
		Assert.assertTrue(match);
		
		Payment payment = cartPage.clickCheckout();
		
		payment.typeCounty("ind");
		payment.selectCountry("India");
		payment.placeOrder();
		String confirmMessage = payment.getMessage();
		System.out.println(confirmMessage);
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));

		System.out.println("CiCD Pipeline is working fine?");
		driver.close();
	}

}

