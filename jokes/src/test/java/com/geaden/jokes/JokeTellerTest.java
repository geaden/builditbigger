package com.geaden.jokes;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Tests Joke Teller.
 *
 * @author Gennady Denisov
 */
public class JokeTellerTest {

    @Test
    public void testGetJoke() throws Exception {
        JokeTeller jokeTeller = JokeTeller.getInstance();
        assertTrue(jokeTeller.getJoke().length() != 0);
    }
}