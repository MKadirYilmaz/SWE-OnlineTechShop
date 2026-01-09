# Online Technology Store System (Online Tech Shop)

This project is a Spring Boot-based Online Technology Store application that provides a modern e-commerce experience. It offers a platform where users can browse technological products, add them to their cart, and place orders.

## 📋 Features

*   User Management: Sign up and secure login (Authentication).
*   Product Catalog: List products by category and view details.
*   Smart Cart Management: Add/remove items and update quantities in the cart.
*   Order Process: Real-time order creation with stock control (Checkout).
*   Order Tracking: View the status and details of past orders.
*   Admin Panel: (Optional/Extensible) Product and stock management infrastructure.

## 🛠 Technology Stack

This project is built on a robust and scalable architecture:

### Backend
*   Language: Java 17
*   Framework: Spring Boot 3.5.7
*   Data Access: Spring Data JPA
*   Validation: Spring Validation
*   Tools: Lombok, Maven

### Database
*   System: MySQL 8.0+
*   Test Database: MySQL Database (For tests)

### Frontend
*   Core: HTML5, CSS3
*   Scripting: Vanilla JavaScript (Modern ES6+)
*   Design: Responsive and user-friendly interface

## 🚀 Installation and Running

Follow the steps below to run the project on your local machine.

### 1. Prerequisites
*   Java Development Kit (JDK) 17 or higher
*   MySQL Server

### 2. Database Configuration
Create an empty database named swe on your MySQL server:

CREATE DATABASE swe;

Open the src/main/resources/application.properties file and enter your own database credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/swe
spring.datasource.username=YOUR_USERNAME  (e.g., root)
spring.datasource.password=YOUR_PASSWORD

### 3. Starting the Project

Go to the project directory in your terminal or command line and run the following command:

Windows:
./mvnw spring-boot:run
*(Alternatively, you can double-click the run_project.bat file)*

Linux/Mac:
./mvnw spring-boot:run

Once the application starts successfully, it will run on Port 8088.

## 🌐 Usage

Open your browser and navigate to the home page:

👉 http://localhost:8088

*   Login/Register: Log in to your account or create a new one from the top right menu.
*   Shopping: Add products from the home page to your cart using the "Add to Cart" button.
*   Cart: Click the Cart icon in the top right to manage your cart and complete the order by clicking "Checkout".
*   My Orders: View your past orders from the profile menu.

## 📁 Project Structure

SWE-OnlineTechShop/
├── src/main/java/com/techshop/
│   ├── controller/    # Classes handling API requests
│   ├── model/         # Entities corresponding to database tables
│   ├── repository/    # Data access layer (DAO)
│   ├── service/       # Business logic rules
│   └── dto/           # Data transfer objects
├── frontend/          # HTML, CSS, and JS files
└── pom.xml            # Maven dependency management

## 🧪 Tests

To run unit tests:

./mvnw test
