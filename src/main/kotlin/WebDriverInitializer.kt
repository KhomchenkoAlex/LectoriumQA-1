import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions

object WebDriverInitializer {
    private val chromeDriverService = ChromeDriverService.Builder()
        .usingAnyFreePort()
        .build()

    private val chromeOptions = ChromeOptions()
        .addArguments("--window-size=1920,1080")

    val webDriver = ChromeDriver(chromeDriverService, chromeOptions)
}