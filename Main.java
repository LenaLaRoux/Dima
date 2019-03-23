package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int j, k;                                           // счетчики
        int i = (int) (Math.random() * (words.length - 1)); // три строки являющиеся конструкцией возврата рандомного
        // элемента массива
        String wordToGuess = words[i];
        int wordToGuessLength = wordToGuess.length();

        int maskLength = 15;// присвоение переменной quest рандомного значения массива
        String mask = String.format("%1$"+maskLength+ "s", "").replace(" ","#"); //Дима, это место чисто для размышления,
                                                                            // можно и в цикле заполнять, просто чтобы видел другие варианты
        char[] maskChars = mask.toCharArray();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Угадайте какое слово загадано" + Arrays.toString(words)); // вывод элементов массива words


        String answer;
        do {                                                // этот цикл должен вернуть на ввод слова
            System.out.println("Загаданное слово: " + mask);   // Вывод загаданного слова quest
            System.out.println("Введите слово из перечня");

            answer = scanner.nextLine();                    // ввод строки пользователем

            if (answer.equals(wordToGuess)) {
                break;
            }


            for (j = 0; j < answer.length(); j++) {
                if (wordToGuessLength < j + 1)
                    break;

                if (answer.charAt(j) == wordToGuess.charAt(j)) {
                    maskChars[j] = answer.charAt(j);
                }

            }
            mask = new String(maskChars);

        } while (true);

        System.err.println("Поздравляю, загаданное слово: " + wordToGuess);
    }
}
