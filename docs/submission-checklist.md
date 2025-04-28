# ✅ Submission Checklist

## 1. Process Requirements
- [x] Forked and cloned the repository.
- [x] Wrote a clear and structured README.md.
- [x] Created and maintained a Feature List.
- [x] Used AngularJS style for Git commit messages (e.g., `feat:`, `fix:`).
- [x] Only Kotlin `.kt` source files are tracked — no unnecessary files included.

## 2. Functional Requirements
- [x] Input and validate purchase amount (`InputValidator`, `PurchaseAmount`).
- [x] Generate Lotto tickets with 6 unique numbers (`GenerateLottos`, `Lotto`).
- [x] Input and validate winning numbers (`WinningNumbers`).
- [x] Input and validate bonus number (`BonusNumber`).
- [x] Match Lotto tickets with winning numbers and determine ranks (`matchLottos`, `Rank`, `MatchResult`).
- [x] Calculate and round the profit rate properly (`MatchResult`).
- [x] All error messages consistently start with `[ERROR]`.
- [x] Correctly display winning statistics and profit rate (`OutputView`).

## 3. Programming Requirements
- [x] Implemented entirely in Kotlin 1.9.24.
- [x] No Java code is used.
- [x] The entry point is the `main()` function in `Application.kt`.
- [x] No use of `System.exit()` or `exitProcess()`.
- [x] Maintained the original package structure under `lotto/`.
- [x] View components (`InputView`, `OutputView`) are excluded from unit tests, following the guidelines.
- [x] Service and Domain layers are fully covered by unit tests.

## 4. Code Style and Structure
- [x] Followed Kotlin coding conventions (naming, spacing, formatting).
- [x] Each function is under 10 lines and handles only one responsibility.
- [x] Maximum of 2 levels of indentation (early return preferred).
- [x] Meaningful names for classes, methods, and variables.
- [x] All magic numbers and strings are declared as constants.
- [x] Consistent use of spaces for indentation (no mixing tabs and spaces).
- [x] No unnecessary comments — code itself is self-explanatory.

## 5. Testing
- [x] Thorough unit tests for all logic in Domain and Service layers.
- [x] UI interaction components (View layer) are not unit tested (correct per rules).
- [x] All tests pass successfully (`./gradlew clean test` results in BUILD SUCCESSFUL).

## 6. Additional Final Checks
- [x] No `.idea/`, `build/`, or compiled `.class` files are tracked by Git.
- [x] No debugging `print()` statements left in the code.
- [x] Code properly formatted using IDE auto-formatting (Ctrl+Alt+L or ⌥⌘L).

---

# 🧩 Component patterm (MVC + Service Layer)

## View (InputView, OutputView)
- [x] Handles only input and output.
- [x] No business logic implemented.

## Controller (LottoController)
- [x] Orchestrates the flow by coordinating Views, Services, and Domains.
- [x] Does not perform any calculations directly.

## Domain Models (e.g., Lotto, PurchaseAmount, WinningNumbers)
- [x] Designed to be immutable after creation.
- [x] All validation happens during initialization.
- [x] No setter methods or mutable states.

## Testing Strategy
- [x] Unit tests thoroughly cover Domain and Service layers (TDD approach).
- [x] View and Controller components are intentionally excluded from unit tests as per guidelines.

---

# 🚀 Final Steps Before Submission
- [x] Run `./gradlew clean test` and confirm **BUILD SUCCESSFUL**.
- [x] Final review of `README.md` (includes project description and feature list).
- [x] Push all changes to GitHub repository.
- [x] Submit the GitHub repository link via the Application Platform.

---