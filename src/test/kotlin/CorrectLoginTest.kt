import org.testng.Assert
import org.testng.annotations.Test

class CorrectLoginTest: BaseTest() {

    val page = GitHubLoginPage(webDriver)

    val login = "KhomchenkoAlex"
    val password = "dozori35"

    @Test
    fun correctLogin(){
        page.inputLogin(login)
        page.inputPassword(password)
        page.submit()
        Assert.assertEquals(webDriver.title, "GitHub")
    }

}