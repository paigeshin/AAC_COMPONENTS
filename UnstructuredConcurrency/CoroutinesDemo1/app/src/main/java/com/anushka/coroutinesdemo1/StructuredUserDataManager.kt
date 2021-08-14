package com.anushka.coroutinesdemo1

import kotlinx.coroutines.*

class StructuredUserDataManager {

    suspend fun getOtalUserCount(): Int {
        var count = 0
        lateinit var deferred: Deferred<Int>

        //if we put every execution code in `coroutineScope`, it will make sure every code will be executed
        coroutineScope {
            launch(Dispatchers.IO) {
                delay(1000)
                count = 50
            }
            deferred = async(Dispatchers.IO) {
                delay(3000)
                return@async 70
            }
        }

        return count + deferred.await() //returns 120,
    }

}