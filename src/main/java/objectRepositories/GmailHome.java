package objectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailHome {
	WebDriver driver;
 By username=By.cssSelector("input#identifierId");
 //By nxtBtn=By.cssSelector("span[class='VfPpkd-vQzf8d']");
 By passWord=By.cssSelector("input[name='password']");
 By nxtBtn=By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]");
 By nxtBtnPsswd=By.xpath("//*[@id=\"passwordNext\"]/div/button/div[2]");
 public GmailHome(WebDriver _driver)
 {
	 this.driver=_driver;
 }
 public WebElement Email()
 {
	 return driver.findElement(username);
 }
 public WebElement Password()
 {
	 return driver.findElement(passWord);
 }
 public WebElement Next()
 {
	 return driver.findElement(nxtBtn);
 }
 public WebElement NextBtnPsswd()
 {
	 return driver.findElement(nxtBtnPsswd);
 }
}
