# Simple Email Service :email: 
---
To view the whole solution go to the following link
[System Integration assignment 2: ](https://github.com/tobias-z/case-management)

This service will be a part of a process which will be incorporated with Camunda. This excercise is to gain further knowlede about Business Process Management (BPM). 

---

## 1.0 Setup
To run the service simply clone the project and run it. The service has been written in **Java** with the **Spring Boot** framework and has a relational database(**PostgreSQL**) attached.  

There can be made requests to the following two REST endpoints:
- http://localhost:8090/emails/test/message
- http://localhost:8090/emails/message

Furthermore, you will have to type in your own email and password in the resource.properties file which can be found in the resource folder.

```java
spring.mail.username= INSERT YOUR OWN SENDER EMAIL HERE
```

To not upload my passwords I make use of the following commands in the JVM or resource.properties file:
```java
#spring.mail.password= INSERT YOUR EMAIL PASSWORD HERE OR IN THE JVM WITH -Dspring.mail.password=  
#spring.datasource.password= INSERT YOUR POSTGRESS USER PASSWORD HERE OR IN THE JVM WITH -Dspring.datasource.password=   
``` 
  
Lastly go to EmailResource.java and insert the mail you want to receive mails on line 22.  
In the EmailSenderService.java file go to line 33, 47 and 68 to insert the email address of the mail sender.

#### 1.2 Concept  
The whole concept of the service is to be able to receive a user complaint from a user to then be able to generate an email to the customer service for further work and to generate an email for the user to be able to notify them when the company has received their complaint.  


#### 1.3 TODO
*The following are tasks I can incorporate if need be or to practice*  
1. Docker files to setup the environment
2. Test of endpoints with assertions and with Mvc framework
3. Exception handling
4. Incorporate Camunda
5. Reach REST level 3 to make the service fully RESTful

High five :hand: