package org.elasticsearch.plugin.sample



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MusicianController {

    def musicianService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def musicianList = musicianService.searchMusicianOrderBySongCountMissingLast()

        respond Musician.list(params), model:[musicianInstanceCount: Musician.count()]
    }

    def show(Musician musicianInstance) {
        respond musicianInstance
    }

    def create() {
        respond new Musician(params)
    }

    @Transactional
    def save(Musician musicianInstance) {
        if (musicianInstance == null) {
            notFound()
            return
        }

        if (musicianInstance.hasErrors()) {
            respond musicianInstance.errors, view:'create'
            return
        }

        musicianInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'musician.label', default: 'Musician'), musicianInstance.id])
                redirect musicianInstance
            }
            '*' { respond musicianInstance, [status: CREATED] }
        }
    }

    def edit(Musician musicianInstance) {
        respond musicianInstance
    }

    @Transactional
    def update(Musician musicianInstance) {
        if (musicianInstance == null) {
            notFound()
            return
        }

        if (musicianInstance.hasErrors()) {
            respond musicianInstance.errors, view:'edit'
            return
        }

        musicianInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Musician.label', default: 'Musician'), musicianInstance.id])
                redirect musicianInstance
            }
            '*'{ respond musicianInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Musician musicianInstance) {

        if (musicianInstance == null) {
            notFound()
            return
        }

        musicianInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Musician.label', default: 'Musician'), musicianInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'musician.label', default: 'Musician'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
