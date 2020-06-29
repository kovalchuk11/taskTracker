##Note for the reviewer
I will be very grateful if you write to me what needs to be fixed here. So that I can improve my skill.

#API

####The project was deployed to heroku
https://nameless-falls-13226.herokuapp.com/

All requests you can send to this server

- ## User endpoint:   
 - ####registration 
 /api/user/signup
 
 POST requests with body: 
 
 
    "username": "sodd",
    "firstName": "firstName",
    "lastName": "lastName",
    "email": "emaishlww@gmail.com",
    "password": "password"

 - ####login 
 /login
 
 POST requests with body: 
 
 
    "username": "soddd",
    "password": "password"

A token will come from the server. He is in Header. Token example:
`Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzb21lbmFtZSIsImF1dGhvcml0aWVzIjpbXSwiaWF0IjoxNTkzNDI1MTUzLCJleHAiOjE1OTQyNTI4MDB9.S_5V7B_nifFs186v0Zo8lI4dupL-CvoN368hKJPYdtf_G4ANObbdW1j6K8pyB4lP5NrMJUIHCJ3e5t7Ve2K02A`
#####For all of the following requests, you will need a token.
Be sure to insert it into the request header. Example:
######Header Key:
Authorization

######Authorization value: 
Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzb21lbmFtZSIsImF1dGhvcml0aWVzIjpbXSwiaWF0IjoxNTkzNDI1MTUzLCJleHAiOjE1OTQyNTI4MDB9.S_5V7B_nifFs186v0Zo8lI4dupL-CvoN368hKJPYdtf_G4ANObbdW1j6K8pyB4lP5NrMJUIHCJ3e5t7Ve2K02A

