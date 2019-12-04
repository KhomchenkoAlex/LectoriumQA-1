import org.testng.Assert
import org.testng.annotations.Test
import page.PageManager.Pages.GITHUB_PAGE

class SearchTest : BaseTest() {

    private val textForSearch = "Java"

    @Test
    fun searchTest() {
        navigationHelper.navigateTo(GITHUB_PAGE)
        userHelper.searchFor(textForSearch)
        Assert.assertTrue(searchHelper.isResultsContainsText(textForSearch))
    }
}
