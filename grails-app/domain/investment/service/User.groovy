package investment.service

class User {

    String email
    String firstName
    String lastName
    String password
    boolean active = true

    static constraints = {
        email nullable: false
        firstName nullable: true
        lastName nullable: true
        password nullable: false
        active nullabe: false
    }
}
