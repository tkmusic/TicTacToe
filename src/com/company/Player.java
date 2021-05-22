package com.company;
import java.util.Scanner;

public class Player {
    int number;
    Scanner scanner = new Scanner(System.in);
    public Player(int number){
        this.number = number;
    }
    public int getTurn(){
        System.out.println("Player " + number + " ist dran ");
        int input = scanner.nextInt();
        if(input < 9 && input >= 0){
            return input;
        }
        System.out.println("Ungültige Eingabe, bitte nochmal probieren!");
        return getTurn();
    }
    public boolean validateTurn(int[] board, int turn){
        if(board[turn] == -1){
            return true;
        }
        return false;
    }
}
