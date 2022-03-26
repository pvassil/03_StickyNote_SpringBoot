A small application with Spring Boot
----------------------------------------------
#What it does
It has a <code>StickyController</code> java class mapping the <code>http://localhost:8080</code> path to the page <code>/resources/</code> folder

What the example covers is:
* how to list of all contents of a list in an HTML table via Thymeleaf
* how to add and delete elements via the web (also how to use a form for the addition)
* a very clean and to-the-point architecture of how we handle the combination of SpringApplication, Controllers, Services, Repositories and Models to this end
* a primitive demonstration of parameter passing and the rolw of Thymeleaf
* a very primitive demo of Bootstrap 5 for the adornment of the web pages  

#How to run
* Maven build with goal <code>spring-boot:run</code> to just run it from inside eclipse
* Maven build with goal <code>clean package</code> and then run the .jar produced
* Anyway, goto <code>http://localhost:8080</code> and work with the application

#How to clean up the apache tomcat
Solution: Open dos prompt to kill the process holding 8080

```
C:\Users\pvassil>netstat -ano | findstr :8080
  TCP    0.0.0.0:8080           0.0.0.0:0              LISTENING       13304
  TCP    [::]:8080              [::]:0                 LISTENING       13304

C:\Users\pvassil>taskkill /pid 13304 /f
SUCCESS: The process with PID 13304 has been terminated.
```

See also:
   https://stackoverflow.com/questions/12737293/how-do-i-resolve-the-java-net-bindexception-address-already-in-use-jvm-bind

How to fix the error sign at Eclipse
---------------------------------------
Right click on the project -> Maven -> Update project
   