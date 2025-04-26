# kotlin-lotto-precourse


## Commit tag
- feat (feature)
- fix (bug fix)
- docs (documentation)
- style (formatting, missing semi colons, …)
- refactor
- test (when adding missing tests)
- chore (maintain)


## input
  - Purchase amount for lottery tickets:
   `14000`
  -  Winning numbers (comma-separated):
  `1,2,3,4,5,6`
  - Bonus number:
  `7`
## output
  - Number of tickets issued and their numbers (sorted in ascending order):
    ```
    You have purchased 8 tickets.
    [8, 21, 23, 41, 42, 43]
    [3, 5, 11, 16, 32, 38]
    [7, 11, 16, 35, 36, 44]
    [1, 8, 11, 31, 41, 42]
    [13, 14, 16, 38, 42, 45]
    [7, 11, 30, 40, 42, 43]
    [2, 13, 22, 32, 38, 45]
    [1, 3, 5, 14, 22, 45]
    
    ````
    - Lotto result statistics:
    ```
    3 Matches (5,000 KRW) – 1 tickets
    4 Matches (50,000 KRW) – 0 tickets
    5 Matches (1,500,000 KRW) – 0 tickets
    5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
    6 Matches (2,000,000,000 KRW) – 0 tickets
    ```
    - Profit rate rounded to the nearest tenth (e.g., 100.0%, 51.5%, 1,000,000.0%):  
    `Total return rate is 62.5%.`
    - Error messages must start with [ERROR]:  
    `[ERROR] Lotto numbers must be between 1 and 45.`

## Check

- [x] You must use the Randoms and Console APIs provided by the camp.nextstep.edu.missionutils
  package.
    - To generate random values, use Randoms.pickUniqueNumbersInRange() from
      camp.nextstep.edu.missionutils.Randoms.
    - To receive user input, use Console.readLine() from camp.nextstep.edu.missionutils.Console.
- [x] Custom Exception (Error)
    - using huge try-catch