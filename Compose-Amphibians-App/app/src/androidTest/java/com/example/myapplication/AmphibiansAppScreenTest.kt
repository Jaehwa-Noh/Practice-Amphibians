package com.example.myapplication

import androidx.activity.compose.setContent
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.example.myapplication.ui.AmphibiansApp
import com.example.myapplication.ui.theme.MyApplicationTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class AmphibiansAppScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var composeTestRule =
        createAndroidComposeRule<MainActivity>()

    @Before
    fun createAmphibiansAppScreen() {
        hiltRule.inject()
        composeTestRule.activity.setContent {
            MyApplicationTheme {
                AmphibiansApp()
            }
        }
    }

    @Test
    fun loadingScreen_Loading_ProgressDisplaySuccess() {
        val progressBar = composeTestRule.onNodeWithTag("Progress")
        progressBar.assertIsDisplayed()
    }

    @Test
    fun amphibiansListScreen_LoadList_AmphibiansListDisplaySuccess() {
        navigateAmphibiansList()
        val greatBasin = composeTestRule.onNodeWithText(
            "Great Basin",
            substring = true
        )
        greatBasin.assertExists()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun amphibiansListScreen_LoadImage_ImageDisplaySuccess() {
        navigateAmphibiansList()
        val greatBasin = composeTestRule.onNodeWithText(
            "Great Basin",
            substring = true
        )
        greatBasin.assertExists()

        composeTestRule.waitUntilExactlyOneExists(
            hasTestTag("Great Basin Spadefoot"), 100_000
        )
    }


    @OptIn(ExperimentalTestApi::class)
    private fun navigateAmphibiansList() {
        composeTestRule.waitUntilDoesNotExist(
            hasTestTag("Progress"), 100_000
        )
    }
}