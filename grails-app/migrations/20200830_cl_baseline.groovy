databaseChangeLog = {

    changeSet(author: "spencerpowell (generated)", id: "1578509340288-1") {
        createTable(tableName: "investment_user") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "userPK")
            }

            column(name: "email", type: "VARCHAR(64)") {
                constraints(nullable: "false")
            }

            column(name: "firstName", type: "VARCHAR(64)")

            column(name: "lastName", type: "VARCHAR(64)")

            column(name: "active", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "password", type: "VARCHAR(64)") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "timestamp") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "timestamp") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "spencerpowell (generated)", id: "1578509340288-2") {
        createTable(tableName: "investment") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "investmentPK")
            }

            column(name: "down_payment_percentage", type: "INTEGER")

            column(name: "estimated_tax_savings", type: "INTEGER")

            column(name: "interest_rate", type: "INTEGER")

            column(name: "pmi_rate", type: "INTEGER")

            column(name: "estimated_rental_income_per_month", type: "INTEGER") {
                constraints(nullable: "false")
            }

            column(name: "property_price", type: "INTEGER") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "timestamp") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "timestamp") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "spencerpowell (generated)", id: "1578509340288-3") {
        createTable(tableName: "investment_defaults") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "investmentDefaultsPK")
            }

            column(name: "down_payment_percentage", type: "INTEGER")

            column(name: "estimated_tax_savings", type: "INTEGER")

            column(name: "interest_rate", type: "INTEGER")

            column(name: "pmi_rate", type: "INTEGER")

            column(name: "estimated_rental_income_per_month", type: "INTEGER")

            column(name: "property_price", type: "INTEGER")

            column(name: "date_created", type: "timestamp") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "timestamp") {
                constraints(nullable: "false")
            }
        }
    }
}
