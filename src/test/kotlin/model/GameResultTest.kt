package model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GameResultTest {

    @Test
    fun `when increase wins and loses on GameResult then rounds should reflects this calls`() {
        val gameResult = GameResult()
        gameResult.increaseDraws()
        gameResult.increaseLoses()
        gameResult.increaseWins()
        Assertions.assertEquals(3, gameResult.getRounds())
    }

    @Test
    fun `when increase wins and loses on GameResult then toString should prints formatted value`() {
        val gameResult = GameResult()
        gameResult.increaseDraws()
        gameResult.increaseLoses()
        gameResult.increaseWins()
        Assertions.assertEquals("Wins: 1 Loses: 1 Draws: 1", gameResult.toString())
    }
}