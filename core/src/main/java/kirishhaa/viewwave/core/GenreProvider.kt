package kirishhaa.viewwave.core

object GenreProvider {

    const val ACTION_ID = 28
    const val ADVENTURE_ID = 12
    const val ANIMATION_ID = 16
    const val COMEDY_ID = 35
    const val CRIME_ID = 80
    const val DOCUMENTARY_ID = 99
    const val DRAMA_ID = 18
    const val FAMILY_ID = 10751
    const val FANTASY_ID = 14
    const val HISTORY_ID = 36
    const val HORROR_ID = 27
    const val MUSIC_ID = 10402
    const val MYSTERY_ID = 9648
    const val ROMANCE_ID = 10749
    const val SCIENCE_FICTION_ID = 878
    const val TV_MOVIE_ID = 10770
    const val THRILLER_ID = 53
    const val WAR_ID = 10752
    const val WESTERN_ID = 37

    fun provideGenreById(id: Int): String {
        return when (id) {
            ACTION_ID -> "Action"
            ADVENTURE_ID -> "Adventure"
            ANIMATION_ID -> "Animation"
            COMEDY_ID -> "Comedy"
            CRIME_ID -> "Crime"
            DOCUMENTARY_ID -> "Documentary"
            DRAMA_ID -> "Drama"
            FAMILY_ID -> "Family"
            FANTASY_ID -> "Fantasy"
            HISTORY_ID -> "History"
            HORROR_ID -> "Horror"
            MUSIC_ID -> "Music"
            MYSTERY_ID -> "Mystery"
            ROMANCE_ID -> "Romance"
            SCIENCE_FICTION_ID -> "Science Fiction"
            TV_MOVIE_ID -> "TV Movie"
            THRILLER_ID -> "Thriller"
            WAR_ID -> "War"
            WESTERN_ID -> "Western"
            else -> throw IllegalArgumentException()
        }
    }

}