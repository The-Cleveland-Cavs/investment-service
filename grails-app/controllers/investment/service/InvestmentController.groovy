package investment.service

import grails.validation.Validateable

class InvestmentController {
    def investmentService


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

    def create(CreateInvestmentCmd cmd) {
        if (! cmd.validate()) {
            throw new Exception("Validation failed while creating investment", cmd.errors.allErrors)
        }
        println('got here')

        Investment investment = investmentService.createInvestment(cmd)
        [investment: investment]
    }
}

class CreateInvestmentCmd implements Validateable {
    Integer downPaymentPercentage = 0
    Integer estimatedRentalIncomePerMonth
    Integer estimatedTaxSavings = 0
    Integer interestRate = 0
    Integer pmiRate = 0
    Integer propertyPrice
    Long userId

    static constraints = {
        downPaymentPercentage nullable: true
        estimatedRentalIncomePerMonth nullable: false
        estimatedTaxSavings nullable: true
        interestRate nullable: true
        pmiRate nullable: true
        propertyPrice nullable: false
        userId nullable: true
    }
}
