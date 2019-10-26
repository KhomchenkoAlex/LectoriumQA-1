import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions
import org.testng.annotations.*
import java.util.concurrent.TimeUnit

open class BaseTest {

    private var chromeDriverService = ChromeDriverService.Builder()
        .usingAnyFreePort()
        .build()

    private var chromeOptions = ChromeOptions()
        .addArguments("--window-size=1920,1080")

    var webDriver = ChromeDriver(chromeDriverService, chromeOptions)

    fun implicitlyWait(durationInSeconds: Long) {
        webDriver.manage().timeouts().implicitlyWait(durationInSeconds, TimeUnit.SECONDS)
    }

    fun pageLoadWait(durationInSeconds: Long) {
        webDriver.manage().timeouts().pageLoadTimeout(durationInSeconds,TimeUnit.SECONDS)
    }

    @BeforeSuite
    fun setUp(){
        webDriver.navigate().to("https://github.com")
        pageLoadWait(5)
    }

    @AfterSuite
    fun tearDown(){
        webDriver.close()
    }
}
