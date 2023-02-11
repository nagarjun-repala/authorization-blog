# Authorization blog

## Blog: [spring-security-protect-user-specific-resources-using-pre-and-post-authorization](https://nagarjun-repala.medium.com/springboot-security-protect-user-specific-resources-using-pre-and-post-authorization-enabled-a53c984a38cc)
### Prerequisites
Make, Docker, Maven, Java

To run the application follow below commands
```
make sql-init
make run
```

User API
```
Create user - POST: http://localhost:8080/user/register
```
```JSON
{
    "firstName": "test",
    "lastName" : "test",
    "username" : "test",
    "password" : "test",
    "email" : "test@test.com"
}
```
```
Login user - POST: http://localhost:8080/user/login
```
```JSON
{
    "username" : "test",
    "password" : "test"
}
```
