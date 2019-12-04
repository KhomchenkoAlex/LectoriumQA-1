import org.testng.Assert
import org.testng.annotations.Test
import page.PageManager.Pages.BLOG_PAGE

class BlogTest : BaseTest() {

    @Test
    fun blogTest() {
        userHelper.clickOnBlogLink()
        val currentUrl = getCurrentUrl()
        val blogPageUrl = navigationHelper.getPageUrl(BLOG_PAGE) as CharSequence
        Assert.assertTrue(currentUrl.contentEquals(blogPageUrl))
        Assert.assertEquals(webElementHelper.getBlogElementText(), "The GitHub Blog")
    }
}