package org.elasticsearch.plugin.sample

/**
 * Implements the GeoPoint feature of the Elasticsearch plugin
 * see http://noamt.github.io/elasticsearch-grails-plugin/guide/mapping.html#geoPoint
 */
class Location {

	/**
	 *  The geoPoint must have ONLY two fields indexed: lat and lon
	 */
	Double lat

	Double lon

	/**
	 * The geoPoint domain needs to have the root parameter
	 * set to false
	 */
	static searchable = {
		root false
	}

    static constraints = {
    }
}
