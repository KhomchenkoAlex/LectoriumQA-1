import extension.waitForPageLoad
import org.testng.Assert
import org.testng.annotations.Test

class RepositoryTest: BaseTest() {

    @Test
    fun checkAllElementsNumber() {
        githubPage.clickOnRepositoryListElement()
        driver.waitForPageLoad(2)
        Assert.assertEquals(repoPage.getAllRepositoryElementsNumber(), 7)
    }

    @Test
    fun checkFilesNumber(){
        Assert.assertEquals(repoPage.getFileElementsNumber(), 5)
    }

    @Test
    fun checkDirectoriesNumber(){
        Assert.assertTrue(repoPage.getDirectoryElementsNumber()==2)
    }

}