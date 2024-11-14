API Reference
====================================
- [AdiscopeSdk](#adiscopesdk)
  - [initialize](#initialize)
  - [isInitialize](#isinitialize)
  - [setUserId](#setuserid)
  - [setRewardedCheckParam](#setrewardedcheckparam)
  - [getUnitStatus](#getunitstatus)
  - [getSDKVersion](#getsdkversion)
  - [getNetworksVersion](#getnetworksversions)
  - [getAdInstance](#getinterstitialadinstance)
- [OptionSetter](#optionsetter)
    - [setUseCloudFrontProxy](#setusecloudfrontproxy)
    - [setChildYN](#setvolumeoff)
    - [setVolumeOff](#setvolumeoff)
- [AdiscopeError](#adiscopeerror)
- [InterstitialAd](#interstitialad)
- [RewardedVideoAd](#rewardedvideoad)
- [RewardedInterstitialAd](#rewardedinterstitialad)
- [OfferwallAd](#offerwallad)
- [AdEvent](#adevent)


## API Reference - AdiscopeSdk.Android
### AdiscopeSdk

```java
public class AdiscopeSdk {
    public static void initialize(Activity activity, AdiscopeInitializeListener listener)

    public static void initialize(Activity activity, AdiscopeInitializeListener listener, String callbackTag)

    public static void initialize(Activity activity, AdiscopeInitializeListener listener, String callbackTag, String childYN)

    @Deprecated
    public static void initialize(Activity activity, String mediaId, String mediaSecret, AdiscopeInitializeListener listener)

    @Deprecated
    public static void initialize(Activity activity, String mediaId, String mediaSecret, String callbackTag, AdiscopeInitializeListener listener)

    @Deprecated
    public static void initialize(Activity activity, String mediaId, String mediaSecret, String callbackTag, String childYN, AdiscopeInitializeListener listener)

    public static boolean isInitialize()

    public static void setUserId(String userId)

    public static void getUnitStatus(String unitId, IUnitStatus callback)

    public static String getSDKVersion()

    public static String getNetworksVersion()

    public static OfferwallAd getOfferwallAdInstance(Activity activity)

    public static RewardedVideoAd getRewardedVideoAdInstance(Activity activity)

    public static InterstitialAd getInterstitialAdInstance(Activity activity)

    public static RewardedInterstitialAd getRewardedInterstitialAdInstance(Activity activity)
      
    public static AdEvent getAdEventInstance(Activity activity)

    public static OptionSetter getOptionSetterInstance(Activity activity)

    public static void setRewardedCheckParam(String param)
}

public interface AdiscopeInitializeListener {
    void onInitialized(boolean isSuccess)
}
```

<br/>

#### initialize
```java
public static void initialize(Activity activity, AdiscopeInitializeListener listener)

public static void initialize(Activity activity, AdiscopeInitializeListener listener, String callbackTag)

public static void initialize(Activity activity, AdiscopeInitializeListener listener, String callbackTag, String childYN)

@Deprecated
public static void initialize(Activity activity, String mediaId, String mediaSecret, AdiscopeInitializeListener listener)

@Deprecated
public static void initialize(Activity activity, String mediaId, String mediaSecret, String callbackTag, AdiscopeInitializeListener listener)

@Deprecated
public static void initialize(Activity activity, String mediaId, String mediaSecret, String callbackTag, String childYN, AdiscopeInitializeListener listener)
```

|  Parameters   |                                                                                                                                                                                                                      |
|:-------------:|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|  `activity`   | Activity                                                                                                                                                                                                             |
|   `mediaId`   | 매체 아이디 (애디스콥에 문의)                                                                                                                                                                                                    |
| `mediaSecret` | 매체 시크릿키 (애디스콥에 문의)                                                                                                                                                                                                   |
| `callbackTag` | 보상 콜백을 복수 개로 등록해서 사용할 시에 어떤 보상 콜백을 사용할지 지정됨. 지정하지 않을 시 빈값(`""`)으로 지정하며, 이때 기본 보상콜백이 사용됨 (복수 개 사용 시 애디스콥에 문의)                                                                                                         |
|   `childYN`   | 어린이인지 아닌지의 여부를 설정해주는 값으로 Google GMA에 세팅됨.<br/>애디스콥에서는 Google Play 가족 정책을 준수해야 함([Adiscope Google Play 가족 정책 확인](./families-policy.md)) <br/><span style="color:red">정책 미준수 시 광고에 제한이 생김</span>(광고 물량 축소 및 오퍼월 진입 불가) |

<br/>

#### isInitialize
```java
public static boolean isInitialize()
```
* 애디스콥 이니셜라이즈 여부를 확인할 수 있다. 
  * 이니셜라이즈 된 상태일 경우 `true`, 이니셜라이즈가 되지 않은 상태일 경우 `false` 반환

<br/>

#### setUserId
```java
public static boolean setUserId(String userId)
```

| Parameters |              |
|------------|--------------|
| `userId`   | 고유한 유저의 ID 값 |

* 앱 사용자의 Unique Id를 설정한다(최대 길이 64자).
* 이 정보는 리워드 지급 등에 있어 사용자를 구분하는데 사용된다.
* 만일 서비스에서 한 사람당 N개의 계정 사용이 가능한 경우, 계정 변경 시 `setUserId` 호출로 애디스콥에 변경 정보를 전달해주어야 한다.
  * 그렇지 않을 경우 변경된 계정 정보로 보상 지급이 되지 않으니 유의해야 한다.

<br/>

#### setRewardedCheckParam
```java
public static void setRewardedCheckParam(String param)
```

| Parameters |                                        |
|------------|----------------------------------------|
| `param`    | rewarded callback 시 customData에 전달 될 값 |

* Application 사용자의 rewarded callback 시 parameters을 추가. 이 정보는 rewarded 지급 등에 있어 구분하는데 사용 할 수 있다.
* customData은 내부 설정 후 사용 가능. 담당자에게 요청 부탁드립니다.
> ⚠️ param은 Base64 Encoded(UTF8) 처리 후 1000자내로 설정 해 주시기 바랍니다.


<br/>

#### getUnitStatus
```java
public static void getUnitStatus(String unitId, IUnitStatus callback)

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

| Parameters |                |
|------------|----------------|
| `unitId`   | 유닛 아이디         |
| `callback` | 결과를 리턴받을 콜백 객체 |

* 유닛의 상태 정보를 구한다.
  * RV, 오퍼월 유닛의 상태를 확인할 수 있다.
* `IUnitStatus` 객체의 `onResult` 콜백을 통해 결과를 받을 수 있다.
* 애디스콥 이니셜라이즈가 먼저 진행되어야 한다.

<br/>

#### getSDKVersion
```java
public static String getSDKVersion()
```
* 애디스콥의 버전을 반환한다.

<br/>

#### getNetworksVersions
```java
public static String getNetworksVersions()
```
* 각 네트워크 버전을 리스트로 반환한다.

<br/>

#### getInterstitialAdInstance
```java
public static InterstitialAd getInterstitialAdInstance(Activity activity)
```
* `InterstitialAd`의 전역 Singleton 객체를 생성한다.
    * 애디스콥 이니셜라이즈에 대한 콜백 리스너인 `AdiscopeInitializeListener`의 콜백함수 `onInitialized` 의 `isSuccess` 값을 true로 받은 뒤 객체를 생성해주어야 한다.
        * `isSuccess` 값이 false일 경우에 인스턴스를 가져올 경우 null 반환

<br/>

#### getRewardedVideoAdInstance
```java
public static RewardedVideoAd getRewardedVideoAdInstance(Activity activity)
```
* `RewardedVideoAd`의 전역 Singleton 객체를 생성한다.
    * 애디스콥 이니셜라이즈에 대한 콜백 리스너인 `AdiscopeInitializeListener`의 콜백함수 `onInitialized` 의 `isSuccess` 값을 true로 받은 뒤 객체를 생성해주어야 한다.
        * `isSuccess` 값이 false일 경우에 인스턴스를 가져올 경우 null 반환

<br/>

#### getRewardedInterstitialAdInstance
```java
public static RewardedInterstitialAd getRewardedInterstitialAdInstance(Activity activity)
```
* `RewardedInterstitialAd`의 전역 Singleton 객체를 생성한다.
    * 애디스콥 이니셜라이즈에 대한 콜백 리스너인 `AdiscopeInitializeListener`의 콜백함수 `onInitialized` 의 `isSuccess` 값을 true로 받은 뒤 객체를 생성해주어야 한다.
        * `isSuccess` 값이 false일 경우에 인스턴스를 가져올 경우 null 반환

<br/>

#### getOfferwallAdInstance
```java
public static OfferwallAd getOfferwallAdInstance(Activity activity)
```
* `OfferwallAd`의 전역 Singleton 객체를 생성한다.
    * 애디스콥 이니셜라이즈에 대한 콜백 리스너인 `AdiscopeInitializeListener`의 콜백함수 `onInitialized` 의 `isSuccess` 값을 true로 받은 뒤 객체를 생성해주어야 한다.
        * `isSuccess` 값이 false일 경우에 인스턴스를 가져올 경우 null 반환

<br/>

#### getAdEventInstance
```java
public static AdEvent getAdEventInstance(Activity activity)
```
* `AdEvent`의 전역 Singleton 객체를 생성한다.
  * 애디스콥 이니셜라이즈에 대한 콜백 리스너인 `AdiscopeInitializeListener`의 콜백함수 `onInitialized` 의 `isSuccess` 값을 true로 받은 뒤 객체를 생성해주어야 한다.
    * `isSuccess` 값이 false일 경우에 인스턴스를 가져올 경우 null 반환

<br/>

#### getOptionSetterInstance
```java
public static OptionSetter getOptionSetterInstance(Activity activity)
```
* `OptionSetter`의 전역 Singleton 객체를 생성한다.

<br/>

## API Reference - OptionSetter.Android

### OptionSetter
```java
public interface OptionSetter {
    void setUseCloudFrontProxy(boolean useCloudFrontProxy);
    void setChildYN(String childYN);
    void setVolumeOff(boolean isVolume);
}
```

<br/>

#### setUseCloudFrontProxy
```java
void setUseCloudFrontProxy(boolean useCloudFrontProxy);
```

| Parameters           |                              |
|----------------------|------------------------------|
| `useCloudFrontProxy` | AWS Cloud Front Proxy의 사용 여부 |
* AWS Cloud Front Proxy를 사용할지 말지 설정한다.
  * 이 옵션을 사용하게되면, 북미, 유럽에서 게임을 서비스할시에 Adiscope API의 응답속도가 향상된다.

<br/>

#### setChildYN
```java
void setChildYN(String childYN);
```
| Parameters |                                                                                                         |
|------------|---------------------------------------------------------------------------------------------------------|
| `childYN`  | 사용자의 어린이 유무를 확인하기 위한 설정값<br/>- 어린이에 해당하거나 정보가 없는 경우: `"YES"` or `Null`<br/>- 어린이가 아닌 경우(어른인 경우): `"NO"` |

* 광고를 시청할 유저가 어린이인지 아닌지의 여부를 설정한다. 
  * 이 설정값은 그대로 Google GMA 에 세팅된다.
* 애디스콥에서는 Google Play 가족 정책을 준수해야 한다. ([Adiscope Google Play 가족 정책 확인](./families-policy.md))
  * <span style="color:red">정책 미준수 시 광고에 제한이 생김</span> (광고 물량 축소 및 오퍼월 진입 불가)

<br/>

#### setVolumeOff
```java
void setVolumeOff(boolean isVolume)
```
| Parameters |                                                     |
|------------|-----------------------------------------------------|
| `isVolume` | 광고음의 on/off 설정값. 미송출 시 `true`, 송출(`false`)이 default |
* 광고음의 on/off 설정을 지원하며, 광고음 송출이 디폴트이다.
  * 지원 네트워크: Admob, Applovin, MAX(일부 비더 네트워크)
    * MAX: 맥스에서 제공하는 일부 네트워크의 광고음 뮤트 적용
      * Google bidding and Google Admob, AppLovin, Mintegral(Mobvista), Verve
* 앱을 음소거하면 동영상 광고 적합성이 저하되고 앱의 광고 수익이 감소할 수 있으므로, 특수한 상황에만 사용토록 권장한다.

<br/>

## API Reference - AdiscopeError.Android

### AdiscopeError
```java
package com.nps.adiscope;
 
public class AdiscopeError {
    private final int code;
    private final String description;
    private String xb3TraceId;
}
```

[애디스콥 에러 정보 문서 확인](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/error_info.md)

<br/>

## API Reference - InterstitialAd.Android

### InterstitialAd
```java
public interface InterstitialAd {
    void load(String unitId)

    boolean isLoaded(String unitId)

    boolean show()

    void setInterstitialAdListener(InterstitialAdListener interstitialAdListener)
}
   
public interface InterstitialAdListener {
    void onInterstitialAdLoaded()

    void onInterstitialAdFailedToLoad(AdiscopeError error)

    void onInterstitialAdOpened(String unitId)

    void onInterstitialAdClosed(String unitId)

    void onInterstitialAdFailedToShow(String unitId, AdiscopeError error)
}    
```

<br/>

#### load
```java
void load(String unitId)
```
| Parameters |                       |
|------------|-----------------------|
| `unitId`   | 로드할 인터스티셜 광고의 unit id |

**Callback**

| Method                       | Info                   | Parameter     |
|------------------------------|------------------------|---------------|
| onInterstitialAdLoaded       | 인터스티셜 광고를 성공적으로 로드했을 때 | void          |
| onInterstitialAdFailedToLoad | 인터스티셜 광고의 로드가 실패했을 때   | AdiscopeError |

* 특정 인터스티셜 유닛에 속한 광고 네트워크들의 인터스티셜 광고를 로드한다.
* load와 show는 pair로 호출되어야 한다.
  * 즉 load를 한 후 show를 하고, 광고를 show한 후에는 다시 load를 하여 다음번 show를 준비해야 한다.
* load가 실행되면 `onInterstitialAdLoaded` 와 `onInterstitialAdFailedToLoad` 중 하나의 callback은 항상 호출된다.

<br/>

#### isLoaded
```java
boolean isLoaded(String unitId)
```
| Parameters |                              |
|------------|------------------------------|
| `unitId`   | 로드 여부를 체크할 인터스티셜 광고의 unit id |

* 특정 인터스티셜 유닛의 광고가 로드되었는지 확인한다.
  * 로드된 광고가 있을 시 `true`, 없을 시 `false`를 반환한다.
  
<br/>

#### show
```java
boolean show()
```
**Callback**

| Method                         | Info                 | Parameter                          |
|--------------------------------|----------------------|------------------------------------|
| `onInterstitialAdOpened`       | 인터스티셜 광고가 열릴 때       | String unitId                      |
| `onInterstitialAdClosed`       | 인터스티셜 광고가 닫혔을 때      | String unitId                      |
| `onInterstitialAdFailedToShow` | 인터스티셜 광고를 보여줄 수 없을 때 | String unitId, AdiscopeError error |

* 최근에 로드된 인터스티셜 광고 유닛에 속한 광고를 사용자에게 보여준다.
    * show가 정상적으로 시작되면 true, 만약 이미 다른 show가 진행중이라면 `false` 반환
* show가 실행되면 (return값이 `true`일 경우) `onInterstitialAdOpened`, `onInterstitialAdFailedToShow` 중 하나가 항상 호출된다.
    * `onInterstitialAdOpened`가 호출되었다면 이후 `onInterstitialAdClosed`가 항상 호출된다.

<br/>

## API Reference - RewardedVideoAd.Android

### RewardedVideoAd
```java
public interface RewardedVideoAd {
    void load(String unitId)
        
    boolean isLoaded(String unitId)

    boolean show()

    void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener)
}
   
public interface RewardedVideoAdListener {
    void onRewardedVideoAdLoaded(String unitId)

    void onRewardedVideoAdFailedToLoad(String unitId, AdiscopeError error)

    void onRewardedVideoAdOpened(String unitId)

    void onRewardedVideoAdClosed(String unitId)

    void onRewarded(String unitId, RewardItem rewardItem)

    void onRewardedVideoAdFailedToShow(String unitId, AdiscopeError error)
}    
```

<br/>

#### load
```java
void load(String unitId)
```
| Parameters |                     |
|------------|---------------------|
| `unitId`   | 로드할 보상형 광고의 unit id |


**Callback**

| Method                          | Info              | Parameter                          |
|---------------------------------|-------------------|------------------------------------|
| `onRewardedVideoAdLoaded`       | 보상형 광고 로드를 성공했을 때 | String unitId                      |
| `onRewardedVideoAdFailedToLoad` | 보상형 광고 로드를 실패했을 때 | String unitId, AdiscopeError error |

* 특정 보상형 광고 유닛에 속한 광고 네트워크들의 보상형 광고를 로드한다.
* load와 show는 pair로 호출되어야 한다.
  * 즉 load를 한 후 show를 하고, 광고를 show한 후에는 다시 load를 하여 다음번 show를 준비해야 한다.
* load-show 후 다시 load를 하려할 때 load는 show 이후 언제든 호출 가능하다.
* 광고가 show되는 동안 다음 광고를 load를 할 수도 있지만 이는 사용하는 mediation ad network company의 종류에 따라 달라질 수 잇으므로 항상 보장되는 동작은 아니다.
  * 그러므로 show의 callback 인 `onRewardedVideoAdClosed`에서 다시 load를 하는 것을 권장한다.
  * 이는 어뷰징 방지를 위해 보상형 광고를 연속으로 보여주는 것을 제한하여, 한번 광고를 보고 나면 일정 시간이 지난 후에 다시 show를 할 수 있도록 어드민 페이지에서 서비스 설정을 할 수 있기 때문이다.
  </br>(일정 시간 이내에 show를 할 경우 `onRewardedVideoAdFailedToShow` callback이 호출된다)
* load가 실행되면 `onRewardedVideoAdLoaded`, `onRewardedVideoAdFailedToLoad` 중 하나의 callback은 항상 호출된다.
* **(Optional)** load의 시간이 필요해 로드 중에는 프로그래스바 노출 추천

<br/>

#### isLoaded
```java
boolean isLoaded(String unitId)
```
| Parameters |                            |
|------------|----------------------------|
| `unitId`   | 로드 여부를 체크할 보상형 광고의 unit id |

* 특정 보상형 광고 유닛이 로드되었는지 확인한다.
    * 로드된 광고가 있을 시 `true`, 없을 시 `false`를 반환한다.

<br/>

#### show
```java
boolean show()
```

**Callback**

| Method                          | Info                 | Parameter                            |
|---------------------------------|----------------------|--------------------------------------|
| `onRewardedVideoAdOpened`       | 보상형 광고가 열릴 때         | String unitId                        |
| `onRewardedVideoAdClosed`       | 보상형 광고가 닫혔을 때        | String unitId                        |
| `onRewarded`                    | 보상형 광고 시청 후 보상이 있을 시 | String unitId, RewardItem rewardItem |
| `onRewardedVideoAdFailedToShow` | 보상형 광고를 보여줄 수 없을 때   | String unitId, AdiscopeError error   |


* 최근에 로드된 보상형 광고 유닛에 속한 광고를 사용자에게 보여준다.
    * show가 정상적으로 시작되면 true, 만약 이미 다른 show가 진행중이라면 `false` 반환
* show가 실행되면 (return값이 `true`일 경우) `onRewardedVideoAdOpened`, `onRewardedVideoAdFailedToShow` 중 하나가 항상 호출된다.
    * `onRewardedVideoAdOpened가`가 호출되었다면 이후 `onRewardedVideoAdClosed`가 항상 호출된다.
* `OnRewarded`는 보통 `onRewardedVideoAdOpened` 와 `onRewardedVideoAdClosed` 사이에 호출되는 경우가 많으나 광고 미디에이션 네트워크마다 동작이 다를 수 있다.
* Reward 정보는 어뷰징 방지를 위해서 Server-to-Server(S2S) 방식으로 전달 받는 것을 권장한다.
    * S2S 방식을 선택하더라도 보상이 전달 될 시에는 `OnRewarded`가 호출된다.
    * 이때는 서버를 통해 전달받은 정보를 기준으로 처리하고, `OnRewarded`를 통해 전달받은 정보는 검증용으로 사용하거나 무시하도록 한다.

<br/>

## API Reference - RewardedInterstitialAd.Android

### RewardedInterstitialAd
```java
public interface RewardedInterstitialAd {
    void preloadUnit(String[] unitIdList)

    void preloadAll()

    void show(String unitId)

    void getUnitStatus(String unitId, IUnitStatus callback)

    void setRewardedInterstitialAdListener(RewardedInterstitialAdShowListener listener)
}

public interface RewardedInterstitialAdShowListener {
    void onRewardedInterstitialAdSkipped(String unitId)

    void onRewardedInterstitialAdOpened(String unitId)

    void onRewardedInterstitialAdClosed(String unitId)

    void onRewardedInterstitialAdRewarded(String unitId, RewardItem rewardItem)

    void onRewardedInterstitialAdFailedToShow(String unitId, AdiscopeError error)
}
```

#### preloadUnit
```java
void preloadUnit(String[] unitIdList)
```
| Parameters   |                          |
|--------------|--------------------------|
| `unitIdList` | 로드할 전면형 보상광고의 unit id 목록 |

* 특정 유닛들에 속한 광고 네트워크들의 전면형 보상 광고를 순차적으로 로드한다.
  * 애디스콥 이니셜라이즈 성공 콜백을 받은 이후 1회 호출 권장

<br/>

#### preloadAll
```java
void preloadAll()
```
* 어드민 페이지에 등록되어 있는 활성화된 전면형 보상 광고 유닛들을 순차적으로 로드한다.
  * 애디스콥 이니셜라이즈 성공 콜백을 받은 이후 1회 호출 권장

<br/>

#### show
```java
void show(String unitId)
```
| Parameters |                              |
|------------|------------------------------|
| `unitId`   | show 하고자 할 전면형 보상광고의 unit id |

**Callback**

| Method                                 | Info                           | Parameter                            |
|----------------------------------------|--------------------------------|--------------------------------------|
| `onRewardedInterstitialAdSkipped`      | 사용자가 스킵 버튼을 클릭하여 안내 팝업창을 닫았을 때 | String unitId                        |
| `onRewardedInterstitialAdOpened`       | 전면형 보상광고가 열릴 때                 | String unitId                        |
| `onRewardedInterstitialAdClosed`       | 전면형 보상광고가 닫혔을 때                | String unitId                        |
| `onRewardedInterstitialAdRewarded`     | 전면형 보상광고 시청 후 보상이 있을 시         | String unitId, RewardItem rewardItem |
| `onRewardedInterstitialAdFailedToShow` | 전면형 보상광고를 보여줄 수 없을 때           | String unitId, AdiscopeError error   |

* 로드된 전면형 보상 광고의 유닛을 지정하여 사용자에게 보여준다.
* show는 중복하여 호출할 수 없다.
* 해당 유닛이 로드되어 있으면 안내 팝업을 보여준 뒤 해당 광고를 사용자에게 보여준다.
    * 유저가 안내 팝업의 스킵 버튼을 클릭하면 안내 팝업창이 닫히면서 광고는 스킵된다. 이때 `onRewardedInterstitialAdSkipped`가 호출된다.
* show가 실행되면 `onRewardedInterstitialAdSkipped`, `onRewardedInterstitialAdOpened`, `onRewardedInterstitialAdFailedToShow` 중 하나가 항상 호출된다.
* `onRewardedInterstitialAdOpened`가 호출되었다면 이후 `onRewardedInterstitialAdClosed`가 항상 호출된다.
* `onRewardedInterstitialAdRewarded`는 보통 `onRewardedInterstitialAdOpened`와 `onRewardedInterstitialAdClosed` 사이에 호출되는 경우가 많으나 광고 시스템의 상황에 따라 달라질 수 있다.
* `onRewardedInterstitialAdClosed`와 `onRewardedInterstitialAdFailedToShow`가 호출되면 내부에서 해당 유닛을 자동으로 로드한다.

<br/>

#### getUnitStatus (RI)
```java
void getUnitStatus(String unitId, IUnitStatus callback)

public interface IUnitStatus {
    void onResult(AdiscopeError error, UnitStatus unitStatus)
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

| Parameters |                   |
|------------|-------------------|
| `unitId`   | 전면형 보상광고의 unit id |
| `callback` | 결과를 리턴받을 콜백 객체    |


* 보상형 전면광고 유닛의 상태를 확인한다.
* `IUnitStatus` 객체의 `onResult` 콜백을 통해 결과를 받을 수 있다.

<br/>

## API Reference - OfferwallAd.Android

### OfferwallAd
```java
public interface OfferwallAd {

    boolean show(Activity activity, String unitId, String[] excludeAdTypeList)

    boolean showDetail(Activity activity, String unitId, String[] excludeAdTypeList, int sponsorshipItemId)

    boolean showDetail(Activity activity, String url)

    void setOfferwallAdListener(OfferwallAdListener offerwallAdListener)
}
        
    public interface OfferwallAdListener {

    void onOfferwallAdOpened(String unitId)

    void onOfferwallAdFailedToShow(String unitId, AdiscopeError error)

    void onOfferwallAdClosed(String unitId)
}    
```

<br/>

#### show
```java
boolean show(Activity activity, String unitId, String[] excludeAdTypeList)
```
| Parameters          |                                  |
|---------------------|----------------------------------|
| `activity`          | 상위 액티비티                          |
| `unitId`            | 오퍼월 광고 unit id                   |
| `excludeAdTypeList` | 구매 제한 타입 리스트<br/>ex) `[ "CPS" ]` |

**Callback**

| Method                      | Info               | Parameter                          |
|-----------------------------|--------------------|------------------------------------|
| `onOfferwallAdOpened`       | 오퍼월 광고가 열릴 때       | String unitId                      |
| `onOfferwallAdClosed`       | 오퍼월 광고가 닫혔을 때      | String unitId                      |
| `onOfferwallAdFailedToShow` | 오퍼월 광고를 보여줄 수 없을 때 | String unitId, AdiscopeError error |
* 오퍼월 광고를 사용자에게 표시한다.
* show가 정상적으로 시작되면 `true`, 만약 이미 다른 show가 처리되는 중이라면 `false`를 반환한다.
* show가 실행되면 (return값이 `true`일 경우) `onOfferwallAdOpened`, `onOfferwallAdFailedToShow` 중 하나가 항상 호출된다.
    * `onOfferwallAdOpened`가 호출되었다면 이후 `onOfferwallAdClosed`가 항상 호출된다.

<br/>

#### showDetail
```java
boolean showDetail(Activity activity, String unitId, String[] excludeAdTypeList, int sponsorshipItemId)

boolean showDetail(Activity activity, String url)
```

| Parameters          |                                                                 |
|---------------------|-----------------------------------------------------------------|
| `activity`          | 상위 액티비티                                                         |
| `unitId`            | 로드 여부를 체크할 인터스티셜 광고의 unit id                                    |
| `excludeAdTypeList` | 구매 제한 타입 리스트<br/>ex) `[ "CPS" ]`                                |
| `sponsorshipItemId` | 이동하고자 할 스폰서십의 item id. Admin page에 등록된 id와 동일해야 한다.             |
| `url`               | mediaId, unitId, excludeAdTypes, sponsorshipItemId가 포함된 형식의 url |

* 특정 광고 아이템의 상세 페이지로 이동한다.
* showDetail이 정상적으로 시작되면 `true`, 그렇지 않다면 `false`를 반환한다.
* showDetail이 실행되면 (return값이 `true`일 경우) `onOfferwallAdOpened`, `onOfferwallAdFailedToShow` 중 하나가 항상 호출된다.
    * `onOfferwallAdOpened`가 호출되었다면 이후 `onOfferwallAdClosed`가 항상 호출된다.

<br/>

## API Reference - AdEvent.Android

### AdEvent
```java
public interface AdEvent {

    boolean show(Activity activity, String unitId)

    void setAdEventListener(AdEventListener adEventListener)
}
        
    public interface AdEventListener {

    void onAdEventOpened(String unitId)

    void onAdEventFailedToShow(String unitId, AdiscopeError error)

    void onAdEventClosed(String unitId)
}    
```

<br/>

#### show
```java
boolean show(Activity activity, String unitId)
```
| Parameters          |                                  |
|---------------------|----------------------------------|
| `activity`          | 상위 액티비티                          |
| `unitId`            | Ad Event의 unit id                |

**Callback**

| Method                  | Info                    | Parameter                          |
|-------------------------|-------------------------|------------------------------------|
| `onAdEventOpened`       | Ad Event 화면이 열릴 때       | String unitId                      |
| `onAdEventClosed`       | Ad Event 화면이 닫혔을 때      | String unitId                      |
| `onAdEventFailedToShow` | Ad Event 화면을 보여줄 수 없을 때 | String unitId, AdiscopeError error |
* Ad Event 광고를 사용자에게 표시한다.
* show가 정상적으로 시작되면 `true`, 만약 이미 다른 show가 처리되는 중이라면 `false`를 반환한다.
* show가 실행되면 (return값이 `true`일 경우) `onAdEventOpened`, `onAdEventFailedToShow` 중 하나가 항상 호출된다.
  * `onAdEventOpened`가 호출되었다면 이후 `onAdEventClosed`가 항상 호출된다.

<br/>
