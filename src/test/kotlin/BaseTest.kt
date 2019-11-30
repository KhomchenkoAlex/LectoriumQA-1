import manager.AppManager
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite

open class BaseTest {

    val navigationHelper = AppManager.navigationHelper
    val userHelper = AppManager.userHelper
    val repositoryHelper = AppManager.repositoryHelper
    val pageManager = AppManager.pageManager
    val searchHelper = AppManager.searchHelper
    private val startPage = AppManager.pageManager.githubPage

    fun getCurrentUrl(): String = AppManager.webDriver.currentUrl

    @BeforeSuite
    fun setUp() {
        navigationHelper.navigateTo(startPage)
    }

    @AfterSuite
    fun tearDown() {
        AppManager.webDriver.close()
    }
}
