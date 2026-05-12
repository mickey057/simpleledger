# SimpleLedger

SimpleLedger is a minimal accounting web application built with Spring Boot, Thymeleaf, Bootstrap, and Spring Data JPA.

The purpose of this project is to demonstrate a clean Java/Spring Boot MVC application that can record income and expenses and calculate a basic business balance.

## Features

- Dashboard with total income, total expenses, balance, and transaction count
- Add income or expense transactions
- View all transactions
- Delete transactions
- Basic validation
- H2 database for fast local demo
- Clean MVC structure

## Tech Stack

- Java 17+
- Spring Boot
- Spring MVC
- Thymeleaf
- Bootstrap 5
- Spring Data JPA
- H2 Database

## Architecture

The application uses a simple layered architecture:

```text
controller -> service -> repository -> database