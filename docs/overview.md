OverView
===========
- [AdiscopeSdk](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/overview.md#adiscopesdk)
- [InterstitialAd](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/overview.md#interstitialad)
- [OfferwallAd](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/overview.md#offerwallad)
- [RewardedVideoAd](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/overview.md#rewardedvideoad)

## Overview - Sdk.Android
### AdiscopeSdk

1. 초기화

   <br>mediaId, mediaSecret이 필요하며 이 값은 admin page를 통해 app을 등록하여 발급받아야 한다.
   <br>**callback tag 미사용**
    ```
    //callback tag 미사용 
    import com.nps.adiscope.AdiscopeSdk;
  
    // initialize AdiscopeSdk, must be called in main thread
    AdiscopeSdk.initialize(Activity activity, String mediaId, String mediaSecret, AdiscopeInitializeListener listener) 
    ```
    **callback tag 사용**

    ```
    //callback tag 사용

    import com.nps.adiscope.AdiscopeSdk;
  
    // initialize AdiscopeSdk, must be called in main thread
    AdiscopeSdk.initialize(final Activity activity, String mediaId, String mediaSecret, String callbackTag, AdiscopeInitializeListener listener)
    ```
   
   **사용 예**

   ```
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
                } else {
                    // Init 실패 에 대한 처리 Code 
                }
        }
   ```
2. 사용자 정보 설정

    <br>application 사용자의 unique user id를 Adiscope Sdk에 전달한다. unique user id는 보상이 지급 될 시 사용자를 구분하기 위해 사용된다.
    
    <br>* 최대길이 64자로 제한된다. 그 이상일 경우 false를 반환 

    <span style="color:red">* 만일 서비스에서 한 사람당 N개의 계정 사용이 가능한 경우, 계정 변경 시 `setUserId` 호출로 애디스콥에 변경 정보를 전달해주어야 한다. 그렇지 않을 경우 변경된 계정 정보로 보상 지급이 되지 않으므로 유의해야 한다.</span></br>


    ```
    // Setting User Id
    import com.nps.adiscope.AdiscopeSdk;
  
    // set unique user id to identify the user in reward information
    AdiscopeSdk.setUserId("exampleUniqueUserId");
    ```

3. 광고 Instance

   <br>각 Ad의 global singleton instance를 얻을 수 있다.
   ```
    import com.nps.adiscope.AdiscopeSdk;
    import com.nps.adiscope.offerwall.OfferwallAd;
    import com.nps.adiscope.reward.RewardedVideoAd;
  
    // get singleton instance of offerwall ad
    OfferwallAd offerwallAd = AdiscopeSdk.getOfferwallAdInstance(this);
    RewardedVideoAd rewardedVideoAd = Adiscope.getRewardedVideoAdInstance(this);
   ```


4. 광고의 표시
   <br>실제 광고를 보여주기 위해서는 필요한 상세정보에 대해서는 Overview section의 OfferwallAd와 RewardedVideoAd 항목을 참조할 것
    ```
     Offerwall Ad는 이후 Show를 하면 광고가 표시된다.
     Rewarded Video Ad의 경우는 이후 위의 과정을 거친후 RewardedVideoAd.Load를 실행해야여 OnLoaded callback이 전달 된 후에 Show를 할 수 있다
    ```

## Overview - InterstitialAd.Android

### InterstitialAd
1. Singleton Instance
   - Interstitial Ad Instance는 global singleton instance이므로 여러개의 instance가 생성되지 않는다.
2. Interstitial Ad 사용 방법
   - Interstitial Ad를 게임 내에서 표시하기 위해서는 다음의 과정을 거쳐야 한다.
   ```
    // Sdk Initialization
    import com.nps.adiscope.AdiscopeSdk;
  
    AdiscopeSdk.initialize(final Activity activity, String mediaId, String mediaSecret, String callbackTag, AdiscopeInitializeListener listener);
   ```
   - Interstitial Ad instance 생성
   ```
    // Get Instance
    import com.nps.adiscope.AdiscopeSdk;
    import com.nps.adiscope.interstitial.InterstitialAd;
  
    // get singleton instance of Interstitial Ad
    InterstitialAd interstitialAd = AdiscopeSdk.getInterstitialAdInstance(this);
   ```
   - Callback 등록
    ```
    // Register Callback Event Handlers 
    import com.nps.adiscope.AdiscopeSdk;
    import com.nps.adiscope.interstitial.InterstitialAd;
    import com.nps.adiscope.interstitial.InterstitialAdListener;

    // set callbacks
    interstitialAd.setInterstitialAdListener(this);
    ```
   -  Load AD
      -  특정 유닛에 속한 ad 네크워크들의 광고를 load 한다.
      -  onInterstitialAdLoaded callback이 호출되면 load가 완료된 것이다.
   ```
    // Load Ad
    // load a interstitial ad which belongs to a specific unit
    interstitialAd.load("UNIT_ID"); 
   ```
      - load가 실행되면 onInterstitialAdLoaded와 onInterstitialAdFailedToLoad 중 하나의 callback은 항상 호출된다.
      - Interstitial Ad의 load와 show는 pair로 호출되어야 한다. 즉 load를 한 후 show를 하고, 광고를 show한 후에는 다시 load를 하여 다음번 show를 준비하여야 한다.
   - isLoaded
       - 광고가 load 되었는지 상태를 확인 할 수 있다.
   ```
        //Check Loaded Ad

        // check Interstitial load
        if (interstitialAd.isLoaded("UNIT_ID")) {
            // show ad here
        } else {
            // do something else
        }
   ```
   - show
     - 마지막으로 load된 광고를 사용자에게 보여준다.
     - show 호출 후에는 다시 load를 호출해야한다.
     - show method는 중복하여 호출 할 수 없다.
     - unitId는 admin page을 통하여 등록/조회한다.
   ```
   // Show Ad
   
   // check Interstitial Ad is loaded
    if (interstitialAd.isLoaded("UNIT_ID")) {
        // only one "show" can not be requested at a time
        // if show() returns false, show is in progress somewhere else
        if (interstitialAd.show()) {
            Debug.Log("AdiscopeExample - InterstitialAd.show");
        } else {
            // show is already in progress
            Debug.Log("AdiscopeExample - this show request is duplicated");
        }
    }
    else {
        // ad is not loaded
        Debug.Log("AdiscopeExample - InterstitialAd is not loaded");
    }
   ```
      -  show가 실행되면 (return값이 True일 경우) onInterstitialAdOpened 와 onInterstitialAdFailedToShow 중 하나가 항상 호출되고, onInterstitialAdOpened가 호출되었다면 이후 onInterstitialAdClosed 가 항상 호출된다.
      - Interstitial Ad의 load와 show는 pair로 호출되어야 한다. 즉 load를 한 후 show를 하고, 광고를 show한 후에는 다시 load를 하여 다음번 show를 준비하여야 한다.

   - Callbacks
     - load 성공 시 onInterstitialAdLoaded, 실패 시 onInterstitialAdFailedToLoad 가 호출된다.
     - show 성공 시 onInterstitialAdOpened, onInterstitialAdClosed 가 순차적으로 호출되고, 실패시 onInterstitialAdFailedToShow 가 호출된다.



## Overview - OfferwallAd.Android

### OfferwallAd
1.  Singleton instance
    - OfferwallAd Instance는 global singleton instance이므로 여러개의 instance가 생성되지 않는다.

2. Offerwall Ad 사용 방법
   <br>Offerwall Ad를 게임 내에서 표시하기 위해서는 다음의 과정을 거쳐야 한다.
     - 초기화 및 사용자 정보 설정
     ```
    // Sdk Initialization
    import com.nps.adiscope.AdiscopeSdk;
  
    AdiscopeSdk.initialize(final Activity activity, String mediaId, String mediaSecret, String callbackTag, AdiscopeInitializeListener listener);
   ```
   - Offerwall Ad instance 생성
   ```
    //Get Instance

    import com.nps.adiscope.AdiscopeSdk;
    import com.nps.adiscope.offerwall.OfferwallAd;
  
    // get singleton instance of Offerwall Ad
    OfferwallAd offerwallAd = AdiscopeSdk.getOfferwallAdInstance(this);
   ```
   - Callback 등록
   ```
    // Register Callback Event Handlers

    import com.nps.adiscope.AdiscopeSdk;
    import com.nps.adiscope.offerwall.OfferwallAd;
    import com.nps.adiscope.offerwall.OfferwallAdListener;
  
    // set callbacks
    offerwallAd.setOfferwallAdListener(this);
   ```

   - Show
       - Offerwall 광고를 사용자에게 보여준다.
       - Show method는 중복하여 호출 할 수 없다.
       - unitId는 admin page을 통하여 등록/조회한다.
       - excludeAdTypeList 는 제외할 타입을 지정해준다. ex) ["CPS"] 
   ```
    // Show Ad
 
    import com.nps.adiscope.AdiscopeSdk;
    import com.nps.adiscope.offerwall.OfferwallAd;
  
    // show offerwall ad
    if (offerwallAd.show(activity, "UNIT_ID", new String[]{})) {
        // Succeed
    } else {
        // show is already in progress
    }
   ```
      - show가 실행되면 (return값이 True일 경우) onOfferwallAdOpened 와 onOfferwallAdFailedToShow 중 하나가 항상 호출되고, onOfferwallAdOpened가 호출되었다면 이후 onOfferwallAdClosed가 항상 호출된다.

   -  Callbacks
      - show 성공 시 onOfferwallAdOpened, onOfferwallAdOpened callback이 순차적으로 호출된다.
      - show 실패 시 onOfferwallAdFailedToShow callback이 호출된다.

## Overview - RewardedVideoAd.Android
### RewardedVideoAd
1. Singleton Instance
   - Rewarded Video Ad Instance는 global singleton instance이므로 여러개의 instance가 생성되지 않는다.
2. Rewarded Video Ad 사용 방법
   - Rewarded Video Ad를 게임 내에서 표시하기 위해서는 다음의 과정을 거쳐야 한다.
     - 초기화 및 사용자 정보 설정
    ```
    // Sdk Initialization
    import com.nps.adiscope.AdiscopeSdk;
  
    AdiscopeSdk.initialize(final Activity activity, String mediaId, String mediaSecret, String callbackTag, AdiscopeInitializeListener listener);
   ```
    - Rewarded Video Ad instance 생성
    ```
    import com.nps.adiscope.AdiscopeSdk;
    import com.nps.adiscope.reward.RewardedVideoAd;
  
    // get singleton instance of Rewarded Video Ad
    RewardedVideoAd rewardedVideoAd = AdiscopeSdk.getRewardedVideoAdInstance(this); 
    ```
   -  Callback 등록
   ```
    // Register Callback Event Handlers

    import com.nps.adiscope.AdiscopeSdk;
    import com.nps.adiscope.offerwall.RewardedVideoAd;
    import com.nps.adiscope.offerwall.RewardedVideoAdListener;
  
    // set callbacks
    rewardedVideoAd.setRewardedVideoAdListener(this);
   ```
   - load
     - 특정 유닛에 속한 ad 네크워크들의 광고를 load 한다.
     - onRewardedVideoAdLoaded callback이 호출되면 load가 완료된 것이다.
   ```
   // Load Ad
   
    // load a rewarded video ad which belongs to a specific unit
    rewardedVideoAd.load("UNIT_ID");
   ```
      - load가 실행되면 onRewardedVideoAdLoaded와 onRewardedVideoAdFailedToLoad 중 하나의 callback은 항상 호출된다.
      - Rewarded Video Ad의 load와 show는 pair로 호출되어야 한다. 즉 load를 한 후 show를 하고, 광고를 show한 후에는 다시 load를 하여 다음번 show를 준비하여야 한다.
   - isLoaded
     - 광고가 load 되었는지 상태를 확인 할 수 있다.
     ```
        // check video load
        if (rewardedVideoAd.isLoaded("UNIT_ID")) {
            // show ad here
        } else {
            // do something else
        }
     ```

   - show
     - 마지막으로 load된 광고를 사용자에게 보여준다.
     - show 호출 후에는 다시 load를 호출해야한다.
     - show method는 중복하여 호출 할 수 없다.
     - unitId는 admin page을 통하여 등록/조회한다.
   ```
    // check rewarded video is loaded
    if (rewardedVideoAd.isLoaded("UNIT_ID")) {
        // only one "show" can not be requested at a time
        // if show() returns false, show is in progress somewhere else
        if (rewardedVideoAd.show()) {
            Debug.Log("AdiscopeExample - RewardedVideoAd.show");
        }
        else {
            // show is already in progress
            Debug.Log("AdiscopeExample - this show request is duplicated");
        }
    } else {
        // ad is not loaded
        Debug.Log("AdiscopeExample - RewardedVideoAd is not loaded");
    }
   ```
      - show가 실행되면 (return값이 True일 경우) onRewardedVideoAdOpened 와 onRewardedVideoAdFailedToShow 중 하나가 항상 호출되고, onRewardedVideoAdOpened가 호출되었다면 이후 onRewardedVideoAdClosed 가 항상 호출된다.
      - Rewarded Video Ad의 load와 show는 pair로 호출되어야 한다. 즉 load를 한 후 show를 하고, 광고를 show한 후에는 다시 load를 하여 다음번 show를 준비하여야 한다.
   - Reward
     - 보상이 주어져야 할 경우 onRewarded callback이 호출되며 그 parameter로 관련 정보가 전달된다.
     - 이 보상 정보를 바탕으로 게임 내에서 보상을 지급할 수 있다.

   - Reward
   ```
    @Override
    public void onRewarded(String unitId, RewardItem rewardItem) {
        /*
        RewardItem.getType - 보상 type
        RewardItem.getAmount - 보상의 양
        */
        DoSomethingWithReward();
    }
   ```
      - onRewarded는 보통 onRewardedVideoAdOpened 와 onRewardedVideoAdClosed 사이에 호출되는 경우가 많으나 광고 System의 상황에 따라 달라 질 수 있다. 또한 onRewarded가 호출되지 않는 경우도 존재할 수 있다.
      -  Mediation network 중 Adcolony의 경우, Reward 설정을 Server-to-server로 하였다면, Adcolony의 Video 시청 후에는 onRewarded가 호출되지 않는다.
      -  Reward 정보는 abusing 방지를 위해서 Server-to-server 방식으로 전달 받는 것을 권장한다. <br>Server-to-server 방식을 선택하더라도 보상이 전달 될 시에는 onRewarded가 호출된다. 이때는 Server를 통해 전달받은 정보를 기준으로 처리하고, onRewarded를 통해 전달받은 정보는 검증용으로 사용하거나 무시하도록 한다.
   -  Callbacks
      -  load 성공 시 onRewardedVideoAdLoaded, 실패 시 onRewardedVideoAdFailedToLoad 가 호출된다.
      -  show 성공 시 onRewardedVideoAdOpened, onRewardedVideoAdClosed 가 순차적으로 호출되고, 실패시 onRewardedVideoAdFailedToShow 가 호출된다.
      -  보상이 있을 경우 onRewarded 가 호출된다.