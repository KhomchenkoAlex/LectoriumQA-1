package manager

import helper.*
import io.qameta.allure.Attachment
import org.openqa.selenium.OutputType
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions
import page.PageManager
import java.util.concurrent.TimeUnit

object AppManager {
    private val chromeDriverService = ChromeDriverService.Builder()
        .usingAnyFreePort()
        .build()

    private val chromeOptions = ChromeOptions()
        .addArguments("--window-size=1920,1080")

    val webDriver = ChromeDriver(chromeDriverService, chromeOptions)
    val pageManager = PageManager(webDriver)
    val userHelper = UserHelper(webDriver)
    val navigationHelper = NavigationHelper(webDriver)
    val repositoryHelper = RepositoryHelper(webDriver)
    val searchHelper = SearchHelper(webDriver)
    val webElementHelper = WebElementHelper(webDriver)

    fun implicitlyWait(duration: Long): WebDriver.Timeouts =
        webDriver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS)

    @Attachment(value = "Page screenshot", type = "image/png")
    fun takeScreenshot(): ByteArray {
        return webDriver.getScreenshotAs(OutputType.BYTES)
    }
}