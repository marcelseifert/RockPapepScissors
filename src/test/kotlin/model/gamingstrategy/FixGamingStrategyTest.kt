package model.gamingstrategy

import model.PlayElement
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FixGamingStrategyTest {

    private val fixGamingStrategy = FixGamingStrategy(PlayElement.ROCK)

    @Test
    fun `when choiceGameElement then Rock will always be returned`() {
        Assertions.assertTrue(fixGamingStrategy.choiceGameElement() == PlayElement.ROCK)
    }
}