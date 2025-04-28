# kotlin-lotto-precourse

## TO-DO Features
	[x] Class InputVIew
		[x] Implement Functions
		[x] Unit Test (Exception)
	
	[x] Class OutputView
		[x] Implement Functions
		[x] Unit Test

	[x] Class Lotto
		[x] Implement Functions
		[x] Unit Test - Using JUnit
	
	[x] Class LottoSimulate
		[x] Implement Functions
		[x] Unit Test

## Structure With PseudoCode

	Class InputView {

		int getPurchaseAmount():
			print (Please enter the purchase amount.)
			return readLine() - only Int, Exception

		List<int> getWinningNumbers():
			print (Please enter last week's winning numbers.)
			List<int> winningNumbers = readLine() - comma sperate, Exception
			return winningNumbers

		int getBonusNumber():
			print (Please enter the bonus number.)
			return readLine() - only Int, Exception
	}

	Class OutputView {

		void displayTickets(lottoList: List<Lotto>):
			print (You have purchased $lottoList.size tickets.)
			for lotto in lottoList:
				lotto.displayNumbers()
		
		void displayWinningStatistics(matched: List<int>, returnRate: Float):
			print (Winning Statistics)
			print (---)
			print (3 Matches (5,000 KRW) – $matched[Matched3] tickets)
			print (4 Matches (50,000 KRW) – $matched[Matched4] tickets)
			print (5 Matches (1,500,000 KRW) – $matched[Matched5] tickets)
			print (5 Matches + Bonus Ball (30,000,000 KRW) – $matched[MatchedBonus] tickets)
			print (6 Matches (2,000,000,000 KRW) – $matched[Matched6] tickets)
			print (Total return rate is $.1freturnRate%.)
	}

	Class Lotto (private val numbers: List<int>) {

		init {
			require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
		}

		void displayNumbers():
			println(numbers)

		int calculatePrize(winningNumbers: List<int>, bonusNumber: int)
			matched: int = numbers.intersect(winningNumbers)
			if matched == 5 && bonusNumber in numbers:
				return MathedBonus
			return matched to Matched?
	}

	Class LottoSimulate() {
		amount: int
		winningNumbers: List<int>
		bonusNumber: int

		lottoCount: int
		lottoList: List<lotto>

		inputView: InputView
		outputView: outputView

		void simulate():
			amount = InputView.getPurchaseMount()

			lottoCount = amount / 1000

			for i in lottoCount:
				lottoList.append(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted)

			outputView.displayTickets(lottoList)

			winningNumbers = InputView.getWinningNumbers()
			bonusNumber = InputView.getBonusNumber()

			matchedNumber: List<int> = countMatched(lottoList, winningNumbers, bonusNumber)
			returnRate: double = calReturnRate(amount, matchedNumber)

			outputView.displayWinningStatistics()

		List<int> countMatched(lottoList: List<int>, winningNumbers: List<int>, bonusNumber: int):
		
		double calReturnRate(amount: int, matchedNumber: List<int>):
			totalPrize: double = 0

			for i in matchedNumber.size():
				totalPrize += matchedNumber[i] * PrizeEnum?

			return amount / totalPrize * 100
	}

	main () {
		var lottoSimulate = LottoSimulate()
		
		lottoSimulate.simulate()
	}