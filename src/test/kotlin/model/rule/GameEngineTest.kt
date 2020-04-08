package model.rule

import model.PlayElement
import model.Player
import model.gamingstrategy.FixGamingStrategy
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class GameEngineTest {

    @Test
    fun `if rounds is set to 5 then gameResults should return 5 as well`() {
        val playerPaper = Player(FixGamingStrategy(PlayElement.PAPER), "PlayerPaper")
        val playerScissors = Player(FixGamingStrategy(PlayElement.SCISSORS), "PlayerScissors")

        GameEngine.playIt(5, playerPaper, playerScissors)
        Assertions.assertEquals(5, GameEngine.gameResults.getRounds())
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `if player one should win then player one scores reflect it`(playerOne: Player, playerTwo: Player) {
        GameEngine.playIt(1, playerOne, playerTwo)
        Assertions.assertEquals(1, GameEngine.gameResults.gameResultPlayerOne.wins.get())
        Assertions.assertEquals(1, GameEngine.gameResults.gameResultPlayerTwo.loses.get())
    }

    companion object {
        val playerPaper = Player(FixGamingStrategy(PlayElement.PAPER), "PlayerPaper")
        val playerScissors = Player(FixGamingStrategy(PlayElement.SCISSORS), "PlayerScissors")
        val playerRock = Player(FixGamingStrategy(PlayElement.ROCK), "PlayerScissors")
        val playerSpock = Player(FixGamingStrategy(PlayElement.SPOCK), "PlayerScissors")
        val playerLizard = Player(FixGamingStrategy(PlayElement.LIZARD), "PlayerScissors")

        @JvmStatic
        fun testData() = listOf(
            Arguments.of(playerPaper, playerRock),
            Arguments.of(playerPaper, playerSpock),
            Arguments.of(playerLizard, playerPaper),
            Arguments.of(playerLizard, playerSpock),
            Arguments.of(playerScissors, playerPaper),
            Arguments.of(playerScissors, playerLizard),
            Arguments.of(playerSpock, playerRock),
            Arguments.of(playerSpock, playerScissors),
            Arguments.of(playerRock, playerLizard),
            Arguments.of(playerRock, playerScissors)
        )
    }
}