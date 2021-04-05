참고 : https://sup2is.github.io/2020/03/05/spring-security-login-with-jwt.html

#멤버추가
- curl -H "Content-Type: application/json" -X POST -d '{"email":"test@gmail.com", "password":"1234"}' http://localhost:8080/api/member

#인증
curl -H "Content-Type: application/json" -X POST -d '{"email":"test@gmail.com", "password":"1234"}' http://127.0.0.1:8080/authenticate

#인증된 토큰으로 API 요청
curl -H "Content-Type: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2MTc2MTYzODMsImlhdCI6MTYxNzU5ODM4MywianRpIjoidGVzdEBnbWFpbC5jb20ifQ.NzPl7Ya5DjxCTVINxRVpbeb4Ik8tf1CDC9ONbs-SUzbuRukkb0TtQdUmqS_qtY5jiq0vlZoV_bN8ZFTR4JBMUw" -X GET http://localhost:8080/hello