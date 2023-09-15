package SeleniumModule4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Assignment1{

public WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		System.setProperty("WebDriver.Chrome.Driver", "C:\\Selenium Temp\\ChromeDriver\\chromedriver.exe");
		driver.manage().window().maximize();
	
		driver.get("http://demo.guru99.com/V4/");

	    String file = "C:\\Selenium Temp\\Dumps\\DataDriven.xlsx";  
	    FileInputStream fs = new FileInputStream(file);
	    XSSFWorkbook workbook = new XSSFWorkbook(fs);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    
	    String EmailSheet = sheet.getRow(1).getCell(0).getStringCellValue();
	    System.out.println(EmailSheet);
	    String PasswordSheet = sheet.getRow(1).getCell(1).getStringCellValue();
	    System.out.println(PasswordSheet);	
	    
	    int flag=0;
	    
	    if(flag==0)
	    {	
	    flag++;
	    System.out.println(flag);
	    WebElement UserID = driver.findElement(By.xpath("//*[@name='uid']"));
	    Thread.sleep(1000);
	    UserID.sendKeys(EmailSheet);
	    
	    WebElement Password = driver.findElement(By.xpath("//*[@name='password']"));
	    Thread.sleep(1000);
	    Password.sendKeys(PasswordSheet);
	    }
	    
	    WebElement Login = driver.findElement(By.xpath("//*[@name='btnLogin']"));
	    Thread.sleep(1000);
	    Login.click();
	    
	    Alert alert = driver.switchTo().alert();
	    System.out.println(alert.getText());
	    Thread.sleep(1000);
	    alert.accept();
	    
	 }
}
	
	

	    
