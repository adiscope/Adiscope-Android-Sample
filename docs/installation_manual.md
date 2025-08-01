Installation_manual
===================
- [1. gradle 연동 설정](#1.-gradle-연동-설정)
- [2. Network 별 추가작업](#2.-network-별-추가-작업)

## Adiscope Android Sdk Install

### 1. gradle 연동 설정

프로젝트 단위의 `build.gradle`에 아래의 repository 주소를 추가

**build.gradle(root)**
```groovy
allprojects {
    repositories {
        // [required] adiscope library
        maven {
            url 'https://repository.adiscope.com/repository/adiscope/'
        }

        maven { url "https://s3.amazonaws.com/smaato-sdk-releases/" } // max 연동 시 추가
        maven { url "https://artifactory.bidmachine.io/bidmachine" } // max 연동 시 추가
        maven { url "https://maven.ogury.co" } // max 연동 시 추가
        maven { url "https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea" } // max 연동 시 추가
        maven { url "https://android-sdk.is.com" } // max 연동 시 추가
        maven { url "https://artifact.bytedance.com/repository/pangle" } // max 혹은 pangle 연동 시 추가
        maven { url 'https://cboost.jfrog.io/artifactory/chartboost-ads/' } // max 혹은 chartboost 연동 시 추가
    }
}
```
<br/>

**build.gradle(app)**  
앱 모듈의 build.gradle의 `manifestPlaceholders`에 애디스콥 설정값을 정의(<span style="color:red">미정의 시 컴파일 에러가 발생함</span>).  
애디스콥 측에 아래 값에 대해 문의 후 기입

* `adiscope_media_id`: 매체 아이디
* `adiscope_media_secret`: 매체 시크릿키
* `adiscope_sub_domain`: 옵션값 ([오퍼월 상세페이지 이동 기능](./api_documentation.md#showdetail)에 사용하는 값으로, 필요 시 담당자 전달 예정)


```groovy
android {
    defaultConfig {
        // [required] adiscope config
        manifestPlaceholders = [
            adiscope_media_id    : "media id 기입필요",
            adiscope_media_secret: "media secret 기입필요",
            adiscope_sub_domain  : "" // 옵션값으로 사용 시 value에 전달값을 기입
        ]
    }
}

dependencies {

    // [required] adiscope library
    implementation 'com.nps.adiscope:adiscopeCore:4.5.0'
    implementation 'com.nps.adiscope:adiscopeAndroid:1.2.2'
    
    // bidding, waterfall adapter
    implementation 'com.nps.adiscope:adapter.admob:24.4.0.0'            // admob

    // bidding adapter
    implementation 'com.nps.adiscope:adapter.max:13.3.1.1'              // max

    // waterfall adapter
    implementation 'com.nps.adiscope:adapter.chartboost:9.8.3.0'        // chartboost
    implementation "com.nps.adiscope:adapter.pangle:7.2.0.4.0"          // pangle
    implementation 'com.nps.adiscope:adapter.vungle:7.5.0.0'            // vungle
}
```

<br/>


**AndroidManifest.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
          xmlns:tools="http://schemas.android.com/tools">
    <application>
        <!-- [required] Define mediaId, secretKey metadata and 
         use AdiscopeSdk.initialize(activity, listener) function,
         sdk reads this information and initializes it  -->
        <meta-data android:name="adiscope_media_id" android:value="${adiscope_media_id}"/>
        <meta-data android:name="adiscope_media_secret" android:value="${adiscope_media_secret}"/>
    </application>
</manifest>
```

- adiscopeCore, adiscopeAndroid 라이브러리는 필수로 포함시켜야 합니다.
- 운영에 필요한 각각의 네트워크 어댑터를 연동하시면 됩니다.
- 모든 어댑터를 implementation 했더라도, 애디스콥 어드민에서 off 설정된 네트워크 어댑터들은 런타임에 구동되지 않습니다.

<br/>

### 2. Network 별 추가 작업

#### Admob - Rewarded Video / Interstitial / Rewarded Interstitial Video Network
* 애드몹 어댑터 연동 시 매니페스트에 애드몹 appId를 추가해야 합니다.
* Max 어댑터 11.9.1 버전부터 Max 비더에 admob이 포함되므로, 애드몹 어댑터를 미연동하여도 Max 어댑터 연동 시 아래 작업이 포함되어야 합니다.
* 애디스콥으로부터 값을 전달받은 후 기입 (미기입 시 앱 크래시 발생)
* 애드몹 SDK(`com.google.android.gms:play-services-ads`)를 프로젝트에 이미 포함하고 있는 경우 버전 호환에 유의
  * 퍼블리셔-애디스콥 간 gms 메이저 버전이 다를 경우 크래시 발생될 수 있음
  * gms 22 버전: 애디스콥 `4.1.0` 미만 [가이드](https://github.com/adiscope/Adiscope-Android-Sample/tree/4.0.1?tab=readme-ov-file#integration-guide)를 따라 연동
  * gms 23 버전: 애디스콥 `4.4.0` 미만 [가이드](https://github.com/adiscope/Adiscope-Android-Sample/tree/4.3.2?tab=readme-ov-file#integration-guide)를 따라 연동
  * gms 24 버전: 애디스콥 `4.4.0` 이상 [가이드](https://github.com/adiscope/Adiscope-Android-Sample?tab=readme-ov-file#integration-guide)를 따라 연동
  * 관련 문서: https://developers.google.com/admob/android/migration?hl=en
```xml
  <application>
    <!-- admob app id for adiscope Admob rewarded video networks -->
    <meta-data
        android:name="com.google.android.gms.ads.APPLICATION_ID"
        android:value="admob_app_id"/>
  </application>
```

<br/>

#### Chartboost - Rewarded Video Network
* 9.2.1 버전부터 kotlinx의 coroutines 라이브러리를 사용합니다. 아래 참조가 포함되어 있습니다.  
  `implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1'`

<br/>

#### Vungle - Rewarded / Interstitial Video Network
* 어댑터 내에 아래 참조가 포함되어 있습니다.

  `implementation 'androidx.core:core:1.3.1'`  
  `implementation 'com.google.code.gson:gson:2.8.6'`  
  `implementation 'androidx.localbroadcastmanager:localbroadcastmanager:1.0.0'`  
  `implementation 'com.squareup.okhttp3:okhttp:3.12.12'`  
  `implementation 'com.squareup.okio:okio:1.15.0'`

<br/>

#### Max - Rewarded Video / Interstitial Network
* 11.9.0.0 버전부터 앱러빈의 미디에이션 플랫폼인 MAX를 통해 비딩, 워터폴을 교차 운영할 수 있도록 지원합니다.
* 11.9.3 버전부터 max adapter를 연동하면 하기 네트워크들이 max bidder로 자동 포함됩니다.
  - applovin, admob, fan, mobvista, pangle, smaato, vungle
* 애드몹 SDK(`com.google.android.gms:play-services-ads`)를 프로젝트에 이미 포함하고 있는 경우 버전 호환에 유의
  * admob, unityads bidder 내 gms 함수가 사용됨
  * 퍼블리셔-애디스콥 간 gms 메이저 버전이 다를 경우 크래시 발생될 수 있음
  * gms 22 버전: 애디스콥 `4.1.0` 미만 [가이드](https://github.com/adiscope/Adiscope-Android-Sample/tree/4.0.1?tab=readme-ov-file#integration-guide)를 따라 연동
  * gms 23 버전: 애디스콥 `4.4.0` 미만 [가이드](https://github.com/adiscope/Adiscope-Android-Sample/tree/4.3.2?tab=readme-ov-file#integration-guide)를 따라 연동
  * gms 24 버전: 애디스콥 `4.4.0` 이상 [가이드](https://github.com/adiscope/Adiscope-Android-Sample?tab=readme-ov-file#integration-guide)를 따라 연동
  * 관련 문서: https://developers.google.com/admob/android/migration?hl=en