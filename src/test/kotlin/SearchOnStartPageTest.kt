import org.testng.Assert
import org.testng.annotations.Test

class SearchOnStartPageTest: BaseTest() {

    @Test
    fun countStarsValues() {
        searchHelper.searchOnLoginPage("java")
        val result = searchHelper.getStarsValues()
        result.forEach { println(it) }
        Assert.assertTrue(result.sum() == 96160)
    }

    @Test
    fun sortingResultNotEquals(){
        searchHelper.searchOnLoginPage("java")
        val sortByBestMatchResult = searchHelper.getResults()
        searchHelper.changeSorting()
        val sortByFewestStars = searchHelper.getNewResults()
        Assert.assertNotEquals(sortByBestMatchResult,sortByFewestStars)
    }

}