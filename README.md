# Spring Boot Web App
https://start.spring.io/ : Add following modules - Web, Actuator, JPA, H2, DevTools

POST: When we create an entity we should return HTTP status of 201 (Created). Easy way to do in Spring is to use ResponseEntity.created(location:URI).build(). location:URI could be retrieve using ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

DELETE: When an entity is deleted its a best practice to return HTTP status 204 (No Content) using ResponseEntity.noContent().build().

Exception Handling: Spring by default returns a complex object with error detail whenever an exception happens. If you want to change the object that is returned when an exception is returned you should extend the abstract class ResponseEntityExceptionHandler. The class should be annotated with @ControllerAdvice and @RestController. The method that handles specific error condition should be annotated with @ExceptionHandler(ExceptionClass.class)


### References
- https://martinfowler.com/articles/richardsonMaturityModel.html
- https://spring.io/understanding/HATEOAS
