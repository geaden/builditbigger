package com.geaden.jokes;

import com.geaden.jokes.backend.jokesApi.JokesApi;
import com.geaden.jokes.backend.jokesApi.model.JokeBean;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Tests Joke Teller.
 *
 * @author Gennady Denisov
 */
@RunWith(MockitoJUnitRunner.class)
public class JokeTellerTest {
    @Mock
    private JokesApi mockJokesApi;

    @Mock
    private JokesApi.TellJoke tellJoke;

    @Before
    public void setUp() throws Exception {
        when(mockJokesApi.tellJoke()).thenReturn(tellJoke);
        when(tellJoke.execute()).thenReturn(new JokeBean().setData("foo bar"));
    }

    @Test
    public void testGetJoke() throws Exception {
        JokeTeller jokeTeller = JokeTeller.getInstance(mockJokesApi);
        assertEquals(jokeTeller.getJoke(), "foo bar");
    }
}