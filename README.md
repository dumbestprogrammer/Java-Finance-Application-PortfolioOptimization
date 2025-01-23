# Java-Finance-Application-PortfolioOptimization
## Portfolio Optimization Project


- The Portfolio Optimization Project is a work-in-progress application designed to provide real-time analytics and historical data insights for stock portfolios.
- It is based on a microservices architecture, leveraging Apache Kafka for streaming data and Apache Pinot for storage and analytics. <br>

- The project aims to handle large volumes of stock data while enabling real-time and historical data processing. <br>

- This README outlines the current state of the project, its functionality, design approach, and future plans.  <br> <br>


# Current State of the Project

## Microservices Overview
**The project currently includes one completed microservice, with plans for additional services in the future:**

1. **Microservice 1: Data Ingestion Microservice (Completed):**
- Fetches stock data from APIs like Alpha Vantage and Polygon.
- Publishes this data to Apache Kafka topics.
<br>
<br>


2. **Microservice 2: Data Processing Microservice (Paused):**
   
**Idea:**

- Consume data from Kafka topics.

- Save the data in Apache Pinot for real-time and historical purposes.

- Perform transformations such as calculating percentages and averages using Pinot's query capabilities.

**Current Status:** 
- Work on this service is on hold while I study Apache Pinot to ensure efficient and scalable implementation.
  

<br>
<br>


3. **Microservice 3: Portfolio Optimization Service (Planned):**

**Purpose:**


- Will retrieve processed data to perform portfolio optimization using advanced algorithms.

- Will act as the decision-making layer for user portfolio recommendations.

**Status:**  *Planned for future development.*

<br> <br>

# Technologies Used
- **Java:** Backend programming language.
- **Spring Boot:** Framework for building microservices.
- **Apache Kafka**: Real-time data streaming.
- **Apache Pinot:** Real-time and historical data storage and analytics.
- **Docker:** Containerization for easy deployment.

<br>

# Planned Features:
Here are the future features planned for the project:
<br>
<br>


**AI-Powered Insights:**

- Integrate AI models for stock trend predictions and sentiment analysis (using Python).

<br>

**Real-Time Alerts:**

- Enable notifications for custom stock alerts based on user-defined triggers.

<br>

**Interactive Dashboard:**

- Develop a user-friendly frontend for visualizing stock data (currently, no frontend is implemented).

<br>

**Risk Analysis:**

- Add AI-driven tools to assess portfolio risks based on real-time and historical data.

<br>
<br>

# Why Apache Pinot?

**Apache Pinot was selected for its strengths in handling large-scale analytics:**


- **Real-Time Querying:** Ultra-low latency for real-time analytics.

- **Optimized for OLAP:** Built for processing streaming data at scale.

- **Time-Based Retention:** Automatically manages historical data retention, perfect for financial applications.

<br>
<br>

# Getting Started
**Prerequisites**


To run this project, ensure you have the following installed:

- JDK 11 or higher

- Apache Kafka

- Apache Pinot

- Docker


<br>
<br>


# Current Microservices Flow
**Microservice 1: Data Ingestion Microservice**

- Fetches stock data from external APIs.

- Publishes the raw data to Kafka topics.


<br>
<br>

**Microservice 2: Data Processing Microservice (Planned)**

- Consume data from Kafka topics.
- Save and query the data using Apache Pinot.
- Leverage Pinot's OLAP features for real-time analytics like averages and percentages.
- Use Pinot's time-based retention for managing historical data (e.g., retaining data for the last three days).

<br>

**Future Work**
- Resume development of the Data Processing Microservice after completing my study of Apache Pinot.
- Add AI-based modules for analytics and predictions.
- Build a responsive and interactive frontend dashboard using modern web technologies.

<br> <br>

**Microservice 3: Portfolio Optimization Service (Planned):**
- Will retrieve processed data to perform portfolio optimization using advanced algorithms.

- Will act as the decision-making layer for user portfolio recommendations.

<br>
<br>

# Contact
**For any questions, feedback, or contributions, feel free to reach out:**
**Email:** *anukulmaurya18@gmail.com*

### This README will be updated as the project progresses. Stay tuned!
