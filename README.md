## 실행
docker-compose up -d

## stomp 원리 (단점 : 브로커(웹소켓)이 서부 내부에 있어서 서버 확장에 불리)
- 웹소켓 연결(핸드셰이킹)
- 구독하기 (stomp)
- 출판하기 (stomp)

## kafka + stomp 연동 원리 (장점 : 브로커(kafka)가 서부 외부에 있음)
- 웹소켓 연결(핸드셰이킹)
- 구독하기 (stomp)
- kafka 컨트롤러 호출 -> kafka producer 호출 -> 토픽을 구독하는 애들에게 전송 -> consumer는 stomp.converAndSend 호출