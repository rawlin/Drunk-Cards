package com.example.drunkcards.mockData

import com.example.drunkcards.models.DareTask
import com.example.drunkcards.models.Players
import com.example.drunkcards.models.TaskComment
import com.example.drunkcards.models.TaskReportCard

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

        fun getComments():List<TaskComment>{
            return listOf(
                    TaskComment("t-1","Ajay","id-1","U did that really well, loved it","cid-1"),
                    TaskComment("t-1","Ananya","id-2","Can you teach me that?","cid-3"),
                    TaskComment("t-1","Aman","id-3","Bro you nailed it, just awesome","cid-2")
            )
        }

        fun getReportCardAfterATurn(): TaskReportCard {
            return TaskReportCard(
                    "t-1",
                    "Ajay",
                    3.5f,
                    "Take an embarrassing selfie and post it as your profile picture."
            )
        }
    }
}
