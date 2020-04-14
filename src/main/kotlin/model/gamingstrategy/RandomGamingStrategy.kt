package model.gamingstrategy

import model.PlayElement
import kotlin.random.Random

object RandomGamingStrategy {

    fun buildStrategy(playElements: Array<PlayElement>) = { ->
        playElements.elementAt(Random.nextInt(0, playElements.size))
    }

}