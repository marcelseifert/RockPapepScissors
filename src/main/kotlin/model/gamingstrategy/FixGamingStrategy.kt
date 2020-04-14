package model.gamingstrategy

import model.PlayElement

object FixGamingStrategy {

    fun buildStrategy(playElement: PlayElement) = { -> playElement }

}