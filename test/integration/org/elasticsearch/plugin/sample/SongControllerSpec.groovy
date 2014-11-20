package org.elasticsearch.plugin.sample



import spock.lang.*

/**
 *
 */
class SongControllerSpec extends Specification {

	SongService songService

    def setup() {
        
    }

    def cleanup() {
    }

    void "test that the fuzzy title search method renders the correct result after bootstrap"() {
    	def result = songService.searchSongFuzzyTitle("All Alog the Watchtower")

    	def expected_results = []

    	// without specifying an analyzer,
    	// the search gets songs that contain
    	// unwanted words like 'the'
    	expected_results.add(Song.get(1))
    	expected_results.add(Song.get(4))
    	expected_results.add(Song.get(3))
        expected_results.add(Song.get(9))

    	expect:

    	result == expected_results
    }

    void "test that the fuzzy title search method with english analyzer returns the correct result after bootstrap"() {
    	def result = songService.searchSongFuzzyTitleAnalyzer("All Alog the Watchtower")

    	def expected_results = []

    	// with an anylzer, stop words like
    	// 'the' are ignored
    	expected_results.add(Song.get(1))

    	expect:

    	result == expected_results
    }
}
