import org.testng.Assert
import org.testng.annotations.Test

class BlogTest: BaseTest() {

    private val blogUrl = "https://github.blog/"

    @Test
    fun blogTest() {
        githubPage.clickOnBlog()
        Assert.assertTrue(webDriver.currentUrl!!.contentEquals(blogUrl))
        Assert.assertEquals(blogPage.gitHubBlog.text, "The GitHub Blog")
    }
}