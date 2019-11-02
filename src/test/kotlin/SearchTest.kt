import org.testng.Assert
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit


class SearchTest : BaseTest() {

    private val textForSearch = "Java"

    @Test
    fun searchTest() {
        webDriver.navigate().to(githubPage.url)
        githubPage.inputIntoSearch(textForSearch)
        githubPage.clickOnAllGithubButton()
        val searchResult = searchPage.getSearchResults()
        Assert.assertTrue(searchPage.isResultsContainsText(searchResult, textForSearch))
    }
}
