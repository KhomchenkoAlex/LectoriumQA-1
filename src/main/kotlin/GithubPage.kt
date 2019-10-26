import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

open class GithubPage(
    private val driver: WebDriver
) {
    init {
        PageFactory.initElements(driver, this)
    }

    @FindBy(xpath = "//label/input[@type=\"text\"]")
    private lateinit var searchInput: WebElement

    @FindBy(partialLinkText = "All GitHub")
    private lateinit var allGithubButton: WebElement

    fun inputIntoSearch(searchString: String) {
        searchInput.clear()
        searchInput.sendKeys(searchString)
    }

    fun clickOnAllGithubButton(){
        allGithubButton.click()
    }

}