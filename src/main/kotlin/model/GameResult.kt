package model

import java.util.concurrent.atomic.AtomicInteger

class GameResult {
    var wins = AtomicInteger()
    var loses = AtomicInteger()
    var draws = AtomicInteger()

    fun getRounds(): Int {
        return wins.get() + loses.get() + draws.get()
    }

    fun increaseDraws() {
        draws.incrementAndGet()
    }

    fun increaseWins() {
        wins.incrementAndGet()
    }

    fun increaseLoses() {
        loses.incrementAndGet()
    }

    override fun toString(): String {
        return "Wins: ${wins} Loses: ${loses} Draws: ${draws}"
    }
}
