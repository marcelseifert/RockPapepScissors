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
            .groupingBy { it }.eachCount().map { (key, value) ->
                when (key) {
                    GameResultValues.DRAW -> Summary(0, 0, value)
                    GameResultValues.PLAYER_ONE_WINS -> Summary(value, 0, 0)
                    GameResultValues.PLAYER_TWO_WINS -> Summary(0, value, 0)
                }
            }.fold(Summary(0, 0, 0)) { summary, element ->
                Summary(
                    summary.playerOneWins + element.playerOneWins,
                    summary.playerTwoTwins + element.playerTwoTwins,
                    summary.draws + element.draws
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