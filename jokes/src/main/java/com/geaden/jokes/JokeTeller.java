package com.geaden.jokes;

/**
 * Basic class that tells jokes.
 */
public class JokeTeller {

    /** Prevent explicit instantiation of Joke Teller */
    private JokeTeller() {
    }

    private static JokeTeller sInstance;

    /**
     * Joke Teller singleton to prevent redundant instances.
     *
     * @return instance of {@link JokeTeller}
     */
    public static JokeTeller getInstance() {
        if (sInstance == null) {
            sInstance = new JokeTeller();
        }
        return sInstance;
    }

    /**
     * Get random joke.
     *
     * @return a joke.
     */
    public String getJoke() {
        return "To understand what recursion is, you must first understand recursion.";
    }
}
