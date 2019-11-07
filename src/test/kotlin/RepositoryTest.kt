import org.testng.Assert
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

class RepositoryTest: BaseTest() {

    @Test
    fun checkAllElementsNumber() {
        githubPage.clickOnRepositoryListElement()
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS)
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