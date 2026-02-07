#  Banxico Currency Tracker

A Java application that tracks the official USD to MXN exchange rate (FIX) in real-time using the **Bank of Mexico (Banxico) API**.

##  Features
* **Real-time Data:** Fetches the latest official exchange rate.
* **Secure:** Uses environment variables (`.env`) to manage API tokens.
* **Clean Architecture:** Built with a modular structure (Service, Model, and Main layers).
* **JSON Parsing:** Utilizes Jackson for efficient data mapping.

##  Technologies
* **Java 17+**
* **Maven** (Dependency Management)
* **Jackson** (JSON Processing)
* **Java Dotenv** (Environment Variable Management)

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

##  License
This project is for educational purposes. Data provided by Bank of Mexico.
