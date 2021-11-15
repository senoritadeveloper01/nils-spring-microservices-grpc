# A Sample Spring Boot Microservices Project with gRPC
This is a sample microservices project developed with Spring Boot and gRPC, using Java version 16.

<img src="https://img.shields.io/badge/Language-Java-orange.svg">

## Submodules:
- City Score
    - It calculates a city score value.
    - Request parameter uses a custom "ValidCityCode" validation.

- Score Segment
    - It calculates a score segment value.
    - Request parameter uses a custom "ValidIdNumber" validation.

- Score Calculator
    - It calls CityScore and Score Segment services to calculate a final score.
    - H2 is used for database implementation.

## Usage
To test score service API call, you can perform a cURL request (or import it to Postman):
```
curl -L -X GET 'http://localhost:8200/calculate-score?idNumber=3654118644&name=senorita&surname=dev&phoneNumber=5007665432&cityCode=-35&incomeBracketMultiplierId=1'
```
To reach H2 database UI, please visit [http://localhost:8200/h2-console](http://localhost:8200/h2-console).

**JDBC URL**: jdbc:h2:mem:testdb

**User Name**: sa

**Pasword**: _no password required, leave empty_

## Authors / Contributors / Credits
**Nil Seri**

[Github 1](https://github.com/senoritadeveloper01)

[Github 2](https://github.com/nilseri01)

You can visit [my Medium profile](https://senoritadeveloper.medium.com/) 
You can specifically visit [this post](https://senoritadeveloper.medium.com/grpc-implementation-with-spring-boot-7d6f98349d27) where you can find posts giving detail about important steps for implementing this project.

You can also visit [my Docker Hub](https://hub.docker.com/u/nilseri) for images created for the services in the project.

## Copyright & Licensing Information
This project is licensed under the terms of the MIT license.
