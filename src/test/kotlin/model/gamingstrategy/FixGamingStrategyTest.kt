package model.gamingstrategy

import model.PlayElement
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FixGamingStrategyTest {

    @Test
    fun `when choiceGameElement then Rock will always be returned`() {
        Assertions.assertTrue(FixGamingStrategy.buildStrategy(PlayElement.ROCK) == PlayElement.ROCK)
    }
}