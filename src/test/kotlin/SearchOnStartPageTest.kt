import org.testng.Assert
import org.testng.annotations.Test

class SearchOnStartPageTest: BaseTest() {

    @Test
    fun countStarsValues() {
        searchHelper.searchOnLoginPage("java")
        val result = searchHelper.getStarsValues()
        result.forEach { println(it) }
        println(result.sum())
        Assert.assertTrue(result.sum() > 0)
    }

    @Test
    fun foundByText() {
        val result = searchHelper.getElementValue("Java")
        println(result)
        Assert.assertTrue(result > 0)
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