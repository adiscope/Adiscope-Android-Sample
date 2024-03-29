Version Info
============
- [ChangeLog](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/version_info.md#changelog)
- [VersionCompatible](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/version_info.md#versioncompatible)
- [ReleaseNote](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/version_info.md#releasenote)

## ChangeLog
| 날짜          | 변경 사항                                                                                                                                                                                                                                                                                                                                                                                                                      |
|-------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 2024/03/19  | 핫픽스 <br>adiscope-core  3.5.0 → 3.5.1 </br> setVolumeOff 지원 네트워크 확장 (Applovin, MAX, Mobvista) </br>                                                                                                                                                                                                                                                                                                                         |
| 2024/03/15  | 기능 변경 <br>adiscope-core  3.4.0 → 3.5.0 </br> MAX 3rd party bidder 추가 (Inmobi) <br> 오퍼월 버그 수정 </br>                                                                                                                                                                                                                                                                                                                         |
| 2024/02/02  | 기능 변경 <br>adiscope-core  3.3.2 → 3.4.0 </br> MAX 3rd party bidder 추가 (Verve)                                                                                                                                                                                                                                                                                                                                               |
| 2023/12/22  | 핫픽스 <br>adiscope-core  3.3.1 → 3.3.2 </br> ㄴ 네트워크 SDK 버전 최신화 </br> 비디오 볼륨의 on/off 기능 추가                                                                                                                                                                                                                                                                                                                                    |
| 2023/12/05  | 핫픽스 <br>adiscope-core  3.3.0 → 3.3.1 </br> ㄴ 오퍼월 광고 목록 버그 수정 </br>                                                                                                                                                                                                                                                                                                                                                         |
| 2023/11/29  | 기능 변경 <br>adiscope-core  3.1.0 → 3.3.0 </br> Rewarded Interstitial 추가 </br> Admob Dynamic Floor 추가 </br> 오퍼월 신규 광고 라벨 UI 추가 </br> admob, ironsource, smaato SDK 버전 업데이트 </br> * admob: 20.6.0 -> 22.3.0 </br> * ironsource: 7.2.1 -> 7.5.1 </br> * smaato(max bidder): 22.1.0 -> 22.1.1 </br> max 어댑터 구조 변경 및 tapjoy, inmobi, smaato 어댑터 제거 </br>                                                                          |
| 2023/11/17  | 핫픽스 <br>adiscope-Android 업데이트 1.1.8 -> 1.1.9 </br> ㄴ 구글 플레이스토어 정책 사항 반영을 위한 오퍼월 화면의 앱링크 스킴 제거 </br>                                                                                                                                                                                                                                                                                                                        |
| 2023/11/10  | 핫픽스 <br>MAX Adapter 업데이트 9.2.1 → 9.2.2 </br> ㄴ inmobi bidder 제외 </br>                                                                                                                                                                                                                                                                                                                                                      |
| 2023/08/17  | 기능 변경 <br>adiscope-core  3.0.0.0 → 3.1.0 </br> MAX 3rd party bidder 추가 (Google Bidding - Admob) </br> chartboost SDK 업데이트 8.4.2 -> 9.2.1 </br> 아래 함수 호출시, 이니셜라이즈 실패할 경우 인스턴스를 null로 반환 하도록 변경 </br>   * `AdiscopeSdk.getRewardedVideoAdInstance(act)` </br> * `AdiscopeSdk.getInterstitialAdInstance(act)` </br> * `AdiscopeSdk.getOfferwallAdInstance(act)` </br> ㄴ `AdiscopeSdk.isInitialize()` 함수로 이니셜라이즈 여부 체크하여 사용 필요 |
| 2023/05/04  | 기능 변경 <br>adiscope-core  2.1.8.0 → 3.0.0.0 </br> MAX 3rd party bidder 추가 (Vungle, Pangle, Tapjoy)                                                                                                                                                                                                                                                                                                                          |
| 2023/04/25  | 기능 변경 <br>adiscope-core  2.1.7.2 → 2.1.8.0 </br> adiscope-android 1.1.7 → 1.1.8 </br> Tapjoy Interstitial 추가, Offerwall 상세화면 바로가기 기능 추가 (딥링크, 앱링크)                                                                                                                                                                                                                                                                         |
| 2023/03/16  | 기능 변경 <br>adiscope-core  2.1.7.1 → 2.1.7.2 </br> adiscope-android 1.1.6 → 1.1.7 </br> RV, Interstitial 실 로드 대기시간 지표 추가, RV 성능 개선, 이니셜라이즈 함수 추가                                                                                                                                                                                                                                                                             |
| 2023/03/02  | 기능 변경 <br>adiscope-core  2.1.7.0 → 2.1.7.1 </br> 앱러빈 다이나믹 비드 소스 네트워크 추가 및 수정                                                                                                                                                                                                                                                                                                                                               |
| 2023/02/20  | 기능 변경 <br>adiscope-core  2.1.6.0 → 2.1.7.0 </br> 앱러빈 다이나믹 비드 보완, Offerwall 상세화면 바로가기 기능 추가, NetworkSdk 업데이트                                                                                                                                                                                                                                                                                                                |
| 2022/12/22  | 기능 변경 <br>adiscope-core  2.1.5.0 → 2.1.6.0 </br> 앱러빈 다이나믹 비드 적용                                                                                                                                                                                                                                                                                                                                                            |
| 2022/12/16  | 기능 변경 <br>adiscope-core  2.1.4.0 → 2.1.5.0 </br> Offerwall 멀티 유닛 적용, adcolony adapter 삭제                                                                                                                                                                                                                                                                                                                                   |
| 2022/10/04  | 기능 변경 <br>adiscope-core  2.1.3.1 → 2.1.4.0 </br> 신규 네트워크 pangle 추가, 사용성 개선                                                                                                                                                                                                                                                                                                                                                 |
| 2022/08/03  | 기능 변경 <br>adiscope-core  2.1.3.0 → 2.1.3.1 </br> Offerwall reward 단위 이슈 수정                                                                                                                                                                                                                                                                                                                                                 |
| 2022/07/29  | 기능 변경 <br>adiscope-core  2.1.2.1 → 2.1.3.0 </br> 광고 네트워크 SDK 업데이트 AppLovin, 오퍼월 신규 상품 출시, 오퍼월 에러코드 주체변경                                                                                                                                                                                                                                                                                                                    |
| 2022/07/12  | 기능 변경 <br>adiscope-core  2.1.2.0 → 2.1.2.1 </br> 광고 네트워크 SDK 업데이트 Vungle, Fan                                                                                                                                                                                                                                                                                                                                              |
| 2022/06/24  | 기능 변경 <br>adiscope-core  2.1.1.0 → 2.1.2.0 </br> RV 이슈 수정, 각종 네트워크 업데이트, UnityAds Interstitial 추가                                                                                                                                                                                                                                                                                                                          |
| 2022/04/28  | 기능 변경 <br>adiscope-core  2.1.0.0 → 2.1.1.0 </br> RV Adapter 구조 변경, Offerwall UI 개선, ironsource 개선                                                                                                                                                                                                                                                                                                                          |
| 2022/04/01  | 기능 변경 <br>adiscope-core  2.0.9.0 → 2.1.0.0 </br> Chartboost RV 추가, Vungle Interstitial 추가 및 이슈 수정 및 기능 개선                                                                                                                                                                                                                                                                                                                  |
| 2022/03/05  | 기능 변경 <br>adiscope-core  2.0.8.0 → 2.0.9.0 </br> 구글 가족정책 대응 및 네트워크 업데이트 및 이슈 수정 및 기능 개선                                                                                                                                                                                                                                                                                                                                    |
| 2021/12/30  | 기능 변경 <br>adiscope-core  2.0.7.1 → 2.0.8.0 </br> Android 12대응 네트워크 업데이트 및 기능 개선                                                                                                                                                                                                                                                                                                                                            |
| 2021/11/19  | 이슈 수정 <br>adiscope-core  2.0.7.0 → 2.0.7.1 </br> RV show 할 때 NPE 발생 수정                                                                                                                                                                                                                                                                                                                                                     |
| 2021/11/15  | 기능 변경 <br>adiscope-core  2.0.6.1 → 2.0.7.0 </br> ironsource, vungle sdk 업 및 기타 기능 개선                                                                                                                                                                                                                                                                                                                                       |
| 2021/10/22  | 이슈 수정 <br>adiscope-core  2.0.6.0 → 2.0.6.1 </br> adid 비활성화 안내 문구 변경                                                                                                                                                                                                                                                                                                                                                        |
| 2021/10/22  | 이슈 수정 <br>adiscope-core  2.0.5.0 → 2.0.6.0 </br> fan, unityAds 안드로이드 12대응 update                                                                                                                                                                                                                                                                                                                                           |
| 2021/10/01  | 이슈 수정 <br>adiscope-core  2.0.3.3 → 2.0.5.0 </br> fan bidding 추가, 인터스티셜 개선, admob 20.2.0 버전 및 안드로이드 12 대응                                                                                                                                                                                                                                                                                                                   |
| 2021/09/14  | 이슈 수정 <br>adiscope-core  2.0.3.2 → 2.0.3.3 </br> adid 0이어도 session init 통과 수정                                                                                                                                                                                                                                                                                                                                              |
| 2021/09/07  | 이슈 수정 <br>adiscope-core  2.0.3.1 → 2.0.3.2 </br> rv initialize time out 추가                                                                                                                                                                                                                                                                                                                                                 |
| 2021/09/03  | 이슈 수정 <br>unityads:3.5.0.6 -> 3.5.0.7 </br> UnityAdsAdapter NPE 수정                                                                                                                                                                                                                                                                                                                                                         |
| 2021/08/12  | 기능 변경 <br>adiscope-core  2.0.3 → 2.0.3.1</br> cps 탭 분리 사이드 이펙트 수정                                                                                                                                                                                                                                                                                                                                                          |
| 2021/07/26  | 기능 변경 <br>adiscope-core  2.0.2 → 2.0.3</br> cps 탭 분리 excludeType List param 변경                                                                                                                                                                                                                                                                                                                                             |
| 2021/06/24  | 기능 변경 <br>RV 안정화</br> 전 network timeout 추가                                                                                                                                                                                                                                                                                                                                                                                 |
| 2021/06/08  | 기능 변경 <br>RV hotfix</br> admob timeout 추가                                                                                                                                                                                                                                                                                                                                                                                  |
| 2021/06/02  | 기능 변경 <br>RV 구조 변경</br>                                                                                                                                                                                                                                                                                                                                                                                                    |
| 2021/03/17  | 기능 변경 <br>mobvista  13.1.1 → 15.4.31</br> unityads  UnityMonetization -> UnityAds 변경                                                                                                                                                                                                                                                                                                                                       |
| 2021/02/19  | 이슈 수정 <br>offerwall 문의 하기 이슈 수정                                                                                                                                                                                                                                                                                                                                                                                            |
| 2021/02/16  | 이슈 수정 <br> 무한로딩 이슈 수정 <br>android target30 에서 패키지 네임 못가져오는 이슈 수정                                                                                                                                                                                                                                                                                                                                                           |
| 2021/01/12  | 기능 변경 <br>네트워크 tapjoy 추가 12.7.1<br>네트워크 applovin 추가 9.14.9<br>에러메시지 고도화<br>버전관리 기능 추가<br>각종 기능 개선                                                                                                                                                                                                                                                                                                                          |
| 2021/01/5   | 이슈 수정 <br>RV, Interstitial 최초 진입시 ADID 가져 오지 못하는 이슈 수정                                                                                                                                                                                                                                                                                                                                                                     |
| 2020/12/02  | 이슈 수정 <br>오퍼월 최초 진입시 ADID 가져 오지 못하는 이슈 수정                                                                                                                                                                                                                                                                                                                                                                                  |
| 2020/11/24  | 기능 변경 <br>Adiscope-android-sdk.adiscopeCore 1.6.0 -> 1.6.1<br>target sdk version 30 대응<br>adcolony sdk version 변경 : 4.1.4 -> 4.3.0<br>ironsouece sdk version 변경 : 6.16.1 -> 7.0.3<br>기타 사용성 개선                                                                                                                                                                                                                             |
| 2020/11/13  | 기능 변경 <br>멀티인스턴스 체계 적용<br>멀티인스턴스 체계 적용으로 안한 각 네트워크사의 adapter 구조 변경<br>Adiscope-android-sdk.adiscopeCore 1.5.9 -> 1.6.0                                                                                                                                                                                                                                                                                                     
| 2020/10/22	 | 기능 변경 <br>target sdk version 30 대응<br>admob sdk version 변경 : 17.2.0 -> 19.4.0<br>unityads sdk version 변경 : 3.4.2 -> 3.5.0<br>vungle sdk version 변경 : 6.5.3 -> 6.8.0<br>fan sdk version 변경 : 5.9.0-> 6.1.0                                                                                                                                                                                                                  |
| 2020/08/20	 | 이슈 수정 <br>X509Certificate 경고 수정                                                                                                                                                                                                                                                                                                                                                                                            |
| 2020/08/06	 | 기능 개선 <br>오퍼월 기능 개선                                                                                                                                                                                                                                                                                                                                                                                                        |
| 2020/06/23	 | 기능 추가 <br>인터스티셜 기능 추가 및 연동가이드 설명 추가 <br>admob 인터스티셜 네트워크 추가                                                                                                                                                                                                                                                                                                                                                                |
| 2020/06/02	 | 기능 변경 <br>OfferwallAd.show(String unitId) 인터페이스가 OfferwallAd.show(Activity activity, String unitId) 로 변경됨<br>Admob 네트워크의 Google Play Services Ads 버전이 17.2.0으로 변경됨                                                                                                                                                                                                                                                         |
| 2020/05/15	 | 기능 개선 <br>Vungle network sdk 업데이트 : 6.4.11 -> 6.5.3 (use androidx)<br>Mobvista network sdk 업데이트 : 9.12.7 -> 13.1.1 (use androidx)<br>Vungle, Mobvista 연동가이드 설명 변경<br>Vungle, Mobvista 새버전을 사용하기위해서는 앱내에 androidx 라이브러리가 포함되어야합니다.<br>앱 환경에 따라서 androidx migration이 필요할 수 있습니다. (https://developer.android.com/jetpack/androidx/migrate)                                                                                    |
| 2020/03/02	 | 기능 변경 <br>setUserId API의 userId 문자열 32자 제한 조건이 제거됨<br>연동가이드 변경 setUserId API의 userId 문자열 32자 제한사항에 대한 설명 제거됨                                                                                                                                                                                                                                                                                                               |
| 2020/02/21	 | 연동가이드 변경 <br>구글가족정책 가이드 추가                                                                                                                                                                                                                                                                                                                                                                                                 |
| 2020/02/14  | 연동가이드 변경 <br> Adiscope sdk 배포 방식을 maven repository로 변경 및 연동가이드 수정                                                                                                                                                                                                                                                                                                                                                          |
| 2020/02/06  | 연동가이드 변경 <br> adcolony proguard 설정 변경                                                                                                                                                                                                                                                                                                                                                                                      |
| 2020/01/31  | 기능 변경/연동가이드 변경 <br> Unityads sdk 교체 : 3.0.0 -> 3.4.2<br>Unityads AndroidManifest.xml 항목 변경                                                                                                                                                                                                                                                                                                                                 |
| 2020/01/08	 | 기능 변경 <br>Vungle (v6.4.11) 연동가이드 대폭 변경 (Activity, proguard 설명 변경)<br>Youappi Reward Video Network 제거                                                                                                                                                                                                                                                                                                                       |
| 2019/11/01	 | 기능 변경/연동가이드 변경 <br>FAN sdk 교체 : 5.0.1 -> 5.5.0<br>FAN 연동가이드 대폭 변경                                                                                                                                                                                                                                                                                                                                                          |
| 2019/10/24	 | 기능 변경 <br>Applovin 네트워크 제거 및 Applovin 관련 연동가이드 제거<br>Mobvista 네트워크 연동가이드 변경<br>AndroidManifest.xml의 MTGFileProvider provider 항목 제거<br>mtg_provider_paths.xml xml 파일 생성하는 내용 제거                                                                                                                                                                                                                                             |
| 2019/08/09  | 연동가이드 설명 추가 <br>Mobvista sdk 설정 가이드 및 proguard 설정 변경                                                                                                                                                                                                                                                                                                                                                                       |
| 2019/3/4	   | 기능 추가 <br>Vungle network sdk 4.0.3 -> 6.3.24 업데이트 (AndroidManifest, proguard 설정 및 라이브러리 구조 변경)<br>Youappi Reward Video Network 추가 (v4.3.10)<br>Offerwall 처리 개선 - 설치확인 기능의 예외 처리 추가                                                                                                                                                                                                                                         |
| 2019/01/04	 | 기능 추가 <br>Applovin network sdk 7.0.3 -> 8.1.4 업데이트<br>Unityads network sdk 2.1.2 -> 3.0.0 업데이트 (proguard 설정 변경)                                                                                                                                                                                                                                                                                                            |
| 2018/11/08	 | 기능 추가 <br>FAN 5.0.1 (Facebook Audience Network) Reward Video Network 추가<br>Admob 버전 17 지원                                                                                                                                                                                                                                                                                                                                  |
| 2018/08/28	 | 기능 추가 <br>Admob Reward Video Network 추가                                                                                                                                                                                                                                                                                                                                                                                    |
| 2018/06/25	 | 기능 추가 <br>setUserId API에 사용되는 userId 파라미터의 길이 제한이 20자에서 32자로 변경되었습니다.                                                                                                                                                                                                                                                                                                                                                      |
| 2018/06/14	 | 기능 추가 <br>오퍼월 광고는 Adiscope 서버가 3rd-party 서버로부터 광고 캠페인들을 직접 수집하는 방식으로 변경되었습니다. 따라서 3rd-party 오퍼월 sdk들은 제거되었습니다.<br>인터페이스 변경<br>메인 클래스의 클래스 이름이 변경되었습니다. (com.nps.adiscope.Adiscope -> com.nps.adiscope.AdiscopeSdk)                                                                                                                                                                                                         |
| 2018/03/04	 | 기능 추가 <br>OptionSetter.setUseCloudFrontProxy(boolean useCloudFrontProxy) API 추가                                                                                                                                                                                                                                                                                                                                            |


## VersionCompatible
#### 애디스콥 네트워크 버전 호환정보

| adiscope core version | max        | admob             |applovin| fan              |ironsource| mobvista            | tapjoy            | unityads         | vungle          | pangle     | inmobi      | smaato    |
|-----------------------|------------|-------------------|--------|------------------|----------|---------------------|-------------------|------------------|-----------------|------------|-------------|-----------|
| ~1.1.5                | no service | ~1.1.1.3          |no service| ~5.5.0.2         |~6.6.5.2| ~13.1.1.2           | no service        | ~3.4.2.2         | ~6.4.11.2       | -          | -           | -         |
| 1.15~1.6.3            | no service | 1.1.1.4~19.4.0.1	 |no service| 5.5.0.3~6.1.0.1	 |6.6.5.3~7.0.3.0	| 13.1.1.3~13.1.1.2	  | no service        | 3.4.2.3~3.5.0.1	 | 6.5.3.0~6.8.0.1 | -          | -           | -         |
| 1.6.4~1.6.6	          | no service | 19.4.0.2~         |9.14.9.0~| 6.1.0.2~         |7.0.3.1~| 15.4.31.0~          | 12.7.1.2~         | 3.5.0.3~         | 6.8.0.2~        | -          | -           | -         |
| 2.0.0~2.0.3.3         | no service | 19.4.0.3~19.4.0.5 |9.14.10.0~9.14.10.1| 6.4.0.1~6.4.0.3  |7.0.3.2~7.0.3.4| 15.4.31.1~15.4.31.2 | 12.7.1.3~12.7.1.4 | 3.5.0.4~3.5.0.6  | 6.8.0.3~        | -          | -           | -         |
| 2.0.5.0               | no service | 20.2.0.0~         |9.14.10.2~| 6.4.0.5~         |7.0.3.5~| 15.4.31.3~          | 12.7.1.5~         | 3.5.0.7          | 6.8.0.5~        | -          | -           | -         |
| 2.0.6.0 ~	            | no service | 20.2.0.0~         |9.14.10.2~| 6.4.0.5~         |7.0.3.5~| 15.4.31.3~          | 12.7.1.5~         | 3.7.0.0~         | 6.8.0.5~        | -          | -           | -         |
| 2.1.4.0 ~	            | no service | 20.2.0.0~         |9.14.10.2~| 6.4.0.5~         |7.0.3.5~| 15.4.31.3~          | 12.7.1.5~         | 3.7.0.0~         | 6.8.0.5~        | 4.7.0.5.1~ | -           | -         |
| 2.1.6.0 ~	            | 11.4.4.1~  | 20.6.0.4~         |11.4.4.3~| 6.11.0.1~        |7.2.1.2~| 15.8.0.3~           | 12.10.0.1~        | 4.2.1.1~         | 6.11.0.2~       | 4.7.0.5.5~ | -           | -         |
| 2.1.8.0 ~	            | 11.4.4.1~  | 20.6.0.4~         |11.4.4.3~| 6.11.0.1~        |7.2.1.2~| 15.8.0.3~           | 12.11.1.1~        | 4.2.1.1~         | 6.11.0.2~       | 4.7.0.5.5~ | -           | -         |
| 3.0.0.0 ~	            | 11.9.0.0~  | 20.6.0.4~         |11.9.0.0~| 6.13.7.0~        |7.2.1.2~| 16.4.31.0~          | 12.11.1.2~        | 4.2.1.1~         | 6.12.1.1~       | 5.1.0.8.0~ | 10.1.3.4.0~ | 22.1.0.0~ |
| 3.1.0 ~	              | 11.9.1~    | 20.6.1~           |11.9.0.0~| 6.13.7.0~        |7.2.1.2~| 16.4.31.0~          | 12.11.1.2~        | 4.2.1.1~         | 6.12.1.1~       | 5.1.0.8.0~ | 10.1.3.4.0~ | 22.1.0.0~ |
| 3.3.0 ~	              | 11.9.2.1~  | 22.3.0.0~         |11.9.0.0~| 6.13.7.1~        |7.2.1.2~| 16.4.32.1~          | -                 | 4.2.1.2~         | 6.12.1.2~       | 5.1.0.8.1~ | -           | -         |
## ReleaseNote
> ## Version 3.5.1
> _2023-03-19_
> * setVolumeOff 지원 네트워크 확장 (Applovin, MAX, Mobvista)

> ## Version 3.5.0
> _2023-03-15_
> * MAX 3rd party bidder 추가 (Inmobi)
> * 오퍼월 버그 수정

> ## Version 3.4.0
> _2023-02-02_
> * MAX 3rd party bidder 추가 (Verve)

> ## Version 3.3.2
> _2023-12-22_
> * 네트워크 SDK 버전 최신화 및 어댑터 버전 업데이트
>  * applovin(waterfall): 11.9.0 -> 12.1.0
>  * chartboost: 9.2.1 -> 9.3.1
>  * ironsource: 7.5.1 -> 7.5.2
>  * max(applovin bidding): 11.9.0 -> 12.1.0
>    * smaato: 22.1.1.0 -> 22.5.0.0
>    * fan: 6.13.7.0 -> 6.16.0.0
>  * mobvista: 16.4.31 -> 16.5.91
>  * pangle: 5.1.0.8 -> 5.6.0.3
>  * vungle: 6.12.1 -> 7.1.0
>  * unityads: 4.2.1 -> 4.6.1
> * 비디오 볼륨의 on/off 기능 추가

> ## Version 3.3.1
> _2023-12-05_
> * 오퍼월 광고 목록 버그 수정

> ## Version 3.3.0
> _2023-11-29_
> * Rewarded Interstitial 추가
> * Admob Dynamic Floor 추가
> * 오퍼월 신규 광고 강조 추가
> * admob, ironsource, smaato SDK 버전 업데이트
>  * admob: 20.6.0 -> 22.3.0
>  * ironsource: 7.2.1 -> 7.5.1
>  * smaato(max bidder): 22.1.0 -> 22.1.1
> * max 어댑터 구조 변경 및 tapjoy, inmobi, smaato 어댑터 제거
>  * smaato는 max 어댑터에 통합되었음
>  * tapjoy, inmobi는 미지원하는 네트워크로 제거
>  * (전) max 연동 시 비더로 포함되는 모든 워터폴 어댑터의 연동 필요
>  * (후) max 연동 시 비더로 포함되는 네트워크의 물량 제공.   
     비더로 포함되는 네트워크의 워터폴 운영이 필요할 경우 선택적으로 연동 필요

> ## Version 3.1.0 (hotfix v2)
> _2023-11-17_
> * adiscopeAndroid 업데이트 1.1.8 -> 1.1.9
> * 구글 플레이스토어 정책 사항 반영을 위한 오퍼월 화면의 앱링크 스킴 제거

> ## Version 3.1.0 (hotfix)
> _2023-11-10_
> * MAX Adapter 업데이트 11.9.1 -> 11.9.2
  > * Inmobi bidder 제외

> ## Version 3.1.0
> _2023-08-17_
> * MAX 3rd party bidder 추가 (Google Bidding - Admob)
> * chartboost SDK 업데이트 8.4.2 -> 9.2.1
> * 아래 함수 호출시, 이니셜라이즈 실패할 경우 인스턴스를 null로 반환 하도록 변경 (`AdiscopeSdk.isInitialize()` 함수로 이니셜라이즈 여부 체크하여 사용 필요) 
>  * `AdiscopeSdk.getRewardedVideoAdInstance(act)`
>  * `AdiscopeSdk.getInterstitialAdInstance(act)`
>  * `AdiscopeSdk.getOfferwallAdInstance(act)`

> ## Version 3.0.0.0
> _2023-05-04_
> * MAX 3rd party bidder 추가 (Vungle, Pangle, Tapjoy)

> ## Version 2.1.8.0
> _2023-04-25_
> * Tapjoy Interstitial 추가
> * Offerwall 상세화면 바로가기 기능 추가 (딥링크, 앱링크)

> ## Version 2.1.7.2
> _2023-03-16_
> * RV, Interstitial 실 로드 대기시간 지표 추가
> * RV 성능 개선
> * 이니셜라이즈 함수 추가

> ## Version 2.1.7.1
> _2023-03-02_
> * 앱러빈 다이나믹 비드 소스 네트워크 추가 및 수정

> ## Version 2.1.7.0
> _2023-02-20_
> * 앱러빈 다이나믹 비드 보완
> * Offerwall 상세화면 바로가기 기능 추가 
> * NetworkSdk 업데이트

> ## Version 2.1.6.0
> _2022-12-22_
> * 앱러빈 다이나믹 비드 적용

> ## Version 2.1.5.0
> _2022-12-16_
> * Offerwall 멀티 유닛 적용
> * adcolony adapter 삭제

> ## Version 2.1.4.0
> _2022-10-04_
> * 신규 네트워크 pangle 추가
> * 사용성 개선 및 이슈 수정
> 
> ## Version 2.1.3.1
> _2022-08-03_
> * Offerwall 신규 아이템 reward 단위 이슈 수정

> ## Version 2.1.3.0
> _2022-07-29_
> *  광고 네트워크 SDK 업데이트 AppLovin
> *  오퍼월 신규 상품(CPCA) 출시 
> *  오퍼월 에러코드 주체변경

> ## Version 2.1.2.1
> _2022-07-12_
> * 광고 네트워크 SDK 업데이트 Vungle, Fan

> ## Version 2.1.2.0
> _2022-06-24_
> * RV Adapter 이슈 수정
> * 광고 네트워크 SDK 업데이트
> * UnityAds Interstitial 추가

> ## Version 2.1.1.0
> _2022-04-29_
> * RV Adapter 구조 변경
> * Offerwall UI 개선
> * ironsource manual load 방식으로 개선

> ## Version 2.1.0.0
> _2022-04-01_
> * chartboost RV 추가
> * Vungle Interstitial 추가
> * UnityAds, Ironsource sdk update
> * 기타 이슈 대응 및 기능 개선

> ## Version 2.0.9.0
> _2022-03-05_
> * 구글 가족정책 대응
> * admob, mobvista, vungle sdk update
> * RV, Offerwall 이슈 대응 및 기능 개선

> ## Version 2.0.8.0
> _2021-12-30_
> * Android 12 대응 및 기능개선

> ## Version 2.0.7.1
> _2021-11-19_
> * RV video show NPE 수정

> ## Version 2.0.7.0
> _2021-11-15_
> * IronSource sdk version up
> * Vungle sdk version up
> * RV 기능 개선

> ## Version 2.0.6.1
> _2021-11-03_
> * ADID 비활성화 안내 문구 변경

> ## Version 2.0.6.0
> _2021-10-22_
> * Android 12 네트워크 이슈 대응(UnityAds, Fan)
> * Mobvista Sub Thread 이슈 대응

> ## Version 2.0.5.0
> _2021-10-01_
> * Android 12 adid 제거 대응
> * Fan bidding kit 기능 추가 
> * 인터스티셜 구조개선
> 
> ## Version 2.0.3.3
> _2021-09-14_
>  * adid invalid 체크 제거

> ## Version 2.0.3.2
> _2021-09-07_
>  * RV load 시 네트워크 sdk 이니셜라이즈 시간도 타임아웃 시간으로 포함

> ## Version 2.0.3.1
> _2021-08-12_
>  * 오퍼월 구매형 아이템 이슈 수정

> ## Version 2.0.3
> _2021-07-26_
>  * CPS 탭 분리
>  * 구매한도 리스트 제어

> ## Version 2.0.2
> _2021-06-24_
>  * RV 안정화
>  * 전 network timeout 추가

> ## Version 2.0.1
> _2021-06-08_
>  * RV hotfix
>  * admob timeout 추가

> ## Version 2.0.0
> _2021-06-02_
>  * RV 구조 변경

> ## Version 1.6.6
> _2021-03-17_
>  * RV 네트워크 버전 업데이트

> ## Version 1.6.5.1
> _2021-02-19_
>  * 오퍼월 문의하기 이슈 수정

> ## Version 1.6.5
> _2021-02-16_
>  * 일부 세팅 환경에서 무한로딩 이슈 수정
>  * target sdk 30 버전 이슈 대응

> ## Version 1.6.4
> _2021-01-12_
>  * 신규 네트워크 (tapjoy, applovin) 추가
>  * 에러메시지 고도화
>  * 버전관리 기능 추가
>  * 기타 사용성 개선

> ## Version 1.6.3
> _2021-01-05_
>  * 이슈 수정
>  (RV, Interstitial 최초가 진입시 ADID 가져 오지 못하는 이슈 수정)

> ## Version 1.6.2
> _2020-12-02_
>  * 이슈 수정 (오퍼월 최초 진입시 ADID 가져 오지 못하는 이슈 수정)

> ## Version 1.6.1
> _2020-11-24_
>  * target sdk version 30 대응
>  * adcolony sdk version 변경 : 4.1.4 -> 4.3.0
>  * ironsouece sdk version 변경 : 6.16.1 -> 7.0.3
>  * 기타 사용성 개선

> ## Version 1.6.0
> _2020-11-13_
>  * 멀티인스턴스 체계 적용
>  * 멀티인스턴스 체계 적용으로 안한 각 네트워크사의 adapter 구조 변경

> ## Version 1.5.9
> _2020-10-22_
>  * 안드로이드 target sdk version 30 대응이 반영 된 각 네트워크 sdk 버전으로 update
>  * vungle, fan, admob, unityads

> ## Version 1.5.8
> _2020-10-12_
>  * 특정 유니티 앱 환경에서 오퍼월>참여목록>도움말>궁금해요 버튼 클릭시 크래쉬 발생하는 오류 수정

> ## Version 1.5.7
> _2020-09-28_
>  * 리워드비디오 시청시 드물게 userId 필드가 누락되는 버그 수정

> ## Version 1.5.2
> _2020-08-20_
>  * 구글보안정책 위반사항 수정 (X509Certificate 관련 수정)

> ## Version 1.5.1
> _2020-08-12_
>  * 오퍼월 - 버그 수정

> ## Version 1.5.0
> _2020-08-06_
>  * 오퍼월 - 기능 개선

> ## Version 1.1.7
> _2020-06-23_
>  * Interstitial 광고 타입 추가 및 Interstitial-Admob 네트워크 추가
>  * 오퍼월 - 획득보상 표시 정책 변경
>  * 오퍼월 - 문의하기 기능 개선

> ## Version 1.1.6
> _2020-06-02_
>  * Adcolony network sdk 업데이트 : 3.3.10 -> 4.1.4 (for targetSdkVersion 29 requirement)
>  * Ironsource network sdk 업데이트 : 6.6.5 -> 6.16.1 (for targetSdkVersion 29 requirement)
>  * Fan network sdk 업데이트 : 5.5.0 -> 5.9.0 (for targetSdkVersion 29 requirement)
>  * changed offerwallAd.show API interface

> ## Version 1.1.5
> _2020-05-15_
>  * Vungle network sdk 업데이트 : 6.4.11 -> 6.5.3 (use androidx)
>  * Mobvista network sdk 업데이트 : 9.12.7 -> 13.1.1 (use androidx)
>  * Vungle, Mobvista 연동가이드 설명 변경
>    * Vungle, Mobvista 새버전을 사용하기위해서는 앱내에 androidx 라이브러리가 포함되어야합니다.
>    * 앱 환경에 따라서 androidx migration이 필요할 수 있습니다. (https://developer.android.com/jetpack/androidx/migrate)

> ## Version 1.1.4
> _2020-03-30_
>  * Adiscope sdk 내에서 google adid 추출에 실패하면 RuntimeException이 발생되도록 변경됨
>  * setUserId API의 userId 파라미터의 32자 length 제한이 제거됨(하지만 length가 너무 클 경우 문제가 발생할 소지가 있습니다)

> ## Version 1.1.1
> _2020-02-27_
>  * Adiscope sdk 빌드시 코드축소/난독화에 R8 사용하던 것을 제거함
>  * Adiscope sdk 및 Vungle network의 난독화 설정 일부 변경

> ## Version 1.1.0
> _2020-02-14_
>  * Adiscope sdk 배포 방식을 maven repository로 변경 및 연동가이드 수정

> ***
