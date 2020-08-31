package investment.service

class InvestmentController {
    def index() {

    }

    def show() {
        Investment investment = new Investment(
            downPaymentPercentage: 10,
            estimatedRentalIncomePerMonth: 1000,
            estimatedTaxSavings: 1000,
            interestRate: 3,
            pmiRate: 5,
            propertyPrice: 200000
        )
        [investment: investment]
    }

    def create() {

    }
}
