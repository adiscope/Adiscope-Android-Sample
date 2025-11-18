# 전면/리워드 광고 연동 작업 간소화 기능
비디오 광고 지면 추가를 쉽게 작업할 수 있도록 지원하는 모듈과 샘플 코드입니다.

## 목차

* [적용 방법](#적용-방법)
  * [adiscopeWalnut 모듈 추가](#1-adiscopewalnut-모듈-의존성-추가)
  * [샘플코드 다운로드 및 적용](#2-샘플-코드-다운로드-및-적용)
* [제공 코드 부가설명](#제공-코드-부가설명)
  * [주요 컴포넌트](#주요-컴포넌트)
    * [ViewModel](#1-viewmodel)
    * [Delegate](#2-adiscopedelegate)
    * [AdListener](#3-adlistener)
  * [필수 설정값](#필수-설정값)
    * [userId](#userid)
    * [childYN](#childyn)
  * [주요 기능](#주요-기능-1)
    * [SDK 초기화](#1-sdk-초기화)
    * [로드 상태 감지](#2-로드-상태-감지)
    * [뷰모델 옵저빙](#3-viewmodel-옵저빙)
    * [로딩 다이얼로그 설정](#4-로딩-다이얼로그-설정)
    * [광고 다이얼로그 설정](#5-광고-다이얼로그-설정)
  * [광고 로드 및 표시 방법](#광고-로드-및-표시-방법)
  * [런타임 계정 변경 처리](#런타임-계정-변경-처리)

<br></br>

## 적용 방법

### 1. adiscopeWalnut 모듈 의존성 추가
adiscope SDK가 연동되어 있는 앱 모듈의 **build.gradle** 디펜던시 블록에 아래 의존성을 추가합니다.

```groovy
// [optional] adiscope simplified integration library
implementation 'com.nps.adiscope:adiscopeWalnut:1.0.0'
```

<br></br>

### 2. 샘플 코드 다운로드 및 적용
아래 코드를 프로젝트에 추가해줍니다.
샘플 코드 주석과 IDE 내 kdoc, 하단의 문서 설명을 참고하여 필요시 추가 작업 혹은 커스터마이징하실 수 있습니다.
- [ExAdiscopeActivity](../ex/ExAdiscopeActivity.kt)  
- [ExAdiscopeViewModel](../ex/ExAdiscopeViewModel.kt)

<br></br>

#### 주요 기능
1. `AdiscopeDelegate`를 통해 복잡한 광고 로직을 간단하게 사용
2. `VAdAdiscopeViewModelImpl`과 `VAdAdiscopeDelegate`가 광고 상태를 자동으로 관리
3. 리스너, 다이얼로그, UI 등을 쉽게 커스터마이징 가능
4. 광고 로딩 상태에 따른 UI 업데이트 자동화

<br></br>

## 제공 코드 부가설명

### 주요 컴포넌트

#### 1. ViewModel
```kotlin
val viewModel: ExAdiscopeViewModel by viewModels()
```
- 광고 관련 비즈니스 로직 처리해주는 뷰모델
- ViewModel lifecycle이 자동으로 관리됨
- 필요 시 메서드를 오버라이드하여 커스터마이징 가능

<br></br>

#### 2. AdiscopeDelegate
```kotlin
val adiscopeDelegate by lazy {
    VAdAdiscopeDelegate(this, this, viewModel, listener)
}
```
- Activity와 ViewModel 사이의 비디오 광고 이벤트의 상호작용을 처리

<br></br>

#### 3. AdListener
```kotlin
val listener = object : VAdAdiscopeAdListener {}
```
- 광고 이벤트 콜백을 받을 수 있는 리스너
- 다음과 같이 필요한 함수만 오버라이딩하여 커스터마이징할 수 있음
```kotlin
 val listener = object : VAdAdiscopeAdListener {
        override fun onRewarded(
            adType: String,
            unitId: String,
            rewardType: String,
            amount: Long
        ) {
            // 리워드 지급 처리에 대한 별도 로직
        }
    }
```

<br></br>

### 필수 설정값

#### userId
```kotlin
val userId: String by lazy { "test_user" }
```
- 유저를 식별할 수 있는 값
- 리워드 지급을 위해 필수적으로 설정 필요
- 애디스콥 이니셜라이즈 후 런타임 중 계정 변경 발생 시 아이디 재설정 필요
  - `AdiscopeSdk.setUserId(userId)`

<br></br>

#### childYN
```kotlin
val childYN: String by lazy { "NO" }
```
- 만 13세 미만 어린이 여부 설정으로 앱의 타겟 연령에 맞게 정확히 설정
  - `YES`: 만 13세 미만
  - `NO`: 만 13세 이상
- 만 13세 미만 앱에서 `childYN` 미설정시 제한된 네트워크 물량만 노출됨
- 애디스콥 이니셜라이즈 후 런타임 중 계정 변경 발생 시 `childYN` 재설정 필요
  - `AdiscopeSdk.getOptionSetterInstance(activity).setChildYN(childYN)`

<br></br>

### 주요 기능

#### 1. SDK 초기화
- 이니셜라이즈와 함께 유저아이디, 어린이여부를 설정해줍니다.
- `mediaId`, `mediaSecret`은 각각 앱 모듈 > build.gradle > `manifestPlaceholders`에 매핑된 key-value를 SDK에서 읽어와 이니셜라이즈합니다. ([참고 가이드](../README_Kotlin.md#b-adiscopesdkinitializeactivity-listener))
  - mediaId: `adiscope_media_id`
  - mediaSecret: `adiscope_media_secret`
```kotlin
viewModel.initAdiscopeSdk(this, userId, childYN) { isSuccess ->
    if (isSuccess) {
        // 광고 SDK 초기화 성공
    } else {
        // 광고 SDK 초기화 실패 처리
    }
}
```

<br></br>

#### 2. 로드 상태 감지
- 광고 로드 상태 변경 콜백을 설정합니다.
- 광고 로드 상태에 따라 UI를 업데이트 등의 코드를 필요 시에 작업하시면 됩니다.
```kotlin
adiscopeDelegate.setOnLoadStateChanged { adType, unitId, state ->
    // UI 변경 혹은 비즈니스 로직 처리
    if (adType == AdType.INTERSTITIAL) {
        btnShow.text = when (state) {
            AdLoadState.LOADING -> "..."
            else -> "광고 보기"
        }
    }
}
```

<br></br>

#### 3. ViewModel 옵저빙
- ViewModel의 광고 이벤트 및 설정값의 변경을 관찰하여 자동으로 UI를 업데이트하도록 지원합니다.
```kotlin
adiscopeDelegate.observeViewModel()
```

<br></br>

#### 4. 로딩 다이얼로그 설정
- `viewModel.showRV` 혹은 `viewModel.showInterstitial`이 호출될 때 표시할 로딩 다이얼로그를 설정합니다.
- 파라미터에 아무것도 포함하지 않을 경우 애디스콥에서 제공하는 로딩 다이얼로그가 설정됩니다.
- `Dialog`를 상속받은 다이얼로그를 파라미터에 담아 호출하시면 커스텀 다이얼로그가 설정됩니다.
- 다이얼로그 백그라운드 색상은 다크모드를 지원하고 있습니다.
```kotlin
// 기본 다이얼로그 사용
adiscopeDelegate.setLoadingDialog()

// 커스텀 다이얼로그 사용
// adiscopeDelegate.setLoadingDialog(CustomLoadingDialog())
```

<br></br>

#### 5. 광고 다이얼로그 설정
- `viewModel.showRV` 혹은 `viewModel.showInterstitial`을 호출하여 에러 발생 및 리워드 지급 시 노출할 애디스콥 기본 다이얼로그의 설정값을 적용합니다.
- 다이얼로그 백그라운드 색상은 다크모드를 지원하고 있습니다.
```kotlin
viewModel.applyDialogConfig {
  setVisible(true)
  setButtonColor(BUTTON_COLOR.toColorInt())
  setTitleColor(TITLE_COLOR.toColorInt())
  setMessageColor(MESSAGE_COLOR.toColorInt())
  setAutoShow()
  setAutoRewardOnInterClosed(rewardType = "팝콘", amount = 100)
  setOnClick {
    // 버튼 클릭 시 동작
  }
}
```

<br></br>

### 광고 로드 및 표시 방법

#### A) 미리 로드 후 표시 (권장)
- 이니셜라이즈 성공 시 load 함수를 호출하여 미리 로드하는 것을 권장하고 있습니다.
- 광고 재생 버튼 클릭과 동시에 이니셜라이즈 및 로드를 호출할 경우 네트워크 물량 및 기기 환경에 따라 로드 시간이 오래 걸릴 수 있습니다.
- show 함수에 unitId를 지정하지 않으면 가장 최신으로 로드한 유닛의 광고를 송출합니다.
  - 로드 성공 여부에 따라 바로 광고 송출 혹은 load-show가 수행됩니다.
```kotlin
// 미리 로드만 실행
viewModel.loadRV(RV_UNIT_ID)
viewModel.loadInterstitial(INTER_UNIT_ID)

// 나중에 원하는 시점에 표시
viewModel.showRV()  // unitId 없이 호출
viewModel.showInterstitial()
```

<br></br>

#### B) 즉시 로드하고 표시
- show 함수 파라미터에 유닛을 지정합니다.
- 로드 성공 여부에 따라 바로 광고 송출 혹은 load-show가 수행됩니다.
```kotlin
// 로드되어 있으면 바로 표시, 없으면 로드 후 자동 표시
viewModel.showRV(RV_UNIT_ID)
viewModel.showInterstitial(INTER_UNIT_ID)
```

<br></br>

### 런타임 계정 변경 처리
- 애디스콥 이니셜라이즈 후 런타임 중 계정 변경이 발생하면 아래 함수로 `userId`, `childYN`을 재설정해야 합니다.
  - ex. 유저가 로그아웃 후 다른 계정으로 로그인할 때
- 유저에게 원활한 네트워크 물량 공급 및 리워드 지급을 위해 정확히 설정해주셔야 합니다. 
```kotlin
// 계정 변경 시 userId, childYN 재설정
AdiscopeSdk.setUserId(userId)
AdiscopeSdk.getOptionSetterInstance(activity).setChildYN(childYN)
```