package org.elasticsearch.plugin.sample



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LocationController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Location.list(params), model:[locationInstanceCount: Location.count()]
    }

    def show(Location locationInstance) {
        respond locationInstance
    }

    def create() {
        respond new Location(params)
    }

    @Transactional
    def save(Location locationInstance) {
        if (locationInstance == null) {
            notFound()
            return
        }

        if (locationInstance.hasErrors()) {
            respond locationInstance.errors, view:'create'
            return
        }

        locationInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'location.label', default: 'Location'), locationInstance.id])
                redirect locationInstance
            }
            '*' { respond locationInstance, [status: CREATED] }
        }
    }

    def edit(Location locationInstance) {
        respond locationInstance
    }

    @Transactional
    def update(Location locationInstance) {
        if (locationInstance == null) {
            notFound()
            return
        }

        if (locationInstance.hasErrors()) {
            respond locationInstance.errors, view:'edit'
            return
        }

        locationInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Location.label', default: 'Location'), locationInstance.id])
                redirect locationInstance
            }
            '*'{ respond locationInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Location locationInstance) {

        if (locationInstance == null) {
            notFound()
            return
        }

        locationInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Location.label', default: 'Location'), locationInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'location.label', default: 'Location'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
