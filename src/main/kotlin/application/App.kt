package application

import model.GameEngine
import model.PlayElement
import model.gamingstrategy.FixGamingStrategy
import model.gamingstrategy.RandomGamingStrategy

fun main(args: Array<String>) {
    var rounds = if (args.isEmpty() || args[0].toInt() <= 0) {
        100
    } else {
        args[0].toInt()
    }
    println(GameEngine.playIt(rounds, RandomGamingStrategy(), FixGamingStrategy(PlayElement.ROCK)))
}