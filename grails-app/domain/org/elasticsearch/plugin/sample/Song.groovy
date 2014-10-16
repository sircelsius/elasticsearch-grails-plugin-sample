package org.elasticsearch.plugin.sample

class Song {

		String title

		Musician writer

		static searchable = {
				writer parent: true, reference:true
		}

    static constraints = {
    }
}
