package page

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class CustomRepositoryPage(pages: PageManager): Page(pages) {

    @FindBy(xpath = "//tr/td/img")
    private lateinit var listElements: MutableList<WebElement>

    @FindBy(xpath = "//*[local-name() = 'svg'][@aria-label='file']")
    private lateinit var fileElements: MutableList<WebElement>

    @FindBy(xpath = "//*[local-name() = 'svg'][@aria-label='directory']")
    private lateinit var directoryElements: MutableList<WebElement>

    fun getAllRepositoryElementsNumber() = listElements.size

    fun getFileElementsNumber() = fileElements.size

    fun getDirectoryElementsNumber() = directoryElements.size

}