
🎟️ Lotto Program


A Kotlin-based application that simulates the purchase of Lotto tickets, checks them against winning numbers, calculates results, and outputs the profit rate.
This project emphasizes clean architecture, strict input validation, and clear separation of concerns between business logic and UI.

📋 Project Overview
This Lotto program allows users to:

Purchase a set of lotto tickets based on their input amount.

Input winning numbers and a bonus number.

Compare purchased tickets against the winning numbers to determine the prizes.

Calculate and display the total winnings and profit rate.

✨ Features
1. Purchase Lotto Tickets
User inputs a purchase amount.

Validations:

Must be a numeric input.

Must be divisible by 1,000 KRW.

Generates the correct number of tickets (1 ticket per 1,000 KRW).

Each ticket contains 6 unique random numbers between 1 and 45, displayed in ascending order.

2. Input Winning Numbers
User inputs exactly 6 unique winning numbers (1 to 45).

User inputs 1 bonus number (must also be between 1 and 45 and must not duplicate any winning number).

Validations:

Numbers must be unique.

Numbers must be within the valid range (1–45).

Exactly 6 winning numbers must be provided.

3. Result Calculation
Compares each ticket against the winning numbers.

Determines ranks based on matches:

1st Prize: 6 matches

2nd Prize: 5 matches + bonus number match

3rd Prize: 5 matches

4th Prize: 4 matches

5th Prize: 3 matches

Calculates total prize money.

Calculates and displays the profit rate based on the user's original purchase amount.

4. Error Handling
Invalid inputs throw an IllegalArgumentException.

All error messages are prefixed with [ERROR].

Strict validation prevents the program from continuing with bad inputs.

5. Structure & Testing
Business logic and user interface are strictly separated.

All business logic is fully unit tested.

No UI elements (e.g., println) appear in the logic classes.

Follows clean, scalable architecture for easy maintenance.