package page

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions

class UserRepositoriesPage(pages: PageManager): Page(pages) {

    @FindBy(xpath = "//h3/a")
    lateinit var repositoryList: MutableList<WebElement>

    @FindBy(xpath = "//input[@type='search']")
    private lateinit var findRepositoryInput: WebElement

    fun getRandomRepositoryName(): String {
        val randomPosition = (0 until repositoryList.size).random()
        return repositoryList[randomPosition].text
    }

    fun insertTextIntoFindRepositoryInput(text: String){
        findRepositoryInput.clear()
        findRepositoryInput.sendKeys(text)
    }

    fun refreshedRepositoryList(): List<WebElement> {
        wait.until(ExpectedConditions.stalenessOf(repositoryList.first()))
        return repositoryList
    }

    fun getResultRepositoryNames(resultList: List<WebElement>): List<String> =
        resultList.map { it.text }
}
