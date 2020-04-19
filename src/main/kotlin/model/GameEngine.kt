package model

object GameEngine {

    fun playIt(rounds: Int, playerOneStrategy: () -> PlayElement, playerTwoStrategy: () -> PlayElement): Summary {
        return createSummary(rounds, playerOneStrategy, playerTwoStrategy, Summary(0, 0, 0))
    }

    private tailrec fun createSummary(
        rounds: Int,
        playerOneStrategy: () -> PlayElement,
        playerTwoStrategy: () -> PlayElement,
        acc: Summary
    ): Summary {

        val funPlayerOneWins = { -> Summary(acc.playerOneWins + 1, acc.playerTwoTwins, acc.draws, acc.rounds + 1) }
        val funPlayerTwoWins = { -> Summary(acc.playerOneWins, acc.playerTwoTwins + 1, acc.draws, acc.rounds + 1) }
        val funPlayersTie = { -> Summary(acc.playerOneWins, acc.playerTwoTwins, acc.draws + 1, acc.rounds + 1) }

        val summary = buildGameResult(
            playerOneStrategy.invoke(),
            playerTwoStrategy.invoke(),
            funPlayerOneWins,
            funPlayerTwoWins,
            funPlayersTie
        )
        if (rounds > 1) {
            return createSummary(rounds - 1, playerOneStrategy, playerTwoStrategy, summary)
        }

        return summary
    }

    private fun buildGameResult(
        playElementFromPlayerOne: PlayElement,
        playElementFromPlayerTwo: PlayElement,
        funPlayerOneWins: () -> Summary,
        funPlayerTwoWins: () -> Summary,
        funTie: () -> Summary
    ): Summary {
        return when {
            playElementFromPlayerOne == playElementFromPlayerTwo -> {
                funTie.invoke()
            }
            hasPlayerOneWon(playElementFromPlayerOne, playElementFromPlayerTwo) -> {
                funPlayerOneWins.invoke()
            }
            else -> {
                funPlayerTwoWins.invoke()
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