package investment.service

class InvestmentController {
	static responseFormats = ['json', 'xml']
	
    def index() {

    }

    def show() {
        InvestmentSpec spec = new InvestmentSpec(
            downPaymentPercentage: 10,
            estimatedRentalIncomePerMonth: 1000,
            estimatedTaxSavings: 1000,
            interestRate: 3,
            pmiRate: 5,
            propertyPrice: 200000
        )
        [investmentSpec: spec]
    }

    def create() {

    }
}
