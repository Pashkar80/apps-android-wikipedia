package org.wikipedia.lesson11

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.lesson8.hometask.ExplorerScreen
import org.wikipedia.lesson8.hometask.FuturedArticleItem
import org.wikipedia.lesson8.hometask.OnboardingScreen
import org.wikipedia.main.MainActivity
import java.util.Locale.ENGLISH
import java.util.Locale.GERMAN

class AdbTests : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkAdb() {
        adbServer.performShell(
            command = "echo", arguments = listOf(
                "Hello from Kaspresso", ">", "/sdcard/kaspresso_test.txt"
            )
        )
    }

    @Test
    fun preAndPostScenario() {
        before("Название теста") {
            device.network.toggleMobileData(false)
            device.network.toggleWiFi(false)
        }.after {
            device.network.toggleMobileData(true)
            device.network.toggleWiFi(true)
        }.run {
            OnboardingScreen.skipButton.isDisplayed()
        }
    }

    @Test
    fun orientation() {
        run("Verify screen orientation after move right") {
            device.uiDevice.setOrientationRight()
            Thread.sleep(3000)
            assertFalse(device.uiDevice.isNaturalOrientation)
            device.uiDevice.setOrientationNatural()
            Thread.sleep(3000)
            assertTrue(device.uiDevice.isNaturalOrientation)
        }
    }

    @Test
    fun switchOfAndOnPhoneScreen() {
        run("Verify is element displayed after phone wake up") {
            device.uiDevice.apply {
                sleep()
                wakeUp()
            }
            OnboardingScreen.skipButton.isDisplayed()
        }
    }

    @Test
    fun collapseApp() {
        run("Collapse the app and verify result") {
            device.uiDevice.apply {
                pressHome()
                repeat(2) {
                    pressRecentApps()
                }
            }
            OnboardingScreen.skipButton.isDisplayed()
        }
    }

    @Test
    fun verifyWorkAppWithoutNet() {
        before() {
            adbServer.performAdb("shell svc data disable")
            adbServer.performAdb("shell svc wifi disable")
        }.after() {
            adbServer.performAdb("shell svc data enable")
            adbServer.performAdb("shell svc wifi enable")
        }.run {
            Thread.sleep(20000)
            OnboardingScreen.skipButton.click()
            ExplorerScreen.apply {
                retryButton.isDisplayed()
                offlineCardText.isDisplayed()
            }
            adbServer.performAdb("shell svc data enable")
            adbServer.performAdb("shell svc wifi enable")
            ExplorerScreen.apply {
                retryButton.click()
                Thread.sleep(5000)
                item.childWith<FuturedArticleItem> {
                    isInstanceOf(FeaturedArticleCardView::class.java)
                } perform {
                    header.isDisplayed()
                }
            }
        }
    }

    @Test
    fun changeLanguage() {
        before {
            device.language.switchInApp(GERMAN)
        }.after {
            device.language.switchInApp(ENGLISH)
        }.run {
            OnboardingScreen.skipButton.hasText("Überspringen")
        }
    }

    @Test
    fun mainActivity() {
        run {
            OnboardingScreen.skipButton.click()
            device.activities.isCurrent(MainActivity::class.java)
        }
    }
}
