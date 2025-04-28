# kotlin-lotto-precourse

# Lotto Application

A simple command-line lottery ticket machine written in Kotlin.

## 🚀 Features

### 1. **Purchase Flow**
- The user will input a purchase amount for lottery tickets.
- The amount must be divisible by 1,000 KRW, as each ticket costs 1,000 KRW.
- The program will issue as many tickets as the budget allows based on the purchase amount.

### 2. **Ticket Generation**
- Each lottery ticket consists of 6 unique random numbers.
- The numbers must be in the range 1–45, and they will be generated using the `Randoms.pickUniqueNumbersInRange(1, 45, 6)` method.
- The generated numbers for each ticket will be sorted in ascending order for easier reading.

### 3. **Winning Number Input**
- The user will be prompted to input the winning lottery numbers, which must be 6 unique numbers in the range 1–45.
- The user will also input the bonus number, which is a separate number from the 6 winning numbers.

### 4. **Rank Calculation**
- The program will compare each purchased ticket with the winning numbers and the bonus number to determine the rank.
- The rank is assigned based on the following criteria:
    - **1st Prize**: Match all 6 numbers.
    - **2nd Prize**: Match 5 numbers + bonus number.
    - **3rd Prize**: Match 5 numbers.
    - **4th Prize**: Match 4 numbers.
    - **5th Prize**: Match 3 numbers.
    - **NONE**: For tickets that do not match 3 or more numbers.

### 5. **Statistics & Output**
- After the lottery results are calculated, the program will display the following information:
    - The number of tickets purchased and their corresponding numbers.
    - The number of tickets that matched 3, 4, 5, or 6 numbers, and the number of tickets that matched 5 numbers + the bonus number.
    - The total return rate (profit percentage) based on the tickets’ ranks.
    - Each prize category will display the corresponding prize amount and the count of tickets in that category.

### 6. **Error Handling & Validation**
- The program will throw an `IllegalArgumentException` if invalid data is entered by the user, such as non-numeric or out-of-range numbers.
- When an invalid input is detected, the program will re-prompt the user for correct input until valid data is provided.

### 7. **Profit Calculation & Return Rate**
- After calculating the winning ticket ranks, the program will compute the total profit by summing the prize amounts from all winning tickets.
- The **return rate** is calculated as:  
  `returnRate = (totalPrize / purchaseAmount) * 100`.
- The program will print the return rate rounded to one decimal place.

### 8. **Orchestration**
- The `LottoRankOrchestrator` class will serve as the main controller for the entire flow of the application.
- It will coordinate the steps of:
    - Getting user input (purchase amount, winning numbers, bonus number),
    - Generating the tickets,
    - Calculating ranks,
    - Displaying the results.

---


