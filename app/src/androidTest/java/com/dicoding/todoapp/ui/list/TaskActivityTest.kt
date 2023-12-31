package com.dicoding.todoapp.ui.list

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.dicoding.todoapp.R
import com.dicoding.todoapp.ui.add.AddTaskActivity
import org.junit.After

//TODO 16 : Write UI test to validate when user tap Add Task (+), the AddTaskActivity displayed
@RunWith(AndroidJUnit4::class)
class TaskActivityTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(TaskActivity::class.java)

    @Before
    fun setup(){
        Intents.init()
    }

    @Test
    fun whenUserClickAddTaskButton_ShouldDisplayAddTaskActiviy() {
        Espresso.onView(ViewMatchers.withId(R.id.fab)).perform(click())

        intended(IntentMatchers.hasComponent(AddTaskActivity::class.java.name))
    }

    @After
    fun tearDown() {
        Intents.release()
    }
}