package com.company;

import org.jetbrains.annotations.NotNull;

public class Main {

    public static void main(String[] args) {
        int turn = 0;
        int winner = -1;
        int[] board = new int[9];

        for(int i = 0; i < board.length; i++){
            board[i] = -1;
        }
        Player a = new Player(0);
        Player b = new Player(1);
        Player[] players = new Player[2];
        players[0] = a;
        players[1] = b;

        while(winner == -1){
            printBoard(board);
            int turnField = players[turn].getTurn();
            if(players[turn].validateTurn(board, turnField)){
                board[turnField] = players[turn].number;
                turn = (turn +1) % 2;
            }
            winner = checkWinner(board);
            if(winner != -1){
                System.out.println("Player " + winner + " hat gewonnen!");
            }
        }
        printBoard(board);
    }

    public static int checkWinner(int[] board){
        int winner = -1;
        if(board[0] == board[1] && board[0] == board[2] && board[0] != -1){
            winner = board[0];
        }
        else if(board[3] == board[4] && board[3] == board[5] && board[3] != -1){
            winner = board[3];
        }
        else if(board[6] == board[7] && board[6] == board[8] && board[6] != -1){
            winner = board[6];
        }
        else if(board[0] == board[3] && board[0] == board[6] && board[0] != -1){
            winner = board[0];
        }
        else if(board[1] == board[4] && board[1] == board[7] && board[1] != -1){
            winner = board[1];
        }
        else if(board[2] == board[5] && board[2] == board[8] && board[2] != -1){
            winner = board[2];
        }
        else if(board[0] == board[4] && board[0] == board[8] && board[0] != -1){
            winner = board[0];
        }
        else if(board[2] == board[4] && board[2] == board[6] && board[2] != -1){
            winner = board[2];
        }
        else{
            winner = -1;
        }
        return winner;
    }

    public static void printBoard(int @NotNull [] board){
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }
}
