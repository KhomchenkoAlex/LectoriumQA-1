package page

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import util.AppProperty

class LoginPage(pages: PageManager) : Page(pages) {

    override var pageUrl = AppProperty.getPropertyByName("login-page-url")

    @FindBy(xpath = "//input[@name=\"login\"]")
    private lateinit var  loginInput: WebElement

    @FindBy(xpath = "//input[@name=\"password\"]")
    private lateinit var passwordInput: WebElement

    @FindBy(xpath = "//input[@value=\"Sign in\"]")
    private lateinit var submitButton: WebElement

    @FindBy(xpath = "//a[contains(text(),'Signed in as')]")
    lateinit var successMessage: WebElement

    @FindBy(xpath = "//form/div/div[contains(., 'Incorrect')]")
    lateinit var errorMessage: WebElement

    @FindBy(xpath = "//form/label/input[@type=\"text\"]")
    lateinit var searchField: WebElement

    @FindBy(partialLinkText = "All GitHub")
    private lateinit var allGithubButton: WebElement

    fun inputLogin(login: String?) {
        shortWait.until(ExpectedConditions.visibilityOf(loginInput))
        loginInput.clear()
        loginInput.sendKeys(login)
    }

    fun inputPassword(password: String?) {
        shortWait.until(ExpectedConditions.visibilityOf(passwordInput))
        passwordInput.clear()
        passwordInput.sendKeys(password)
    }

    fun submit() {
        submitButton.click()
    }

    fun inputToSearchField(text: String) {
        shortWait.until(ExpectedConditions.visibilityOf(searchField))
        searchField.clear()
        searchField.sendKeys(text)
    }

    fun clickOnAllGitHubButton() {
        shortWait.until(ExpectedConditions.elementToBeClickable(allGithubButton))
        allGithubButton.click()
    }
}
