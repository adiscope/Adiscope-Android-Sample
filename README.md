# Adiscope-Android-Sample
Sample for Adiscope Android sdk

## Requirements
- minSdkVersion 16
- To use mobvista, vungle mediation network, You should include androidx library (https://developer.android.com/jetpack/androidx/migrate)

## version : 3.5.0

## Link
- [Release note](https://github.com/adiscope/Adiscope-Android-Sample/wiki/release_note)

## Guide
- [연동 가이드](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/AdiscopeSDKGuide.md)

## Error Information
- [Error 정보](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/error_info.md)

## Download

### Project Gradle
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

        // max adapter 연동 시 필수로 포함해야 합니다. (max의 비더로 포함되는 네트워크: smaato, pangle, mobvista, verve)
        // max 미운영 매체는 pangle, mobvista 워터폴 연동 시 각각의 maven url을 추가하셔야 합니다.
        maven { url "https://s3.amazonaws.com/smaato-sdk-releases/" } // max bidder로 max 연동 시 추가
        maven { url "https://verve.jfrog.io/artifactory/verve-gradle-release" } // max bidder로 max 연동 시 추가
        maven { url "https://artifact.bytedance.com/repository/pangle" } // max 혹은 pangle 연동 시 추가
        maven { url "https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea" } // max 혹은 mobvista 연동 시 추가

        // chartboost 연동 시 추가
        maven { url 'https://cboost.jfrog.io/artifactory/chartboost-ads/' }

        // ironsource 연동 시 추가
        maven { url 'https://android-sdk.is.com/' }
    }
}
```

### Module Gradle

```groovy
android {
    ...
    defaultConfig {

        // 애디스콥 측에 media_id 와 media_secret, sub_domain 문의!
        // adiscope_media_id: 매체 아이디
        // adiscope_media_secret: 매체 시크릿키
        // adiscope_sub_domain: '무료충전소 상세 화면 이동 기능'에 사용하는 값으로, 해당 기능 적용 시 애디스콥과 협의 필요
        manifestPlaceholders = [
                // 파라미터에 mediaId, mediaSecret이 미포함된 이니셜라이즈 함수를 사용할 경우 
                // => 해당 값을 읽어 이니셜라이즈 수행
                // 파라미터에 mediaId, mediaSecret이 포함되어 있는 이니셜라이즈 함수를 사용할 경우
                // => 파라미터에 포함된 매체값으로 이니셜라이즈 수행
                // (Deprecated 함수지만 사용 가능하므로 용도에 따라 적용하도록 권장)
                // 가이드 참고: /docs/api_documentation.md의 initialized Definition
                adiscope_media_id    : "media id 기입필요",
                adiscope_media_secret: "media secret 기입필요",

                // adiscopeAndroid 1.1.9 이상
                // => 필드값은 필수이나 '무료충전소 상세 화면 이동 기능' 미사용 시 
                //    value는 빈 값으로 기입할 수 있음 (ex. adiscope_sub_domain: "")
                // adiscopeAndroid 1.1.8
                // => 필드값은 필수이나 '무료충전소 상세 화면 이동 기능' 미사용 시 
                //    디폴트 값(adiscope) 추가 필요  (ex. adiscope_sub_domain: "adiscope")
                adiscope_sub_domain  : "sub domain 기입필요"
        ]
    }
    ...
}

dependencies {

    // [required] adiscope library
    implementation 'com.nps.adiscope:adiscopeCore:3.5.0'
    implementation 'com.nps.adiscope:adiscopeAndroid:1.2.1'

    // adiscope sdk have to extract Google Advertising Id.
    // if com.google.android.gms.ads.identifier.AdvertisingIdClient class is not included in your app, uncomment following code
    // implementation 'com.google.android.gms:play-services-basement:8.3.0'

    implementation 'com.nps.adiscope:adapter.chartboost:9.3.1.0'        // chartboost

    implementation 'com.nps.adiscope:adapter.ironsource:7.5.2.0'        // ironsource

    implementation 'com.nps.adiscope:adapter.unityads:4.6.1.0'          // unityads

    /****************************
     max adapter를 연동하면 하기 네트워크들이 max의 bidder로 포함됩니다.
     admob, fan, mobvista, pangle, smaato, vungle, verve
     비더 네트워크를 워터폴로도 함께 운영하려면 아래 워터폴 어댑터 라이브러리들을 선택적으로 포함해야 합니다.
     (아래 네트워크들이 max bidder에 포함됨)
     *****************************/
    implementation 'com.nps.adiscope:adapter.max:12.1.0.2'              // max
    implementation 'com.nps.adiscope:adapter.applovin:12.1.0.0'         // applovin (waterfall adapter)
    implementation 'com.nps.adiscope:adapter.admob:22.3.0.1'            // admob (use play-services-ads:22.3.0 dependency)
    implementation 'com.nps.adiscope:adapter.fan:6.13.7.1'              // fan
    implementation 'com.nps.adiscope:adapter.mobvista:16.5.91.0'        // mobvista (use androidx)
    implementation "com.nps.adiscope:adapter.pangle:5.6.0.3.0"          // pangle
    implementation 'com.nps.adiscope:adapter.vungle:7.1.0.0'            // vungle (use androidx)
}
```

### AndroidManifest.xml setting for admob network, manifestPlaceholders
```xml
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

## ETC
### MAX Ad Review
Max 어댑터를 사용하는 매체에 한하여, 동영상 소재에 따른 효율 파악 및 매출 증대를 위해 하기 작업 필요합니다.

1. 애디스콥측으로부터 맥스 Ad Review 키를 전달받는다.
2. root 수준의 build.gradle에 아래 코드를 추가한다.

#### groovy (gradle ~6.x)

```groovy
// gradle ~6.x
// build.gradle (root)
buildscript {
    repositories {
        maven { url 'https://artifacts.applovin.com/android' }
    }
    dependencies {
        classpath "com.applovin.quality:AppLovinQualityServiceGradlePlugin:+"
    }
}
```

#### kotlin (gradle ~6.x)

```kotlin
// gradle ~6.x
// build.gradle (root)
buildscript {
    repositories {
        maven { url = uri("https://artifacts.applovin.com/android") }
    }
    dependencies {
        classpath("com.applovin.quality:AppLovinQualityServiceGradlePlugin:+")
    }
}
```

gradle 버전 7 이상 사용 시에는 settings.gradle, root 수준의 build.gradle에 각각의 코드를 추가한다.

#### groovy (gradle 7+)

```groovy
// gradle 7+
// settings.gradle
pluginManagement {
    repositories {
        maven { url 'https://artifacts.applovin.com/android' }
    }
}

// build.gradle (root)
plugins {
    id 'com.applovin.quality' version '+' apply false
}
```

#### kotlin (gradle 7+)

```kotlin
// gradle 7+
// settings.gradle
pluginManagement {
    repositories {
        maven { url = uri("https://artifacts.applovin.com/android") }
    }
}

// build.gradle (root)
plugins {
    id("com.applovin.quality") version "+" apply false
}
```

3. app 수준의 build.gradle에 전달받은 Ad Review 키와 함께 아래 코드를 추가한다.  
   (gradle 버전 상관없이 동일하게 적용한다.)

#### groovy

```groovy
// build.gradle (app)
apply plugin: 'applovin-quality-service'
applovin {
    apiKey "AD_REVIEW_KEY"
} 
```

#### kotlin

```kotlin
// build.gradle (app)
plugins {
    id("applovin-quality-service")
}
applovin {
    apiKey = "AD_REVIEW_KEY"
}
```