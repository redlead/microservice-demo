# Spring Boot Microservice Demo

Project demonstrates String Boot Microservice architecture.

## Modules

| Module         | Description                    | Default Url           |
| -------------- | ------------------------------ | --------------------- |
| eureka-server  | Eureka Discovery Server        | http://localhost:8761 |
| admin-server   | Spring Boot Admin Server       | http://localhost:9090 |
| zuul-server    | Zuul API Gateway Server        | http://localhost:9000 |
| user-service   | User database REST API service | http://localhost:9110 |
| task-service   | Task database REST API service | http://localhost:9120 |
| report-service | Report REST API service        | http://localhost:9130 |


Report service get data from Task and User services requesting real
service endpoints in Service Discovery.



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
