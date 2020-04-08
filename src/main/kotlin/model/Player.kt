package model

import model.gamingstrategy.GamingStrategy

data class Player(val gamingStrategy: GamingStrategy, val name: String) {

    fun play(): PlayElement {
        return gamingStrategy.choiceGameElement()
    }
}