# 🎰 Lotto Ticket Machine – Kotlin Precourse

This project is a simple console-based Lotto program written in Kotlin. It simulates a lottery ticket machine that issues tickets, checks winning numbers, and calculates prizes based on strict rules.

## 🧠 Learning Objectives

- Group related functions into **collaborating classes**
- Write **unit tests** for each class and function to ensure correctness and reliability

## 📋 Lotto Game Rules

1. The user enters the purchase amount (must be divisible by 1,000 KRW).
2. Each ticket costs 1,000 KRW and contains **6 unique random numbers** between **1 and 45**.
3. The user then inputs:
   - **6 winning numbers** (unique)
   - **1 bonus number** (unique and separate)
4. Prize ranks are determined as follows:

| Rank | Match Criteria                    | Prize (KRW)         |
|------|-----------------------------------|---------------------|
| 1st  | Match 6 numbers                   | 2,000,000,000       |
| 2nd  | Match 5 + bonus number            | 30,000,000          |
| 3rd  | Match 5 numbers                   | 1,500,000           |
| 4th  | Match 4 numbers                   | 50,000              |
| 5th  | Match 3 numbers                   | 5,000               |

5. The program compares the user's tickets with the winning numbers and prints:
   - Number of matches per ticket
   - Total winnings
   - Profit rate

6. Invalid inputs throw an `IllegalArgumentException` or `IllegalStateException` and re-prompt the user.

## 🚧 Progress Checklist

- [✅] Set up project structure and build system
- [✅] Create Lotto class
- [✅] Create LottoManager class
- [✅] Implement ticket generation logic
- [ ] Add input validation
- [ ] Build comparison and ranking logic
- [ ] Create Enum for Winner Criteria
- [ ] Handle exceptions properly
- [ ] Write unit tests for all major components
- [✅] Add user input/output logic
- [ ] Build Error handling method
      - When exception is thrown by require(), main() terminates before printing anything so comparing with "[ERROR]" is not possible
      - [✅] Stick with assertThrows and search later if there's other way to utilize "[ERROR]" message

---

_This README will be updated as the project evolves._
