package model.gamingstrategy

import model.PlayElement
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RandomGamingStrategyTest {


    @Test
    fun `when choiceGameElement then any playElement will always be returned`() {
        Assertions.assertTrue(
            PlayElement.values().contains(RandomGamingStrategy.buildStrategy(PlayElement.values()).invoke())
        )
    }
}