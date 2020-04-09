package model.rule

import model.PlayElement
import model.gamingstrategy.FixGamingStrategy
import model.gamingstrategy.GamingStrategy
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class GameEngineTest {

    @Test
    fun `if rounds is set to 5 then gameResults should return 5 as well`() {
        GameEngine.playIt(5, FixGamingStrategy(PlayElement.PAPER), FixGamingStrategy(PlayElement.SCISSORS))
        Assertions.assertEquals(5, GameEngine.gameResult.getRounds())
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `if player one should win then player one scores reflect it`(
        playerOne: GamingStrategy,
        playerTwo: GamingStrategy
    ) {
        GameEngine.playIt(1, playerOne, playerTwo)
        Assertions.assertEquals(1, GameEngine.gameResult.winsForPlayerOne)
        Assertions.assertEquals(1, GameEngine.gameResult.losesForPlayerTwo)
        GameEngine.gameResult.reset()
    }

    companion object {
        val strategyPaper = FixGamingStrategy(PlayElement.PAPER)
        val strategyScissors = FixGamingStrategy(PlayElement.SCISSORS)
        val strategyRock = FixGamingStrategy(PlayElement.ROCK)
        val strategySpock = FixGamingStrategy(PlayElement.SPOCK)
        val strategyLizard = FixGamingStrategy(PlayElement.LIZARD)

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