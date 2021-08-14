package com.anushka.coroutinesdemo1

import kotlinx.coroutines.*

class UnstructuredUserDataManager {

    suspend fun getTotalUserCount(): Int {
        var count = 0

        //This CoroutineScope is executed immediately
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            count = 50 //Therefore, count won't be set to 50
        }

        //This CoroutineScope returns 70 and wait for 3 seconds
        val deffered = CoroutineScope(Dispatchers.IO).async {
            delay(3000)
            return@async 70
        }
        return count + deffered.await() //This will return 70
        // count will be 0
        // deffered.await() will be 70
    }

}