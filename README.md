# kotlin-lotto-precourse


### ✅ Feature Implementation Checklist

#### Input Handling:
- Prompt and validate the purchase amount (must be a **multiple of 1000**).
- Prompt and validate the winning numbers (6 **unique** numbers, 1-45).
- Prompt and validate the bonus number (1-45, not among winning numbers).
- On invalid input, throw **IllegalArgumentException** and retry.

#### Lottery Ticket Generation: 
- Use **Randoms.pickUniqueNumbersInRange(1, 45, 6)** to create tickets.
- Generate **as many** tickets **as allowed** by the purchase amount.
- **Sort** each ticket’s numbers in **ascending order**.

#### Lotto Class Implementation:
- **Validate** Lotto(numbers): must be exactly 6 numbers, each between 1 and 45 and all unique.
- Add a **getter**.
- Add a method **countMatches**(winningNumbers: List<Int>): Int
- Add a method **containsBonus**(bonus: Int): Boolean

#### Prize Matching Logic: 
- Create **enum** class **PrizeRank** with criteria:
- - SIX_MATCH, FIVE_MATCH_BONUS, FIVE_MATCH, etc.
- - A function to determine a ticket’s rank based on matches and bonus.
- Count how many tickets fall into each prize category.

#### Statistics Calculation:
- Track winnings for each rank.
- Calculate total winnings.
- Compute and display profit rate: (total return / purchase amount) * 100.

#### Output Display
- Print all purchased tickets (in ascending order)
- Print each match category with ticket count and prize
- Print total profit rate rounded to one decimal

#### Reminders for myself:
	•	No indentation > 2 levels
	•	No else if early return is possible
	•	All functions under 10 lines
	•	Separate UI and logic