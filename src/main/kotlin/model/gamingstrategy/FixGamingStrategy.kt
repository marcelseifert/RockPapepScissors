package model.gamingstrategy

import model.PlayElement

class FixGamingStrategy(val playElement: PlayElement) : IGamingStrategy {

    override fun choiceGameElement(): PlayElement = playElement

}