Schedule suggesting application - Java
===============

Description
-----

The goal of our capstone project was to create a user friendly application and design a recommendation algorithm which will make it easier for AUA students to create a schedule for the next semester that fulfills both program requirements and their time/day preferences. 
  
Setup up DB
-----

  ```  
  $ export PATH=$PATH:/usr/local/mysql/bin
  
  $ sudo mysql -p
  
  $ create database schedule_app;
  ```
  
Run project
----- 
  ````
  $ mvn spring-boot:run
  
  ````
  
Recreate DB:
----- 

  ````
  $ mvn flyway:clean
  
  $ mvn flyway:repair
  
  $ mvn spring-boot:run
  
  ````
