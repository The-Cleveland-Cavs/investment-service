package investment.service

import grails.gorm.transactions.Transactional
import grails.validation.ValidationException

@Transactional
class InvestmentService {

    Investment createInvestment(CreateInvestmentCmd cmd) {
        InvestmentUser user
        if (cmd.userId) {
            user = InvestmentUser.get(cmd.userId)
        }

        Investment investment = new Investment(
            downPaymentPercentage: cmd.downPaymentPercentage,
            estimatedRentalIncomePerMonth: cmd.estimatedRentalIncomePerMonth,
            estimatedTaxSavings: cmd.estimatedTaxSavings,
            interestRate: cmd.interestRate,
            pmiRate: cmd.pmiRate,
            propertyPrice: cmd.propertyPrice,
            invesmentUser: user
        )

        try {
            investment.save()
        } catch (ValidationException e) {
            throw new Exception("Validation failed while creating investment", e.errors.allErrors)
        }

        return investment
    }
}
