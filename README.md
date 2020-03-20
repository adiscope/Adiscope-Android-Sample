# Adiscope-Android-Sample
Sample for Adiscope Android sdk


## Requirements
- minSdkVersion 15


## Link 
- [Release note](https://github.com/adiscope/Adiscope-Android-Sample/wiki/release_note)
- [Adiscope Android Sdk Guide](https://github.com/adiscope/Adiscope-Android-Sample/tree/master/doc/AdiscopeAndroidSdk_guide.pdf) (해당 페이지에서 Download 버튼을 클릭해 파일을 다운로드받으세요)


### Download

Project Gradle:
```gradle
allprojects {
    repositories {
        maven {
            url 'http://repository.adiscope.com:8081/repository/adiscope/'
        }
        ...
    }
}
```

### Module Gradle
```gradle
dependencies {

    // [required] adiscope library
    implementation 'com.nps.adiscope:adiscopeCore:1.1.4'
    implementation 'com.nps.adiscope:adiscopeAndroid:1.1.2'

    // If you are already using goople play-services-ads, you can remove play-services-basement
    implementation 'com.google.android.gms:play-services-basement:8.3.0'

    // [optional] adiscope rewarded video networks
    implementation 'com.nps.adiscope:adapter.adcolony:3.3.10.2'     // adcolony
    implementation 'com.nps.adiscope:adapter.admob:1.1.1.3'         // admob
    implementation 'com.nps.adiscope:adapter.fan:5.5.0.2'           // fan
    implementation 'com.nps.adiscope:adapter.ironsource:6.6.5.2'    // ironsource
    implementation 'com.nps.adiscope:adapter.mobvista:9.12.7.2'     // mobvista
    implementation 'com.nps.adiscope:adapter.unityads:3.4.2.2'      // unityads
    implementation 'com.nps.adiscope:adapter.vungle:6.4.11.2'       // vungle
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

