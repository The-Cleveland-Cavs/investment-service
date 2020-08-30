grails.cors.enabled = true
grails.databinding.dateFormats = ["yyyy-MM-dd'T'HH:mm:ss'Z'"]
grails.plugin.databasemigration.updateOnStart = (getEnvProperty('MIGRATE_DB')?.toLowerCase() == 'true')
grails.plugin.databasemigration.updateOnStartFileName = 'changelog.groovy'

grails.gorm.default.mapping = {
    cache true
    version false
}

def getEnvProperty(name) {
    return System.env[name] ?: System.getProperty(name)
}
