package page

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class GitHubLoginPage: PageObject() {

    val loginPageUrl = "https://github.com/login"

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

    fun inputLogin(login: String?) {
        loginInput.clear()
        loginInput.sendKeys(login)
    }

    fun inputPassword(password: String?) {
        passwordInput.clear()
        passwordInput.sendKeys(password)
    }

    fun submit() {
        submitButton.click()
    }
}
