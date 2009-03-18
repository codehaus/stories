package com.stories

import com.stories.Iteration

class IterationController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ iterationInstanceList: Iteration.list( params ), iterationInstanceTotal: Iteration.count() ]
    }

    def show = {
        def iterationInstance = Iteration.get( params.id )

        if(!iterationInstance) {
            flash.message = "Iteration not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ iterationInstance : iterationInstance ] }
    }

    def delete = {
        def iterationInstance = Iteration.get( params.id )
        if(iterationInstance) {
            try {
                iterationInstance.delete()
                flash.message = "Iteration ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Iteration ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Iteration not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def iterationInstance = Iteration.get( params.id )

        if(!iterationInstance) {
            flash.message = "Iteration not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ iterationInstance : iterationInstance ]
        }
    }

    def update = {
        def iterationInstance = Iteration.get( params.id )
        if(iterationInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(iterationInstance.version > version) {
                    
                    iterationInstance.errors.rejectValue("version", "iteration.optimistic.locking.failure", "Another user has updated this com.stories.Iteration while you were editing.")
                    render(view:'edit',model:[iterationInstance:iterationInstance])
                    return
                }
            }
            iterationInstance.properties = params
            if(!iterationInstance.hasErrors() && iterationInstance.save()) {
                flash.message = "Iteration ${params.id} updated"
                redirect(action:show,id:iterationInstance.id)
            }
            else {
                render(view:'edit',model:[iterationInstance:iterationInstance])
            }
        }
        else {
            flash.message = "Iteration not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def iterationInstance = new Iteration()
        iterationInstance.properties = params
        return ['iterationInstance':iterationInstance]
    }

    def save = {
        def iterationInstance = new Iteration(params)
        if(!iterationInstance.hasErrors() && iterationInstance.save()) {
            flash.message = "Iteration ${iterationInstance.id} created"
            redirect(action:show,id:iterationInstance.id)
        }
        else {
            render(view:'create',model:[iterationInstance:iterationInstance])
        }
    }
}
