import org.testng.Assert
import org.testng.annotations.Test

class SearchTest : BaseTest() {

    private val textForSearch = "Java"
    private val githubPage = pageManager.githubPage
    private val searchPage = pageManager.searchResultPage

    @Test
    fun searchTest() {
        pageManager.navigateTo(githubPage)
        userHelper.inputTextForSearch(textForSearch)
        Assert.assertTrue(searchPage.isResultsContainsText(textForSearch))
    }
}
