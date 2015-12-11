package com.geaden.android.builditbigger.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitial;

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
        // Show progress bar on Ad loading
        ProgressBar mProgressBar = (ProgressBar) findViewById(R.id.loader);
        mProgressBar.setVisibility(View.VISIBLE);
        mInterstitial = new InterstitialAd(this);
        mInterstitial.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitial.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                new JokeTellerAsyncTask().execute(MainActivity.this);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                new JokeTellerAsyncTask().execute(MainActivity.this);
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                /** Display interstitial ad */
                mInterstitial.show();
            }
        });
        AdRequest ar = new AdRequest.Builder().build();
        mInterstitial.loadAd(ar);
    }
}
