package page

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindAll
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import java.util.concurrent.TimeUnit

class RepositoryPage(): PageObject() {

    @FindBy(xpath = "//tr/td/img")
    private lateinit var listElements: MutableList<WebElement>

    fun getRepositoryElementsNumber() = listElements.size

}