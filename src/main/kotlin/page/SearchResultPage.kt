package page

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions

class SearchResultPage: Page() {

    @FindBy(xpath = "//p/em")
    private lateinit var searchResults: MutableList<WebElement>

    @FindBy(xpath = "//h3/a")
    private lateinit var repositorySearchResult: MutableList<WebElement>

    @FindBy(xpath = "//details/summary/span")
    private lateinit var sortButton: WebElement

    @FindBy(xpath = "(//span[@class = 'select-menu-item-text'])[3]")
    private lateinit var fewestStars: WebElement

    @FindBy(xpath = "//div/div[@class = 'mr-3']/a")
    private lateinit var stars: MutableList<WebElement>

    @FindBy(xpath = "(//div/div[@class = 'mr-3']/a)[0]")
    private lateinit var firstStar: WebElement

    fun isResultsContainsText(text: String): Boolean =
        searchResults.run {
            shortWait.until(ExpectedConditions.visibilityOfAllElements(this))
            this.all {
                it.text.contains(
                    other = text,
                    ignoreCase = true
                )
            }
        }

    fun getRepositoryNames(): List<String> {
        shortWait.until(ExpectedConditions.visibilityOfAllElements(repositorySearchResult))
        return repositorySearchResult.map { it.text }
    }

    fun clickOnSortButton(){
        sortButton.click()
    }

    fun clickOnFewestStars(){
        shortWait.until(ExpectedConditions.elementToBeClickable(fewestStars))
        fewestStars.click()
    }

    fun waitForRefresh(){
        shortWait.until(ExpectedConditions.stalenessOf (repositorySearchResult.first()))
    }

    fun getStarsValues(): MutableList<WebElement>  = stars
}