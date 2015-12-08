package com.geaden.jokes;

import com.geaden.jokes.backend.jokesApi.JokesApi;

import java.io.IOException;

/**
 * Basic class that tells jokes.
 */
public class JokeTeller {

    /**
     * Prevent explicit instantiation of Joke Teller
     */
    private JokeTeller(JokesApi jokesApi) {
        this.jokesApi = jokesApi;
    }

    private static JokeTeller sInstance;
    private JokesApi jokesApi;

    /**
     * Joke Teller singleton to prevent redundant instances.
     *
     * @param jokesApi API to get jokes from.
     * @return instance of {@link JokeTeller}
     */
    public static JokeTeller getInstance(JokesApi jokesApi) {
        if (sInstance == null) {
            sInstance = new JokeTeller(jokesApi);
        }
        return sInstance;
    }

    /**
     * Get random joke.
     *
     * @return a joke.
     */
    public String getJoke() {
        try {
            return jokesApi.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getLocalizedMessage();
        }
    }
}
