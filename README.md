# Lottery Ticket Machine - Requirements

## Overview
A simple console-based lottery ticket machine that allows users to purchase tickets, enter winning numbers, and determine their prize winnings based on predefined rules.

---

## Functional Requirements

### 1. Ticket Purchase
- Prompt user: **"Please enter the purchase amount."**
- Each ticket costs **1,000 KRW**.
- The purchase amount must be divisible by 1,000.
- The program should calculate the number of tickets based on the entered amount.


### 2. Ticket Generation
- Each ticket contains **6 unique random numbers**.
- Number range: **1 to 45** inclusive.
- All generated tickets must be unique per purchase session.

---

### 3. Winning Number Input
- Prompt user: **"Please enter last week's winning numbers."**
- Input must be **6 unique numbers** between **1 and 45**.
- Prompt user: **"Please enter the bonus number."**
- Bonus number must be:
    - A **single number**
    - Between **1 and 45**
- **Not included** in the set of 6 winning numbers

---

### 4. Result Evaluation
- Each ticket is compared to the winning numbers.
- **Order does not matter** for matching.
- Rank determination based on matches:

| Rank | Match Criteria               | Prize (KRW)        |
|------|------------------------------|--------------------|
| 1st  | Match 6 numbers              | 2,000,000,000 KRW  |
| 2nd  | Match 5 numbers + bonus      | 30,000,000 KRW     |
| 3rd  | Match 5 numbers              | 1,500,000 KRW      |
| 4th  | Match 4 numbers              | 50,000 KRW         |
| 5th  | Match 3 numbers              | 5,000 KRW          |

- Display number of tickets per prize rank.
- Calculate:
- **Total Winnings**
- **Profit Rate**: `(Total winnings / Purchase amount) × 100`

