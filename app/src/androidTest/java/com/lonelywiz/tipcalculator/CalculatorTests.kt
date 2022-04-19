package com.lonelywiz.tipcalculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.Matchers.containsString


@RunWith(AndroidJUnit4::class)
class CalculatorTests {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun calculate_20_percent_tip() {
        onView(withId(R.id.costofservice)).perform(typeText("50.00")).perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.amazing)).perform(click())
        onView(withId(R.id.Calculate)).perform(click())
        onView(withId(R.id.Result)).check(matches(withText(containsString("10"))))
    }
}