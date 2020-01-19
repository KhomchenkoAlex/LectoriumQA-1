import listener.CustomTestListener
import manager.AppManager
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Listeners
import page.PageManager.Pages.GITHUB_PAGE

@Listeners(CustomTestListener::class)
open class BaseTest {

    val navigationHelper = AppManager.navigationHelper
    val userHelper = AppManager.userHelper
    val repositoryHelper = AppManager.repositoryHelper
    val webElementHelper = AppManager.webElementHelper
    val searchHelper = AppManager.searchHelper


    fun getCurrentUrl(): String = AppManager.webDriver.currentUrl

    @BeforeSuite
    fun setUp() {
        navigationHelper.navigateTo(GITHUB_PAGE)
    }

    @AfterSuite
    fun tearDown() {
        AppManager.webDriver.close()
    }
}
