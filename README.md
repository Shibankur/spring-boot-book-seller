# Spring Boot Book Seller App
### End-Points
#### sign-In
```
POST /api/authentication/sign-in HTTP/1.1
Host: localhost:8080
username: user
Content-Type: application/json
Content-Length: 55

{
"username" : "user",
"password" : "user"
}
```
#### sign-up
```
POST /api/authentication/sign-up HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 75

{
"name" : "user",
"username": "user",
"password": "user"
}
```
#### api/internal/make-admin/admin
```
PUT /api/internal/make-admin/admin HTTP/1.1
Host: localhost:8080
Authorization: Bearer InternalApiKey1234!
```

#### api/book
```
POST /api/book HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoiUk9MRV9BRE1JTiIsInVzZXJJZCI6MywiZXhwIjoxNjk2NDQ1ODM3fQ.yyTj92utfkHBm9oySKmY5qjHRdjv63a4QbXXRospNNLYsGIxA-JUdbB0I-y6Z8nRKKLPIuia7SVS_QQi9btPig
Content-Length: 122

{
    "title" : "Test Book",
    "price" : 20,
    "description" : "Test Description",
    "author" : "Test Author"
}
```

#### api/book/2
```
DELETE /api/book/2 HTTP/1.1
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoiUk9MRV9BRE1JTiIsInVzZXJJZCI6MywiZXhwIjoxNjk2NDQ1ODM3fQ.yyTj92utfkHBm9oySKmY5qjHRdjv63a4QbXXRospNNLYsGIxA-JUdbB0I-y6Z8nRKKLPIuia7SVS_QQi9btPig
```
#### api/book
```
GET /api/book HTTP/1.1
Host: localhost:8080
```

#### api/purchase-history
```
POST /api/purchase-history HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoiUk9MRV9BRE1JTiIsInVzZXJJZCI6MywiZXhwIjoxNjk2NDQ1ODM3fQ.yyTj92utfkHBm9oySKmY5qjHRdjv63a4QbXXRospNNLYsGIxA-JUdbB0I-y6Z8nRKKLPIuia7SVS_QQi9btPig
Content-Length: 60

{
    "userId" : 3,
    "bookId" : 1,
    "price" : 10
}
```

#### api/purchase-history

```
GET /api/purchase-history HTTP/1.1
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoiUk9MRV9BRE1JTiIsInVzZXJJZCI6MywiZXhwIjoxNjk2NDQ1ODM3fQ.yyTj92utfkHBm9oySKmY5qjHRdjv63a4QbXXRospNNLYsGIxA-JUdbB0I-y6Z8nRKKLPIuia7SVS_QQi9btPig
```