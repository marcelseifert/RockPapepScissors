package model.rule

import model.GameEngine
import model.PlayElement
import model.gamingstrategy.FixGamingStrategy
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class GameEngineTest {

    @Test
    fun `if rounds is set to 5 then gameResults should return 5 as well`() {
        val summary =
            GameEngine.playIt(
                5,
                FixGamingStrategy.buildStrategy(PlayElement.PAPER),
                FixGamingStrategy.buildStrategy(PlayElement.SCISSORS)
            )
        Assertions.assertEquals(5, summary.rounds)
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `if player one should win then player one scores reflect it`(
        playerOne: () -> PlayElement,
        playerTwo: () -> PlayElement
    ) {
        val summary = GameEngine.playIt(1, playerOne, playerTwo)
        Assertions.assertEquals(1, summary.playerOneWins)
        Assertions.assertEquals(0, summary.playerTwoTwins)
    }

    companion object {
        val strategyPaper = FixGamingStrategy.buildStrategy(PlayElement.PAPER)
        val strategyScissors = FixGamingStrategy.buildStrategy(PlayElement.SCISSORS)
        val strategyRock = FixGamingStrategy.buildStrategy(PlayElement.ROCK)
        val strategySpock = FixGamingStrategy.buildStrategy(PlayElement.SPOCK)
        val strategyLizard = FixGamingStrategy.buildStrategy(PlayElement.LIZARD)

        @JvmStatic
        fun testData() = listOf(
            Arguments.of(strategyPaper, strategyRock),
            Arguments.of(strategyPaper, strategySpock),
            Arguments.of(strategyLizard, strategyPaper),
            Arguments.of(strategyLizard, strategySpock),
            Arguments.of(strategyScissors, strategyPaper),
            Arguments.of(strategyScissors, strategyLizard),
            Arguments.of(strategySpock, strategyRock),
            Arguments.of(strategySpock, strategyScissors),
            Arguments.of(strategyRock, strategyLizard),
            Arguments.of(strategyRock, strategyScissors)
        )
    }
}