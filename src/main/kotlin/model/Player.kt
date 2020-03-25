package model

data class Player(val gamingStrategy: IGamingStrategy, val name: String) {

    fun play(): PlayElement {
        return gamingStrategy.choiceGameElement()
    }
}