import org.testng.Assert
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit


class SearchTest : BaseTest() {

    private val textForSearch = "Java"

    @Test
    fun searchTest() {
        driver.navigate().to(githubPage.url)
        githubPage.inputIntoSearch(textForSearch)
        githubPage.clickOnAllGithubButton()
        Assert.assertTrue(searchPage.isResultsContainsText(textForSearch))
    }
}
