import org.openqa.selenium.chrome.ChromeDriver
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeGroups
import java.util.concurrent.TimeUnit

open class BaseTest {

    var webDriver = ChromeDriver()

    @BeforeClass
    fun setUp(){
        webDriver.get("https://github.com/login")
        webDriver.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS)
    }


    @AfterClass
    fun tearDown(){
        webDriver.close()
    }
}