# Spring Boot Microservice Demo

Project demonstrates String Boot Microservice architecture and next patterns
* Discovery Service
* API Gateway

## Modules

| Module           | Description                    | Default Url           |
| ---------------- | ------------------------------ | --------------------- |
| `eureka-server`  | Eureka Discovery Server        | http://localhost:8761 |
| `admin-server`   | Spring Boot Admin Server       | http://localhost:9090 |
| `zuul-server`    | Zuul API Gateway Server        | http://localhost:9000 |
| `user-service`   | User database REST API service | http://localhost:9110 |
| `task-service`   | Task database REST API service | http://localhost:9120 |
| `report-service` | Report REST API service        | http://localhost:9130 |

## Infrastructure modules

### Eureka Discovery Server

Module `eureka-server` implements Discovery Service. This is a very simple
project with the powerfull Eureka library. You can read the documentation at
https://cloud.spring.io/spring-cloud-netflix/ 

### Spring Boot Admin Server

Module `admin-server` implements Admin UI where you can see all running
Spring Boot application of the project. This is also a very simple project.
Read the documentation at https://github.com/codecentric/spring-boot-admin
Admin Server uses Eureka to get the application list.

### Zuul API Gateway Server

Module `zuul-server` imlements API Gateway. This is a simple project again :)
Read the documentation at https://github.com/Netflix/zuul

API Gateway configured to proxy all methods of all microservices modules
of the project. 

| Endpoint              | Microservice     |
| --------------------- | ---------------- |
| `/api/user-service`   | `user-service`   |
| `/api/task-service`   | `user-service`   |
| `/api/report-service` | `report-service` |

## Microservice modules

### User database REST API service

Module `user-service` used to access user database. In-memory H2 database used.
You can use `/console` endpoint to connect database with user `sa` and empty
password.

| Method            | Description         |
| ----------------- | ------------------- |
| `GET /user`       | Get all users       | 
| `GET /user/{key}` | Get one user by key | 

Example of user record
```
{
  "id": 1,
  "key": "DENT",
  "fullName": "Arthur Dent"
}
```

### Task database REST API service

Module `task-service` used to access task database. In-memory H2 database used.
You can use `/console` endpoint to connect database with user `sa` and empty
password.

| Method            | Description         |
| ----------------- | ------------------- |
| `GET /task`       | Get all tasks       | 
| `GET /task/{id}`  | Get one task by id  | 

Example of task record
```
{
  "id": 1,
  "userKey": "DENT",
  "text": "Check if home exists",
  "status": "CLOSED"
}
```

### Report REST API service

Module `report-service` is report service. The only one demo report is 'All task
report'. It lists all tasks and all user information in JSON format.
Service uses method `GET /task` of `task-service` to get all tasks and
`GET /user/{key}` of `user-service` to get uses information.

| Method                 | Description         |
| ---------------------- | ------------------- |
| `GET /report/all-task` | All tasks report    | 

Example of 'All tasks report' data
```
[
  {
    "id": 1,
    "user": {
      "id": 1,
      "key": "DENT",
      "fullName": "Arthur Dent"
    },
    "text": "Check if home exists",
    "status": "CLOSED"
  },
  ...
]
```

## How to build

```
mvn clean package
```

## How to run

Use next command to run any module
```
java -jar {MODULE_NAME}\target\{MODULE-NAME}-{MODULE-VERSION}.jar
```
You can run more then one of each microservices. Use `--server.port={PORT}` to set port.

Use `nohup` to run many modules in one console
```
nohup java -jar {MODULE_NAME}\target\{MODULE-NAME}-{MODULE-VERSION}.jar >/dev/null 2>&1 &
```
and `ps` and `kill` to stop modules
```
ps -fC java
```




```

  
  
  +----------------+                           +------------------+     +------------------+
  |      Zuul      |       service info        |      Eureka      |     |    Spring Boot   |
  |  Api  Gateway  |---------------------------| Discovery Server |-----|   Admin Server   |
  |     Server     |                           |                  |     |                  |
  +----------------+                           +------------------+     +------------------+
           |                                            |||
           | report data                                |||
           |                                            |||
           |                                            |||
  +----------------+                                    |||
  | Report Service |------------------------------------+||
  +----------------+                                     || service &
            | |                                          || registration
            | |                                          || info
            | | task data +----------------+             ||
            | +-----------|  Task Service  |-------------+|
            |             +----------------+              |
            |                      |                      |
            |                 ( Task DB )                 |
            |   user data                        +----------------+
            +------------------------------------|  User Service  |
                                                 +----------------+
                                                          |
                                                     ( User DB )
```
