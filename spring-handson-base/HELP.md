#1 Create 


https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.3.2&packaging=jar&jvmVersion=17&groupId=com.dhyancc&artifactId=spring-handson-base&name=spring-handson-base&description=Demo%20project%20for%20Spring%20Boot&packageName=com.dhyancc.handson&dependencies=lombok,web,data-jpa,postgresql
-------
#2 Download and Setup


Download and extract the project, import it into eclipse
-------
#3 Setup datasource

Add the following to your application.properties

	spring.datasource.url=jdbc:postgresql://localhost:5432/dhyancc
	spring.datasource.username=dhyancc
	spring.datasource.password=dhyancc
	spring.datasource.driverClassName=org.postgresql.Driver
	spring.jpa.hibernate.ddl-auto = create


When you specify ddl-auto, the saved data will be reset after each restart. Specifying the value as update will retain the values.
-------
#4 Run

Run the following from your project path on your console (make sure you are on the same path as that of pom.xml)

mvn spring-boot:run

Your springboot applicaiton must get started

-------
#5 Copy JPA entities

Copy the Java classes available in the namespace com.dhyancc.handson.datamodel into your project, with the same namespace

-------
#6 Run Again

Run the following from your project path on your console (make sure you are on the same path as that of pom.xml)

mvn spring-boot:run

Your springboot applicaiton must get started

Now you must see the tables for your java classes in the database

------
#7 Data model init

Copy the class com.dhyancc.handson.init.DBInit into your project, also copy all repo classes avaialble in com.dhyancc.handson.repo into your project

-------
#8 Run Again

Run the following from your project path on your console (make sure you are on the same path as that of pom.xml)

mvn spring-boot:run

Your springboot applicaiton must get started

Now you must see the tables for your java classes in the database, you will also have values in your tables this time. Read the steps in DBInit class to understand what happened.

-------
#9 Copy service and rest api code

Copy the service and REST Api code from the namespaces com.dhyancc.handson.rest and com.dhyancc.handson.service into your project. Remember what was dicused in teh session, what each layer is for? Also read about the annotations used there.

-------
#10 Run Again

Run the following from your project path on your console (make sure you are on the same path as that of pom.xml)

mvn spring-boot:run

Your springboot applicaiton must get started

-------
#11 Run REST API

curl  -X GET localhost:8080/api/angular/student-management/students

See the response

you can specify -v to look into the headers sent

curl -v  -X GET localhost:8080/api/angular/student-management/students
-------
#12 Move security classes


		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		
Move classes from com.dhyancc.handson.security into your project
		
-------
#13 Run again (Same steps as 10)
------
#14 Run REST API

Try

curl -v  -X GET localhost:8080/api/angular/student-management/students

You will notice that this retuned 401, read about 401 HTTP status on the web.

Now try with 

curl -v -u 'user2:user2' -X GET localhost:8080/api/angular/student-management/students

When you do that, notice the logs that get printed on your server log (the console that you ran mvn spring-boot:run)

------

#15 Auditlog
Copy all classes from com.dhyancc.handson.audit into your project
-------
#16 Run again (Same steps as 10)

