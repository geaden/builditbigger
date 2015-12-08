package com.geaden.android.builditbigger.tests;

import android.test.AndroidTestCase;

import com.geaden.android.builditbigger.app.JokeTellerAsyncTask;

/**
 * Tests calling Joke Teller Async Task.
 *
 * @author Gennady Denisov
 */
public class JokeTellerAsyncTaskTest  extends AndroidTestCase{
    public void testVerifyRetrievedNonEmptyJoke() throws Exception {
        JokeTellerAsyncTask task = new JokeTellerAsyncTask();
        task.execute(getContext());
        String data = task.get();
        assertTrue(data.length() != 0);
    }
}
