package page

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class BlogPage: PageObject() {

    @FindBy(xpath = "//div/a/h1" )
    private lateinit var gitHubBlog: WebElement

    fun getElementText() = gitHubBlog.text
}