import extension.waitForPageLoad
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import page.*

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
        driver.waitForPageLoad(2)
    }

    @AfterSuite
    fun tearDown() {
        driver.close()
    }
}
