Simple application - RESTful service.

Start com.ds.sample.Application to start the service.

Use the following endpoints to manage user data storage:

http://localhost:8080/list
    to list content of the storage

http://localhost:8080/create?name=<user's first name>&surname=<user's last name>&email=<user's e-mail address>
    to create a new user
    e.g. http://localhost:8080/create?name=Andrew&surname=Smith&email=something

http://localhost:8080/update?id=<user id>&name=<new name>&email=<new e-mail address>
    to update an existing user
    e.g. http://localhost:8080/update?id=1&name=Dmitry&surname=Wesson&email=changed

http://localhost:8080/delete?id=<user id>
    to delete existing user
    e.g. http://localhost:8080/delete?id=1
