import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import page.*
import java.util.concurrent.TimeUnit

abstract class BaseTest {

    val gitHubLoginPage = GitHubLoginPage()
    val searchPage = SearchResultPage()
    val githubPage = GithubPage()
    val blogPage = BlogPage()
    val repoPage = RepositoryPage()
    val driver = WebDriverInitializer.webDriver

    @BeforeSuite
    fun setUp() {
        driver.navigate().to(githubPage.url)
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS)
    }

    @AfterSuite
    fun tearDown() {
        driver.close()
    }
}
