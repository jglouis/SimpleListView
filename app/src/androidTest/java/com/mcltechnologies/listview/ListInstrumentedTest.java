package com.mcltechnologies.listview;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.IsAnything.anything;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ListInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void selectSecondItem() {
        onData(anything()).inAdapterView(withId(R.id.list_view)).atPosition(1).perform(click());

        onData(anything()).inAdapterView(withId(R.id.list_view)).atPosition(1).check(matches(new BaseMatcher<View>() {
            @Override
            public boolean matches(Object item) {
                return ((CustomListItem) item).isChecked();
            }

            @Override
            public void describeMismatch(Object item, Description mismatchDescription) {
                mismatchDescription.appendText("Item is not checked");
            }

            @Override
            public void describeTo(Description description) {

            }
        }));
// does not work because Android does not ship java.beans.Introspector...
//        onData(anything()).inAdapterView(withId(R.id.list_view)).atPosition(1).check(matches(hasProperty("check", equalTo(true))));
    }
}
