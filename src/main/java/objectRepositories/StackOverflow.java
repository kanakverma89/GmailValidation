package objectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StackOverflow {
WebDriver driver;

By loginBtn=By.xpath("//a[text()='Log in']");
By loginWithGoogle=By.xpath("//body/div[3]/div[2]/div[1]/div[2]/button[1]");
By username=By.cssSelector("input#identifierId");
By nextBtn=By.xpath("//span[text()='Next']");
/*By.xpath("//span[contains(text(),'Next')]");*/
By nxtBtn1=By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]/div[2]");
By passWord=By.cssSelector("input[name='password']");

public StackOverflow(WebDriver _driver)
{
	this.driver=_driver;
}
public WebElement LogInStack()
{
	return driver.findElement(loginBtn);
}
public WebElement LogInWithGoogle()
{
	return driver.findElement(loginWithGoogle);
}
public WebElement Email()
{
	return driver.findElement(username);
}
public WebElement PassWord()
{
	return driver.findElement(passWord);
}
public WebElement Next()
{
	return driver.findElement(nextBtn);
}
public WebElement NextInEmail()
{
	 return driver.findElement(nxtBtn1);
}
}
