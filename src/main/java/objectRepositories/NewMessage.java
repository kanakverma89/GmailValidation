package objectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewMessage {
 WebDriver driver;
 By subject=By.cssSelector("input[name='subjectbox']");//("//textarea[@id=':qd']");
 By recepient=By.cssSelector("div.aoD.hl");
 By to=By.cssSelector("textarea[name='to']");
 By attachBtn=By.cssSelector("div[command='Files']");
 public NewMessage(WebDriver _driver)
 {
	 this.driver=_driver;
 }
 public WebElement Recipient()
 {
	 return driver.findElement(recepient);
 }
 public WebElement SubjectLine()
 {
	 return driver.findElement(subject);
 }
 public WebElement ToRecepient()
 {
	 return driver.findElement(to);
 }
 public WebElement AttachDoc()
 {
	 return driver.findElement(attachBtn);
 }
 public void GetId(String id)
 {
	 By rec=By.id(id);
	driver.findElement(rec).sendKeys("kanakverma89@gmail.com");
 }
}
