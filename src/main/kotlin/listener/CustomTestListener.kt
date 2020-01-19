package listener

import manager.AppManager
import org.testng.ITestContext
import org.testng.ITestListener
import org.testng.ITestResult

class CustomTestListener: ITestListener {
    override fun onFinish(context: ITestContext?) {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTestSkipped(result: ITestResult?) {
      //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTestSuccess(result: ITestResult?) {
        println("onTestSuccess")
      //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTestFailure(result: ITestResult?) {
        println("OnTestFailure")
        AppManager.takeScreenshot()
      //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTestFailedButWithinSuccessPercentage(result: ITestResult?) {
      //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTestStart(result: ITestResult?) {
        println("onTestStart")
      //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStart(context: ITestContext?) {
        println("onStart")
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}