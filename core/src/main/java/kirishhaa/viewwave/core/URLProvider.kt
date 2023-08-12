package kirishhaa.viewwave.core


object URLProvider {

    object QUERY{
        const val BASE_URL_QUERY = "https://api.themoviedb.org/3/"
        const val ACCEPT = "accept"
        const val TYPE_HEADER = "application/json"
        const val AUTHORIZATION = "Authorization"
        const val HEADER_TOKEN =
            "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyNzVmNzE3NzM0OTlhY2RiZmZiYzU2ZDQ5ODhlMjMwYiIsInN1YiI6IjY0YzRkM2EyZWVjNWI1MDExY2IwMjFiZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.AEfy0L23cFc2vZHrATUBSk0-U35s55eQh6U5jE5OEvo"
        const val DISCOVER_MOVIE = "discover/movie"
        const val GET_MOVIE_BY_DETAIL ="movie/"
    }

    object IMAGES {
        const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/"
        const val POSTER_SIZE_W185 = "w185/"
        const val BACKDROP_SIZE_W300 = "w300/"
    }
}