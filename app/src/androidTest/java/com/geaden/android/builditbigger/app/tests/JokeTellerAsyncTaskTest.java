package com.geaden.android.builditbigger.app.tests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import com.geaden.android.builditbigger.app.JokeTellerAsyncTask;
import com.geaden.android.builditbigger.app.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests calling Joke Teller Async Task.
 *
 * @author Gennady Denisov
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class JokeTellerAsyncTaskTest extends AndroidTestCase {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testVerifyRetrievedNonEmptyJoke() throws Exception {
        JokeTellerAsyncTask task = new JokeTellerAsyncTask();
        task.execute(mActivityRule.getActivity());
        String data = task.get();
        assertTrue(data.length() != 0);
    }
}
