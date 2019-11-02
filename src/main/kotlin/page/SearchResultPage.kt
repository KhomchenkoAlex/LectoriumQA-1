package page

import org.openqa.selenium.WebElement

class SearchResultPage : PageObject() {

    private var resultsLocator = "//p/em"

    fun getSearchResults(): List<WebElement> =
        WebDriverInitializer.webDriver.findElementsByXPath(resultsLocator)

    fun isResultsContainsText(results: List<WebElement>, text: String) =
        results.all {
            it.text.contains(
                other = text,
                ignoreCase = true
            )
        }
}