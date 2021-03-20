package com.example.drunkcards

import android.app.Application
import com.example.drunkcards.sockets.SocketEvents
import io.socket.client.IO
import io.socket.client.Socket
import io.socket.emitter.Emitter
import org.json.JSONObject
import timber.log.Timber
import java.lang.Exception
import java.net.URISyntaxException

class DrunkApp:Application() {
    private lateinit var socketConnection:Socket

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
        try {
            val options=IO.Options()
            options.port=3000
            //socketConnection=IO.socket("https://caca6d017a8b.ngrok.io",options).connect() // connection with ngrock
            socketConnection=IO.socket("http://192.168.43.220:3000").connect()  //connection to mobile with localhost
        }catch (e: Exception){
            e.printStackTrace()
            Timber.d("Error in socket connection")
        }
    }

    fun getSocketInstance():Socket{
        if(this::socketConnection.isInitialized)
            return socketConnection
        else{
            socketConnection=IO.socket("http://192.168.1.28:3000").connect()
            return socketConnection
        }
    }
}