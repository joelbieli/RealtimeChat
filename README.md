# Realtime Chat

This should in the end be a Realtime Chat application with a Kotlin backend and a Vue.js frontend.

[TOC]

## Backend Technology

The following libraries were used to construct the backend.

- [Javalin](https://javalin.io/) which uses [Jackson Kotlin Module](https://github.com/FasterXML/jackson-module-kotlin) under the hood for (de)serialization of JSON requests/responses

- [MicroUtils Kotlin-Logging](https://github.com/MicroUtils/kotlin-logging) which uses a [slf4j](https://www.slf4j.org/) under the hood

- [KMongo ](https://litote.org/kmongo/)which uses [Jackson Kotlin Module](https://github.com/FasterXML/jackson-module-kotlin) under the hood for (de)serialization of [BSON](http://bsonspec.org/)

- [jBCrypt](https://github.com/jeremyh/jBCrypt)

- [gethostname4j](https://github.com/mattsheppard/gethostname4j)

- [Apache Commons Codec](http://commons.apache.org/proper/commons-codec/)

- [JJWT](https://java.jsonwebtoken.io/)

- [Spek](https://spekframework.org/) which uses [JUnit](https://junit.org/junit5/) under the hood

- [Kluent](https://markusamshove.github.io/Kluent/)

##Visualisations

[Class Diagram](https://www.lucidchart.com/invitations/accept/9d59de55-f09f-4bf2-bcd9-791f99fa96ca) - [this](https://www.lucidchart.com/pages/uml-class-diagram) style guide was used for creating the diagram

[Sequence Diagram for registering and logging in](https://www.lucidchart.com/invitations/accept/9d59de55-f09f-4bf2-bcd9-791f99fa96ca) - [this](https://www.lucidchart.com/pages/uml-sequence-diagram) style guide was used for creating the diagram

## Code Documentation

[HERE](docs/-realtime-chat/index.md)