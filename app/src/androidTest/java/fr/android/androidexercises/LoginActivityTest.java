package fr.android.androidexercises;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {

    // TODO test login activity with Espresso
    @Rule
    public ActivityTestRule<LoginActivity> activityRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);

    @Test
    public void logged() throws Exception{
        //WHEN
        onView(withId(R.id.usernameEdit)).perform(typeText("elisa"));
        onView(withId(R.id.passwordEdit)).perform(typeText("zaza")).perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.loginButton)).perform(click());

        //THEN
        onView(withId(R.id.loggedText)).check(matches(isDisplayed()));
    }

}