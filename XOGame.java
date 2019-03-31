package com.company;

import java.util.Scanner;

public class XOGame {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        System.out.print("Enter dimension of an array: ");
        int dim = in.nextInt();
        char [][] arr = new char[dim][dim];
        char symb = 'x';

        for (int i =0; i< dim ; i++){
            arr[i][1] = symb;
        }

        if ( checkLines(arr, symb, dim) )
            System.err.println("Line is found");
        else
            System.err.println("Line is not found");
    }

    public static boolean checkLines(char[][] arr, char symb, int dimention) {

        if (checkLeftDiagonal (arr, symb, dimention))
            return true;

        if (checkRightDiagonal(arr, symb, dimention))
            return true;

        int i = 0;

        while ( i < dimention ){   //ищем по левой диагонали

            if (checkVertical(arr, symb, i, dimention))
                return true;

            if (checkHorizontal(arr, symb, i, dimention))
                return true;

            i++;
        }

        return false;
    }

    private  static boolean checkDiagonal (char [][]  arr , char symb, int dimention, int direction){

        int i = 0;
        int n;

        if (direction > 0){
            n = 0;
        }else
            n = dimention - 1;

        while (i < dimention ){
            if (arr[n + i * direction][i] != symb){
                return false;
            }
            i++;
        }
        return true;
    }
    public  static boolean checkLeftDiagonal (char [][]  arr , char symb, int dimention){
        System.out.println("Check left diagonal");
        return checkDiagonal(arr, symb, dimention, 1);
    }

    public  static boolean checkRightDiagonal (char [][]  arr , char symb, int dimention){
        System.out.println("Check right diagonal");
        return checkDiagonal(arr, symb, dimention, -1);
    }

    private static boolean checkLine(char[][] arr, char symb, int positionX,int positionY, int dimention){
        int i = 0;
        while (i < dimention ) {
            if (positionX < 0 && arr[i][positionY] != symb)
                return false;
            if (positionY < 0 && arr[positionX][i] != symb)
                return false;

            i++;
        }
        return true;
    }

    public static boolean checkVertical(char[][] arr, char symb, int positionVert, int dimention){
        System.out.println("Check vertical at "+ "\""+positionVert+"\"");
        return checkLine(arr, symb, -1, positionVert, dimention);
    }

    public static boolean checkHorizontal(char[][] arr, char symb, int positionHoriz, int dimention){
        System.out.println("Check horizontal at "+ "\""+positionHoriz+"\"");
        return checkLine(arr, symb,  positionHoriz, -1, dimention);
    }
}
