package model.gamingstrategy

import model.IGamingStrategy
import model.PlayElement

class FixRockGamingStrategy : IGamingStrategy {

    override fun choiceGameElement(): PlayElement = PlayElement.ROCK

}