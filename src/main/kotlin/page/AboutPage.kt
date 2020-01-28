package page

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class AboutPage: Page() {
    @FindBy(xpath = "//div/a/img[@alt ='Twitter logo']")
    private lateinit var twitterButton: WebElement

    fun getTwitterButton(): WebElement{
        return twitterButton
    }
}