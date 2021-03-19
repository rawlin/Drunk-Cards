package com.example.drunkcards.mockData

import com.example.drunkcards.models.*
import timber.log.Timber

class MockData {
    companion object {
        fun getMockedUsers(): List<Players> {
            //todo get some random drawables
            return listOf(
                Players(
                    "https://assets.entrepreneur.com/content/3x2/2000/learn-beiber-twitter.jpg",
                    "Justin",
                    "I Love singing and adventure"
                ),
                Players(
                    "https://assets.entrepreneur.com/content/3x2/2000/learn-beiber-twitter.jpg",
                    "Carlos",
                    "I Love dancing and coding"
                ),
                Players(
                    "https://assets.entrepreneur.com/content/3x2/2000/learn-beiber-twitter.jpg",
                    "James",
                    "I Love food"
                )
            )
        }

        fun getFakeTasks(totalTime: Int): List<DareTask> {
            return listOf(
                DareTask(
                    "1",
                    "Go to Himalayas",
                    "There is nothing left in this materialistic world",
                    totalTime
                ),
                DareTask(
                    "2",
                    "Go out at 1:15 AM",
                    "Go and face the ghost and enjoy yourself",
                    totalTime
                ),
                DareTask(
                    "3",
                    "Visit Donald Trump",
                    "Go and consider yourself lucky to have a company of Mr Donald Trump",
                    totalTime
                )
            )
        }

        fun getComments(): List<TaskComment> {
            return listOf(
                TaskComment("t-1", "Ajay", "id-1", "U did that really well, loved it", "cid-1"),
                TaskComment("t-1", "Ananya", "id-2", "Can you teach me that?", "cid-3"),
                TaskComment("t-1", "Aman", "id-3", "Bro you nailed it, just awesome", "cid-2")
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

        fun getResultAfterAMatch(): List<MatchResultForAPlayer> {
            return listOf(
                MatchResultForAPlayer("u-1", "m-1", "Aron", 56),
                MatchResultForAPlayer("u-2", "m-1", "Aman", 23),
                MatchResultForAPlayer("u-3", "m-1", "Aarush", 90),
                MatchResultForAPlayer("u-4", "m-1", "Amit Dubey", 74)
            )
        }

        fun createSchedule(players: List<Players>): List<MatchesModel> {
            val allMatches = mutableListOf<MatchesModel>()
            var index = 0
            var matchId = 1
            for (player: Players in players) {
                for (innerIdx in players.indices) {
                    if (innerIdx > index) {
                        allMatches.add(
                            MatchesModel(
                                "match-" + matchId
                                ,
                                "user-" + (index + 1),
                                "user-" + (innerIdx + 1),
                                players[index].name,
                                players[innerIdx].name
                            )
                        )
                        matchId++
                    }
                }
                index++
            }
            allMatches.shuffle()
            matchId = 1
            for (match: MatchesModel in allMatches) {
                match.matchId = "match-" + matchId.toString()
                matchId++
            }
            return allMatches
        }

        fun getCardsOfHumanity(): List<CardsOFHumanity> {
            return listOf(
                CardsOFHumanity(
                    "c-1", "Why can't I sleep at night?", listOf(
                        "Michelle Obama's arms.",
                        " German dungeon porn.",
                        "  White people.",
                        "Getting so angry that you pop a boner."
                    )
                ),
                CardsOFHumanity(
                    "c-1", "I got 99 problems but ____ ain't one.", listOf(
                        "Michelle Obama's arms.",
                        " German dungeon porn.",
                        " White people.",
                        "Getting so angry that you pop a boner."
                    )
                ),
                CardsOFHumanity(
                    "c-1", "What ended my last relationship?", listOf(
                        "Michelle Obama's arms.",
                        "German dungeon porn.",
                        "Guys who don't call.",
                        "Getting so angry that you pop a boner."
                    )
                ),
                CardsOFHumanity(
                    "c-1", "What did I bring back from Mexico?", listOf(
                        "The Jews",
                        "Christmas",
                        "Hormone injection.",
                        "Getting so angry that you pop a boner."
                    )
                ),
                CardsOFHumanity(
                    "c-1", "What don't you want to find in your Chinese food?", listOf(
                        "Charisma",
                        "Attitude",
                        "A hot mess",
                        "Sarah Palin"
                    )
                ),
            )
        }
    }
}
