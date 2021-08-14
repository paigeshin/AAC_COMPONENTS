package com.anushka.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofitService =
            RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)
        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response: Response<Albums> = retrofitService.getAlbums()
            emit(response)
        }
        val pathResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response: Response<AlbumsItem> = retrofitService.getAlbum(3)
            emit(response)
        }
        val queryResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response: Response<AlbumsItem> = retrofitService.getSortedAlbums(3)
            emit(response)
        }
        val postResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response: Response<AlbumsItem> = retrofitService.uploadAlbum(AlbumsItem(300, "hello", 34))
            emit(response)
        }
        responseLiveData.observe(this, Observer {
            val albumList: MutableListIterator<AlbumsItem>? = it.body()?.listIterator()
            albumList?.let {
                while(it.hasNext()) {
                    val albumsItem: AlbumsItem = albumList.next()
                    Log.i("MYTAG", albumsItem.title)
                }
            }
        })
    }
}
