package com.anushka.retrofitdemo

import retrofit2.Response
import retrofit2.http.*

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbums(): Response<Albums>

    //Query Parameters
    @GET("/albums")
    suspend fun getSortedAlbums(@Query("userId") userId: Int): Response<AlbumsItem>

    //Path Parameters
    @GET("/albums/{id}")
    suspend fun getAlbum(@Path("id") albumId: Int): Response<AlbumsItem>

    //Post
    @POST("/albums")
    suspend fun uploadAlbum(@Body album: AlbumsItem): Response<AlbumsItem>

}