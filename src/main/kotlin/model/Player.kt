package model

data class Player(val gamingStrategy: IGamingStrategy, val name: String) {

    var countWins = 0
    var countLoses = 0
    var countDraws = 0

    fun play(): PlayElement {
        return gamingStrategy.choiceGameElement()
    }

    fun drawn() {
        countDraws++
    }

    fun lose() {
        countLoses++
    }

    fun win() {
        countWins++
    }
}