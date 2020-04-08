package model

class GameResults(val playerOne: Player, val playerTwo: Player) {

    var gameResultPlayerOne = GameResult()
    var gameResultPlayerTwo = GameResult()

    fun getRounds(): Int {
        if (gameResultPlayerOne.getRounds() != gameResultPlayerTwo.getRounds()) throw IllegalStateException("should not happen, check rounds for every player goes wrong")
        return gameResultPlayerOne.getRounds()
    }

    fun playerOneWins() {
        gameResultPlayerOne.increaseWins()
        gameResultPlayerTwo.increaseLoses()
    }

    fun playerTwoWins() {
        gameResultPlayerOne.increaseLoses()
        gameResultPlayerTwo.increaseWins()
    }

    fun allPlayersDraws() {
        gameResultPlayerOne.increaseDraws()
        gameResultPlayerTwo.increaseDraws()
    }

    fun printAllGameResults() {
        println("PlayerOne $gameResultPlayerOne")
        println("PlayerTwo $gameResultPlayerTwo")
    }
}
