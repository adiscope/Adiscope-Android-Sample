# Adiscope-Android-Sample
Sample for Adiscope Android sdk


## Requirements
- minSdkVersion 16
- To use mobvista, vungle mediation network, You should include androidx library (https://developer.android.com/jetpack/androidx/migrate)

## version : 2.0.7.0

## Link
- [Release note](https://github.com/adiscope/Adiscope-Android-Sample/wiki/release_note)

## Guide
- [연동 가이드](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/AdiscopeSDKGuide.md)

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
dependencies {

    // [required] adiscope library
    implementation 'com.nps.adiscope:adiscopeCore:2.0.7.0'
    implementation 'com.nps.adiscope:adiscopeAndroid:1.1.3'

    // adiscope sdk have to extract Google Advertising Id.
    // if com.google.android.gms.ads.identifier.AdvertisingIdClient class is not included in your app, uncomment following code
    // implementation 'com.google.android.gms:play-services-basement:8.3.0'

    // [optional] adiscope rewarded video networks
    implementation 'com.nps.adiscope:adapter.admob:20.2.0.2'        // admob (use play-services-ads:19.4.0 dependency)
    implementation 'com.nps.adiscope:adapter.applovin:9.14.10.2'        // applovin
    implementation 'com.nps.adiscope:adapter.fan:6.7.0.0'           // fan
    implementation 'com.nps.adiscope:adapter.ironsource:7.1.12.0'   // ironsource
    implementation 'com.nps.adiscope:adapter.mobvista:15.4.31.4'     // mobvista (use androidx)
    implementation 'com.nps.adiscope:adapter.tapjoy:12.7.1.6'        // tapjoy
    implementation 'com.nps.adiscope:adapter.unityads:3.7.5.1'      // unityads
    implementation 'com.nps.adiscope:adapter.vungle:6.10.2.0'        // vungle (use androidx)

    // [optional] adiscope interstitial networks
    implementation 'com.nps.adiscope:adapter.admob:20.2.0.2'        // admob (use play-services-ads:19.4.0 dependency)
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

