package selenium.miniproject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;


public class HumanResourceManagement {
 
	public static void main(String[] args)throws Exception{
	//1.Launch the edge browser
		System.setProperty("webdriver.edge.driver","C:\\Users\\2317554\\eclipse-workspace\\selenium\\browser\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\2317554\\eclipse-workspace\\selenium\\browser\\geckodriver.exe");
	   //WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
	//2.Enter URL
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		
	//3.Enter the username and password
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
	//4.Click the “Login” button
		WebElement button=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]"));
		button.click();
		
	//5.Verify the current URL and check if it contains the string “dashboard”.
		String url=driver.getCurrentUrl();
		if(url.contains("dashboard"))
		{
			System.out.println("'dashboard' present in the url");
		}
		else
		{
			System.out.println("'dashboard' not present in the url");
		}
		
	//6.Go to Admin Tab

		WebElement admin=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]"));
		admin.click();
	
		
	//7.Go to the Job tab and check ‘Job Titles’ is there or not.
		
		WebElement jobDropdown=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]"));
		jobDropdown.click();
		
		
		WebElement title=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul/li[1]"));
		if(title.isDisplayed())
		{
			System.out.println("'Job Title' is visible");
			title.click();
		}
		else
		{
			System.out.println("Job Title not available");
		}
   //8.Get the List of All Jobs Available

		List<WebElement> jobs =driver.findElements(By.xpath("//div[@data-v-6c07a142='']"));
	
		for(WebElement job : jobs)
		{
			System.out.println("Job Name : "+job.getText());
		}
		
	//9.Click on “Add Button” icon, add job as “Automation Tester”

		driver.findElement(By.cssSelector(".oxd-button")).click();
		
	//10.Fill the appropriate data in the fields “Job Title” and click on “Save”.
		
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")).sendKeys("Automation Tester");
 
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		System.out.println();
		System.out.println("Job has been added to the list");
		
	//11.Logout and close the browser
		
		driver.close();
		
				
	}
 
}

