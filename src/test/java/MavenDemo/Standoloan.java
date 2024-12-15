package MavenDemo;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import MavenDemo.pageobjects.LandingPage;


public class Standoloan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String myProd = "ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		
		LandingPage lpage = new LandingPage(driver); //Creating object of a page object model class and passing driver as argument
		
		driver.findElement(By.id("userEmail")).sendKeys("pardeeplohan@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Lohan@123");
		driver.findElement(By.id("login")).click();
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod = products.stream().filter(s->
		s.findElement(By.cssSelector("b")).getText().equals(myProd)).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector("div.card-body button:last-of-type")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		
		List<WebElement> cart = driver.findElements(By.cssSelector(".cartSection h3"));
		boolean match = cart.stream().anyMatch(product -> product.getText().equals(myProd));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");
		List<WebElement> countries = driver.findElements(By.xpath("//button/span"));
		WebElement c = countries.stream().filter(country -> 
		country.getText().equalsIgnoreCase("India")).findAny().orElse(null);
		c.click();
		driver.findElement(By.cssSelector(".btnn")).click();
		
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(confirmMessage);
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		
		driver.close();
	}

}
