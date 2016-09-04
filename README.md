# Spring Boot Microservice Demo

Project demonstrates String Boot Microservice architecture.

Modules of project are Spring Boot applications:
* Eureka Discovery Server with Spring Boot Admin UI
* User service implements REST API for user database
* Task service implements REST API for task database
* Report service implements REST API for reports

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
