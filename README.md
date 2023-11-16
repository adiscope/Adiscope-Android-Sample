# Adiscope-Android-Sample
Sample for Adiscope Android sdk


## Requirements
- minSdkVersion 16
- To use mobvista, vungle mediation network, You should include androidx library (https://developer.android.com/jetpack/androidx/migrate)

## version : 3.3.0

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
                // 필드값은 필수이나 value는 빈 값으로 기입할 수 있음 (ex. adiscope_sub_domain: "")
                // 무료페이지 상세 페이지 이동 기능을 적용 시에 기재하는 값으로,
                // 해당 기능 적용 시 애디스콥과 협의 필요
                adiscope_sub_domain: "sub domain 기입필요"
        ]
    }
    ...
}

dependencies {

    // [required] adiscope library
    implementation 'com.nps.adiscope:adiscopeCore:3.3.0'
    implementation 'com.nps.adiscope:adiscopeAndroid:1.2.0'

    // adiscope sdk have to extract Google Advertising Id.
    // if com.google.android.gms.ads.identifier.AdvertisingIdClient class is not included in your app, uncomment following code
    // implementation 'com.google.android.gms:play-services-basement:8.3.0'

    implementation 'com.nps.adiscope:adapter.chartboost:9.2.2'        // chartboost

    implementation 'com.nps.adiscope:adapter.ironsource:7.2.2'   // ironsource

    implementation 'com.nps.adiscope:adapter.unityads:4.2.2'      // unityads

    /****************************
     max adapter를 연동하면 하기 네트워크들이 max bidder로 포함됩니다.
     admob, fan, mobvista, pangle, smaato, vungle
     비더 네트워크를 워터폴로도 함께 운영하려면 아래 워터폴 어댑터 라이브러리들을 선택적으로 포함해야 합니다.
     (아래 네트워크들이 max bidder에 포함됨)
     *****************************/
    implementation 'com.nps.adiscope:adapter.max:11.9.3'        // max
    implementation 'com.nps.adiscope:adapter.applovin:11.9.0.0'        // applovin (watarfall adapter)
    implementation 'com.nps.adiscope:adapter.admob:20.7.0'        // admob (use play-services-ads:20.6.0 dependency)
    implementation 'com.nps.adiscope:adapter.fan:6.13.7.0'           // fan
    implementation 'com.nps.adiscope:adapter.mobvista:16.4.32'     // mobvista (use androidx)
    implementation "com.nps.adiscope:adapter.pangle:5.1.0.8.0"        // pangle
    implementation 'com.nps.adiscope:adapter.vungle:6.12.1.1'        // vungle (use androidx)
}
```

### AndroidManifest.xml setting for admob network, manifestPlaceholders
```
<application ...>
    <!-- admob app id for adiscope Admob rewarded video networks -->
    <meta-data
        android:name="com.google.android.gms.ads.APPLICATION_ID"
        android:value="admob_app_id"/>
    ...
    <!-- gradle에 정의한 애디스콥 매체 아이디, 시크릿키 값을 매니페스트에 연결 -->
    <meta-data android:name="adiscope_media_id" android:value="${adiscope_media_id}"/>
    <meta-data android:name="adiscope_media_secret" android:value="${adiscope_media_secret}"/>
</application>
```

