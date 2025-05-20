# Event Booking API

A RESTful backend API built with **Spring Boot** for managing and booking events. Designed for both customers and administrators, this API supports secure user authentication, event searching, booking, and admin-level event management.

---

## Project Context

The company requires a web application backend to manage event bookings. As a junior developer, your responsibility is to build and document this Spring Boot API with full CRUD functionality, authentication (JWT), and secure user handling.

---

##  Features

###  For Clients:
- View homepage events
- Register and log in
- View/update user profile
- Search and filter events (by date, location, category)
- Book an event
- View information about the team (About page)

###  For Admins:
- Dashboard statistics (users, bookings, events)
- Manage users (view/delete)
- Manage events (create, update, delete, details)

---

## Security
- JWT-based authentication
- Role-based access control (ADMIN / USER)
- Spring Security for protected endpoints

---

## Project Structure (MVC + DTO + Mapper)
```
src/
├── controller/ # REST controllers (APIs)
├── service/ # Business logic
├── repository/ # JPA repositories
├── dto/ # Data Transfer Objects
├── entity/ # JPA entities
├── mapper/ # MapStruct mappers
└── config/ # Security configuration
```
## UML Diagrams

### Use Case Diagram
![class Diagram](C:\Users\MAJD\Desktop\ENAA\Event-Booking\uml\DiagramDeClass.png)

### Class Diagram
![Use Case Diagram](C:\Users\MAJD\Desktop\ENAA\Event-Booking\uml\DiagramDeCasDeUtulisation.png)

### Sequence Diagram
![sequence Diagram](C:\Users\MAJD\Desktop\ENAA\Event-Booking\uml\sequenceUML.png)