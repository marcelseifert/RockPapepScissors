package model.gamingstrategy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RandomGamingStrategyTest {

    private val randomGamingStrategy = RandomGamingStrategy()

    @Test
    fun `when choiceGameElement then any playElement will always be returned`() {
        Assertions.assertTrue(randomGamingStrategy.choiceGameElement() != null)
    }
}