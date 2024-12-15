package MavenDemo.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MavenDemo.AbstractComponants.AbstractComponet;

public class ProductCatalogue extends AbstractComponet {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	//Using PageFactory
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	//driver.findElement(By.cssSelector(".ng-animating"))
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector("div.card-body button:last-of-type");
	By toastMessage = By.id("toast-container");
	
	public List<WebElement> getProductList()
	{
		waitForVisibiltyofEle(productsBy);
		
		return products;
		
	}
	
	public WebElement filterProduct(String myProd)
	{
	WebElement prod = getProductList().stream().filter(s->
	s.findElement(By.cssSelector("b")).getText().equals(myProd)).findFirst().orElse(null);
	return prod;
	}
	
	public void addProductToCart(String myProd)
	{
	
		WebElement prod = filterProduct(myProd);
		prod.findElement(addToCart).click();
		waitForVisibiltyofEle(toastMessage);
		waitForInvisibiltyofEle(spinner);
		
	}
}
