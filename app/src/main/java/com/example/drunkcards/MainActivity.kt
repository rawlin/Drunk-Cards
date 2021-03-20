package com.example.drunkcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.drunkcards.sockets.SocketEvents
import io.socket.client.Socket
import io.socket.emitter.Emitter
import org.json.JSONObject
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    lateinit var socketConnection: Socket

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        socketConnection=(application as DrunkApp).getSocketInstance()
        /*socketConnection.on(SocketEvents.connectionMsg,object : Emitter.Listener{
            override fun call(vararg args: Any?) {
                val jsonData=args[0] as JSONObject
                Timber.d("data from socket on connection $jsonData")
            }
        })*/

        Timber.d("socket connection is : ${socketConnection.connected()}")
        socketConnection.on(SocketEvents.connectionMsg,object :Emitter.Listener{
            override fun call(vararg args: Any?) {
                val jsonData=args[0] as JSONObject
                Timber.d("data from socket on connection $jsonData")
            }
        })
        socketConnection.emit(SocketEvents.sendMessage,"Hi I am android client")
    }
}