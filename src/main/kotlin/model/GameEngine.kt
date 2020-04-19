package model

object GameEngine {

    fun playIt(rounds: Int, playerOneStrategy: () -> PlayElement, playerTwoStrategy: () -> PlayElement): Summary {
        return createSummary(rounds, playerOneStrategy, playerTwoStrategy, Summary(0, 0, 0))
    }

    private fun createSummary(
        rounds: Int,
        playerOneStrategy: () -> PlayElement,
        playerTwoStrategy: () -> PlayElement,
        acc: Summary
    ): Summary {
        var summary: Summary

        val result = buildGameResult(
            playerOneStrategy.invoke(),
            playerTwoStrategy.invoke()
        )
        when (result) {
            GameResultValues.DRAW -> summary = Summary(acc.playerOneWins, acc.playerTwoTwins, acc.draws + 1)
            GameResultValues.PLAYER_ONE_WINS -> summary = Summary(acc.playerOneWins + 1, acc.playerTwoTwins, acc.draws)
            GameResultValues.PLAYER_TWO_WINS -> summary = Summary(acc.playerOneWins, acc.playerTwoTwins + 1, acc.draws)
        }

        if (rounds > 1) {
            return createSummary(rounds - 1, playerOneStrategy, playerTwoStrategy, summary)
        }
        return summary
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