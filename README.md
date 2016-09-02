# Spring Boot Microservice Demo

Project demonstrates String Boot Microservice architecture.

Modules of project are Spring Boot applications:
* Eureka Discovery Server with Spring Boot Admin UI
* User service implements REST API for user database
* Task service implements REST API for task database
* Report service implements REST API for reports

Report service get data from Task and User services requesting real
service endpoints in Service Discovery.
