package com.toe;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.toe.Board.TIE;
import static com.toe.Player.FIRST_PLAYER;
import static com.toe.Player.SECOND_PLAYER;

public class GameManager {
    Board board;
    public GameManager(Board board) {
        this.board = board;
    }

    public void startGame(Player firstPlayer, Player secondPlayer) {
        boolean isGameNotOver = true;
        int turn = FIRST_PLAYER;

        while(isGameNotOver){
            int move;
            getUserInput(firstPlayer,secondPlayer,turn);
            move = getUserMove();
            if(move < 1 || move > 9){
                System.out.println("Invalid Choice . . !!");
                continue;
            }
            else if(isPlaceAlreadyField(move)){
                System.out.println("Already Filled . . . !! ");
            }
            else{
                putUserMoveOnBoard(board.getBoard(),move,turn);
                board.displayBoard();
                if (isGameOver(firstPlayer, secondPlayer)) {
                    break;
                }
                turn = changePlayersTurn(turn);
            }
        }
    }

    private boolean isGameOver(Player firstPlayer, Player secondPlayer) {
        if(board.checkFinalResult() != null)
        {
            if (board.checkFinalResult().equals(FIRST_PLAYER)) {
                System.out.println(firstPlayer.getName()+ ":- "+ " Won the game !!");
                return true;
            } else if (board.checkFinalResult().equals(SECOND_PLAYER)) {
                System.out.println(secondPlayer.getName() +":- "+ " Won the game !!");
                return true;
            } else if (board.checkFinalResult().equals(TIE)) {
                System.out.println("Opss Its Tie !!");
                return true;
            }
        }
        return false;
    }

    private void putUserMoveOnBoard(int[][] board, int userMove, int turn) {
        board[(userMove-1)/3][(userMove-1)%3] = turn;
    }

    private boolean isPlaceAlreadyField(int move) {
        return board.getBoard()[(move-1)/3][(move-1)%3] !=0;
    }

    private int getUserMove() {
        int move = -1;
        try {
            move = new Scanner(System.in).nextInt();
        }
        catch(InputMismatchException e){
            move = -1;
        }
        return move;
    }

    private void getUserInput(Player firstPlayer, Player secondPlayer, Integer turn) {
        if(turn.equals(FIRST_PLAYER))
            firstPlayer.printUserInput();
        else
            secondPlayer.printUserInput();
    }
    private Integer changePlayersTurn(Integer turn) {
        switch (turn){
            case FIRST_PLAYER:
                return SECOND_PLAYER;
            case SECOND_PLAYER:
                return FIRST_PLAYER;
        }
        return turn;
    }
}
