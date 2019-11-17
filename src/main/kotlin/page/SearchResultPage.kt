package page

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions

class SearchResultPage(pages: PageManager) : Page(pages) {

    @FindBy(xpath = "//p/em")
    private lateinit var searchResults: MutableList<WebElement>

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
}