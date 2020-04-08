package model.gamingstrategy

import model.PlayElement

interface GamingStrategy {

    fun choiceGameElement(): PlayElement
}