package model

class GameResult {
    var winsForPlayerOne = 0
    var losesForPlayerOne = 0
    var drawsForPlayerOne = 0

    val winsForPlayerTwo: Int
        get() = losesForPlayerOne
    val losesForPlayerTwo: Int
        get() = winsForPlayerOne
    val drawsForPlayerTwo: Int
        get() = drawsForPlayerOne


    fun getRounds(): Int {
        return winsForPlayerOne + losesForPlayerOne + drawsForPlayerOne
    }

    fun drawForPlayerOne() {
        drawsForPlayerOne++
    }

    fun winForPlayerOne() {
        winsForPlayerOne++
    }

    fun loseForPlayerOne() {
        losesForPlayerOne++
    }

    fun reset() {
        winsForPlayerOne = 0
        losesForPlayerOne = 0
        drawsForPlayerOne = 0
    }

    override fun toString(): String {
        return "PlayerOne Wins: ${winsForPlayerOne} Loses: ${losesForPlayerOne} Draws: ${drawsForPlayerOne}" + System.lineSeparator() +
                "PlayerTwo Wins: ${winsForPlayerTwo} Loses: ${losesForPlayerTwo} Draws: ${drawsForPlayerTwo}"
    }
}
