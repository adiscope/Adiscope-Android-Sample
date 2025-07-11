# Adiscope-Android-Sample
[![GitHub package.json version](https://img.shields.io/badge/Android-4.5.0-blue)](https://github.com/adiscope/Adiscope-Android-Sample/releases)
[![GitHub package.json version](https://img.shields.io/badge/iOS-4.4.0-blue)](https://github.com/adiscope/Adiscope-iOS-Sample)
[![GitHub package.json version](https://img.shields.io/badge/Unity-4.5.0-blue)](https://github.com/adiscope/Adiscope-Unity-UPM)
[![GitHub package.json version](https://img.shields.io/badge/Flutter-4.5.0-blue)](https://pub.dev/packages/adiscope_flutter_plugin)
[![GitHub package.json version](https://img.shields.io/badge/ReactNative-4.5.0-blue)](https://www.npmjs.com/package/@adiscope.ad/adiscope-react-native)

## Requirements
- minSdkVersion 23
- compileSdkVersion 35
<details>
<summary>Network Adapter Requirements</summary>
<div markdown="1">  

| Adapter    | minSdk | bidding | bidders                                                                                                                                                                                   |
|------------|--------|---------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| admob      | 23     | O       | fan, mobvista, pangle, vungle                                                                                                                                                             |
| chartboost | 21     | -       |                                                                                                                                                                                           |
| max        | 21     | O       | admob, applovin, fan, mobvista, smaato,<br/>inmobi, pangle, vungle, unityads,<br/>aps, bidmachine, ogury, <br/>google admanager, dt exchange, moloco, <br/>chartboost, ironsource, yandex |
| pangle     | 23     | -       |                                                                                                                                                                                           |
| vungle     | 21     | -       |                                                                                                                                                                                           |

#### Network Version
| Ad Network          | Android Version |
|---------------------|-----------------|
| AdMob               | 24.4.0          |
| Amazon              | 11.0.1          |
| AppLovin            | 13.3.1          |
| BidMachine          | 3.3.0           |
| Chartboost          | 9.8.3           |
| DT Exchange         | 8.3.7           |
| InMobi              | 10.8.3          |
| Ironsource          | 8.9.1           |
| Liftoff(Vungle)     | 7.5.0           |
| Meta(Fan)           | 6.20.0          |
| Mintegral(Mobvista) | 16.9.71         |
| Moloco              | 3.10.0          |
| Ogury               | 6.0.1           |
| Pangle              | 7.2.0.4         |
| Smaato              | 22.7.2          |
| Unity Ads           | 4.15.0          |
| Yandex              | 7.13.0          |

> 기존 gms SDK 사용중인 퍼블리셔는 admob, max 어댑터 사용 시 24버전으로 마이그레이션 필요 [(관련 문서)](./docs/installation_manual.md#2-network-별-추가-작업)
> - gms 22 버전: 애디스콥 `3.3.0`~`4.1.0`
> - gms 23 버전: 애디스콥 `4.1.0`~`4.3.2`
> - gms 24 버전: 애디스콥 `4.4.0` 이상

</div>
</details>


## Contents
* [**Integration Guide**](#integration-guide) ([Java ver](./README.md))
  * [1. Import Adiscope Sdk](#1-import-adiscope-sdk)
  * [2. Initialize](#2-initialize-adiscope-sdk)
  * [3. Set User Id](#3-set-user-id)
* [**Ad Formats**](#ad-formats)
  * [Offerwall Ads](#offerwall-ads)
  * [Rewarded Ads](#rewarded-ads)
  * [Interstitial Ads](#interstitial-ads)
  * [Rewarded Interstitial Ads](#rewarded-interstitial-ads)
  * [Ad Event](#ad-event)
* [API Documentation](./docs/api_documentation.md)
* [Error Information](./docs/error_info.md)
* [Reward Callback](./docs/reward_callback_info.md)
* [Release Note](https://github.com/adiscope/Adiscope-Android-Sample/wiki/release_note)

<br/>

## Integration Guide
### 1. Import Adiscope Sdk
#### 1-1. Add Adiscope core module

**build.gradle(root)**
```groovy
repositories {
    // [required] adiscope library
    maven {
        url 'https://repository.adiscope.com/repository/adiscope/'
    }
}
```
<br/>  

**build.gradle(app)**  
앱 모듈의 build.gradle의 `manifestPlaceholders`에 애디스콥 설정값을 정의해야 하며, <span style="color:red">미정의 시 컴파일 에러가 발생함.</span>
애디스콥 측에 아래 값에 대해 문의 후 기입

* `adiscope_media_id`: 매체 아이디
* `adiscope_media_secret`: 매체 시크릿키
* `adiscope_sub_domain`: 옵션값 ([오퍼월 상세페이지 이동 기능](./docs/api_documentation.md#showdetail)에 사용하는 값으로, 필요 시 담당자 전달 예정)


```groovy
android {
    defaultConfig {
        manifestPlaceholders = [
            adiscope_media_id    : "media id 기입필요",
            adiscope_media_secret: "media secret 기입필요",
            adiscope_sub_domain  : ""  // 옵션값으로 사용 시 value에 전달값을 기입
        ]
    }
}

dependencies {
    // [required] adiscope core library
    implementation 'com.nps.adiscope:adiscopeCore:4.5.0'
    implementation 'com.nps.adiscope:adiscopeAndroid:1.2.2'
}
```
<br/>


**AndroidManifest.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
          xmlns:tools="http://schemas.android.com/tools">
    <application>
        <!-- Define mediaId, secretKey metadata and 
         use AdiscopeSdk.initialize(activity, listener) function,
         sdk reads this information and initializes it  -->
        <meta-data android:name="adiscope_media_id" android:value="${adiscope_media_id}"/>
        <meta-data android:name="adiscope_media_secret" android:value="${adiscope_media_secret}"/>
    </application>
</manifest>
```

<br/>

#### 1-2. Add required network module
운영에 필요한 각각의 네트워크 어댑터를 연동

**build.gradle(root)**  
max, pangle, chartboost 네트워크 어댑터를 연동할 경우 각 주석을 참고하여 저장소 url 추가
```groovy
repositories {
    google()
    mavenCentral()

    maven { url "https://s3.amazonaws.com/smaato-sdk-releases/" } // max 연동 시 추가
    maven { url "https://artifactory.bidmachine.io/bidmachine" } // max 연동 시 추가
    maven { url "https://maven.ogury.co" } // max 연동 시 추가
    maven { url "https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea" } // max 연동 시 추가
    maven { url "https://android-sdk.is.com" } // max 연동 시 추가
    maven { url "https://artifact.bytedance.com/repository/pangle" } // max 혹은 pangle 연동 시 추가
    maven { url 'https://cboost.jfrog.io/artifactory/chartboost-ads/' } // max 혹은 chartboost 연동 시 추가
}
```

<br/>

**build.gradle(app)**  
운영에 필요한 각각의 네트워크 어댑터 의존성을 추가  
비딩을 지원하는 admob, max 어댑터는 각각 하기 네트워크들이 비더로 포함됨  
비더 네트워크를 워터폴로 함께 운영하려면 워터폴 어댑터 라이브러리를 선택적으로 포함해야 함

> ex) admob 비딩을 사용하면서 비더 네트워크를 워터폴로 운영할 경우  
> -> admob, pangle, vungle 어댑터를 연동

* admob
  * fan, mobvista, pangle, vungle
* max
  * admob, applovin, pangle, vungle, chartboost
  * (only max bidder) unityads, smaato, inmobi, aps, bidmachine, ogury, fan, mobvista, google admanager, dt exchange, moloco, ironsource, yandex

> `3.9.0~` adiscopeCore 버전 기준으로 코어 버전과 매핑되는 어댑터 버전이 아닐 경우 <br/>
> 이니셜라이즈 시점에 아래와 같이 에러 레벨의 로그가 표시됩니다.

![adapter version checker log](https://github.com/user-attachments/assets/286e83f0-8b63-4e3f-bb09-ad86e15df83c)

```groovy
dependencies {
    // bidding, waterfall adapter
    implementation 'com.nps.adiscope:adapter.admob:24.4.0.0'            // admob
    
    // bidding adapter
    implementation 'com.nps.adiscope:adapter.max:13.3.1.0'              // max

    // waterfall adapter
    implementation 'com.nps.adiscope:adapter.chartboost:9.8.3.0'        // chartboost
    implementation "com.nps.adiscope:adapter.pangle:7.2.0.4.0"          // pangle
    implementation 'com.nps.adiscope:adapter.vungle:7.5.0.0'            // vungle
}
```
<br/>

**Admob (`AndroidManifest.xml`)**  
애드몹 어댑터 연동 시 매니페스트에 애드몹 appId를 추가해야 함  
애디스콥으로부터 값을 전달받은 후 기입 (미기입 시 앱 크래시 발생)

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
          xmlns:tools="http://schemas.android.com/tools">
    <application>
        <!-- insert admob app id for Adiscope Admob network adapter -->
        <meta-data
                android:name="com.google.android.gms.ads.APPLICATION_ID"
                android:value="INPUT_YOUR_ADMOB_APP_ID"/>
    </application>
</manifest>
```
<br/>

### 2. Initialize Adiscope Sdk
이니셜라이즈 함수는 크게 아래 두 가지로 지원하며, 용도에 따라 선택해서 사용할 수 있음
* `AdiscopeSdk.initialize(activity: Activity, mediaId: Int, mediaSecret: String, listener: AdiscopeInitializeListener)`
* `AdiscopeSdk.initialize(activity: Activity, listener: AdiscopeInitializeListener)`
* [Other Initialize API](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/api_documentation.md#adiscopesdk)

<br/>

#### A) AdiscopeSdk.initialize(activity, mediaId, mediaSecret, listener)
빌드 환경에 따라 매체 환경을 코드 내에서 분기처리하여 이니셜라이즈하는 경우

```kotlin
// initialize parameters
// mediaId: 관리자를 통해 발급
// mediaSecret: 관리자를 통해 발급
// callbackTag: 관리자를 통해 발급, 기본 ""
// childYN: 어린이 여부를 설정해주는 값 (Google GMA에 세팅)
AdiscopeSdk.initialize(
  activity,
  INPUT_YOUR_MEDIA_ID,
  "INPUT_YOUR_MEDIA_SECRET_KEY"
) { isSuccess ->
    if (isSuccess) {
        Log.d(TAG, "AdiscopeSdk initialized.")
        // (recommend) get ad instance and set ad event listener
        mOfferwallAd = AdiscopeSdk.getOfferwallAdInstance(this)
        mOfferwallAd.setOfferwallAdListener(this)

        mRewardedVideoAd = AdiscopeSdk.getRewardedVideoAdInstance(this)
        mRewardedVideoAd.setRewardedVideoAdListener(this)

        mInterstitialAd = AdiscopeSdk.getInterstitialAdInstance(this)
        mInterstitialAd.setInterstitialAdListener(this)

        mRewardedInterstitialAd = AdiscopeSdk.getRewardedInterstitialAdInstance(this)
        mRewardedInterstitialAd.setRewardedInterstitialAdListener(this)

        mAdEvent = AdiscopeSdk.getAdEventInstance(this)
        mAdEvent.setAdEventListener(this)
   } else {
        Log.d(TAG, "AdiscopeSdk initialize failed.")
   }
}
```

<br/>

#### B) AdiscopeSdk.initialize(activity, listener)
mediaId, mediaSecret 값을 고정으로 사용하는 경우

> 앱 모듈의 build.gradle의 `manifestPlaceholders`에 정의된 `adiscope_media_id`, `adiscope_media_secret` 값을
> 매니페스트에 각각 <span style="color:#3894ff">**adiscope_media_id**</span>, <span style="color:#3894ff">**adiscope_media_secret**</span> meta-data로 설정하고
> <span style="color:darkgrey">_AdiscopeSdk.initialize(activity, listener)_</span> 함수를 사용하면 SDK가 해당 meta-data 값을 읽어와 이니셜라이즈를 수행한다.

```kotlin
AdiscopeSdk.initialize(
    activity
) { isSuccess ->
    if (isSuccess) {
        Log.d(TAG, "AdiscopeSdk initialized.")
        // (recommend) get ad instance and set ad event listener
        mOfferwallAd = AdiscopeSdk.getOfferwallAdInstance(this)
        mOfferwallAd.setOfferwallAdListener(this)

        mRewardedVideoAd = AdiscopeSdk.getRewardedVideoAdInstance(this)
        mRewardedVideoAd.setRewardedVideoAdListener(this)

        mInterstitialAd = AdiscopeSdk.getInterstitialAdInstance(this)
        mInterstitialAd.setInterstitialAdListener(this)

        mRewardedInterstitialAd = AdiscopeSdk.getRewardedInterstitialAdInstance(this)
        mRewardedInterstitialAd.setRewardedInterstitialAdListener(this)

        mAdEvent = AdiscopeSdk.getAdEventInstance(this)
        mAdEvent.setAdEventListener(this)
    } else {
        Log.d(TAG, "AdiscopeSdk initialize failed.")
    }
}
```

<br/>

### 3. Set User Id
```kotlin
AdiscopeSdk.setUserId("exampleUniqueUserId")
```
* 참여/시청한 광고에 대한 보상 지급을 위한 사용자 아이디 설정 (최대길이 64자)
  * `Offerwall`, `Rewarded Video`, `Rewarded Interstitial` 사용 시 필수 설정
* 다계정 사용이 가능한 서비스일 경우, 계정 변경 시 setUserId 호출로 애디스콥에 변경 정보를 전달해주어야 함
  * 그렇지 않을 경우 변경된 계정 정보로 보상 지급이 되지 않음

<br/><br/>

## Ad Formats

### Offerwall Ads

#### Create Ad Instance
```kotlin
import com.nps.adiscope.offerwall.OfferwallAd
val mOfferwallAd = AdiscopeSdk.getOfferwallAdInstance(this)
```
<br/>

#### Set Event Callback
```kotlin
mOfferwallAd.setOfferwallAdListener(this)

override fun onOfferwallAdOpened(unitId: String) {
    // offerwall ad show completed
}

override fun onOfferwallAdFailedToShow(unitId: String, adiscopeError: AdiscopeError) {
    // offerwall ad failed to show
}

override fun onOfferwallAdClosed(unitId: String) {
    // offerwall ad closed
}
```
<br/>

#### Show
```kotlin
val OFFERWALL_UNIT_ID = ""
val excludeAdTypeList = arrayOf() // 제외할 오퍼월 광고 타입 (ex. ["CPS"])
if (mOfferwallAd.show(activity, OFFERWALL_UNIT_ID, excludeAdTypeList)) {
    // succeed
} else {
    // show is already in progress
}
```
* 애디스콥 이니셜라이즈 후 호출 가능
* 어드민 페이지에 등록된 오퍼월 광고 유닛으로 사용자에게 오퍼월 광고를 보여줌
* show는 중복 호출 불가
* show가 실행되면 `onOfferwallAdOpened`와 `onOfferwallAdFailedToShow` 중 하나가 항상 호출
* `onOfferwallAdOpened`가 호출되었다면 이후 `onOfferwallAdClosed`가 항상 호출

<br/>

#### Show Detail
오퍼월 상세 페이지 이동 함수는 두 가지로 지원
* `offerwallAd.showDetail(activity: Activity, unitId: String, excludeAdTypeList: Array<String>, sponsorshipItemId: Int)`
* `offerwallAd.showDetail(activity: Activity, url: String)`

**A) showDetail(activity, unitId, excludeAdTypeList, sponsorshipItemId)**
```kotlin
val OFFERWALL_UNIT_ID = ""
val SPONSORSHIP_ITEM_ID = ""
val excludeAdTypeList = arrayOf() // 제외할 오퍼월 광고 타입 (ex. ["CPS"])
if (mOfferwallAd.showDetail(activity, OFFERWALL_UNIT_ID, excludeAdTypeList, SPONSORSHIP_ITEM_ID)) {
    // succeed
} else {
    // show is already in progress
}
```

<br/>

**B) showDetail(activity, url)**
```java
val SPONSORSHIP_URL = ""
if (mOfferwallAd.showDetail(activity, SPONSORSHIP_URL)) {
    // succeed
} else {
    // show is already in progress
}
```
* 애디스콥 이니셜라이즈 후 호출 가능
* 특정 광고 아이템의 상세 화면으로 이동
* url는 `mediaId`, `unitId`, `excludeAdTypeList`, `sponsorshipItemId`가 포함된 형식
* 요청하고자 하는 스폰서십 아이디 및 URL은 애디스콥에 문의 필요

<br/>

### Rewarded Ads
#### Create Ad Instance
```kotlin
import com.nps.adiscope.reward.RewardedVideoAd
val mRewardedVideoAd = AdiscopeSdk.getRewardedVideoAdInstance(this) 
```
<br/>

#### Set Event Callback
```kotlin
mRewardedVideoAd.setRewardedVideoAdListener(this)

override fun onRewardedVideoAdLoaded(unitId: String) {
    // rewarded ad is ready
}

override fun onRewardedVideoAdFailedToLoad(unitId: String, adiscopeError: AdiscopeError) {
    // rewarded ad failed to load
}

override fun onRewardedVideoAdOpened(unitId: String) {
    // rewarded ad show completed
}

override fun onRewardedVideoAdClosed(unitId: String) {
    // rewarded ad closed
}

override fun onRewarded(unitId: String, rewardItem: RewardItem) {
    // user should receive the reward
    // RewardItem.getType: 보상 타입
    // RewardItem.getAmount: 보상 양
}

override fun onRewardedVideoAdFailedToShow(unitId: String, adiscopeError: AdiscopeError) {
    // rewarded ad failed to show
}
```
<br/>

#### Load
```kotlin
String RV_UNIT_ID = ""
mRewardedVideoAd.load(RV_UNIT_ID);
```
* 애디스콥 이니셜라이즈 후 로드 호출 가능
* 특정 보상형 광고 유닛에 속한 광고 네트워크의 광고를 로드
* RewardedVideoAd의 `Load`와 `Show`는 pair로 호출
  * Load를 한 후 Show를 하고, 광고를 Show한 후에는 다시 Load하여 다음 번 Show를 준비
* 광고가 Show되는 동안 다음 광고를 Load할 수 있지만 이는 사용하는 Mediation Ad Network에 따라 달라질 수 있으므로 항상 보장되는 동작은 아님
* 로드 성공 시 `onRewardedVideoAdLoaded`, 로드 실패 시 `onRewardedVideoAdFailedToLoad` 이벤트 콜백 호출
* 로드 성공 콜백에 따라 보상형 광고 송출(show) 가능
* **(Optional)** load의 시간이 필요해 로드 중에는 프로그래스바 노출 추천

<br/>

#### isLoaded
```kotlin
if (mRewardedVideoAd.isLoaded(RV_UNIT_ID)) {
    // show rewarded ad
} else {
    // do something else
}
```
* 특정 보상형 광고 유닛의 광고 로드 여부 상태를 확인할 수 있음

<br/>

#### Show
```kotlin
if(mRewardedVideoAd.show()){
    // succeed
}else{
    // this show request is duplicated
}
```
* 마지막으로 로드된 보상형 광고를 사용자에게 송출함
* show 성공 시 `onRewardedVideoAdOpened`, 실패 시 `onRewardedVideoAdFailedToShow` 이벤트 콜백 호출
* `onRewardedVideoAdOpened`가 호출되었다면 이후 `onRewardedVideoAdClosed`가 항상 호출
* RewardedVideoAd의 `Load`와 `Show`는 pair로 호출
  * Load를 한 후 Show를 하고, 광고를 Show한 후에는 다시 Load하여 다음 번 Show를 준비
* `onRewarded` 콜백이 호출되었을 경우 사용자에게 보상 지급이 가능함

<br/>

#### Callback Reward
```kotlin
override fun onRewarded(unitId: String, rewardItem: RewardItem) {
    // user should receive the reward
    // RewardItem.getType: 보상 타입
    // RewardItem.getAmount: 보상 양
}
```
* 보상이 주어져야 할 경우 `OnRewarded`가 호출되며 파라미터로 관련 정보가 전달 (`RewardItem`)
  * `RewardItem.type`: 보상 타입
  * `RewardItem.amount`: 보상의 양
* 이 보상 정보를 바탕으로 게임 내에서 보상을 지급
* `OnRewarded`는 보통 `onRewardedVideoAdOpened` 와 `onRewardedVideoAdClosed` 사이에 호출되는 경우가 많으나 광고 미디에이션 네트워크마다 동작이 다를 수 있음
* `OnRewarded`가 호출되지 않는 경우도 존재할 수 있음
  * 보상 콜백 설정을 Server-to-Server(S2S)로 하였다면, Video 시청 후에는 `OnRewarded`가 호출되지 않음
* Reward 정보는 어뷰징 방지를 위해서 S2S 방식으로 전달 받는 것을 권장
  * S2S 방식을 선택하더라도 보상이 전달 될 시에는 `OnRewarded`가 호출
  * 이때는 서버를 통해 전달받은 정보를 기준으로 처리하고, `OnRewarded`를 통해 전달받은 정보는 검증용으로 사용하거나 무시하도록 함


<br/>

### Interstitial Ads

#### Create Ad Instance
```kotlin
import com.nps.adiscope.interstitial.InterstitialAd
val mInterstitialAd = AdiscopeSdk.getInterstitialAdInstance(this)
```

#### Set Event Callback
```kotlin
mInterstitialAd.setInterstitialAdListener(this)

override fun onInterstitialAdLoaded() {
    // interstitial ad is ready
}

override fun onInterstitialAdFailedToLoad(adiscopeError: AdiscopeError) {
    // interstitial ad failed to load
}

override fun onInterstitialAdOpened(unitId: String) {
    // interstitial ad show completed
}

override fun onInterstitialAdClosed(unitId: String) {
    // interstitial ad closed
}

override fun onInterstitialAdFailedToShow(unitId: String, adiscopeError: AdiscopeError) {
    // interstitial ad failed to show
}
```

#### Load
```kotlin
val INTERSTITIAL_UNIT_ID = ""
mInterstitialAd.load(INTERSTITIAL_UNIT_ID)
```
* 애디스콥 이니셜라이즈 후 로드 호출 가능
* 특정 인터스티셜 유닛에 속한 광고 네트워크의 광고를 로드
* Interstitial의 `Load`와 `Show`는 pair로 호출
  * Load를 한 후 Show를 하고, 광고를 Show한 후에는 다시 Load하여 다음 번 Show를 준비
* 광고가 Show되는 동안 다음 광고를 Load할 수 있지만 이는 사용하는 Mediation Ad Network에 따라 달라질 수 있으므로 항상 보장되는 동작은 아님
* 로드 성공 시 `onInterstitialAdLoaded`, 로드 실패 시 `onInterstitialAdFailedToLoad` 이벤트 콜백 호출
* 로드 성공 콜백에 따라 인터스티셜 광고 송출(show) 가능

#### isLoaded
```kotlin
if (mInterstitialAd.isLoaded(INTERSTITIAL_UNIT_ID)) {
    // show interstitial ad
}else {
    // ad is not loaded
}
```
* 특정 인터스티셜 유닛의 광고 로드 여부 상태를 확인할 수 있음

#### Show
```kotlin
if(mInterstitialAd.show()){
    // succeed
}else{
    // this show request is duplicated
}
```
* 마지막으로 로드된 인터스티셜 광고를 사용자에게 송출함
* show 성공 시 `onInterstitialAdOpened`, 실패 시 `onInterstitialAdFailedToShow` 이벤트 콜백 호출
* `onInterstitialAdOpened`가 호출되었다면 이후 `onInterstitialAdClosed`가 항상 호출
* Interstitial의 `Load`와 `Show`는 pair로 호출
  * Load를 한 후 Show를 하고, 광고를 Show한 후에는 다시 Load하여 다음 번 Show를 준비

<br/>

### Rewarded Interstitial Ads

#### Create Ad Instance
```kotlin
import com.nps.adiscope.rewardinterstitial.RewardedInterstitialAd
val mRewardedInterstitialAd = AdiscopeSdk.getRewardedInterstitialAdInstance(this)
```
<br/>

#### Set Event Callback
```kotlin
mRewardedInterstitialAd.setRewardedInterstitialAdListener(this)

override fun onRewardedInterstitialAdSkipped(unitId: String) {
    // user skipped rewarded interstitial ad
}

override fun onRewardedInterstitialAdOpened(unitId: String) {
    // rewarded interstitial ad show completed
}

override fun onRewardedInterstitialAdClosed(unitId: String) {
    // rewarded interstitial ad closed
}

override fun onRewardedInterstitialAdRewarded(unitId: String, rewardItem: RewardItem) {
    // user should receive the reward
    // RewardItem.getType: 보상 타입
    // RewardItem.getAmount: 보상 양
}

override fun onRewardedInterstitialAdFailedToShow(unitId: String, adiscopeError: AdiscopeError) {
    // rewarded interstitial ad failed to show
}
```
<br/>

#### Preload
```kotlin
// preload rewarded interstitial ad which belongs to specific unit list
val unitList = arrayOf("RI_UNIT1", "RI_UNIT2", "RI_UNIT3")
mRewardedInterstitialAd.preloadUnit(unitList)
```
* 파라미터에 지정한 전면형 보상 광고 유닛들에 대한 로드를 순차적으로 진행
* 이니셜라이즈 콜백 이후 1회 호출 권장

#### Preload All
```kotlin
// preload all activated rewarded interstitial ad
mRewardedInterstitialAd.preloadAll()
```
* 어드민 페이지에 등록된 활성화된 전면형 보상 광고 유닛들을 순차적으로 로드
* 이니셜라이즈 콜백 이후 1회 호출 권장

<br/>

#### Show
```kotlin
mRewardedInterstitialAd.show("RI_UNIT1")
```
* 로드된 전면형 보상 광고의 유닛을 지정하여 사용자에게 보여줌
* 해당 유닛이 로드되어 있으면 안내 팝업을 보여준 뒤 해당 광고를 사용자에게 보여줌
  * 안내 팝업의 건너뛰기 버튼 클릭 시 팝업이 종료되며 `onRewardedInterstitialAdSkipped`가 호출됨
  * `onRewardedInterstitialAdRewarded`는 보통 `onRewardedInterstitialAdOpened` 와 `onRewardedInterstitialAdClosed` 사이에 호출되는 경우가 많으나 광고 미디에이션 네트워크마다 동작이 다를 수 있음
* show는 중복하여 호출할 수 없음
* `onRewardedInterstitialAdClosed` 혹은 `onRewardedInterstitialAdFailedToShow`가 호출되면 내부에서 해당 유닛을 자동으로 로드한다

<br/>

#### Callback Reward
```kotlin
override fun onRewardedInterstitialAdRewarded(unitId: String, rewardItem: RewardItem) {
    // user should receive the reward
    // RewardItem.getType: 보상 타입
    // RewardItem.getAmount: 보상 양
}
```
* 보상이 주어져야 할 경우 `onRewardedInterstitialAdRewarded`가 호출되며 파라미터로 관련 정보가 전달 (`RewardItem`)
  * `RewardItem.type`: 보상 타입
  * `RewardItem.amount`: 보상의 양
* 이 보상 정보를 바탕으로 게임 내에서 보상을 지급
* `onRewardedInterstitialAdRewarded`는 보통 `onRewardedInterstitialAdOpened` 와 `onRewardedInterstitialAdClosed` 사이에 호출되는 경우가 많으나 광고 미디에이션 네트워크마다 동작이 다를 수 있음
* `onRewardedInterstitialAdRewarded`가 호출되지 않는 경우도 존재할 수 있음
  * 보상 콜백 설정을 Server-to-Server(S2S)로 하였다면, Video 시청 후에는 `onRewardedInterstitialAdRewarded`가 호출되지 않음
* Reward 정보는 어뷰징 방지를 위해서 S2S 방식으로 전달 받는 것을 권장
  * S2S 방식을 선택하더라도 보상이 전달 될 시에는 `onRewardedInterstitialAdRewarded`가 호출
  * 이때는 서버를 통해 전달받은 정보를 기준으로 처리하고, `onRewardedInterstitialAdRewarded`를 통해 전달받은 정보는 검증용으로 사용하거나 무시하도록 함

<br/>

### Ad Event

#### Create Ad Instance
```kotlin
import com.nps.adiscope.adevent.AdEvent
val mAdEvent = AdiscopeSdk.getAdEventInstance(this)
```
<br/>

#### Set Event Callback
```kotlin
mAdEvent.setAdEventListener(this)

override fun onAdEventOpened(unitId: String) {
    // ad event show completed
}

override fun onAdEventFailedToShow(unitId: String, adiscopeError: AdiscopeError) {
    // ad event failed to show
}

override fun onAdEventClosed(unitId: String) {
    // ad event closed
}
```
<br/>

#### Show
```kotlin
val AD_EVENT_UNIT_ID = ""
if (mAdEvent.show(activity, AD_EVENT_UNIT_ID)) {
    // succeed
} else {
    // show is already in progress
}
```
* 애디스콥 이니셜라이즈 후 호출 가능
* 애디스콥 시스템에 등록된 Ad Event 유닛으로 사용자에게 Ad Event 광고를 보여줌
* show는 중복 호출 불가
* show가 실행되면 `onAdEventOpened`와 `onAdEventFailedToShow` 중 하나가 항상 호출
* `onAdEventOpened`가 호출되었다면 이후 `onAdEventClosed`가 항상 호출

<br/>