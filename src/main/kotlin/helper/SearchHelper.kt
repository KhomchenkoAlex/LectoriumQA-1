package helper

import org.openqa.selenium.WebDriver
import page.PageManager

class SearchHelper(driver: WebDriver): PageManager(driver){

    fun searchOnLoginPage(text: String){
        loginPage.inputToSearchField(text)
        loginPage.clickOnAllGitHubButton()
    }

    fun changeSorting(){
        searchResultPage.clickOnSortButton()
        searchResultPage.clickOnFewestStars()
    }

    fun getResults(): List<String> = searchResultPage.getRepositoryNames()

    fun getNewResults(): List<String> {
        searchResultPage.waitForRefresh()
        return searchResultPage.getRepositoryNames()
    }
}