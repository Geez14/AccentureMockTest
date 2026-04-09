# Changelog

## [Unreleased]
- Initial project setup for Accenture Java Full Stack Pre-Mock Assessment

## [Added]
- Spring Boot backend project structure with layered architecture (Controller, Service, DAO, Entity, Bean)
- RESTful API endpoints for Appointment and Patient management
- Spring Data JPA repositories for Appointment and Patient entities
- DAO Wrapper classes for business logic and entity-bean conversion
- Service layer implementations for Appointment and Patient operations
- Global exception handling with @ExceptionHandler
- Validation using @Valid and BindingResult in controllers
- Integration with MySQL database
- Automatic table creation via JPA configuration
- Test data initialization using `src/test/resources/data.sql` for repeatable test runs
- Integration and unit test skeletons for AppointmentService and PatientService
- Global CORS configuration to allow frontend (localhost:5173) to access backend (localhost:8090)
- Sample SQL schema and data scripts in `src/main/resources/HeathCareDb.sql` and `src/test/resources/data.sql`
- React frontend project structure (Vite, src/components, assets, etc.)

## [Changed]
- Improved controller methods to return proper HTTP status codes and error messages
- Enhanced validation and error handling in REST endpoints
- Refactored method and variable names for clarity and consistency
- Updated application.properties for database and JPA settings

## [Fixed]
- CORS errors between frontend and backend
- Table auto-creation issues by setting `spring.jpa.hibernate.ddl-auto`
- Test data persistence for integration tests

## [Documentation]
- Added inline comments and JavaDoc for all major classes and methods
- Provided setup and usage instructions in README.md

---