# Practice-Amphibians
https://developer.android.com/codelabs/basic-android-kotlin-compose-practice-amphibians-app#0

Practice makes a master.   
This main branch is the main directory.   

there are 5 additional branchs for 1 practice.   
Compose, Compose-Hilt, Compose-Ktor, SwiftUI and SwiftUI-Factory   
   
• [Compose branch](https://github.com/Jaehwa-Noh/Practice-Amphibians/tree/compose-amphibians-app)   
• [Compose-Hilt branch](https://github.com/Jaehwa-Noh/Practice-Amphibians/tree/compose-hilt-amphibians-app)   
• [Compose-Ktor branch](https://github.com/Jaehwa-Noh/Practice-Amphibians/tree/compose-ktor-amphibians-app)   
• [SwiftUI branch](https://github.com/Jaehwa-Noh/Practice-Amphibians/tree/swiftui-amphibians-app)   
• [SwiftUI-Factory branch](https://github.com/Jaehwa-Noh/Practice-Amphibians/tree/swiftui-factory-amphibians-app)   

---

연습이 장인을 만든다.   
이 메인 브랜치는 메인 폴더입니다.

1개의 연습에 5개의 추가적인 브랜치가 있습니다.   
컴포즈, 컴포즈-힐트, 컴포즈-케이토르, 스위프트유아이 그리고 스위프트유아이-펙토리   
   
• [컴포즈 브랜치](https://github.com/Jaehwa-Noh/Practice-Amphibians/tree/compose-amphibians-app)   
• [컴포즈-힐트 브랜치](https://github.com/Jaehwa-Noh/Practice-Amphibians/tree/compose-hilt-amphibians-app)   
• [컴포즈-케이토르 브랜치](https://github.com/Jaehwa-Noh/Practice-Amphibians/tree/compose-ktor-amphibians-app)   
• [스위프트유아이 브랜치](https://github.com/Jaehwa-Noh/Practice-Amphibians/tree/swiftui-amphibians-app)    
• [스위프트유아이-펙토리 브랜치](https://github.com/Jaehwa-Noh/Practice-Amphibians/tree/swiftui-factory-amphibians-app)   


## Amphibians App (양서류 앱)
An app communicates with Server. (서버와 통신하는 앱입니다)   
Take json which have information about Amphibians from server, and shows it to users. (서버로부터 양서류 정보가 담긴 json을 받아 사용자에게 보여줍니다.)

## UI specifications (UI 명세서)
### Full screen (전체 화면)
<img width="300" alt="Full screen of Amphibians app (양서류 앱 전체 화면)" src="https://github.com/Jaehwa-Noh/Practice-Amphibians/assets/48680511/1aad0435-417b-43ae-bad2-24ee9e092fae">

## Network API specifications (네트워크 API 명세서)
### Amphibians API (양서류 API)
|key|data type|
|---|---------|
|name|string|
|type|string|
|description|string|
|img_src|string|

# My Result (내 결과물)
## Apps on device (프로젝트 실행 이미지)
### Compose (컴포즈)
| Loading (로딩) | Error (오류) | Amphibians List (양서류 목록) | Load Image (이미지 불러오기) |
| :-----------: | :----------: | :-------------------------: | :-------------------------: |
| <img width="200" alt="Loading (로딩)" src="https://github.com/Jaehwa-Noh/Practice-Amphibians/assets/48680511/dd69f81a-2a48-4212-a950-2236bb34dd4b"> | <img width="200" alt="Error (오류)" src="https://github.com/Jaehwa-Noh/Practice-Amphibians/assets/48680511/b26cc77b-ad9e-456a-80b0-3e0cd42880df"> | <img width="200" alt="Amphibians List (양서류 목록)" src="https://github.com/Jaehwa-Noh/Practice-Amphibians/assets/48680511/34093b4e-c107-4ef5-b3c3-4497a994bcff"> | <img width="200" alt="Load Image (이미지 불러오기)" src="https://github.com/Jaehwa-Noh/Practice-Amphibians/assets/48680511/f5ab12f0-6a00-43dc-9fc2-b0e6c767a958"> |

### SwiftUI (스위프트유아이)
| Loading (로딩) | Error (오류) | Amphibians List (양서류 목록) | Load Image (이미지 불러오기) |
| :-----------: | :----------: | :-------------------------: | :-------------------------: |
| <img width="200" alt="Loading (로딩)" src="https://github.com/Jaehwa-Noh/Practice-Amphibians/assets/48680511/92a76fa8-746a-4b27-ae35-60c2ec371bc9"> | <img width="200" alt="Error (오류)" src="https://github.com/Jaehwa-Noh/Practice-Amphibians/assets/48680511/53027fac-b401-4f76-819c-28265316d753"> | <img width="200" alt="Amphibians List (양서류 목록)" src="https://github.com/Jaehwa-Noh/Practice-Amphibians/assets/48680511/34d4f507-9cdd-4fda-bcc8-34c386eae7e6"> | <img width="200" alt="Load Image (이미지 불러오기)" src="https://github.com/Jaehwa-Noh/Practice-Amphibians/assets/48680511/e2d53b36-3b31-4d99-ae19-32b0eaa00b3e"> |


## Problem Solve (문제 해결)
### Compose (컴포즈)
#### @HiltViewModel Unit test problem(@HiltViewModel 단위 테스트 문제)
• [@HiltViewModel Unit test problem(@HiltViewModel 단위 테스트 문제)](https://github.com/google/dagger/issues/4212)
