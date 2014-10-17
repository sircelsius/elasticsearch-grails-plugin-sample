package org.elasticsearch.plugin.sample

class Musician {

    String firstName

    String lastName

    String age

    Location locationBorn

    /**
     * All fields are searchable
     * the locationBorn field is a geoPoint (and therefore MUST be a set as a component)
     */
    static searchable = {
    	locationBorn geoPoint:true, component: true
    }

    static constraints = {
    }
}
