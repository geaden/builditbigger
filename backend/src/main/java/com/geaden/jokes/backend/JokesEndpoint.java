/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.geaden.jokes.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.Random;

/** An endpoint class we are exposing */
@Api(
  name = "jokesApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.jokes.geaden.com",
    ownerName = "backend.jokes.geaden.com",
    packagePath=""
  )
)
public class JokesEndpoint {

    private final String[] JOKES = {
        "To understand what recursion is, you must first understand recursion.",
        "There are 10 kinds of people in the world: Those that know binary & those that don’t.",
        "Unix is user friendly. It’s just very particular about who its friends are."
    };

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "tellJoke", path = "joke", httpMethod = "GET")
    public JokeBean tellJoke() {
        JokeBean response = new JokeBean();
        int i = new Random().nextInt(JOKES.length);
        response.setData(JOKES[i]);
        return response;
    }
}
