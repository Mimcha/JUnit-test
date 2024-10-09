package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//В main спросите у пользователя настройки для чекера,
// создайте объект чекера и в бесконечном цикле — до ввода end
// — спрашивайте у пользователя пароли, которые затем проверяйте чекером
// и выводите на экран результат. Если пользователь ввёл недопустимые настройки,
// то программа не должна вылетать с исключением.
// Поймайте его, выведите на экран сообщение об ошибке и завершите программу.
        Scanner scanner = new Scanner(System.in);
        PasswordChecker checer = new PasswordChecker();

        System.out.print("Введите мин. длину пароля: ");

        try {
            int input = Integer.parseInt(scanner.nextLine());//5
            checer.setMinLength(input);

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }


        System.out.print("Введите макс. допустимое количество повторений символа подряд: ");

        try {
            int input = Integer.parseInt(scanner.nextLine());//5
            checer.setMaxRepeats(input);

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        try {
            while (true) {
                System.out.print("Введите пароль или end: ");
                String input = scanner.nextLine();//end

                if ("end".equals(input)) {
                    System.out.println("Программа завершена");
                    break;
                }
                System.out.println(checer.verify(input) ? "Подходит" : "Не подходит");
            }

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

    }
}