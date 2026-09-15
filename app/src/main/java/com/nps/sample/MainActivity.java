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
import com.nps.adiscope.model.AdiscopeUserType;
import com.nps.adiscope.offerwall.OfferwallAd;
import com.nps.adiscope.offerwall.OfferwallAdListener;
import com.nps.adiscope.reward.RewardItem;
import com.nps.adiscope.reward.RewardedVideoAd;
import com.nps.adiscope.reward.RewardedVideoAdListener;
import com.nps.adiscope.rewardedinterstitial.RewardedInterstitialAd;
import com.nps.adiscope.rewardedinterstitial.RewardedInterstitialAdShowListener;

/**
 * readme
 *   - admob rewarded video network
 *     - need to add meta-data (com.google.android.gms.ads.APPLICATION_ID) to AndroidManifest.xml
 *
 */
public class MainActivity extends Activity implements RewardedVideoAdListener, OfferwallAdListener, InterstitialAdListener, RewardedInterstitialAdShowListener {

    private static final String TAG = MainActivity.class.getName();

    private String SAMPLE_MEDIA_ID = "";
    private String SAMPLE_MEDIA_SECRET = "";
    private String SAMPLE_OFFERWALL_UNIT = "";
    private String SAMPLE_REWARDED_VIDEO_UNIT = "";
    private String SAMPLE_INTERSTITIAL_UNIT = "";
    private String[] SAMPLE_REWARDED_INTERSTITIAL_UNIT = {};

    private static OfferwallAd mOfferwallAd;
    private static RewardedVideoAd mRewardedVideoAd;
    private static InterstitialAd mInterstitialAd;
    private static RewardedInterstitialAd mRewardedInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set user info (unique user id, user type), recommended before initialize
        AdiscopeSdk.setUserIdChild("testUserId", getAdiscopeUserType(getUserAge()));

        // get singleton ad instances (SDK 5.5.0+: non-null even before initialize)
        mOfferwallAd = AdiscopeSdk.getOfferwallAdInstance(this);
        mRewardedVideoAd = AdiscopeSdk.getRewardedVideoAdInstance(this);
        mInterstitialAd = AdiscopeSdk.getInterstitialAdInstance(this);
        mRewardedInterstitialAd = AdiscopeSdk.getRewardedInterstitialAdInstance(this);

        // set listener before initialize to receive NOT_INITIALIZED fail callbacks
        mOfferwallAd.setOfferwallAdListener(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        mInterstitialAd.setInterstitialAdListener(this);
        mRewardedInterstitialAd.setRewardedInterstitialAdListener(this);

        // initialize adiscope sdk
        AdiscopeSdk.initialize(this, SAMPLE_MEDIA_ID, SAMPLE_MEDIA_SECRET, new AdiscopeInitializeListener() {
            @Override
            public void onInitialized(boolean isSuccess) {
                if (isSuccess) {
                    Log.d(TAG, "AdiscopeSdk initialized.");
                } else {
                    // Init 실패 시 initialize 재호출로 재시도 가능
                    Log.e(TAG, "AdiscopeSdk initialize failed.");
                }
            }
        });

        ((Button) findViewById(R.id.btnShowOfferwall)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // show offerwall

                String[] excludeType = new String[]{}; // excludeType List
                // ex) [CPI, CPE, CPS, CPA]
                mOfferwallAd.show(MainActivity.this, SAMPLE_OFFERWALL_UNIT, excludeType);
            }
        });

        ((Button) findViewById(R.id.btnLoadVideo)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // load rewarded video
                mRewardedVideoAd.load(SAMPLE_REWARDED_VIDEO_UNIT);
            }
        });

        ((Button) findViewById(R.id.btnLoadInterstitial)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // load interstitial
                mInterstitialAd.load(SAMPLE_INTERSTITIAL_UNIT);
            }
        });

        ((Button) findViewById(R.id.btnPreloadRewardedInterstitial)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // load rewarded interstitial
                mRewardedInterstitialAd.preloadUnit(SAMPLE_REWARDED_INTERSTITIAL_UNIT);
            }
        });

        ((Button) findViewById(R.id.btnPreloadAllRewardedInterstitial)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // load rewarded interstitial
                mRewardedInterstitialAd.preloadAll();
            }
        });

    }

    /**
     * 매체에서 수집하고 있는 유저의 만 나이를 반환
     * - 유저 나이를 알 수 없는 경우 null 반환
     */
    private Integer getUserAge() {
        return null; // TODO: 매체의 유저 정보(만 나이)로 교체
    }

    /**
     * 유저의 만 나이로 AdiscopeUserType 결정
     * - 만 13세 미만: Child (Google Play 가족 정책 준수를 위해 반드시 설정 필요)
     * - 만 13세 이상: Adult
     * - 나이를 알 수 없음: None
     */
    private static AdiscopeUserType getAdiscopeUserType(Integer age) {
        if (age == null) {
            return AdiscopeUserType.None;
        }
        return age < 13 ? AdiscopeUserType.Child : AdiscopeUserType.Adult;
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
        mRewardedVideoAd.load(SAMPLE_REWARDED_VIDEO_UNIT);
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
        mInterstitialAd.load(SAMPLE_INTERSTITIAL_UNIT);
    }

    @Override
    public void onInterstitialAdFailedToShow(String unitId, AdiscopeError adiscopeError) {
        Log.e(TAG, "onInterstitialAdFailedToShow : " + adiscopeError);
    }
    // endregion

    // region implementation RewardedInterstitialAdListener
    @Override
    public void onRewardedInterstitialAdLoaded(String unitId) {
        Log.d(TAG, "onRewardedInterstitialAdLoaded");
    }

    @Override
    public void onRewardedInterstitialAdFailedToLoad(String unitId, AdiscopeError adiscopeError) {
        Log.d(TAG, "onRewardedInterstitialAdFailedToShow : " + adiscopeError);
    }

    @Override
    public void onRewardedInterstitialAdSkipped(String unitId) {
        Log.d(TAG, "onRewardedInterstitialAdSkipped");
    }

    @Override
    public void onRewardedInterstitialAdOpened(String unitId) {
        Log.d(TAG, "onRewardedInterstitialAdOpened");
    }

    @Override
    public void onRewardedInterstitialAdClosed(String unitId) {
        Log.d(TAG, "onRewardedInterstitialAdClosed");
    }

    @Override
    public void onRewardedInterstitialAdRewarded(String unitId, RewardItem rewardItem) {
        Log.d(TAG, "onRewardedInterstitialAdRewarded");
    }

    @Override
    public void onRewardedInterstitialAdFailedToShow(String unitId, AdiscopeError adiscopeError) {
        Log.d(TAG, "onRewardedInterstitialAdFailedToShow : " + adiscopeError);
    }
    // endregion
}
