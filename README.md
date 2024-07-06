# spring-ai-ollama-chat example

spring ai ollama를 이용해서 qwen2 모델을 테스트 해 봅니다.
모델을 변경하고 싶은 경우 application.yaml 에서 model 을 qwen2 -> llama3 로 변경해 주면 됩니다.

프로젝트 버전 정보
* Spring AI 1.0.0-M1
* Spring Boot 3.3.1
* Kotlin 1.9.24
* Gradle 7.3.3

## 구동
구동
```
./gradlew bootRun
```

## 테스트
httpie
```
http GET 'http://localhost:8080/ollama?name=홍길동'
{"response":"안녕하세요, 홍길동님! 어떻게 도와드릴까요?"}
```

curl
```
curl 'http://localhost:8080/ollama?name=%ED%99%8D%EA%B8%B8%EB%8F%99'
```
