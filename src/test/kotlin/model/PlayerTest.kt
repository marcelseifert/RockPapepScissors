package model

import model.gamingstrategy.FixRockGamingStrategy
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PlayerTest {

    @Test
    fun `when player is configured with a gaming strategy then play will return a play element`() {
        val playerOne = Player(FixRockGamingStrategy(), "PlayerOne")
        Assertions.assertTrue(playerOne.play() != null)
    }

    @Test
    fun `when player wins, loses and drawns then getGameResult return expected result`() {
        val playerOne = Player(FixRockGamingStrategy(), "PlayerOne")
        playerOne.lose()
        playerOne.win()
        playerOne.win()
        playerOne.drawn()
        playerOne.drawn()
        playerOne.drawn()
        Assertions.assertEquals(1, playerOne.getGameResult().loses)
        Assertions.assertEquals(2, playerOne.getGameResult().wins)
        Assertions.assertEquals(3, playerOne.getGameResult().drawns)
    }
}