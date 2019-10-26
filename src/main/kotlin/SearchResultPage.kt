import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class SearchResultPage(
    private val driver: WebDriver
) {

    init {
        PageFactory.initElements(driver, this)
    }

    @FindBy(xpath = "//h3/a/em")
    private lateinit var results: List<WebElement>

    fun isResultsContainsText(results: List<WebElement>, text: String)  =
        results.all {
            it.text.contains(
                other = text,
                ignoreCase = true
            )
        }
}