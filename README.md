Java Streams Workbook – 12 Practical Problems
Project Overview
Java Streams Workbook is a Maven-based Java project containing solutions to 12 practical programming problems using Java 8 Streams and related Java concepts.
The project demonstrates how to process collections, group data, perform aggregations, sort records, analyze logs, and solve common programming challenges.
Technologies Used
Java (Java 8 Streams API)
Maven
IntelliJ IDEA
Git and GitHub
Java Collections Framework
Lambda Expressions
Stream API and Collectors
Problems Implemented
No.ProblemDescription1Customer Transaction AggregatorCalculate credits, debits, and balances for customers2Group Orders by CustomerGroup orders and calculate total orders and amounts3Log AnalyticsCount log messages by severity4Top 3 Frequent WordsFind the three most frequent words5Group AnagramsGroup words containing the same letters6Inventory ReconciliationIdentify quantity mismatches between warehouse and store7Longest Substring with K Distinct CharactersFind the longest substring containing K distinct characters8Employee Hierarchy BuilderBuild a reporting hierarchy using employee-manager relationships9Multi-Level Employee SortingSort employees by department, experience, rating, and name10Account Balance ProcessorCalculate account balances and identify the highest balance11Detect Circular DependencyDetect circular relationships in dependencies12Session AnalyticsCalculate user session durations and average session time
Project Structure
JavaStreamsWorkbook/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── training/
                    ├── dto/
                    │   └── DTO classes
                    ├── main/
                    │   └── Main.java
                    └── service/
                        └── StreamService.java
Key Concepts Practiced
Stream operations: filter(), map(), sorted(), and forEach()
Collectors: groupingBy(), counting(), and toMap()
Lambda expressions and method references
Comparator-based sorting
Collection processing and aggregation
Working with lists and maps
Date and time calculations
Problem-solving with Java
How to Run
Clone this repository using Git.
Open the project in IntelliJ IDEA.
Import the project as a Maven project.
Configure a compatible JDK.
Open src/main/java/com/training/main/Main.java.
Run the main() method to execute the solutions.
Learning Outcomes
This project helped strengthen practical understanding of Java Streams, collection processing, data transformation, aggregation, sorting, and problem-solving.
Author
Varsha Katakam
Project Status
Completed – 12 Java programming problems implemented.
