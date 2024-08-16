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
	spring.jpa.hibernate.ddl-auto = update

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

Copy the class DBInit into your project, also copy all repo classes avaialble in com.dhyancc.handson.repo into your project

-------
#8 Run Again

Run the following from your project path on your console (make sure you are on the same path as that of pom.xml)

mvn spring-boot:run

Your springboot applicaiton must get started

Now you must see the tables for your java classes in the database, you will also have values in your tables this time. Read the steps in DBInit class to understand what happened.
