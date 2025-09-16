package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties properties;
	
	@BeforeClass(groups= {"Sanity","Regression","Master","DataDriven"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws InterruptedException, IOException {
		
		FileReader file=new FileReader("C:\\Automation\\myworkspace\\OpenCart121\\src\\test\\resources\\config.properties");
		properties=new Properties();
		properties.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		if(properties.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows")) {
			capabilities.setPlatform(Platform.WIN11);
			}else if(os.equalsIgnoreCase("mac")){
				capabilities.setPlatform(Platform.MAC);
			}else 
				if(os.equalsIgnoreCase("linux")){
					capabilities.setPlatform(Platform.LINUX);
				}else{
				System.out.println("no opersting system found");
				return;
			}
			
			
			switch(br.toLowerCase()) {
			case "chrome": capabilities.setBrowserName("chrome");break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge");break;
			case "firefox": capabilities.setBrowserName("firefox");break;
			default:System.out.println("Invalid browser");
			return;
			}
			
			driver=new RemoteWebDriver(new URL(" http://localhost:4444/wd/hub"),capabilities);
			
		}
		
		if(properties.getProperty("execution_env").equalsIgnoreCase("local")) {
			
			switch(br){
			case "chrome":driver=new ChromeDriver(); break;
			case "edge":driver=new EdgeDriver(); break;
			case "firefox":driver=new FirefoxDriver(); break;
			default:System.out.println("Invalid browser");
			return;
			}
			
		}
		
		// use below code to run on local mechine
		/*switch(br){
		case "chrome":driver=new ChromeDriver(); break;
		case "edge":driver=new EdgeDriver(); break;
		case "firefox":driver=new FirefoxDriver(); break;
		default:System.out.println("Invalid browser");
		return;
		}*/
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(properties.getProperty("appURL"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master","DataDriven"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
		String genratedstring=RandomStringUtils.randomAlphabetic(5);
		return genratedstring;
	}
	
	public String randomNumbers() {
		String genrateNumber=RandomStringUtils.randomNumeric(10);
		return genrateNumber;
	}
	
	public String randomAlphaNumeric() {
		String genratedstring=RandomStringUtils.randomAlphabetic(3);
		String genrateNumber=RandomStringUtils.randomNumeric(3);
		return (genrateNumber+"@"+genratedstring);
		
	}

	public String captureScreen(String tname) throws IOException {
		
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takeScreenshot=(TakesScreenshot) driver;
		File sourceFile= takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		String tagetFilePath=System.getProperty("C:\\Automation\\myworkspace\\OpenCart121\\screenshots")+tname+"_"+timeStamp+".png";
		File targetFile=new File(tagetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return tagetFilePath;
	}

}
