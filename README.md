## Note for the reviewer
I will be very grateful if you write to me what needs to be fixed here. So that I can improve my skill.
https://www.linkedin.com/in/ivan-kovalchuk-7740a511a/

## Before running Locally

Сreate a schema and tables. The script is located in the resources folder.

### Used technologies

- Spring Boot
- Spring Security
- Spring jdbctemplate
- JWT

# API

#### The project was deployed to heroku
https://nameless-falls-13226.herokuapp.com/

All requests you can send to this server


 ### - User endpoint:   
 - #### registration 
 /api/user/signup
 
 POST requests with body: 
```json
{
    "username": "soddd",
    "firstName": "firstName",
    "lastName": "lastName",
    "email": "emaishlwws@gmail.com",
    "password": "password"
}
```
 - #### Login 
 /login
 
 POST requests with body: 
```json
{
    "username": "soddd",
    "password": "password"
}
```
A token will come from the server. He is in Header. 
Token example:
`Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzb21lbmFtZSIsImF1dGhvcml0aWVzIjpbXSwiaWF0IjoxNTkzNDI1MTUzLCJleHAiOjE1OTQyNTI4MDB9.S_5V7B_nifFs186v0Zo8lI4dupL-CvoN368hKJPYdtf_G4ANObbdW1j6K8pyB4lP5NrMJUIHCJ3e5t7Ve2K02A`
##### For all of the following requests, you will need a token.
Be sure to insert token into the request header. Example:
###### Header Key:
Authorization

###### Authorization value: 
Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzb21lbmFtZSIsImF1dGhvcml0aWVzIjpbXSwiaWF0IjoxNTkzNDI1MTUzLCJleHAiOjE1OTQyNTI4MDB9.S_5V7B_nifFs186v0Zo8lI4dupL-CvoN368hKJPYdtf_G4ANObbdW1j6K8pyB4lP5NrMJUIHCJ3e5t7Ve2K02A

 - #### Update user
/api/user/updateUser

PUT requests with body:
 
Indicate user id and data for editing
```json
{
    "userId": 1,
    "username": "rrrrrrr",
    "firstName": "ttttttt",
    "lastName": "lllllllll",
    "password": "password"
}
```
 - #### Delete user
/api/user/deleteUser

DELETE requests with body:
 
Indicate user id  for deleting
```json
{
    "userId": 1
}
```
 - #### Get user
/api/user/getUser

POST requests with body:
 
Indicate user id 

```json
{
    "userId": 1
}
```
 - #### Get users list
 pagination has not yet been implemented
  
 /api/user/getUsers
 
 POST requests with body:
```json
{
    "pagination": 1
}
```
 ## - Task endpoint:
 
 - #### Add new Task
 /api/task/add
 
 When creating a task, it is assigned to its creator
 
 PUT requests with body:
 ```json
 {
    "status": "View",
    "title": "iiiisdi",
    "description": "some description"
}
```
 - #### Update task
/api/task/updateTask

 PUT requests with body:
  ```json
 {
    "id": 65,
    "status": "Done",
    "title": "iiiisdi",
    "description": "some else description"
}
```
 - #### Delete task
/api/task/deleteTask

 DELETE requests with task id in body:
  ```json
 {
    "id": 1
}
```


 - #### Getting a list of tasks
 
/api/task/getTasks

Sorting by new / old users by'desc' or 'asc'

 POST requests with body:
 
```json
 {
     "status": "Done",
     "orderType": "desc"
 }
 ```
 
 - #### Change the user to whom the task is assigned
 
 /api/task/changeTaskResponsible
 
  PUT requests with body:
```json
{
    "taskId": 5,
    "userId": 7
}
```
  
 I would be very grateful if you looked at the code and write me what needs to be fixed. Professional opinion is very important for me.
  