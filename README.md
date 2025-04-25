## Lotto Game – Feature Breakdown

This project implements a simple lottery game as part of the Hero Tech Course pre-course assignment.  
Below is a breakdown of the core features I plan to build and the key behaviors the program will support.

---

### User Input
- Prompt the user to enter a purchase amount (must be divisible by 1,000).
- Accept 6 unique winning numbers (comma-separated), all within the range 1 to 45.
- Accept 1 bonus number, also between 1 and 45.
- All inputs should be validated, and invalid entries should result in an `IllegalArgumentException`.

---

### Ticket Generation
- Generate one lottery ticket per 1,000 KRW of the purchase amount.
- Each ticket consists of 6 unique random numbers between 1 and 45.
- Numbers will be sorted in ascending order for readability.

---

### Result Evaluation
- Compare each ticket against the winning numbers.
- Identify how many numbers match, and whether the bonus number is also matched.
- Determine the result rank (from 1st to 5th prize) based on the match count and bonus number condition.

---

### Output
- Display all purchased tickets in sorted format.
- Summarize how many tickets matched each rank.
- Calculate and print the total return rate as a percentage, rounded to the nearest tenth.

---

### Implementation Notes
- Follow Kotlin coding conventions throughout the project.
- Limit function length and nesting to maintain readability.
- Use enums to represent prize ranks.
- Keep UI (input/output) logic separated from business logic using `InputView` and `OutputView`.
- Write unit tests for all business logic using JUnit 5 and AssertJ.

---