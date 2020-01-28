package page

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import java.time.Duration

class TwitterPage: Page() {

    @FindBy(xpath = "(//div/span/span[text()=\"GitHub\"])[1]")
    private lateinit var gitHubLink: WebElement

    @FindBy(xpath = "//a[@href='/help/verified']")
    private lateinit var accountVerified: WebElement

    fun getAccountVerifiedElement(): WebElement = accountVerified

    fun getGitHubLink(): WebElement {
        shortWait.withTimeout(Duration.ofSeconds(4))
        return gitHubLink
    }

    fun getElementText(webElement: WebElement): String {
        return webElement.text
    }
}