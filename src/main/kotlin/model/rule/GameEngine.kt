package model.rule

import model.GameResults
import model.PlayElement
import model.Player

object GameEngine {

    lateinit var gameResults: GameResults

    fun playIt(rounds: Int, playerOne: Player, playerTwo: Player) {
        gameResults = GameResults(playerOne, playerTwo)
        for (i in 1..rounds) {
            verifyResult(playerOne.play(), playerTwo.play())
        }
    }

    private fun verifyResult(playElementFromPlayerOne: PlayElement, playElementFromPlayerTwo: PlayElement) {
        if (playElementFromPlayerOne == playElementFromPlayerTwo) {
            gameResults.allPlayersDraws()
        }
        if (hasPlayerOneWon(playElementFromPlayerOne, playElementFromPlayerTwo)) {
            gameResults.playerOneWins()
        } else {
            gameResults.playerTwoWins()
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