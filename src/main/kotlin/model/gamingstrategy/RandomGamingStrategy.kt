package model.gamingstrategy

import model.PlayElement
import kotlin.random.Random

class RandomGamingStrategy : GamingStrategy {

    override fun choiceGameElement(): PlayElement {
        val playElements = PlayElement.values()
        return playElements.elementAt(Random.nextInt(0, playElements.size))
    }

}