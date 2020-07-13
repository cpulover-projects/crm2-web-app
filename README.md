# Customer Relationships Management Web Application

## Configuration
### Spring Boot
1. Spring Boot configuration with dependencies 
[[Reference]()]
   - Spring Web
   - Thymeleaf
   - MySQL Driver
   - Spring Data JPA
   - Spring Boot DevTools (Optional)
   - Lombok (Optional)
2. Create MySQL database 
[[create-datebase.sql]()]
3. Configure database connection (JDBC) in 
[application.properties]()

### Spring Data JPA
1. Create Entity classes 
[[Customer]()]
2. Create Repository interfaces extends JpaRepository 
[[CustomerRepository]()]
3. Create Service interfaces 
[[CustomerService]()]
4. Create Service Implementation classes 
[[CustomerServiceRepository]()]
   - Inject Repository (prefer by constructor)
   
### Spring MVC - Thymeleaf
1. Create Controllers 
[[CustomerController]()]
2. Create HTML view pages 
[[list-customers]()]
3. Create index file in ```/static``` to redirect to home page at startup 
[[index.html]()]
    - ```<meta http-equiv="refresh" content="0; URL='<path>'" />```

### Spring AOP
1. Create an Aspect defining public common pointcuts 
[[CommonPointcuts]()]
2. Create specialized Aspects and define advices
[[LoggingAspect]()]

### Spring Security

### Spring Data REST


## Notes/Tips
- Use Model to send model from the Controller to View page and @ModelAttribute to get the model from View page 
[[CustomerController]()]
- Create custom methods in the Repository with 
[Spring Data JPA Query Methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference)
- Add hidden ID field for UPDATE 
[[customer-form]()]
- Spring MVC only support @GetMapping and @PostMapping
























