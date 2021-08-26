package com.example.androidassignment

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4::class)
class InstrumentedTest {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testLoginUI(){
        Espresso.onView(withId(R.id.etemail))
            .perform(ViewActions.typeText("sandy@gmail.com"))
        Espresso.onView(withId(R.id.etpassword))
            .perform(ViewActions.typeText("ujjwal"))
        Espresso.closeSoftKeyboard()

        Espresso.onView(withId(R.id.btnLogin))
            .perform(ViewActions.click())
        Thread.sleep(4000)
        Espresso.onView(withId(R.id.dashcontainer))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
