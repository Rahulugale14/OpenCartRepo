package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;         //this is to do manually after adding log4j2 to this class
import org.apache.logging.log4j.Logger;             //this is to do manually after adding log4j2 to this class
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

// THIS IS THE BASE CLASS, it contains common methods used repetitively, thus achieving reusability

public class BaseClass {

    public WebDriver driver;
    public Logger logger;                      //Log4J2
    public Properties prop;

    @BeforeClass
    @Parameters({"os", "browser"})
    public void setUp(String os, String br) throws IOException {

        //loading config.properties file
        FileReader file = new FileReader(".//src//test//resources//config.properties");
        prop = new Properties();
        prop.load(file);

        //Log4J2
        logger = LogManager.getLogger(this.getClass());


        switch (br.toLowerCase()) {
            case "chrome": driver = new ChromeDriver(); break;
            //case "edge": driver = new EdgeDriver(); break;
            case "firefox": driver = new FirefoxDriver(); break;
            default: System.out.println("Invalid browser name... ");return;
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(prop.getProperty("appURL"));     //reading URL from config.properties file
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    public String randomString() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);              //this class is not from Java, this is to pass for Strings
        return generatedString;
    }

    public String randomNumber() {
        String generatedNumber = RandomStringUtils.randomNumeric(10);       //to pass random telephone number
        return generatedNumber;
    }

    public String randomAlphaNumeric() {
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        String generatedNumber = RandomStringUtils.randomNumeric(3);
        return (generatedString + "@" + generatedNumber);                 //adding special chars for password

    }


}
