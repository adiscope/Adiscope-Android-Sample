# 오퍼월 상세 이동 적용 가이드

## 함수 호출 (showDetail())

github의 overview에 showDetail() 메서드에 관한 설명과 사용 예시를 기술하였으므로 [해당 링크](https://github.com/adiscope/Adiscope-Android-Sample/blob/master/docs/overview.md#overview---offerwalladandroid)에서 참고 부탁드립니다.

</br>

## 딥링크 (custom scheme)

애디스콥측 Manifest에 intent-filter가 적용되어 있으므로 매체 측에서 별도로 설정/구현해야 할 부분은 없습니다. 다만, 매체의 `build.gradle(app)`에 `adiscope_media_id`와 `adiscope_media_secret`이 정확히 기입되어 있는지 확인이 필요합니다.

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

</br></br>

## 기능별 장단점 요약
|  | showDetail() | 딥링크
| --- | --- | --- |
| 장점 | 딥링크, 앱링크와는 다르게 소통 비용이 들지 않음. sdk 버전을 2.1.7.0 이상으로 업데이트만 한다면, 기존의 sdk 함수를 사용하던 방식처럼 오퍼월 상세 페이지 이동 기능을 적용할 수 있음 | 앱의 외부(모바일 웹, 앱)에서 오퍼월 상세 화면으로 바로 이동할 수 있고, 내부 코드에서도 규약된 url를 사용하여 오퍼월 상세 화면로 이동할 수 있음 </br> (다만, 현재로서는 앱이 실행 중인 상태에서만 딥링크가 작동되며, 앱이 구동되지 않은 상태에서 딥링크가 작동되고자 한다면 앱 구동 시점에 애디스콥 이니셜라이징이 완료되어야 함) |
| 사용 용도 | 앱 내에서 특정 오퍼월 아이템의 상세 화면으로 이동하고자 할 때 사용 | 앱 내부/외부에서 특정 오퍼월 아이템의 상세 화면으로 이동하고자 할 때 사용하며 이 링크는 앱에서만 사용이 가능함 |
| 단점 | 고정된 광고 아이템의 상세 화면으로만 이동이 가능하므로 확장성이 없음 | 각 앱별로 고유 딥링크를 점유할 수 없으므로, 같은 uri 스킴을 사용할 시에는 충돌이 일어나 앱을 선택하는 창이 뜰 수 있음 </br> (애디스콥측에서 규정한 스킴은 각 매체마다 고유하도록 설계하였으나, 제3의 앱이 해당 딥링크를 사용할 경우 충돌이 일어날 수 있음) |
| 참고 사항 | - | 애디스콥측의 오퍼월 화면에 intent-filter를 적용하였으므로 매체에서 별도로 작업할 사항은 없음 |