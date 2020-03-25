package model.gamingstrategy

import model.IGamingStrategy
import model.PlayElement
import kotlin.random.Random

class RandomGamingStrategy : IGamingStrategy {

    override fun choiceGameElement(): PlayElement {
        return PlayElement.values().elementAt(Random.nextInt(0, PlayElement.values().size))
    }

}