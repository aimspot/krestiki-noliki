package com.company;

public class DrawBoard {

    static void draw(int[] board) {
        System.out.println("     |     |     ");

        for(int i = 0; i < 9; ++i) {
            if (i != 0) {
                if (i % 3 == 0) {
                    System.out.println();
                    System.out.println("_____|_____|_____");
                    System.out.println("     |     |     ");
                } else {
                    System.out.print("|");
                }
            }

            if (board[i] == 0) {
                System.out.print("  " + i + "  ");
            }

            if (board[i] == 1) {
                System.out.print("  X  ");
            }

            if (board[i] == 2) {
                System.out.print("  O  ");
            }
        }

        System.out.println();
        System.out.println("     |     |     ");
    }

}


