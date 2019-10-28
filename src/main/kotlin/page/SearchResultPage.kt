package page

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class SearchResultPage : PageObject() {

    @FindBy(xpath = "//h3/a/em")
    lateinit var results: List<WebElement>

    fun isResultsContainsText(results: List<WebElement>, text: String) =
        results.all {
            it.text.contains(
                other = text,
                ignoreCase = true
            )
        }
}