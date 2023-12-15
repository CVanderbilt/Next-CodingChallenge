## Bank api

You may notice that I havent used the base project that was available. The reason is because I was having errors running it. I lost some time trying to fix it and finally I ended up creating my own using [https://start.spring.io/] but I lost almost an hour in the process.

### Implemented
In the available time I implemented the following things:
* Application: Using a comprehensible and easily extendable architecture (controller-data-service layers)
* API endopoints:
```/client/status```:  
returns a list of all clients/accounts
```/client/activate```:   
returns nothing
body:
```
{
    "clientId": "657c4fe02ce6852be9bc9141",
}
```
```/client/withdraw```:   
returns nothing
body:
```
{
    "clientId": "657c4fe02ce6852be9bc9141",
    "amount": "100"
}
```
```/client/deposit```:   
returns nothing
body:
```
{
    "clientId": "657c4fe02ce6852be9bc9141",
    "amount": "100"
}

### Build

#### Java Application
To build the application, navigate to the root directory of the project and execute the following command:
```make build```. Alternatively, you can directly run ```./gradlew build``` from inside the ```/demo/``` directory

### Run

#### Mongodb
Start/stop the MongoDB service in a Docker container with the following commands
```
make start-mongodb  # To start
make stop-mongodb   # To stop
```
Alternatively, you can use docker-compose up to start MongoDB and docker-compose down to stop it. MongoDB will be
accessible at localhost:27017.

#### Java Application
You can run the application using the following command ```make run```. Alternatively, you can run it from
IntelliJ or execute java -jar your-jar-file from the console. Ensure that MongoDB is running, and the application has
the correct configuration in /demo/src/resources/application.properties. By default, a configuration is provided to
connect to the MongoDB service in the container

### Rebuild and Restart
To rebuild and restart the application, you can use the following command ```make re```.
This command simplifies the process of updating and redeploying your service.

