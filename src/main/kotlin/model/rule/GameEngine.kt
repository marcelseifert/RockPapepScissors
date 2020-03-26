package model.rule

import model.PlayElement
import model.Player

object GameEngine {

    fun playIt(rounds: Int, playerOne: Player, playerTwo: Player) {
        for (i in 0 until rounds) when (verifyResult(playerOne.play(), playerTwo.play())) {
            Result.DRAWN -> {
                playerOne.drawn()
                playerTwo.drawn()
            }
            Result.PLAYERONE_WINS -> {
                playerOne.win()
                playerTwo.lose()
            }
            Result.PLAYERTWO_WINS -> {
                playerOne.lose()
                playerTwo.win()
            }
        }
    }

    private fun verifyResult(playElementFromPlayerOne: PlayElement, playElementFromPlayerTwo: PlayElement): Result {
        if (playElementFromPlayerOne == playElementFromPlayerTwo) {
            return Result.DRAWN
        }
        if ((playElementFromPlayerOne == PlayElement.ROCK && playElementFromPlayerTwo == PlayElement.SCISSORS) ||
            (playElementFromPlayerOne == PlayElement.PAPER && playElementFromPlayerTwo == PlayElement.ROCK) ||
            (playElementFromPlayerOne == PlayElement.SCISSORS && playElementFromPlayerTwo == PlayElement.PAPER)
        ) {
            return Result.PLAYERONE_WINS
        }

        return Result.PLAYERTWO_WINS
    }

    enum class Result {
        PLAYERONE_WINS,
        PLAYERTWO_WINS,
        DRAWN
    }
}