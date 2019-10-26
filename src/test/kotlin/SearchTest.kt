import org.testng.Assert
import org.testng.annotations.Test


class SearchTest : BaseTest() {

    private val githubPage = GithubPage(webDriver)
    private val textForSearch = "Java"

    @Test
    fun searchTest() {
        githubPage.inputIntoSearch(textForSearch)
        implicitlyWait(5)
        githubPage.clickOnAllGithubButton()
        pageLoadWait(5)
        val searchResultPage = SearchResultPage(webDriver)
        implicitlyWait(5)
        val results = webDriver.findElementsByXPath("//h3/a/em")
        Assert.assertTrue(searchResultPage.isResultsContainsText(results, textForSearch))
    }
}
