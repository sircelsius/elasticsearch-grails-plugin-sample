package org.elasticsearch.plugin.sample

import grails.transaction.Transactional

@Transactional
class SongService {

	def ElasticSearchService

    def searchSongFuzzyTitle(text) {
    	println("Getting songs with title like '" + text + "'")

    	def songSearch = Song.search([sort: "_score", order: "desc"],
    		{
    			fuzzy_like_this(
					like_text: text,
					fuzziness:0.8
				)
    		}
    	)

    	println("\nSearch results (sorted):\n" + songSearch )

    	def songList = []

    	for(song_id in songSearch.sort) {
        	songList.add(Song.get(song_id.key))
        }

        println("\nSong list (sorted):\n" + songList)

        return songList
    }

    def searchSongFuzzyTitleAnalyzer(text) {
    	println("Getting songs with title like '" + text + "', using the english analyzer")

    	def songSearch = Song.search([sort: "_score", order: "desc"],
    		{
    			fuzzy_like_this(
					like_text: text,
					fuzziness:0.8,
					analyzer: "english"
				)
    		}
    	)

    	println("\nSearch results (sorted):\n" + songSearch )

    	def songList = []

    	for(song_id in songSearch.sort) {
        	songList.add(Song.get(song_id.key))
        }

        println("\nSong list (sorted):\n" + songList)

        return songList
    }
}
