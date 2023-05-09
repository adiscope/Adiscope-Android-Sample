# Adiscope-Android-Sample
Sample for Adiscope Android sdk


## Requirements
- minSdkVersion 16
- To use mobvista, vungle mediation network, You should include androidx library (https://developer.android.com/jetpack/androidx/migrate)

## version : 3.0.0.0

## Link
- [Release note](https://github.com/adiscope/Adiscope-Android-Sample/wiki/release_note)

## Guide
- [연동 가이드](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/AdiscopeSDKGuide.md)

## Error Information
- [Error 정보](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/error_info.md)

## Download

### Project Gradle
```gradle
allprojects {
    repositories {
        maven {
            url 'https://repository.adiscope.com/repository/adiscope/'
        }
        ...
    }
}
```

### Module Gradle
```gradle
android {
    ...
    defaultConfig {

        // 애디스콥 측에 media_id 와 media_secret, sub_domain 문의!

        manifestPlaceholders = [
                adiscope_media_id: "media id 기입필요",
                adiscope_media_secret: "media secret 기입필요",
                adiscope_sub_domain: "sub domain 기입필요"
        ]
    }
    ...
}

dependencies {

    // [required] adiscope library
    implementation 'com.nps.adiscope:adiscopeCore:3.0.0.0'
    implementation 'com.nps.adiscope:adiscopeAndroid:1.1.8'

    // adiscope sdk have to extract Google Advertising Id.
    // if com.google.android.gms.ads.identifier.AdvertisingIdClient class is not included in your app, uncomment following code
    // implementation 'com.google.android.gms:play-services-basement:8.3.0'

    // [optional] adiscope rewarded video networks
    implementation 'com.nps.adiscope:adapter.admob:20.6.0.4'        // admob (use play-services-ads:20.6.0 dependency)

    implementation 'com.nps.adiscope:adapter.chartboost:8.4.2.2'        // chartboost

    implementation 'com.nps.adiscope:adapter.ironsource:7.2.1.3'   // ironsource

    implementation 'com.nps.adiscope:adapter.unityads:4.2.1.1'      // unityads

    implementation 'com.nps.adiscope:adapter.max:11.9.0.0'        // max
    implementation 'com.applovin:applovin-sdk:11.9.0'        // applovin 앱러빈은 직접 참조 해야함

    /****************************
     max lib를 사용하더라도 max bidder로 포함되어 있는 네트워크의 워터폴을 사용하실 경우,
     해당 네트워크 어댑터 참조를 선택적으로 하시면 됩니다.
     (아래 네트워크들이 max bidder에 포함됨)
     *****************************/

    implementation 'com.nps.adiscope:adapter.applovin:11.9.0.0'        // applovin
    implementation 'com.nps.adiscope:adapter.fan:6.13.7.0'           // fan
    implementation 'com.nps.adiscope:adapter.inmobi:10.1.3.4.0'      // inmobi
    implementation 'com.nps.adiscope:adapter.mobvista:16.4.31.0'     // mobvista (use androidx)
    implementation "com.nps.adiscope:adapter.pangle:5.1.0.8.0"        // pangle
    implementation 'com.nps.adiscope:adapter.smaato:22.1.0.0'        // smaato
    implementation 'com.nps.adiscope:adapter.tapjoy:12.11.1.2'        // tapjoy
    implementation 'com.nps.adiscope:adapter.vungle:6.12.1.1'        // vungle (use androidx)
}
```

### AndroidManifest.xml setting for admob network:
```
<application ...>
    <!-- admob app id for adiscope Admob rewarded video networks -->
    <meta-data
        android:name="com.google.android.gms.ads.APPLICATION_ID"
        android:value="admob_app_id"/>
    ...
</application>
```

