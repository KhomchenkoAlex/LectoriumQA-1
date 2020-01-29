package page

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions

class TwitterPage: Page() {

    @FindBy(xpath = "(//div/a[@href = '/github']//span/span)[1]")
    private lateinit var gitHubLink: WebElement

    @FindBy(xpath = "(//*[name()=\"svg\" and @viewBox and @aria-label])[2]")
    private lateinit var accountVerified: WebElement

    fun getAccountVerifiedElement(): WebElement = accountVerified

    fun getGitHubLink(): WebElement {
        wait.until(ExpectedConditions.visibilityOfAllElements(gitHubLink))
        return gitHubLink
    }

    fun getElementText(webElement: WebElement): String {
        return webElement.text
    }
}