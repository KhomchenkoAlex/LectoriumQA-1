import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert
import org.testng.annotations.Test
import java.time.Duration
import java.util.concurrent.TimeUnit

class SearchTest: BaseTest() {

    private val inputSearch = "//input[@data-scoped-placeholder = 'Search or jump to…']"
    private val result = "//img[@src[contains(., 'java.png')]]"

    @Test
    fun searchTest() {
        val wait = WebDriverWait(webDriver,5)

        val inputElement = webDriver.findElementByXPath(inputSearch)
        inputElement.clear()
        inputElement.click()
        inputElement.sendKeys("java")
        wait.withTimeout(Duration.ofSeconds(2))
        webDriver.findElement(By.partialLinkText("All GitHub")).click()

        wait.until { webDriver.currentUrl.contains("https://github.com/search?q=") }
        val search = webDriver.findElementByXPath("id('jump-to-results')")
        search.click()

        webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS)

        wait.until { webDriver.findElementByXPath(result).isEnabled }
        val resultElement = webDriver.findElementByXPath(result)
        Assert.assertTrue(resultElement.isEnabled)
    }

}
