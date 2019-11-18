package helper

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import page.PageManager

class RepositoryHelper(driver: WebDriver): PageManager(driver) {

    fun getTextForSearch() = userRepositoryPage.getRandomRepositoryName().slice(0..1)
    
    fun insertTextToSearchField(text: String) = userRepositoryPage.insertTextIntoFindRepositoryInput(text)

    fun getSearchResults(): List<WebElement> = userRepositoryPage.refreshedRepositoryList()

    fun getRepositoriesNameList(resultList: List<WebElement>): List<String> =
        userRepositoryPage.getResultRepositoryNames(resultList)
}