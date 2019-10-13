import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

class LoginTest : BaseTest() {

    private val page = GitHubLoginPage(webDriver)

    private val login = AppProperty.getProperty("login")
    private val password = AppProperty.getProperty("password")
    private val incorrectLogin = AppProperty.getProperty("incorrect-login")
    private val incorrectPassword =  AppProperty.getProperty("incorrect-password")
    private val inputSearch = "//input[@data-scoped-placeholder = 'Search or jump to…']"
    private val result = "//img[@src[contains(., 'java.png')]]"

    @Test
    fun correctLogin(){
        page.inputLogin(login)
        page.inputPassword(password)
        page.submit()
        Assert.assertTrue(webDriver.findElementByXPath("//a[contains(text(),'Signed in as')]").isEnabled)
    }

    @Test
    fun incorrectLogin() {
        page.inputLogin(incorrectLogin)
        page.inputPassword(incorrectPassword)
        page.submit()
        val errorMessage = webDriver.findElementByXPath("//form/div/div[contains(., 'Incorrect')]")
        Assert.assertTrue(errorMessage.isDisplayed)
    }

    @Test
    fun searchTest() {
        val inputElement = webDriver.findElementByXPath(inputSearch)
        inputElement.clear()
        inputElement.sendKeys("java")
        val x = webDriver.findElementByXPath("id('jump-to-results')")
            x.click()

        webDriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS)
        val wait = WebDriverWait(webDriver,10)
        wait.until {  webDriver.findElementByXPath(result).isEnabled}
        val resultElement = webDriver.findElementByXPath(result)
        Assert.assertTrue(resultElement.isEnabled)
    }

}