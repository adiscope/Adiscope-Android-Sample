# 오퍼월 상세 이동 적용 가이드

## 함수 호출 (showDetail())

github의 overview에 showDetail() 메서드에 관한 설명과 사용 예시를 기술하였으므로 [해당 링크](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/overview.md#overview---offerwalladandroid)에서 참고 부탁드립니다.

</br>

## 딥링크 (custom scheme)

애디스콥측 Manifest에 intent-filter가 적용되어 있으므로 매체 측에서 별도로 설정/구현해야 할 부분은 없습니다. 다만, 매체의 `build.gradle(app)`에 `adiscope_media_id`와 `adiscope_media_secret`, `adiscope_sub_domain`이 정확히 기입되어 있는지 확인이 필요합니다.

딥링크 적용 시 매체 협업 시트를 확인하거나 담당자로부터 애디스콥 딥링크 url 형식을 전달 받아, 해당 url 형식으로 이동시키면 됩니다.

</br>

예시 코드

```java
//java
String url = "애디스콥에서 제공하는 url 형식";
Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
startActivity(intent);

// kotlin
val url = "애디스콥에서 제공하는 url 형식"
val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
startActivity(intent)
```

</br>

## 앱링크 (https)

애디스콥측의 도메인에 앱을 연결해주는 association file을 등록하여 앱링크를 동작하도록 지원합니다.
애디스콥측 Manifest에 intent-filter가 적용되어 있으므로 매체 측에서 별도로 설정/구현해야 할 부분은 없습니다. 다만, 매체의 `build.gradle(app)`에 `adiscope_media_id`와 `adiscope_media_secret`, `adiscope_sub_domain`이 정확히 기입되어 있는지 확인이 필요합니다.

매체는 도메인 연결을 위한 json 파일을 [공식 문서의 가이드](https://developer.android.com/studio/write/app-link-indexing?utm_source=android-studio#associatesite)에 따라 생성하여, 애디스콥측에 제공해야 합니다.

</br>

앱링크를 적용하고자 한다면 다음 순서를 따라주시길 바랍니다.

1. 애디스콥측과 협의하여 도메인 링크를 전달 받고
2. Android Studio > Tools > App Links Assistant의 **3. Associate website**에서 `Open Digital Asset Links File Generator` 버튼 클릭
    1. 실행하고자 하는 매체 앱의 모듈을 선택하고, 전달받은 도메인 링크와 application ID를 기입
    2. SHA256 핑거프린트 적용 (signing config 혹은 매체에서 사용하고 있는 keystore file로 설정. 앱링크 테스트 시 디버그 모드로 디버그 사이닝키를 적용하고, 라이브용 파일은 릴리즈 모드로 적용할 수 있음)
    3. `Generate Digital Asset Links file` 버튼 클릭하여 Asset Links json 파일 생성
3. 2-iii 에서 생성한 Asset Links json 파일을 애디스콥측에 전달

</br>

> ⚠️ SHA256 핑거프린트 값은 매체에서 빌드하실 때 사용하는 모든 인증키를 의미하며, 디버그(QA), 라이브, 릴리즈(스토어) 인증키를 각각 다르게 사용한다면 각 인증키값이 json 파일에 모두 포함되어야 함.

</br>

> 💡 애디스콥측에서 제공하는 도메인이 아닌 매체측에서 운영 중인 별도의 도메인에 등록하여 사용할 경우에는 사전에 협의가 필요하며, </br> 이때 애디스콥 SDK의 코드 수정이 필요하므로 해당 방법은 권장하지 않음

</br>

전달 주신 json 파일을 애디스콥에서 도메인에 등록하고 매체에 노티를 드린 시점부터 앱링크 사용이 가능해집니다.

이 앱링크는 딥링크와 동일하게 내부 코드에서도 활용할 수 있으며, 딥링크 목차의 예시 코드와 동일하게 적용할 수 있습니다.

</br></br>

## 기능별 장단점 요약
|  | showDetail() | 딥링크 (2.1.8.0~) | 앱링크(2.1.8.0~) |
| --- | --- | --- | --- |
| 사용 용도 | 앱 내에서 특정 오퍼월 아이템의 상세 화면으로 이동하고자 할 때 사용 | 앱 내부/외부에서 특정 오퍼월 아이템의 상세 화면으로 이동하고자 할 때 사용하며 이 링크는 앱에서만 사용이 가능함 | 실제 운영 중인 https 도메인의 링크로 앱의 상세 화면에 연결할 수 있으며, 앱 내부/외부에서 특정 오퍼월 아이템 상세 화면으로 이동할 수 있음. 앱이 설치되어 있지 않을 경우 웹으로 이동하게 해줌 (다만 매체의 앱이 설치되어 있어야 애디스콥의 무료충전소에 접근이 가능하므로 앱이 설치되어 있지 않는 상황은 고려되지 않음) |
| 장점 | 딥링크, 앱링크와는 다르게 소통 비용이 들지 않음. sdk 버전을 2.1.7.0 이상으로 업데이트만 한다면, 기존의 sdk 함수를 사용하던 방식처럼 오퍼월 상세 페이지 이동 기능을 적용할 수 있음 | 앱의 외부(모바일 웹, 앱)에서 오퍼월 상세 화면으로 바로 이동할 수 있고, 내부 코드에서도 규약된 url를 사용하여 오퍼월 상세 화면로 이동할 수 있음 </br> (다만, 현재로서는 앱이 실행 중인 상태에서만 딥링크가 작동되며, 앱이 구동되지 않은 상태에서 딥링크가 작동되고자 한다면 앱 구동 시점에 애디스콥 이니셜라이징이 완료되어야 함) | 딥링크처럼 매체의 내부 코드로 해당 url를 활용하여 오퍼월 상세 화면으로 이동시킬 수 있음. 또한 매체 앱의 외부(모바일 웹, 앱)에서 링크를 클릭했을 때 오퍼월 상세 화면으로 바로 이동할 수 있도록 하여 확장성 증대를 기대할 수 있음 </br> (다만, 현재로서는 앱이 실행 중인 상태에서만 앱링크가 작동되며, 앱이 구동되지 않은 상태에서 앱링크가 작동되고자 한다면 앱 구동 시점에 애디스콥 이니셜라이징이 완료되어야 함) |
| 단점 | 고정된 광고 아이템의 상세 화면으로만 이동이 가능하므로 확장성이 없음 | 각 앱별로 고유 딥링크를 점유할 수 없으므로, 같은 uri 스킴을 사용할 시에는 충돌이 일어나 앱을 선택하는 창이 뜰 수 있음 </br> (애디스콥측에서 규정한 스킴은 각 매체마다 고유하도록 설계하였으나, 제3의 앱이 해당 딥링크를 사용할 경우 충돌이 일어날 수 있음) | https 사이트 내에 앱을 연결할 수 있도록 하는 association file을 매체에서 제공해야 함. 해당 방법으로 상세페이지 이동 기능을 적용할 시 다른 방법(함수호출, 딥링크)보다 소통 비용이 커짐 |
| 참고 사항 | - | 애디스콥측의 오퍼월 화면에 intent-filter를 적용하였으므로 매체에서 별도로 작업할 사항은 없음 | 매체는 애디스콥측에 json 파일을 제공하고, 애디스콥측의 도메인에 해당 json 파일을 등록함 </br> (매체측에서 운영 중인 도메인에 등록하여 사용할 경우에는 사전에 협의가 필요하고, 애디스콥 SDK측 코드 수정이 필요하므로 권장하지 않음) |
