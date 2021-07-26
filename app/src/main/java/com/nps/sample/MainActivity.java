package com.nps.sample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.nps.adiscope.AdiscopeError;
import com.nps.adiscope.AdiscopeSdk;
import com.nps.adiscope.interstitial.InterstitialAd;
import com.nps.adiscope.interstitial.InterstitialAdListener;
import com.nps.adiscope.listener.AdiscopeInitializeListener;
import com.nps.adiscope.offerwall.OfferwallAd;
import com.nps.adiscope.offerwall.OfferwallAdListener;
import com.nps.adiscope.reward.RewardItem;
import com.nps.adiscope.reward.RewardedVideoAd;
import com.nps.adiscope.reward.RewardedVideoAdListener;

/**
 * readme
 *   - admob rewarded video network
 *     - need to add meta-data (com.google.android.gms.ads.APPLICATION_ID) to AndroidManifest.xml
 *
 *   - fan rewarded video network
 *     - need to register test device id to facebook admin
 *
 */
public class MainActivity extends Activity implements RewardedVideoAdListener, OfferwallAdListener, InterstitialAdListener {

    private static final String TAG = MainActivity.class.getName();

    private String SAMPLE_MEDIA_ID              = "";
    private String SAMPLE_MEDIA_SECRET          = "";
    private String SAMPLE_OFFERWALL_UNIT        = "";
    private String SAMPLE_REWARDED_VIDEO_UNIT   = "";
    private String SAMPLE_INTERSTITIAL_UNIT     = "";

    private static OfferwallAd mOfferwallAd;
    private static RewardedVideoAd mRewardedVideoAd;
    private static InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize adiscope sdk
        AdiscopeSdk.initialize(this, SAMPLE_MEDIA_ID, SAMPLE_MEDIA_SECRET, new AdiscopeInitializeListener() {
            @Override
            public void onInitialized(boolean isSuccess) {
                if (isSuccess) {
                    // get offerwall singleton instance
                    mOfferwallAd = AdiscopeSdk.getOfferwallAdInstance(MainActivity.this);

                    // get rewardVideo singleton instance
                    mRewardedVideoAd = AdiscopeSdk.getRewardedVideoAdInstance(MainActivity.this);

                    // get interstitial singleton instance
                    mInterstitialAd = AdiscopeSdk.getInterstitialAdInstance(MainActivity.this);

                    // set listener
                    mOfferwallAd.setOfferwallAdListener(MainActivity.this);
                    mRewardedVideoAd.setRewardedVideoAdListener(MainActivity.this);
                    mInterstitialAd.setInterstitialAdListener(MainActivity.this);
                }
            }
        });

        // set userId (user unique id)
        AdiscopeSdk.setUserId("testUserId");

        ((Button)findViewById(R.id.btnShowOfferwall)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // show offerwall

                String[] excludeType = new String[]{}; // excludeType List
                // ex) [CPI, CPE, CPS, CPA]
                mOfferwallAd.show(MainActivity.this, SAMPLE_OFFERWALL_UNIT, excludeType);
            }
        });

        ((Button)findViewById(R.id.btnLoadVideo)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // load rewarded video
                mRewardedVideoAd.load(SAMPLE_REWARDED_VIDEO_UNIT);
            }
        });

        ((Button)findViewById(R.id.btnLoadInterstitial)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // load interstitial
                mInterstitialAd.load(SAMPLE_INTERSTITIAL_UNIT);
            }
        });

    }

    // region implementation RewardedVideoAdListener
    @Override
    public void onRewardedVideoAdLoaded(String unitId) {
        Log.d(TAG, "onRewardedVideoAdLoaded");
        mRewardedVideoAd.show();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(String unitId, AdiscopeError adiscopeError) {
        Log.e(TAG, "onRewardedVideoAdFailedToLoad : " + adiscopeError);
    }

    @Override
    public void onRewardedVideoAdOpened(String unitId) {
        Log.d(TAG, "onRewardedVideoAdOpened");

    }

    @Override
    public void onRewardedVideoAdClosed(String unitId) {
        Log.d(TAG, "onRewardedVideoAdClosed");

    }

    @Override
    public void onRewarded(String unitId, RewardItem rewardItem) {
        Log.d(TAG, "onRewarded");

    }

    @Override
    public void onRewardedVideoAdFailedToShow(String unitId, AdiscopeError adiscopeError) {
        Log.e(TAG, "onRewardedVideoAdFailedToLoad : " + adiscopeError);

    }
    // endregion

    // region implementation OfferwallAdListener
    @Override
    public void onOfferwallAdOpened(String unitId) {
        Log.d(TAG, "onOfferwallAdOpened");

    }

    @Override
    public void onOfferwallAdFailedToShow(String unitId, AdiscopeError adiscopeError) {
        Log.e(TAG, "onRewardedVideoAdFailedToLoad : " + adiscopeError);
    }

    @Override
    public void onOfferwallAdClosed(String unitId) {
        Log.d(TAG, "onOfferwallAdClosed");

    }
    // endregion

    // region implementation InterstitialAdListener
    @Override
    public void onInterstitialAdLoaded() {
        Log.d(TAG, "onInterstitialAdLoaded");
        mInterstitialAd.show();
    }

    @Override
    public void onInterstitialAdFailedToLoad(AdiscopeError adiscopeError) {
        Log.e(TAG, "onInterstitialAdFailedToLoad : " + adiscopeError);
    }

    @Override
    public void onInterstitialAdOpened(String unitId) {
        Log.d(TAG, "onInterstitialAdOpened");
    }

    @Override
    public void onInterstitialAdClosed(String unitId) {
        Log.d(TAG, "onInterstitialAdClosed");
    }

    @Override
    public void onInterstitialAdFailedToShow(String unitId, AdiscopeError adiscopeError) {
        Log.e(TAG, "onInterstitialAdFailedToShow : " + adiscopeError);
    }
    // endregion
}
