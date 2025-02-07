package investment.service

class InvestmentDefaults {

    Integer downPaymentPercentage
    Integer estimatedRentalIncomePerMonth
    Integer estimatedTaxSavings
    Integer interestRate
    Integer pmiRate
    Integer propertyPrice

    Date dateCreated
    Date lastUpdated

    static belongsTo = [investmentUser: InvestmentUser]

    static mapping = {
        version false
    }

    static constraints = {
        downPaymentPercentage nullable: true
        estimatedRentalIncomePerMonth nullable: true
        estimatedTaxSavings nullable: true
        interestRate nullable: true
        pmiRate nullable: true
        propertyPrice nullable: true
        investmentUser nullable: true
    }
}
