import org.elasticsearch.plugin.sample.*

class BootStrap {

    def init = { servletContext ->
      def parent1 = new Musician(firstName: 'Jim', lastName: 'Morrison', age:42)
      parent1.save()
      def parent2 = new Musician(firstName: 'Jimmy', lastName: 'Hendrix', age:40)
      parent2.save()
      def parent3 = new Musician(firstName: 'Lou', lastName: 'Reed', age:51)
      parent3.save()
      def parent4 = new Musician(firstName: 'Jimmy', lastName: 'Page', age:57)
      parent4.save()
      def parent5 = new Musician(firstName: 'David', lastName: 'Gilmour', age:63)
      parent5.save()
      def song1 = new Song(title: "All Along the Watchtower", writer: parent2)
      song1.save()
      def song2 = new Song(title: "Hey Joe", writer: parent2)
      song2.save()
      def song3 = new Song(title: "Riders on the storm", writer: parent1)
      song3.save()
      def song4 = new Song(title: "The end", writer: parent1)
      song4.save()
      def song5 = new Song(title: "People Are Strange", writer: parent1)
      song5.save()
      def song6 = new Song(title: "Sweet Jane", writer: parent3)
      song6.save()
      def song7 = new Song(title: "Stairway to Heaven", writer: parent4)
      song7.save()
      def song8 = new Song(title: "Comfortably Numb", writer: parent5)
      song8.save()
      def song9 = new Song(title: "Another Brick in the Wall", writer: parent5)
      song9.save()
    }
    def destroy = {
    }
}
