# Perspective API

A RESTful API to have all your personal development perspectives in one place! No more missed Perspectives or difficulty in finding them in notebooks or scattered sticky notes.

<p align="center">
    <img src="https://i.postimg.cc/8zTwMsN6/responsive-mockup.png" />             
</p>

### Front-End Web App

The above image corresponds to the web app that uses this API. This application can be found in the following link: [Perspective Web App](https://github.com/jperezmota/perspective-web-app)

## Built With

* [Spring with Spring Boot](https://spring.io/projects/spring-boot) - A Java Framework.
* [Hibernate](https://hibernate.org/) - An object-relational mapping tool for the Java programming language.
* [MySQL](https://www.mysql.com/) - Database.
* [Flyway](https://flywaydb.org/) - Database Migration Tool.
* [Maven](https://maven.apache.org/) - Dependency Management.

#### Installation Process

1. Clone the repository to your directory
```
git clone https://github.com/jperezmota/perspective-api.git
```
2. Import the Maven project to your IDE

3. Either run the project through your IDE or inside the project root directory run the following command: `./mvnw spring-boot: run`

## Authentication

In order to access the API Endpoints you need a ``Token`` which is obtained by authenticating your account through the following endpoint:

### Securities Endpoint

Request Method: POST <br>
Request URL: http://localhost:8080/api/securities <br>
Request Body:
```
{
    "username": "admin",
    "password": "admin"
}
```
Response Body:
```
{
    "username": "admin",
    "password": "$2a$04$tI.B0ZrrEcP4ejGKHJboVuRIOFU4MsnjBw/VUr.TdlvTa0jQeCSBO",
    "token": "asdasdaWEwe12231344",
    "enabled": true,
    "authorities": [
        {
            "authority": "ROLE_ADMIN"
        }
    ]
}
```
Error Response Body:
```
{
    "status": 404,
    "message": "User not found with those credential ",
    "timestamp": 1538420595089
}
```

## Authorization Header

All requests to the endpoints below should include the ``Authorization`` http header which value has to be the ``Token`` you obtained from authenticating.

| Http Header   | Value         |
| ------------- | ------------- |
| Authorization | Your Token    |

### Perspectives Endpoint

**Create a Perspective** <br>
Request Method: POST <br>
Request URL: http://localhost:8080/api/perspectives

**Modify a Perspective** <br>
Request Method: PATCH <br>
Request URL: http://localhost:8080/api/perspectives/:id

**List Perspectives** <br>
Request Method: GET <br>
Request URL: http://localhost:8080/api/perspectives

**Get a single Perspective** <br>
Request Method: GET <br>
Request URL: http://localhost:8080/api/perspectives/:id

**Delete a single Perspective** <br>
Request Method: GET <br>
Request URL: http://localhost:8080/api/perspectives/:id

### Authors Endpoint

**Create a Author** <br>
Request Method: POST <br>
Request URL: http://localhost:8080/api/authors

**Modify a Author** <br>
Method: PATCH <br>
URL: http://localhost:8080/api/authors/:id

**List Authors** <br>
Request Method: GET <br>
Request URL: http://localhost:8080/api/authors

**Get a single Author** <br>
Request Method: GET <br>
Request URL: http://localhost:8080/api/authors/:id

**Delete a single Author** <br>
Request Method: GET <br>
Request URL: http://localhost:8080/api/authors/:id

### Categories Endpoint

**Create a Category** <br>
Request Method: POST <br>
URL: http://localhost:8080/api/categories

**Modify a Category** <br>
Request Method: PATCH <br>
Request URL: http://localhost:8080/api/categories/:id

**List Categories** <br>
Request Method: GET <br>
Request URL: http://localhost:8080/api/categories

**Get a single Category** <br>
Request Method: GET <br>
Request URL: http://localhost:8080/api/categories/:id

**Delete a single Category** <br>
Request Method: GET <br>
Request URL: http://localhost:8080/api/categories/:id

## Contributing

Please take a look at our [contributing](https://github.com/jperezmota/perspective-api/blob/master/CONTRIBUTING.md) guidelines if you're interested in helping!

#### Pending Features

Pending features are listed here: [Issues](https://github.com/jperezmota/perspective-api/issues)

## Contact me

Feel free to contact me if you need any help! jonathanperezmota@gmail.com
