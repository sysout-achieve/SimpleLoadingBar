# SimpleLoadingBar
# 간편 로딩바 구현 라이브러리 (안드로이드 java)

[![](https://jitpack.io/v/sysout-achieve/SimpleLoadingBar.svg)](https://jitpack.io/#sysout-achieve/SimpleLoadingBar)


프로젝트의 gradle에 추가 :

```
gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
앱 gradle에 추가 :

```
dependencies {  
    implementation 'com.github.sysout-achieve:SimpleLoadingBar:v1.0.2'
}
```

<hr>

## 사용법

로딩바 on
```
 LoadingBar.init().on(Activity myActivity);
```

로딩바 off
```
 LoadingBar.init().off();
```

## options
```
    private BackBrightness backBrightness;    // 로딩바 뒤 배경화면 밝기 설정 (DIM, KEEP_SCREEN_ON 두 가지)
    private int color;                        // 색상설정 가능 ex) Color.parseColor("#색상")
    private boolean isCancelable;             // 화면 클릭으로 로딩바 멈춤 가능 여부
```

example : option setting
```
LoadingBar.init()
  .color(Color.parseColor("#067a77"))
  .backBrightness(LoadingBarOption.BackBrightness.DIM)
  .isCancelable(true)
  .on(MainActivity.this);
``` 


앱 실행 중 마지막으로 설정한 options 데이터가 저장되며 LoadingBar.init().on()만으로 같은 옵션으로 설정된 LoadingBar를 화면에 출력합니다.

LoadingBar는 거의 모든 프로젝트마다 만들어야하는데 매번 로딩바를 생성, 관리해야하는 번거로움을 해소하기 위해 만들게 되었습니다.

간단한 앱에 로딩바가 필요할 경우 간결하게 추가하여 사용할 수 있습니다.
