import org.testng.Assert
import org.testng.annotations.Test

class BlogTest: BaseTest() {

    private val blogUrl = "https://github.blog/"

    @Test
    fun blogTest() {
        githubPage.clickOnBlog()
        val currentUrl = webDriver.currentUrl as String
        Assert.assertTrue(currentUrl.contentEquals(blogUrl))
        Assert.assertEquals(blogPage.gitHubBlog.text, "The GitHub Blog")
    }
}