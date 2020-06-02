# Adiscope-Android-Sample
Sample for Adiscope Android sdk


## Requirements
- minSdkVersion 15
- To use mobvista, vungle mediation network, You should include androidx library (https://developer.android.com/jetpack/androidx/migrate)

## version : 1.1.6

## Link
- [Release note](https://github.com/adiscope/Adiscope-Android-Sample/wiki/release_note)
- [Adiscope Android Sdk Guide](https://github.com/adiscope/Adiscope-Android-Sample/tree/master/doc/AdiscopeAndroidSdk_guide.pdf) (해당 페이지에서 Download 버튼을 클릭해 파일을 다운로드받으세요)

## Download

### Project Gradle
```gradle
allprojects {
    repositories {
        maven {
            url 'http://repository.adiscope.com:8081/repository/adiscope/' // In order to connect, you need to register the IP address to adiscope inbound
        }
        ...
    }
}
```

### Module Gradle
```gradle
dependencies {

    // [required] adiscope library
    implementation 'com.nps.adiscope:adiscopeCore:1.1.6'
    implementation 'com.nps.adiscope:adiscopeAndroid:1.1.2'

    // adiscope sdk have to extract Google Advertising Id.
    // if com.google.android.gms.ads.identifier.AdvertisingIdClient class is not included in your app, uncomment following code
    // implementation 'com.google.android.gms:play-services-basement:8.3.0'

    // [optional] adiscope rewarded video networks
    implementation 'com.nps.adiscope:adapter.adcolony:4.1.4.0'      // adcolony
    implementation 'com.nps.adiscope:adapter.admob:17.2.0.0'        // admob (use play-services-ads:17.2.0 dependency)
    implementation 'com.nps.adiscope:adapter.fan:5.9.0.0'           // fan
    implementation 'com.nps.adiscope:adapter.ironsource:6.16.1.0'   // ironsource
    implementation 'com.nps.adiscope:adapter.mobvista:13.1.1.1'     // mobvista (use androidx)
    implementation 'com.nps.adiscope:adapter.unityads:3.4.2.3'      // unityads
    implementation 'com.nps.adiscope:adapter.vungle:6.5.3.0'        // vungle (use androidx)
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

