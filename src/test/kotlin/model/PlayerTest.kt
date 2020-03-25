package model

import model.gamingstrategy.FixRockGamingStrategy
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PlayerTest {

    @Test
    fun `when_player_is_configured_with_a_gaming_strategy_then_play_will_return_a_play_element`() {
        val playerOne = Player(FixRockGamingStrategy(), "PlayerOne")
        Assertions.assertTrue(playerOne.play() != null)
    }
}