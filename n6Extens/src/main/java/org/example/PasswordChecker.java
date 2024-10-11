package org.example;

public class PasswordChecker {


    private static int minLength = -1;
    private static int maxRepeats = -1;

    public static int getMinLength() {
        return minLength;
    }

    public static int getMaxRepeats() {
        return maxRepeats;
    }
    public void setMinLength(int minLength) {
        //Если в сеттер передали недопустимое значение (отрицательное число),
        // то должно выкинуться исключение IllegalArgumentException,
        // т. е. исключение недопустимого аргумента, с соответствующим сообщением;
        if (minLength < 0) {
            throw new IllegalArgumentException("Значение не может быть отрицательным");
        }
        this.minLength = minLength;
    }


    public void setMaxRepeats(int maxRepeats) {
        //сли в сеттер передали недопустимое значение (отрицательное число или 0),
        // то должно выкинуться исключение IllegalArgumentException,
        // т. е. исключение недопустимого аргумента, с соответствующим сообщением.
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("Значение не может быть отрицательным или 0");
        }
        this.maxRepeats = maxRepeats;
    }

    public static boolean verify(String password) {
        //который проверяет переданный пароль на эти два критерия.
        // Если пароль проходит, возвращает true, не проходит — false.
        // Если до вызова метода verify хотя бы одна из двух вышеперечисленных
        // настроек не была выставлена чекеру, то в нём кидается исключение IllegalStateException,
        // т. е. исключение недопустимого состояния, с соответствующим сообщением.
        if (minLength == -1 || maxRepeats == -1) {
            throw new IllegalArgumentException("Чекер не настроен");
        }

        if (minLength > password.length()) {
            return false;
        }
        int countMaxRepeats;
        countMaxRepeats = 1;
        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i - 1) == password.charAt(i)) {
                countMaxRepeats++;
            } else {
                countMaxRepeats = 1;
            }
            if (countMaxRepeats > maxRepeats) {
                return false;
            }
        }
        return true;
    }
}
