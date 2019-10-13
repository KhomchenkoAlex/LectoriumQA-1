import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class GitHubLoginPage(
    private val driver: WebDriver
) {

    init {
        PageFactory.initElements(driver, this)
    }

    @FindBy(xpath = "//input[@name=\"login\"]")
    private lateinit var  loginInput: WebElement

    @FindBy(xpath = "//input[@name=\"password\"]")
    private lateinit var passwordInput: WebElement

    @FindBy(xpath = "//input[@value=\"Sign in\"]")
    private lateinit var submitButton: WebElement

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