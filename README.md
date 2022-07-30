# StClaireClinicBackend

## Starting
The project was created using Java 11 and is the backend of StClairClinic FrontEnd project.

## How to use
* Download or clone the repository in your local machine
* Open the project in your preferred IDE
* You can use the application.properties with your preferences or if you decide use default you need to create a schema in your database called saint_claire_clinic 
* In case you decide use another application.properties create the schema in your database, make sure to call exactly the same in your application.properties
* I recommend to use this dialect in your application.properties:
```
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
```
* Finally, run your backend and open the frontend