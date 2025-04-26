# kotlin-lotto-precourse

## Description
This is a simple Kotlin-based lottery machine simulator. Here, users can purchase tickets, enter winning numbers and a bonus number, and see results and profit rate.

## Feature List

### 1. User Input
### 2. Lotto Ticket Generation
### 3. Result Calculation
### 4. Output
### 5. Error Handling


### 1. User Input
- Enter purchase amount (must be divisible by 1000).
- Enter 6 unique winning numbers between 1-45.
- Enter a unique bonus number (not in winning numbers).

### 2. Lotto Ticket Generation
- Generate N tickets (purchaseAmount / 1000).
- Each ticket: 6 unique sorted numbers from 1 to 45.

### 3. Result Calculation
- Match ticket vs winning numbers.
- Determine prize rank:
  - If there are 6 matches = 1st prize
  - If there are 5 matches + bonus = 2nd prize
  - If there are 5 matches = 3rd prize
  - If there are 4 matches = 4th prize
  - If there are 3 matches = 5th prize
- Calculate total winnings and profit rate.

### 4. Output
- Show all tickets purchased.
- Show statistics (ticket count per prize tier).
- Display profit rate (rounded to 1 decimal place).

### 5. Error Handling
- Invalid input (non-divisible amount, wrong number ranges, duplicates) → show `[ERROR]` message and re-prompt.

---

## 🧪 Unit Tests
- Unit tests for ticket generation, matching, and profit calculation using JUnit5 + AssertJ.
