package com.tic_tac_toe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[] tableline = {' ',' ',' ',' ',' ',' ',' ',' ',' '};
        Scanner input = new Scanner(System.in);
        boolean winnerbool = false;
        while(!winnerbool) { 
            game(1, tableline, input);
            game(2, tableline, input);
            }
        }

        public static int inputBox(Scanner input, String msg) {
            System.out.print(msg);
            int num = input.nextInt();
            return num;
        }

        public static void game(int player, char[] tableline, Scanner input) {
            char playerchar = (player == 1)?'O':'X';
            System.out.println("Tic Tac Toe (Player 1): \n1: "+"["+tableline[0]+"]"+"["+tableline[1]+"]"+"["+tableline[2]+"]"+"\n"+
            "2: "+"["+tableline[3]+"]"+"["+tableline[4]+"]"+"["+tableline[5]+"]"+"\n"+
            "3: "+"["+tableline[6]+"]"+"["+tableline[7]+"]"+"["+tableline[8]+"]"+"\n");
            int number = inputBox(input, "number (from 0 to 8 in line): "); 

            while( number < 0 && number > 8 || tableline[number] == 'O' || tableline[number] == 'X') {
                System.out.println("error, input incorrect");
                number = inputBox(input, "number (from 0 to 8 in line): "); 
            } 
            tableline[number] = playerchar;

            
        }
}