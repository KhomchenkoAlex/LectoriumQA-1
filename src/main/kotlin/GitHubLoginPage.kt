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

    @FindBy(xpath = "//*[@id=\"login_field\"]")
    private lateinit var  loginInput: WebElement

    @FindBy(xpath = "//*[@id=\"password\"]")
    private lateinit var passwordInput: WebElement

    @FindBy(xpath = "//*[@id=\"login\"]/form/div[3]/input[8]")
    private lateinit var submitButton: WebElement

    fun inputLogin(login: String) {
        loginInput.sendKeys(login)
    }

    fun inputPassword(password: String) {
        passwordInput.sendKeys(password)
    }

    fun submit() {
        submitButton.click()
    }
}