package com.geaden.android.builditbigger.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.geaden.android.jokeactivity.JokeActivity;
import com.geaden.jokes.JokeTeller;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Launches activity with a joke content.
     *
     * @param view the view method invoked from.
     */
    public void tellJoke(View view) {
        JokeTeller jokeTeller = JokeTeller.getInstance();
        String aJoke = jokeTeller.getJoke();
        Intent intent = new Intent(this, JokeActivity.class);
        Bundle extras = new Bundle();
        extras.putString(JokeActivity.JOKE_KEY, aJoke);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
