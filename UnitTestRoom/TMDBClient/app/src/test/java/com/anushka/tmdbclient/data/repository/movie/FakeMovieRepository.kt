package com.anushka.tmdbclient.data.repository.movie

import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.domain.repository.MovieRepository

class FakeMovieRepository: MovieRepository {

    private val movies = mutableListOf<Movie>()

    init {
        movies.add(Movie(1, "overview1", "postPath1", "releaseDate1", "title1"))
        movies.add(Movie(2, "overview1", "postPath1", "releaseDate1", "title1"))
    }

    override suspend fun getMovies(): List<Movie>? {
        return movies
    }

    override suspend fun updateMovies(): List<Movie>? {
        movies.clear()
        movies.add(Movie(3, "overview1", "postPath1", "releaseDate1", "title1"))
        movies.add(Movie(4, "overview1", "postPath1", "releaseDate1", "title1"))
        return movies
    }
}