package com.geaden.android.builditbigger.app;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.geaden.android.jokeactivity.JokeActivity;
import com.geaden.jokes.JokeTeller;
import com.geaden.jokes.backend.jokesApi.JokesApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Async Task to pull jokes from backend.
 *
 * @author Gennady Denisov
 */
public class JokeTellerAsyncTask extends AsyncTask<Context, Void, String> {
    private static JokesApi jokeApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {
        if (jokeApiService == null) {
            JokesApi.Builder builder = new JokesApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver
            jokeApiService = builder.build();
        }
        context = params[0];
        JokeTeller jokeTeller = JokeTeller.getInstance(jokeApiService);
        return jokeTeller.getJoke();
    }

    @Override
    protected void onPostExecute(String aJoke) {
        super.onPostExecute(aJoke);
        // Launch JokeActivity
        Intent intent = new Intent(context, JokeActivity.class);
        Bundle extras = new Bundle();
        extras.putString(JokeActivity.JOKE_KEY, aJoke);
        intent.putExtras(extras);
        context.startActivity(intent);
    }
}
