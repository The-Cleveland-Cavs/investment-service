package investment.service

class UrlMappings {

    static mappings = {
        "/"(controller: 'application', action:'index')
        post "/investment"(controller: 'investment', action:'create')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
