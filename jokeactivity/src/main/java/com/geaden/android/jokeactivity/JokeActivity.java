package com.geaden.android.jokeactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Activity that shows a joke.
 *
 * @author Gennady Denisov
 */
public class JokeActivity extends AppCompatActivity {
    public static final String JOKE_KEY = "joke_key";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        Bundle extras = getIntent().getExtras();
        if (savedInstanceState == null && extras != null) {
            // Pass joke to a fragment.
            Fragment fragment = JokeActivityFragment.getInstance(extras.getString(JOKE_KEY));
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_joke, fragment)
                    .commit();
        }
    }
}
