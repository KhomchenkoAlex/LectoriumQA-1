import org.testng.Assert
import org.testng.annotations.Test
import page.PageManager.Pages.GITHUB_PAGE

class RepositoriesTest: BaseTest() {

    @Test
    fun repositoryTest() {
        navigationHelper.navigateTo(GITHUB_PAGE)
        navigationHelper.goToYourRepositories()
        Assert.assertTrue(getCurrentUrl().contains("repositories", ignoreCase = true))
        Assert.assertTrue(repositoryHelper.getUserRepositoriesList().isNotEmpty())
    }

    @Test
    fun repositoryFindTest() {
        val searchText = repositoryHelper.getTextForSearch()
        repositoryHelper.insertTextToSearchField(searchText)
        val resultList = repositoryHelper.getSearchResults()
        val names = repositoryHelper.getRepositoriesNameList(resultList)
        Assert.assertTrue(resultList.isNotEmpty())
        Assert.assertTrue(names.all { it.contains(searchText, ignoreCase = true) })
    }

    @Test
    fun createNewRepositoryTest(){
        navigationHelper.navigateTo(GITHUB_PAGE)
        repositoryHelper.createNewRepository("Test")
        navigationHelper.goToYourRepositories()
        val repoNames = repositoryHelper.getAllRepositoryNamesList()
        Assert.assertTrue(repoNames.contains("Test"))
    }

}