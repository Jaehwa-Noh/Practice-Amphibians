package com.example.myapplication

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.example.myapplication.ui.AmphibiansApp
import com.example.myapplication.ui.theme.MyApplicationTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AmphibiansAppScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun createAmphibiansAppScreen() {
        composeTestRule.setContent {
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