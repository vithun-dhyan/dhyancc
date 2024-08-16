Note: Please create a postgres DB with name dhyancc, username dhyancc and password dhyancc before you proceed with this exercise.

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

Login is handled by MyUserDetailsService


------
#15 Auditlog

Copy all classes from com.dhyancc.handson.audit into your project

-------
#16 Run again (Same steps as 10)
 
 
 Try creating a new random user by invoking the URL
 curl -v  -u 'user2:user2' -X POST localhost:8080/api/angular/student-management/create-random-student 
 
 Check the records in the table 
 
 select * from auditlog
 
 The first few entries got created for the default records
 
 The last one got created for your request, notice that the username got tracked.. Review the code in AuditLogAspect to understand how this works
 
 Note: the current logged in user can be got usign the method Authentication auth = SecurityContextHolder.getContext().getAuthentication();

Read about Aspects in SpringBoot, this deals with intercepting method calls




=======================================
#Few more things

#A
Try executing 

	curl -v -u 'user2:user2' -X PUT localhost:8080/api/angular/student-management/students/1 --data '{
	"id": 1,
	"name": "StudentA",
	"age": 10,
	"gender": "MALE",
	"address": "123 Address11111"
	}' -H 'Content-Type: application/json'

THis is to update the user, see how that works
Also try to create or delete  a user
------------------
#B 

Similar to Student, Exam, and those entities in the namespace com.dhyancc.handson.datamodel, we have a couple of entities in the namespace com.dhyancc.handson.security, namely Role and UserAccount.. Notice that this has ManyToMany relationship. Try to understand how this relationship is maintained in the database, notice that a table "user_account_roles" got created in the database eventhough you never created an entity with that name.

-----------------

#C

In MyUserDetailsService.java.. try to understand what the below expression does (try to learn about Java streams.

u.getRoles().stream().map(role -> 
		new SimpleGrantedAuthority(role.getRole())
	)
	.collect(Collectors.toList())

------------------
#D

Try executing the below query

curl -v -u 'user2:user2' -X PUT localhost:8080/api/angular/student-management/students/1 --data '{
"id": 2,
"name": "StudentA",
"age": 10,
"gender": "MALE",
"address": "123 Address11111"
}' -H 'Content-Type: application/json'



It must fail, thats becasuse the IDs in teh path and the JSON are differnt (1 and 2).. see how we used a custom exception to throw the status code as 422.  IDUpdateException class has an annotaiton about what status code must be sent if this error happens.

		if (studentToUpdate.getId() != null && !studentToUpdate.getId().equals(id)) {
			throw new IDUpdateException();
		}


