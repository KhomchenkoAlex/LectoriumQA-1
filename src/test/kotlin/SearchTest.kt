import org.testng.Assert
import org.testng.annotations.Test


class SearchTest : BaseTest() {

    private val textForSearch = "Java"

    @Test
    fun searchTest() {
        webDriver.navigate().to(githubPage.url)
        githubPage.inputIntoSearch(textForSearch)
        githubPage.clickOnAllGithubButton()
        Assert.assertTrue(searchPage.isResultsContainsText(searchPage.results, textForSearch))
    }
}
