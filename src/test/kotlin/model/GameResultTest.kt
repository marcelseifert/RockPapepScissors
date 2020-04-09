package model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GameResultTest {

    @Test
    fun `when increase wins and loses on GameResult then rounds should reflects this calls`() {
        val gameResult = GameResult()
        gameResult.winForPlayerOne()
        gameResult.loseForPlayerOne()
        gameResult.drawForPlayerOne()
        Assertions.assertEquals(3, gameResult.getRounds())
    }

    @Test
    fun `when player one wins then player two lost`() {
        val gameResult = GameResult()
        gameResult.winForPlayerOne()
        Assertions.assertEquals(1, gameResult.winsForPlayerOne)
        Assertions.assertEquals(0, gameResult.winsForPlayerTwo)
        Assertions.assertEquals(0, gameResult.losesForPlayerOne)
        Assertions.assertEquals(1, gameResult.losesForPlayerTwo)
    }

    @Test
    fun `when player one lost then player two wins`() {
        val gameResult = GameResult()
        gameResult.loseForPlayerOne()
        Assertions.assertEquals(0, gameResult.winsForPlayerOne)
        Assertions.assertEquals(1, gameResult.winsForPlayerTwo)
        Assertions.assertEquals(1, gameResult.losesForPlayerOne)
        Assertions.assertEquals(0, gameResult.losesForPlayerTwo)
    }

    @Test
    fun `when increase wins, draws loses on GameResult then toString should prints formatted value`() {
        val gameResult = GameResult()
        gameResult.winForPlayerOne()
        gameResult.winForPlayerOne()
        gameResult.winForPlayerOne()
        gameResult.loseForPlayerOne()
        gameResult.loseForPlayerOne()
        gameResult.drawForPlayerOne()
        gameResult.drawForPlayerOne()
        Assertions.assertEquals(
            "PlayerOne Wins: 3 Loses: 2 Draws: 2" + System.lineSeparator() + "PlayerTwo Wins: 2 Loses: 3 Draws: 2",
            gameResult.toString()
        )
    }
}