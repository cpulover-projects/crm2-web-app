# Customer Relationships Management Web Application

## Configuration
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
4. Create Entity classes 
[[Customer]()]
5. Create Repository interfaces extends JpaRepository 
[[CustomerRepository]()]
6. Create Service interfaces 
[[CustomerService]()]
7. Create Service Implementation classes 
[[CustomerServiceRepository]()]
   - Inject Repository (prefer by constructor)
8. Create Controllers 
[[CustomerController]()]
9. Create HTML view pages 
[[list-customers]()]
10. Create index file in ```/static``` to redirect to home page at startup 
[[index.html]()]
    - ```<meta http-equiv="refresh" content="0; URL='<path>'" />```

## Notes/Tips
- Use Model to send model from the Controller to View page and @ModelAttribute to get the model from View page 
[[CustomerController]()]
- Create custom methods in the Repository with 
[Spring Data JPA Query Methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference)


























