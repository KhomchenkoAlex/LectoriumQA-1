import extension.waitForPageLoad
import manager.AppManager
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite

open class BaseTest {

    val driver = AppManager.webDriver
    val pageManager = AppManager.pageManager
    val userHelper = AppManager.userHelper
    private val startPage = pageManager.githubPage

    @BeforeSuite
    fun setUp() {
        pageManager.navigateTo(startPage)
        driver.waitForPageLoad(2)
    }

    @AfterSuite
    fun tearDown() {
        driver.close()
    }
}
