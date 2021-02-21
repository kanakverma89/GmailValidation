package objectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailTriggerTest {
WebDriver driver;

By composeBtn=By.xpath("//div[contains(text(),'Compose')]");

public GmailTriggerTest(WebDriver driver2) {
	// TODO Auto-generated constructor stub
	this.driver=driver2;
}

public WebElement ComposeMail()
{
	return driver.findElement(composeBtn);
}
}
