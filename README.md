boardy
======

Spike/template for simple REST service using Dropwizard

Compile and package fat jar with maven
------------------------------
`mvn clean package`

Run tests with maven
---------
`mvn clean test`

Start server (using fat jar from previous step)
-----------------------
`java -jar target/boardy-0.0.1-SNAPSHOT.jar server boardy-app.yml`

Post stuff (message) to server with curl
------------------------------
`curl -H "Content-Type: application/json" -X POST -d '{"title":"my title", "content":"some content here", "sender": "me", "url": "http://foobar.com"}' http://localhost:8080/api/messages`

Get stuff (messages) from server with curl
-------------------------------

Boardy message v1 (only json supported):
`curl -H "Accept: application/json" -X GET http://localhost:8080/api/v1/messages`

Boardy message v2 (json and xml supported)
`curl -H "Accept: application/json" -X GET http://localhost:8080/api/v2/messages`
or
`curl -H "Accept: application/xml" -X GET http://localhost:8080/api/v2/messages`
