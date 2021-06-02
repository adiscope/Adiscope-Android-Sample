# Adiscope for Android Integration


## version history.Android
|날짜|변경 사항|
|----------|------------------|
|2021/03/17| [기능 변경] <br>mobvista  13.1.1 → 15.4.31</br> unityads  UnityMonetization -> UnityAds 변경 |
|2021/02/19| [이슈 수정] <br>offerwall 문의 하기 이슈 수정|
|2021/02/16| [이슈 수정] <br> 무한로딩 이슈 수정 <br>android target30 에서 패키지 네임 못가져오는 이슈 수정 |
|2021/01/12| [기능 변경] <br>네트워크 tapjoy 추가 12.7.1<br>네트워크 applovin 추가 9.14.9<br>에러메시지 고도화<br>버전관리 기능 추가<br>각종 기능 개선 |
|2021/01/5| [이슈 수정] <br>RV, Interstitial 최초 진입시 ADID 가져 오지 못하는 이슈 수정 |
|2020/12/02| [이슈 수정] <br>오퍼월 최초 진입시 ADID 가져 오지 못하는 이슈 수정|
|2020/11/24| [기능 변경] <br>Adiscope-android-sdk.adiscopeCore 1.6.0 -> 1.6.1<br>target sdk version 30 대응<br>adcolony sdk version 변경 : 4.1.4 -> 4.3.0<br>ironsouece sdk version 변경 : 6.16.1 -> 7.0.3<br>기타 사용성 개선|
|2020/11/13| [기능 변경] <br>멀티인스턴스 체계 적용<br>멀티인스턴스 체계 적용으로 안한 각 네트워크사의 adapter 구조 변경<br>Adiscope-android-sdk.adiscopeCore 1.5.9 -> 1.6.0
|2020/10/22	| [기능 변경] <br>target sdk version 30 대응<br>admob sdk version 변경 : 17.2.0 -> 19.4.0<br>unityads sdk version 변경 : 3.4.2 -> 3.5.0<br>vungle sdk version 변경 : 6.5.3 -> 6.8.0<br>fan sdk version 변경 : 5.9.0-> 6.1.0|
|2020/08/20	| [이슈 수정] <br>X509Certificate 경고 수정|
|2020/08/06	| [기능 개선] <br>오퍼월 기능 개선|
|2020/06/23	| [기능 추가] <br>인터스티셜 기능 추가 및 연동가이드 설명 추가 <br>admob 인터스티셜 네트워크 추가|
|2020/06/02	| [기능 변경] <br>OfferwallAd.show(String unitId) 인터페이스가 OfferwallAd.show(Activity activity, String unitId) 로 변경됨<br>Admob 네트워크의 Google Play Services Ads 버전이 17.2.0으로 변경됨|
|2020/05/15	| [기능 개선] <br>Vungle network sdk 업데이트 : 6.4.11 -> 6.5.3 (use androidx)<br>Mobvista network sdk 업데이트 : 9.12.7 -> 13.1.1 (use androidx)<br>Vungle, Mobvista 연동가이드 설명 변경<br>Vungle, Mobvista 새버전을 사용하기위해서는 앱내에 androidx 라이브러리가 포함되어야합니다.<br>앱 환경에 따라서 androidx migration이 필요할 수 있습니다. (https://developer.android.com/jetpack/androidx/migrate)|
|2020/03/02	| [기능 변경] <br>setUserId API의 userId 문자열 32자 제한 조건이 제거됨<br>연동가이드 변경 setUserId API의 userId 문자열 32자 제한사항에 대한 설명 제거됨|
|2020/02/21	| [연동가이드 변경] <br>구글가족정책 가이드 추가|
|2020/02/14 | [연동가이드 변경] <br> Adiscope sdk 배포 방식을 maven repository로 변경 및 연동가이드 수정|
|2020/02/06 | [연동가이드 변경] <br> adcolony proguard 설정 변경|
|2020/01/31 | [기능 변경/연동가이드 변경] <br> Unityads sdk 교체 : 3.0.0 -> 3.4.2<br>Unityads AndroidManifest.xml 항목 변경|
|2020/01/08	| [기능 변경] <br>Vungle (v6.4.11) 연동가이드 대폭 변경 (Activity, proguard 설명 변경)<br>Youappi Reward Video Network 제거|
|2019/11/01	| [기능 변경/연동가이드 변경] <br>FAN sdk 교체 : 5.0.1 -> 5.5.0<br>FAN 연동가이드 대폭 변경|
|2019/10/24	| [기능 변경] <br>Applovin 네트워크 제거 및 Applovin 관련 연동가이드 제거<br>Mobvista 네트워크 연동가이드 변경<br>AndroidManifest.xml의 MTGFileProvider provider 항목 제거<br>mtg_provider_paths.xml xml 파일 생성하는 내용 제거|
|2019/08/09 | [연동가이드 설명 추가] <br>Mobvista sdk 설정 가이드 및 proguard 설정 변경|
|2019/3/4	  | [기능 추가] <br>Vungle network sdk 4.0.3 -> 6.3.24 업데이트 (AndroidManifest, proguard 설정 및 라이브러리 구조 변경)<br>Youappi Reward Video Network 추가 (v4.3.10)<br>Offerwall 처리 개선 - 설치확인 기능의 예외 처리 추가|
|2019/01/04	| [기능 추가] <br>Applovin network sdk 7.0.3 -> 8.1.4 업데이트<br>Unityads network sdk 2.1.2 -> 3.0.0 업데이트 (proguard 설정 변경)|
|2018/11/08	| [기능 추가] <br>FAN 5.0.1 (Facebook Audience Network) Reward Video Network 추가<br>Admob 버전 17 지원|
|2018/08/28	| [기능 추가] <br>Admob Reward Video Network 추가|
|2018/06/25	| [기능 추가] <br>setUserId API에 사용되는 userId 파라미터의 길이 제한이 20자에서 32자로 변경되었습니다.|
|2018/06/14	| [기능 추가] <br>오퍼월 광고는 Adiscope 서버가 3rd-party 서버로부터 광고 캠페인들을 직접 수집하는 방식으로 변경되었습니다. 따라서 3rd-party 오퍼월 sdk들은 제거되었습니다.<br>인터페이스 변경<br>메인 클래스의 클래스 이름이 변경되었습니다. (com.nps.adiscope.Adiscope -> com.nps.adiscope.AdiscopeSdk)|
|2018/03/04	| [기능 추가] <br>OptionSetter.setUseCloudFrontProxy(boolean useCloudFrontProxy) API 추가|


## 애디스콥 네트워크 버전 호환정보
|adiscope core version|adcolony|admob|applovin|fan|ironsource|mobvista|tapjoy|unityads|vungle|
|---------------------|--------|-----|--------|---|----------|--------|------|--------|------|
|~1.1.5|~3.3.10.2|~1.1.1.3|no service|~5.5.0.2|~6.6.5.2|~13.1.1.2|no service|~3.4.2.2|~6.4.11.2|
|1.15~1.6.3   |3.3.10.3 ~ 4.3.0.0   |1.1.1.4~19.4.0.1	|no service|5.5.0.3~6.1.0.1	|6.6.5.3~7.0.3.0	|13.1.1.3~13.1.1.2	|no service|3.4.2.3~3.5.0.1	|6.5.3.0~6.8.0.1|
|1.6.4~1.6.6	|4.3.0.1~|19.4.0.2~|9.14.9.0~|6.1.0.2~|7.0.3.1~|15.4.31.0~|12.7.1.2~|3.5.0.3~|6.8.0.2~|
|2.0.0~	|4.3.0.2~|19.4.0.3~|9.14.10.0~|6.4.0.1~|7.0.3.2~|15.4.31.1~|12.7.1.3~|3.5.0.4~|6.8.0.3~|











	



## Installation

### CocoaPods
CocoaPods는 Cocoa projects의 Dependency를 관리할 수 있습니다. 다음과 같은 명령어를 사용하여 설치를 진행합니다.
```
$ gem install cocoapods
```



CocoaPods의 Xcode project내에 Podfile에서 기술합니다.

```
source 'https://github.com/CocoaPods/Specs.git'
platform :ios, '10.0'
use_frameworks!

target '<Your Target Name>' do
    pod 'Adiscope', '1.6.6.1'
    # pod 'AdiscopeMediaAppLovin', '1.6.0.1'
    # pod 'AdiscopeMediaAdMob', '1.6.0.1'
    # pod 'AdiscopeMediaAdColony', '1.6.0.1'
    # pod 'AdiscopeMediaFAN', '1.6.4.1'
    # pod 'AdiscopeMediaMobVista', '1.6.4.4'
    # pod 'AdiscopeMediaUnityAds', '1.6.6.1'
    # pod 'AdiscopeMediaVungle', '1.6.6.1'
end
```



그리고 다음의 명령어를 실행합니다.

```
$ pod install --repo-update
```



### Manual

* Native Manual 설치는 해당 [문서](https://github.com/adiscope/Adiscope-iOS-Sample/blob/2.0.0/Installation_manual.md)



## Setup Xcode

### info.plist 수정

- App Tracking Permission 추가

	```
	<key>NSUserTrackingUsageDescription</key>
	<string></string>
	```


- Xcode 12.0 이상일 경우 SKAdNetwork 추가 ([Download](https://github.com/adiscope/Adiscope-iOS-Sample/releases/download/1.6.6.0/AdiscopeSkAdNetworks.plist))

  ```
  <dict>
	  <key>SKAdNetworkItems</key>
	    <array>
	      <dict>
	        <key>SKAdNetworkIdentifier</key>
	        <string></string>
	      </dict>
	    </array>
  </dict>
  ```


- **(Admob)** info.plist 에 "GADIsAdManagerApp" 설정

	```
	<key>GADIsAdManagerApp</key>
	<true/>
	```


- **(AppLovin)** info.plist 에 Key 설정

	```
	<key>AppLovinSdkKey</key>
	<string></string>
	```
