package model.rule

import model.GameResult
import model.PlayElement
import model.gamingstrategy.GamingStrategy

object GameEngine {

    var gameResult = GameResult()

    fun playIt(rounds: Int, playerOneStrategy: GamingStrategy, playerTwoStrategy: GamingStrategy) {
        for (i in 1..rounds) {
            verifyResult(playerOneStrategy.choiceGameElement(), playerTwoStrategy.choiceGameElement())
        }
    }

    private fun verifyResult(playElementFromPlayerOne: PlayElement, playElementFromPlayerTwo: PlayElement) {
        if (playElementFromPlayerOne == playElementFromPlayerTwo) {
            gameResult.drawForPlayerOne()
        }
        if (hasPlayerOneWon(playElementFromPlayerOne, playElementFromPlayerTwo)) {
            gameResult.winForPlayerOne()
        } else {
            gameResult.loseForPlayerOne()
        }
    }

    private fun hasPlayerOneWon(playElementFromPlayerOne: PlayElement, playElementFromPlayerTwo: PlayElement): Boolean =
        when (playElementFromPlayerOne) {
            PlayElement.SCISSORS -> playElementFromPlayerTwo == PlayElement.PAPER || playElementFromPlayerTwo == PlayElement.LIZARD
            PlayElement.ROCK -> playElementFromPlayerTwo == PlayElement.SCISSORS || playElementFromPlayerTwo == PlayElement.LIZARD
            PlayElement.PAPER -> playElementFromPlayerTwo == PlayElement.ROCK || playElementFromPlayerTwo == PlayElement.SPOCK
            PlayElement.LIZARD -> playElementFromPlayerTwo == PlayElement.SPOCK || playElementFromPlayerTwo == PlayElement.PAPER
            PlayElement.SPOCK -> playElementFromPlayerTwo == PlayElement.SCISSORS || playElementFromPlayerTwo == PlayElement.ROCK
        }

}