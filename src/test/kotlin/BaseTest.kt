import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions
import org.testng.annotations.*
import java.io.File
import java.util.*
import java.util.concurrent.TimeUnit

open class BaseTest {

    private var chromeDriverService = ChromeDriverService.Builder()
        .usingAnyFreePort()
        .build()

    private var chromeOptions = ChromeOptions()
        .addArguments("--window-size=1920,1080")

    var webDriver = ChromeDriver(chromeDriverService, chromeOptions)

    @BeforeSuite
    fun setUp(){
        webDriver.navigate().to("https://github.com/login")
        webDriver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS)
    }


    @AfterSuite
    fun tearDown(){
        webDriver.close()
    }
}