package com.tic_tac_toe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[] tableline = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        Scanner input = new Scanner(System.in);
        int winner = 0;

        while (winner == 0) {
            game(1, tableline, input);
            winner = winner(tableline);
            if (winner != 0) break;  
            
            game(2, tableline, input);
            winner = winner(tableline);
        }

        System.out.println("Winner: player " + winner);
    }

    public static int winner(char[] tableline) {
        
        for (int i = 0; i < 3; i++) {
            if (tableline[i * 3] == 'X' && tableline[i * 3 + 1] == 'X' && tableline[i * 3 + 2] == 'X') {
                return 2;  
            }
            if (tableline[i * 3] == 'O' && tableline[i * 3 + 1] == 'O' && tableline[i * 3 + 2] == 'O') {
                return 1;  
            }
        }

        
        for (int i = 0; i < 3; i++) {
            if (tableline[i] == 'X' && tableline[i + 3] == 'X' && tableline[i + 6] == 'X') {
                return 2;
            }
            if (tableline[i] == 'O' && tableline[i + 3] == 'O' && tableline[i + 6] == 'O') {
                return 1;
            }
        }

        
        if (tableline[0] == 'X' && tableline[4] == 'X' && tableline[8] == 'X') return 2;
        if (tableline[2] == 'X' && tableline[4] == 'X' && tableline[6] == 'X') return 2;
        if (tableline[0] == 'O' && tableline[4] == 'O' && tableline[8] == 'O') return 1;
        if (tableline[2] == 'O' && tableline[4] == 'O' && tableline[6] == 'O') return 1;

        return 0; 
    }

    public static int inputBox(Scanner input, String msg) {
        System.out.print(msg);
        return input.nextInt();
    }

    public static void game(int player, char[] tableline, Scanner input) {
        char playerchar = (player == 1) ? 'O' : 'X';
        System.out.println("Tic Tac Toe (Player " + player + "):");
        System.out.println("1: [" + tableline[0] + "][" + tableline[1] + "][" + tableline[2] + "]");
        System.out.println("2: [" + tableline[3] + "][" + tableline[4] + "][" + tableline[5] + "]");
        System.out.println("3: [" + tableline[6] + "][" + tableline[7] + "][" + tableline[8] + "]");

        int number = inputBox(input, "Number (from 0 to 8): ");

        while (number < 0 || number > 8 || tableline[number] == 'O' || tableline[number] == 'X') {
            System.out.println("Error, input incorrect");
            number = inputBox(input, "Number (from 0 to 8): ");
        }

        tableline[number] = playerchar;
    }
}
