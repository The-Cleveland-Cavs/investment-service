package investment.service

class ConfigHelper {
    /**
     * Grails uses a Postgresqsl datasource url scheme like:
     * postgresql://hostname:port/dbname?user=blah&password=blah
     *
     * where Heroku uses:
     *
     * postgres://user:password@hostname:port/dbname
     *
     * This method will convert the Heroku type to Grails.
     *
     * @param dbUrl
     * @return
     */
    static def convertDatabaseUrl(dbUrl) {
        def m = dbUrl =~ /^postgres:\/\/(.*?):(.*?)@(.*?):(\d+)\/(.*?)$/
        if (! m) {
            if (isUrlAlreadyConverted(dbUrl)) {
                return dbUrl
            }
            throw new IllegalArgumentException("Database url '$dbUrl' is not of proper form: postgres://user:password@hostname:port/dbname")
        }

        return "postgresql://" + m[0][3] + ':' +  m[0][4]?.toInteger() + '/' +
                m[0][5] + '?user=' + m[0][1] + '&password=' + m[0][2]
    }


    /**
     * Converts the RedisToGo URL so it can be converted and used in the Grails redis
     * plugin that uses each part of the URL separately
     *
     * @param redisUrl
     * @return
     */
    static def parseRedisUrl(redisUrl) {
        def m = redisUrl =~ /^redis:\/\/(.*?):(.*?)@(.*?):(\d+).*$/
        if (! m) {
            throw new IllegalArgumentException("Redis url '$redisUrl' is not of proper form: redis://user:password@hostname:port")
        }
        return [user: m[0][1], password: m[0][2], host: m[0][3], port: m[0][4]?.toInteger()]
    }


    /**
     * Returns whether the url passed is already in the format we are trying
     * @param url
     * @return
     */
    private static isUrlAlreadyConverted(url) {
        url ==~ /^\w+:\/\/.*?:\d+\/.*?\?user=.*?&password=.*?/
    }

    /**
     * Converts an amqp url
     */
    static def parseRabbitUrl(url) {
        def m = url =~ /^amqp:\/\/(.*):(.*)@(.*)\/(.*)$/

        if (! m) {
            throw new IllegalArgumentException("AMQP URL '$url' is not of proper form: amqp://user:password@hostname")
        }

        return [username: m[0][1], password: m[0][2], hostname: m[0][3], virtualHost: m[0][4]]
    }

    static def parseFTPUrl(url) {
        def m = url =~ /^ftp:\/\/(.*):(.*)@(.*):(\d+).*$/
        if (! m) {
            throw new IllegalArgumentException("FTP Server '$url' is not of proper form ftp://user:password@hostname:port")
        }
        return [username: m[0][1], password: m[0][2], hostname: m[0][3], port: m[0][4]?.toInteger()]
    }

}
