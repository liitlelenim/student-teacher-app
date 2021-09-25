[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)


<h1 align="center">Student-Teacher</h1>

<div align="center">

![Logo](./logo.png)

</div>

**Simple CRUD application, made for learning purposes that allows user to keep track of student and their grades.**

## Live version

Check out live version right now on: https://student-teacher.netlify.app/


## Tech stack

### Backend

* Java
* Spring Boot
* Spring Data JPA
* H2 Database
* Lombok
* JUnit

### Frontend

* React
* React Router
* React-Bootstrap

## Features


* Adding students to the database
* Editing and deleting students data
* Adding grades, their values and descriptions
* Editing and deleting grade data

## Running project on your machine


* First you should open a terminal window inside the project root folder and then run the following command
  ```console
  mvn spring-boot:run
* Next you have to locate the .env.sample file in frontend directory. Now you should change its name to ".env" and set
  the
  *REACT_APP_API_BASE_URL* accordingly to your working environment needs. For most cases it should be just set
  to `"http://localhost:8080/api/"`.
* At the end you have to run following command inside *frontend* directory.
  ```console
  npm start

Now the project should be working on your local machine.