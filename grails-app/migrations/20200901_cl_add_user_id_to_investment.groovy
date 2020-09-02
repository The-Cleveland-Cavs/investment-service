databaseChangeLog = {
    changeSet(author: "spencerpowell", id: "add_user_id_to_investment") {
        addColumn(tableName: "investment") {
            column(name: "investment_user_id", type: "BIGINT")
        }
    }

    changeSet(author: "spencerpowell", id: "add_user_id_to_investment_defaults") {
        addColumn(tableName: "investment_defaults") {
            column(name: "investment_user_id", type: "BIGINT")
        }
    }
}
