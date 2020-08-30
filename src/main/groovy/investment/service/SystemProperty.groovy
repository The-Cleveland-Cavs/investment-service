package investment.service

class SystemProperty {

    static def getEnvProperty(name) {
        return System.env[name] ?: System.getProperty(name)
    }
}
