package com.nps.sample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.nps.adiscope.AdiscopeError;
import com.nps.adiscope.AdiscopeSdk;
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
public class MainActivity extends Activity implements RewardedVideoAdListener, OfferwallAdListener {

    private static final String TAG = MainActivity.class.getName();

    private String SAMPLE_MEDIA_ID              = "";
    private String SAMPLE_MEDIA_SECRET          = "";
    private String SAMPLE_OFFERWALL_UNIT        = "";
    private String SAMPLE_REWARDED_VIDEO_UNIT   = "";

    private static OfferwallAd mOfferwallAd;
    private static RewardedVideoAd mRewardedVideoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize adiscope sdk
        AdiscopeSdk.initialize(this, SAMPLE_MEDIA_ID, SAMPLE_MEDIA_SECRET);

        // get offerwall singleton instance
        mOfferwallAd = AdiscopeSdk.getOfferwallAdInstance(this);

        // get rewardVideo singleton instance
        mRewardedVideoAd = AdiscopeSdk.getRewardedVideoAdInstance(this);

        // set listener
        mOfferwallAd.setOfferwallAdListener(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);

        // set userId (user unique id)
        AdiscopeSdk.setUserId("testUserId");

        ((Button)findViewById(R.id.btnShowOfferwall)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // show offerwall
                mOfferwallAd.show(MainActivity.this, SAMPLE_OFFERWALL_UNIT);
            }
        });

        ((Button)findViewById(R.id.btnLoadVideo)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // load rewarded video
                mRewardedVideoAd.load(SAMPLE_REWARDED_VIDEO_UNIT);
            }
        });

    }

    // region implementation RewardedVideoAdListener
    @Override
    public void onRewardedVideoAdLoaded() {
        Log.d(TAG, "onRewardedVideoAdLoaded");
        mRewardedVideoAd.show();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(AdiscopeError adiscopeError) {
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
}
