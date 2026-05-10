package org.wikipedia.lesson26

import android.util.Log
import android.view.View
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.ViewInteraction
import com.kaspersky.kaspresso.interceptors.behavior.ViewBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.watcher.testcase.TestRunWatcherInterceptor
import com.kaspersky.kaspresso.interceptors.watcher.view.ViewActionWatcherInterceptor
import com.kaspersky.kaspresso.interceptors.watcher.view.ViewAssertionWatcherInterceptor
import com.kaspersky.kaspresso.testcases.models.info.TestInfo


class BeforeAfterLogBehaviorInterceptor : ViewBehaviorInterceptor {

    override fun <T> intercept(
        interaction: ViewInteraction,
        action: () -> T
    ): T {
        Log.i("KASPRESSO", "BEFORE ACTION")

        Log.i("KASPRESSO", "AFTER ACTION")
        throw AssertionError()
    }
}

class MyViewActionWatcherInterceptor : ViewActionWatcherInterceptor {

    override fun intercept(viewAction: ViewAction, view: View) {
        Log.i("KASPRESSO", "Description : ${viewAction.description}")
    }
}

class MyViewAssertionWatcherInterceptor : ViewAssertionWatcherInterceptor {
    override fun intercept(
        viewAssertion: ViewAssertion,
        view: View?,
        exception: NoMatchingViewException?
    ) {
        Log.i("KASPRESSO", "Assertion : CUSTOM INTERCEPTOR")
        if (exception != null) {
            Log.e("KASPRESSO", "Assertion : ${exception.message}")
        }
    }

}

class TimeInterceptor : ViewBehaviorInterceptor {
    override fun <T> intercept(
        interaction: ViewInteraction,
        action: () -> T
    ): T {
        val startTime = System.nanoTime()
        return action().also {
            val finishTime = System.nanoTime()
            Log.i("KASPRESSO", "${finishTime - startTime}")
        }
    }
}

class CustomTestRunWatcherInterceptor : TestRunWatcherInterceptor {

    override fun onTestStarted(testInfo: TestInfo) {
        Log.i("KASPRESSO", "TEST STARTED")
    }

    override fun onBeforeSectionStarted(testInfo: TestInfo) {
        Log.i("KASPRESSO", "ON BEFORE SECTION STARTED")
    }

    override fun onBeforeSectionFinishedSuccess(testInfo: TestInfo) {
        Log.i("KASPRESSO", "ON BEFORE SECTION FINISHED SUCCESS")
    }

    override fun onMainSectionStarted(testInfo: TestInfo) {
        Log.i("KASPRESSO", "IN MAIN SECTION STARTED")
    }

    override fun onMainSectionFinishedSuccess(testInfo: TestInfo) {
        Log.i("KASPRESSO", "ON MAIN SECTION FINISHED SUCCESS")
    }

    override fun onAfterSectionStarted(testInfo: TestInfo) {
        Log.i("KASPRESSO", "IN AFTER SECTION STARTED")
    }

    override fun onAfterSectionFinishedSuccess(testInfo: TestInfo) {
        Log.i("KASPRESSO", "ON AFTER SECTION FINISHED SUCCESS")
    }

    override fun onTestFinished(testInfo: TestInfo, success: Boolean) {
        Log.i("KASPRESSO", "TEST FINISHED")
    }
}