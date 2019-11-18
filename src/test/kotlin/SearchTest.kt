import org.testng.Assert
import org.testng.annotations.Test

class SearchTest : BaseTest() {

    private val textForSearch = "Java"
    private val githubPage = pageManager.githubPage
    private val searchPage = pageManager.searchResultPage

    @Test
    fun searchTest() {
        navigationHelper.navigateTo(githubPage)
        userHelper.searchFor(textForSearch)
        Assert.assertTrue(searchPage.isResultsContainsText(textForSearch))
    }
}
