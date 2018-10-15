package com.toe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner readInput = new Scanner(System.in);

        System.out.println("Hi welcome to Tic Tac Toe Game !!!");
        System.out.println();

        System.out.print("Please enter the name of Player 1:- ");
        Player firstPlayer = new Player(readInput.nextLine(),Player.FIRST_PLAYER);

        System.out.print("Please enter the name of Player 1:- ");
        Player secondPlayer = new Player(readInput.nextLine(),Player.SECOND_PLAYER);

        Board board = new Board();
        board.displayBoard();

        GameManager gameManager = new GameManager(board);
        gameManager.startGame(firstPlayer,secondPlayer);
    }
}
