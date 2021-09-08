package com.company;

import java.lang.reflect.ParameterizedType;
import java.util.Scanner;

public class Controller {

    static int[] board = new int[]{0, 0, 0,
                                    0, 0, 0,
                                    0, 0, 0};


    static void Game(){
        boolean isCurrentX = false;

        Scanner in = new Scanner(System.in);
        System.out.print("Input first player name: ");
        Players first_player = new Players(in.nextLine());

        System.out.print("\nInput second player name: ");
        Players second_player = new Players(in.nextLine());
        System.out.print("\n");
        System.out.print("Starting game.....\n");

        DrawBoard db = new DrawBoard();

        boolean b;
        do {
            isCurrentX = !isCurrentX; //смена ходов
            db.draw(board);
            System.out.println((isCurrentX ? first_player.name : second_player.name)+ " turn");
            int n = getNumber();
            board[n] = isCurrentX ? 1 : 2;
            b = !isGameOver(n);
        } while(b);

        db.draw(board);
        System.out.println();
        System.out.println("The winner is " + (isCurrentX ? first_player.name : second_player.name) + "!");
    }

    static int getNumber() {
        Scanner reader = new Scanner(System.in); //считываем
        while(true) {
            while(true) {
                try {
                    int n = Integer.parseInt(reader.nextLine()); // переводим в инт
                    if (n >= 0 && n < board.length && board[n] == 0) { //если n>0 и меньше длинны доски и ячейка не занята
                        return n;
                    }
                    else {
                        System.out.println("Choose free cell");
                    }
                } catch (NumberFormatException var2) {
                    System.out.println("Please enter the number");
                }
            }
        }
    }

    //проверка выйграшных комбинаций
    static boolean isGameOver(int n) {

        int row = n - n % 3;

        if (board[row] == board[row + 1] && board[row] == board[row + 2]) { //если собралась линия горизонтальная
            return true;
        } else {
            int column = n % 3;
            if (board[column] == board[column + 3] && board[column] == board[column + 6]) { // если собралась линия вертикальная
                return true;
            } else if (n % 2 != 0) {//значит не может собраться выйграшная комбинация
                return false;
            } else {
                if (n % 4 == 0) {
                    if (board[0] == board[4] && board[0] == board[8]) { // главная диагональ
                        return true;
                    }

                    if (n != 4) { //значит не может собраться выйграшная комбинация
                        return false;
                    }
                }

                return board[2] == board[4] && board[2] == board[6]; //побочная диагональ
            }
        }
    }




}
