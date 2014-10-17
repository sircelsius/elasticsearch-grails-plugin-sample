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
		 * the locationPlayed field
		 */
		static searchable = {
			writer parent: true, reference:true
			locationPlayed geoPoint:true, component:true
		}

    static constraints = {
    }
}
