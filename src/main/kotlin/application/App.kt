package application

import model.PlayElement
import model.Player
import model.gamingstrategy.FixGamingStrategy
import model.gamingstrategy.RandomGamingStrategy
import model.rule.GameEngine

fun main(args: Array<String>) {
    var rounds = 100

    if (args.isEmpty() || args[0].toInt() <= 0) {
        println("start RockPaperScissors with 100 rounds")
    } else {
        rounds = args[0].toInt()
        println("start RockPaperScissors with ${args[0]} round(s)")
    }

    val playerOne = Player(RandomGamingStrategy(), "PlayerOne")
    val playerTwo = Player(FixGamingStrategy(PlayElement.ROCK), "PlayerTwo")

    GameEngine.playIt(rounds, playerOne, playerTwo)
    GameEngine.gameResults.printAllGameResults()

}