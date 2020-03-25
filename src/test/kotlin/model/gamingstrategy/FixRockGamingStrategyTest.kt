package model.gamingstrategy

import model.PlayElement
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FixRockGamingStrategyTest {

    private val fixRockGamingStrategy = FixRockGamingStrategy()

    @Test
    fun `when choiceGameElement then Rock will always be returned`() {
        Assertions.assertTrue(fixRockGamingStrategy.choiceGameElement() == PlayElement.ROCK)
    }
}