package model

import model.gamingstrategy.FixGamingStrategy
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PlayerTest {

    @Test
    fun `when player a fixed gamingstrategy with a gaming strategy then play will return a play element`() {
        val playerOne = Player(FixGamingStrategy(PlayElement.ROCK), "PlayerOne")
        Assertions.assertTrue(playerOne.play() == PlayElement.ROCK)
    }

}