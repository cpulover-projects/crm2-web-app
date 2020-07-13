# Customer Relationships Management Web Application

## Configuration
### Spring Boot
Configuration with dependencies 
[[Reference]()]
- Spring Web
- Thymeleaf
- MySQL Driver
- Spring Data JPA
- Spring Security
- Thymeleaf entries for Spring Security 
[[URL](https://search.maven.org/classic/#search%7Cga%7C1%7Ca%3A%22thymeleaf-extras-springsecurity5%22)]
- Spring Boot DevTools (Optional)
- Lombok (Optional)

### Database
1. Create MySQL database for Entity
[[create-datebase-customer.sql]()]
2. Create MySQL database for Security
[[create-datebase-security.sql]()] 
[[Reference]()]
3. Configure database connection (JDBC) in 
[application.properties]()
4. Configure data sources by Java (manually for multiple data sources)
[[DataSourceConfig]()]

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
   - XML namespace ```<html lang="en" xmlns:th="http://www.thymeleaf.org">``` supports Thymeleaf.
3. Create index file in ```/static``` to redirect to home page at startup (unnecessary if adding Security)
[[index.html]()]
    - ```<meta http-equiv="refresh" content="0; URL='<path>'" />```

### Spring AOP
1. Create an Aspect defining public common pointcuts 
[[CommonPointcuts]()]
2. Create specialized Aspects and define advices
[[LoggingAspect]()]

### Spring Security
1. Configure Security by Java 
[[SecurityConfig]()] 
[[Reference]()]
2. Update HTML view pages
[[list-customers]()]
   - XML namespace ```<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity5">``` supports Thymeleaf Security.
   - Attribute ```sec:authorize="hasAnyRole('ROLE_<ROLE1>', 'ROLE_<ROLE2>')"``` to display tags based on the role.

### Spring Data REST


## Notes/Tips
- Use Model to send model from the Controller to View page and @ModelAttribute to get the model from View page 
[[CustomerController]()]
- Create custom methods in the Repository with 
[Spring Data JPA Query Methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference)
- Add hidden ID field for UPDATE 
[[customer-form]()]
- Spring MVC only support @GetMapping and @PostMapping
























