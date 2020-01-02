package helper

import manager.AppManager
import org.openqa.selenium.By
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

    fun isResultsContainsText(text: String) = searchResultPage.isResultsContainsText(text)

    fun getStarsValues(): MutableList<Int> {
        val stars = searchResultPage.getStarsValues()
        val starsValuesList = mutableListOf<Int>()
        stars.forEach { webElement ->
            webElement.text.let {
                if (it.contains("k")) {
                    val value = it.substringBefore("k").trim().replaceFirst(".","")
                    starsValuesList.add(value.toInt()*100)
                } else {
                    starsValuesList.add(it.trim().toInt())
                }
            }
        }
        return starsValuesList
    }

    fun getElementValue(text: String): Int {
        AppManager.implicitlyWait(2)
        val element = driver.findElement(By.xpath("//a[contains(.,'$text')]/span"))
        return element.text.replaceFirst(",","").toInt()
    }
}