import investment.service.ConfigHelper
import investment.service.SystemProperty

dataSource {
    pooled = true
    configClass = OverrideGrailsDomainConfiguration

    // By default, use DB Migrations to update DB for all environments
    ssl = true
    logSql = false

    dbCreate = (SystemProperty.getEnvProperty('DB_CREATE')) ?: "none"
    url = "jdbc:" + ConfigHelper.convertDatabaseUrl(
        'postgresql://investment:invest@localhost:5432/investment',
        'investment-service'
    )
}

hibernate {
    dialect = net.kaleidos.hibernate.PostgresqlExtensionsDialect
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory'
    singleSession = true // configure OSIV singleSession mode
}

// environment specific settings
environments {
    development {
        dataSource {
            driverClassName = "org.postgresql.Driver"
            dialect = net.kaleidos.hibernate.PostgresqlExtensionsDialect
            ssl = false
        }
    }

    test {
        dataSource {
            if (SystemProperty.getEnvProperty('INTEGRATION_TEST_ENABLED')) {
                driverClassName = "org.postgresql.Driver"
                dialect = net.kaleidos.hibernate.PostgresqlExtensionsDialect
                username = "investment"
                password = "invest"
                url = "jdbc:postgresql://localhost:5432/investment"
                logSql = true
            } else {
                dbCreate = "update"
                url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            }
        }
    }

    production {
        dataSource {
            driverClassName = "org.postgresql.Driver"
            dialect = net.kaleidos.hibernate.PostgresqlExtensionsDialect
            pooled = true
            ssl=true
            properties {
                maxActive = -1
                minEvictableIdleTimeMillis=1800000
                timeBetweenEvictionRunsMillis=1800000
                numTestsPerEvictionRun=3
                testOnBorrow=false
                testWhileIdle=true
                testOnReturn=true
                validationQuery="SELECT 1"
            }
        }
    }
}

grails.gorm.default.mapping = {
    id generator: 'identity'
}
