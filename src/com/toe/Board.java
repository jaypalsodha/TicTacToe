package com.toe;

import static com.toe.Player.FIRST_PLAYER;
import static com.toe.Player.SECOND_PLAYER;

public class Board {
    public static final int TIE = 3;
    private static final int EMPTY = 0;
    private static final Integer BOARD_SIZE = 3;
    private int[][] board;

    public Board(int[][] board) {
        this.board = board;
    }
    public void displayBoard(){
        System.out.println("-------------");
        for(int row = 0;row<BOARD_SIZE;row++){
            for(int col= 0;col<BOARD_SIZE;col++){
                System.out.print("|");
                System.out.print(printValueOnBoard(board[row][col]));
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }
    private static String printValueOnBoard(int i) {
        switch (i) {
            case FIRST_PLAYER:
                return " X ";
            case SECOND_PLAYER:
                return " O ";
            default:
                return "   ";
        }
    }
    public void move(Player player,int positionOnBoard){
        board[(positionOnBoard-1)/BOARD_SIZE][(positionOnBoard-1)%BOARD_SIZE] = player.getPlayerType();
    }

    public int[][] getBoard() {
        return board;
    }
    public Integer checkFinalResult() {

        if(isHorizontalMatching(board[0]))
            return board[0][0];
        else if(isHorizontalMatching(board[1]))
            return board[1][0];
        else if(isHorizontalMatching(board[2]))
            return board[2][0];
        else if(isFirstVerticalMatching(board))
            return board[0][0];
        else if(isSecondVerticalMatching(board))
            return board[0][1];
        else if(isThirdVerticalMatching(board))
            return board[0][2];
        else if(isLeftToRightDiagonalMatching(board))
            return board[0][0];
        else if(isRightToLeftDiagonalMatching(board))
            return board[0][0];
        else if(isAllBoxesFilled(board))
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
}
