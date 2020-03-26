package model

data class Player(val gamingStrategy: IGamingStrategy, val name: String) {

    private var countWins = 0
    private var countLoses = 0
    private var countDrawns = 0

    fun play(): PlayElement {
        return gamingStrategy.choiceGameElement()
    }

    fun drawn() {
        countDrawns++
    }

    fun lose() {
        countLoses++
    }

    fun win() {
        countWins++
    }

    fun getGameResult(): GameResult {
        return GameResult(countWins, countLoses, countDrawns)
    }
}