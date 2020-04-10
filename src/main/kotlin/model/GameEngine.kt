package model

import model.gamingstrategy.GamingStrategy

object GameEngine {

    fun playIt(rounds: Int, playerOneStrategy: GamingStrategy, playerTwoStrategy: GamingStrategy): Summary =
        (1..rounds)
            .map {
                buildGameResult(
                    playerOneStrategy.choiceGameElement(),
                    playerTwoStrategy.choiceGameElement()
                )
            }
            .groupBy { it }.values
            .fold(initial = Summary(0, 0, 0)) { gameResult, element ->
                val sumPlayerOneWins = if (element.contains(GameResultValues.PLAYER_ONE_WINS)) element.size else 0
                val sumPlayerTwoWins = if (element.contains(GameResultValues.PLAYER_TWO_WINS)) element.size else 0
                val sumDraws = if (element.contains(GameResultValues.DRAW)) element.size else 0
                Summary(
                    gameResult.playerOneWins + sumPlayerOneWins,
                    gameResult.playerTwoTwins + sumPlayerTwoWins,
                    gameResult.draws + sumDraws
                )
            }

    private fun buildGameResult(
        playElementFromPlayerOne: PlayElement,
        playElementFromPlayerTwo: PlayElement
    ): GameResultValues {
        return when {
            playElementFromPlayerOne == playElementFromPlayerTwo -> {
                GameResultValues.DRAW
            }
            hasPlayerOneWon(playElementFromPlayerOne, playElementFromPlayerTwo) -> {
                GameResultValues.PLAYER_ONE_WINS
            }
            else -> {
                GameResultValues.PLAYER_TWO_WINS
            }
        }
    }

    private fun hasPlayerOneWon(playElementFromPlayerOne: PlayElement, playElementFromPlayerTwo: PlayElement): Boolean =
        when {
            playElementFromPlayerOne == PlayElement.SCISSORS -> playElementFromPlayerTwo == PlayElement.PAPER || playElementFromPlayerTwo == PlayElement.LIZARD
            playElementFromPlayerOne == PlayElement.ROCK -> playElementFromPlayerTwo == PlayElement.SCISSORS || playElementFromPlayerTwo == PlayElement.LIZARD
            playElementFromPlayerOne == PlayElement.PAPER -> playElementFromPlayerTwo == PlayElement.ROCK || playElementFromPlayerTwo == PlayElement.SPOCK
            playElementFromPlayerOne == PlayElement.LIZARD -> playElementFromPlayerTwo == PlayElement.SPOCK || playElementFromPlayerTwo == PlayElement.PAPER
            playElementFromPlayerOne == PlayElement.SPOCK -> playElementFromPlayerTwo == PlayElement.SCISSORS || playElementFromPlayerTwo == PlayElement.ROCK
            else -> throw IllegalStateException("could not detect who has won ${playElementFromPlayerOne} ${playElementFromPlayerTwo}")
        }

}