/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.geaden.jokes.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

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

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "tellJoke", path = "joke", httpMethod = "GET")
    public JokeBean tellJoke() {
        JokeBean response = new JokeBean();
        response.setJoke("To understand what recursion is, you must first understand recursion.");
        return response;
    }
}
