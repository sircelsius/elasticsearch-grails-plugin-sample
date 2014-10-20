package org.elasticsearch.plugin.sample

class Musician {

    String firstName

    String lastName

    String age

    Location locationBorn

    static hasMany = [song: Song]
    /**
     * All fields are searchable
     * the locationBorn field is a geoPoint (and therefore MUST be a set as a component)
     */
    static searchable = {
    	locationBorn geoPoint:true, component: true
    	/**
         * /!\ This is undocumented /!\
         * Apparently, when doing a has_child search on a parent document,
         * the parent must have the child mapped as component:true
         * see https://github.com/noamt/elasticsearch-grails-plugin/issues/61
         */
        song component:true
    }

    static constraints = {
    }
}
