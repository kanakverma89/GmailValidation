package stepDefinations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import objectRepositories.GmailHome;
import objectRepositories.GmailTriggerTest;
import objectRepositories.NewMessage;
import objectRepositories.StackOverflow;

public class StepDefTest {
	WebDriver driver;
	
   
	
	@Given("^I have navigate to the below url in the browser\\.$")
	public void i_have_navigate_to_the_below_url_in_the_browser(DataTable arg1) throws InterruptedException, IOException {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<List<String>> data = arg1.raw();
		System.out.println("The address we need to navigate is " + (data.get(0)));
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver\\chromedriver.exe");
		String _url = data.get(0).toString();
		StringBuilder _sb = new StringBuilder(_url);
		_sb.deleteCharAt(0);
		_sb.deleteCharAt(_sb.length() - 1);
		System.out.println(_sb);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(_sb.toString());
		GmailHome _gh = new GmailHome(driver);
		Properties _prop=new Properties();
		Path currentPath = Paths.get(System.getProperty("user.dir"));
		Path filePathPropertiesFile = Paths.get(currentPath.toString(),"src\\main\\java\\utilities\\data.properties");
		FileInputStream _fps=new FileInputStream(filePathPropertiesFile.toString());
		_prop.load(_fps);
		_gh.Email().sendKeys(_prop.getProperty("email"));
		_gh.Next().click();
		_gh.Password().sendKeys(_prop.getProperty("password"));
		_gh.NextBtnPsswd().click();

	}

	@Then("^I click on the Compose button\\.$")
	public void i_click_on_the_compose_button() throws InterruptedException {
		GmailTriggerTest _compose = new GmailTriggerTest(driver);
		_compose.ComposeMail().click();

	}

	@And("^I enter the recepient name and subject mail\\.$")
	public void i_enter_the_recepient_name_and_subject_mail() {
		NewMessage _nm = new NewMessage(driver);

		WebElement ele = driver.findElement(By.cssSelector("div.aYF"));
		System.out.println(ele.getText());
		_nm.SubjectLine().sendKeys("Test Message");
		_nm.Recipient().click();
		String _id = _nm.ToRecepient().getAttribute("id");
		_nm.GetId(_id);
	}
	 @Then("^I attach the required document\\.$")
	    public void i_attach_the_required_document() throws IOException, InterruptedException {
	        NewMessage _nm=new NewMessage(driver);
	        _nm.AttachDoc().click();
	        Thread.sleep(2000);
	        Path currentPath = Paths.get(System.getProperty("user.dir"));
			Path filePathAutoIt = Paths.get(currentPath.toString(),"src\\main\\java\\utilities\\fupload.exe");
			 Path filePathRel = Paths.get(System.getProperty("user.dir"));
			Path filePath = Paths.get(currentPath.toString(),"data.txt");
			//System.out.println(filePathRel.toString());
	       // Runtime.getRuntime().exec("C:\\Users\\HP\\Compose\\src\\main\\java\\utilities\\fileupload.exe");
			Runtime.getRuntime().exec(filePathAutoIt.toString()+" "+filePath.toString());
	        System.out.println(Paths.get("").toAbsolutePath().toString());

	        System.out.println(System.getProperty("user.dir"));
	        
	    }
	 @And("^I click on send button to send the email\\.$")
	    public void i_click_on_send_button_to_send_the_email()  {
	       List<WebElement> _ele=driver.findElements(By.cssSelector("div[class='dC'] div"));
	       for(WebElement item:_ele)
	       {
	    	   String name=item.getText().toString();
	    	   System.out.println(item.getText());
	    	   if(name.contains("Send"))
	    	   {
	    		   try
	    		   {
	    			   item.click();
	    		   }
	    		   catch (Exception ex)
	    		   {
	    			   System.out.println(ex.getMessage());
	    		   }
	    	   }
	       }
	    }
	 @After
	 public void TearDown() throws InterruptedException
	 {
		 Thread.sleep(4000);
		 driver.close();
	 }
	 
}
