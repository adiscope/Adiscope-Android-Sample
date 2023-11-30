Installation_manual
===================
- [1. gradle 연동 설정](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/installation_manual.md#1-gradle-연동-설정)
- [2. Network 별 추가작업](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/installation_manual.md#2-network-별-추가작업)


## Adiscope Android Sdk Install

### 1. gradle 연동 설정

`프로젝트 단위의 gradle file 에 아래의 repository 주소를 추가 해준다.`

project build.gradle
```groovy
allprojects {
    repositories {
        // [required] adiscope library
        maven {
            url 'https://repository.adiscope.com/repository/adiscope/'
        }

        /****************************
         (Adiscope SDK 3.3.0~) 
         3.3.0 이상 연동 시 각 네트워크별로 maven url 등록이 필요합니다.
         아래 네트워크 어댑터를 연동하는 매체는 각각의 maven url을 등록해주세요.
         max, pangle, mobvista, chartboost, ironsource 
         *****************************/
         
        // max adapter 연동 시 필수로 포함해야 합니다. (max의 비더로 포함되는 네트워크: smaato, pangle, mobvista)
        // max 미운영 매체는 pangle, mobvista 워터폴 연동 시 각각의 maven url을 추가하셔야 합니다.
        maven { url "https://s3.amazonaws.com/smaato-sdk-releases/" } // max bidder로 max 연동 시 추가
        maven { url "https://artifact.bytedance.com/repository/pangle" } // max 혹은 pangle 연동 시 추가
        maven { url "https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea" } // max 혹은 mobvista 연동 시 추가
       
        // chartboost 연동 시 추가
        maven { url 'https://cboost.jfrog.io/artifactory/chartboost-ads/' }
       
       // ironsource 연동 시 추가
        maven {url 'https://android-sdk.is.com/'}
    }
}
```

`모듈(앱) 단위의 gradle file 에 아래의 라이브러리를  추가 해준다.`

module build.gradle
```groovy
dependencies {

    // [required] adiscope library
    implementation 'com.nps.adiscope:adiscopeCore:3.3.0'
    implementation 'com.nps.adiscope:adiscopeAndroid:1.2.0'

    // adiscope sdk have to extract Google Advertising Id.
    // if com.google.android.gms.ads.identifier.AdvertisingIdClient class is not included in your app, uncomment following code
    // implementation 'com.google.android.gms:play-services-basement:8.3.0'

    implementation 'com.nps.adiscope:adapter.chartboost:9.2.1.1'        // chartboost

    implementation 'com.nps.adiscope:adapter.ironsource:7.5.1.0'   // ironsource

    implementation 'com.nps.adiscope:adapter.unityads:4.2.1.2'      // unityads

    /****************************
     max adapter를 연동하면 하기 네트워크들이 max bidder로 포함됩니다.
     admob, fan, mobvista, pangle, smaato, vungle
     비더 네트워크를 워터폴로도 함께 운영하려면 아래 워터폴 어댑터 라이브러리들을 선택적으로 포함해야 합니다.
     (아래 네트워크들이 max bidder에 포함됨)
     *****************************/
    implementation 'com.nps.adiscope:adapter.max:11.9.2.1'        // max
    implementation 'com.nps.adiscope:adapter.applovin:11.9.0.0'        // applovin (watarfall adapter)
    implementation 'com.nps.adiscope:adapter.admob:22.3.0.0'        // admob (use play-services-ads:22.3.0 dependency)
    implementation 'com.nps.adiscope:adapter.fan:6.13.7.1'           // fan
    implementation 'com.nps.adiscope:adapter.mobvista:16.4.32.1'     // mobvista (use androidx)
    implementation "com.nps.adiscope:adapter.pangle:5.1.0.8.1"        // pangle
    implementation 'com.nps.adiscope:adapter.vungle:6.12.1.2'        // vungle (use androidx)
}
```

- adiscopeCore, adiscopeAndroid 라이브러리는 필수로 포함시켜야합니다.
- play-services-basement은 옵션으로서 adiscope sdk 내에서 adid 추출에 사용됩니다. 앱에서 이미 google play-services-ads 를 사용중이라면 이것을 포함시킬 필요가 없습니다. 또는 adapter.admob 를 사용하는 경우에도 adapter.admob의 dependency에 google play-services-ads가 포함되있기때문에, play-services-basement를 포함시킬 필요가 없습니다.
- video network adapter들 중에서 앱에서 사용하고자하는 adapter만 implementation으로 추가하시면 됩니다. 모든 video network adapter를 implementation했더라도, adiscope admin 에서 off 설정된 network adapter들은 런타임에 구동되지 않습니다.

### 2. Network 별 추가작업

#### Admob - Rewarded Video / Interstitial Network
* AndroidManifest.xml 의 application 태그 하위에 아래의 meta-data가 선언되어야합니다.
>  <br>AndroidManifest.xml 설정
> ```xml
>  <application ..>
>  // ... (생략)
>       <meta-data android:name="com.google.android.gms.version" android:value="@integer/google_play_services_version"/>
>  </application>
>  ```

#### Chartboost - Rewarded Video Network
* 9.2.1 버전부터 kotlinx의 coroutines 라이브러리를 사용합니다. 아래 참조가 포함되어 있습니다.
  `implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1'`

#### Fan - Rewarded Video Network
* 디바이스에서 광고를 테스트하기위해서는 Facebook admin에 디바이스의 ADID가 등록되어야합니다.

#### Mobvista - Rewarded Video Network
* 13.1.1.0 버전부터 androidx 라이브러리를 사용합니다. 앱 환경에 따라서 androidx migration이 필요할 수 있습니다. <a href="#heading-ids">https://developer.android.com/jetpack/androidx/migrate </a>

#### Vungle - Rewarded Video Network
* 6.5.3.0 버전부터 androidx 라이브러리를 사용합니다. 앱 환경에 따라서 androidx migration이 필요할 수 있습니다. (https://developer.android.com/jetpack/androidx/migrate)
* 어댑터 내에 아래 참조가 포함되어 있습니다.

  `implementation 'androidx.core:core:1.3.1'`  
  `implementation 'com.google.code.gson:gson:2.8.6'`  
  `implementation 'androidx.localbroadcastmanager:localbroadcastmanager:1.0.0'`  
  `implementation 'com.squareup.okhttp3:okhttp:3.12.12'`  
  `implementation 'com.squareup.okio:okio:1.15.0'`

#### Ironsource - Rewarded Video Network
* 어댑터 내에 아래 참조가 포함되어 있습니다.  
  `implementation 'org.jetbrains.kotlin:kotlin-stdlib:1.4.10'`

#### Max - Rewarded Video / Interstitial Network
* 11.9.0.0 버전부터 앱러빈의 미디에이션 플랫폼인 MAX를 통해 비딩, 워터폴을 교차 운영할 수 있도록 지원합니다.
* 11.9.3 버전부터 max adapter를 연동하면 하기 네트워크들이 max bidder로 자동 포함됩니다.
  - applovin, admob, fan, mobvista, pangle, smaato, vungle