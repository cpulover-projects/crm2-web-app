# Customer Relationships Management Web Application - RESTful API (Spring Boot)

## Features
### General
- Database integration
- AOP Logging support


### CRUD UI/URLs
- ```/customer/list```: shows list of customers
- ```/customer/showFormForAdd```: shows form for adding new customer
- ```/customer/showFormForUpdate```: shows form for modify existing customer
- ```/customer/delete/{id}```: deletes customer by id

### CRUD RESTful APIs
- GET ```/api/customers```: returns list of customers
- GET ```/api/customers/{id}```: returns customer by id
- GET ```/api/customers?page={number}```: returns list of customers at page number
- GET ```/api/customers?sort=lastName```: returns list of customers, ascending sort by last name
- GET ```/api/customers?sort=firstName,desc```: returns list of customers, descending sort by first name
- POST ```/api/customers```: adds new customer
- PUT ```/api/customers/{id}```: modifies customer by id
- DELTE ```/api/customers/{id}```: deletes customer by id
- GET Actuator APIs 
[[List of built-in endpoints](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html)]
---

## Development Process
### Spring Boot
Configuration with dependencies 
[[Reference]()]
- Spring Web
- Thymeleaf
- MySQL Driver
- Spring Boot Actuator
- Spring Data JPA
- Rest Repositories (Spring Data REST)
- Spring Security
- Thymeleaf entries for Spring Security 
[[URL](https://search.maven.org/classic/#search%7Cga%7C1%7Ca%3A%22thymeleaf-extras-springsecurity5%22)]
- Spring Boot DevTools (Optional)
- Lombok (Optional)

### Hibernate - Database
1. Create MySQL database for Entity
[[create-datebase-customer.sql]()]
2. Create MySQL database for Security
[[create-datebase-security.sql]()] 
[[Reference]()]
3. Configure database connection (JDBC) in 
[application.properties]()
4. Configure data sources by Java (unnecessary if single data source)
[[DataSourceConfig]()]
5. Create Entity classes 
[[Customer]()]

### Spring Data JPA
1. Create Repository interfaces extends JpaRepository 
[[CustomerRepository]()]
   - Define custom methods in the Repository with 
[Spring Data JPA Query Methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference)
2. Create Service interfaces 
[[CustomerService]()]
3. Create Service Implementation classes 
[[CustomerServiceRepository]()]
   - Inject Repository (prefer by constructor)

### Spring Data REST
Configure in 
[application.properties]() 
[[Reference]()]

### Spring Boot Actuator
Configure in 
[application.properties]() 
[[Reference]()]
   
### Spring MVC - Thymeleaf
1. Create Controllers 
[[CustomerController]()]
2. Create HTML view pages 
[[list-customers.html]()]
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
2. Login page 
[[fancy-login.html]()]
3. Custom Access Denied page 
[[access-denied.html]()]
4. Update HTML view pages
[[list-customers.html]()]
   - XML namespace ```<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity5">``` supports Thymeleaf Security.
   - Attribute ```sec:authorize="hasAnyRole('ROLE_<ROLE1>', 'ROLE_<ROLE2>')"``` to display tags based on the role.

---

## Notes/Tips
- Use Model to send model from the Controller to View page and @ModelAttribute to get the model from View page 
[[CustomerController]()]
- Add hidden ID field for UPDATE 
[[customer-form.html]()]
- Spring MVC only support @GetMapping and @PostMapping
























