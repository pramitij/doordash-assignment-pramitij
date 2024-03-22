# DoorDash Clone - Modeling Food Delivery Using Design Patterns

## Overview
>The DoorDash Clone is a Java-based software solution designed to simulate a simplified food delivery system, showcasing the application of various design patterns such as Bridge, Builder, Factory, Decorator, and Strategy. It demonstrates how these patterns can be utilized to create a structured and flexible system for managing orders, calculating totals, and applying discounts.

## Table of Contents
- [Introduction](#introduction)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Design Patterns Used](#design-patterns-used)
- [Development Log](#development-log)


## Introduction
The DoorDash Clone application features a simplified point-of-sale (POS) system capable of processing orders and calculating totals with various discounts. It employs several design patterns such as Bridge, Builder, Factory, Decorator, and Strategy to showcase software design principles in action.

## Requirements
Java Development Kit (JDK)
Integrated Development Environment (IDE) such as Eclipse, VS Code, or IntelliJ

## Installation
1. Clone the repository on your local system:
   ```sh
   git clone https://github.com/yourusername/doordash-clone.git

2. Import the project into your preferred IDE. For Eclipse, import it as an Existing Maven Project. For IntelliJ, open it directly using 'Get from VCS'.

3. Navigate to the project directory:
   ```sh
   cd doordash-clone
   
4. Compile and run the code:
   ```sh
   javac DoorDash.java
   java DoorDash
   
## Usage
Run the `demo()` method in the DoorDash class to see a demonstration of the application functionality.
Customize and test the POS system, calculator implementations, and order management functionalities as needed.

## Design Patterns Used
- Bridge Design Pattern: Separates abstraction from its implementation, allowing the POS system to switch between different calculator implementations seamlessly.
- Builder Design Pattern: Constructs complex order and item objects step by step, providing flexibility and ease of use.
- Factory Design Pattern: Creates instances of items and orders using factory classes, promoting loose coupling and easy extensibility.
- Decorator Design Pattern: Dynamically adds additional functionalities such as discounts and special offers to order objects without altering their structure.
- Strategy Design Pattern: Defines a family of algorithms, encapsulates each one, and makes them interchangeable, allowing the POS system to apply different discount strategies dynamically.

## Development Log
Version 1.0: Initial version of the DoorDash Clone application.
Version 1.1: Implemented basic skeleton interfaces and classes for POS and calculator.
Version 1.2: Developed order management functionalities using the Builder pattern.
Version 1.3: Created factory classes for item and order creation.
Version 1.4: Implemented various discount strategies using the Strategy pattern.
Version 1.5: Integrated decorator classes for applying discounts dynamically.
Version 1.6: Tested and debugged the application for successful execution.
