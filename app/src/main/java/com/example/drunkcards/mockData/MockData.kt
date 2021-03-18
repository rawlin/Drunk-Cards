package com.example.drunkcards.mockData

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
    }
}
