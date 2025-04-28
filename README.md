# Lotto

## Features

- **User can input the total amount for ticket purchase**
    - The amount must be divisible by 1000.
    - If a number is out of range or invalid:
        - Show an error message
        - Prompt the user to enter the correct number again **at this stage**

- **Program displays ticket numbers as an array depending on the purchase amount**
    - Generate random numbers in each ticket.
    - Numbers must be **sorted in ascending order** within each ticket.

- **User can input 6 winning numbers (range 1–45)**
    - **Validate user input**:
        - Each number must be between **1 and 45**.
        - If a number is out of range or invalid:
            - Show an error message
            - Prompt the user to enter the correct number again **at this stage**

- **User can input a bonus number**
    - Each number must be between **1 and 45**.
    - If a number is out of range or invalid:
        - Show an error message
        - Prompt the user to enter the correct number again **at this stage**

- **Program compares the user's numbers with the winning combination and splits tickets in six buckets:**
    1. 6 matches
    2. 5 matches + bonus number
    3. 5 matches
    4. 4 matches
    5. 3 matches

- **Program outputs the number of matching digits**

- **Program calculates and displays the profit**

- **Program is covered by Unit tests to validate the functionality.**
