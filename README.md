# kotlin-lotto-precourse
This project implements a simple lottery ticket machine according to the Hero Tech Course pre-course requirements.  

---

## 📝 Feature List

1. **Purchase Validation**  
   - Ensure the purchase amount is divisible by 1 000 KRW.  
2. **Ticket Generation**  
   - Generate as many tickets as the budget allows (each ticket is 6 unique random numbers in 1–45).  
3. **Winning Numbers Input & Validation**  
   - Read 6 unique winning numbers (comma-separated).  
   - Read a bonus number that must not duplicate any winning number.  
4. **Result Calculation**  
   - Compare each ticket to the winning numbers and bonus.  
   - Determine rank (1st–5th) and tally counts.  
   - Compute total prize and profit rate, formatted to one decimal place.  
5. **I/O Separation**  
   - `InputView` handles all `Console.readLine()` and parsing.  
   - `OutputView` handles formatting and printing to the console.  
6. **Error Handling**  
   - Throw `IllegalArgumentException` on invalid input, print `[ERROR]…` and re-prompt.  
7. **Unit Tests**  
   - JUnit 5 + AssertJ tests for each core class and function.  