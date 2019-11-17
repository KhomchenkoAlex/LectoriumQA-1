package page

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import util.AppProperty
import java.time.Duration

class GithubPage(pages: PageManager) : Page(pages) {

    override var pageUrl = AppProperty.getPropertyByName("github-page-url")

    @FindBy(xpath = "//label/input[@type='text']")
    private lateinit var searchInput: WebElement

    @FindBy(partialLinkText = "All GitHub")
    private lateinit var allGithubButton: WebElement

    @FindBy(xpath = "//ul/li/a[.= 'Blog']")
    private lateinit var blog: WebElement

    @FindBy(xpath = "//ul/li[2]/div/a")
    private lateinit var secondElementOfRepositoryList: WebElement

    @FindBy(xpath = "//summary/img")
    private lateinit var loginAvatarImage: WebElement

    @FindBy(xpath = "//a[contains(.,'Your repositories')]")
    private lateinit var yourRepositories: WebElement

    @FindBy(xpath = "//form/button[contains(text(),'Sign out')]")
    private lateinit var signOut: WebElement

    @FindBy(xpath = "//a[@href='/login']")
    private lateinit var signIn: WebElement


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
        wait.until(ExpectedConditions.elementToBeClickable(blog))
        blog.click()
    }

    fun clickOnRepositoryListElement() {
        wait.until(ExpectedConditions.visibilityOf(secondElementOfRepositoryList))
        secondElementOfRepositoryList.click()
    }

    fun clickToSignOut() {
        loginAvatarImage.click()
        shortWait.until(ExpectedConditions.visibilityOf(signOut))
        signOut.click()
    }

    fun clickToYourRepositories(){
        loginAvatarImage.click()
        shortWait.until(ExpectedConditions.visibilityOf(yourRepositories))
        yourRepositories.click()
        shortWait.withTimeout(Duration.ofSeconds(1))
    }

    fun isSignInVisible() = signIn.isDisplayed
}
