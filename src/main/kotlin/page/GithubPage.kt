package page

import WebDriverInitializer.webDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import java.util.concurrent.TimeUnit

class GithubPage : PageObject() {

    val url = AppProperty.getPropertyByName("github-page-url")

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
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
        allGithubButton.click()
    }

    fun clickOnBlog() {
        blog.click()
    }

}
