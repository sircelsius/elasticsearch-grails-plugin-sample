package org.elasticsearch.plugin.sample

class Song {

		String title

		Date dateWritten

		static belongsTo = [writer: Musician]

		static hasMany = [
			locationPlayed: Location
		]

		/**
		 * All fields are searchable
		 * the writer field is a reference to the parent musician
		 * the locationPlayed field is a geoPoint
		 * the title field is mapped as mutli field in order to 
		 * do an alphabetical sort
		 */
		static searchable = {
			title multi_field:true
			writer parent: true, reference:true
			locationPlayed geoPoint:true, component:true
		}

    static constraints = {
    }
}
