# Helper notes
## Beans:
- #### @Component:
The most generic stereotype; suitable for any Spring-managed bean. Utility classes that don’t belong to a specific layer, 
like processors, validators, or transformers.
- #### @Service:
Specialized stereotype for beans containing business logic or service functions. Business logic components, 
interacting between controllers and repositories.
- #### @Controller:
Class handles HTTP requests. Specialized stereotype for front-end-facing beans. Controllers defining REST or UI endpoints.
- #### @Repository
Specialized annotation for persistence layer beans. Components interacting directly with the database 
(like Spring Data JPA repositories).

## Spring Scopes:
- #### Singleton
Single, shared instance for the entire application context.
- #### Prototype
New instance created every time the bean is requested.
- #### Request
New instance per HTTP request, destroyed after the request lifecycle ends.
- #### Session
New instance per HTTP session, tied to individual user sessions.
- #### Application
Single instance shared across the entire web application (ServletContext).
- #### Websocket
New instance per WebSocket session, destroyed when the session ends.
        