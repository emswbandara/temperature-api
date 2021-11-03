# API to save and fetch Temperature Readings

This is implemented as a Spring Boot application which exposes services to view and save temperature readings via a RESTful API.
It uses an in-memory H2 database to persist data during runtime.
The application will also persist some dummy data during initialization(data available in src/main/resources/data.sql file) for trying out the APIs.

Swagger definition of the API is available in src/main/resources/temperature.yml

## How to run?

### Prerequisites
Make sure you have JAVA 8 or newer version installed. Set JAVA_HOME variable point to JAVA installation directory.

Use the following command to start the application with default configurations.

```
java -jar target/temperature-api-0.1.0.jar
```

## Sample API call to save a temperature reading
```
curl --location --request POST 'http://localhost:8080/temperature/save' \
--header 'Content-Type: application/json' \
--data-raw '{
    "temperature" : "28",
    "recordedAt" : "2021-08-26T22:34:59Z"
}'
```

## Sample API call to fetch temperature readings

The /fetch API requires a time-range for fetching temperature readings.
Use the 'start' parameter to specify the starting time of the range in ISO 8601 format.
Use the 'end' parameter to specify the ending time of the range in ISO 8601 format.

```
curl --location --request GET 'http://localhost:8080/temperature/fetch?start=2021-08-30T00:00:00Z&end=2021-08-31T00:00:00Z'
```

## Sample API call to bulk save a list of temperature readings

```
curl --location --request POST 'http://localhost:8080/temperature/bulk-save' \
--header 'Content-Type: application/json' \
--data-raw '[
    {
    "temperature" : "32",
    "recordedAt" : "2021-08-25T22:34:59Z"
    },
    {
    "temperature" : "40",
    "recordedAt" : "2021-08-25T22:39:05Z"
    },
    {
    "temperature" : "25",
    "recordedAt" : "2021-08-26T22:39:05Z"   
    }
]'
```
