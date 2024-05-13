package hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DivDoubleTests extends TestCalculator {

    // Тесты на корректность операции деления
    @ParameterizedTest
    @CsvSource({
            "10.0, 100.0, 10.0",
            "-4.5, 13.5, -3.0",
            "0.0, 0.0, 5.0",
            "Infinity, 1.0, 0.0"
    })
    void testGeneralCorrectness(double expected, double a, double b) {
        assertEquals(expected, calc.div(a, b), 0.0001);
    }

    // Тесты на деление на ноль
    @ParameterizedTest
    @CsvSource({
            "Infinity, 1.0, 0.0",
            "-Infinity, -1.0, 0.0",
            "NaN, 0.0, 0.0"
    })
    void testDivisionByZero(double expected, double a, double b) {
        assertEquals(expected, calc.div(a, b), 0.0);
    }

    // Тесты на деление числа самого на себя
    @ParameterizedTest
    @CsvSource({
            "1.0, 100.0, 100.0",
            "-1.0, -10.0, 10.0"
    })
    void testDivisionByItself(double expected, double a, double b) {
        assertEquals(expected, calc.div(a, b), 0.0001);
    }
}
