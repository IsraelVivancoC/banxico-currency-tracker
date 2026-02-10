#  Banxico Currency Tracker

A Java application that tracks the official USD to MXN exchange rate (FIX) in real-time using the **Bank of Mexico (Banxico) API**.

##  Features
* **Real-time Data:** Fetches the latest official exchange rate.
* **Secure:** Uses environment variables (`.env`) to manage API tokens.
* **Clean Architecture:** Built with a modular structure (Service, Model, and Main layers).
* **JSON Parsing:** Utilizes Jackson for efficient data mapping.
* **Unit Testing:** Includes a test suite powered by JUnit 5 to ensure data integrity.


##  Technologies
* **Java 17+**
* **Maven** (Dependency Management)
* **Jackson** (JSON Processing)
* **Java Dotenv** (Environment Variable Management)
* **JUnit 5** (Unit Testing Framework)


##  Setup

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/IsraelVivancoC/banxico-currency-tracker.git](https://github.com/IsraelVivancoC/banxico-currency-tracker.git)
    cd banxico-currency-tracker
    ```

2.  **Get your API Token:**
    * Visit the [Banxico SIE API portal](https://www.banxico.org.mx/SieAPIRest/service/v1/).
    * Generate your free token.

3.  **Environment Configuration:**
    Create a `.env` file in the root directory and add your token:
    ```env
    BANXICO_TOKEN=your_token_here
    ```

4.  **Run the application:**
    Use your IDE (IntelliJ) or Maven to run the `Main` class.

 ## Testing
To run the automated test suite, you can use either the Maven CLI or your IDE:

* **Maven CLI:** Execute `mvn test` in the terminal.
* **IntelliJ IDEA:** Right-click the `src/test/java` folder and select **Run 'All Tests'**, or click the green play icon next to the test class/method.

##  License
This project is for educational purposes. Data provided by Bank of Mexico.
