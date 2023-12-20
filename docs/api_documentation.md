API Reference
====================================
- [AdiscopeSdk](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/api_documentation.md#adiscopesdk)
- [OptionSetter](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/api_documentation.md#optionsetter)
- [AdiscopeError](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/api_documentation.md#adiscopeerror)
  - [AdiscopeError Code](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/api_documentation.md#adiscopeerror-code)
- [InterstitialAd](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/api_documentation.md#interstitialad)
- [OfferwallAd](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/api_documentation.md#offerwallad)
- [RewardedVideoAd](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/api_documentation.md#rewardedvideoad)
- [RewardedInterstitialAd](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/api_documentation.md#rewardedinterstitialad)


## API Reference - AdiscopeSdk.Android
### AdiscopeSdk
1. Class Declaration
    ```java
        public class AdiscopeSdk {

            public static void initialize(Activity activity, AdiscopeInitializeListener listener)

            public static void initialize(Activity activity, AdiscopeInitializeListener listener, String callbackTag)
    
            public static void initialize(Activity activity, AdiscopeInitializeListener listener, String callbackTag, String childYN)

            @Deprecated
            public static void initialize(Activity activity, String mediaId, String mediaSecret, AdiscopeInitializeListener listener)
            
            @Deprecated
            public static void initialize(final Activity activity, String mediaId, String mediaSecret, String callbackTag, AdiscopeInitializeListener listener)
            
            @Deprecated
            public static void initialize(final Activity activity, String mediaId, String mediaSecret, String callbackTag, String childYN, AdiscopeInitializeListener listener)
            
            public static boolean isInitialize()
    
            public static OfferwallAd getOfferwallAdInstance(Activity activity)
                        
            public static RewardedVideoAd getRewardedVideoAdInstance(Activity activity)
    
            public static InterstitialAd getInterstitialAdInstance(Activity activity)
   
            public static RewardedInterstitialAd getRewardedInterstitialAdInstance(Activity activity)
    
            public static OptionSetter getOptionSetterInstance(Activity activity) 
            
            public static void setUserId(String userId)
            
            public static void getUnitStatus(String unitId, IUnitStatus callback)                
    
            public static String getNetworksVersion()
   
            public static String getSDKVersion()
        }
    
        public interface AdiscopeInitializeListener {
            void onInitialized(boolean isSuccess);
        }
            
    ```
2. Methods
   - initialize
     *  Sdk 기능을 초기화 한다. 
        <주의> setUserId는 64자까지 설정 할 수 있습니다.
       
     - Definition
       - public static void initialize(Activity activity, AdiscopeInitializeListener listener)
       - public static void initialize(Activity activity, AdiscopeInitializeListener listener, String callbackTag)
       - public static void initialize(Activity activity, AdiscopeInitializeListener listener, String callbackTag, String childYN)
       - ~~public static void initialize(Activity activity, String mediaId, String mediaSecret, AdiscopeInitializeListener listener)~~
       - ~~public static void initialize(final Activity activity, String mediaId, String mediaSecret, String callbackTag, AdiscopeInitializeListener listener)~~
       - ~~public static void initialize(final Activity activity, String mediaId, String mediaSecret, String callbackTag, String childYN, AdiscopeInitializeListener listener)~~
     - Parameters
       - activity : Activity
       - mediaId : Amdin page에서 등록한 해당 application에 대한 Id
       - mediaSecret : mediaId에 대응되는 secret key
       - callbackTag : 보상 콜백을 복수 개로 등록해서 사용할시에 어떤 보상 콜백을 사용할지 지정한다. 지정하지 않을시에는 기본 보상콜백이 사용된다.
       - childYN : 어린이 인지 아닌지의 여부를 설정 해주는 값 그대로 Google GMA 에 세팅 된다.  
     - Return

   - isInitialize
       * 이니셜라이즈 여부를 확인할 수 있다. 애디스콥 내부에서 이니셜라이즈가 되지 않았다고 판단 시에는 false를 반환한다.

       - Definition
           - public static boolean isInitialize()
       - Return
           - bool : 이니셜라이즈 된 상태일 경우 True, 이니셜라이즈가 되지 않은 상태일 경우 False


   - setUserId
     * Application 사용자의 Unique Id를 설정한다. 이 정보는 reward 지급 등에 있어 사용자를 구분하는데 사용된다.

     - Definition
       - public static boolean setUserId(String userId)
     - Parameters
       - userId : application user's unique id
     - Return
       - bool : load된 광고가 있을 시 True, load된 광고가 없을 시 False

   - getOfferwallAdInstance
     * Offerwall Ad의 전역 Singleton 객체를 생성한다.
     * Initialize() 를 호출하고 반드시 AdiscopeInitializeListener 의 콜백함수 onInitialized 의 isSuccess값을 true 로 받은뒤 객체 생성 해주어야한다.

     - Definition
       - public static OfferwallAd getOfferwallAdInstance(Activity activity)
     - Parameters
       - activity : Activity
     - Return
       - OfferwallAd : Offerwall 광고의 Singleton Instance

   - getRewardedVideoAdInstance
     * Rewarded Video Ad의 전역 Singleton 객체를 생성한다.
     * Initialize() 를 호출하고 반드시 AdiscopeInitializeListener 의 콜백함수 onInitialized 의 isSuccess값을 true 로 받은뒤 객체 생성을 해주어야 한다.

     - Definition
       - public static RewardedVideoAd getRewardedVideoAdInstance(Activity activity)
     - Parameters
       - activity : Activity
     - Return
       - RewardedVideoAd : Rewarded Video 광고의 Singleton Instance

   - getInterstitialAdInstance
       * Interstitial Ad의 전역 Singleton 객체를 생성한다.
       * Initialize() 를 호출하고 반드시 AdiscopeInitializeListener 의 콜백함수 onInitialized 의 isSuccess값을 true 로 받은뒤 객체 생성을 해주어야 한다.

       - Definition
           - public static InterstitialAd getInterstitialAdInstance(Activity activity)
       - Parameters
           - activity : Activity
       - Return
           - InterstitialAd : Interstitial 광고의 Singleton Instance

   - getRewardedInterstitialAdInstance
       * Rewarded Interstitial Ad의 전역 Singleton 객체를 생성한다.
       * Initialize() 를 호출하고 반드시 AdiscopeInitializeListener 의 콜백함수 onInitialized 의 isSuccess값을 true 로 받은뒤 객체 생성을 해주어야 한다.

       - Definition
           - public static RewardedInterstitialAd getRewardedInterstitialAdInstance(Activity activity)
       - Parameters
           - activity : Activity
       - Return
           - RewardedInterstitialAd : Rewarded Interstitial 광고의 Singleton Instance


   - getUnitStatus
     * 유닛의 상태 정보를 구한다.

     - Definition
       - public static void getUnitStatus(String unitId, IUnitStatus callback)

     - Parameters
       - unitId : 유닛 id
       - callback : 결과를 리턴받을 콜백 객체

     - Return
       - IUnitStatus : Rewarded Video 광고의 Singleton Instance
       - 
          ```java
          public interface IUnitStatus {
              void onResult(AdiscopeError error, UnitStatus unitStatus);
          }
          
          public class UnitStatus {
              private boolean live;       // 광고 수익화 on/off
              private boolean active;     // 유닛 활성화 on/off

              public UnitStatus() {}

              public boolean isLive() {
                  return live;
              }

              public boolean isActive() {
                  return active;
              }
          }
         ```
         
   - getNetworksVersions
     * 각 네트워크 버전을 리스트로 반환한다.

       - Definition
           - public static String getNetworksVersions()

       - Parameters

       - Return
          - String :  Network Version List


   - getSDKVersion
    * 현 애디스콥의 버전을 반환한다.

        - Definition
            - public static String getSDKVersion()

        - Parameters

        - Return
            - String :  Adiscope core version return
          

## API Reference - OptionSetter.Android
### OptionSetter
1.  Class Declaration
    ```java
        public interface OptionSetter {
            void setUseCloudFrontProxy(boolean useCloudFrontProxy);
            void setChildYN(String childYN);
            void setVolumeOff(boolean isVolume);
         }
    ```
2. Methods
   - setUseCloudFrontProxy
     *  AWS Cloud Front Proxy를 사용할지 말지 설정한다.<br>이 옵션을 사용하게되면, 북미, 유럽에서 게임을 서비스할시에 Adiscope API의 응답속도가 향상된다.

     - Definition
       - void setUseCloudFrontProxy(boolean useCloudFrontProxy)
     - Parameters
       - useCloudFrontProxy : AWS Cloud Front Proxy를 사용할지말지 여부
   - setChildYN
     * 광고를 시청할 유저가 어린이인지 아닌지의 여부를 설정하는 함수.<br>이 설정값은 그대로 Google GMA 에 세팅된다.

     - Definition
         - void setChildYN(String childYN)
     - Parameters
         - childYN : 사용자의 어린이 유무를 확인하기 위한 설정값
             - 어린이에 해당하거나 정보가 없는 경우: "YES" or Null
             - 어린이가 아닌 경우(어른인 경우): "NO"
   - setVolumeOff
     * 광고음의 on/off 설정을 지원하는 함수로, 미송출 설정하지 않을 경우 광고음 송출이 디폴트이다. <br>Admob 네트워크 한정으로 광고음 미송출 설정이 가능하다.

     - Definition
         - void setVolumeOff(boolean isVolume)
     - Parameters
         - isVolume :
             - 광고음이 송출되지 않도록 할 경우: true
             - 광고음이 송출되도록 할 경우: false (default)


## API Reference - AdiscopeError.Android

### AdiscopeError
1. Class Declaration
   ```java
    package com.nps.adiscope;
 
    public class AdiscopeError {
        private final int code;
        private final String description;
        private String xb3TraceId;
   
        public int getCode() {    return code;   }

        public String getDescription() {    return description;   }

        public String getXb3TraceId() {     return xb3TraceId;      }
    }
   ```
2. ErrorCode
#### AdiscopeError Code
[AdiscopeError](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/error_info.md)

## API Reference - InterstitialAd.Android
### InterstitialAd
1.  Class Declaration
    ```java
        public interface InterstitialAd {

            void load(String unitId);

            boolean isLoaded(String unitId);

            boolean show();

            void setInterstitialAdListener(InterstitialAdListener interstitialAdListener);
        }
    
        public interface InterstitialAdListener {

            void onInterstitialAdLoaded();

            void onInterstitialAdFailedToLoad(AdiscopeError error);

            void onInterstitialAdOpened(String unitId);

            void onInterstitialAdClosed(String unitId);

            void onInterstitialAdFailedToShow(String unitId, AdiscopeError error);
        }    
    ```
2. Methods
   - load
     - 특정 유닛에 속한 ad 네트워크들의 Interstitial 광고를 load 한다.
     - Interstitial Ad의 load와 show는 pair로 호출되어야 한다. 즉 load를 한 후 show를 하고, 광고를 show한 후에는 다시 load를 하여 다음번 show를 준비하여야 한다.

     - Definition
       - void load(String unitId)
     - Parameters
       - unitId : load 할 광고의 unit id. Admin page에 등록된 id와 동일해야 한다.
     - Return

     * load가 실행되면 onInterstitialAdLoaded 와 onInterstitialAdFailedToLoad 중 하나의 callback은 항상 호출된다.

     - Callback
      - onInterstitialAdLoaded :
      - |Method|Info|Parameter|
        |-------|---|---------|
        |onInterstitialAdLoaded	|Interstitial 를 load 하였을 때 |void|
        |onInterstitialAdFailedToLoad	|Interstitial load 가 실패하였을 때| AdiscopeError|

   - isLoaded<br>특정 유닛의 Interstitial 광고가 load 되었는 지를 확인한다.
       - Definition
           - boolean isLoaded(String unitId)

       - Parameters
           - unitId : load 여부를 체크할 광고의 unit id

       - Return
           - bool : load된 광고가 있을 시 True, load된 광고가 없을 시 False

   - Show
     * 최근에 load된 Interstitial 광고 유닛에 속한 광고를 사용자에게 보여준다.

     - Definition
        - boolean show()

        - Parameters

        - Return
           - bool : show가 정상적으로 시작되면 True, 만약 이미 다른 show가 진행중이라면 False
           *  show가 실행되면 (return값이 True일 경우) onInterstitialAdOpened 와 onInterstitialAdFailedToShow 중 하나가 항상 호출되고, onInterstitialAdOpened가 호출되었다면 이후 onInterstitialAdClosed가 항상 호출된다.

        - Callback
             - |Method|Info|Parameter|
               |-------|---|---------|
               |onInterstitialAdOpened	|Interstitial 광고창이 열릴 때	| String unitId |
               |onInterstitialAdClosed	|Interstitial 광고창이 닫혔을 때	|String unitId|
               |onInterstitialAdFailedToShow	|Interstitial 광고창을 보여 줄 수 없을 때	|String unitId, AdiscopeError error|


## API Reference - OfferwallAd.Android
### OfferwallAd
1. Class Declaration
    ```java
        public interface OfferwallAd {

            boolean show(Activity activity, String unitId, String[] excludeAdTypeList);

            boolean showDetail(Activity activity, String unitId, String[] excludeAdTypeList, int sponsorshipItemId);

            boolean showDetail(Activity activity, String url);

            void setOfferwallAdListener(OfferwallAdListener offerwallAdListener);
        }
        
        public interface OfferwallAdListener {

            void onOfferwallAdOpened(String unitId);

            void onOfferwallAdFailedToShow(String unitId, AdiscopeError error);

            void onOfferwallAdClosed(String unitId);
        }    
    ```
2. Methods
   - show
     *  Offerwall 광고를 사용자에게 표시한다.

     - Definition
       - boolean show(Activity activity, String unitId, String[] excludeAdTypeList)
     - Parameters
       - activity : 상위 액티비티
       - unitId : 사용자에게 표시할 광고의 unit id. Admin page에 등록된 id와 동일해야 한다.
       - excludeAdTypeList : 구매 제한 타입 리스트 ex) [ "CPS" ].
         
     - Return
       - bool : show가 정상적으로 시작되면 True, 만약 이미 다른 show가 처리되는 중이라면 False
     * show가 실행되면 (return값이 True일 경우) onOfferwallAdOpened 와 onOfferwallAdFailedToShow 중 하나가 항상 호출되고, onOfferwallAdOpened가 호출되었다면 이후 onOfferwallAdClosed가 항상 호출된다.

     - Callback
      - |Method|Info|Parameter|
        |-------|---|---------|
        |onOfferwallAdOpened	|Offerwall 광고창이 열릴 때	 |String unitId|
        |onOfferwallAdClosed		|Offerwall 광고창이 닫혔을 때	| String unitId|
        |onOfferwallAdFailedToShow		|Offerwall 광고창을 보여 줄 수 없을 때	| String unitId, AdiscopeError error|

   - showDetail
     * 특정 광고 아이템의 상세 페이지로 이동한다.

     - Definition
       - boolean showDetail(Activity activity, String unitId, String[] excludeAdTypeList, int sponsorshipItemId)
       - boolean showDetail(Activity activity, String url)
     - Parameters
       - activity : 상위 액티비티
       - unitId: 사용자에게 표시할 광고의 unit id. Admin page에 등록된 id와 동일해야 한다.
       - excludeAdTypeList : 구매 제한 타입 리스트 ex) [ "CPS" ].
       - sponsorshipItemId: 이동하고자 할 스폰서십의 item id. Admin page에 등록된 id와 동일해야 한다.
       - url: mediaId, unitId, excludeAdTypes, sponsorshipItemId가 포함된 형식의 url
     
     - Return
       - bool : showDetail이 정상적으로 시작되면 True, 그렇지 않다면 False
     * showDetail이 실행되면 (return값이 True일 경우) onOfferwallAdOpened 와 onOfferwallAdFailedToShow 중 하나가 항상 호출되고, onOfferwallAdOpened가 호출되었다면 이후 onOfferwallAdClosed가 항상 호출된다.



## API Reference - RewardedVideoAd.Android
### RewardedVideoAd
1.  Class Declaration
    ```java
        public interface RewardedVideoAd {

            void load(String unitId);

            boolean isLoaded(String unitId);

            boolean show();

            void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener);
        }
    
        public interface RewardedVideoAdListener {

            void onRewardedVideoAdLoaded(String unitId);

            void onRewardedVideoAdFailedToLoad(String unitId, AdiscopeError error);

            void onRewardedVideoAdOpened(String unitId);

            void onRewardedVideoAdClosed(String unitId);

            void onRewarded(String unitId, RewardItem rewardItem);

            void onRewardedVideoAdFailedToShow(String unitId, AdiscopeError error);
        }    
    ```
2. Methods
   - load
     *  특정 유닛에 속한 ad 네트워크들의 Rewarded Video 광고를 load 한다.
     *  Rewarded Video Ad의 load와 show는 pair로 호출되어야 한다. 즉 load를 한 후 show를 하고, 광고를 show한 후에는 다시 load를 하여 다음번 show를 준비하여야 한다.
     *  load - show 후 다시 load를 하려 할 때 load 는 show 이후 언제든 호출가능하다. 광고가 show되는 동안 다음 광고를 load를 할 수도 있지만 이는 사용하는 mediation ad network company의 종류에 따라 달라질 수 잇으므로 항상 보장되는 동작은 아니다. 그러므로 show의 callback 인 onRewardedVideoAdClosed 에서 다시 load를 하는 것을 권장한다. 이는 Abusing 방지를 위해 Rewarded Video Ad를 연속으로 보여주는 것을 제한하여 한번 광고를 보고 나면 일정 시간이 지난 후에 다시 Show를 할 수 있도로록 Admin page에서 서비스 설정을 할 수 있기 때문이다. (일정 시간 이내에 show를 할 경우 onRewardedVideoAdFailedToShow callback이 호출된다)

     - Definition
       - void load(String unitId)
     - Parameters
       - unitId : load 할 광고의 unit id. Admin page에 등록된 id와 동일해야 한다.
     - Return
     * load가 실행되면 onRewardedVideoAdLoaded 와 onRewardedVideoAdFailedToLoad 중 하나의 callback은 항상 호출된다.

     - Callback
     - |Method|Info|Parameter|
       |-------|---|---------|
       |onRewardedVideoAdLoaded	|Rewarded Video 를 load하였을 때	| String unitId |
       |onRewardedVideoAdFailedToLoad	|Rewarded Video load가 실패하였을 때|String unitId, AdiscopeError error|

   - isLoaded
     * load가 실행되면 onRewardedVideoAdLoaded 와 onRewardedVideoAdFailedToLoad 중 하나의 callback은 항상 호출된다.

     - Definition
       - boolean isLoaded(String unitId)
     - Parameters
       - unitId : load 여부를 체크할 광고의 unit id
     - Return
       - bool : load된 광고가 있을 시 True, load된 광고가 없을 시 False

   - Show
     * 최근에 load된 Rewarded Video 광고 유닛에 속한 광고를 사용자에게 보여준다.

     - Definition
       - boolean show()
     - Parameters
     - Return
       - bool : show가 정상적으로 시작되면 True, 만약 이미 다른 show가 진행중이라면 False

     * show가 실행되면 (return값이 True일 경우) onRewardedVideoAdOpened 와 onRewardedVideoAdFailedToShow 중 하나가 항상 호출되고, onRewardedVideoAdOpened가 호출되었다면 이후 onRewardedVideoAdClosed가 항상 호출된다.
     * OnRewarded는 보통 onRewardedVideoAdOpened 와 onRewardedVideoAdOpened 사이에 호출되는 경우가 많으나 광고 System의 상황에 따라 달라 질 수 있다.
     * Reward 정보는 abusing 방지를 위해서 Server-to-server 방식으로 전달 받는 것을 권장한다. Server-to-server 방식을 선택하더라도 보상이 전달 될 시에는 OnRewarded가 호출된다. 이때는 Server를 통해 전달받은 정보를 기준으로 처리하고, OnRewarded를 통해 전달받은 정보는 검증용으로 사용하거나 무시하도록 한다.

     - Callback
     - |Method|Info|Parameter|
       |-------|---|---------|
       |onRewardedVideoAdOpened	|Rewarded Video 광고창이 열릴 때	| String unitId |
       |onRewardedVideoAdClosed	|Rewarded Video 광고창이 닫혔을 때	|String unitId|
       |onRewarded	|Rewarded Video 시청 후 보상이 있을 시	|String unitId, RewardItem rewardItem|
       |onRewardedVideoAdFailedToShow	|Rewarded Video 광고창을 보여 줄 수 없을 때	|String unitId, AdiscopeError error|



## API Reference - RewardedInterstitialAd.Android
### RewardedInterstitialAd
1.  Class Declaration
    ```java
    public interface RewardedInterstitialAd {
        void preloadUnit(String[] unitIdList);

        void preloadAll();

        void show(String unitId);

        void getUnitStatus(String unitId, IUnitStatus callback);

        void setRewardedInterstitialAdListener(RewardedInterstitialAdShowListener listener);
    }

    public interface RewardedInterstitialAdShowListener {
        void onRewardedInterstitialAdSkipped(String unitId);

        void onRewardedInterstitialAdOpened(String unitId);

        void onRewardedInterstitialAdClosed(String unitId);

        void onRewardedInterstitialAdRewarded(String unitId, RewardItem rewardItem);

        void onRewardedInterstitialAdFailedToShow(String unitId, AdiscopeError error);
    } 
    ```
2. Methods
    - preloadUnit
        * 특정 유닛들에 속한 ad 네트워크들의 전면형 보상 광고를 순차적으로 load 한다.
        * 이니셜라이즈 콜백 이후 1회 호출 권장

        - Definition
            - void preloadUnit(String[] unitIdList)
        - Parameters
            - String[] unitIdList : load 할 광고의 unit id 목록. Admin page에 등록된 id와 동일해야 한다.
   
    - preloadAll
        * Admin page에 등록된 활성화된 전면형 보상 광고 유닛들을 순차적으로 load 한다.
        * 이니셜라이즈 콜백 이후 1회 호출 권장

        - Definition
            - void preloadAll()

    - show
        * load된 전면형 보상 광고의 유닛을 지정하여 사용자에게 보여준다.

        - Definition
            - void show(String unitId)
        - Parameters
          - String unitId : show 하고자 할 전면형 보상 광고의 유닛 아이디

        * 해당 유닛이 load 되어 있으면 안내 팝업을 보여준 뒤 해당 광고를 사용자에게 보여준다.
        * show는 중복하여 호출할 수 없다.
        * show가 실행되면 `onRewardedInterstitialAdSkipped` 와 `onRewardedInterstitialAdOpened와` `onRewardedInterstitialAdFailedToShow` 중 하나가 항상 호출되고, `onRewardedInterstitialAdOpened`가 호출되었다면 이후 `onRewardedInterstitialAdClosed`가 항상 호출된다.
        * `onRewardedInterstitialAdRewarded`는 보통 `onRewardedInterstitialAdOpened`와 `onRewardedInterstitialAdClosed` 사이에 호출되는 경우가 많으나 광고 시스템의 상황에 따라 달라질 수 있다.
        * `onRewardedInterstitialAdClosed`와 `onRewardedInterstitialAdFailedToShow`가 호출되면 내부에서 해당 유닛을 자동 load 시킨다.

        - Callback
        - |Method| Info                            | Parameter                            |
          |---------------------------------|--------------------------------------|---------|
          |onRewardedInterstitialAdSkipped	| 사용자가 스킵 버튼을 클릭하여 안내 팝업창을 닫았을 때	 | String unitId                        |
          |onRewardedInterstitialAdOpened	| 전면형 보상 광고창이 열릴 때	               | String unitId                        |
          |onRewardedInterstitialAdClosed	| 전면형 보상 광고창이 닫혔을 때	              | String unitId                        |
          |onRewardedInterstitialAdRewarded	| 전면형 보상 광고 시청 후 보상이 있을 시	        | String unitId, RewardItem rewardItem |
          |onRewardedInterstitialAdFailedToShow	| 전면형 보상 광고창을 보여 줄 수 없을 때	        | String unitId, AdiscopeError error   |
   
    - getUnitStatus
       * Rewarded Interstitial 광고 유닛의 상태 정보를 구한다.
      
       - Definition
         - void getUnitStatus(String unitId, IUnitStatus callback)
       - Parameters
         - unitId : Rewarded Interstitial 광고의 유닛 아이디
         - callback : 결과를 리턴받을 콜백 객체
       - Return
         - IUnitStatus : Rewarded Interstitial 광고의 Singleton Instance
         - 
           ```java
           public interface IUnitStatus {
               void onResult(AdiscopeError error, UnitStatus unitStatus);
           }
       
           public class UnitStatus {
               private boolean live;       // 광고 수익화 on/off
               private boolean active;     // 유닛 활성화 on/off

               public UnitStatus() {}

               public boolean isLive() {
                   return live;
               }

               public boolean isActive() {
                   return active;
               }
           }
           ```

    - setRewardedInterstitialAdListener
      * 전면형 보상 광고의 콜백을 받기 위한 콜백 리스너를 등록한다.

      - Definition
        - void setRewardedInterstitialAdListener(RewardedInterstitialAdShowListener listener)
      - Parameters
        - RewardedInterstitialAdShowListener : 전면형 보상 광고의 show에 대한 콜백을 받을 리스너