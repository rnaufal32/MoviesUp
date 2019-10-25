package std.aanrstudio.apps.moviesup.data.source.mock

import std.aanrstudio.apps.moviesup.data.source.model.Movie

object MovieMockData {
    private val title = arrayOf(
        "Alita: Battle Angel",
        "Aquaman",
        "Bohemian Rhapsody",
        "Fantastic Beasts: The Crimes of Grindelwald",
        "Glass",
        "How to Train Your Dragon: The Hidden World",
        "Avengers: Infinity War",
        "Ralph Breaks the Internet",
        "Robin Hood",
        "Spider-Man: Into the Spider-Verse"
    )

    private val overview = arrayOf(
        "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
        "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
        "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
        "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
        "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
        "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
        "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
        "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, \"Sugar Rush.\" In way over their heads, Ralph and Vanellope rely on the citizens of the internet -- the netizens -- to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
        "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
        "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension."
    )

    private val duration = arrayOf(
        "2h 2min",
        "2h 23min",
        "2h 14min",
        "2h 14min ",
        "2h 9min",
        "1h 44min",
        "2h 29min",
        "1h 52min",
        "1h 56min",
        "1h 57min"
    )

    private val poster = arrayOf(
        "/xRWht48C2V8XNfzvPehyClOvDni.jpg",
        "/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
        "/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
        "/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
        "/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
        "/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
        "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
        "/qEnH5meR381iMpmCumAIMswcQw2.jpg",
        "/AiRfixFcfTkNbn2A73qVJPlpkUo.jpg",
        "/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg"
    )

    val mockData: ArrayList<Movie>
        get() {
            val ls = arrayListOf<Movie>()
            for (position in title.indices) {
                val movie = Movie()
                movie.title = title[position]
                movie.overview = overview[position]
                movie.duration = duration[position]
                movie.poster = poster[position]
                ls.add(movie)
            }
            return ls
        }

    fun getData(position: Int): Movie {
        val movie = Movie()
        movie.title = title[position]
        movie.overview = overview[position]
        movie.duration = duration[position]
        movie.poster = poster[position]

        return movie
    }
}