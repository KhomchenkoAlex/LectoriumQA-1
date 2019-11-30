import org.testng.Assert
import org.testng.annotations.Test

class SearchOnStartPageTest: BaseTest() {

    @Test
    fun sortingResultNotEquals(){
        searchHelper.searchOnLoginPage("java")
        val sortByBestMatchResult = searchHelper.getResults()
        searchHelper.changeSorting()
        val sortByFewestStars = searchHelper.getNewResults()
        Assert.assertNotEquals(sortByBestMatchResult,sortByFewestStars)
    }
}