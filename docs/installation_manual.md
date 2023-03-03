Installation_manual
===================
- [1. gradle 연동 설정](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/installation_manual.md#1-gradle-연동-설정)
- [2. Network 별 추가작업](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/installation_manual.md#2-network-별-추가작업)


## Adiscope Android Sdk Install

### 1. gradle 연동 설정

`프로젝트 단위의 gradle file 에 아래의 repository 주소를 추가 해준다.`

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

`모듈(앱) 단위의 gradle file 에 아래의 라이브러리를  추가 해준다.`

module build.gradle
```
dependencies {
 
    // [required] adiscope library
    implementation 'com.nps.adiscope:adiscopeCore:2.1.7.1'
    implementation 'com.nps.adiscope:adiscopeAndroid:1.1.6'

    // adiscope sdk have to extract Google Advertising Id.
    // if com.google.android.gms.ads.identifier.AdvertisingIdClient class is not included in your app, uncomment following code
    // implementation 'com.google.android.gms:play-services-basement:8.3.0'

    // [optional] adiscope rewarded video networks
    implementation 'com.nps.adiscope:adapter.admob:20.6.0.4'        // admob (use play-services-ads:20.6.0 dependency)

    implementation 'com.nps.adiscope:adapter.chartboost:8.4.2.2'        // chartboost

    implementation 'com.nps.adiscope:adapter.ironsource:7.2.1.3'   // ironsource
    implementation "com.nps.adiscope:adapter.pangle:4.7.0.5.5"        // pangle

    implementation 'com.nps.adiscope:adapter.tapjoy:12.11.1.0'        // tapjoy
    implementation 'com.nps.adiscope:adapter.unityads:4.2.1.1'      // unityads
    implementation 'com.nps.adiscope:adapter.vungle:6.12.1.0'        // vungle (use androidx)

    implementation 'com.nps.adiscope:adapter.max:11.4.4.5'        // max
    implementation 'com.applovin:applovin-sdk:11.4.4'        // applovin 앱러빈은 직접 참조 해야함
    
    /****************************
     만약 위 max lib 을 참조 하신 경우라면 아래의 applovin, fan, mobvista 참조를 하시면 안됩니다.
     *****************************/

    // implementation 'com.nps.adiscope:adapter.applovin:11.4.4.5'        // applovin
    // implementation 'com.nps.adiscope:adapter.mobvista:15.8.0.3'     // mobvista (use androidx)
    // implementation 'com.nps.adiscope:adapter.fan:6.11.0.1'           // fan

    // [optional] adiscope interstitial networks
    implementation 'com.nps.adiscope:adapter.admob:20.6.0.3'        // admob (use play-services-ads:20.6.0 dependency)
}
```

- adiscopeCore, adiscopeAndroid 라이브러리는 필수로 포함시켜야합니다.
- play-services-basement은 옵션으로서 adiscope sdk 내에서 adid 추출에 사용됩니다. 앱에서 이미 google play-services-ads 를 사용중이라면 이것을 포함시킬 필요가 없습니다. 또는 adapter.admob 를 사용하는 경우에도 adapter.admob의 dependency에 google play-services-ads가 포함되있기때문에, play-services-basement를 포함시킬 필요가 없습니다.
- video network adapter들 중에서 앱에서 사용하고자하는 adapter만 implementation으로 추가하시면 됩니다. 모든 video network adapter를 implementation했더라도, adiscope admin 에서 off 설정된 network adapter들은 런타임에 구동되지 않습니다.

### 2. Network 별 추가작업

#### Admob - Rewarded Video / Interstitial Network
* AndroidManifest.xml 의 application 태그 하위에 아래의 meta-data가 선언되어야합니다.
>  <br>AndroidManifest.xml 설정
> ```
>  <application ..>
>  // ... (생략)
>       <meta-data android:name="com.google.android.gms.version" android:value="@integer/google_play_services_version"/>
>  </application>
>  ```

#### Fan - Rewarded Video Network
* 디바이스에서 광고를 테스트하기위해서는 Facebook admin에 디바이스의 ADID가 등록되어야합니다.

#### Mobvista - Rewarded Video Network
* 13.1.1.0 버전부터 androidx 라이브러리를 사용합니다. 앱 환경에 따라서 androidx migration이 필요할 수 있습니다. <a href="#heading-ids">https://developer.android.com/jetpack/androidx/migrate</a>

#### Vungle - Rewarded Video Network
* 6.5.3.0 버전부터 androidx 라이브러리를 사용합니다. 앱 환경에 따라서 androidx migration이 필요할 수 있습니다. (https://developer.android.com/jetpack/androidx/migrate)
* 아래 참조가 없다면 참조를 해주어야합니다.  
  implementation 'androidx.core:core:1.3.1'
  implementation 'com.google.code.gson:gson:2.8.6'
  implementation 'androidx.localbroadcastmanager:localbroadcastmanager:1.0.0'
  implementation 'com.squareup.okhttp3:okhttp:3.12.12'
  implementation 'com.squareup.okio:okio:1.15.0'
#### Ironsource - Rewarded Video Network
* 아래 참조가 없다면 참조를 해주어야합니다.  
  implementation 'org.jetbrains.kotlin:kotlin-stdlib:1.4.10'