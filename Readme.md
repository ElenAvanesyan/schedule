Schedule suggesting application - Java
===============

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
