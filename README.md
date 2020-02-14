# Adiscope-Android-Sample
Sample for Adiscope Android sdk

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

Module Gradle:
```gradle
dependencies {

    // [required] adiscope library
    implementation 'com.nps.adiscope:adiscopeCore:1.1.0'
    implementation 'com.nps.adiscope:adiscopeAndroid:1.1.1'

    // If you are already using goople play-services-ads, you can remove play-services-basement
    implementation 'com.google.android.gms:play-services-basement:8.3.0'

    // [optional] adiscope rewarded video networks
    implementation 'com.nps.adiscope:adapter.adcolony:3.3.10.0'     // adcolony
    implementation 'com.nps.adiscope:adapter.admob:1.1.1.0'         // admob
    implementation 'com.nps.adiscope:adapter.fan:5.5.0.0'           // fan
    implementation 'com.nps.adiscope:adapter.ironsource:6.6.5.0'    // ironsource
    implementation 'com.nps.adiscope:adapter.mobvista:9.12.7.0'     // mobvista
    implementation 'com.nps.adiscope:adapter.unityads:3.4.2.0'      // unityads
    implementation 'com.nps.adiscope:adapter.vungle:6.4.11.0'       // vungle
}
```


AndroidManifest.xml setting for admob network:
```
<application ...>
    <!-- admob app id for adiscope Admob rewarded video networks -->
    <meta-data
        android:name="com.google.android.gms.ads.APPLICATION_ID"
        android:value="admob_app_id"/>
    ...
</application>
```