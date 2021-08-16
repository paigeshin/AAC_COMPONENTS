package com.anushka.tmdbclient.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.anushka.tmdbclient.data.model.movie.Movie
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: MovieDao
    private lateinit var database: TMDBDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()
        dao = database.movieDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveMoviesTest() = runBlocking {
        val movies = listOf(
            Movie(1, "overview1", "poasterPath1", "date1", "title1"),
            Movie(2, "overview1", "poasterPath1", "date1", "title1"),
            Movie(3, "overview1", "poasterPath1", "date1", "title1")
        )
        dao.saveMovies(movies)
        val allMovies = dao.getMovies()
//        Assert.assertEquals("com.anushka.tmdbclient", appContext.packageName)
        Assert.assertEquals(movies, allMovies)
    }

    @Test
    fun deleteMoviesTest() = runBlocking {
        val movies = listOf(
            Movie(1, "overview1", "poasterPath1", "date1", "title1"),
            Movie(2, "overview1", "poasterPath1", "date1", "title1"),
            Movie(3, "overview1", "poasterPath1", "date1", "title1")
        )
        dao.saveMovies(movies)
        dao.deleteAllMovies()
        val moviesResult = dao.getMovies()
        Assert.assertEquals(0, moviesResult.size)
    }

}