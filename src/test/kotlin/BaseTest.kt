import org.testng.annotations.AfterSuite
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeSuite
import org.testng.annotations.BeforeTest
import page.BlogPage
import page.GitHubLoginPage
import page.GithubPage
import page.SearchResultPage
import java.util.concurrent.TimeUnit

open class BaseTest {

    val webDriver = WebDriverInitializer.webDriver

    val gitHubLoginPage = GitHubLoginPage()
    val searchPage = SearchResultPage()
    val githubPage = GithubPage()
    val blogPage = BlogPage()

    @BeforeSuite
    fun setUp() {
        webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS)
        webDriver.navigate().to("https://github.com")
    }

    @AfterSuite
    fun tearDown() {
        webDriver.close()
    }
}
