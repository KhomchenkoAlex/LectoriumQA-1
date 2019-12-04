import org.testng.Assert
import org.testng.annotations.Test
import page.PageManager.Pages.GITHUB_PAGE

class CustomRepositoryTest: BaseTest() {


    @Test
    fun checkAllElementsNumber() {
        navigationHelper.navigateTo(GITHUB_PAGE)
        userHelper.clickOnRepositoryLink()
        Assert.assertEquals(repositoryHelper.getAllElementsCount(), 7)
    }

    @Test
    fun checkFilesAndDirectoriesCount(){
        val filesCount = repositoryHelper.getFilesCount()
        val directoriesCount = repositoryHelper.getDirectoriesCount()
        val allElements = repositoryHelper.getAllElementsCount()
        Assert.assertEquals(directoriesCount, 2)
        Assert.assertEquals(filesCount, 5)
        Assert.assertEquals(allElements, (directoriesCount + filesCount))
    }
}