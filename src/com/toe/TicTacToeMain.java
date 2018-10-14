package com.toe;

import java.util.InputMismatchException;
import java.util.Scanner;


public class TicTacToeMain {

    private static final int EMPTY = 0;
    private static final int FIRST_PLAYER = 1;
    private static final int SECOND_PLAYER = 2;
    private static final int TIE = 3;
    public static void main(String[] args) {

        String playerA, playerB;
        Integer turn;
        int[][] gameBoard = new int[3][3];

        System.out.println("Hi welcome to Tic Tac Toe Game !!!");
        System.out.println();
        System.out.print("Please enter the name of Player 1:- ");
        playerA = new Scanner(System.in).next();
        System.out.println("Please enter the name of Player 2:- ");
        playerB = new Scanner(System.in).next();
        System.out.println();

        displayTicTacToeBoard(gameBoard);
        turn = FIRST_PLAYER; // default first player will get turn.
        letsPlayTheGame(playerA, playerB, turn, gameBoard);
    }

    private static void letsPlayTheGame(String playerA, String playerB, Integer turn, int[][] gameBoard) {
        while(true){
            int move;
            getUserInput(playerA, playerB, turn);
            try {
                move = new Scanner(System.in).nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Invalid choice. . . !!");
                continue;
            }
            if(move < 1 || move > 9){
                System.out.println("Invalid choice. . . !!");
            }
            else if(gameBoard[(move-1)/3][(move-1)%3] !=0){
                System.out.println("Already Filled . . . !! ");
            }
            else
            {
                SetValueOnBoardByPosition(gameBoard,move,turn);
                displayTicTacToeBoard(gameBoard);
                if (isEndOfTheGame(playerA, playerB, gameBoard)) break;
                turn = changePlayersTurn(turn);
            }
        }
    }

    private static boolean isEndOfTheGame(String playerA, String playerB, int[][] gameBoard) {
        if (checkFinalResult(gameBoard) != null) {
            if (checkFinalResult(gameBoard).equals(FIRST_PLAYER)) {
                System.out.println(playerA+ ":- "+ " Won the game !!");
                return true;
            } else if (checkFinalResult(gameBoard).equals(SECOND_PLAYER)) {
                System.out.println(playerB +":- "+ " Won the game !!");
                return true;
            } else if (checkFinalResult(gameBoard).equals(TIE)) {
                System.out.println("Opss Its Tie !!");
                return true;
            }
        }
        return false;
    }

    private static Integer changePlayersTurn(Integer turn) {
        switch (turn){
            case FIRST_PLAYER:
                return SECOND_PLAYER;
            case SECOND_PLAYER:
                return FIRST_PLAYER;
        }
        return turn;
    }

    private static void getUserInput(String playerA, String playerB, Integer turn) {
        if(turn.equals(FIRST_PLAYER))
            printUserInput(playerA);
        else
            printUserInput(playerB);
    }

    private static void printUserInput(String playerName) {
        System.out.println(playerName+" Please enter your choice from 1-9.");
    }

    private static Integer checkFinalResult(int[][] gameBoard) {

        if(isHorizontalMatching(gameBoard[0]))
            return gameBoard[0][0];
        else if(isHorizontalMatching(gameBoard[1]))
            return gameBoard[1][0];
        else if(isHorizontalMatching(gameBoard[2]))
            return gameBoard[2][0];
        else if(isFirstVerticalMatching(gameBoard))
            return gameBoard[0][0];
        else if(isSecondVerticalMatching(gameBoard))
            return gameBoard[0][1];
        else if(isThirdVerticalMatching(gameBoard))
            return gameBoard[0][2];
        else if(isLeftToRightDiagonalMatching(gameBoard))
            return gameBoard[0][0];
        else if(isRightToLeftDiagonalMatching(gameBoard))
            return gameBoard[0][0];
        else if(isAllBoxesFilled(gameBoard))
            return TIE;
        return EMPTY;


    }

    private static boolean isAllBoxesFilled(int[][] gameBoard) {
        return gameBoard[0][0] != 0 && gameBoard[0][1] != 0 && gameBoard[0][2] != 0
                && gameBoard[1][0] != 0 && gameBoard[1][1] != 0 && gameBoard[1][2] != 0 &&
                gameBoard[2][0] != 0 && gameBoard[2][1] != 0 && gameBoard[2][2] != 0;
    }

    private static boolean isRightToLeftDiagonalMatching(int[][] gameBoard) {
        return (gameBoard[0][2] == gameBoard[1][1]) && (gameBoard[1][1] == gameBoard[2][0]);
    }

    private static boolean isLeftToRightDiagonalMatching(int[][] gameBoard) {
        return (gameBoard[0][0] == gameBoard[1][1]) && (gameBoard[1][1] == gameBoard[2][2]);
    }

    private static boolean isThirdVerticalMatching(int[][] gameBoard) {
        return (gameBoard[0][2] == gameBoard[1][2]) && (gameBoard[1][2] == gameBoard[2][2]);
    }

    private static boolean isSecondVerticalMatching(int[][] gameBoard) {
        return (gameBoard[0][1] == gameBoard[1][1]) && (gameBoard[1][1] == gameBoard[2][1]);
    }

    private static boolean isFirstVerticalMatching(int[][] gameBoard) {
        return (gameBoard[0][0] == gameBoard[1][0]) && (gameBoard[1][0] == gameBoard[2][0]);
    }

    private static boolean isHorizontalMatching(int[] ints) {
        return (ints[0] == ints[1]) && (ints[1] == ints[2]);
    }

    private static void SetValueOnBoardByPosition(int[][] board, int move, Integer turn) {
        board[(move-1)/3][(move-1)%3] = turn; // find the position based on user input.
    }

    private static void displayTicTacToeBoard(int[][] board) {

        System.out.println("-------------");
        for(int row = 0;row<3;row++){
            for(int col= 0;col<3;col++){
                System.out.print("|");
                System.out.print(printValueAtPosition(board[row][col]));
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }

    private static String printValueAtPosition(int i) {
            switch (i) {
                case FIRST_PLAYER:
                    return " X ";
                case SECOND_PLAYER:
                    return " O ";
                default:
                    return "   ";
            }
    }
}
