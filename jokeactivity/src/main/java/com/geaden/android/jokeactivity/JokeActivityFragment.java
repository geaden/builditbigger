package com.geaden.android.jokeactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A fragment that shows a passed joke.
 *
 * @author Gennady Denisov
 */
public class JokeActivityFragment extends Fragment {
    public JokeActivityFragment() {

    }

    /**
     * Gets instance of a fragment with a joke as argument.
     *
     * @param aJoke passed joke.
     * @return instance of a fragment.
     */
    public static Fragment getInstance(String aJoke) {
        Fragment fragment = new JokeActivityFragment();
        Bundle extras = new Bundle();
        extras.putString(JokeActivity.JOKE_KEY, aJoke);
        fragment.setArguments(extras);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke, container, false);
        TextView jokeTextView = (TextView) rootView.findViewById(R.id.joke_text_view);
        Bundle args = getArguments();
        String aJoke = args.getString(JokeActivity.JOKE_KEY);
        jokeTextView.setText(aJoke);
        return rootView;
    }
}
