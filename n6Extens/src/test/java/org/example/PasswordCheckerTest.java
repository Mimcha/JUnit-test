package org.example;

import org.junit.jupiter.api.Assertions;

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
}