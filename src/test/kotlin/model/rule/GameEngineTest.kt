package model.rule

import io.mockk.every
import io.mockk.mockkClass
import io.mockk.verify
import model.PlayElement
import model.Player
import org.junit.jupiter.api.Test

class GameEngineTest {


    @Test
    fun `if the game is tied then on all players drawn is called`() {
        //Arrange
        val playerOne = mockkClass(Player::class, relaxed = true)
        val playerTwo = mockkClass(Player::class, relaxed = true)

        every { playerOne.play() } returns PlayElement.PAPER
        every { playerTwo.play() } returns PlayElement.PAPER

        //Act
        GameEngine.playIt(1, playerOne, playerTwo)

        //Assert
        verify { playerOne.drawn() }
        verify { playerTwo.drawn() }
    }

    @Test
    fun `if playerOne wins the game then on playerOne is win called and on playerTwo is lose called`() {
        //Arrange
        val playerOne = mockkClass(Player::class, relaxed = true)
        val playerTwo = mockkClass(Player::class, relaxed = true)

        every { playerOne.play() } returns PlayElement.PAPER
        every { playerTwo.play() } returns PlayElement.ROCK

        //Act
        GameEngine.playIt(1, playerOne, playerTwo)

        //Assert
        verify(exactly = 1) { playerOne.win() }
        verify(exactly = 1) { playerTwo.lose() }
    }

    @Test
    fun `if playerTwo wins the game then on playerOne is lose called and on playerTwo is win called`() {
        //Arrange
        val playerOne = mockkClass(Player::class, relaxed = true)
        val playerTwo = mockkClass(Player::class, relaxed = true)

        every { playerOne.play() } returns PlayElement.SCISSORS
        every { playerTwo.play() } returns PlayElement.ROCK

        //Act
        GameEngine.playIt(1, playerOne, playerTwo)

        //Assert
        verify(exactly = 1) { playerOne.lose() }
        verify(exactly = 1) { playerTwo.win() }
    }
}