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
- [✅] Add input validation
- [✅] Build comparison and ranking logic
- [✅] Create Enum for Winner Criteria
- [✅] Add profitability caculation logic
- [✅] Handle exceptions properly
- [✅] Write unit tests for all major components
- [✅] Add user input/output logic
- [✅] Enhance Readability
- [✅] Build Error handling method
      - When exception is thrown by require(), main() terminates before printing anything so comparing with "[ERROR]" is not possible

      - [✅] Stick with assertThrows and search later if there's other way to utilize "[ERROR]" message

      - solved by saving return value from assertThrows and asserting if that return value contains "[ERROR]" message

---

## 💪 Challenges Faced During the Project

### 1. Incremental Development & Testing
Struggled with working in small steps and testing frequently. Still at the habit of trying to cover a bigger area at once. Learned the value of Test-Driven Development (TDD) and early validation.

### 2. Debugging
Couldn't implement a debugger successfully, relied at times on `println` for tracking. Realized the importance of proper debugging tools.

### 3. Test Setup
Setting up tests for each and every class and function and not just for the whole program only was challenging but helped me understand the discipline of TDD.

### 4. Initial Planning
Learned the importance of planning ahead. A good initial README and structure made the development process smoother.

### 5. Naming Classes & Variables
Found naming classes and variables challenging. Learned that clear, descriptive names are essential for readability.

### 6. Edge Case Thinking
Realized that thinking of all edge cases on my own had limits. Outside source (AI, websites, etc.) helped identify more cases.

### 7. Writing Test Cases vs Manual Testing
Writing automated test cases was different from manual testing. It made me appreciate the value of repeatable, structured tests.

### 8. Coding Conventions
Not fully accustomed to coding conventions, but realized the need for constant review and practice.

### 9. Over-Refactoring
Over-refactoring sometimes reduced readability. Learned that balance is key to maintain clarity without overcomplicating.

### 10. Architectural Patterns
Recognized the importance of following established architectural patterns like MVC and domain-driven design for better project structure. This isn't implemented in this project and felt the need to further pursue learning these patterns in the future.
