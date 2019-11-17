package page

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import util.AppProperty

class GithubPage(pages: PageManager) : Page(pages) {

    override var pageUrl = AppProperty.getPropertyByName("github-page-url")

    @FindBy(xpath = "//label/input[@type=\"text\"]")
    private lateinit var searchInput: WebElement

    @FindBy(partialLinkText = "All GitHub")
    private lateinit var allGithubButton: WebElement

    @FindBy(xpath = "//ul/li/a[.= \"Blog\"]")
    private lateinit var blog: WebElement

    @FindBy(xpath = "//ul/li[2]/div/a")
    private lateinit var secondElementOfRepositoryList: WebElement


    fun inputIntoSearch(searchString: String) {
        shortWait.until(ExpectedConditions.visibilityOf(searchInput))
        searchInput.clear()
        searchInput.sendKeys(searchString)
    }

    fun clickOnAllGithubButton() {
        shortWait.until(ExpectedConditions.visibilityOf(allGithubButton))
        allGithubButton.click()
    }

    fun clickOnBlog() {
        blog.click()
    }

    fun clickOnRepositoryListElement() {
        wait.until(ExpectedConditions.visibilityOf(secondElementOfRepositoryList))
        secondElementOfRepositoryList.click()
    }
}
