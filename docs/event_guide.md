## 서드파티 이벤트 제공


### 이벤트 등록

매체 영업팀을 통해 이벤트 아이디와 키값을 발급 받아 사용 합니다.

event_key : 이벤트를 식별하는 고유 키값입니다. 예) 10002501 : 룰렛, 10002502 : 복권, 10002503 : 출석

appid : 이벤트매체 식별용 키값입니다.


### 이벤트 모듈 참조 추가
```groovy
implementation "com.nps.adiscope:adiscopeLuckyEvent:5.1.2"
```


### Method
- 사용자 아이디를 설정합니다.
- void TnkEventBuilder.setUserName(String: userName)

- 이벤트 아이디와 앱아이디를 설정합니다.
- void TnkEventBuilder.setEventIdTnkAppId(eventId: String, pubId: String)

- 이벤트 화면을 표시합니다. (필수)
- void TnkEventBuilder.show(context: Context)


#### sample
```kotlin
TnkEventActivity.TnkEventBuilder()
    .setUserName("tnk_test")
    .setEventIdTnkAppId("25120101","00000000-0000-0000-0000-000000000000")
    .show(this@MainActivity)
```
