package org.elasticsearch.plugin.sample

import grails.transaction.Transactional
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.plugin.sample.Musician

@Transactional
class MusicianService {

	// import the ElasticSearchService provided by the plugin
	def ElasticSearchService

	/**
	 * Search all the Musician instances, order them by the count
	 * of Song objects which are their children
	 * @return a list of Musician Objects sorted by song count
	 */
    def searchMusicianOrderBySongCount() {
    	println("Getting Musicians sorted by Song count")

    	def musicianSearch = Musician.search([sort: "_score", order: "desc"],{
            bool{
                must{
                    has_child(
                        type:"song",
                        score_mode: "sum",
                        query: QueryBuilders.matchAllQuery()
                    )
                }
            }
        })

        println("\nSearch result (sorted):\n" + musicianSearch.sort)
        
        def musicianList = []

        for(musician_id in musicianSearch.sort) {
        	musicianList.add(Musician.get(musician_id.key))
        }

        println("\nMusician list (sorted):\n" + musicianList)

        return musicianList
    }
}
