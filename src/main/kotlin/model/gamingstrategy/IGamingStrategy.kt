package model.gamingstrategy

import model.PlayElement

interface IGamingStrategy {

    fun choiceGameElement(): PlayElement
}