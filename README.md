# Banking Application & Employee Management Application

## Overview

This repository contains two separate applications developed using Maven and Hibernate:

1. **Banking Application** - A system that handles basic banking operations such as account management, transactions, and customer information.
2. **Employee Management Application** - A system designed to manage employee records, including CRUD operations, department assignments, and role management.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Database Configuration](#database-configuration)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Features

### Banking Application
- Create, read, update, and delete (CRUD) operations for accounts.
- Transaction management (deposits, withdrawals, transfers).
- Customer profile management.

### Employee Management Application
- CRUD operations for employee records.
- Department and role management.
- Search and filter employees by various criteria.

## Technologies Used

- **Java** - Programming language used for development.
- **Maven** - Build automation tool for managing dependencies and project structure.
- **Hibernate** - ORM (Object-Relational Mapping) framework for database operations.
- **MySQL** - Relational Database management system.

## Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/mofq786/Hibernate_Framework_Projects.git
   
2. **Navigate to the Project Directory**
   ```bash
   cd Hibernate_Framework_Project
3. **Build the Project**
   ```bash
   mvn clean install
## Database Configuration
- Database Setup
     - Ensure your database is running and accessible.
     - Update the JPA configuration in the persistence.xml file or equivalent configuration files in your project.
- JPA Configuration
     - Configuration in `src/main/resources/META-INF/persistence.xml`:
       ```bash
       <?xml version="1.0" encoding="UTF-8"?>
       <persistence version="2.1" xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi=
       "http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
       http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
	   <persistence-unit name="BankingApplication" transaction-type="RESOURCE_LOCAL">
		<class>com.jsp.entity.UserInformation</class>
		<properties>
			<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/teca6061hibernate"/>
			<property name="javax.persistence.jdbc.user" value="root"/>
			<property name="javax.persistence.jdbc.password" value="12345"/>
			<property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
		</properties>
	   </persistence-unit>
       </persistence>
  
## Project Structure
- src/main/java - Contains the Java source files.
- src/main/resources - Configuration files, including persistence.xml.
- src/test/java - Unit tests for both applications.

## Contributing
- Contributions are welcome! Please create a pull request or open an issue to discuss what you would like to change.

## License
- This project is licensed under the MIT License - see the LICENSE file for details.
