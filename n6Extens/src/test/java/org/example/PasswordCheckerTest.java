package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordCheckerTest {


    @org.junit.jupiter.api.Test
    void verifyPositive() {
        // given:
        PasswordChecker checer = new PasswordChecker();
        checer.setMinLength(10);
        checer.setMaxRepeats(10);
        String password1 = "gjjjjjjjjhj";
        String password2 = "gfjytyjyfgj";
        String password3 = "fgjfgjf*gj";
        // when:
        boolean result1 = PasswordChecker.verify(password1);
        boolean result2 = PasswordChecker.verify(password2);
        boolean result3 = PasswordChecker.verify(password3);
        // then:
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
        Assertions.assertTrue(result3);
    }

    @org.junit.jupiter.api.Test
    void verifyNegative() {
        // given:
        PasswordChecker checer = new PasswordChecker();
        checer.setMinLength(1);
        checer.setMaxRepeats(1);
        String password = "gjjjjjjjjhj";
        // when:
        boolean result = PasswordChecker.verify(password);
        // then:
        Assertions.assertTrue(result);
    }

    @Test
    public void testSetMinLength_ValidValue() {
        PasswordChecker passwordChecker = new PasswordChecker();
        int validMinLength = 5;


        // Устанавливаем допустимое значение
        passwordChecker.setMinLength(validMinLength);

        // Проверяем, что значение установлено правильно
        assertEquals(validMinLength, passwordChecker.getMinLength());
    }

    @Test
    public void testSetMinLength_NegativeValue() {
        PasswordChecker passwordChecker = new PasswordChecker();
        int negativeMinLength = -1;

        // Проверяем, что при установке отрицательного значения выбрасывается исключение
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            passwordChecker.setMinLength(negativeMinLength);
        });

        // Проверяем сообщение исключения
        assertEquals("Значение не может быть отрицательным", thrown.getMessage());
    }

    @Test
    public void testSetMaxRepeats_ValidValue() {
        PasswordChecker passwordChecker = new PasswordChecker();
        int validMinRepeats = 5;

        // Устанавливаем допустимое значение
        passwordChecker.setMaxRepeats(validMinRepeats);

        // Проверяем, что значение установлено правильно
        assertEquals(validMinRepeats, passwordChecker.getMaxRepeats());
    }

    @Test
    public void testSetMaxRepeats_NegativeValue() {
        PasswordChecker passwordChecker = new PasswordChecker();
        int negativeMinRepeats = -1;

        // Проверяем, что при установке отрицательного значения выбрасывается исключение
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            passwordChecker.setMaxRepeats(negativeMinRepeats);
        });

        // Проверяем сообщение исключения
        assertEquals("Значение не может быть отрицательным или 0", thrown.getMessage());
    }

}