package investment.service

class InvestmentUser {

    String email
    String firstName
    String lastName
    String password
    boolean active = true

    Date dateCreated
    Date lastUpdated

    static hasMany = [investments: Investment]

    static mapping = {
        version false
    }

    static constraints = {
        email nullable: false
        firstName nullable: true
        lastName nullable: true
        password nullable: false
        active nullabe: false
    }
}
