package com.example.drunkcards.mockData

import com.example.drunkcards.models.DareTask
import com.example.drunkcards.models.Players

class MockData{
    companion object{
        fun getMockedUsers():List<Players>{
            //todo get some random drawables
            return listOf(
                Players("https://assets.entrepreneur.com/content/3x2/2000/learn-beiber-twitter.jpg","Justin","I Love singing and adventure"),
                Players("https://assets.entrepreneur.com/content/3x2/2000/learn-beiber-twitter.jpg","Carlos","I Love dancing and coding"),
                Players("https://assets.entrepreneur.com/content/3x2/2000/learn-beiber-twitter.jpg","James","I Love food")
            )
        }

        fun getFakeTasks(totalTime:Int):List<DareTask>{
            return listOf(
                DareTask("1","Go to Himalayas","There is nothing left in this materialistic world",totalTime),
                DareTask("2","Go out at 1:15 AM","Go and face the ghost and enjoy yourself",totalTime),
                DareTask("3","Visit Donald Trump","Go and consider yourself lucky to have a company of Mr Donald Trump",totalTime)
            )
        }
    }
}
