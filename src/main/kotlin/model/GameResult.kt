package model

class GameResult(val wins: Int, val loses: Int, val drawns: Int) {
    override fun toString(): String {
        return "GameResult(wins=$wins, loses=$loses, drawns=$drawns)"
    }
}
