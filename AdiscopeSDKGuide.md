# Adiscope for Android Integration


## version history.Android
|날짜|변경 사항|
|----------|------------------|
|2021/03/17| 기능 변경 <br>mobvista  13.1.1 → 15.4.31</br> unityads  UnityMonetization -> UnityAds 변경 |
|2021/02/19| 이슈 수정 <br>offerwall 문의 하기 이슈 수정|
|2021/02/16| 이슈 수정 <br> 무한로딩 이슈 수정 <br>android target30 에서 패키지 네임 못가져오는 이슈 수정 |
|2021/01/12| 기능 변경 <br>네트워크 tapjoy 추가 12.7.1<br>네트워크 applovin 추가 9.14.9<br>에러메시지 고도화<br>버전관리 기능 추가<br>각종 기능 개선 |
|2021/01/5| 이슈 수정 <br>RV, Interstitial 최초 진입시 ADID 가져 오지 못하는 이슈 수정 |
|2020/12/02| 이슈 수정 <br>오퍼월 최초 진입시 ADID 가져 오지 못하는 이슈 수정|
|2020/11/24| 기능 변경 <br>Adiscope-android-sdk.adiscopeCore 1.6.0 -> 1.6.1<br>target sdk version 30 대응<br>adcolony sdk version 변경 : 4.1.4 -> 4.3.0<br>ironsouece sdk version 변경 : 6.16.1 -> 7.0.3<br>기타 사용성 개선|
|2020/11/13| 기능 변경 <br>멀티인스턴스 체계 적용<br>멀티인스턴스 체계 적용으로 안한 각 네트워크사의 adapter 구조 변경<br>Adiscope-android-sdk.adiscopeCore 1.5.9 -> 1.6.0
|2020/10/22	| 기능 변경 <br>target sdk version 30 대응<br>admob sdk version 변경 : 17.2.0 -> 19.4.0<br>unityads sdk version 변경 : 3.4.2 -> 3.5.0<br>vungle sdk version 변경 : 6.5.3 -> 6.8.0<br>fan sdk version 변경 : 5.9.0-> 6.1.0|
|2020/08/20	| 이슈 수정 <br>X509Certificate 경고 수정|
|2020/08/06	| 기능 개선 <br>오퍼월 기능 개선|
|2020/06/23	| 기능 추가 <br>인터스티셜 기능 추가 및 연동가이드 설명 추가 <br>admob 인터스티셜 네트워크 추가|
|2020/06/02	| 기능 변경 <br>OfferwallAd.show(String unitId) 인터페이스가 OfferwallAd.show(Activity activity, String unitId) 로 변경됨<br>Admob 네트워크의 Google Play Services Ads 버전이 17.2.0으로 변경됨|
|2020/05/15	| 기능 개선 <br>Vungle network sdk 업데이트 : 6.4.11 -> 6.5.3 (use androidx)<br>Mobvista network sdk 업데이트 : 9.12.7 -> 13.1.1 (use androidx)<br>Vungle, Mobvista 연동가이드 설명 변경<br>Vungle, Mobvista 새버전을 사용하기위해서는 앱내에 androidx 라이브러리가 포함되어야합니다.<br>앱 환경에 따라서 androidx migration이 필요할 수 있습니다. (https://developer.android.com/jetpack/androidx/migrate)|
|2020/03/02	| 기능 변경 <br>setUserId API의 userId 문자열 32자 제한 조건이 제거됨<br>연동가이드 변경 setUserId API의 userId 문자열 32자 제한사항에 대한 설명 제거됨|
|2020/02/21	| 연동가이드 변경 <br>구글가족정책 가이드 추가|
|2020/02/14 | 연동가이드 변경 <br> Adiscope sdk 배포 방식을 maven repository로 변경 및 연동가이드 수정|
|2020/02/06 | 연동가이드 변경 <br> adcolony proguard 설정 변경|
|2020/01/31 | 기능 변경/연동가이드 변경 <br> Unityads sdk 교체 : 3.0.0 -> 3.4.2<br>Unityads AndroidManifest.xml 항목 변경|
|2020/01/08	| 기능 변경 <br>Vungle (v6.4.11) 연동가이드 대폭 변경 (Activity, proguard 설명 변경)<br>Youappi Reward Video Network 제거|
|2019/11/01	| 기능 변경/연동가이드 변경 <br>FAN sdk 교체 : 5.0.1 -> 5.5.0<br>FAN 연동가이드 대폭 변경|
|2019/10/24	| 기능 변경 <br>Applovin 네트워크 제거 및 Applovin 관련 연동가이드 제거<br>Mobvista 네트워크 연동가이드 변경<br>AndroidManifest.xml의 MTGFileProvider provider 항목 제거<br>mtg_provider_paths.xml xml 파일 생성하는 내용 제거|
|2019/08/09 | 연동가이드 설명 추가 <br>Mobvista sdk 설정 가이드 및 proguard 설정 변경|
|2019/3/4	  | 기능 추가 <br>Vungle network sdk 4.0.3 -> 6.3.24 업데이트 (AndroidManifest, proguard 설정 및 라이브러리 구조 변경)<br>Youappi Reward Video Network 추가 (v4.3.10)<br>Offerwall 처리 개선 - 설치확인 기능의 예외 처리 추가|
|2019/01/04	| 기능 추가 <br>Applovin network sdk 7.0.3 -> 8.1.4 업데이트<br>Unityads network sdk 2.1.2 -> 3.0.0 업데이트 (proguard 설정 변경)|
|2018/11/08	| 기능 추가 <br>FAN 5.0.1 (Facebook Audience Network) Reward Video Network 추가<br>Admob 버전 17 지원|
|2018/08/28	| 기능 추가 <br>Admob Reward Video Network 추가|
|2018/06/25	| 기능 추가 <br>setUserId API에 사용되는 userId 파라미터의 길이 제한이 20자에서 32자로 변경되었습니다.|
|2018/06/14	| 기능 추가 <br>오퍼월 광고는 Adiscope 서버가 3rd-party 서버로부터 광고 캠페인들을 직접 수집하는 방식으로 변경되었습니다. 따라서 3rd-party 오퍼월 sdk들은 제거되었습니다.<br>인터페이스 변경<br>메인 클래스의 클래스 이름이 변경되었습니다. (com.nps.adiscope.Adiscope -> com.nps.adiscope.AdiscopeSdk)|
|2018/03/04	| 기능 추가 <br>OptionSetter.setUseCloudFrontProxy(boolean useCloudFrontProxy) API 추가|


## 애디스콥 네트워크 버전 호환정보
|adiscope core version|adcolony|admob|applovin|fan|ironsource|mobvista|tapjoy|unityads|vungle|
|---------------------|--------|-----|--------|---|----------|--------|------|--------|------|
|~1.1.5|~3.3.10.2|~1.1.1.3|no service|~5.5.0.2|~6.6.5.2|~13.1.1.2|no service|~3.4.2.2|~6.4.11.2|
|1.15~1.6.3   |3.3.10.3 ~ 4.3.0.0   |1.1.1.4~19.4.0.1	|no service|5.5.0.3~6.1.0.1	|6.6.5.3~7.0.3.0	|13.1.1.3~13.1.1.2	|no service|3.4.2.3~3.5.0.1	|6.5.3.0~6.8.0.1|
|1.6.4~1.6.6	|4.3.0.1~|19.4.0.2~|9.14.9.0~|6.1.0.2~|7.0.3.1~|15.4.31.0~|12.7.1.2~|3.5.0.3~|6.8.0.2~|
|2.0.0~	|4.3.0.2~|19.4.0.3~|9.14.10.0~|6.4.0.1~|7.0.3.2~|15.4.31.1~|12.7.1.3~|3.5.0.4~|6.8.0.3~|


## Adiscope Android Sdk Install

### 1. gradle 연동 설정

project build.gradle
```
allprojects {
    repositories {
        maven {
            url 'https://repository.adiscope.com/repository/adiscope/'
        }
        ...
    }
}
```

module build.gradle
```
dependencies {
 
    // [required] adiscope library
    implementation 'com.nps.adiscope:adiscopeCore:1.6.6'
    implementation 'com.nps.adiscope:adiscopeAndroid:1.1.2'
 
    // adiscope sdk have to extract Google Advertising Id.
    // if com.google.android.gms.ads.identifier.AdvertisingIdClient class is not included in your app, uncomment following code
    // implementation 'com.google.android.gms:play-services-basement:8.3.0'
 
    // [optional] adiscope rewarded video networks
        implementation 'com.nps.adiscope:adapter.adcolony:4.3.0.1'      // adcolony
        implementation 'com.nps.adiscope:adapter.admob:19.4.0.2'        // admob (use play-services-ads:19.4.0 dependency)
        implementation 'com.nps.adiscope:adapter.applovin:9.14.9.0'        // applovin
        implementation 'com.nps.adiscope:adapter.fan:6.1.0.2'           // fan
        implementation 'com.nps.adiscope:adapter.ironsource:7.0.3.1'   // ironsource
        implementation 'com.nps.adiscope:adapter.mobvista:15.4.31.0'     // mobvista (use androidx)
        implementation 'com.nps.adiscope:adapter.tapjoy:12.7.1.2'        // tapjoy
        implementation 'com.nps.adiscope:adapter.unityads:3.5.0.3'      // unityads
        implementation 'com.nps.adiscope:adapter.vungle:6.8.0.2'        // vungle (use androidx)
     
    // [optional] adiscope interstitial networks
        implementation 'com.nps.adiscope:adapter.admob:19.4.0.2'        // admob (use play-services-ads:19.4.0 dependency)
}
```
- adiscopeCore, adiscopeAndroid 라이브러리는 필수로 포함시켜야합니다.
- play-services-basement은 옵션으로서 adiscope sdk 내에서 adid 추출에 사용됩니다. 앱에서 이미 google play-services-ads 를 사용중이라면 이것을 포함시킬 필요가 없습니다. 또는 adapter.admob 를 사용하는 경우에도 adapter.admob의 dependency에 google play-services-ads가 포함되있기때문에, play-services-basement를 포함시킬 필요가 없습니다.
- video network adapter들 중에서 앱에서 사용하고자하는 adapter만 implementation으로 추가하시면 됩니다. 모든 video network adapter를 implementation했더라도, adiscope admin 에서 off 설정된 network adapter들은 런타임에 구동되지 않습니다.


### 2. Network 별 추가작업

#### Admob - Rewarded Video / Interstitial Network
AndroidManifest.xml 의 application 태그 하위에 아래의 meta-data가 선언되어야합니다.

<br>AndroidManifest.xml 설정
```
<application ..>
// ... (생략)
    <meta-data android:name="com.google.android.gms.version" android:value="@integer/google_play_services_version"/>
 
</application>
```

#### Fan - Rewarded Video Network
디바이스에서 광고를 테스트하기위해서는 Facebook admin에 디바이스의 ADID가 등록되어야합니다.

#### Mobvista - Rewarded Video Network
13.1.1.0 버전부터 androidx 라이브러리를 사용합니다. 앱 환경에 따라서 androidx migration이 필요할 수 있습니다. <a href="#heading-ids">https://developer.android.com/jetpack/androidx/migrate</a>

#### Vungle - Rewarded Video Network
6.5.3.0 버전부터 androidx 라이브러리를 사용합니다. 앱 환경에 따라서 androidx migration이 필요할 수 있습니다. (https://developer.android.com/jetpack/androidx/migrate)



## Overview.Android
## Adiscope
* Adiscope class는 Adiscope Sdk의 초기화 및 설정을 수행한다.
1. 초기화
   - mediaId, mediaSecret이 필요하며 이 값은 admin page를 통해 app을 등록하여 발급받아야 한다.
   -  ```
      public static void initialize(Activity activity, AdiscopeInitializeListener listener)
      public static void initialize(Activity activity, String mediaId, String mediaSecret)
      public static void initialize(Activity activity, String mediaId, String mediaSecret, AdiscopeInitializeListener listener)
      public static void initialize(final Activity activity, String mediaId, String mediaSecret, String callbackTag, AdiscopeInitializeListener listener)
      ```
   * 애디스콥의 모든 서비스는 위 초기화 함수가 호출되고 성공 되었다는 콜백 응답이 온 뒤에 이용이 가능합니다.<br> offerwall, rewaredVideo, interstitial 인스턴스는 이 초기화 없이 생성 및 이용이 불가능합니다.

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

******

### Adiscope
#### Adiscope class는 Adiscope Sdk의 초기화 및 설정을 수행한다.

1. 초기화

   <br>mediaId, mediaSecret이 필요하며 이 값은 admin page를 통해 app을 등록하여 발급받아야 한다.

    ```
    //callback tag 미사용 
    import com.nps.adiscope.AdiscopeSdk;
  
    // initialize AdiscopeSdk, must be called in main thread
    AdiscopeSdk.initialize(Activity activity, String mediaId, String mediaSecret, AdiscopeInitializeListener listener) 
    ```

    ```
    //callback tag 사용

    import com.nps.adiscope.AdiscopeSdk;
  
    // initialize AdiscopeSdk, must be called in main thread
    AdiscopeSdk.initialize(final Activity activity, String mediaId, String mediaSecret, String callbackTag, AdiscopeInitializeListener listener)
    ```
2. 사용자 정보 설정

    <br>application 사용자의 unique user id를 Adiscope Sdk에 전달한다. unique user id는 보상이 지급 될 시 사용자를 구분하기 위해 사용된다.

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
   ```
    // Show Ad
 
    import com.nps.adiscope.AdiscopeSdk;
    import com.nps.adiscope.offerwall.OfferwallAd;
  
    // show offerwall ad
    if (offerwallAd.show(activity, "UNIT_ID")) {
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
      - 
## API Reference - Sdk.Android
### Adiscope
1.  Class Declaration
    ```
        public class AdiscopeSdk {

            public static void initialize(Activity activity, AdiscopeInitializeListener listener)

            public static void initialize(Activity activity, String mediaId, String mediaSecret)

            public static void initialize(Activity activity, String mediaId, String mediaSecret, AdiscopeInitializeListener listener)

            public static void initialize(final Activity activity, String mediaId, String mediaSecret, String callbackTag, AdiscopeInitializeListener listener)
            
            public static OfferwallAd getOfferwallAdInstance(Activity activity)
                        
            public static RewardedVideoAd getRewardedVideoAdInstance(Activity activity)
    
            public static InterstitialAd getInterstitialAdInstance(Activity activity)
    
            public static OptionSetter getOptionSetterInstance(Activity activity) 
            
            public static void setUserId(String userId)
            
            public static void getUnitStatus(String unitId, IUnitStatus callback)                
    
            public static String getNetworksVersion()
        }
    
        public interface AdiscopeInitializeListener {
            void onInitialized(boolean isSuccess);
        }
            
    ```
2. Methods
   - initialize
     *  Sdk 기능을 초기화 한다.

     - Definition
       - public static void initialize(Activity activity, AdiscopeInitializeListener listener)
       - public static void initialize(Activity activity, String mediaId, String mediaSecret)
       - public static void initialize(Activity activity, String mediaId, String mediaSecret, AdiscopeInitializeListener listener)
       - public static void initialize(final Activity activity, String mediaId, String mediaSecret, String callbackTag, AdiscopeInitializeListener listener)
     - Parameters
       - activity : Activity
       - mediaId : Amdin page에서 등록한 해당 application에 대한 Id
       - mediaSecret : mediaId에 대응되는 secret key
       - callbackTag : 보상 콜백을 복수 개로 등록해서 사용할시에 어떤 보상 콜백을 사용할지 지정한다. 지정하지 않을시에는 기본 보상콜백이 사용된다.
     - Return
       -

   - setUserId
     * Application 사용자의 Unique Id를 설정한다. 이 정보는 reward 지급 등에 있어 사용자를 구분하는데 사용된다.

     - Definition
       - public static boolean setUserId(String userId)
     - Parameters
       - userId : application user's unique id
     - Return
       - bool : load된 광고가 있을 시 True, load된 광고가 없을 시 False

   - GetOfferwallAdInstance
     * Offerwall Ad의 전역 Singleton 객체를 생성한다.
     * Initialize() 를 호출하고 반드시 AdiscopeInitializeListener 의 콜백함수 onInitialized 의 isSuccess값이 true 로 받은뒤 객체 생성 해주어야한다.

     - Definition
       - public static OfferwallAd getOfferwallAdInstance(Activity activity)
     - Parameters
       - activity : Activity
     - Return
       - OfferwallAd : Offerwall 광고의 Singleton Instance

   - GetRewardedVideoAdInstance
     * Rewarded Video Ad의 전역 Singleton 객체를 생성한다.
     * Initialize() 를 호출하고 반드시 AdiscopeInitializeListener 의 콜백함수 onInitialized 의 isSuccess값이 true 로 받은뒤 객체 생성 해주어야한다.

     - Definition
       - public static RewardedVideoAd getRewardedVideoAdInstance(Activity activity)
     - Parameters
       - activity : Activity
     - Return
       - RewardedVideoAd : Rewarded Video 광고의 Singleton Instance


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
          ```
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
## API Reference - OptionSetter.Android
### OptionSetter
1.  Class Declaration
    ```
        public interface OptionSetter {
            void setUseCloudFrontProxy(boolean useCloudFrontProxy);
            void setChildYN(String childYN);
         }
    ```
2. Methods
   - setUseCloudFrontProxy
     *  AWS Cloud Front Proxy를 사용할지 말지 설정한다.<br>이 옵션을 사용하게되면, 북미, 유럽에서 게임을 서비스할시에 Adiscope API의 응답속도가 향상된다.

     - Definition
       - void setUseCloudFrontProxy(boolean useCloudFrontProxy)
     - Parameters
       - useCloudFrontProxy : AWS Cloud Front Proxy를 사용할지말지 여부
     - Return

## API Reference - AdiscopeError.Android

### AdiscopeError
1. Class Declaration
   ```
    package com.nps.adiscope;
 
    public enum AdiscopeError
   ```
2. ErrorCode

|Code	|Value	|Description	|Cause	|Instruction|
|-------|-------|---------------|-------|-----------|
|INTERNAL_ERROR	|0	|"Internal error"	|Adiscope Sdk 내부 오류 혹은 Adiscope Server 오류	|지속적으로 발생 시 Adiscope 개발팀에 문의|
|MEDIATION_ERROR	|1	|"3rd party mediation network error"	|Mediation 광고 Network의 3rd party sdk 혹은 server 오류	|지속적으로 발생 시 Adiscope 개발팀에 문의|
|INITIALIZE_ERROR	|2	|"mediaId/mediaSecret must be valid"	|Adiscope.Sdk.Initialize 시 mediaId/mediaSecret이 유효하지 않음	|지속적으로 발생 시 Adiscope 개발팀에 문의|
|SERVER_SETTING_ERROR	|3	|"Server settings are incorrect"	|광고를 보여주기 위해 필요한 내부 설정값 오류. AndroidManifest에 설정된 값이거나 Runtime 시 server로 부터 전달 받은 값이 정확하지 않음<br>Adiscope admin 설정의 수익화, 유닛 활성화가 OFF인 경우	|Adiscope admin page에서 등록된 media (application)의 id와 secret을 확인<br>Adiscope admin page의 설정 확인|
|INVALID_REQUEST	|4	|"The request is invalid"	|Show() 시 입력한 unitId 오류	|Adiscope admin page에 정의된 각 unitId를 다시 확인 후 Show()에 입력|
|NETWORK_ERROR	|5	|"There is a network problem"	|Network read/write timed out 혹은 Network connection 오류	|Device의 network 연결 상태를 확인|
|NO_FILL	|6	|"No more ads to show"	|하루에 볼 수 있는 Rewarded Video 광고의 횟수를 모두 소진 하였을 경우	|Adiscope admin page의 media (application)에 설정된 기준 시각이 지나면 광고 횟수가 다시 초기화 되므로 기준 시각 이후(next day)에 다시 시도|
|TIME_LIMIT	|7	|"It was time-limited"	|Rewarded Video 광고를 한번 보여주고 난 후 일정 시간 (30초~60초, Adiscope admin page에서 설정된 시간 간격)이 지나기 전에 다시 Show를 시도할 경우	|Adiscope admin page에서 설정된 시간 간격 만큼 간격을 두고 다시 시도|
|"NOT_EXIST_IDFA (Only iOS)"	|8	|iOS 디바이스에서 추출된 IDFA 값이 "00000000-0000-0000-0000-000000000000" 인 경우	|"Internal error"	|iOS 디바이스 설정에서 "광고 추적 제한" 설정이 ON 일 경우에 발생되며, 이 경우, SDK에서는 사용자가 "광고 추적 제한" 설정을 OFF 하도록 유도하는 안내 문구를 System Alert으로 띄운다. 사용자가 "광고 추적 제한" 설정을 OFF 후 게임을 재실행하면 광고 참여가 가능하다|
|GOOGLE_FAMILY_ERROR (Only Android)	|9	|"It is not available because of Google Family Policy"	|구글 가족정책에 의거, 사용할 수 없는 기능이 호출되었음을 의미	|구글 가족정책 가이드 참고|
|INVALID_ADID (Only Android)	|10	|"ADID value is invalid"	|adid 가 없거나 유효하지 않음을 의미	|지속적으로 발생 시 Adiscope 개발팀에 문의|
|TIME_OUT	|11	|"Time out"	|세팅한 기간 내에 Mediation 광고 네트워크의 로드 성공 콜백이 오지 않은 경우	|지속적으로 발생 시 Adiscope 개발팀에 문의|
|SHOW_CALLED_BEFORE_LOAD	|12	|"Show called before load"	|RewardedVideoAd.Show()를 Load() 없이 실행하였을 경우	|지속적으로 발생 시 Adiscope 개발팀에 문의|
|"UNKNOWN_ERROR (Only Unity)"	|-1	|""	|알 수 없는 오류	|지속적으로 발생 시 Adiscope 개발팀에 문의|


## API Reference - InterstitialAd.Android
### InterstitialAd
1.  Class Declaration
    ```
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
       -
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
1.  Class Declaration
    ```
        public interface OfferwallAd {

            boolean show(Activity activity, String unitId);

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
       - boolean show(Activity activity, String unitId)
     - Parameters
       - activity : 상위 액티비티
       - unitId : 사용자에게 표시할 광고의 unit id. Admin page에 등록된 id와 동일해야 한다.
     - Return
       - bool : show가 정상적으로 시작되면 True, 만약 이미 다른 show가 처리되는 중이라면 False
     * show가 실행되면 (return값이 True일 경우) onOfferwallAdOpened 와 onOfferwallAdFailedToShow 중 하나가 항상 호출되고, onOfferwallAdOpened가 호출되었다면 이후 onOfferwallAdClosed가 항상 호출된다.

     - Callback
       - |Method|Info|Parameter|
       |-------|---|---------|
       |onOfferwallAdOpened	|Offerwall 광고창이 열릴 때	 |String unitId|
       |onOfferwallAdClosed		|Offerwall 광고창이 닫혔을 때	| String unitId|
       |onOfferwallAdFailedToShow		|Offerwall 광고창을 보여 줄 수 없을 때	| String unitId, AdiscopeError error|

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

## API Reference - RewardedVideoAd.Android
### RewardedVideoAd
1.  Class Declaration
    ```
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
       -
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
       - 
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


