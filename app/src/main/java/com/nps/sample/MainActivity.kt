package com.nps.sample

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.nps.adiscope.AdiscopeError
import com.nps.adiscope.AdiscopeSdk
import com.nps.adiscope.interstitial.InterstitialAd
import com.nps.adiscope.interstitial.InterstitialAdListener
import com.nps.adiscope.offerwall.OfferwallAd
import com.nps.adiscope.offerwall.OfferwallAdListener
import com.nps.adiscope.reward.RewardItem
import com.nps.adiscope.reward.RewardedVideoAd
import com.nps.adiscope.reward.RewardedVideoAdListener

class MainActivity : Activity(), RewardedVideoAdListener, OfferwallAdListener, InterstitialAdListener {
    private val TAG = MainActivity::class.java.name

    private val SAMPLE_MEDIA_ID = "215"
    private val SAMPLE_MEDIA_SECRET = "77d1c135490f42adb89f0ed0e14f00b2"
    private val SAMPLE_OFFERWALL_UNIT = ""
    private val SAMPLE_REWARDED_VIDEO_UNIT = "MC_RV"
    private val SAMPLE_INTERSTITIAL_UNIT = ""

    private var mOfferwallAd: OfferwallAd? = null
    private var mRewardedVideoAd: RewardedVideoAd? = null
    private var mInterstitialAd: InterstitialAd? = null

    private var offerwallBtn: Button? = null
    private var rvBtn: Button? = null
    private var interstitialBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        offerwallBtn = findViewById(R.id.btnShowOfferwall)
        rvBtn = findViewById(R.id.btnLoadVideo)
        interstitialBtn = findViewById(R.id.btnLoadInterstitial)

        // initialize adiscope sdk
        AdiscopeSdk.initialize(
            this@MainActivity, SAMPLE_MEDIA_ID, SAMPLE_MEDIA_SECRET
        ) { isSuccess ->
            if (isSuccess) {
                // get offerwall singleton instance
                mOfferwallAd = AdiscopeSdk.getOfferwallAdInstance(this@MainActivity)

                // get rewardVideo singleton instance
                mRewardedVideoAd = AdiscopeSdk.getRewardedVideoAdInstance(this@MainActivity)

                // get interstitial singleton instance
                mInterstitialAd = AdiscopeSdk.getInterstitialAdInstance(this@MainActivity)

                // set listener
                mOfferwallAd?.setOfferwallAdListener(this@MainActivity)
                mRewardedVideoAd?.setRewardedVideoAdListener(this@MainActivity)
                mInterstitialAd?.setInterstitialAdListener(this@MainActivity)
                offerwallBtn?.isEnabled = true
                rvBtn?.isEnabled = true
                interstitialBtn?.isEnabled = true
            } else {
                // Init 실패 에 대한 처리 Code
            }
        }

        // set userId (user unique id)
        AdiscopeSdk.setUserId("testUserId")
        offerwallBtn?.setOnClickListener(View.OnClickListener { // show offerwall
            val excludeType = arrayOf<String>() // excludeType List
            // ex) [CPI, CPE, CPS, CPA]
            mOfferwallAd?.show(this@MainActivity, SAMPLE_OFFERWALL_UNIT, excludeType)
        })
        rvBtn?.setOnClickListener(View.OnClickListener { // load rewarded video
            mRewardedVideoAd?.load(SAMPLE_REWARDED_VIDEO_UNIT)
        })
        interstitialBtn?.setOnClickListener(View.OnClickListener { // load interstitial
            mInterstitialAd?.load(SAMPLE_INTERSTITIAL_UNIT)
        })
    }

    // region implementation RewardedVideoAdListener
    override fun onRewardedVideoAdLoaded(unitId: String?) {
        Log.d(TAG, "onRewardedVideoAdLoaded")
        mRewardedVideoAd!!.show()
    }

    override fun onRewardedVideoAdFailedToLoad(unitId: String?, adiscopeError: AdiscopeError) {
        Log.e(TAG, "onRewardedVideoAdFailedToLoad : $adiscopeError")
    }

    override fun onRewardedVideoAdOpened(unitId: String?) {
        Log.d(TAG, "onRewardedVideoAdOpened")
    }

    override fun onRewardedVideoAdClosed(unitId: String?) {
        Log.d(TAG, "onRewardedVideoAdClosed")
    }

    override fun onRewarded(unitId: String?, rewardItem: RewardItem?) {
        Log.d(TAG, "onRewarded")
    }

    override fun onRewardedVideoAdFailedToShow(unitId: String?, adiscopeError: AdiscopeError) {
        Log.e(TAG, "onRewardedVideoAdFailedToLoad : $adiscopeError")
    }
    // endregion

    // endregion
    // region implementation OfferwallAdListener
    override fun onOfferwallAdOpened(unitId: String?) {
        Log.d(TAG, "onOfferwallAdOpened")
    }

    override fun onOfferwallAdFailedToShow(unitId: String?, adiscopeError: AdiscopeError) {
        Log.e(TAG, "onRewardedVideoAdFailedToLoad : $adiscopeError")
    }

    override fun onOfferwallAdClosed(unitId: String?) {
        Log.d(TAG, "onOfferwallAdClosed")
    }
    // endregion

    // endregion
    // region implementation InterstitialAdListener
    override fun onInterstitialAdLoaded() {
        Log.d(TAG, "onInterstitialAdLoaded")
        mInterstitialAd!!.show()
    }

    override fun onInterstitialAdFailedToLoad(adiscopeError: AdiscopeError) {
        Log.e(TAG, "onInterstitialAdFailedToLoad : $adiscopeError")
    }

    override fun onInterstitialAdOpened(unitId: String?) {
        Log.d(TAG, "onInterstitialAdOpened")
    }

    override fun onInterstitialAdClosed(unitId: String?) {
        Log.d(TAG, "onInterstitialAdClosed")
    }

    override fun onInterstitialAdFailedToShow(unitId: String?, adiscopeError: AdiscopeError) {
        Log.e(TAG, "onInterstitialAdFailedToShow : $adiscopeError")
    }
}