package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int number = (int) (Math.random() * 9);
        int attempt = 0;
        boolean isGuessed = false;
        boolean doNotContinue = false;
        int answer;
        Scanner scanner = new Scanner(System.in);

        while (!doNotContinue) {
            for (attempt = 2; attempt >= 0; attempt--) { // сновной цикл с счетчиком попыток, их свего 3

                System.out.print("Угадайте число от 0 до 9: ");

                int userNumber = scanner.nextInt() ; // чтение числа юзера из консоли
                isGuessed = userNumber == number;

                if (isGuessed) { // цикл проверки если юзер угадал число
                    System.out.println("Вы угадали число: " + userNumber);

                } else {
                    if (userNumber > number) { // условие проверки если введеное число больше
                        System.out.println("Выше число больше загаданного.");
                    } else { // условие проверки если введеное число меньше
                        System.out.println("Ваше число меньше загаданного.");
                    }
                }
                
                if (attempt == 0){
                    System.err.println("Игра завершена. Попытки, увы, иcсякли.");
                }
                
                System.out.println("Хотите продолжить? '0' - да, '1' - нет");
                answer = scanner.nextInt();
                doNotContinue = answer == 1;

                if (isGuessed || doNotContinue) {
                    break;
                } else if (attempt != 0){
                    System.out.println("У Вас осталось " + attempt + " попыток.");
                } 
            }
        }
        
        System.out.println("Увидимся позже.");
    }
}
