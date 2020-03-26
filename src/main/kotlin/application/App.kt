package application

import model.Player
import model.gamingstrategy.RandomGamingStrategy
import model.rule.GameEngine

fun main(args: Array<String>) {
    var rounds = 1

    if (args.isEmpty() || args[0].toInt() <= 0) {
        println("start RockPaperScissors with 1 round")
    } else {
        rounds = args[0].toInt()
        println("start RockPaperScissors with ${args[0]} round")
    }

    val playerOne = Player(RandomGamingStrategy(), "PlayerOne")
    val playerTwo = Player(RandomGamingStrategy(), "PlayerOne")

    GameEngine.playIt(rounds, playerOne, playerTwo)

    println("PlayerOne ${playerOne.getGameResult()}")
    println("PlayerTwo ${playerOne.getGameResult()}")
}