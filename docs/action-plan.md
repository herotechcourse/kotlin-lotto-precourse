# Action plan
## Step 1. Project setting & Documentation
- Analyze the overall specification and break down the project into key tasks.
- Create a list of features in `docs/feature-list.md`.
- Set up project structure based on MVC(S). (Controller, Domain, Service, View)

---

## Step 2. FDD (Feature-Driven Development)
- Design classes and Methods based on feature units.
   - Example features:
      - Validate Purchase Amount
      - Validate Winning Numbers and Bonus Number
      - Generate Lottos
      - Match Lottos with Winning Numbers
      - Calculate MatchResult and ProfitRate
- Implemented prototypes for each feature without tests initially.

---

## Step 3. TDD (Test_Driven Development)
- Write unit tests before implementing code.
  - `Red → Green → Refactor` cycle for each feature.
- Frameworks: JUnit5, AssertJ
- Examples:
   - Validate correct numbers from lotto
   - Validate bonus number is not duplicated
- Gradually refactored based on test feedback.

---

## Step 4. DDD & MVC pattern for separation of responsibilities
- - Applied Domain-Driven Design (DDD) principles
- Separated responsibilities following MVC pattern:
   - Controller: Handles application main flow
     - `LottoController`
   - View: User interaction layer -> input/output
     - `InputView`, `InputValidator`, `OutputView`
   - Service: Procedural tasks
     - `GenerateLottos`, `MatchLottos`
   - Domain: Business logic
     - `PurchaseAmount`, `WinningNumbers`
     - `BonuseNumber`, `Rank`, `MatchResult`

---

## Step 5. Test using Gradle
- Test whole project using Gradle
- Confirmed all tests passed with BUILD SUCCESSFUL.
- Ensured clean build and test environment.

---

## Step 6. Cleanup & Documentation
- Refactored code for better readability and maintainability.
- Structured final project hierarchy.
- Updated all docs
  - `README, project-guidelines, functional-requirements`
  - `execution-flow documents, action-plan, feature-list`

---

