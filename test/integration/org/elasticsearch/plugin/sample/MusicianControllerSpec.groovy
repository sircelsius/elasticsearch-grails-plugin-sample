package org.elasticsearch.plugin.sample



import spock.lang.*

/**
 *
 */
class MusicianControllerSpec extends Specification {

	MusicianService musicianService

    def setup() {

    }

    def cleanup() {
    }

    void "test that the search method (missing last) renders the correct result after bootstrap"() {
    	def result = musicianService.searchMusicianOrderBySongCountMissingLast()
    	def expected_results = []
    	expected_results.add(Musician.get(1))
    	expected_results.add(Musician.get(5))
    	expected_results.add(Musician.get(2))
    	expected_results.add(Musician.get(4))
    	expected_results.add(Musician.get(3))
    	expected_results.add(Musician.get(6))

    	expect:

    	result == expected_results
    }

    void "test that the search method renders the correct result after bootstrap"() {
    	def result = musicianService.searchMusicianOrderBySongCount()
    	def expected_results = []
    	expected_results.add(Musician.get(1))
    	expected_results.add(Musician.get(5))
    	expected_results.add(Musician.get(2))
    	expected_results.add(Musician.get(4))
    	expected_results.add(Musician.get(3))

    	expect:

    	result == expected_results
    }
}
