package model.gamingstrategy

import model.PlayElement

class FixGamingStrategy(val playElement: PlayElement) : GamingStrategy {

    override fun choiceGameElement(): PlayElement = playElement

}