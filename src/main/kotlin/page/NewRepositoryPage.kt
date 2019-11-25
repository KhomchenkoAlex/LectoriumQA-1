package page

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions

class NewRepositoryPage(pages: PageManager) : Page(pages) {

    @FindBy(xpath = "//dd/input[@id='repository_name']")
    private lateinit var newRepositoryNameInput: WebElement

    @FindBy(xpath = "//button[text()[contains(., 'Create repository')]]")
    private lateinit var createRepositoryButton: WebElement

    fun inputNewRepositoryName(repoName: String) {
        newRepositoryNameInput.clear()
        newRepositoryNameInput.sendKeys(repoName)
    }

    fun clickOnCreateRepositoryButton(){
        shortWait.until(ExpectedConditions.elementToBeClickable(createRepositoryButton))
        createRepositoryButton.click()
    }
}