package investment.service

class Investment {

    Integer downPaymentPercentage = 0
    Integer estimatedRentalIncomePerMonth
    Integer estimatedTaxSavings = 0
    Integer interestRate = 0
    Integer pmiRate = 0
    Integer propertyPrice

    InvestmentUser investmentUser

    Date dateCreated
    Date lastUpdated

    static mapping = {
        version false
    }

    static constraints = {
        downPaymentPercentage nullable: true
        estimatedRentalIncomePerMonth nullable: false
        estimatedTaxSavings nullable: true
        interestRate nullable: true
        pmiRate nullable: true
        propertyPrice nullable: false
        investmentUser nullable: true
    }
}
