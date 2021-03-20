package com.example.drunkcards.sockets

import io.socket.client.Socket
import io.socket.emitter.Emitter
import org.json.JSONObject

class DrunkGameSocketHelper {

    companion object{
        fun createARoom(socket: Socket,roomName:String){
            socket.emit(SocketEvents.createCardOfHumanity,roomName)
        }

        fun roomCreateEvent(socket: Socket,callback:(response:JSONObject)->Unit){
            socket.on(SocketEvents.createdRoom,object:Emitter.Listener{
                override fun call(vararg args: Any?) {
                    val jsonData=args[0] as JSONObject
                    callback(jsonData)
                }
            })
        }
    }
}