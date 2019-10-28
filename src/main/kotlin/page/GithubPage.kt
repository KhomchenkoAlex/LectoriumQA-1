package page

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class GithubPage : PageObject() {

    val url = "https://github.com/"

    @FindBy(xpath = "//label/input[@type=\"text\"]")
    private lateinit var searchInput: WebElement

    @FindBy(partialLinkText = "All GitHub")
    private lateinit var allGithubButton: WebElement

    @FindBy(xpath = "//ul/li/a[.= \"Blog\"]")
    private lateinit var blog: WebElement

    fun inputIntoSearch(searchString: String) {
        searchInput.clear()
        searchInput.sendKeys(searchString)
    }

    fun clickOnAllGithubButton() {
        allGithubButton.click()
    }

    fun clickOnBlog() {
        blog.click()
    }

}
