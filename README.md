# kotlin-lotto-precourse

### Functional Requirements

#### Input

- [ ] Prompt user to input purchase amount (must be divisible by 1,000).
- [ ] Prompt user to input 6 comma-separated winning numbers.
- [ ] Prompt user to input a single bonus number.
- [ ] If invalid input is given, throw an `IllegalArgumentException` and re-prompt from the same step.

#### Game Rules

- [x] Based on the purchase amount (which must be divisible by 1,000), issue as many lottery tickets as allowed (1
  ticket per 1,000 KRW).
- [x] Each ticket must **contain 6 unique random numbers** in the **range of 1 to 45**.
- [x] Winning numbers and the bonus number must be **in the range of 1 to 45** and **must not be duplicated**.
- [x] Determine the prize rank (1st to 5th) and corresponding reward based on the matching numbers.
- [ ] Compare all user tickets with the winning numbers and print the number of winners per rank, total winnings, and
  profit rate.
- [ ] Only use specific exceptions like `IllegalArgumentException` or `IllegalStateException` (do not use generic
  `Exception`).

##### Extended Rules

- [x] Determine the match count (number of winning numbers matched) for each ticket.
- [x] Map match conditions to prize ranks:

  | Rank   | Condition                                 | Prize Amount      |
    |--------|-------------------------------------------|-------------------|
  | 1st    | Match 6 numbers                           | 2,000,000,000 KRW |
  | 2nd    | Match 5 numbers + Bonus number            | 30,000,000 KRW    |
  | 3rd    | Match 5 numbers                           | 1,500,000 KRW     |
  | 4th    | Match 4 numbers                           | 50,000 KRW        |
  | 5th    | Match 3 numbers                           | 5,000 KRW         |
  | No Win | Does not meet any of the above conditions | -                 |

- [ ] Count the number of winning tickets per prize rank.
- [ ] Calculate the total winnings from all tickets.
- [ ] Calculate the profit rate as `(total winnings / purchase amount) * 100`

#### Output

- [ ] Print the number of tickets purchased and each ticket's numbers **in ascending order.**
- [ ] Print lotto result statistics as shown in the rank table above.
- [ ] Print profit rate rounded to one decimal place (e.g., `62.5%`).
- [ ] All error messages must start with `[ERROR]`.

---

### Programming Requirements

- [ ] Keep each function under 10 lines and ensure it follows the single responsibility principle.
- [ ] Avoid using `else` statements; prefer early return instead.
- [x] Use `Enum` classes where applicable.
- [ ] Clearly separate business logic from UI logic.
    - [ ] Use dedicated classes such as `InputView` and `OutputView` to isolate UI code.
- [ ] Write unit tests for all logic except for UI interactions (`System.out`, `System.in`).
    - [x] If unfamiliar with unit testing, refer to `LottoTest` as an example before writing your own.

---

### Constraints

- [x] You must use the provided `Lotto` class for your implementation.
- [x] Do not add any fields (instance variables) to the `Lotto` class other than `numbers`.
- [x] Do not change the `private` visibility modifier on the `numbers` field.
- [x] Do not change the package of the `Lotto` class.
