package page

import AppProperty
import WebDriverInitializer.webDriver
import extension.implicitlyWait
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class GithubPage: PageObject() {

    val url = AppProperty.getPropertyByName("github-page-url")

    @FindBy(xpath = "//label/input[@type=\"text\"]")
    private lateinit var searchInput: WebElement

    @FindBy(partialLinkText = "All GitHub")
    private lateinit var allGithubButton: WebElement

    @FindBy(xpath = "//ul/li/a[.= \"Blog\"]")
    private lateinit var blog: WebElement

    @FindBy(xpath = "//ul/li[2]/div/a")
    private lateinit var secondElementOfRepositoryList: WebElement


    fun inputIntoSearch(searchString: String) {
        searchInput.clear()
        searchInput.sendKeys(searchString)
    }

    fun clickOnAllGithubButton() {
        webDriver.implicitlyWait(2)
        allGithubButton.click()
    }

    fun clickOnBlog() {
        blog.click()
    }

    fun clickOnRepositoryListElement() = secondElementOfRepositoryList.click()
}
