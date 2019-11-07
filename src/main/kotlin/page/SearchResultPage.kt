package page

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class SearchResultPage : PageObject() {

    @FindBy(xpath = "//p/em")
    private lateinit var searchResults: MutableList<WebElement>

    fun isResultsContainsText(text: String) =
        searchResults.all {
            it.text.contains(
                other = text,
                ignoreCase = true
            )
        }
}